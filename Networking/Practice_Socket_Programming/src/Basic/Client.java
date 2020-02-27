package Basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6667);
        System.out.println("Client : Local port : " + socket.getLocalPort());
        System.out.println("Client : Connection established.");
        System.out.println("Client : Remote Port : " + socket.getPort());

        // sending byte data to server
//        byte[] str = new byte[1024];
//        String s = "string fsf ef efwf f grg  grg";
//        str = s.getBytes();
//        OutputStream os = socket.getOutputStream();
//        os.write(str);

        // sending object
//        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//        oos.writeObject("object string.");

    }
}
