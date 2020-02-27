package Threading;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Worker extends Thread{
    Socket socket;
    Worker(Socket socket){
        this.socket = socket;
    }
    public void run(){
//        Scanner sc = new Scanner(System.in);
        try {
            ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());
            while (true)
            {
                System.out.println("Sent");
                Thread.sleep(1000);
                Date date = new Date();
                out.writeObject(date.toString());

//                String str = sc.nextLine();
//                out.writeObject(str);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
