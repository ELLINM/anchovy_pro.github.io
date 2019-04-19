//Client

class Client 
{
	private String name;
	private String csn;
	private double height;
	private double weight;

	public Client()
	{
	}
	public Client (String name, String csn, double height, double weight)
	{
		this.name = name;
		this.csn = csn;
		this.height = height;
		this.weight = weight;
	}
	public String getName()
	{
		return name;
	}
	public String getCsn()
	{
		return csn;
	}
	public double getHeight()
	{
		return height;
	}
	public double getWeight()
	{
		return weight;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setCsn(String csn)
	{
		this.csn = csn;
	}
	public void setHeight(double height)
	{
		this.height = height;
	}
	public void setWeight(double weight)
	{
		this.weight = weight;
	}
	public void print()
	{
		System.out.println("\n이름 : " + name + "\n등록번호 : " + csn + "\n키 : " + height + "\n몸무게 : " + weight);
	}
}

//Client Main

class ClientMain 
{
	public static void main(String [] args)
	{
		new ClientUI();
	}
}

//Client UI

import java.util.Scanner;

class ClientUI 
{
	private String name, csn;
	private double weight, height;
	Scanner sc = new Scanner(System.in);
	private ClientManager cm = new ClientManager();
	int choice;

	public ClientUI()
	{
		while (true)
		{
			mainMenu();
			choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				System.out.println("이름 입력 : ");
				name = sc.next();
				
				System.out.println("등록번호 입력 : ");
				csn = sc.next();

				System.out.println("키 입력 : ");
				height = sc.nextDouble();

				System.out.println("몸무게 입력 : ");
				weight = sc.nextDouble();

				Client c = new Client(name, csn, height, weight);

				cm.insertClient(c);
				break;
			case 2:
				cm.printAll();
				break;
			case 3:
				System.out.println(cm.clientBmi());
				break;
			case 4:
				System.out.println("등록번호 입력 : ");
				csn = sc.next();

				boolean f = cm.deleteClient(csn);
				// boolean 값으로 성공인지 아닌지 

				if (f)
				{
					System.out.println("삭제 성공");
				}
				else
				{
					System.out.println("삭제 실패 : 일치하는 회원 없음");
				}
				break;
			}
		}
	}
	public void mainMenu()
	{
		System.out.println("===================");
		System.out.println("1. 등록");
		System.out.println("2. 전체 출력");
		System.out.println("3. 고객별 BMI출력");
		System.out.println("4. 삭제");
		System.out.println("===================");
	}
}

//Client Manager

class ClientManager 
{
	private Client [] cArray = new Client[1000];
	private int count = 0;
	private double bmi;

	public void insertClient(Client c)
	{
		boolean flag = true; //등록 성공 실패 여부
		// 입력받아 배열에 넣기만 하면 되기 때문에 void사용
		for (int i = 0; i < count; i++)
		{//입력받은 값을 Client Vo값과 비교
			if (cArray[i].getCsn().equals(c.getCsn()))
			{
				flag = false; //같은 값이 있다면 false로 처리
			}
		}
		if (flag)
		{
			cArray[count++] = c; //같은 값이 없다면 
		}
	}
	public void printAll()
	{
		for (int i = 0; i <count; i++)
		{
			cArray[i].print();
		}
	}
	public String clientBmi()
	{// String으로 반환해주기 때문에 String으로 생성
		String result=""; //result 변수 생성과 초기화
		for (int i = 0; i < count; i++)
		{
			bmi = cArray[i].getWeight()/((cArray[i].getHeight()*0.01)*(cArray[i].getHeight()*0.01));
			//cArray[i]를 통해 Client Class에서 필요한 데이터를 갖고옴
			result+="이름 : "+cArray[i].getName()+" BMI : "+bmi+" \n";
		}
		return result; //UI로 반환해줄 result값
	}
	public boolean deleteClient(String csn) //UI에서 받아오는 입력값
	{
		boolean flag = false;
		
		for (int i = 0; i < count; i++)//i만큼 반복하며 확인
		{
			if (cArray[i].getCsn().equals(csn)) // 입력받은 csn값을 기존 등록 정보와 비교하여 같은 값이 있다면
			{
				for (int j = i; j < count-1; j++) 
				{// 해당 정보를 삭제하고 원래 값의 다음 입력되어있던 배열값으로 채워줌
					cArray[j] = cArray[j+1];
				}
				count--; //한개의 정보가 삭제되었기 때문에 전체 갯수를 하나 줄여준다.
				flag = true; //이 과정이 진행되었다면 true로 판정
			}
		}
		return flag; //UI에 반환해 
	}
}
