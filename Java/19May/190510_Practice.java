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


package Practice;

public class JavaPractice {
	
	public static void main(String [] args)	{
		boolean bl = false;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (bl == false) {
					System.out.print("*");
					bl = true; //*을 출력하고 true를 대입
				}else {
					System.out.print("-");
					bl = false; // - 를 출력하고 false를 대입
				}
			}
			System.out.println("\n"); //j의 5회 반복이 끝나면 i의 1회 이므로 for문을 나와서 다음줄로 넘어간다.
		}
	}
}


package Practice;

import java.io.*;
import java.io.InputStreamReader;

public class JavaPractice {
	
	public static void main(String [] args)	throws IOException{
		
		System.out.println("몇 번째 처리를 전너 뛰시겠습니까? (1-10)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int res = Integer.parseInt(str);
		
		for (int i = 1; i <= 10; i++) {
			if (i == res) 
				continue; //if 문을 {로 묶지 않음으로서 처리한다.
			System.out.println(i + "번째 처리입니다.");
		}
	}
}


package Practice;

import java.io.*;

public class JavaPractice {
	
	public static void main(String [] args)	throws IOException{
		System.out.println("시험 응시자 수를 입력하십시오.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str =  br.readLine();
		int num = Integer.parseInt(str);
		//배열의 요소 개수 입력
		
		int[] test;
		test = new int[num];
		// 필요한 개수만큼 배열요소를 준비
		
		System.out.println("시험 응시자 수 만큼 점수를 입력하십시오");
		
		for(int i = 0; i < num; i++) {
			str = br.readLine();
			int tmp = Integer.parseInt(str);
			test[i] = tmp;
		}
		
		for (int i = 0; i < num; i++) {
			System.out.println((i + 1) + "번째 사람의 점수는  " + test[i] + "입니다.");
		}
	}
}


package Practice;

import java.io.*;

public class JavaPractice {
	
	public static void main(String [] args)	{
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("test1.txt")));
			
			pw.println("Hello");
			pw.println("GoodBye");
			System.out.println("파일에 기롣되었습니다.");
			
			pw.close();
		}catch(Exception e){
			System.out.println("입출력 에러가 발생하였습니다.");
		}
		
	}
}
