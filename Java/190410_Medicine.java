D제약회사 제품 품질 관리에서는 1000개의 총 제품 수 중에 10개의 제품을 랜덤 샘플 품질 실험을 하여  
2개가 품질 불합격을 받는 다면 1000개의 제품을 모두 폐기 하고 있다. 
10개의 제품 품질 정보를 입력하여 모두 폐기할지, 납품할지 출력하는 프로그램을 만들어라. 프로세스는 반복 될 수 있다.

예시)

1번째 제품 품질 입력 (1.합격/2.불합격) : 1
2번째 제품 품질 입력 (1.합격/2.불합격) : 1
3번째 제품 품질 입력 (1.합격/2.불합격) : 1
4번째 제품 품질 입력 (1.합격/2.불합격) : 2
5번째 제품 품질 입력 (1.합격/2.불합격) : 1
6번째 제품 품질 입력 (1.합격/2.불합격) : 1
7번째 제품 품질 입력 (1.합격/2.불합격) : 1
8번째 제품 품질 입력 (1.합격/2.불합격) : 2
9번째 제품 품질 입력 (1.합격/2.불합격) : 1
10번째 제품 품질 입력 (1.합격/2.불합격) : 1
결과: 10개의 제품중 2개가 불합격입니다. 1000개 모두 폐기합니다.

1번째 제품 품질 입력 (1.합격/2.불합격) : 1
2번째 제품 품질 입력 (1.합격/2.불합격) : 1
3번째 제품 품질 입력 (1.합격/2.불합격) : 1
4번째 제품 품질 입력 (1.합격/2.불합격) : 1
5번째 제품 품질 입력 (1.합격/2.불합격) : 1
6번째 제품 품질 입력 (1.합격/2.불합격) : 1
7번째 제품 품질 입력 (1.합격/2.불합격) : 1
8번째 제품 품질 입력 (1.합격/2.불합격) : 2
9번째 제품 품질 입력 (1.합격/2.불합격) : 1
10번째 제품 품질 입력 (1.합격/2.불합격) : 1
결과: 10개의 제품중 1개가 불합격입니다. 납품 합니다.

배열로 푼다면 1000개의 index를 보유한 배열을 만들고 값을 입력받는다*/

//my answer

import java.util.Scanner;

class Medic
{
	public static void main(String[] args) 
	{
		int [] medic = new int [10];
		int counter = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < medic.length; i++)
		{
			System.out.printf("%d번째 제품 품질 입력 (1.합격/2.불합격) : ",i+1);
			medic[i] = sc.nextInt();

			if (medic[i] == 2)
			{
				counter++;
				if (counter >= 2)
				{
					System.out.printf("결과: 10개의 제품중 %d개가 불합격입니다. 1000개 모두 폐기합니다.",counter);
				}
				System.out.printf("결과: 10개의 제품중 %d개가 불합격입니다. 납품 합니다.",counter);
			}
		}
	}
}//입력을 받고 출력을 할 수 있으나 중간에 2를 입력할 경우 문구가 뜨면서 예시처럼 되지 않는다.


//teacher

import java.util.Scanner;

class ArrayTest
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int [] result=new int [10]; 
		
		while(true){

		int counter=0;//불합격 카운터 초기화 - 매 바퀴마다 0으로 초기화합니다.


		for(int i=0;i<result.length;i++){
				System.out.println((i+1)+"번째 제품 품질 입력 (1.합격/2.불합격) : ");
				result[i]=sc.nextInt();
		}

		for(int i=0;i<result.length;i++){ //불합격이 몇개인지 셉니다. 위의 for에서 세어도 상관없습니다.
				if(result[i]==2){
					counter++;
				}
		}

		if(counter>1){
			System.out.println("결과: 10개의 제품중 "+counter+"개가 불합격입니다. 1000개 모두 폐기합니다.");
		}else{
			System.out.println("결과: 10개의 제품중 "+counter+"개가 불합격입니다. 납품합니다.");
		}

		}
	}
}
