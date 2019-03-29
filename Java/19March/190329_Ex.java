//ex1
/*키보드로 정수를 입력 받아, 
1) 4와 5로 나누어 지는지, 
2) 4 또는 5로 나누어 지는지,
3) 나누어 진다면 어떤 수로 나누어 지는지
3가지를 알수 있도록 출력하시오.(난이도 하)
예시)정수 입력 : 16
4와 5로 나누어 지지 않습니다.
4또는 5로 나누어지고,
4로 나누어 집니다.
or
정수 입력 : 13
4와 5로 나누어 지지 않습니다.
4또는 5로 나누어지지 않습니다.
or
정수 입력 : 20
4와 5로 나누어 집니다.
4또는 5로 나누어 집니다.*/

import java.util.Scanner;

class Cir
{
	public static void main(String[] args) 
	{
		int x;
		Scanner sc = new Scanner(System.in);

		System.out.println("정수 입력 : ");
		x = sc.nextInt();

		if (x%4==0&&x%5==0){
			System.out.println("4 와 5로 나누어집니다.");
		}
		else if (x%4==0||x%5==0){
			System.out.println("4또는 5로 나누어 집니다.");
			System.out.print(x%4==0? "4로 나누어 집니다":"");
			System.out.println(x%5==0? "5로 나누어 집니다.":"");
		}
		else{
			System.out.print("나누어 지지 않습니다.");
		}
	}
}

//ex2
/*년도와 월을 입력 받아 해당 월이 몇 일인지 출력하여라.(난이도 상)
(윤년도 계산하여 포함한다)
-서력 기원 연수가 4로 나누어떨어지는 해는 윤년으로 한다. (1992년, 1996년, 2004년....)
-서력 기원 연수가 4, 100으로 나누어떨어지는 해는 평년으로 한다. (1900년, 2100년....)
-서력 기원 연수가 4, 100, 400으로 나누어떨어지는 해는 윤년으로 둔다. (1600년, 2000년, 2400년)
예시)
년도 입력 : 2019
월 입력 : 3
해당 월은 31일 입니다.
or
년도 입력 : 2019
입력 : 2
해당 월은 28일 입니다.
or
년도 입력 : 2000
월 입력 : 2
해당 월은 29일 입니다.*/

import java.util.Scanner;

class Ad 
{
	public static void main(String[] args) 
	{
		int year, month;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("년도 입력 : ");
		year = sc.nextInt();

		System.out.println("월 입력 : ");
		month = sc.nextInt();

		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			System.out.println("해당 월은 31일 입니다.");
		}
		else if(month==4||month==6||month==9||month==11){
			System.out.println("해당 월은 30일 입니다.");
		}
		else if(year%4==0&&year%100!=0||year%400==0){
			System.out.println("해당 월은 29일 입니다.");
		}
		else {
			System.out.println("해당 월은 28일 입니다.");
		}
	}
}

//ex3
//세가지 수를 입력 받아 세가지 수중에 가장 큰수를 출력하시오.

import java.util.Scanner;

class Int
{
	public static void main(String[] args) 
	{
		int x, y, z;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 수 : ");
		x = sc.nextInt();

		System.out.println("두번째 수 : ");
		y = sc.nextInt();
		
		System.out.println("세번째 수 : ");
		z = sc.nextInt();

		if (x>y&&x>z){
			System.out.println(y>z? x+" "+y+" "+z:"");
			System.out.println(z>y? x+" "+z+" "+y:"");
		}
		else if (y>x&&y>z){
			System.out.println(x>z? y+" "+x+" "+z:"");
			System.out.println(z>x? y+" "+z+" "+x:"");
		}
		else if (z>x&&z>y){
			System.out.println(x>y? z+" "+x+" "+y:"");
			System.out.println(y>x? z+" "+y+" "+x:"");
		}
		else{
			System.out.println("동일한 수가 있습니다.");
		}

	}
}

