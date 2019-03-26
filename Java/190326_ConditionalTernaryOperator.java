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
