package networkTest;

import java.io.IOException;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        String ip_address = "127.0.0.1";
        int port = 10001;
        
        try {
        	Socket sc = new Socket(ip_address, port);
        	
        	
        } catch (IOException e) {
        	e.getStackTrace();
        }
    }
}