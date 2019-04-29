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


//Service


/*3번 메뉴 선택시,
보관함 번호 : 
영화제목 입력 : 
제조일자 입력 :
4번 메뉴 선택시,
보관함 번호 : 
영화를 몇개 넣으시겠습니까?
제목 입력 :*/
