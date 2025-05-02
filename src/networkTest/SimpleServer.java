package networkTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer{
    public static void main(String[] args) {
    	int port = 10001;
    	
    	try {
    		ServerSocket serverSC = new ServerSocket(port);
    		System.out.println("서버 준비 완료. 연결 대기 중..");
    		
    		Socket sc = serverSC.accept();
    		
    	} catch (IOException e) {
    		e.getStackTrace();
    	}
    }
}