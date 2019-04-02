class For1 
{
	public static void main(String[] args) 
	{		
		for (int i = 1; i < 10 ; i++)
		{
			for (int j = 0; j < i; j++) //한바퀴 돌때 하나출력 두바퀴째에는 두개 출력
			{
				System.out.print("*"); //문자 변환 필요없이 그냥 출력
			}
			System.out.println();
		}
	}
}

class For1 //줄어드는 별모양
{
	public static void main(String[] args) 
	{		
		for (int i = 1; i <= 10 ; i++)
		{
			for (int j = 10; j >= i; j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

class For1 //반대로 줄
{
	public static void main(String[] args) 
	{		
		for (int i = 1; i < 10 ; i++)
		{
			for (int j = 8; j > 0; j--)
			{
				if (i<j)
				{
					System.out.print(" ");
				}
				else
				{
					System.out.print("*");
				}
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
