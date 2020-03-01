package Online_B2_Solve;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(6667);
        while(true){
            try {
                System.out.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
                SocketInfo socketInfo = new SocketInfo(socket);

                String type = (String) socketInfo.getIn().readObject();
                System.out.println(type);
                if (type.equalsIgnoreCase("Sender Connected")) {
                    socketInfo.setName("sender");
                } else socketInfo.setName("listener");

                Thread serversThread = new ServersThread(socketInfo);
                serversThread.start();
            }catch (Exception r){
                r.printStackTrace();
            }
        }
    }
}
