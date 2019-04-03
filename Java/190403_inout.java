//ex1 next(), nextLine(); 오류에 대하여

import java.util.Scanner;

class NextLine
{
	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in);
    //1. Scanner sc2 = new Scanner(System.in); 전용 스캐너를 따로 만들어 해소함
		
    System.out.println("이름입력 : ");
		String name = sc.next(); //입력한 문자열의 앞을 삭제하는 오류가 발생
    //2. sc.nextLine();을 입력하여 오류를 해소함
    
		System.out.println("이름입력 : ");
		String name = sc.nextLine();

		System.out.println(name);
	}
}


//ex2 print(), println()

import java.util.Scanner;

class NextLine
{
	public static void main(String[] args) 
	{
		System.out.print("a"); //System.out.print(); 아무것도 적지 않으면 작동하지않음
		System.out.print("b"); //System.out.println(); 줄바꿈 기능을 사용할 수 있어 작동함
		System.out.print("c"); //출력은 acb계속하려면...\n을 추가하면 줄바꿈
	}//System.out.print("c\n");
} //System.out.println(); 기능을 적고 출력을 하면 출력후 줄바꿈이 작동함


//ex3 printf(); 한줄 출력 줄바꿈 없음
class NextLine
{//문장을 완성하고 무엇을 삽입하는 형태
	public static void main(String[] args) 
	{//s = string d = decimal %,d 를 사용하게 되면 세자리 마다 쉼표로 자릿수를 구분해줌
		System.out.printf("%s님 환영합니다.","홍길동");//,를 붙여가면서 요소를 추가할 수 있음
	}// 문장을 완성하고 기호를 통해서 완성한다
}//Scanner로 입력받은 값을 넣을 수 있음
//소수점은 %f = float로 표현 소수점은 이하 6자리 까지 출력 %.2f로 표시할 경우 소수점 이하 두자리 까지 출력
//0.016을 두자리수 까지 출력한다 했을때 0.02로 반올림 하여 출력함 0.014일경우 0.01로 출력
