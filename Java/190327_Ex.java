//ex1
//정수를 입력 받아 0보다 미만이거나 999를 초과하는 수라면 "입력 오류!" 문구를 출력하시오.

import java.util.Scanner;

class Natural
{
	public static void main(String[] args) 
	{
		int num;
		boolean not;
		
		Scanner cc = new Scanner(System.in);
		
		System.out.println("숫자 입력 : ");
		num = cc.nextInt();

		not = num<0||num>999;

		String n = not? "입력 오류":"";;
		System.out.println(n);
	}
}


//ex2
/*실수령액= 기본급 + 시간수당 -세금(기본급의 10%), 시간수당=초과근무시간 X 15000 
기본급과 초과 근무 시간을 입력 받아, 실수령액을 구하시오*/

import java.util.Scanner;
//실수령액= 기본급 + 시간수당 -세금(기본급의 10%), 시간수당=초과근무시간 X 15000 
class Money1 
{
	public static void main(String[] args) 
	{
		int pay,time,ot,money;
		Scanner num=new Scanner(System.in);

		System.out.println("기본급 입력 : ");
		pay=num.nextInt();

		System.out.println("초과 근무 시간 : ");
		time=num.nextInt();

		ot=time*15000;
		money=pay+ot-(pay/10);

		System.out.println("실수령 액은"+money+"원 입니다.");
	}
}

//ex3
//세가지 수를 입력 받아 세가지 수중에 가장 큰수를 출력하시오.

import java.util.Scanner;

class Big
{
	public static void main(String[] args) 
	{
		int fir, sec, thr, four;
//알고리즘을 이해 보자 비교는 3번
		Scanner num = new Scanner(System.in);

		System.out.print("첫번째 수 : ");
		fir = num.nextInt();

		System.out.print("두번째 수 : ");
		sec = num.nextInt();

		System.out.print("세번째 수 : ");
		thr = num.nextInt();

		four=sec>fir?fir:0;
		fir=four!=0?sec:fir;
		sec=four!=0?four:sec;

		four=0;

		four=thr>fir?fir:0;
		fir=four!=0?thr:fir;
		thr=four!=0?four:thr;

		four=0;

		four=thr>sec?sec:0;
		sec=four!=0?thr:sec;
		thr=four!=0?four:thr;


		System.out.print(fir + " " + sec + " " + thr);

	}
}

//ex4
/*1세기는 1년부터 100년까지를, 2세기는 101년부터 200년까지 3세기는 201년부터 300년까지 ......
년도를 입력 받아, 몇세기 인지 출력하시오.(21세기 까지 출력가능)*/

import java.util.Scanner;

class Century
{
	public static void main(String[] args) 
	{
		int cen,ad,pa,bc;

		Scanner num = new Scanner(System.in);

		System.out.println("년도 입력 : ");
		cen = num.nextInt();

		ad = (cen+99)/100;

		System.out.println( ad + "세기 입니다.");
	}
}

//ex5
/*피자 조각 과 사람 수를 입력 받아 한 사람당 몇 조각을 먹을 수 있는지, 강아지가 몇 조각 먹는지 출력하시오. 
못 먹는 피자는 강아지가 먹게 됩니다.*/

import java.util.Scanner;

class Pizza 
{
	public static void main(String[] args) 
	{
		int pizza, people,num,num2;
		Scanner eat = new Scanner(System.in);

		System.out.println("피자 조각 : ");
		pizza=eat.nextInt();

		System.out.println("사람 수 : ");
		people=eat.nextInt();

		num=pizza/people;
		num2=pizza%people;

		System.out.println("한 사람당 : "+num+"조각의 피자를 먹고");
		System.out.println("강아지는 "+num2+"조각의 남은 피자를 먹습니다.");
	}
}

//ex6
/*1사분면의 좌표 두개를 입력 받은 후, 원점 과 가장 가까운 한가지의 좌표를 출력하시오.
예시) 
첫번째 점 x좌표 입력:1
첫번째 점 y좌표 입력:2
두번째 점 x좌표 입력:4
두번째 점 y좌표 입력:4
점(1,2) 가 원점과 더 가깝습니다.*/

import java.util.Scanner;

class Graph 
{
	public static void main(String[] args) 
	{
		int a,b,c,d,e;
		Scanner num=new Scanner(System.in);

		System.out.println("첫번째 점 x좌표 입력:");
		a=num.nextInt();

		System.out.println("첫번째 점 y좌표 입력:");
		b=num.nextInt();

		System.out.println("두번째 점 x좌표 입력:");
		c=num.nextInt();

		System.out.println("두번째 점 y좌표 입력:");
		d=num.nextInt();

		e=c>a?a:0;
		e=0;

		e=a>c?c:0;
		e=0;

		e=d>b?b:0;
		e=0;

		e=b>d?d:0;

		System.out.println("점 ("+a+","+b+") 가 원점과 더 가깝습니다.");
	}
}
