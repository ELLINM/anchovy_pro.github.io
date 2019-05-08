//Writer

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
// print : ы t I am your father : String으로 입력해서 보이는것 정상


//Reader

package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjecTest {
	
	public static void main(String[] args) throws Exception{
		
		File file = new File("C:/test/Object.txt");
		//경로에 있는 파일을 불러옴
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		String str = (String)ois.readObject();
		//빨간줄이 생기는 이유는 무엇을 갖고 와야 할지 모르기 때문 강제 형변환 해줘야함
		
		System.out.println(str);
	}
}
