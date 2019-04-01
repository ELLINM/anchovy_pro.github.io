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


//ex3
class For1 
{
	public static void main(String[] args) 
	{
		int x= 0; //x를 초기화

		for (int i = 1; i<=10; i++)//i는 1 -> 10보다 작거나 같을때까지 1씩 증가한다.
		{//for (int i = 1; i<=10; i+=2)짝수값을 구할수 있다 
			/*for (int i = 1; i<=10; i++)
			{
			if(i%2==1){
			x+=1;
			}
			}을 사용 같은 값을 구할 수 있음*/
			x+=i; // x와 i를 더해준다 i는 계속해서 1씩 증가하므로 0이었던 x에 1,2,3...10까지 더해진다.
		}
			System.out.println(x);
	}
}
