package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMain {
	
	public static void main(String [] args) {
		
	Scanner sc = new Scanner(System.in);
	int num = 0;
		
	System.out.println("숫자 입력");
	
	try { //try문안에서 선언된것은 try문 안에서만 사용가능
		num = sc.nextInt(); //try에서 문제가 발생하면 catch로 넘어감
		// 입력하는 순간 대입이 되는데 오류를 입력하게되면 대입을 하지않고 초기값을 가지고옴
		System.out.println("입력성공");
	}catch(InputMismatchException exc) {
		//catch(Exception exc) 을 사용하여 모든 Exception을 처리 할 수 
		num = 99;
		System.out.println("입력오류");
		//초기값을 설정해줄 수 있음
	}
	System.out.println("프로그램 종료 입력한 값 : " + num);
	}
}
