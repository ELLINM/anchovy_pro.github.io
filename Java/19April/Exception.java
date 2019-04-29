package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMain {
	
	public static void main(String [] args) {
		
	Scanner sc = new Scanner(System.in);
	
	System.out.println("숫자 입력");
	
	try {
		sc.nextInt();
	}catch(InputMismatchException exc) {
		System.out.println("입력오류");
	}
	System.out.println("프로그램 종료");
	}
}
