//ex1


class Array2
{
	public static void main(String[] args) 
	{
		int [] array = new int [10];
	// 자료형  이름 메모리할당 데이터의 갯수
		array[0] = 15; //선택 
		
		for (int i = 0; i<10; i++)
		{
			System.out.println(array[i]); //배열 전체를 출력하기 위한 함수
		}
	}
}


//ex2


import java.util.Scanner;

class Array3 
{
	public static void main(String[] args) 
	{
		String name;
		int seat;
		String [] array = new String [10]; //좌석 10개 배열선언

		Scanner sc = new Scanner(System.in);

		System.out.println("==========좌석============");
		
		for (int i = 1; i<10; i++) 
		{
			if (array[i]==null)
			{
				System.out.print("[  ]");
			}else{
				System.out.println("[" + array[i] + "]"); //각 좌석 번호를 배열로 지정
				}
		}

		System.out.println("\n예약자 이름 : ");
		name = sc.next();

		System.out.println("좌석번호 (1~10) : ");
		seat = sc.nextInt();

		array[seat-1] = name; //좌석에 이름 예약, 배열은 0부터 시작하기 때문에 -1을 해준다.
		
		System.out.println("====================================");
		for(int i=0;i<10;i++){
			if(array[i]==null){
			System.out.print("[    ]");
			}else{
			System.out.print("["+array[i]+"]");
			}
		}

		System.out.println();

	}
}
