//Server

package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(8989);
			//앞번호는 선점 되어있는 경우가 많기 때문에 8000대 후반으로 작성한다.
			System.out.println("접속 대기...");
			
			Socket soc = ss.accept();
			//접속을 기다리는 중
			
			System.out.println("접속 성공");
			
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			// Client의 data를 받아쥼
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());			
			// Client로 data를 보냄
			Scanner sc = new Scanner(System.in);
			
			
			while(true) {
				String message = dis.readUTF();
				//data가 오지않으면 기다림
				System.out.println("클라이언트 : " + message);
			
				System.out.println("내용 입력 : ");
				dos.writeUTF(sc.nextLine());
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


//Client

package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Socket soc = new Socket("203.233.196.213",8989);
			System.out.println("접속성공");
			
			DataInputStream dis = new DataInputStream(soc.getInputStream());
			// Server의 data를 받아쥼
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());			
			//Server로 data를 보냄
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("내용 입력 : ");
				dos.writeUTF(sc.nextLine());
				
				String message = dis.readUTF();
				//data가 오지않으면 기다림
				System.out.println("서버 : " + message);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
