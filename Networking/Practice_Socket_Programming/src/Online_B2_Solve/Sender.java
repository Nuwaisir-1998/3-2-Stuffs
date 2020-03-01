package Online_B2_Solve;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 6667);

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        out.writeObject("sender connected");
        while(true){
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            out.writeObject(msg);
            System.out.println((String)in.readObject());
        }
    }
}
