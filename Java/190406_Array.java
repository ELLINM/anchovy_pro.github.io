//ex1 Array의 선언과 생성

class ArrayTest
{
	public static void main(String[] args) 
	{
		int[] intArr = new int[5]; //Array의 선언과 Data의 개수까지 함께 생성
		intArr[0] = 11; // Array 0 은 11이라는 값을 대입
		intArr[1] = 22;
		intArr[2] = 33;
		intArr[3] = 44;
		intArr[4] = 55;
	}
}


//ex2 Array의 사용과 Length 속성


class ArrayTest
{
	public static void main(String[] args) 
	{
		int[] intArr = new int[5]; //int Type 의 Array 5개를 선언
		intArr[0] = 11; //3개의 변수에 값을 각각 대입하여 초기화
		intArr[1] = 22;
		intArr[2] = 33;

		System.out.println(intArr[0]); //총 5번에 걸쳐 테이터를 출력
		System.out.println(intArr[1]);
		System.out.println(intArr[2]);
		System.out.println(intArr[3]);// 아래 2개의 변수는 초기화 하지 않았기 때문에 기본값인 0으로 출력
		System.out.println(intArr[4]);
	}
} // Array를 사용할 때 Index는 정수 이므로 전체 Array의 Data를 출력하는 코드는 반복문으로 처리하는것이 좋다.


//ex3

class ArrayTest
{
	public static void main(String[] args) 
	{
		int[] intArr = new int[5];
		intArr[0] = 11;
		intArr[1] = 22;
		intArr[2] = 33;

		System.out.println("배열의 길이는" + intArr.length); //길이를 출력할때 5라는 상수값을 쓰지않고 ArrayName.length를 

		for (int i = 0; i < intArr.length; i++)
		{
			System.out.println(intArr[i]);
		}

	}
}


//ex 5 Array Initialization

// Array 선언
int[] iArray;
Human[] hArray;

//Array 생성
iArray = new int[10];
hArray = new Human[15];

//Array선언과 동시에 생성
String[] sArray = new String[20];

//Array Initialization
iArray[0] = 12;
sArray[1] = new String();
sArray[2] = "text";
hArray[1] = "new Human();
	
/*Array 선언, 생성, Initialization를 한번에
String[] sArray = {"a", "b", "c", "d", "e",};
Array의 길이가 5인 String Type Array인 sArray를 선언하면서 동시에 각원소들을 주어진 값으로 초기화*/

//ex 6


class Person
{
	int age;
	String name;
	
	// Array구성에 필요한 변수 선언
	
	public Person(int newAge, String newName)
	{ 
	//이후 사용하게될 Person Array의 요소들로 각각 선언해줌
		
		age = newAge;
		name = newName;		
	}

	public String printAll() 
	{ 
	//출력 형식 선언
		
		return "Person [age = " + age + ", name = " + name + "]";
	}
}

public class ArrayTest2 // Array 구성
{
	public static void main(String [] args)
	{ 
		//Person Array 선언 및 생성
		
		Person[] pArray = new Person[3];
		//각 Array의 방에 새로운 Person Object를 생성하여 Initialization
		
		pArray[0] = new Person(10, "Soft");
		pArray[1] = new Person(20, "Engineer");
		pArray[2] = new Person(30, "Society");
		
		/*pArray에는 각Index마다 요소들이 들어감
		Array의 Index를 이용하여 값을 참조할 수 있다.*/
		
		System.out.println(pArray[0].name + pArray[1].name + pArray[2].name);
		
		/*처음에는 각 배열의 이름들이 출력이 됨 SoftEngineerSociety 이후에 배열을 출력하게됨 
		Array의 length속성을 이용하여 Array를 순회할 수 있다.*/
		
		for (int i = 0; i < pArray.length; i++)
		{
		/*각 배열을 출력해 주기 위해서 반복문을 사용하여 출력
		Array의 길이는 3이기 때문에 0,1,2를 출력할 수 있음*/
			
			System.out.println(pArray[i].printAll());
		}
	}
}
