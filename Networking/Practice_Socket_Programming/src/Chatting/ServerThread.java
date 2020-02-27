package Chatting;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    Socket socket;
    static ArrayList<SocketDetails> socketList = new ArrayList<>(100);
    SocketDetails socketDetails;
    ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        socketDetails = new SocketDetails(socket);
        socketList.add(socketDetails);
    }

    public void run() {
        try {
            ObjectInputStream in = null;
            for(SocketDetails socketDetails : socketList){
                if(socketDetails.getSocket().getPort() == socket.getPort()){
                    in = socketDetails.getObjectInputStream();
                }
            }

            while(true) {
                String msg = (String) in.readObject();
                System.out.println(msg);

                for(SocketDetails socketDetails : socketList){
                    if(socketDetails.getSocket().getPort() != this.socket.getPort()){
//                        ObjectOutputStream out2 = new ObjectOutputStream(socket.getOutputStream());
//                        out2.writeObject(msg);
//                        System.out.println("hoom dhukse");
//                        InputStream is = socket.getInputStream();
//                        OutputStream os = socket.getOutputStream();
//                        os.write(msg.getBytes());
//                        System.out.println("kaj korar kotha");

                        socketDetails.getObjectOutputStream().writeObject(msg);

                        break;
                    }
                }

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
