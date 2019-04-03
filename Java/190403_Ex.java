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

class Meat3
{
	public static void main(String[] args) 
	{
		String meat,yn;
		int kg,tot=0;

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("고기 종류 입력(닭고기/돼지고기/소고기) : ");
		meat = sc.nextLine();

		System.out.println("무게입력 (kg) : ");
		kg = sc2.nextInt();

		System.out.println("계속 입력하시겠습니까?(y/n)");
		yn = sc.nextLine();

		while (yn.equals("y"))
		{
			System.out.println("고기 종류 입력(닭고기/돼지고기/소고기) : ");
			meat = sc.nextLine();
			
			System.out.println("무게입력 (kg) : ");
			kg = sc2.nextInt();
			
			System.out.println("계속 입력하시겠습니까?(y/n)");
			yn = sc.nextLine();

			if (yn.equals("n"))
			{
				switch (meat)
				{
				case "닭고기":
					tot = kg*3000;
				case "돼지고기":
					tot += kg*5000;
				case "소고기":
					tot += kg*7000;
				}
				System.out.println("총 가격 : " + tot);
				break;
			}
		}
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
