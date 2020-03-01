package Online_B2_Solve;

import Chatting.ServerThread;

import java.io.IOException;
import java.util.ArrayList;

public class ServersThread extends Thread {
    static ArrayList<SocketInfo> socketList = new ArrayList<>(100);
    SocketInfo socketInfo;
    ServersThread(SocketInfo socketInfo){
        this.socketInfo = socketInfo;
        ServersThread.socketList.add(socketInfo);
//        System.out.println(socketInfo.getName() + " added. names:");
//        for(SocketInfo socketInfo1 : ServersThread.socketList){
//            System.out.println(socketInfo1.getName());
//        }
    }

    public void run(){
        while(true){
            try {
                String str = (String)socketInfo.getIn().readObject();
                System.out.println(str);
                boolean flag = false;
                for(SocketInfo socketInfo : ServersThread.socketList){
                    //System.out.println(socketInfo.getName());
                    if(socketInfo.getName().equalsIgnoreCase("listener")){
                        socketInfo.getOut().writeObject(str);
                        flag = true;
                    }
                }
                if(!flag){
                    for(SocketInfo socketInfo : ServersThread.socketList){
                        if(socketInfo.getName().equalsIgnoreCase("sender")){
                            socketInfo.getOut().writeObject("0");
                        }
                    }
                }else{
                    for(SocketInfo socketInfo : ServersThread.socketList){
                        if(socketInfo.getName().equalsIgnoreCase("sender")){
                            socketInfo.getOut().writeObject("1");
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                ServersThread.socketList.removeIf(socketInfo -> socketInfo.getName().equalsIgnoreCase("listener"));
            }
        }
    }
}
