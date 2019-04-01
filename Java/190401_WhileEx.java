//ex1

import java.util.Scanner;

class Int2
{
	public static void main(String[] args) 
	{
		int x, y, z, r;
		Scanner sc = new Scanner(System.in);

		System.out.println("첫번째 수 : ");
		x = sc.nextInt();

		System.out.println("두번째 수 : ");
		y = sc.nextInt();

		System.out.println("세번째 수 : ");
		z = sc.nextInt();

		if (y<x) //y가 x보다 작다면
		{
			r = x; //변수 r에 x를  저장
			x = y; //y를 x에 대입
			y = r; //y에 r(x)를 대입
		}
		if (z<x); //위 조건을 만족하고 현 조건을 만족 하면
		{
			r = x; //변수 r에 x를 저장
			x = z; //x에 z를 대입
			z = r; //다시 z에 r(x)값을 대입
		}
		if (z<y) 
		{
			r = y;
			y = z;
			z = r;
		}
		System.out.print(x + " " + y + " " + z); //위 조건들을 만족한다면 각 자리에 수가 대입되어 
	}
}

//ex2

import java.util.Scanner;

class Grade3 
{
	public static void main(String[] args) 
	{
		int fir, sec, thr, tot, choice;
		double avg;
		String x;

		Scanner sc = new Scanner(System.in);

		System.out.println("첫번째 과목 입력 : ");
		fir = sc.nextInt();

		System.out.println("두번째 과목 입력 : ");
		sec = sc.nextInt();

		System.out.println("세번째 과목 입력 : ");
		thr = sc.nextInt();

		System.out.println("=======메뉴 입력==========\n 1.평균 출력\n 2.총점 출력\n 3.학점 출력\n==========================");
		choice = sc.nextInt();
		
		tot = fir + sec + thr;
		avg = tot/3.0;
		

		switch(choice){
			case 1:
				System.out.println("평균 점수는 : " + avg);
			break;
			case 2:
				System.out.println("총점 : " + tot);
			break;
			case 3:
				if (avg>=90)
				{
				System.out.print("학점 : A");
				}
				else if (avg>=80)
				{
				System.out.print("학점 : B");
				}
				else if (avg>=70)
				{
				System.out.print("학점 : C");
				}
				else if (avg>=60)
				{
				System.out.print("학점 : D");
				}
				else
				{
				System.out.print("학점 : F");
				}
			break;
		}
	}
}


import java.util.Scanner;

class TestNum2
{
	public static void main(String[] args) 
	{
		int num1 = 0, num2 = 0; //두 변수를 초기화
		Scanner sc = new Scanner(System.in);
		boolean flag = true; //초기값으로 true

		while (flag)
		{
		System.out.println("====================\n 1.첫번째 수 입력 \n 2.두번째 수 입력 \n 3.덧셈 \n 4.뺄셈 \n 5.곱셈 \n 6.나눗셈 \n 7.프로그램 종료 \n====================");
		int choice = sc.nextInt();// 메뉴를 제작하고 실행하면 무한반복

		switch(choice){
			case 1:
				System.out.print("첫번째 수 입력 : ");
				num1 = sc.nextInt();
				break;
			case 2:
				System.out.print("두번째 수 입력 : ");
				num2 = sc.nextInt();
				break;
			case 3:
				System.out.println("덧셈 결과 : " + (num1+num2));
				break;
			case 4:
				System.out.println("뺄셈 결과 : " + (num1-num2));
				break;
			case 5:
				System.out.println("곱셈 결과 : " + (num1*num2));
				break;
			case 6:
				System.out.println("나눗셈셈 결과 : " + (num1/num2));
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				flag = false;
			    	break;
		}
		}
	}
}
