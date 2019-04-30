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
					Movie m = makeMovie();
					ms.insertMovie(m);
					break;
				case 2:
					System.out.println(ms.printAll());
					break;
				case 3:					
					if(ms.makeDvd(makeDvd(), title)) {
						System.out.println("등록성공");
					}else {
						System.out.println("등록실패");
					}
					/*먼저 return된 makeDvd가 처리
					하단의 make Dvd에서는 title값을 만들지 않더라도
					후처리로 사용이 됨
					title이 전역번슈기 때문에 처리됨*/
					break;
				case 4:
					Usb u = makeUsb();
					ms.insertUsb(u, titleList);
					break;
				case 5:
					System.out.println("영화 제목 입력");
					title = sc.next();
					
					System.out.println(ms.searchTitle(title));
					break;
				case 6:
					flag = false;
					break;
				}	
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Movie makeMovie() {
		System.out.println("영화 제목 입력");
		title = sc.next();
	
		System.out.println("장르 입력");
		genre = sc.next();
	
		System.out.println("상영시간 입력");
		playTime = sc.next();
	
		System.out.println("가격 입력");
		price = sc2.nextInt();
		
		Movie m = new Movie(title, genre, playTime, price)
		
		return m;
	}
	public Dvd makeDvd() {
		System.out.println("보관함 번호 입력");
		rackNum = sc.next();
		
		System.out.println("영화 제목 입력");
		title = sc.next();
		
		System.out.println("제조 일자 입력");
		madeDate = sc.next();
		
		Dvd d = new Dvd();
		d.setRackNum(rackNum);
		d.setMadeDate(madeDate);
		return d;
	}
	public Usb makeUsb() {
		titleList = new ArrayList<>();
		System.out.println("보관함 번호 입력");
		rackNum = sc.next();
		
		System.out.println("몇개의 영화를 넣으시겠습니까");
		number = sc2.nextInt();
		
		for (int i = 0; i < number; i++) {
			System.out.println("제목입력");
			String title = sc.next();
			//title을 새로 선언해줌 
			titleList.add(title);
		}
		Usb u = new Usb();
		u.setRackNum(rackNum);
		return u;
	}
}


//Service

package Service;

import java.util.ArrayList;

import VO.Dvd;
import VO.Movie;
import VO.Usb;

public class MovieService {
	private ArrayList <Movie> mList = new ArrayList<>();
	private ArrayList <Device> dList = new ArrayList<>();
	
	public void insertMovie(Movie m) {
			moList.add(m);
	}
	public String printAll() { //void로 하면 method안에서 출력 String으로 하면 돌려줄 문자열 값을 생성
		String result = ""; //result = null로 생성할경우 null도 함께 출력됨
		for (Movie m : mList) {
			result += m + "\n"; //object가 생성한 toString으로 출력되며 toString이없을 경우 주소값으로 출력됨
		}
		return result;
	}
	/*public void madeDvd(String rackNum, String title, String madeDate) { // Device를 생성하여 Device안에 넣어줘야함
		Movie temp=new Movie(); //Movie를 담아줄 temp를 마련
		for (Movie i : mList) {
			if (i.getTitle().equals(title)) { //입력한 title과 비교
				temp=i; //temp에 검사한 i값을 넣어줌
			}
		}
		Dvd d = new Dvd(rackNum, temp, madeDate);
		// parameter와 함께 temp를 Dvd Vo로 넣어줌
	}*/
	public boolean makeDvd(Dvd d, String title) {
	 	boolean result = false;
	 	for (Movie m : mList){
	 	if (m.getTitle().equals(title)){
	 		d.setMovie(m);
	 		dList.add(d);
	 		result = true;
	 		break;
	 	}
	 	return result;
		}
	 }
	/*public void madeUsb(String rackNum, int number, String title) {
		Usb usb = new Usb(rackNum, );
	}
	// usb는 입력받은 rackNum으로 Device Vo로 들어가고 Usb안에는 Movie를 ArrayList 형식으로 포함하게 된다.	 
	public String searchMovie(String title) {
		String total = "";
		for (Movie i : mList) {
			if (i.getTitle().equals(title)) {
				total += i.toString();
			}
		}
		return total;
	}*/
	public boolean insertUsb(Usb u, ArrayList <String> sList) {
	 아직 영화의 배열이 들어가지 않은 Usb를 받고 여러 영화의 제목을 받을 배열을 생성
	 	boolean flag = false;
	 	for(Movie m : mList) { 
	 		for(String title : sList) {
	 			if (m.getTitle().equals(title)) {
	 				u.getmList().add(m);
	 				flag = true;
	 등록된 영화 리스트와 사용자가 입력한 리스트를 대조하여 같은것이 있으면 등록
	 			}
	 		}
	 	}
	 	if (flag) {
	 		dList.add(u);
	 	}
	 	return flag;
	 }
	public String searchTitle(String title) {
		String toPrint = "";
		
		for (Device device : dList) { 
			//영화는 device안에 들어있지 않기 때문에 형변환이 필요
			if (device instanceof Dvd) {
				//Dvd안에 들어있는지 찾아봄
				if(((Dvd) device).getMovie().getTitle().equals(title)) {
					//안에 들어있다면 Dvd안의 영화 title과 입력받은 title을 해줌
					toPrint += device + "\n";
				}
			}else if(device instanceof Usb){
				for (int i = 0; i < ((Usb)device).getmList().size(); i++) {
				//Usb는 ArrayList로 들어가있기 때문에 형변환을 하고 ArrayList를 갖고와서 비교를함
					if (((Usb)device).getmList().get(i).getTitle().equals(title)) {
						//Movie의 ArrayList.Movie.title
						toPrint += device + "\n";
					}
				}
			}
		}
		return toPrint;
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
