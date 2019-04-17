//ex1

import java.util.Scanner;

class Meat 
{
	public static void main(String[] args) 
	{
		String meat;
		int kg,tot;

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("고기 종류 입력(닭고기/돼지고기/소고기) : ");
		meat = sc.nextLine();

		System.out.println("무게입력 (kg) : ");
		kg = sc2.nextInt();

		switch (meat)
		{
		case "닭고기":
			tot = kg*3000;
		System.out.println("가격 : " + tot);
			break;
		case "돼지고기":
			tot = kg*5000;
		System.out.println("가격 : " + tot);
			break;		
		case "소고기":
			tot = kg*7000;
		System.out.println("가격 : " + tot);
			break;		
		default:
			System.out.println("다시 입력해 주세요");
		}
	}
}


//ex2


import java.util.Scanner;

class Meat
{
	public static void main(String[] args) 
	{	
		int chickenPerKg=3000,porkPerKg=5000,beefPerKg=7000; //입력받는 무게에 대한 연산 비용을 변수로 정장
		Scanner sc=new Scanner(System.in);
		int total=0, weight; // 총 가격을 입력받을 변수를 선언하고 초기화,
		String meatType,choice; //입력받는 문장에 대한 변수 선언
		boolean flag=true; //반복에 필요한 조건값을 선언
//입출력 구문들은 while 구문 안에서 작동하도록 한다.
		while(flag){ //flag는 true이기 때문에 계속 반복할 수 있도록 해줌
			// while문은 y와 n을 구분하여 출력하기 위함
		System.out.println("고기 종류를 입력(닭고기/돼지고기/소고기) : ");
		meatType=sc.nextLine();
		System.out.println("무게 입력(kg) : ");
		weight=sc.nextInt();

		switch(meatType){//구해야하는 값들을 분리하디 위해서 구분이 용이한 meatType으로 구분
		case "닭고기" :
				total+=chickenPerKg*weight; //total변수에 무게당 변수의 가격을 저장
			break;
		case "돼지고기" :
				total+=porkPerKg*weight;
			break;
		case "소고기" :
				total+=beefPerKg*weight;
			break;
		default :
			System.out.println("ERROR:고기종류를 재대로 입력 하세요.");
		}
		sc.nextLine();//위에서 입력받은 Line값이 중첩 되므로 한번더 입력하여 오류를 삭제해준다.
		System.out.println("계속 입력 하시겠습니까?(y/n)"); //y를 입력하게되면 true이기 때문에 다시 반복
		choice=sc.nextLine();//n,N을 제외한 모듭값을 입력하여도 가능
		
		switch(choice){//n은 false갑이면 여기서 멈추게됨
		case "n":
		case "N":
			flag=false; //flag를 false로 선언 하면서 while문이 끝나도록함
			break;
		}


		}
		
		System.out.printf("총 가격 : %,1d 원%n",total);//while문 내부에서 연산된 값들을 더하여 요구값을 
	}
}


//ex3


import java.util.Scanner;

class Basal1
{
	public static void main(String[] args) 
	{
		int kg, cm, age;
		double bmr;
		String sex;

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);

		System.out.println("몸무게 입력 : ");
		kg = sc.nextInt();

		System.out.println("키 입력 : ");
		cm = sc.nextInt();

		System.out.println("나이 입력 : ");
		age = sc.nextInt();

		System.out.println("성별 (남/여) 입력 : ");
		sex = sc1.nextLine();

		if (sex.equals("남"))
			{
			bmr = 66 + (13.8*kg) + (5*cm) - (6.8*age);
			System.out.println("기초대사량 (kcal) : " + bmr);
			}
		if (sex.equals("여"))
			{
			bmr = 655 + (9.6*kg) + (1.8*cm) - (4.7*age);
			System.out.println("기초대사량 (kcal) : " + bmr);
			}
		else
			{
			System.out.println("다시입력해주세요");
			}
	}
}


//ex4

import java.util.Scanner;

class Basal2
{
	public static void main(String[] args) 
	{
		int time;
		double burn;
		String sports;

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);

		System.out.println("운동 종목 입력 : ");
		sports = sc1.nextLine();

		System.out.println("운동 시간 입력 : ");
		time = sc.nextInt();

		switch (sports)
		{
		case "가볍게 걷기":
			burn = time*(90.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "빠르게 걷기":
			burn = time*(150.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "요가":
			burn = time*(75.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "볼링":
			burn = time*(99.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "스트레칭 체조":
			burn = time*(87.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "자전거 타기":
			burn = time*(132.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "등산":
			burn = time*(150.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "춤추기":
			burn = time*(144.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "승마":
			burn = time*(173.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "탁구":
			burn = time*(180.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "테니스":
			burn = time*(216.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "배드민턴":
			burn = time*(173.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "배구":
			burn = time*(210.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "축구":
			burn = time*(270.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "농구":
			burn = time*(279.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "스키":
			burn = time*(246.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "에어로빅":
			burn = time*(177.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "팔굽혀 펴기":
			burn = time*(126.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "계단 오르내리기":
			burn = time*(174.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "윗몸 일으키기":
			burn = time*(303.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "핸드볼":
			burn = time*(300.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "줄넘기":
			burn = time*(312.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "격렬한 달리기":
			burn = time*(315.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		case "수영":
			burn = time*(369.0/30);
		System.out.println("소모한 칼로리 : " + burn + "kcal");
			break;
		}
	}
}


//ex5 너무 노가다인데 줄일 방법이 

import java.util.Scanner;

class Basal3
{
	public static void main(String[] args) 
	{
		int kg, cm, age,time,kcal;
		double bmr,burn,sur;
		String sex, sports;

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);

		System.out.println("몸무게 입력 : ");
		kg = sc.nextInt();

		System.out.println("키 입력 : ");
		cm = sc.nextInt();

		System.out.println("나이 입력 : ");
		age = sc.nextInt();

		System.out.println("성별 (남/여) 입력 : ");
		sex = sc1.nextLine();		
		
		System.out.println("운동 종목 입력 : ");
		sports = sc2.nextLine();

		System.out.println("운동 시간 입력 : ");
		time = sc.nextInt();

		System.out.println("섭취 칼로리 : ");
		kcal = sc.nextInt();

		if (sex.equals("남"))
			{
			bmr = 66 + (13.8*kg) + (5*cm) - (6.8*age);
			switch (sports)
				{
				case "가볍게 걷기":
					burn = time*(90.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "빠르게 걷기":
					burn = time*(150.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "요가":
					burn = time*(75.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "볼링":
					burn = time*(99.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "스트레칭 체조":
					burn = time*(87.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "자전거 타기":
					burn = time*(132.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "등산":
					burn = time*(150.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "춤추기":
					burn = time*(144.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "승마":
					burn = time*(173.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "탁구":
					burn = time*(180.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "테니스":
					burn = time*(216.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "배드민턴":
					burn = time*(173.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "배구":
					burn = time*(210.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "축구":
					burn = time*(270.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "농구":
					burn = time*(279.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "스키":
					burn = time*(246.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "에어로빅":
					burn = time*(177.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "팔굽혀 펴기":
					burn = time*(126.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "계단 오르내리기":
					burn = time*(174.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "윗몸 일으키기":
					burn = time*(303.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "핸드볼":
					burn = time*(300.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "줄넘기":
					burn = time*(312.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "격렬한 달리기":
					burn = time*(315.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "수영":
					burn = time*(369.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				}
			}
		if (sex.equals("여"))
			{
			bmr = 655 + (9.6*kg) + (1.8*cm) - (4.7*age);
			switch (sports)
				{
				case "가볍게 걷기":
					burn = time*(90.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "빠르게 걷기":
					burn = time*(150.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "요가":
					burn = time*(75.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "볼링":
					burn = time*(99.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "스트레칭 체조":
					burn = time*(87.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "자전거 타기":
					burn = time*(132.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "등산":
					burn = time*(150.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "춤추기":
					burn = time*(144.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "승마":
					burn = time*(173.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "탁구":
					burn = time*(180.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "테니스":
					burn = time*(216.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "배드민턴":
					burn = time*(173.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "배구":
					burn = time*(210.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "축구":
					burn = time*(270.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "농구":
					burn = time*(279.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "스키":
					burn = time*(246.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "에어로빅":
					burn = time*(177.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "팔굽혀 펴기":
					burn = time*(126.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "계단 오르내리기":
					burn = time*(174.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "윗몸 일으키기":
					burn = time*(303.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "핸드볼":
					burn = time*(300.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "줄넘기":
					burn = time*(312.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "격렬한 달리기":
					burn = time*(315.0/30);
				sur = kcal - (bmr+burn);
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				case "수영":
					burn = time*(369.0/30);
				sur = kcal - (bmr+burn);	
				System.out.printf("하루에%.2f kg찝니다.",(sur/7700));
				break;
				}
			}
	}
}
