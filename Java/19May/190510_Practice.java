package Practice;

import java.io.*;

public class JavaPractice {
	
	public static void main(String [] args) throws IOException{
		System.out.println("문자열을 입력하세요");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //System.in은  표준 입력이라는 장치와 연결되어 있습니다.
		
		String str = br.readLine(); //사용자의 입력을 기다리는 상태
		
		System.out.println(str + "(이)가 입력되었습니다.");
	}
}


package Practice;

import java.io.*;

public class JavaPractice {
	
	public static void main(String [] args) throws IOException{
		System.out.println("정수를 입력하십시오");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Scanner와 차이점 import java.io.*;로 사용 , InputStreamReader로 입력을 받음
		String str = br.readLine();
		// readLine(); 으로 읽음
		int num = Integer.parseInt(str);
		
		System.out.println(num + "(이)가 입력되었습니다.");
	}
}


package Practice;

import java.io.*;
import java.util.Scanner;

public class JavaPractice {
	
	public static void main(String [] args) throws IOException{
		System.out.println("정수를 2개 입력하십시오");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		System.out.println("먼저 " + num1 + "(이)가 입력되었습니다.");
		System.out.println("그 다음으로 " + num2 + "(이)가 입력되었습니다.");
	}
}


package Practice;

import java.io.*;
import java.util.Scanner;

public class JavaPractice {
	
	public static void main(String [] args) throws IOException{
		System.out.println("정수를 입력하십시오");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int res = Integer.parseInt(str);
		
		if (res == 1)
			System.out.println("1이 입력 되었습니다.");
		
		System.out.println("처리되었습니다.");
	}
}
