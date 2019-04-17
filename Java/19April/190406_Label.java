//ex1

class LabelTest 
{
	public static void main(String[] args) 
	{
		Loop: //Label을 추가하기 전에는 abcdefg가 여러차례반복됨
		for (int i = 1; i <= 10; i++)
		{
			for (char ch = 'a'; ch <= 'z'; ch++)
			{
				System.out.print(ch + " ");
				if (ch >= 'g') break Loop;
			}//라벨이후에는 abcdefg 한번 출력후 프로그램이 종료
		}
		System.out.println("The End!");
	}
}


//ex2

class LabelTest 
{
	public static void main(String[] args) 
	{
		Loop: 
		for (int i = 1; i <= 10; i++)
		{
			for (char ch = 'a'; ch <= 'z'; ch++)
			{
				System.out.print(ch + " ");
				if (ch >= 'c') continue Loop;//continue와 함께 사용할 경우 반복문을 계속 실행하게된다.
			}
		}
		System.out.println("The End!");
	}
}


//ex3


class LabelTest 
{
	public static void main(String[] args) 
	{
		int i = 0; //변수 i를 초기화

		Loop:
			while (i < 10) //i는 0~9까지 실행됨
			{
			char ch = 'a'; //변수 ch는 알파벳 a이며
			while (ch <= 'z') //z보다 작거나 같을동안 계속해서 반복되어 출력
			{
				System.out.print(ch + " "); //한칸씩 공백을 두며 출력 ex)a b c d ...

				if (ch >= 'g') break Loop; //만약 ch가 g와 같거나 크다면 반복을 멈추고 빠져 나오게 된다.
				ch++; //그렇지 않다면 ch는 하나씩 증가하게됨
			}
			i++; 
			}
			System.out.println("The End");
	}
}
