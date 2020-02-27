package Chatting;

import java.io.*;
import java.net.Socket;

public class ClientsListener extends Thread{
    Socket socket;
    ClientsListener(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            //ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//            InputStream is = socket.getInputStream();
//            OutputStream os = socket.getOutputStream();
//            byte[] b = new byte[1024];
//            b = is.readAllBytes();
//            String s = new String(b);
//            System.out.println(s);
            while(true) {
                System.out.println((String) in.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
