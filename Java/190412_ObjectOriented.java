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
