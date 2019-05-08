package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjecTest {
	
	public static void main(String[] args) throws Exception{
		
		File file = new File("C:/test/Object.txt");
		//경로에 있는 파일을 불러옴
		
		if (file.exists()) { //boolean type return
		//경로에 파일이 있으면 true 없으면 false를 return함

			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// 접근해야하는 매개변수 생성자를 작성해 줘야함
			
			String str = "I am your father";
			
			oos.writeObject(str);
			
			oos.flush();
			System.out.println("완료");
		}
	}
}
// 순서 filestream -> objectstream -> 생성하고자 하는 객체 -> writeobject
// print : ы t I am your father
