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
