package Basic;

import java.io.IOException;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6667);
        System.out.println("Client2 : Connection established.");
    }
}
