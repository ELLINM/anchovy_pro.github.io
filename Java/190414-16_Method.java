//ex1


public class Method1
{
  public static void main(String[] args) //mainMethod에서 부터 프로그램이 실행
  {
    addHap2(1, 2); //addHap2( )Method를 호출 메소드 호출구문을 보면 1과 2를 인수로 가짐
    addHap2(3, 4); //addHap2( )Method를 한번더 호출

    int hap = addHap(1 ,2);  //addHap2( )Method를 한번더 실행하고 난뒤 이번엔 addHap( )Method를 호출

    System.out.println(hap);
  }

    int  addHap (int a, int b) //int a와 int b를 인수로 받으며 int형의 반환값
    {
	    int hap = a + b;
	    return hap; //int hap이라는 변수를 선언하고 리턴값을 hap이라는 변수에 받아내는 것
    } 
	void addHap2 (int a, int b)  //addHap2( )Method의 구현부를 보면 int a와 int b를 인수로 받으며 반환값이 없다
	{
		int hap  =  a  +  b;  //addHap2( )Method는 1과 2를 인수로 받아 그 합을 구하고 합을 출력
		System.out.println(a+" 와 "+b+"의 합은" + hap + "입니다."); //리턴값을 받은 hap을 프린트
	} 
}


// ex2


public class Method1 
{
	int a; //Method1 클래스의 객체변수로 선언

	public void vartest(Method1 test) 
	{ //vartest Method는 다음과 같이 Method1클래스의 객체를 입력받아 해당 객체의 객체변수 a의 값을 1만큼 증가시키는 역할
		test.a++;
	}

	public static void main(String[] args)
	{ //main Method에서는 vartest Method에 1이라는 값을 전달하던것을 Method1클래스의 객체인 myTest를 넘김
		Method1 myTest = new Method1(); 
		myTest.a = 1;
		myTest.vartest(myTest);
		System.out.println(myTest.a);
	}//myTest객체의 객체변수 a의 값이 원래는 1이었는데 vartest  Method 실행 후 1만큼 증가되어 2라는 값이 출력
}
/* vartest메소드의 입력 파라미터가 값이 아닌 Method1클래스의 객체라는데 있다. 
이렇게 Method가 객체를 전달 받으면 Method 내의 객체는 전달받은 객체 그 자체로 수행된다. 
따라서 입력으로 전달받은 myTest 객체의 객체변수 a의 값이 증가하게 되는 것이다.
Method의 입력항목이 값인지 객체인지를 구별하는 기준은 입력항목의 자료형이 primitive 자료형인지 아닌지에 따라 나뉜다. 
int 자료형과 같은 primitive 자료형인 경우 값이 전달되는 것이고 그 이외의 경우(reference 자료형)는 객체가 전달된다.*/


//ex3 들어오는 값이 있고 나가는 값이 있는 Method

//file 1
class Method1 
{
	public int plusFour(int num) //나가는 값의 Data Type
	{
		int result = num + 4;//Method의 몸통

		return result; //결과를 반환
	}
}

//file 2
import java.util.Scanner;

class Method2
{
	public static void main(String[] args) 
	{
		Method1 me = new Method1(); //Scanner를 통하여 입력 받을 수있음
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		int numResult = me.plusFour(input);
		//반듯이 괄호를 열고 닫아줘야함 호출한다.
		//출력방법은 담아줄 변수를 설정하는 법과, 직접 출력하는법
		System.out.println(numResult);
	}
}


//ex4 

//file 1
class Person3
{ // 필드는 가장위에 작성
	private String name;
	private int age;
	// 속성이 2개이기 때문에 최소 4개의 Method가 필요
	//getter와 setter 각각 2개씩

	public String getName()//get은 getter만 사용
	{
		return name;
	}

	public void setName(String newName)//void는 return값이 없다.
	{
		name = newName;
	}
	
	public int getAge()
	{
		return age;
	}

	public void setAge(int newAge)
	{
		age = newAge;
	}
}

//file 2
import java.util.Scanner;

class Person4
{
	public static void main(String[] args) 
	{
		Person3 p = new Person3();

		p.setName("홍길동"); //Person3에있는  setName에 String을 대입한다.
		String name = p.getName(); //name을 getName에서 갖고온다.
		System.out.println(name); //name을 출력
		
		p.setAge(45);
		int age = p.getAge();
		System.out.println(age);
	}
}


//ex5


class Person3
{
	private String name;
	private int age;

	public String getName()
	{
		return name;
	}

	public void setName(String newName)
	{
		name = newName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int newAge)
	{
		age = newAge;
	}

	public void print()
	{
		System.out.println("이름 : " + name + " 나이 : " + age);
	} //출력만 하는 Method 
}

//file 2
import java.util.Scanner;

class Person4
{
	public static void main(String[] args) 
	{
		Person3 p = new Person3();

		p.setName("홍길동");
		p.setAge(45);
		p.print();

	}
}


//ex6


//file 1

class Animal 
{
	private String name;
	private String kind;
	private int age;

	public String getName()
	{
		return name;
	}
	public void setName(String newName)
	{
		name = newName;
	}
	public String getKind()
	{
		return kind;
	}
	public void setKind(String newKind)
	{
		kind = newKind;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int newAge)
	{
		age = newAge;
	}
	public void print()
	{
		System.out.println("이름 : " + name + " 종류 : " + kind + " 나이 : " +  age);
	}
}

//file 2

import java.util.Scanner;

class Animal2 
{
	public static void main(String[] args) 
	{
		Animal [] array = new Animal [100];
		
		int age2, choice;
		int counter = 0;
		String name2, kind2;
		Scanner sc = new Scanner(System.in);

		while (true)
		{
			System.out.println("============");
			System.out.println("1. 등록");
			System.out.println("2. 출력");
			System.out.println("============");
			choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				System.out.println("이름 입력 : ");
				name2 = sc.next();

				System.out.println("종류 입력 : ");
				kind2 = sc.next();

				System.out.println("나이 입력 : ");
				age2 = sc.nextInt();

				Animal ani = new Animal();

				ani.setName(name2);
				ani.setKind(kind2);
				ani.setAge(age2);
				
				array[counter++] = ani;
				break;
			case 2:
				for (int i = 0; i < counter; i++)
				{
				array[i].print();
				}
				break;
			}
		}
	}
}


//ex7

//file 1

class Todo 
{
	private String title;
	private String todo;

	public String getTitle()
	{
		return title;
	}
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}
	public String getTodo()
	{
		return todo;
	}
	public void setTodo(String newTodo)
	{
		todo = newTodo;
	}
	public void print()
	{
		System.out.println("제목 : " + title + " 내용 : " + todo);
	}

}

//file 2

import java.util.Scanner;

class Todo2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int choice, counter = 0;
		String title, todo;
		Todo [] array = new Todo [10];

		while (true)
		{
			System.out.println("============");
			System.out.println("1. 할일 등록");
			System.out.println("2. 출력");
			System.out.println("3. 초기화");
			System.out.println("============");
			choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				System.out.println("제목 : ");
				title = sc.next();

				System.out.println("할일 : ");
				todo = sc.next();

				Todo t = new Todo();

				t.setTitle(title);
				t.setTodo(todo);

				array[counter++] = t;
				break;
			case 2:
				for (int i = 0; i < counter; i++)
				{
				array[i].print();
				}
				break;
			case 3:
				for (int i = 0; i <  array.length; i++)
				{
					if (array[i] != null)
						{
						array[i] = null;
						counter = 0;
						}
		//배열에 null을 대입하게되면 내용이 Todo클래스가 아니게됨 때문에 그냥 null이되고 프린트를 하면 에러가 발생
				}
				break;			
			}
		}
	}
}


//ex8

//file 1

class Student2
{
	private String name;
	private int score;
	/*
	public Student (String name, int score)
	{
		this.name = name;
		this.score = score;
	}
	*/

	public String getName()
	{
		return name;
	}
	public void setName(String newName)
	{ //public void setName(String name)
		name = newName;
		//this.name = name;
	}
	public int score()
	{
		return score;
	}
	public void setScore(int newScore)
	{
		score = newScore;
	}
	public void print()
	{
		System.out.println("이름 : " + name + " 점수 : " + score);
	}
}

//file 2

import java.util.Scanner;

class Student3
{
	public static void main(String[] args) 
	{
		String name;
		int score, choice, counter = 0, sum = 0;
		double avg;
		Scanner sc = new Scanner(System.in);

		Student2 [] array = new Student2 [50];

		while (true)
		{
			System.out.println("==================");
			System.out.println("1. 학생 등록");
			System.out.println("2. 전체 출력");
			System.out.println("3. 학생 평균 출력");
			System.out.println("==================");
			choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				System.out.println("이름 입력 : ");
				name = sc.next();

				System.out.println("점수 입력 : ");
				score = sc.nextInt();

				Student2 s = new Student2();
				/*Student2 s = new Student2(name, score); 굳이 setter를 만들어줄 필요가 없음
				Data Type의 순서를 맞춰줄것*/ 

				s.setName(name);
				s.setScore(score);
					
				sum += score;

				array[counter++] = s;
				break;
			case 2:
				for (int i = 0; i < counter; i++)
				{
				array[i].print();
				}
				break;
			case 3:
				avg = (double)sum/counter;
				System.out.printf("학급평균 점수는 %.2f 점 입니다.\n",avg);
				break;
			}
		}

	}
}


//ex9

//file 1

class Account
{
	private String owner;
	private String accNo;
	private int balance;

	public Account(){}

	public Account (String owner, String accNo, int balance)
	{
		this.owner = owner;
		this.accNo = accNo;
		this.balance = balance;
	}
	public String getOwner()
	{
		return owner;
	}
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	public String getAccNo()
	{
		return accNo;
	}
	public void setAccNo(String accNo)
	{
		this.accNo = accNo;
	}
	public int getBalance()
	{
		return balance;
	}
	public void setBalance(int balance)
	{
		this.balance = balance;
	}
	public void print()
	{
		System.out.print("예금주명 : " + owner + " 계좌 번호 : " + accNo + " 잔액 : " + balance);
	}
}

//file 2

import java.util.Scanner;

class Account2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String owner, accNo;
		int choice, balance, money, total, counter = 0;

		Account [] array = new Account [10000];

		while (true)
		{
			System.out.println("==============");
			System.out.println("1. 계좌 등록");
			System.out.println("2. 전체 출력");
			System.out.println("3. 입금");
			System.out.println("4. 출금");
			System.out.println("==============");
			choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				System.out.println("예금주 명을 입력 하세요");
				owner = sc.next();

				System.out.println("계좌번호를 입력 하세요");
				accNo = sc.next();

				System.out.println("금액을 입력 하세요");
				balance = sc.nextInt();

				array[counter++] = new Account(owner, accNo, balance);
				break;
			case 2:
				for (int i = 0; i < counter; i++)
				{
				array[i].print();
				}
				break;
			case 3:
				System.out.println("계좌번호 입력");
				accNo = sc.next();

				System.out.println("금액입력 입력");
				balance = sc.nextInt();

				for (int i = 0; i < counter; i++)
				{
					if (array[i].getAccNo().equals(accNo))
					{
						array[i].setBalance(array[i].getBalance()+balance);
					}
				}
				break;
			case 4:
				System.out.println("계좌번호 입력");
				accNo = sc.next();

				System.out.println("금액입력 입력");
				balance = sc.nextInt();

				for (int i = 0; i < counter; i++)
				{
					if (array[i].getAccNo().equals(accNo))
					{
						array[i].setBalance(array[i].getBalance()-balance);
					}
				}
				break;
			}
		}
	}
}

