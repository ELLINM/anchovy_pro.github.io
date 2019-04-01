//ex1

class For1 
{
	public static void main(String[] args) 
	{
		for (int i = 1; i<=100; i++)
    //for (int i = 0; i<=100; i+=2)이런식으로 짝수만 출력하는것도 가능
    //i의 초기값은 1이다 -> i의 값이 100보다 작거나 같은가? -> i값을 출력 -> i값을 1증가 -> 100이되면 for문을 빠져나옴
		{
			System.out.println(i);
		}
	}
}

//ex2

class For1 
{
	public static void main(String[] args) 
	{
		for (int i = 1; i<10; i++)
		{//i의 초기값은 1 -> i는 10보다 작다
			for (int j = 1; j<10; j++)
			{//j의 초기값은 1 -> j는 10보다 작다
				System.out.println(i + " * " + i + " = " + (i*j));
			}//두가지 선언이 만족함에 따라 i와j의 값을 출력한다. 둘다 9가 되면 탈출 
		}
	}
}
//구구단 출력도 가능
