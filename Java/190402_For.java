//ex1

import java.util.Scanner;

class For1 
{
	public static void main(String[] args) 
	{
		int x = 0;
		int y; //변수 y를 선언
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요 : ");
		y = sc.nextInt(); //y를 입력받음

		for (int i = 0; i<=y; i++) //i가 y보다 작거나 같을 동안 i++를 반복
		{			
			x += i; //변수 x에 i를 대입
		}
		System.out.println(x); //x는 y까지 반복연산을 하여 총합을 
	}
}

//ex2

import java.util.Scanner;

class For1 
{
	public static void main(String[] args) 
	{
		int y;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요 : ");
		y = sc.nextInt();

		for (int i = 1; i<=y; i++)
		{//위와 같이 i가 y보다 작거나 같다는 조건
			if (y%i==0)
			{//조건식으로 y를 i로 나누었을때 0이라는 조건을 넣어줌
				System.out.println(i); //위 조건을 만족할때 i를 출력
			}
		}
	}
}


//ex3
import java.util.Scanner;

class For1 
{
	public static void main(String[] args) 
	{
		int y;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요 : ");
		y = sc.nextInt();

		for (int i = 1; i<=y; i++)
		{			
			if (y/i==i)
				System.out.println(i);
		}
	}
}


//ex4

import java.util.Scanner;

class For1 
{
	public static void main(String[] args) 
	{
		int y;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요 : ");
		y = sc.nextInt();

		for (int i = 0; i <= y; i++)
		{
			if (i%12==3)// 2019/12 == 168 2019%12 == 3 때문에 i를 12로 나눈 나머지가 3이 되어야 돼지해를 구할 수 있다.
			{
				System.out.println("역대 돼지의 해는 : " + i);
			}
		}
	}
}


//ex5

