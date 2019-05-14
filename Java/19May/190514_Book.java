//VO
//Book
package sesoc.global.vo;

import java.io.Serializable;

public class Book implements Serializable {
	private String isbn;
	private String title;
	private String publisher;

	public Book() {
	}

	public Book(String isbn, String title, String publisher) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "번호: " + isbn + " 제목: " + title + " 출판사: " + publisher;
	}
}

//Novel
package sesoc.global.vo;

import java.io.Serializable;

public class Novel extends Book implements Serializable {
	private String author;
	private String genre;

	public Novel() {
	}

	public Novel(String isbn, String title, String publisher, String author, String genre) {
		super(isbn, title, publisher);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return super.toString() + " 저자:" + author + " 장르: " + genre;
	}
}

//Comics
package sesoc.global.vo;

import java.io.Serializable;

public class Comics extends Book implements Serializable {
	private int year;
	private int month;

	public Comics() {
	}

	public Comics(String isbn, String title, String publisher, int year, int month) {
		super(isbn, title, publisher);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return super.toString() + " 발행일: " + year + "/" + month;
	}
}


//Main
package sesoc.global.main;

import sesoc.global.ui.BookStoreUI;

public class BookStoreMain {
	public static void main(String[] args) {
		try {
			new BookStoreUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


//UI

package sesoc.global.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import sesoc.global.service.BookStoreManager;
import sesoc.global.vo.Book;
import sesoc.global.vo.Comics;
import sesoc.global.vo.Novel;

public class BookStoreUI {
	private BookStoreManager manager = null;
	private Scanner scan = new Scanner(System.in);
	private Scanner scanLine = new Scanner(System.in);
	
	public BookStoreUI() throws Exception {
		manager = new BookStoreManager(); 
		String select = null;
		
		while (true) {
			printMainMenu();
			select = scanLine.nextLine();
			
			switch (select) {
			case "1":
				input();
				break;
			case "2":
				searchByTitle();
				break;
			case "3":
				searchByIsbn();
				break;
			case "4":
				delete();
				break;				
			case "5":
				printAll();
				break;			
			case "0":
				System.out.println("모든 도서 정보를 저장하고, 프로그램을 종료합니다.");
				manager.saveFile();
				System.exit(0);
			default:
				System.out.println("잘못 선택했습니다.");
				break;
			}
		}
	}
	
	/**
	 * 도서관리 프로그램의 메인 메뉴를 출력한다.
	 **/
	public void printMainMenu() {
		System.out.println("====================");
		System.out.println("      도서 정보 관리 ");
		System.out.println("====================");
		System.out.println("  1. 도서 정보 입력");
		System.out.println("  2. 책 제목으로 검색");
		System.out.println("  3. ISBN 검색");
		System.out.println("  4. 도서 정보 삭제");
		System.out.println("  5. 전체 출력");		
		System.out.println("  0. 종료");
		System.out.print  ("     선택 > ");
	}
	
	/**
	 * 도서 정보를 입력한다.
	 * 입력할 도서정보를 선택한 후 선택된 도서에 따른 정보를 입력받아 등록한다.
	 * */
	public void input() {				
		System.out.println("* 도서 정보 입력");
		System.out.print("1. 입력할 분야 (1:소설, 2:만화) : ");
		String no = scanLine.nextLine();
		Book book = null;
		
		switch (no) {
			case "1":
				System.out.print("도서 ISBN 번호 : ");
				String isbn = scanLine.nextLine();
				
				book = manager.searchBookByIsbn(isbn);
				
				if(book != null) {
					System.out.println("같은 ISBN을 가진 책이 존재합니다.");
					break;
				}
				
				System.out.print("제목 : ");
				String title = scanLine.nextLine();
				System.out.print("출판사 : ");
				String publisher = scanLine.nextLine();
				System.out.print("저자 : ");
				String author = scanLine.nextLine();
				System.out.print("장르 : " );
				String genre = scanLine.nextLine();
				
				Novel novel = new Novel(isbn, title, publisher, author, genre);
				
				manager.insertBook(novel);
				
				break;
			case "2":
				System.out.print("도서 ISBN 번호 : ");
				isbn = scanLine.nextLine();
				
				book = manager.searchBookByIsbn(isbn);
				
				if(book != null) {
					System.out.println("같은 ISBN을 가진 책이 존재합니다.");
					break;
				}
				
				System.out.print("제목 : ");
				title = scanLine.nextLine();
				System.out.print("출판사 : ");
				publisher = scanLine.nextLine();
				System.out.print("년도 : ");
				int year = scan.nextInt();
				System.out.print("월 : " );
				int month = scan.nextInt();
				
				Comics comics = new Comics(isbn, title, publisher, year, month);
				
				manager.insertBook(comics);
				break;
			default:System.out.println("잘못 입력하셨습니다.");
		}
	}
		
	/**
	 * 제목으로 도서정보를 검색한다.
	 * 검색할 책 제목을 입력받아 검색 결과를 출력한다.
	 * 검색결과가 없을 시 적절한 문구를 출력한다.
	 * */
	public void searchByTitle() {
		System.out.println("* 도서 정보 검색");
		System.out.print("검색할 책 제목 : ");
		String title = scanLine.nextLine();
		String result = "";
		
		ArrayList<Book> tList = manager.searchBookByTitle(title);
		
		for(int i = 0; i < tList.size(); i++){
			System.out.println(tList.get(i));
		}
		/*CODE HERE*/
	}
	
	/**
	 * ISBN로 도서정보를 검색한다.
	 * 검색할 ISBN를 입력받아 검색 결과를 출력한다.
	 * 검색결과가 없을 시 적절한 문구를 출력한다.
	 * */
	public void searchByIsbn() {
		System.out.println("* 도서 정보 검색");
		System.out.print("검색할 도서 ISBN : ");
		String isbn = scanLine.nextLine();
		
		System.out.println(manager.searchBookByIsbn(isbn));
		/*CODE HERE*/
	}
	
	/**
	 * ISBN로 도서정보를 검색한 후 검색된 도서를 삭제한다.
	 * 검색할 ISBN를 입력받아 검색 결과를 출력한다.
	 * 검색결과가 없을 시 적절한 문구를 출력한다.
	 * */	
	public void delete() {
		System.out.println("* 도서 정보 삭제");
		System.out.print("삭제할 도서 ISBN : ");
		
		String isbn = scanLine.nextLine();
		
		/*CODE HERE*/
		
		/* Code Here : 
		 * 삭제할 도서의 isbn이 존재하는지 여부 확인 ==> searchBookByIsbn() 이용, 
		 * 도서가 존재할 경우 진짜로 삭제할 지 확인 한 후 Y, y가 입력될 때만 삭제
		 * 해당 도서가 존재하지 않을 때 메시지 출력 
		 * */
		
	}

	/**
	 * 등록된 모든 도서정보를 출력한다.
	 * */
	public void printAll() {
		/*CODE HERE*/
		String result = "";
		ArrayList<Book> bookList = manager.getAllBookList();
		
		for(Book b : bookList) {
			result += b +"\n";
		}
		System.out.println(result);
	}
}



//Service

package sesoc.global.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sesoc.global.vo.Book;
/**
 * 도서 정보를 관리하는 클래스
 */
public class BookStoreManager {
	private ArrayList<Book> bookList = new ArrayList<>(); // 책 정보들을 저장하기 위한 ArrayList
	private final String FILE_NAME = "book_store.dat";
	private File file = new File(FILE_NAME);
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private FileOutputStream fos;
	private FileInputStream fis;

	/**
	 * 기본 생성자
	 **/
	public BookStoreManager() throws Exception {
		// 파일에 저장된 책에 대한 정보를 읽어 List에 저장한다.
		getFile();
	}

	/**
	 * 기존에 저장된 파일이 존재하면 파일로부터 데이터를 읽어 ArrayList에 저장한다.
	 */
	public void getFile(){
		try {
			if(file.exists()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
					bookList = (ArrayList<Book>) ois.readObject();
		}
		saveFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ArrayList에 저장된 모든 책관련 정보를 파일에 저장한다.
	 */
	public void saveFile() {
		try {
				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
					oos.writeObject(bookList);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Book객체를 전달받아 ArrayList에 추가
	 * 
	 * @param book
	 *            등록할 Book 클래스의 객체
	 * @return 추가가 된 경우 true, 동일한 isbn이 있어 추가를 못한 경우 false
	 */
	public boolean insertBook(Book book) {
		boolean flag = true;
		
		if (searchBookByIsbn(book.getIsbn()) != null) {
			flag = false;
		}else {
			bookList.add(book);
			return true;
		}
		
		return false;
		/*
		 * Code here : 도서가 존재하는지 searchBookByIsbn() 이용 이미 존재할 경우 false를
		 * 없으면 ArrayList에 저장 후 true 리턴
		 */
	}

	/**
	 * 책의 isbn 값을 전달받아 ArrayList에 등록되어 있는 데이터를 찾아 삭제한다.
	 * 
	 * @param 책의
	 *            isbn 번호
	 * @return 도서정보의 삭제여부 리턴, true이면 삭제완료, false이면 삭제불가
	 */
	public boolean deleteBook(String isbn) {
		boolean flag = false;
		
		for (Book b : bookList) {
			if (isbn.equals(b.getIsbn())) {
				bookList.remove(b);
				return flag = true;
			}
		}
		/*
		 * Code here : 전달받은 ISBN 값으로 도서 정보를 찾아 데이터를 삭제. 삭제 완료 후 true 리턴
		 * 삭제를 못할 경우 false 리턴 (항상 false만 리턴되면 감점)
		 */
		return flag;
	}

	/**
	 * 책 제목을 이용하여 등록된 같은 제목의 모든 책 정보를 검색한다.
	 * 
	 * @param title
	 *            검색할 책 제목
	 * @return 책 제목으로 검색된 책 정보들. 동일한 책 제목의 모든 책을 검색하여 ArrayList에 저장하여 반환한다.
	 */
	public ArrayList<Book> searchBookByTitle(String title) {
		ArrayList<Book> tList = new ArrayList<>();
		
		for (Book b : bookList) {
			if(b.getTitle().equals(title)) {
				tList.add(b);
			}
		}
		/*
		 * Code Here : 모든 책 정보를 전부 검색하는가? (전부 검색하지 못할 경우 감점 )
		 */
		return tList;
	}

	/**
	 * 책 구분 번호(ISBN)로 책을 검색한다.
	 * 
	 * @param id
	 *            검색할 책 구분 번호(ISBN값)
	 * @return 검색된 책 정보
	 */

	public Book searchBookByIsbn(String isbn) {
		Book book = new Book();
		for (Book b : bookList) {
			if (b.getIsbn().equals(isbn)) {
				book = b;
				return book;
			}
		}
		return null;

		/*
		 * Code Here 전달된 isbn 번호로 검색되는가? 항상 null 이 리턴되면 감점
		 */

	}

	/**
	 * ArrayList에 등록된 모든 책 정보를 반환한다.
	 * 
	 * @return ArrayList에 등록된 모든 책 정보
	 */
	public ArrayList<Book> getAllBookList() {
		ArrayList <Book> bList = new ArrayList<>();
		
		for(Book b : bookList) {
			bList.add(b);			
		}
		return bList;

		/*
		 * Code here 모든 도서 정보 반환
		 */

	}
}
