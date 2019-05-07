package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileInputStream fis = new FileInputStream("C:/test/text.txt");
			// 파일 경로를 적어 줘야함
			// 자바는 파일이 실제 존재하는지 안하는지 모름 때문에 try~catch로 구문을 묶어 줘야함
			/*int a = fis.read();
			
			System.out.println((char)a);
			 int로 출력하면 97이 나옴 char로 출력하면 a text에 적은 abcdefg중 a만 출력
			?가 나오거나 -1이 나오면 없다는것을 표현*/
			
			int a = 0;
			
			while (a != -1) { //-1은 해당 파일에 엔터로 띄어쓰기를 하면 ?를 출력한다
				//abcdefg? 가 아니라 abcdefg enter ?로 출력
				a = fis.read();
				if (a != -1) {
				System.out.print((char)a);
				}
			}
			
			FileOutputStream fos = new FileOutputStream("C:/test/text.txt");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			
			for (int i = 0; i < str.length(); i++) {
				fos.write(str.charAt(i));
			}
			
			FileInputStream fis = new FileInputStream("C:/test/text.txt");
			InputStreamReader isr = new InputStreamReader(fis,"MS949");
			//메모장은 MS949 한글도 출력할 수 있음
			int a = 0;
			
			while (a != -1) {
				a = isr.read();
				if(a != -1)
				System.out.print((char)a);
			}
			
			FileOutputStream fis = new FileOutputStream("C:/test/text.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fis,"MS949");
			System.out.println("입력 : ");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			
			osw.write(str);
			osw.flush(); //write를 끝내주는 시점 입력이 끝남을 알려줌
			
			fos.close(); //close시켜 주지 않은면 계속해서 메모리 누수가 일어난다.
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//파일이 존재하지 않을때 OutputStream은 파일을 생성해서 입력하지만 InputStream은 입력자체가안된다.
