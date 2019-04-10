//ex


import java.util.Scanner;

class Books
{
	public static void main(String[] args) 
	{
		String book;
		String [] books = new String [50];
		int counter = 0;

		Scanner sc = new Scanner(System.in);

		while (true)
		{
			System.out.println("책제목을 입력하세요 : ");
			book = sc.next();
			books [counter++] = book;

		for (int i = 0; i < books.length; i++)
		{
			if (books[i] != null)
			{
				System.out.print(books[i] + " ");
			}
		}
		System.out.println();
		}
	}
}
