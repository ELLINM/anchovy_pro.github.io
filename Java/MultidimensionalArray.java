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
