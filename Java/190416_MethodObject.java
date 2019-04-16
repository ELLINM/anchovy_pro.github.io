//ex1

//file 1

class BankAccount
{
	private String name;
	private String accNo;
	private int balance;

	public BankAccount(){}
	public BankAccount(String name, String accNo, int balance){
		this.name=name;
		this.accNo=accNo;
		this.balance=balance;
	}

	public String getName(){
		return name;

	}
	public String getAccNo(){
		return accNo;
	}
	public int getBalance(){
		return balance;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setAccNo(String accNo){
		this.accNo=accNo;
	}
	public void setBalance(int balance){
		this.balance=balance;
	}
	public void print(){
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

		while(true){
			System.out.println("==============");
			System.out.println("1.계좌등록");
			System.out.println("2.전체출력");
			System.out.println("3.입금");
			System.out.println("4.출금");
			System.out.println("==============");
			choice=sc.nextInt();

			switch(choice){
			case 1:
				System.out.println("이름 입력 : ");
				name=sc.next();
				System.out.println("계좌번호입력 : ");
				accNo=sc.next();
				System.out.println("잔고 입력 : ");
				balance=sc.nextInt();

                bm.insertBank(new BankAccount(name,accNo,balance));
				
				break;
			case 2:
				bm.printAll();
				break;
			case 3:
				System.out.println("계좌입력 : ");
				accNo=sc.next();
				System.out.println("금액 입력 : ");
				balance=sc.nextInt();

				bm.deposit(accNo,balance);

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
	
	public void insertBank(BankAccount acc){//계좌등록
		ba[counter++]=acc;
	}

	public void printAll(){//전체출력
		for(int i=0;i<counter;i++){
			ba[i].print();
		}
	}

	public void deposit(String accNo,int balance){//입금
		for(int i=0;i<counter;i++){
					
				if(ba[i].getAccNo().equals(accNo)){
					ba[i].setBalance(ba[i].getBalance()+balance);
				}

		}	
	}

	public void withdrawl(String accNo,int balance){//출금
		for(int i=0;i<counter;i++){
					
				if(ba[i].getAccNo().equals(accNo)){
					ba[i].setBalance(ba[i].getBalance()-balance);
				}

		}	
	}
}
