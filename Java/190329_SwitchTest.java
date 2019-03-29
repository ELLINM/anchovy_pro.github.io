//ex1

class SwitchTest 
{
	public static void main(String[] args) 
	{
		switch(1){
			case 1:
				System.out.println("1번 입니다.");
			break;
			case 2:
				System.out.println("2번 입니다.");
			break;
			case 3:
				System.out.println("3번 입니다.");
			break;//break는 필수적으로 적어 줄것 break를 빼버리면 다음 문장으로 출력이 됨.
		}
	}
}
// 일부러 break를 빼는 경우도 있음 case를 여러개를 중첩 하는 경우도 있음.

//ex2

import java.util.Scanner;

class switchTest
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("===============");
		System.out.println("1.메뉴1");
		System.out.println("2.메뉴2");
		System.out.println("3.메뉴3");
		System.out.println("===============");
		System.out.println("메뉴 선택 :");
		int choice=sc.nextInt();

		switch(choice){
			case 1:
				System.out.println("1번입니다.");
			break;
			case 2:
				System.out.println("2번입니다.");
			break;
			case 3:
				System.out.println("3번입니다.");
			break;
		}

	}
}

//ex3
