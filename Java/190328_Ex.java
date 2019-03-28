//ex1

/*닭이 몇마리인지, 소가 몇마리인지 입력 받아 총 다리 갯수를 구하는 프로그램을 만드시오.
예시)
닭의 마릿수 : 5
소의 마릿수 : 2
총다리의 갯수는 18개 입니다.*/

import java.util.Scanner;

class Animal
{
	public static void main(String[] args) 
	{
		int chi, cow,chil,cowl,result;
		Scanner num = new Scanner(System.in);
		
		System.out.println("닭은 몇마리 인가요 : ");
		chi = num.nextInt();
		
		System.out.println("소는 몇마리 인가요 : ");
		cow = num.nextInt();

		chil = chi*2;
		cowl = cow*4;
		result = chil + cowl;

		System.out.println("총 다리의 갯수는 "+result+"개 입니다.");
	}
}

//ex2

/*값을 3개 입력 받아 입력 받은 첫번째 수가 두번째,세번째 수의 공배수인지의 여부를 출력하시오.
예시)
정수 입력 : 15
정수 입력 :3
정수 입력 :5
15 은/는 3과 5의 공배수입니다.*/

import java.util.Scanner;

class Number3
{
	public static void main(String[] args) 
	{
		int num1, num2, num3;
		Scanner num = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		num1 = num.nextInt();

		System.out.print("정수 입력 : ");
		num2 = num.nextInt();

		System.out.print("정수 입력 : ");
		num3 = num.nextInt();

		String num4 = num1==num2*num3? num1+"은"+num2+"와"+num3+"의 공배수 입니다.":num1+"은"+num2+"와"+num3+"의 공배수가 아닙니다.";
		System.out.println(num4);
	}
}


//ex3

/*세균 A는 30분 마다 원래 개체수의 10%씩 증가하는 박테리아이다. 
원래 100마리 있었다면 30분후 110마리, 한시간후 120마리 한시간 30분후 130마리.....
처음 있던 박테리아의 수와 경과시간(분)을 입력 받아 증가한 총 세균의 수를 출력하시오. */

import java.util.Scanner;

class Science
{
	public static void main(String[] args) 
	{
		int vir,time;
		double total;

		Scanner num = new Scanner(System.in);
		
		System.out.println("박테리아 입력 : ");
		vir = num.nextInt();

		System.out.println("시간 입력 : ");
		time = num.nextInt();

		total=vir+vir*(0.1*(time/30.0));

		System.out.println(time+"분 후에"+total+"마리 입니다.");
	}
}


//ex4
/*약품에서 유통기한이 끝났을 때란, 약품이 스스로 분해되어(산화 등..)
유효성분이 90% 까지 떨어졌을때를 말한다. 유효약품의 용량(mg)을 입력 받아 
유통기한이 지나는 시점의 유효성분의 용량을 출력하시오.*/

import java.util.Scanner;

class Medic 
{
	public static void main(String[] args) 
	{
		int med;
		Scanner num = new Scanner(System.in);

		System.out.print("약품의 용량을 입력하시오 :");
		med = num.nextInt();

		double med2 = med-(med*0.1);

		System.out.println("유효성분의 용량은 : "+med2+"mg 입니다.");
	}
}


//ex5
/*소극장에 10자리의 좌석이 있다.
이름과 몇번째 자리인지 입력 받아 화면에 출력하시오.
예시)
처음엔 빈자리를 보여준다.
============소극장============
[] [] [] [] [] [] [] [] [] []

이름입력:김철수
몇번째자리에 앉습니까? : 2

============소극장============
[] [김철수] [] [] [] [] [] [] [] []*/

import java.util.Scanner;

class Movie
{
	public static void main(String[] args)
	{
		int seat;
		String name,num1,num2,num3,num4,num5,num6,num7,num8,num9,num10;

		Scanner input = new Scanner(System.in);

		System.out.println("=============소극장============="+"\n[] [] [] [] [] [] [] [] [] []");

		System.out.print("이름을 입력하세요 : ");
		name = input.nextLine();
		
		System.out.print("좌석을 입력하세요 : ");
		seat = input.nextInt();

		num1=seat==1?name:"";
		num2=seat==2?name:"";
		num3=seat==3?name:"";
		num4=seat==4?name:"";
		num5=seat==5?name:"";
		num6=seat==6?name:"";
		num7=seat==7?name:"";
		num8=seat==8?name:"";
		num9=seat==9?name:"";
		num10=seat==10?name:"";

		System.out.println("=============소극장============="+"\n["+num1+"] ["+num2+"] ["+num3+"] ["+num4+"] ["+num5+"] ["+num6+"] ["+num7+"] ["+num8+"] ["+num9+"] ["+num10+"]");
	}
}


//ex6
/*1평은 가로 1.8181m 세로 1.8181m의 방을 의미
한다. 방의 가로가 몇 m인지, 세로가 몇 m인지 입력 받아, 평 수를
출력하시오.*/

import java.util.Scanner;

class Era
{
	public static void main(String[] args) 
	{
		double width,column,era,era2;
		Scanner num = new Scanner(System.in);

		System.out.println("가로 길이를 입력하세요. : ");
		width = num.nextInt();
		
		System.out.println("세로 길이를 입력하세요 : ");
		column = num.nextInt();
		
		era = width*column;
		era2 = era*0.3025;

		System.out.println("방의 넓이는 : "+era2+"평 입니다.");
	}
}

//ex7
/*사채업자 우지시마에게 3개월 할부로 돈을 빌리려고 한다.
이자는 1개월당 39.8%의 복리로 계산된다.
금액을 입력하고, 3개월후 원금+이자의 총 금액을 출력하여라. */

import java.util.Scanner;

class Bank 
{
	public static void main(String[] args) 
	{
		double credit,credit1,credit2,credit3;
		Scanner num = new Scanner(System.in);

		System.out.println("대출금 : ");
		credit = num.nextInt();

		credit1=credit+credit*0.398;
		credit2=credit1+credit1*0.398;
		credit3=credit2+credit2*0.398;

		System.out.println("갚아야 하는 금액 : "+(int)credit3);
	}
}

/*import java.util.Scanner;

class Test7
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int debt;
		double result,interest=1.398;
		
		System.out.print("빌린금액 입력 : ");
		debt=sc.nextInt();

		result=debt*interest*interest*interest;

		System.out.println("3개월후 갚을 돈 : "+(int)result+"원");

	}
}*/

//ex8
/*종합 소득세의 표는 다음과 같다. 과세 표준은 연봉으로 적용한다.
연봉을 입력받아 2018년 기준의 종합 소득세를 계산하여라.*/

import java.util.Scanner;

class HateTax 
{
	public static void main(String[] args) 
	{
		double pay;
		double result;

		Scanner num = new Scanner(System.in);
		System.out.println("연봉 입력 : ");
		pay = num.nextInt();

		result=0<pay&&pay<=12000000? pay*0.06:0;
		result=pay>12000000&&pay<=46000000? pay*0.15-1080000:result;
		result=pay>46000000&&pay<=88000000? pay*0.24-5220000:result;
		result=pay>88000000&&pay<=150000000? pay*0.35-14900000:result;
		result=pay>150000000&&pay<=300000000? pay*0.38-19400000:result;
		result=pay>300000000&&pay<=500000000? pay*0.4-25400000:result;
		result=pay>500000000? pay*0.42-35400000:result;

		System.out.println("종합 소득세 : "+(int)result+"원");
	}
}
