package Basic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket welcomeSocket = new ServerSocket(6667);
        int clientCount = 0;
        while(true) {
            System.out.println("Server : Waiting for connection...");
            Socket socket = welcomeSocket.accept();
            System.out.println("Server : Connection established with client.");
            System.out.println("Server : Remote port : " + socket.getPort());
            System.out.println("Server : Local Port : " + socket.getLocalPort());

            //server reading byte data from client
//            InputStream is = socket.getInputStream();
//            byte [] b = new byte[1024];
//            b = is.readAllBytes();
//            String str = new String(b);
//            System.out.println(str);

            // receiving object
//            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//            String s = (String)ois.readObject();
//            System.out.println(s);
        }
    }
}
