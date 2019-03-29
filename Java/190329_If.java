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
		//{를 열어도 되고 안열어도 되지만 열지 않을 경우 한줄만 출력이 됨
		else{
			System.out.println("불합격 입니다.");
		}
	}
}
