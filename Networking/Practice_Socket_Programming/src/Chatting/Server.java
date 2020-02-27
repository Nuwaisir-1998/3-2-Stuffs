package Chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6667);
        while(true){
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Connection established.");
            System.out.println("Remote port : " + socket.getPort());

            Thread connection = new ServerThread(socket);
            connection.start();
        }
    }
}
