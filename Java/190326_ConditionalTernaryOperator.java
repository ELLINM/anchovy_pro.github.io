//ex1

import java.util.Scanner;

class Ternary
{
	public static void main(String[] args) 
	{
		boolean result;
		int score;

		Scanner sc = new Scanner(System.in);

		System.out.print("점수 입력 : ");
		score = sc.nextInt();

		result = score>=70;


		String a = result? "합격":"불학격" ;
		System.out.println(a);
	}
}

//ex2

import java.util.Scanner;

class Ternary
{
	public static void main(String[] args) 
	{
		boolean result;
		int num;

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 입력 : ");
		num = sc.nextInt();

		result = num%2 == 0;


		String a = result? "짝수 입니다.":"홀수 입니다.";
		System.out.println(a);
	}
}
