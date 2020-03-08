lines=`more places.txt | wc -l`
rm myout
touch myout
for (( i=1; i<="$lines"; i++ ))
do
	name=`head -"$i" places.txt | tail -1`
	cnt=`more visited.csv | grep "$name" | wc -l`
	echo "$name" "$cnt" >> myout
done
append=`more myout | rev | sort | cut -f 1 -d ' ' --complement | rev | head -1`
echo "$append" is the most suitable place to visit. >> myout




