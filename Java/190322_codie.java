//ex1

import java.util.Scanner;

class Goods
{
	public static void main(String [] args){
		
		int goods;
		int money;
		int result;

		Scanner cc = new Scanner(System.in);

		System.out.println("상품 금액을 입력하세요 : (원)");
		goods = cc.nextInt();

		System.out.println("받은 돈을 입력하세요 : (원)");
		money = cc.nextInt();

		result = money-goods;

		System.out.println("거스름 돈은" + result + "원 입니다.");
	}
}

//ex2

import java.util.Scanner;

class Subject1
{
	public static void main(String [] args){

		int kr;
		int eng;
		int math;
		double avg;
		int result;

		Scanner cc = new Scanner(System.in);

		System.out.println("국어 점수 : ");
	    kr = cc.nextInt();
		
		System.out.println("국어 점수 : ");
		eng =  cc.nextInt();
		
		System.out.println("국어 점수 : ");
		math = cc.nextInt();

		avg = (kr+eng+math)/3.0;
		result = kr+eng+math;

		System.out.println("총점 : " + result + "평균 : " + avg);
	}
}

//ex3

class Num5
{
	int x, y;

	public Num5(int newX, int newY){
		
		x=newX;
		y=newY;
	}

	public static void main(String [] args){
		Num5 n1 = new Num5(100, 200);
		Num5 n2 = new Num5(200, 100);

        System.out.println("교환 전 : x = " + n1.x + ", y =" + n1.y);
		System.out.println("교환 후 : x = " + n2.x + ", y =" + n2.y);

	}
}

//ex4

import java.util.Scanner;

class Change
{
	public static void main(String [] args){

		int cm;
		double inch;
		double result;

		Scanner ch = new Scanner(System.in);

		System.out.print("길이 입력 (Cm단위) : ");
		cm = ch.nextInt();

		inch = 2.54;
		result = cm/inch;

		System.out.println(cm + "Cm = " + result + "inch");

	}
}

//ex5

import java.util.Scanner;

class Volume
{
	public static void main(String [] args){

		int radius;
		int height;

		Scanner cc = new Scanner(System.in);

		System.out.println("원기둥의 반지름 : ");
		radius = cc.nextInt();

		double pi = 3.14;
		double area = radius*radius*pi;

		System.out.println("원기둥의 높이 : ");
		height = cc. nextInt();

		double volume = area*height;

		System.out.println("원기둥의 부피는" + volume + "입니다.");
		
	}
}

//ex6

import java.util.Scanner;

class Clock
{
	public static void main(String [] args){

		int sec;

		Scanner time = new Scanner(System.in);

		System.out.print("시간을 초 단위로 입력하세요 : ");
		sec = time.nextInt();

		int min = sec/60;
		int hour = sec/3600;

		System.out.println(sec + "는" + hour + "시간" + min%(hour*60) + "분" + sec%(min*60) +"초 입니다.");

	}
}

//ex7

import java.util.Scanner;

class  Money
{
	public static void main(String[] args) 
	{
		
		int price;

		Scanner pr = new Scanner(System.in);

		System.out.println("상품 가격을 입력하세요 : ");
		price = pr.nextInt();

		int fm = price/50000;
		int om = (price-(fm*50000))/10000;
		int fc = (price-(fm*50000)-(om*10000))/5000;
		int c = (price-(fm*50000)-(om*10000)-(fc*5000))/1000;
		int p = price-(fm*50000)-(om*10000)-(fc*5000)-(c*1000);

		System.out.println(price + " 원은 " + "5만원권 " + fm + " 장 ," + "만원권 " + om + " 장, " + "5천원권 " + fc + " 장, " + "천원권 " + c + "장, 을 지불하고 " + p + " 원이 남았습니다.");


	}
}

//ex8

import java.util.Scanner;

class Bmi
{
	public static void main(String [] args){

		int kg;
		int cm;

		Scanner re = new Scanner(System.in);

		System.out.println("몸무게를 입력하세요(kg) : ");
		kg = re.nextInt();

		System.out.println("키를 입력하세요 (cm) : ");
		cm = re.nextInt();
		double m = cm/100.0;

		double result = kg/(m*m);

		System.out.println("bmi 지수 : " + result);
	}
}

