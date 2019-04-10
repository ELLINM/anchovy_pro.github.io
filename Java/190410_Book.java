//ex

/*ex9 철수는 올해 50권의 책을 읽으려고한다. 읽은 책 제목을 입력하면 
String의 배열에 순차적으로 대입이 되며, 한 권 입력시, 한 번 전체 읽은 책 제목들이 출력이 된다. 
프로그램으로 구현하여라.(철수를 위한 프로그램 만들기)*/

//my answer
import java.util.Scanner;

class Books
{
	public static void main(String[] args) 
	{
		String book;
		String [] books = new String [50];
		//counter를 선언하는게 좋았다. 여러 시도중에 counter변수를 선언하기도 했으나 사용법이 잘못되었다.

		Scanner sc = new Scanner(System.in);

		while (true)
		{
			System.out.println("책제목을 입력하세요 : ");
			book = sc.next();
//책 제목을 입력받는 것까지 수행 그러나 전체 출력을 못함 
		for (int i = 0; i < 50; i++)
		{
			books[i] = book; // book변수 대입 대신 counter를 증가시키며 받는다. for문 밖으로 뺄것
			if (books[i] == null) //!= 를 통해 null값이 아닐경우 카운터를 증가시키는것으로 한다.
			{
				System.out.print(" ");
			}
			else //else부분을 제거하고 if에서 책리스트를 출력 하도록 한다.
			{
				System.out.println("[" + books[i] + "]");
			}
		}
		}
	}
}

//teacher
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
