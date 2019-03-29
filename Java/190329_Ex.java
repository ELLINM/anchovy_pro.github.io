//ex1
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

class Cir
{
	public static void main(String[] args) 
	{
		int x;
		Scanner sc = new Scanner(System.in);

		System.out.println("정수 입력 : ");
		x = sc.nextInt();

		if (x%4==0&&x%5==0){
			System.out.println("4 와 5로 나누어집니다.");
		}
		else if (x%4==0||x%5==0){
			System.out.println("4또는 5로 나누어 집니다.");
			System.out.print(x%4==0? "4로 나누어 집니다":"");
			System.out.println(x%5==0? "5로 나누어 집니다.":"");
		}
		else{
			System.out.print("나누어 지지 않습니다.");
		}
	}
}
