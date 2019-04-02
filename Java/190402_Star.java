class For1 //반쪽 삼각형 위로 오른쪽
{
	public static void main(String[] args) 
	{		
		for (int i = 0; i < 5 ; i++) //i가 4까지 반복문을 실행 반복이 진행될 동안 *으 찍음 5에서 i가 반복할때 엔터 열할
		{
			for (int j = 0; j <= i; j++) //ex) i가 2일때는 j는 i와 같아지기 위해서 0,1,2 3번을 반복하기 때문에 ***이후 엔터
			{
				System.out.print("*"); 
			}
			System.out.println();
		}
	}
}

class For1 //반쪽 삼각형 위로 왼쪽
{
	public static void main(String[] args) 
	{		
		for (int i = 0; i < 5 ; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				System.out.print((j<(4-i))? " ":"*");
			}//i가 3일때 j는 5번 반복 => (j<(4-3)) =>  (j<1)이 조건이됨 0일때 true => 공백 => 1,2,3,4는 false이기 때문에 *로 찍히고 엔터
			System.out.println();
		}//i값이 커질수록 공백보다 별의 개수가 많아진다.
	}
}

class For1 //삼각형
{
	public static void main(String[] args) 
	{		
		for (int i = 0; i < 5 ; i++)
		{
			for (int j = 0; j < (5+i); j++)
			{

			}
			System.out.println(" ");
		}
	}
}


class For1 //피라미드 모형
{
	public static void main(String[] args) 
	{		
		for (int i = 0; i < 8 ; i++)
		{
			for (int j = 0; j < 6-i; j++)
			{
				System.out.print(" ");
			}
			for (int j=0;j<2*i+1;j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}

import java.util.Scanner;

class For1 //다이아 
{
	public static void main(String[] args) 
	{
		System.out.println("홀수를 입력해 주세요");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 0; i<num;i++)
		{
			for (int j = 0; j<num; j++)
			{
				if (i<=num/2) //위쪽영역
				{
					if (i+j<=num/2-1)//왼쪽 위 공백찍기
						System.out.print(" ");
				    
					else if (j-i>=num/2+1)//오른쪽 위 공백찍기
							System.out.print(" ");

					else
						System.out.print("*"); //*찍기
					
				}
				else if (i>num/2)//아래쪽 영역
				{
					if (i-j>=num/2+1)//왼쪽 및 공백
							System.out.print(" ");
					else if (i+j>=num/2*3+1)//오른쪽 밑 공백
							System.out.print(" ");
					else 
							System.out.print("*");//별찍기
				}
			}
			System.out.println();//줄바꿈
		}
	}
}
