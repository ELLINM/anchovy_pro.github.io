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


//ex3

//file 1
class Customer 
{
	String name;
	String phone;
	String carNum;
	String place;
}


//file 2

import java.util.Scanner;

class Drive
{
	public static void main(String[] args) 
	{
		int choice, counter = 0;
		String name, phone, place, num;
		Customer [] reserve = new Customer [10000];
		Scanner sc = new Scanner(System.in);		
		
		while (true)
		{
			System.out.println("================");
			System.out.println("1. 예약");
			System.out.println("2. 조회");
			System.out.println("3. 전체 출력");
			System.out.println("================");
			choice = sc.nextInt();
			
			switch (choice)
			{
			case 1:
				System.out.println("이름 입력 : ");
				name = sc.next();

				System.out.println("핸드폰 번호 입력 : ");
				phone = sc.next();

				System.out.println("차량 번호 입력 : ");
				num = sc.next();

				System.out.println("장소 입력 : ");
				place = sc.next();

				boolean flag = true;
	
				Customer c = new Customer();
				c.name = name;
				c.phone = phone;
				c.carNum = num;
				c.place = place;

				reserve[counter++] = c;
				break;
			case 2:
				System.out.println("조회 위한 핸드폰 번호를 입력해 주세요");
				phone = sc.next();
				for (int i = 0; i < counter; i++)
				{
					if (reserve[i].phone.equals(phone))
						{
						flag = false; //한명이라도 같은 사람이 있으면
							System.out.println("==================");
							System.out.println("이름 : " + reserve[i].name);
							System.out.println("전화번호 :" + reserve[i].phone);
							System.out.println("차량번호 :" + reserve[i].carNum);
							System.out.println("예약장소 : " + reserve[i].place);
						}
				} //for문 안에서 결과를 전부 도출 해내지 말것
				if (flag)
				{ //같은 사람이 없으면 true이기 때문에
					System.out.println("검색결과가 없습니다.");
				}
				break;
			case 3:
				for (int i = 0; i < counter; i++)
				{
					System.out.println("==================");
					System.out.println("이름 : " + reserve[i].name);
					System.out.println("전화번호 :" + reserve[i].phone);
					System.out.println("차량번호 :" + reserve[i].carNum);
					System.out.println("예약장소 : " + reserve[i].place);
					}
				break;
			}
		}
	}
}


