class Example
{
	public static void main(String [] args){

	String ex = "가나";

	System.out.println(ex);

	}
}


import java.util.Scanner;

class Example2
{
	public static void main(String [] args){

		int number;//실수 또는 문자를 입력받기 위해서는 자료형을 변경하면 된다. double number or String str

		Scanner sc = new Scanner(System.in);
    
    System.out.println("정수를 입력하세요 : ");
		number = sc.nextInt();//키보드로 부터 정수 입력받기

		System.out.println(number);

	}
}

import java.util.Scanner;

class Example3
{
	public static void main(String [] args){
		
		int rect;
		int result;

		Scanner sc = new Scanner(System.in);

		System.out.println("정사각형 한변의 길이를 입력하세요 : ");
		rect = sc.nextInt();
		resurt = rect*rect;

		System.out.println("정사각형의 넓이는 : " + result + "제곱센치입니다.");

	}
}


import java.util.Scanner;

class Square
{
	public static void main(String [] args){
		
		int width;
		int column;
		int result;

		Scanner sq = new Scanner(System.in);

		System.out.println("사각형의 가로길이를 입력하십시오 : ");
		width = sq.nextInt();

		System.out.println("사각형의 세로길이를 입력하십시오 : ");
		column = sq.nextInt();

		result = width*column;
		System.out.println("사각형의 넓이는 : " + result + "제곱센티입니다.");

	}
}
