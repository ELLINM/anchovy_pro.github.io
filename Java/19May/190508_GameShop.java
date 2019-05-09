//VO
//Game
package Vo;

import java.io.Serializable;

public class Game implements Serializable{

	private String name;// 타이틀명
	private String pCode;// 제품코드
	private String genre;// 장르
	private int amount;// 수량
	private int price;// 게임 가격
	private String info;// 게임정보

	public Game(String name, String pCode, String genre, int amount, int price, String info) {
		super();
		this.name = name;
		this.pCode = pCode;
		this.genre = genre;
		this.amount = amount;
		this.price = price;
		this.info = info;
	}

	public Game() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "타이틀명=" + name + ", 제품코드=" + pCode + ", 장르=" + genre + ", 수량=" + amount + ", 가격="
				+ price + ", 정보=" + info;
	}
}

//PcGame
package Vo;

import java.io.Serializable;

public class PcGame extends Game implements Serializable{

	private String internetCode;// 온라인다운로드코드

	public PcGame(String name, String pCode, String genre, int amount, int price, String info, String internetCode) {
		super(name, pCode, genre, amount, price, info);
		this.internetCode = internetCode;
	}

	public PcGame() {
		super();
	}

	public String getInternetCode() {
		return internetCode;
	}

	public void setInternetCode(String internetCode) {
		this.internetCode = internetCode;
	}

	@Override
	public String toString() {
		return super.toString()+", 다운로드코드=" + internetCode;
	}
}

//PsGame
package Vo;

import java.io.Serializable;

public class PsGame extends Game implements Serializable{

	private String psRegNum;// 타이틀등록번호

	public PsGame(String name, String pCode, String genre, int amount, int price, String info, String psRegNum) {
		super(name, pCode, genre, amount, price, info);
		this.psRegNum = psRegNum;
	}

	public PsGame() {
		super();
	}

	public String getPsRegNum() {
		return psRegNum;
	}

	public void setPsRegNum(String psRegNum) {
		this.psRegNum = psRegNum;
	}

	@Override
	public String toString() {
		return super.toString()+", 플스타이틀등록번호=" + psRegNum;
	}
}

//XboxGame
package Vo;

import java.io.Serializable;

public class XboxGame extends Game implements Serializable{

	private String xboxId;// 사용자 ID

	public XboxGame(String name, String pCode, String genre, int amount, int price, String info, String xboxId) {
		super(name, pCode, genre, amount, price, info);
		this.xboxId = xboxId;
	}

	public XboxGame() {
		super();
	}

	public String getXboxId() {
		return xboxId;
	}

	public void setXboxId(String xboxId) {
		this.xboxId = xboxId;
	}

	@Override
	public String toString() {
		return super.toString() + ", 엑박계정아이디=" + xboxId;
	}
}

//Main

package Main;

import UI.GameUI;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameUI();
	}
}


//UI

package UI;

import java.util.Scanner;

import Service.GameService;
import Vo.Game;
import Vo.PcGame;
import Vo.PsGame;
import Vo.XboxGame;

public class GameUI {
	
	private Scanner sc = new Scanner(System.in);
	private Scanner sc2 = new Scanner(System.in);
	private	String name, pCode, gerne, info, xboxId, psRegNum, internetCode;
	private int choice, amount, price;
	private boolean flag = true;
	private GameService gs = new GameService();
	
	public GameUI() {
		try {
			while (flag) {

				menu();
				choice = sc.nextInt();
				
				switch (choice) {
				case 1:
					gameMenu();
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						PcGame pg = insertPcGame();
						gs.insertGame(pg);
						break;
					case 2:
						PsGame psg = insertPsGame();
						gs.insertGame(psg);
						break;
					case 3:
						XboxGame xg = insertXboxGame();
						gs.insertGame(xg);
						break;
					}
					break;
				case 2:
					System.out.println(gs.printAll());
					break;
				case 3:
					System.out.println("게임 코드를 입력하세요");
					pCode = sc2.next();
				
					System.out.println(gs.printGame(pCode));
					break;
				case 4:
					System.out.println("판매할 게임 코드 입력");
					pCode = sc2.next();
					boolean result = deleteGame(pCode);
					if (result) {
						System.out.println("판매 완료");
					}else {
						System.out.println("다시 입력해 주세요");
					}
					break;
				case 5:
					System.out.println("다운로드 코드를 입력하세요");
					internetCode = sc2.next();
				
					System.out.println(gs.internetCodeSearch(internetCode));
					break;
				case 6:
					System.out.println("타이틀 등록번호 입력하세요");
					psRegNum = sc2.next();
				
					System.out.println(gs.psRegNumSearch(psRegNum));
					break;
				case 7:
					System.out.println("Xbox Id를 입력하세요");
					xboxId = sc2.next();
				
					System.out.println(gs.xboxIdSearch(xboxId));
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					System.out.println("삭제할 게임 코드 입력");
					pCode = sc2.next();
					result = deleteGame(pCode);
					if (result) {
						System.out.println("삭제 성공");
					}else {
						System.out.println("다시 입력해 주세요");
					}
					break;
				case 12:
					flag = false;
					break;
				}
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void menu() {
		System.out.println("=============");
		System.out.println("1. 게임 등록");
		System.out.println("2. 전체 출력");
		System.out.println("3. 게임 정보 출력 ");
		System.out.println("4. 게임 판매");
		System.out.println("5. xbox검색");
		System.out.println("6. ps 검색");
		System.out.println("7. pc 검색");
		System.out.println("8. 게임 정보 수정");
		System.out.println("9. 등록부 파일 저장");
		System.out.println("10. 등록부 파일 불러오기");
		System.out.println("11. 게임 삭제");
		System.out.println("12. 종료");
		System.out.println("=============");	
	}
	
	public void gameMenu() {
		System.out.println("==================");
		System.out.println("1. Pc Game 등록");
		System.out.println("2. PS Game 등록");
		System.out.println("3. Xbox Game 등록");
		System.out.println("=================");	
	}
	public Game insertGame() {
		try {
		System.out.println("게임명");
		name = sc2.next();
		
		System.out.println("게임 코드");
		pCode = sc2.next();
		
		System.out.println("장르");
		gerne = sc2.next();
		
		System.out.println("수량");
		amount = sc.nextInt();
		
		System.out.println("가격");
		price = sc.nextInt();
		
		System.out.println("정보");
		info = sc2.next();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Game g = new Game(name, pCode, gerne, amount, price, info);
		return g;
	}
	
	public PcGame insertPcGame() {
		try {
		insertGame();
		System.out.println("다운도르 코드 입력");
		internetCode = sc2.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		PcGame pg = new PcGame(name, pCode, gerne, amount, price, info, internetCode);
		return pg;
	}
	
	public PsGame insertPsGame() {
		try {
		insertGame();
		System.out.println("타이틀 등록 번호");
		psRegNum = sc2.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		PsGame psg = new PsGame(name, pCode, gerne, amount, price, info, psRegNum);
		return psg;
	}
	
	public XboxGame insertXboxGame() {
		try {
			insertGame();
			System.out.println("xbox id 입력");
			xboxId = sc2.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		XboxGame xg = new XboxGame(name, pCode, gerne, amount, price, info, xboxId);
		return xg;
	}
	public boolean deleteGame(String pCode) {
		boolean result = gs.deleteGame(pCode);
		return result;
	}
	public boolean sellGame(String pCode) {
		boolean result = gs.sellGame(pCode);
		return result;
	}
}


//Service

package Service;

import java.util.ArrayList;

import Vo.Game;
import Vo.PcGame;
import Vo.PsGame;
import Vo.XboxGame;


public class GameService implements GameInterface{
	
	private ArrayList<Game> gList = new ArrayList<>();
	
	public boolean insertGame(Game g) {
		boolean flag = true;
		
		if (searchIndex(g.getpCode()) == -1) {
			gList.add(g);
		}
		
		return flag;
	}
	
	public int searchIndex(String pCode) {
		// TODO Auto-generated method stub
		int result = -1;
		for (int i = 0; i < gList.size(); i++) {
			if (gList.get(i).getpCode().equals(pCode)) {
				result = i;
			}
		}
		return result;
	}
	
	public boolean deleteGame(String pCode) {
		boolean flag = true;
		
		int index = searchIndex(pCode);
		if (index != -1) {
			gList.remove(index);
		}else {
			flag = false;
		}
		return flag;
	}

	@Override
	public String printGame(String pCode) {
		String result = "";
		
		for (Game g : gList) {
			if (pCode.equals(g.getpCode())) {
				result += g + "\n";
			}
		}
		return result;
	}

	@Override
	public boolean updateGame(String pCode, Game g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String xboxIdSearch(String id) {
		String result = "";
		
		for (int i = 0; i < gList.size(); i++) {
			if (gList.get(i).getpCode().equals(id)) {
				result += gList.get(i).toString();
			}
		}
		return result;
	}

	@Override
	public String psRegNumSearch(String psRegNum) {
		String result = "";
		
		for (int i = 0; i < gList.size(); i++) {
			if (gList.get(i).getpCode().equals(psRegNum)) {
				result += gList.get(i).toString();
			}
		}
		return result;
	}

	@Override
	public String internetCodeSearch(String internetCode) {
		String result = "";
		
		for (int i = 0; i < gList.size(); i++) {
			if (gList.get(i).getpCode().equals(internetCode)) {
				result += gList.get(i).toString();
			}
		}
		return result;
	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printInfoFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String printAll() {
		String result = "";
		
		for (Game g : gList) {
			result += g + "\n";
		}
		return result;
	}

	@Override
	public boolean sellGame(String pCode) {
		boolean flag = true;
		int index = searchIndex(pCode);
		if (index != -1) {
			
			if (gList.get(index).getAmount() < 1) {
				flag = false; 
				return flag;
			} else {
				gList.get(index).setAmount(gList.get(index).getAmount() - 1);
				return flag; 
			}
		} else {
			flag = false;
			return flag;
		}
	}
}


//Interface

package Service;

import Vo.Game;

public interface GameInterface {

	
	public boolean insertGame(Game g);//매장내 게임등록, 등록성공 여부를 반환
	public boolean sellGame(String pCode);//게임 판매, 성공여부 반환
	public String printAll();//매장내 모든게임 전체출력
	public String printGame(String pCode);//매장내 특정게임 정보출력
	public boolean deleteGame(String pCode);//게임삭제, 삭제 성공여부 반환
	public boolean updateGame(String pCode, Game g);//게임수정, 해당 제품코드의 제품을 매개변수의 내용으로 변경, 성공여부 반환
	public String xboxIdSearch(String id);//해당 ID가 가지고있는 xbox 타이틀 검색
	public String psRegNumSearch(String psRegNum);//해당 ps 타이틀등록번호로 게임 검색
	public String internetCodeSearch(String internetCode);//해당 다운로드코드로 pc게임 검색
	public void saveData();//등록부파일저장
	public void loadData();//등록부파일불러오기
	
	//번외
	public void printInfoFile();//판매된 제품의 정보를 메모장에 요약하여 출력
	//예시
	//
	//타이틀명: DIABLO3, 가격: 23000, 수량 : 1
	//타이틀명: FABLE2, 가격: 15000, 수량 : 1
	//타이틀명: TEKKEN6, 가격: 20000, 수량 : 1
	// 합계 : 58000 원
}
