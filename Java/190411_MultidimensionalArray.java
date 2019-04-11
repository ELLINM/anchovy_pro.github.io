//ex1

class MultidimensionalArray
{
	public static void main(String[] args) 
	{
		int [][] array = new int [4][4]; //2차원

		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}


import java.util.Scanner;

class MultidimensionalArray
{
	public static void main(String[] args) 
	{
		int row, col;
		String [][] array = new String [5][5]; //2차원
		Scanner sc = new Scanner(System.in);

		System.out.println("행을 입력하세요 : (0~4)");
		row = sc.nextInt();

		System.out.println("열을 입력하세요 : (0~4)");
		col = sc.nextInt();

		array[row][col] = "*";

		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (array[i][j] != null)
				{
					System.out.print("[" + array[i][j] + "]");
				}else{
				System.out.print("[ ]");
				}
			}
			System.out.println();
		}
	}
}
