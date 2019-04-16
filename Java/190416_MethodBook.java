//file 1

public class Book
{
	private String isbn;//도서번호
    private String title;//책 제목
    private String publisher;//출판사

	public Book(){}

	public Book(String isbn, String title, String publisher)
	{
		this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
    }
	public String getIsbn() 
	{
        return isbn;
    }
	public void setIsbn(String isbn) 
	{
        this.isbn = isbn;
    }
	public String getTitle() 
	{
        return title;
    }
	public void setTitle(String title) 
	{
        this.title = title;
    }
	public String getPublisher() 
	{
        return publisher;
    }
	public void setPublisher(String publisher) 
	{
        this.publisher = publisher;
    }
	public void print() 
	{
        System.out.println("번호: " + isbn + " 제목: " + title + " 출판사: " + publisher);
    }
	public void print2()
	{
		System.out.println("출판사 : " + publisher);
	}
	public void print3()
	{
		System.out.println("책제목 : " + title + " 출판사 : " + publisher);
	}
}

//file 2

import java.util.Scanner;

class BookService
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String title, publisher, isbn;
		int choice, counter = 0;
		BookManager bm = new BookManager();

		while (true)
		{
		System.out.println("=================");
		System.out.println("1. 책등록");
		System.out.println("2. 전체 출력");
		System.out.println("3. 출판사 출력");
		System.out.println("4. 도서번호 검색");
		System.out.println("=================");
		choice = sc.nextInt();

		switch (choice)
		{
		case 1:
			System.out.println("책제목 입력 : ");
			title = sc.next();

			System.out.println("출판사 입력 : ");
			publisher = sc.next();

			System.out.println("도서 번호 입력 : ");
			isbn = sc.next();

			bm.insertBook(new Book(isbn, title, publisher));

			break;
		case 2:
			bm.printAll();
			break;
		case 3:
			bm.publisherprint();
			break;
		case 4:
			bm.isbntest();
			break;
		}
		}
	}
}


//file 3

class BookManager 
{
	private Book [] book = new Book [1000];
	private int counter = 0;

	public void insertBook(Book bk)
	{
		book[counter++] = bk;
	}
	public void printAll()
	{
		for (int i = 0; i < counter; i++)
		{
			book[i].print();
		}
	}
	public void publisherprint()
	{
		for (int i = 0; i < counter; i++)
		{
			book[i].print2();
		}
	}
	public void isbntest()
	{
		for (int i = 0; i < counter; i++)
		{
			book[i].print3();
		}
	}
}
