//ex1 영화관 예약 시스템을 만들고 중복되는 자리 입력시 예약좌석일 경우 다시 예약하게 할것

import java.util.Scanner;

class Reservation
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String name;
		int seatNum;
		String [] reservation = new String [10];
		//while문 안에 넣게 되면 반복하면서 초기화 된다.
		
		while (true)//반복시작
		{
			System.out.println("예약하시려는 분의 이름을 입력 : ");
			name = sc.next();

			System.out.println("예약좌석을 입력 (1~10) : ");
			seatNum = sc.nextInt();

			if (reservation[seatNum-1]==null)
			{
				reservation[seatNum-1] = name; //이 부분이 null인지 아닌지 확인
			}else{
				System.out.println("예약좌석입니다.");
			}

			for (int i = 0; i < reservation.length; i++) //length는 배열의 길이
			{
				if (reservation[i] != null)
				{
					System.out.print("[" + reservation[i] + "]");
				}else{
					System.out.print("[  ]");
				}
			}
		}
	}
}


//ex2 이가 100개인 int타입 배열에 정수 1~100를 순차적으로 대입하시오.

class Hundred
{
	public static void main(String[] args) 
	{
		int [] num = new int [100]; //배열을 선언

		for (int i = 0; i<num.length; i++)
		{
			num[i] = i + 1;
			System.out.println("[" + num[i] + "]"); //대입만 하면 되기 때문에 굳이 필요없음 확인용
		}
	}
}


//ex3 길이가 100개인 int타입 배열에 정수 짝수만 순차적으로 대입하시오.

class Hundred2
{
	public static void main(String[] args) 
	{
		int [] num = new int [100];

		for (int i = 0; i<num.length; i+=2)
		{
			num[i] = i + 2; // 정체 출력을 하면 짝수만 출력되지않음
			System.out.println("[" + num[i] + "]");
		}
		/*for (int i = 1; i<101; i++)
		{
			num[i-1) = i*2;
		}*/
	}
}


//ex4 피보나치 수열을 길이가 10인 int 타입의 배열에 순차적으로 대입하시오.


class Fibonacci
{
	public static void main(String[] args) 
	{
		int [] num = new int [10];
		
		num [0] = 1;
		num [1] = 1;

		for (int i = 2; i < num.length; i++)
		{
			num[i] = num[i-1] + num[i-2];
		}
		for (int i = 0; i < num.length; i++)
		{
			System.out.print("[" + num[i] + "]");
		}
	}
}
/*
import java.util.Scanner;

class ArrayTest 
{
	public static void main(String[] args) 
	{
		int [] array=new int[10];
		int a=1,b=1,temp=0;

		for(int i=0;i<10;i++){
			array[i]=a;

			temp=b;
			b=a+b;
			a=temp;
		}

		for(int i=0;i<10;i++){
			System.out.println(array[i]);
		}

		
	}
}*/


/*ex5 길이가 100개인 int타입 배열에 정수 1~100를 순차적으로 대입하시오. 
다만, 3의 배수라면 3333, 5의 배수라면 5555, 3과 5의 공배수라면 3535를 대입하시오.*/


class Hundred3
{
	public static void main(String[] args) 
	{
		int [] num = new int [100];

		for (int i = 0; i<num.length; i++)
		{
			num[i] = i + 1;
			if (num[i]%3==0&&num[i]%5==0)
			{
				num[i] = 3535;
			}
			else if (num[i]%5==0)
			{
				num[i] = 5555;
			}
			else if (num[i]%3==0)
			{
				num[i] = 3333;
			}
			else
			{
				num[i] = i+1;
			}
		}
		for (int i = 0; i < num.length; i++)
		{
			System.out.println(num[i]);
		}
	}
}

/*ex6 좌석번호가 1부터 100번인 콘서트장이 있다, 10개의 좌석이 한열이고, 10개의 열이 있다.
핸드폰번호와 좌석번호(행과 열)를 입력하여 예약받는 프로그램을 만드시오.
-전체 좌석 출력시 예약된 자리는 'ㅇ' 로 표시하고, 이미 예약된 자리를 예약하려고 하면, 이미 예약한 사람의 휴대폰 번호를 출력하시오.*/


import java.util.Scanner;

class Seat
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String phone;
        int row, col;
		String [] seats = new String [100];
		
		while (true)
		{
			System.out.println("예약자의 핸드폰 번호를 입력 : ");
			phone = sc.next();
			
			System.out.println("예약좌석을 입력 (1~10행) : ");
			row = sc.nextInt();
			
			System.out.println("예약좌석을 입력 (1~10열) : ");
			col = sc.nextInt();

		if (seats[(row-1)*10+(col-1)] == null) //예약확인
		{
			seats[(row-1)*10+(col-1)] = phone;
		}
		else
		{
			System.out.println("예약된 좌석입니다.");
			System.out.println(seats[(row-1)*10+(col-1)]);
		}

		for (int i = 0; i<100; i++)
		{
			if (seats[i] == null)
			{
				System.out.print("[]");
			}
			else
			{
				System.out.print("[o]");
			}
				
			if(((i+1)%10)==0)
			{
				System.out.println();
			}
		}
		}
	}
}
