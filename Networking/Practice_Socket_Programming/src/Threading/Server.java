package Threading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket welcomeSocket = new ServerSocket(6667);
        while(true){
            System.out.println("Waiting for connection...");
            Socket socket = welcomeSocket.accept();
            System.out.println("Connection established.");
            System.out.println("Remote Port : " + socket.getPort());
            Thread worker = new Worker(socket);
            worker.start();
        }
    }
}
