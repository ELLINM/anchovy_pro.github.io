//ex1
//정수를 입력 받아 0보다 미만이거나 999를 초과하는 수라면 "입력 오류!" 문구를 출력하시오.

import java.util.Scanner;

class Natural
{
	public static void main(String[] args) 
	{
		int num;
		boolean not;
		
		Scanner cc = new Scanner(System.in);
		
		System.out.println("숫자 입력 : ");
		num = cc.nextInt();

		not = num<0||num>999;

		String n = not? "입력 오류":"";;
		System.out.println(n);
	}
}


//ex2
/*실수령액= 기본급 + 시간수당 -세금(기본급의 10%), 시간수당=초과근무시간 X 15000 
기본급과 초과 근무 시간을 입력 받아, 실수령액을 구하시오*/

//ex3
//세가지 수를 입력 받아 세가지 수중에 가장 큰수를 출력하시오.
