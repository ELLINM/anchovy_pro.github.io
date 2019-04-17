/* ex 한 반에 30명인 학급이 있다. 각 학생의 점수를 입력받아, 학급의 평균을 구하는 프로그램을 만드시오. 
매년 학생 수가 달라 질 수 있는데, 어떻게 하면 가장 적게 수고하여 매년 프로그램을 운영 할 수 있을지 고민하시오.*/

//my answer
import java.util.Scanner;

class ClassRoom
{
	public static void main(String[] args) 
	{
		int [] student = new int [30];
		int grade = 0, sum = 0;
		double avg = 0;

		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i <student.length; i++)
		{
			System.out.printf("%d번째 학생의 점수를 입력하세요 : \n", i+1);
			grade = sc.nextInt();
			student[i] = grade;
		}
		
		for (int i = 0; i <student.length; i++)
		{
			sum = sum + student[i];
		}
			avg = (double)sum/student.length;
		System.out.printf("학급평균 점수는 : %.2f 점 입니다.\n",avg);
	}
}
/*학급의 인원수만 조정해 주면 되기 때문에 배열의 크기만 바꿔가면서 해주면 된다.*/


//teacher

import java.util.Scanner;

class ArrayTest
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int students;
		double total=0,average;

		System.out.println("학급에 몇명이 있습니까?");
		
		int [] scores = new int [sc.nextInt()]; //stay hungry stay foolish
		
		for(int i=0;i<scores.length;i++){
			System.out.println((i+1)+"번째 학생의 점수를 입력 해주세요.");
			total+=sc.nextDouble();
		}

		average=total/scores.length;

		System.out.println(scores.length+"명의 평균 : "+average);

	}
}
