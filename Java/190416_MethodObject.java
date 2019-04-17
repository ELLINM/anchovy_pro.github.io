//ex1

//file 1

class BankAccount
{
	private String name;
	private String accNo;
	private int balance;

	public BankAccount(){}
	public BankAccount(String name, String accNo, int balance)
	{
		this.name=name;
		this.accNo=accNo;
		this.balance=balance;
	}

	public String getName() //getter => 연산에 
	{
		return name;

	}
	public String getAccNo()
	{
		return accNo;
	}
	public int getBalance()
	{
		return balance;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setAccNo(String accNo)
	{
		this.accNo=accNo;
	}
	public void setBalance(int balance)
	{
		this.balance=balance;
	}
	public void print()
	{
		System.out.println("계좌주 : "+name+" 계좌번호 : "+accNo+" 잔액 : "+balance);
	}
}

//file 2

import java.util.Scanner;

class Bank
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		BankManager bm=new BankManager();
		int choice, balance, counter=0;
		String name, accNo;
//기존의 배열이 BM으로 옮겨가면서 BM의 객체를 생성해줌
		while(true)
		{
			System.out.println("==============");
			System.out.println("1.계좌등록");
			System.out.println("2.전체출력");
			System.out.println("3.입금");
			System.out.println("4.출금");
			System.out.println("==============");
			choice=sc.nextInt();

			switch(choice)
			{
			case 1:
				System.out.println("이름 입력 : ");
				name=sc.next();
				System.out.println("계좌번호입력 : ");
				accNo=sc.next();
				System.out.println("잔고 입력 : ");
				balance=sc.nextInt();

                bm.insertBank(new BankAccount(name,accNo,balance));
		//BankAccount에 대입하기 위해 존재했던 구문이 BM으로 넘어갔기 때문에 BM으로 입력해주는 구문이 필요
				
				break;
			case 2:
				bm.printAll();
				break; // 출력구문도 BM에서 갖고온다.
			case 3:
				System.out.println("계좌입력 : ");
				accNo=sc.next();
				System.out.println("금액 입력 : ");
				balance=sc.nextInt();

				bm.deposit(accNo,balance); // 입금정보는 BM의 deposit으로 

				break;
			case 4:
				System.out.println("계좌입력 : ");
				accNo=sc.next();
				System.out.println("금액 입력 : ");
				balance=sc.nextInt();

				bm.withdrawl(accNo,balance);
				break;
			}
		}
	}
}

//file 3

class BankManager
{
	private BankAccount[] ba=new BankAccount[10000];
	private int counter=0;
	
	public void insertBank(BankAccount acc)
	{//계좌등록
		ba[counter++]=acc;
	} //사용자가 입력한 계좌를 BM을 거쳐 Vo로 등록

	public void printAll()
	{//전체출력
		for(int i=0;i<counter;i++)
		{
			ba[i].print();
		}
	}

	public void deposit(String accNo,int balance)
	{//입금
		for(int i=0;i<counter;i++) //Bank에서 받은 정보를 토대로 계좌 비교와 대입을 진행
		{
			if(ba[i].getAccNo().equals(accNo))
			{
				ba[i].setBalance(ba[i].getBalance()+balance);
			}
		}	
	}

	public void withdrawl(String accNo,int balance){//출금
		for(int i=0;i<counter;i++)
		{
			if(ba[i].getAccNo().equals(accNo))
			{
				ba[i].setBalance(ba[i].getBalance()-balance);
			}
		}	
	}
}
