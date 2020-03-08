line_cnt=`wc -l course.txt | cut -f 1 -d ' '`
rm out.csv
touch out.csv
echo "$line_cnt"
header="Student_ID"
for (( i=1; i<="$line_cnt"; i++ ))
do
	sub=`more course.txt | sort | head -"$i" | tail -1`
#	more "$sub"
	header="$header","$sub"	
	sub_line=`more "$sub" | wc -l | cut -f 1 -d ' '`
	subtxt="$sub"".txt"
	sub_line=`more "$subtxt" | wc -l | cut -f 1 -d ' '`
	for (( j=1; j<="$sub_line"; j++ ))
	do 
#		echo $j
#		head -"$i" "$subtxt" | tail -1 | cut -f 1 -d ' '	
		st_id=`head -"$j" "$subtxt" | tail -1 | cut -f 1 -d ' '`
		marks=`head -"$j" "$subtxt" | tail -1 | cut -f 2 -d ' '`
#		echo i : "$st_id" m : "$marks"
		touch "$st_id"
		echo "$sub" "$marks" >> "$st_id" 
	done
done

echo "$header","Tot","Avg","Grade" >> out.csv
for ff in *
do
	first=`echo $ff | cut -c 1`
	if [ "$first" = 1 ]; then
#		echo "$ff"
		to_csv="$ff"
		line=`wc -l "$ff" | cut -f 1 -d ' '`
		sum=0
		for (( i=1; i<="$line"; i++ ))
		do
			number=`more "$ff" | head -"$i" | tail -1 | cut -f 2 -d ' '`
			to_csv="$to_csv","$number"
			sum=`expr $sum + $number`
		done
		avg=`expr $sum / $line_cnt`
		
		if [ "$avg" -ge "80" ];then
			grade=A
		elif [ "$avg" -ge "60" ]; then
			grade=B  	
		elif [ "$avg" -ge "40" ]; then
			grade=C  
		elif [ "$avg" -lt "40" ]; then
			grade=F  		
		fi
		
		to_csv="$to_csv","$sum","$avg","$grade"
		echo $to_csv >> out.csv
		rm "$ff"
	fi
done


