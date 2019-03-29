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
		//else는 if의 조건이 충족하지 않을 경우를 출력
		}
	}
}

//ex2
import java.util.Scanner;

class Iftest
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int score;

		System.out.println("점수 입력 : ");
		score = sc.nextInt();

		if(score>=90){
			System.out.println("A");
		}
		
		else if(score>=80){
			System.out.println("B");
		}
		//다양한 조건이 들어가야 할경우 else if를 사용하여 

		else {
			System.out.println("C");
		}
	}
}

//ex3

import java.util.Scanner;

class Test2
{
	public static void main(String[] args) 
	{
		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		num = sc.nextInt();

		if(num%2==0){
			System.out.println("짝수 입니다.");
		}
		else{
			System.out.println("홍수 입니다.");
		}
	}
}

//ex4
/*시험이 있다. 점수를 입력 받아,
70점 이상은 합격
50~69점은 재시험
50점 미만은 탈락을 출력하시오.*/

import java.util.Scanner;

class Exam
{
	public static void main(String[] args) 
	{
		int score;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수 입력:");
		score = sc.nextInt();

		if(score>=70){
			System.out.println("합격입니다.");
		}

		else if(score>=50){
			System.out.println("재시험입니다.");
		}
		else{
			System.out.println("탈락입니다.");
		}
	}
}

//ex5
/*점수를 입력 받아 다음과 같이 분류하시오. 
A 90~100
B 80~89
C 70~79
D 60~69
그외 F*/

import java.util.Scanner;

class Grade2
{
	public static void main(String[] args) 
	{
		int score;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("성적을 입력하세요 : ");
		score = sc.nextInt();

		if(score>=90){
			System.out.println("A");
		}
		else if(score>=80){
			System.out.println("B");
		}
		else if(score>=80){
			System.out.println("C");
		}
		else if(score>=70){
			System.out.println("D");
		}
		else{
			System.out.println("F");
		}

	}
}
