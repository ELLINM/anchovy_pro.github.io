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
		{//i의 초기값은 1 -> i는 10보다 작다.
			for (int j = 1; j<10; j++)
			{//j의 초기값은 1 -> j는 10보다 작다.
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
		int x= 0; //x를 초기화 밖에서 출력하기 위해서는 밖에서 선언하는

		for (int i = 1; i<=10; i++)//i는 1 -> 10보다 작거나 같을때까지 1씩 증가한다.
		{//for (int i = 1; i<=10; i+=2)짝수값을 구할수 있다.
			/*for (int i = 1; i<=10; i++)
			{
			if(i%2==1){
			x+=1;
			}
			}을 사용 같은 값을 구할 수 있음*/
			x+=i; // x와 i를 더해준다 i는 계속해서 1씩 증가하므로 0이었던 x에 1,2,3...10까지 더해진다.
		}//For문 안에 출력문을 적으면 출력이 반복됨
			System.out.println(x);
	}
}

//ex4
class For1 
{
	public static void main(String[] args) 
	{
		for (int x = 1; x<=3; x++)//변수 x를 선언하여 x<=3이란 조건을 가짐
		{//x가 1이 되어 첫 반복구문을 실행
			for (int y = 1; y<=3; y++)//두번째 for문이 변수 y를 선언하여 y<=3이라는 조건을 가짐
			{//y 또한 1이 되어 첫 반복구문을 실행하는데 마지막 for문이 변수 z를 선언하여 z <= 3 이라는 조건을 수행
				for (int y = 1; y<=3; y++)//y변수를 가진 for문이 3번을 반복하게 명령
				{
					System.out.println(""+x+y+z);//x, y, z를 출력하라는 명령
				}//x와 y가 1의 값을 가지고 있으니 111, 112, 113을 출력
			}//y가 2의 값을 가지고 다시 z변수를 가진 for문을 호출 그러면 z는 다시 3번을 반복 121,122,123을 출력
		}// 이런 식으로 x,y,z가 반복해서 3번씩 반복
	}//x가 한번돌때 y는 3번을 돌게 되고 y가 1번을 돌때 z가 3번을 돌게 되니 즉 x가 한번돌때 z는 9번을 돌게 된다.
}//이렇게 for문안에 for문이 있을때에는 반복횟수 * 반복횟수 만큼 반복이 실행
