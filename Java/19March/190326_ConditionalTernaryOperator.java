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
		boolean isEven;//의미를 담은 변수명을 지어주는것이 좋음
		int num; //입력 받은 숫자를 담는 변수
		String result;

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 입력 : ");
		num = sc.nextInt();

		isEven = num%2 == 0; //짝수임을 판별 짝수 = true, 홀수  = false		
		result = isEven? "짝수" : "홀수";

		System.out.println("숫자" + num +"는/은 "+result+"입니다.");
	}
}
