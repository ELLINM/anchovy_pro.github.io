//file VO

class Human
{
	private String name;//vo생성
	private String ssn;

	public Human()//기본 생성자
	{
	}

	public Human(String name, String ssn) //Method 선언
	{
		this.name = name; //Instance Field임을 선언
		this.ssn = ssn;
	}

	public String getName() //name에 입력받을 변수 생성
	{
		return name;//name 값을 반환함
	}

	public String getSsn()
	{
		return ssn;
	}

	public void setName(String name) //name 값을 받고 반환하지 않음
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
			mainMenu(); //하단에 생성한 mainMenu를 불러옴
			choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				System.out.println("이름 입력 : ");
				name = sc.next();

				System.out.println("주민번호 입력 : ");
				ssn = sc.next();

				Human h = new Human(name, ssn); // Human Class의 name과 ssn을 h로 생성
				
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
	private Human [] hArray = new Human[10000]; //Human Class를 배열로 생성함
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
