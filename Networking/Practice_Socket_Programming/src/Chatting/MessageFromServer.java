package Chatting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageFromServer extends Thread{
    static ArrayList<SocketDetails> socketList = new ArrayList<>(100);
    SocketDetails socketDetails;
    MessageFromServer(SocketDetails socketDetails){
        this.socketDetails = socketDetails;
        socketList.add(socketDetails);
    }

    public void run(){
        System.out.println("Reached...");
        Scanner sc = new Scanner(System.in);
        String str;
        while(true){
            str = sc.nextLine();
            System.out.println("Server: " + str);
            for(SocketDetails socketDetails : socketList){
                try {
                    socketDetails.getObjectOutputStream().writeObject("Server: " + str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
