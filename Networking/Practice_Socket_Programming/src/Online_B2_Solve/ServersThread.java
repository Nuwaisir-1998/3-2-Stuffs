package Online_B2_Solve;

import java.io.IOException;
import java.util.ArrayList;

public class ServersThread extends Thread {
    static ArrayList<SocketInfo> socketList = new ArrayList<>(10);
    SocketInfo socketInfo;
    ServersThread(SocketInfo socketInfo){
        this.socketInfo = socketInfo;
        socketList.add(socketInfo);
    }

    public void run(){
        while(true){
            try {
                String str = (String)socketInfo.getIn().readObject();
                System.out.println(str);
                boolean flag = false;
                for(SocketInfo socketInfo : socketList){
                    if(socketInfo.getName().equalsIgnoreCase("listener")){
                        socketInfo.getOut().writeObject(str);
                        flag = true;
                    }
                }
                if(!flag){
                    for(SocketInfo socketInfo : socketList){
                        if(socketInfo.getName().equalsIgnoreCase("sender")){
                            socketInfo.getOut().writeObject("0");
                        }
                    }
                }else{
                    for(SocketInfo socketInfo : socketList){
                        if(socketInfo.getName().equalsIgnoreCase("sender")){
                            socketInfo.getOut().writeObject("1");
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
