//ex
/*소극장에 10자리의 좌석이 있다.
이름과 몇번째 자리인지 입력 받아 화면에 출력하시오.
예시)
처음엔 빈자리를 보여준다.
============소극장============
[] [] [] [] [] [] [] [] [] []
이름입력:김철수
몇번째자리에 앉습니까? : 2
============소극장============
[] [김철수] [] [] [] [] [] [] [] []*/

import java.util.Scanner;

class Ex1 
{
	public static void main(String[] args) 
	{
		int seat;
		String name;

		Scanner sc = new Scanner(System.in);

		System.out.println("=========소극장==========\n[][][][][][][][][][]");
		
		System.out.print("이름 입력 : ");
		name = sc.nextLine();
		
		System.out.print("몇 번째 자리에 앉습니까? : ");
		seat = sc.nextInt();

		switch (seat)
		{
		case 1:
			System.out.println("=========소극장==========\n["+name+"][][][][][][][][][]");
			break;
		case 2:
			System.out.println("=========소극장==========\n[]["+name+"][][][][][][][][]");
			break;
		case 3:
			System.out.println("=========소극장==========\n[][]["+name+"][][][][][][][]");
			break;
		case 4:
			System.out.println("=========소극장==========\n[][][]["+name+"][][][][][][]");
			break;
		case 5:
			System.out.println("=========소극장==========\n[][][][]["+name+"][][][][][]");
			break;
		case 6:
			System.out.println("=========소극장==========\n[][][][][]["+name+"][][][][]");
			break;
		case 7:
			System.out.println("=========소극장==========\n[][][][][][]["+name+"][][][]");
			break;
		case 8:
			System.out.println("=========소극장==========\n[][][][][][][]["+name+"][][]");
			break;
		case 9:
			System.out.println("=========소극장==========\n[][][][][][][][]["+name+"][]");
			break;
		case 10:
			System.out.println("=========소극장==========\n[][][][][][][][][]["+name+"]");
			break;
		
		default:
			System.out.println("좌석을 제대로 입력해주세요");

		}

	}
}
