//ex1

/*대학을 졸업하려면 최소 140학점을 이수해야한다. 이수한 학점중 전공은 70학점 이상이어야 하며, 교양과 일반은 
각각 30학점이거나 총점이 80학점 이상이어야 한다 이수한 학점을 각각 입력받아 졸업여부를 출력하여라.
예시)

전공 이수 학점 : 75
교양 이수 학점 : 70
일반 이수 학점 : 10
졸업가능*/

import java.util.Scanner;

class Graduate;
{
	public static void main(String[] args) 
	{
		int main, sub, nom, total;
		boolean result;

		Scanner cc = new Scanner(System.in);

		System.out.print("전공 이수 학점 : ");
		main = cc.nextInt();

		System.out.print("교양 이수 학점 : ");
		sub = cc.nextInt();

		System.out.print("일반 이수 학점 : ");
		nom = cc.nextInt();

		total = main + sub + nom;

		result = total>=140&&main>=70&&((sub>=30||nom>=30)&&sub+nom>=80);
		String t = result? "졸업 가능" : "졸업 불가능";

		System.out.println(t);
	}
}

//ex2
/*키보드로 정수를 입력 받아, 
1) 4와 5로 나누어 지는지, 
2) 4 또는 5로 나누어 지는지,
3) 나누어 진다면 어떤 수로 나누어 지는지
3가지를 알수 있도록 출력하시오.(난이도 하)
예시)정수 입력 : 16
4와 5로 나누어 지지 않습니다.
4또는 5로 나누어지고,
4로 나누어 집니다.

or

정수 입력 : 13

4와 5로 나누어 지지 않습니다.
4또는 5로 나누어지지 않습니다.

or

정수 입력 : 20

4와 5로 나누어 집니다.
4또는 5로 나누어 집니다.*/

import java.util.Scanner;

class TypeCasting2 
{
	public static void main(String[] args) 
	{
		int num;
		boolean result, result1, result2;

		Scanner cc = new Scanner(System.in);	
		
		System.out.print("정수 입력 : ");
		num = cc.nextInt();

		result = num%4==0&&num%5==0;
		String s = result? "나누어 집니다.":"나누어 지지않습니다.";

		result1 = num%4==0||num%5==0;
		String r = result1? "나누어 지고,":"나누어 지지 않고.";

		result2 = num%4==0;
		String t = result2? "나누어 집니다.":"나누어 지지 않습니다..";

		System.out.println("4와 5로" + s);
		System.out.println("4 또는 5로" + r);
		System.out.println("4로" + t);
	}
}

//ex3
/*키보드로 0 부터 999까지의 정수를 입력 받은수 각 자릿수의 합한 결과를 출력하는 프로그램을 만드시오.(난이도 중)
예시)
정수 입력 : 194
각자릿수의 합 : 14*/

import java.util.Scanner;

class TypeCasting3 
{
	public static void main(String[] args) 
	{
		int num;
		int sum;
		
		Scanner cc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		num = cc.nextInt();

		sum = (num%10)+((num/10)%10)+((num/110)%10);

		System.out.println(sum);
	}
}



//ex4
/*년도와 월을 입력 받아 해당 월이 몇 일인지 출력하여라.(난이도 상)
(윤년도 계산하여 포함한다)
-서력 기원 연수가 4로 나누어떨어지는 해는 윤년으로 한다. (1992년, 1996년, 2004년....)
-서력 기원 연수가 4, 100으로 나누어떨어지는 해는 평년으로 한다. (1900년, 2100년....)
-서력 기원 연수가 4, 100, 400으로 나누어떨어지는 해는 윤년으로 둔다. (1600년, 2000년, 2400년)

예시)
년도 입력 : 2019
월 입력 : 3
해당 월은 31일 입니다.

or

년도 입력 : 2019
입력 : 2
해당 월은 28일 입니다.

or

년도 입력 : 2000
월 입력 : 2
해당 월은 29일 입니다.*/
