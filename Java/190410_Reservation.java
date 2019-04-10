/*ex12
지금 까지 배운 것들을 합쳐 소극장 예약 프로그램을 매뉴화 시켜 만들어보자.
(배열과 switch를 사용한다.)
제일 먼저 사용자에게 메뉴를 보여준다.
================
1. 좌석 예약
2. 좌석 예약 취소
3. 좌석 정보 보기
4. 좌석 전체 
5. 좌석 초기화
6. 프로그램 종료
================

1. 좌석 예약 선택시 : 

1-1)먼저 좌석을 보여 준다.
[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] 

1-2)좌석 번호와 이름을 입력 받는다.
좌석 입력 : 1
예약자 이름 : 홍길동

2. 좌석 전체 출력 선택시 : 
[O] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] */

import java.util.Scanner;

class Movie
{
	public static void main(String[] args) 
	{
		int num, choice; //num = 좌석 번호 choice = 선택문항 
		String name; // 예약자 이름
		boolean flag = true; // while문을 반복시켜줌
		String [] seat = new String [10]; //좌석 배열

		Scanner sc = new Scanner(System.in);
		
		while (flag) //위 flag가 true이기 때문에 앞으로 전개될 switch문 처리후 선택지가 반복됨
		{
			System.out.println("================");
			System.out.println("1. 좌석 예약");
			System.out.println("2. 좌석 예약 취속");
			System.out.println("3. 좌석 정보 보기");
			System.out.println("4. 좌석 전체");
			System.out.println("5. 좌석 초기화");
			System.out.println("6. 프로그램 종료");
			System.out.println("================");
			choice = sc.nextInt();
			
			switch (choice)
				{
				case 1: // 예약하기
				for (int i = 0; i < seat.length; i++)
				{
				if (seat[i] == null) //좌석의 배열인 seat의 i번째 좌석에 기본값이라면
					{
						System.out.print("[ ]"); //공백을 출력
					}else{
						System.out.print("[o]");// 그렇지 않다면 o를 출력
					}
				}
				System.out.println(); //공백을 줌
				System.out.println("예약자 이름 입력 : "); // 예약을 위한 이름을 입력
				name = sc.next();
				System.out.println("예약할 좌석번호 입력 (1~"+seat.length+")"); //좌석 번호를 입력하여 배열에 대입
				num = sc.nextInt();

				if (seat[num - 1] == null) //보편적으로 좌석은 1번 부터이고 배열은 0부터 이기 때문에 -1
				{ // 그러한 배열의 값이 null이라면
					seat[num -1] = name; //입력한 좌석에 이름을 대입
				}else{
					System.out.println("이미 예약이 되어 있습니다."); //그렇지 않다면 이미 무언가 대입되어 있으므로
					System.out.println(seat[num - 1]);
				}
					break;
				case 2:// 예약 취소
					for (int i = 0; i < seat.length; i++) //예약과 마찬가지로 출력 예약된 좌석을 보기 위함
					{
						if (seat[i] == null)
						{
							System.out.print("[]");
						}else{
							System.out.print("[0]");
						}
					}

					System.out.println();
					System.out.println("취소할 좌석번호 입력 (1~"+seat.length+")"); // 취소하고 싶은 좌석을 입력
					num = sc.nextInt();

					if (seat[num - 1] == null) //이미 null이라면
					{
						System.out.println("이미 비어 있습니다.");					
					}else{
						seat[num - 1] = null; //무언가 값이 들어 있기 때문에 null을 대입해줌
						System.out.println("취소완료");
					}
					break;
				case 3: //예약 정보 확인
					System.out.println("정보보기 할 좌석번호 입력 (1~"+seat.length+")");
					num=sc.nextInt(); //좌석확인을 위한 번호 입력
				
					if(seat[num-1] == null) // 입력한 번호가 null인경우
					{
						System.out.println("비어있는 좌석입니다.");
					}else{
						System.out.println("예약자 이름 : "+ seat[num - 1]);
					} //값이 들어 있는 경우
					break;
				case 4: //좌석 전체 보기
					for(int i=0; i < seat.length; i++) //배열 전체출력을 통하여 출력
					{
						if(seat[i]==null) // 앞서와 같이 값이 들어있는 경우와 없는 경우를 전부 출력
						{
							System.out.print("[ ]" );
						}else{
							System.out.print("[O]" );
						}
					}
					System.out.println();
					break;
				case 5: //좌석 초기화
					for(int i=0; i < seat.length; i++)
					{
						seat[i]=null; //전부 null값을 대입
					}
					System.out.println("좌석 초기화 완료");
					break;
				case 6: //시스템 
					flag = false;
					break;
				}
		}
	}
}
