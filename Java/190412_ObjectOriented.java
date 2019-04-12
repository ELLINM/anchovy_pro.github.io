//ex1

//file 1

class Human 
{
	String name;
	String id;
	String pw;
}

//file 2

import java.util.Scanner;

class ObjectTest2
{
	public static void main(String[] args) 
	{
		Human [] array = new Human[5];
		String id, pw, name;
		int counter = 0;
		int choice;
		Scanner sc = new Scanner(System.in);

		System.out.println("==============");
		System.out.println("1. 등록");
		System.out.println("2. 출력");
		System.out.println("==============");
		choice = sc.nextInt();

		switch (choice)
		{
		case 1:
			System.out.println("ID 입력 : ");
			id = sc.next();
			System.out.println("PW 입력 : ");
			pw = sc.next();
			System.out.println("이름 입력 : ");
			name = sc.next();

			Human h = new Human();
			h.id = id;
			h.pw = pw;
			h.name = name;
			array[counter++] = h;

			break;
		case 2:
			for (int i = 0; i < array.length; i++)
			{
				if (array[i] != null)
				{
					System.out.println("ID : " + array[i].id);
					System.out.println("PW : " + array[i].pw);
					System.out.println("이름 : " + array[i].name);
				}
			}
			break;
		}
	}
}


//ex2

//file 1

class Person2
{
	String name;
	String phone;
	int price;
}



//file 2

import java.util.Scanner;

class Theater
{
	public static void main(String[] args) 
	{
		Person2 [] array = new Person2[10];
		String name, phone;
		int price, choice, counter = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("=================");
		System.out.println("1. 예약 하기");
		System.out.println("2. 예약 전체보기");
		System.out.println("=================");
		choice = sc.nextInt();

		switch (choice)
		{
		case 1:
			System.out.println("이름을 입력 : ");
			name = sc.next();
			System.out.println("전화번호를 입력 : ");
			phone = sc.next();
			System.out.println("가격을 입력 : ");
			price = sc.nextInt();

			Person2 p = new Person2();
			p.name = name; //name은 입력받는 변수 h.name은 자료를 받게되는 변수
			p.phone = phone;
			p.price = price;

			array[counter++] = p; //0부터 늘어나기 때문에 후위 증가

			break;
		case 2:
			for (int i = 0; i < counter; i++)
			{
			System.out.println("**"+array[i].name+" "+array[i].phone+" "+array[i].price);
			}
			break;
		
		}

	}
}
