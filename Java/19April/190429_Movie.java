//VO

//Movie
package VO;

public class Movie {
	private String title;
	private String playtime;
	private String genre;
	private int price;
	public Movie() {
		super();
	}
	public Movie(String title, String playtime, String genre, int price) {
		super();
		this.title = title;
		this.playtime = playtime;
		this.genre = genre;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlaytime() {
		return playtime;
	}
	public void setPlaytime(String playtime) {
		this.playtime = playtime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "제목 = " + title + ", 상영 시간 = " + playtime + ", 장르 = " + genre + ", 가격 = " + price;
	}
}

//Device
package VO;

public class Device {
	private String rackNum;

	public Device() {
		super();
	}

	public Device(String rackNum) {
		super();
		this.rackNum = rackNum;
	}

	public String getRackNum() {
		return rackNum;
	}

	public void setRackNum(String rackNum) {
		this.rackNum = rackNum;
	}

	@Override
	public String toString() {
		return "보관함 번호 = " + rackNum;
	}
}

//Dvd
package VO;

public class Dvd extends Device {
	private Movie movie; //하나의 속성으로 판단
	private String madeDate;
	
	public Dvd() {
		super();
	}
	public Dvd(String rackNum) {
		super(rackNum);
	}
	public Dvd(String rackNum, Movie movie, String madeDate) {
		super(rackNum);
		this.movie = movie;
		this.madeDate = madeDate;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getMadeDate() {
		return madeDate;
	}
	public void setMadeDate(String madeDate) {
		this.madeDate = madeDate;
	}
	@Override
	public String toString() {
		return super.toString() + "영화 = " + movie + ", 제작일  = " + madeDate;
	}
}

//Usb

package VO;

import java.util.ArrayList;

public class Usb extends Device{
	
	private ArrayList<Movie> mList = new ArrayList<>();

	public Usb() {
		super();
	}

	public Usb(String rackNum) {
		super(rackNum);
	}

	public Usb(ArrayList<Movie> mList, String rackNum) {
		super(rackNum);
		this.mList = mList;
	}

	public ArrayList<Movie> getmList() {
		return mList;
	}

	public void setmList(ArrayList<Movie> mList) {
		this.mList = mList;
	}

	@Override
	public String toString() {
		return super.toString() + "영화 리스트 = " + mList;
	}
}


//Main

package Main;

import UI.MovieUI;

public class MovieMain {
	
	public static void main(String [] args) {
		new MovieUI();
	}

}


//UI

package UI;

import java.util.Scanner;

import Service.MovieService;
import VO.Dvd;
import VO.Movie;

public class MovieUI {
	
	private Scanner sc = new Scanner(System.in);
	private Scanner sc2 = new Scanner(System.in);
	private String title, playtime, genre, rackNum, madeDate;
	private int price, choice, number = 0;	
	private MovieService ms = new MovieService();
	private boolean flag = true;
	
	public MovieUI() {
		try {
			while(flag) {
				menu();
				choice = sc.nextInt();
			
				switch (choice) {
				case 1:
					System.out.println("영화 제목 입력");
					title = sc.next();
				
					System.out.println("장르 입력");
					genre = sc.next();
				
					System.out.println("상영시간 입력");
					playtime = sc.next();
				
					System.out.println("가격 입력");
					price = sc2.nextInt();
				
					Movie m = new Movie(title, genre, playtime, price);
					ms.insertMovie(m);
					break;
				case 2:
					String result = ms.printAll();
					System.out.println(result);
					break;
				case 3:
					System.out.println("보관함 번호 입력");
					rackNum = sc.next();
					
					System.out.println("영화 제목 입력");
					title = sc.next();
					
					System.out.println("제조 일자 입력");
					madeDate = sc.next();
					
					ms.madeDvd(rackNum, title, madeDate);
					break;
				case 4:
					System.out.println("보관함 번호 입력");
					rackNum = sc.next();
					
					System.out.println("몇개의 영화를 넣으시겠습니까");
					number = sc2.nextInt();
					
					System.out.println("제목입력");
					title = sc.next();
					
					ms.madeUsb(rackNum, number, title);				
					break;
				case 5:
					System.out.println("검색할 영화 제목을 입력하세요");
					title = sc.next();
					
					System.out.println(ms.searchMovie(title)); //입력 해주는 String argument를 넣어줄것
					break;
				}	
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void menu() {
		System.out.println("================");
		System.out.println("1. 영화 등록");
		System.out.println("2. 보유 영화 목록 보기");
		System.out.println("3. DVD제조");
		System.out.println("4. USB제조");
		System.out.println("5. 영화 검색");
		System.out.println("================");
	}
	public void dvdMenu() {
		System.out.println("================");
		System.out.println("1. 보관함 번호");
		System.out.println("2. 영화 제목 입력");
		System.out.println("3. 제조 일자 입력");
		System.out.println("================");
	}
	public void usbMenu() {
		System.out.println("================");
		System.out.println("1. 보관함 번호");
		System.out.println("2. 영화를 몇개를 넣으시겠습니까");
		System.out.println("3. 제목입력");
		System.out.println("================");
	}
	
}


//Service

package Service;

import java.util.ArrayList;

import VO.Dvd;
import VO.Movie;
import VO.Usb;

public class MovieService {
	ArrayList <Movie> moList = new ArrayList<>();
	
	public void insertMovie(Movie m) {
			
			moList.add(m);
			
	}
	public String printAll() {
		String result = "";
		for (Movie m : moList) {
			result += m + "\n";
		}
		return result;
	}
	public void madeDvd(String rackNum, String title, String madeDate) {
		Movie temp=new Movie(); //Movie를 담아줄 temp를 마련
		for (Movie i : moList) {
			if (i.getTitle().equals(title)) { //입력한 title과 비교
				temp=i; //temp에 검사한 i값을 넣어줌
			}
			Dvd d = new Dvd(rackNum, temp, madeDate);
			// parameter와 함께 temp를 Dvd Vo로 넣어줌
		}
	}
	public void madeUsb(String rackNum, int number, String title) {
		
		Usb usb = new Usb(rackNum, );
	}
	// usb는 입력받은 rackNum으로 Device Vo로 들어가고 Usb안에는 Movie를 ArrayList 형식으로 포함하게 된다.	 
	public String searchMovie(String title) {
		String total = "";
		for (Movie i : moList) {
			if (i.getTitle().equals(title)) {
				total += i.toString();
			}
		}
		return total;
	}
}


/*3번 메뉴 선택시,
보관함 번호 : 
영화제목 입력 : 
제조일자 입력 :
4번 메뉴 선택시,
보관함 번호 : 
영화를 몇개 넣으시겠습니까?
제목 입력 :*/
