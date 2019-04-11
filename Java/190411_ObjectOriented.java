//ex1

class Human 
{
	String name;
	int age;
}

//ex2

class ObjectTest 
{
	public static void main(String[] args) 
	{
		Human h =new Human(); //같은 폴더의 Human Class를 가지고옴
    
    		System.out.println(h.age);
		System.out.println(h.name);
	}
}

//ex3
class ObjectTest 
{
	public static void main(String[] args) 
	{
		Human h = new Human(); //new하는 키워드가 중요 
		Human x = h;

		h.age = 25;
		h.name = "홍길동";
		x.age = 18;

		System.out.println(x==h);
	} //결과는 true 왜? 메모리 주소값이 같다고 판단하기 때문에 true가 나온다.
}


//ex3
//file 1
class Account
{
	int balance;
}

//file 2
import java.util.Scanner;

class ObjectTest 
{
	public static void main(String[] args) 
	{
		Account acc = new Account();
		int num, money = 0;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		while (flag)
		{
			System.out.println("1.입금");
			System.out.println("2.출금");
			System.out.println("3.잔고확인");
			num = sc.nextInt();
			

			switch (num)
			{
			case 1:
				System.out.println("금액을 입력하세요");
				money = sc.nextInt();
				acc.balance += money;
				break;
			case 2:
				System.out.println("금액을 입력하세요");
				money = sc.nextInt();
				acc.balance -= money;
				break;
			case 3:
				System.out.println("현재잔고 : " + acc.balance);
				flag = false;
				break;
			}
		}

	}
}

