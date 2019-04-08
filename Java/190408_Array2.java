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
		String name; //입력받을 이름의 변수 선언
		int seat; //입력받을 좌석의 변수 선언
		String [] array = new String [10]; //좌석 10개 배열선언

		Scanner sc = new Scanner(System.in);

		System.out.println("==========좌석============");
		
		for (int i = 0; i<10; i++) //좌석은 총 10개이기 때문에 0부터 9까지 범위 설정
		{
			if (array[i]==null) //각 좌석을 순서대로 지정하고 null값이 들어올경우 공백으로 출력
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
		for(int i=0;i<10;i++){ //배열로 지정된 좌석에 입력 번호 대신 이름으로 출력
			if(array[i]==null){
			System.out.print("[    ]");
			}else{
			System.out.print("["+array[i]+"]");
			}
		}

		System.out.println();

	}
}
