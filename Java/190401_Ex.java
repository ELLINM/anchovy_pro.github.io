//ex1

import java.util.Scanner;

class Int2
{
	public static void main(String[] args) 
	{
		int x, y, z, r;
		Scanner sc = new Scanner(System.in);

		System.out.println("첫번째 수 : ");
		x = sc.nextInt();

		System.out.println("두번째 수 : ");
		y = sc.nextInt();

		System.out.println("세번째 수 : ");
		z = sc.nextInt();

		if (y<x) //y가 x보다 작다면
		{
			r = x; //변수 r에 x를  저장
			x = y; //y를 x에 대입
			y = r; //y에 r(x)를 대입
		}
		if (z<x); //위 조건을 만족하고 현 조건을 만족 하면
		{
			r = x; //변수 r에 x를 저장
			x = z; //x에 z를 대입
			z = r; //다시 z에 r(x)값을 대입
		}
		if (z<y) 
		{
			r = y;
			y = z;
			z = r;
		}
		System.out.print(x + " " + y + " " + z); //위 조건들을 만족한다면 각 자리에 수가 대입되어 
	}
}

