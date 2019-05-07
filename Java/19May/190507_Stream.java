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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
