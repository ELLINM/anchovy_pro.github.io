
//반쪽 삼각형 위로 오른쪽
class For1 
{
	public static void main(String[] args) 
	{		
		for (int i = 0; i < 5 ; i++) //i가 4까지 반복문을 실행 반복이 진행될 동안 *으 찍음 5에서 i가 반복할때 엔터 열할
		{
			for (int j = 0; j <= i; j++) //ex) i가 2일때는 j는 i와 같아지기 위해서 0,1,2 3번을 반복하기 때문에 ***이후 엔터
			{
				System.out.print("*"); 
			}
			System.out.println();
		}
	}
}


//반쪽 삼각형 위로 왼쪽
class For1 
{
	public static void main(String[] args) 
	{		
		for (int i = 0; i < 5 ; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				System.out.print((j<(4-i))? " ":"*");
			}/*i가 3일때 j는 5번 반복 => (j<(4-3)) =>  (j<1)이 조건이됨 0일때 
			true => 공백 => 1,2,3,4는 false이기 때문에 *로 찍히고 엔터*/
			System.out.println();
		}//i값이 커질수록 공백보다 별의 개수가 많아진다.
	}
}


//삼각형
class For1
{
	public static void main(String[] args) 
	{		
		for (int i = 0; i < 5 ; i++)
		{
			for (int j = 0; j < (5+i); j++) //j<(5+i) 반복문이 적용
			{
				System.out.print((j<(4-i))? " " : "*"); //j<(4-i)라는 조건으로 true이면 공백 false이면 별
			}/*ex) i가 2일때 j는 j<7이니 통 8번 반복하고 j<(2)? " " : "*" 가 되어 
			3번 공백후 5번 별을 찍는다*/
			System.out.println(" ");
		}
	}
}

//반쪽 삼각형 아래로 왼쪽
class For1
{
	public static void main(String[] args) 
	{		
		for (int i = 0; i < 5 ; i++)
		{
			for (int j = i; j < 5; j++)//j=i라고 주어졌다 => i가 커질수록 j도 커진다. => j<5때문에 반복문의 횟수가 짧아진다
			{//별이 줄어든다
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}


//반쪽 삼각형 아래로 오른쪽
class For1
{
	public static void main(String[] args) 
	{
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				System.out.print((j < i)? " " : "*");//j가 i보다 클때 별을 찍는다 i값이 커질수록 true의 결과가 더 많이 나옴
			}// 별이 줄어듬
			System.out.println();
		}
	}
}

	
//역삼각형
class For1
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < (9-i); j++) //9-i로 반복 횟수를 줄임
			{
				System.out.print((j < i)? " " : "*"); 
				//i값이 커질 수록 true가 많이 출력되게함
			}
			System.out.println();
		}
	}
}
	
	
//다이아몬드
class For1
{
	public static void main(String[] args)
	{
		for (int i = 0, j = 0; i < 9; i++) //총 10번 반복
		{
			for (int k = 0; k < j + 5; k++) 
	//j가 커질 수록 k의 반복 횟수가 많게 j가 적을 수록 k의 반복횟수가 적게
			{
				System.out.print((k < (4 - j))? " " : "*");
			}
			if (i < 4){
//if~else까지 i 값을 통해 j값을 조절하여 처음에 증가 i가 4를 넘어가게 되면 줄어듬
				j++;
			}else{
				j--;
			}
			System.out.println();
		}
	}
}
	
	
//모래시계
class For1
{
	public static void main(String[] args)
	{
		for (int i = 0, j = 0; i < 9; i++)
		{
			for (int k = 0, k < (9 - j); k++)//j가 커질 수록 반복 횟수가 적게
			{
				System.out.print((k < j)? " " : "*"); //k<j가 true = 공백 false = *
			}
			if (i < 4)
			{
				j++; //j가 적어질수록 두번째 for문의 반복수가 많아지기 때문에 반복수가 줄어들었다 많아진다.
			}else{
				j--;
			}
			System.out.println();
		}
	}
}
	

// 빈 삼각형

class For1 
{
	public static void main(String[] args) 
	{		
		 for (int i  = 0; i < 5; i++)
			 {
			 for (int j = 0; j < (5+i); j++)
				 {//삼각형 만드는 것과 동일
				 System.out.print((j==(4-i)||j==(4+i)||i==4)? "*" : " ");
			 }//조건식에서 삼각형에 테두리를 만족하는 조건들로 출력
			 System.out.println();
		 }
	}
}

	
	
