//ex1
class WhileTest 
{
	public static void main(String[] args) 
	{
		int num = 1;

		while (num <= 100)
		{
			System.out.println(num++);
		}
	}
}
//무한 루프에 빠짖 않도록 주의 하자 조건을 잘 써줄것

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
