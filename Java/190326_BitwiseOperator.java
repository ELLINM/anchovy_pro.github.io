//ex1

class Bitwise
{
	public static void main(String[] args) 
	{
		
		byte a = 10;
		byte b = 20;

		System.out.println(a&b);
	}
}
//비트 연산 & | ^ ~

//ex2

class Bitwise
{
	public static void main(String[] args) 
	{
		
		byte a = 127;

		System.out.println(a+1);
	}
}
//결과값은 128, 128은 int이기 때문에 자동 형변환이 일어남

//ex3

class BitOp
{
	public static void main(String[] args) 
	{
		
		int a=1;

		a+=1;
		a+=2;
		a+=3;

		System.out.println(a);
	}
}
// += -= *= /= %=

//ex4

class BitOp
{
	public static void main(String[] args) 
	{
		
		int a=1;

		a*=2;
		a*=3;
		a*=4;
		a*=5;
		a*=6;
		a*=7;
		a*=8;
		a*=9;

		System.out.println(a);
	}
}
