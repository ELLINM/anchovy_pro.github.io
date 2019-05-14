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
			
			ServerRvc rvc = new ServerRvc(dis);
			//rvc.run(); 으로  작동 불가능
			rvc.start();
			
			while(true) {
			
				System.out.println("내용 입력 : ");
				dos.writeUTF(sc.nextLine());
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


//ServerRvc
package Server;

import java.io.DataInputStream;

public class ServerRvc extends Thread{

	private  DataInputStream dis;
	
	public ServerRvc(DataInputStream dis) {
		this.dis = dis;
	}
	
	@Override
	public void run() { //동시진행을 도와주는 method
		
		while(true) {
			try {
				String message = dis.readUTF();
				System.out.println("Client : " + message);
			}catch (Exception e) {
				e.printStackTrace();
			}
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
			
			ClientRvc crvc = new ClientRvc(dis);
			crvc.start();
			
			while(true) {
				
				System.out.println("내용 입력 : ");
				dos.writeUTF(sc.nextLine());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
}


//ClientRvc
package Client;

import java.io.DataInputStream;

public class ClientRvc extends Thread{
private  DataInputStream dis;
	
	public ClientRvc(DataInputStream dis) {
		this.dis = dis;
	}
	
	@Override
	public void run() { //동시진행을 도와주는 method
		
		while(true) {
			try {
				String message = dis.readUTF();
				System.out.println("Server : " + message);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

