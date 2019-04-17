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


//ex4

//file1

class Human 
{
	String name ,address;
	int age;
}

//file2

import java.util.Scanner;

class Profile
{
	public static void main(String[] args) 
	{
		int choice;
		Human me = new Human();
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		boolean flag = true;

		while (flag)
		{

		System.out.println("=====나의 프로필=====");
		System.out.println("1. 이름 입력");
		System.out.println("2. 나이 입력");
		System.out.println("3. 주소 입력");
		System.out.println("4. 정보 출력");
		System.out.println("=====================");
		choice = sc.nextInt();

		switch (choice)
		{
		case 1:
			System.out.println("이름 입력 : ");
			me.name = sc.next();
			break;
		case 2:
			System.out.println("나이 입력 : ");
			me.age = sc.nextInt();
			break;
		case 3:
			System.out.println("주소 입력 : ");
			me.address = sc2.nextLine(); //Scanner를 하나만 가지고 사용할경우 입력은 되지만 앞 첫 음절이 사라짐
				/*ex)sc.next();
			me.address = sc.nextLine(); 으로 입력한 경우 서울 영등포구 입력시 서울이 사라짐 따라서 새로 Scanner를 만들어줌*/ 
			break;
		case 4:
			System.out.println("정보 출력");
			System.out.println("이름 : " + me.name);
			System.out.println("나이 : " + me.age);
			System.out.println("주소 : " + me.address);
			flag = false;
			break;
		}
		}

	}
}


//ex5

//file 1

class Student
{
	String name;
	int score;
}


//file 2

import java.util.Scanner;

class Manage
{
	public static void main(String[] args) 
	{
		Student manage = new Student();
		Scanner sc = new Scanner(System.in);
		String [] student = new String [5];
		int choice,counter = 0;
		double avg;

		boolean flag = true;

		while (flag)
		{
		System.out.println("=====================");
		System.out.println("1. 이름 등록");
		System.out.println("2. 점수 등록");
		System.out.println("3. 평균 출력");
		System.out.println("=====================");
		choice = sc.nextInt();

		switch (choice)
		{
		case 1:
			System.out.println("이름을 입력하세요 : ");
			manage.name += sc.nextLine();
			student[counter++] = manage.name;
			sc.next();

			break;
		case 2:
			System.out.println("점수를 입력하세요 : ");
			manage.score += sc.nextInt();
			break;
		case 3:
			avg = manage.score/counter;
			System.out.println("평균 점수 : " + avg);
			break;	
		}
		}
	}
}


//ex6

//file1

class Rectangle2
{
	int height;
	int horizontal;
	int vertical;
}


//file2


import java.util.Scanner;

class Total
{
	public static void main(String[] args) 
	{
		Rectangle2 total = new Rectangle2();
		Scanner sc = new Scanner(System.in);

		int choice;

		while (true)
		{

		System.out.println("=================");
		System.out.println("1. 가로 등록");
		System.out.println("2. 세로 등록");
		System.out.println("3. 높이 등록");
		System.out.println("4. 부피 출력");
		System.out.println("=================");

		choice = sc.nextInt();

		switch (choice)
		{
		case 1:
			System.out.println("가로 길이 입력 : ");
			total.horizontal = sc.nextInt();
			break;
		case 2:
			System.out.println("세로 길이 입력 : ");
			total.vertical = sc.nextInt();
			break;
		case 3:
			System.out.println("높이 입력 : ");
			total.height = sc.nextInt();
			break;
		case 4:
			int total2 = total.horizontal*total.vertical*total.height;
			System.out.printf("부피 : %d입니다.\n",total2);
			break;		
		}

		}
	}
}
