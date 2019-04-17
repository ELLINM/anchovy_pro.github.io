//file VO

class Human
{
	private String name;
	private String ssn;

	public Human()
	{
	}

	public Human(String name, String ssn)
	{
		this.name = name;
		this.ssn = ssn;
	}

	public String getName()
	{
		return name;
	}

	public String getSsn()
	{
		return ssn;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}

	public void print()
	{
		System.out.println("이름 : " + name + " 주민번호 : " + ssn);
	}
}

//file Main

class HumanMain 
{//HumanUI의 생성자만 호출하고 끝난다.
	public static void main(String[] args) 
	{
		new HumanUI(); //HumanUI생성자 호출
	}
}
//실행은 Main에서 진행

//file UI

import java.util.Scanner;

class HumanUI 
{
	private Scanner sc = new Scanner(System.in);
	private int choice;
	private String name, ssn;
	private boolean flag = true;
	private HumanManager hm = new HumanManager();//Manager객체

	public HumanUI() //생성자
	{
		while (flag)
		{
			mainMenu();
			choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				System.out.println("이름 입력 : ");
				name = sc.next();

				System.out.println("주민번호 입력 : ");
				ssn = sc.next();

				Human h = new Human(name,ssn);
				
				hm.insertHuman(h); //입력갑을 Manager의 배열에 넘겨줌
				break;
			case 2:
				hm.printAll();
				break;
			case 3:
				flag = false;
				break;			
			}
		}	
	}
	public void mainMenu()
	{
		System.out.println("================");
		System.out.println("1. 등록");
		System.out.println("2. 전체 출력");
		System.out.println("3. 종료");
		System.out.println("================");
	}

}

//file Manager

class HumanManager 
{
	private Human [] hArray = new Human[10000];
	private int counter = 0;
		//void의 위치는 return
	public void insertHuman(Human h) //등록 : 배열에 대입
	{ //Human h로 받아들임
		hArray[counter++] = h;
	} //입력을 어떻게 받을지 결정해야함

	public void printAll()
	{ //주고 받는 값이 없음
		for (int i = 0; i < counter; i++) //출력 : 배열의 내용을 출력
		{
			hArray[i].print();
		}
	}
}
