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

