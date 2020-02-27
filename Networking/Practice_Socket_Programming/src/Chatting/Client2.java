package Chatting;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6667);
        System.out.println("Connection established.");
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        //ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in);

        Thread listen = new ClientsListener(socket);
        listen.start();

        while(true) {
            String msg = sc.nextLine();
            out.writeObject("Client2: " + msg);
            System.out.println("Me : " + msg);
        }

    }
}
