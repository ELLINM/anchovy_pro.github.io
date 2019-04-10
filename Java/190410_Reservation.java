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

//teacher
import java.util.Scanner;

class ArrayTest
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String [] seats=new String [10];
		String name;
		boolean flag=true;
		int choice,seatNum;	

		while(flag){
			
			System.out.println("==============");
			System.out.println("1.좌석예약");
			System.out.println("2.좌석예약취소");
			System.out.println("3.좌석정보보기");
			System.out.println("4.좌석전체정보보기");
			System.out.println("5.좌석초기화");
			System.out.println("6.프로그램종료");
			System.out.println("==============");
			choice=sc.nextInt();
			switch(choice){
			case 1:

				for(int i=0;i<seats.length;i++){
					if(seats[i]==null){
						System.out.print("[ ]" );
					}else{
						System.out.print("[O]" );
					}
				}
				System.out.println();
				System.out.println("예약할 사람의 이름을 입력 : ");
				name=sc.next();
				System.out.println("예약할 좌석번호 입력 (1~"+seats.length+")");
				seatNum=sc.nextInt();

				if(seats[seatNum-1]==null){
					seats[seatNum-1]=name;
				}else{
					System.out.println("이미 예약이 되어 있습니다.");
					System.out.println(seats[seatNum-1]);
				}
				break;
			case 2:


				for(int i=0;i<seats.length;i++){
					if(seats[i]==null){
						System.out.print("[ ]" );
					}else{
						System.out.print("[O]" );
					}
				}

				System.out.println();
				System.out.println("취소할 좌석번호 입력 (1~"+seats.length+")");
				seatNum=sc.nextInt();

				if(seats[seatNum-1]==null){
					System.out.println("이미 비어 있습니다.");
				}else{
					seats[seatNum-1]=null;
					System.out.println("취소완료");
				}

				break;
			case 3:
				System.out.println("정보보기 할 좌석번호 입력 (1~"+seats.length+")");
				seatNum=sc.nextInt();
				
				if(seats[seatNum-1]==null){
					System.out.println("비어있는 좌석입니다.");
				}else{
					System.out.println("예약자 이름 : "+seats[seatNum-1]);
				}

				break;
			case 4:

				for(int i=0;i<seats.length;i++){
					if(seats[i]==null){
						System.out.print("[ ]" );
					}else{
						System.out.print("[O]" );
					}
				}
				System.out.println();

			
				break;
			case 5:
				for(int i=0;i<seats.length;i++){
					seats[i]=null;
				}
				System.out.println("좌석 초기화 완료");
				break;
			case 6:
				flag=false;
				break;
			
			}

		}
		
	}
}
