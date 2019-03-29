//ex1

import java.util.Scanner;

class Iftest
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int score;

		System.out.println("점수 입력 : ");
		score = sc.nextInt();

		if(score>=70){
			System.out.println("합격 입니다.");
		}
		
		else{
			System.out.println("불합격 입니다.");
		}
	}
}
