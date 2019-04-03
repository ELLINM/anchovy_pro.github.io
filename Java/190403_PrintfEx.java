//ex1
import java.util.Scanner;

class  Avg
{
	public static void main(String[] args) 
	{
		int num;
		String name,test;

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		System.out.print("이름 : ");
		name = sc2.nextLine();

		System.out.print("시험 종류(시험/재시험) : ");
		test = sc2.nextLine();
		
		System.out.println("점수를 입력하세요 : ");
		num = sc.nextInt();
		
		switch (test)
		{
			case "시험": //switch에서 string으로 구분이 
				if (num>=70)
				{
				System.out.printf("%s님은 합격입니다",name);
				}else{
					System.out.printf("%s님은 불합격입니다.",name);
				}
				break;
			case "재시험":
				if (num>=75)
				{
				System.out.printf("%s님은 합격입니다",name);
				}else{
					System.out.printf("%s님은 불합격입니다.",name);
				break;
				}
		}
	}
}


//ex2
import java.util.Scanner;

class AvgNum
{
	public static void main(String[] args) 
	{
		int tot = 0, num;
		//for문에서 입력값을 저장해주기 위해 변수를 초기화 해준다.
		Scanner sc = new Scanner(System.in);

		System.out.println("몇과목의 점수를 계산하겠습니까?");
		num = sc.nextInt();

		for (int i = 1; i<=num; i++) //새로운 변수를 만들어 범위를 지정해 주자
		{//i는 1부터 입력받은 과목의 수까지 증가한다.
			System.out.printf("%d번째 과목 점수 입력 : ",i);
			//1부터 i까지 차례대로 출력 출력후 입력 다시 출력 반복 num까지
			tot += sc.nextInt(); //+=로 입력받은 값은 변수에 저장
		}
		System.out.println("평균 점수 : " + (tot/(double)num));
	}
}


//ex3

import java.util.Scanner;

class Fish
{
	public static void main(String[] args) 
	{
		String kind;
		int cm, g;

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("어종 입력 : ");
		kind = sc.nextLine();

		System.out.println("무게 입력 : ");
		g = sc.nextInt();

		System.out.println("길이 입력 : ");
		cm = sc.nextInt();

		switch (kind)
		{
		case ("배스"):
			System.out.println("가져갈수 있습니다.");
			break;
		case ("가물치"):
			if (g<=200)
			{
			System.out.println("가져갈수 없습니다.");
			}else{
				System.out.println("가져갈수 있습니다.");
			}
			break;
		case ("잉어"):
			if (g<=150||cm<=10)
			{
			System.out.println("가져갈수 없습니다.");
			}else{
				System.out.println("가져갈수 있습니다.");
			}
			break;
		case ("쏘가리"):
			System.out.println("가져갈수 습니다.");
			break;
		case ("꺽치"):
			if (cm>=10)
			{
			System.out.println("가져갈수 없습니다.");
			}else{
				System.out.println("가져갈수 있습니다.");
			}
			break;
		default:
			System.out.println("가져갈수 있습니다.");
		}
	}
}


//ex4

import java.util.Scanner;

class Prime
{
	public static void main(String[] args) 
	{
		int num,counter = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력 : ");
		num = sc.nextInt();

		if (num==1||num==2) //1과 2는 예외
		{
			System.out.println("소수입니다.");
		}
		else{
			for (int i = 1; i<=num; i++) //i는 num보다 작거나 같을때까지 증가
				{
				if (num%i==0) //소수가 아닌 수를 구하는 조건
					{
					counter++; //num값까지 증가
					}
				}
			if (counter == 2) //counter의 수가 2
			{
				System.out.println("소수입니다.");
			}else{
				System.out.println("소수가 아닙니다.");
			}
		}
	}
}
