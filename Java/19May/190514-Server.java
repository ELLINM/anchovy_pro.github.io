//Server

package Server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(8989);
			//앞번호는 선점 되어있는 경우가 많기 때문에 8000대 후반으로 작성한다.
			
			Socket soc = ss.accept();
			//접속을 기다리는 중
			
			System.out.println("접속 성공");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}


//Client

package Client;

import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Socket soc = new Socket("localhost",8989);
			System.out.println("접속성공");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
