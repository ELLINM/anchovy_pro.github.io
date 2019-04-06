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
