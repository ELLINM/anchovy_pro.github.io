//ex1
class WhileTest 
{
	public static void main(String[] args) 
	{
		int num = 1; //num이 1이다

		while (num <= 100) //num이 100보다 작거나 같을동안
		{
			System.out.println(num++); //1부터 1을 더해서 출력한다.
		}
	}
}
//무한 루프에 빠짖 않도록 주의 하자 조건을 잘 써줄것

class TestNum
{
	public static void main(String[] args) 
	{
		int a = 1; //a=1

		while (true) //a가 항상 true일 동안
		{
			System.out.println(a++); //a에 1을 더해서 계속 출력한다.
			if (a==11){ //만약 a가 11이라면
				break; // 멈춘다
			}
		}
	}
}


class TestNum
{
	public static void main(String[] args) 
	{
		int a = 1; //a=1
		boolean flag true;

		while (flag) //
		{
			System.out.println(a++); //a에 1을 더해서 계속 출력한다.
			if (a==11){ //만약 a가 11이라면
				flag = false;
			}
		}
	}
}


//ex2
class WhileTest 
{
	public static void main(String[] args) 
	{
		int num = 10;

		while (num < 20)
		{
			System.out.println(num);
		}
	}
}
//위 코드는 프로그램이 강제 종료 될때 까지 무한 반복한다.

//x++ 는 프로그래밍을 할 때 매우 자주 쓰이는 기법으로 x의 값을 1만큼씩 증가시킬 목적으로 쓰이는 것이다. 이것은 x += 1처럼 쓰기도 한다.
