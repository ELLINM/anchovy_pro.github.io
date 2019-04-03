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
			case "시험":
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
		double avg;
		Scanner sc = new Scanner(System.in);

		System.out.println("몇과목의 점수를 계산하겠습니까?");
		num = sc.nextInt();

		for (int i = 1; i<=num; i++)
		{
			System.out.printf("%d번째 과목 점수 입력 : ",i);
			tot += sc.nextInt();
		}
		System.out.println("평균 점수 : " + (tot/(double)num));
	}
}
