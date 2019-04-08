// Fibonacci Sequence


class FibonacciSequence 
{
	public static void main(String[] args) 
	{
		int num1 = 1;
		int num2 = 1;
		int num3;
		int next;
		
		for (int i = 1; i<11; i++)
		{
			System.out.printf("%d --> ", i);
			//n번째의 수의 값은 이라고출력
			System.out.printf("%d\n", num1);
//i가 1일때 아래와 같고 for문을통하여 반복하면서 증가한다.
			num3 = num1 + num2; //2
			num1 = num2 + num3; //다음 루프에서 출력할 값

		}
	}
}
