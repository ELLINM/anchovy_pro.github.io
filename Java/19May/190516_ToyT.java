//VO
//toy
package global.sesoc.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Toy implements Serializable {
	private String serialNum;
	private String name;
	private int price;

	
	public Toy(String serialNum, String name, int price) {
		super();
		this.serialNum = serialNum;
		this.name = name;
		this.price = price;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	
	@Override
	public String toString() {
		return "[고유번호 = " + serialNum + ", 이름 = " + name + ", 가격 = " + priceToString(price) + "원";
	}
	
	public String priceToString(int price) {
		String sPrice = Integer.toString(price);
		ArrayList<String> pList = new ArrayList<>();
		for(int i = sPrice.length(); i > 0; i-=3) {
			String pricePart = null;
			if(i <= 3) {
				pricePart = sPrice.substring(0, i);
			}
			else {
				pricePart = sPrice.substring(i-3, i);
			}
			pList.add(pricePart);
		}
		
		String newPrice = "";
		for(int i = pList.size() -1; i >= 0; i--) {
			if(i == 0) {
				newPrice += pList.get(i);
			}
			else {
				newPrice += pList.get(i) + ",";
			}
		}
		
		return newPrice;
	}
}

//GameConsole
package global.sesoc.vo;

public class GameConsole extends Toy {

	private boolean isPortable;
	
	public GameConsole(String serialNum, String name, int price, boolean isPortable) {
		super(serialNum, name, price);
		this.isPortable = isPortable;
	}

	public boolean isPortable() {
		return isPortable;
	}

	public void setPortable(boolean isPortable) {
		this.isPortable = isPortable;
	}

	@Override
	public String toString() {
		String portable = null;
		if(isPortable) {
			portable = "Y";
		}
		else {
			portable = "N";
		}
		return "[게임콘솔]\t" +  super.toString() + ", 휴대용=" + portable + "]";
	}
}

//Drone
package global.sesoc.vo;

public class Drone extends Toy {
	private int wingCount;
	
	public Drone(String serialNum, String name, int price,  int wingCount) {
		super(serialNum, name, price);
		this.wingCount = wingCount;
	}

	public int getWingCount() {
		return wingCount;
	}

	public void setWingCount(int wingCount) {
		this.wingCount = wingCount;
	}

	@Override
	public String toString() {
		return "[드론]\t" +  super.toString() + ", 날개 수=" + wingCount + "]";
	}
}

//Bicycle
package global.sesoc.vo;

public class Bicycle extends Toy {
	private String type;
	
	public Bicycle(String serialNum, String name, int price, String type) {
		super(serialNum, name, price);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "[자전거]\t" +  super.toString() + ", 종류=" + type + "]";
	}
}


//Main
package global.sesoc.main;

import global.sesoc.ui.ToyManagerUI;

public class ToyManagerMain {
	public static void main(String[] args) {
		new ToyManagerUI();
	}
}


//UI
package global.sesoc.ui;

import java.util.List;
import java.util.Scanner;

import global.sesoc.manager.ToyManagerMgr;
import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

public class ToyManagerUI {
	Scanner input = new Scanner(System.in);
	ToyManagerMgr manager = new ToyManagerMgr();
	
	/**
	 * 생성자
	 */
	public ToyManagerUI() {
		int mNum = 0;
		
		while(true) {
			try {
				mainMenu();
				mNum = input.nextInt();

				switch(mNum) {
				case 1:
					insertToy();
					break;
				case 2:
					searchToy();
					break;
				case 3:
					deleteToy();
					break;
				case 4:
					searchForPrice();
					break;
				case 5:
					printToyInfo();
					break;
				case 9:		// 저장 후 끝냄
					System.out.println("데이터 저장 후 프로그램 종료합니다.");
					manager.saveFile();
					return;
				default : 
					System.out.println("오류 >>>>> 메뉴 선택을 다시해 주세요.");
					input.nextLine();	
				}
			} catch (Exception e) {
				System.out.println("오류 >>>>> 메뉴 선택을 다시해 주세요.\n");
				input.nextLine();
				continue;
			}
		}

	}

	/**
	 * 주메뉴를 화면에 출력한다.
	 */
	public void mainMenu() {
		System.out.println("\n===== Toy Manager ======");
		System.out.println("1. 장난감 등록");
		System.out.println("2. 장난감 검색");
		System.out.println("3. 장난감 삭제");
		System.out.println("4. 가격대 검색");
		System.out.println("5. 장난감 정보 출력");
		System.out.println("9. 종료");
		System.out.println("=======================");
		System.out.print  ("[ 메뉴  선택  ] ");
	}

	/**
	 * 장난감 객체를 생성해서 삽입하기 위한 메소드
	 * 
	 */
	public void insertToy() {
		while(true) {
			int iNum = 0;
			try {
				insertMenu();
				iNum = input.nextInt();

				if(iNum == 9) {
					return;
				}
			} catch(Exception e) {
				System.out.println("오류 >>>>> 다시 선택해 주세요.\n");
				input.nextLine();
				continue;
			}

			Toy toy = makeToy(iNum);
			manager.insertToy(toy);
		}
	}

	/**
	 * 장난감 객체를 등록하기 위한 메뉴를 화면에 출력
	 */
	public void insertMenu() {
		System.out.println("\n===== 장난감 등록 메뉴 =====");
		System.out.println("1. 자전거");
		System.out.println("2. 드론");
		System.out.println("3. 게임기");
		System.out.println("9. 상위메뉴");
		System.out.print  ("[ 장난감 선택 ] ");
	}

	/**
	 * 장난감 객체를 저장하기 위해 Toy 객체를 새엉한다.
	 * @param toyType 장난감 종류
	 * @return 생성된 장난감 객체
	 */
	public Toy makeToy(int toyType) {
		Toy toy = null;
		String name, serialNum;
		int price = 0;
		
		while(true) {
			try {
				System.out.print("> 고유번호:");
				serialNum = input.next();
				
				Toy sToy = manager.searchToy(serialNum);

				if(sToy != null) {
					System.out.println("중복 오류 >>>>> 입력하신 고유번호의 장난감이 존재합니다.\n");
					continue;
				}

				System.out.print("> 이름:");
				name = input.next();
				
				System.out.print("> 가격:");
				price = input.nextInt();

				switch(toyType) {
				case 1:
					String type = null;

					System.out.print("> 자전거 종류(1. 도로용, 2. 산악용) => ");
					int tNum = input.nextInt();
					switch(tNum) {
					case 1:
						type = "road";
						break;
					case 2:
						type = "mountain";
						break;
					default:
						new Exception("익셉션 발생..");
						break;
					}

					toy = new Bicycle(serialNum, name, price, type);
					
					break;
				case 2:
					int wingCount = 0;
					System.out.print("> 날개 갯수 : ");
					wingCount = input.nextInt();

					toy = new Drone(serialNum, name, price, wingCount);

					break;

				case 3:
					System.out.print("> 휴대 가능 여부(y/n) ");
					String ip = input.next();
					boolean isPortable = false;

					if(ip.equalsIgnoreCase("y")) {
						isPortable = true;
					}
					else if(ip.equalsIgnoreCase("n")) {
						isPortable = false;
					}
					toy = new GameConsole(serialNum, name, price, isPortable);
					
					break;
				}
				
				return toy;
				
			} catch (Exception e) {
				input.nextLine();
				System.out.println("오류 >>>>> 다시 입력해 주세요.\n");
				continue;
			}
		}
		
	}

	/**
	 * 고유번호에 해당하는 장난감을 검색하여 화면에 출력한다.
	 * 
	 */
	public void searchToy() {
		while(true) {
			System.out.print("\n> 장난감 고유번호: ");
			String serialNum = input.next();
			Toy sToy = manager.searchToy(serialNum);

			if(sToy != null) {
				System.out.println(sToy.toString());
			}
			else {
				System.out.println("검색 실패 >>>>> 입력하신 고유번호의 장난감이 존재하지 않습니다.\n");
			}
			return;
		}
	}

	/** 
	 * 장난감의 시리얼번호를 입력받아 해당하는 장난감 정보를 삭제한다. 
	 */
	public void deleteToy() {
		System.out.println("\n===== 장난감 삭제 메뉴 =====");
		System.out.print("> 장난감 고유 번호: ");
		String serialNum = input.next();

		if(manager.deleteToy(serialNum)) {
			System.out.println("[ 삭제 성공 ]\n");
		}
		else {
			System.out.println("삭제 실패 >>>>> 입력하신 고유번호의 장난감이 존재하지 않습니다.\n");
		}
	}

	/**
	 * 가격 검색
	 */
	public void searchForPrice() {
		System.out.println("\n===== 가격 검색 메뉴 =====");
		System.out.print("> 최소가격: ");
		int minPrice = input.nextInt();
		
		System.out.print("> 최대가격: ");
		int maxPrice = input.nextInt();
		
		int count = 0;
		
		List<Toy> tList = manager.toyListForPrice(minPrice, maxPrice);
		if(tList != null) {
			System.out.println("[ " + minPrice + "원 ~ " + maxPrice + "원 사이의 제품 검색 결과 ] ");
			
			for(Toy t : tList) {
				System.out.println(t);
				count++;
			}
			System.out.println("[ 총  "+ count +" 개의 제품이 검색되었습니다.]\n");
			
		}
		else {
			System.out.println(">>>>> 원하시는 가격 대의 제품이 존재하지 않습니다.\n");
		}
	}

	/**
	 * 장난감 정보를 화면에 출력한다.
	 */
	public void printToyInfo() {
		while(true) {
			printMenu();
			int pNum = input.nextInt();
			String msg = null;

			switch(pNum) {
			case 1:
				msg = "총 장난감 개수: [";
				break;
			case 2:
				msg = "총 자전거 대수: [";
				break;
			case 3:
				msg = "총 드론 대수: [";
				break;
			case 4:
				msg = "총 게임콘솔 대수: [";
				break;
			case 9:
				return;
			}
			List<Toy> tList = manager.printToyInfo(pNum);
			if(tList != null) {
				for(int i = 0, len = tList.size(); i < len; i++) {
					System.out.println(tList.get(i).toString());
				}
				System.out.println(msg + tList.size() + "] 대");
			}
		}
	}

	/**
	 * 주 메뉴 출력 메서드
	 */
	public void printMenu() {
		System.out.println("\n===== 장난감 정보 출력 =====");
		System.out.println("1. 전체 출력");
		System.out.println("2. 자전거 정보 출력");
		System.out.println("3. 드론 정보 출력");
		System.out.println("4. 게임콘솔 정보 출력");
		System.out.println("9. 상위 메뉴");
		System.out.print  ("[ 선택 ] ");

	}
}


//Interface
package global.sesoc.manager;

import java.util.List;

import global.sesoc.vo.Toy;

public interface ToyManager {
	public boolean insertToy(Toy toy);
	public Toy searchToy(String serialNum);
	public boolean deleteToy(String serialNum);
	public List<Toy> toyListForPrice(int minPrice, int maxPrice);
	public List<Toy> printToyInfo(int type);
}


//Service
package global.sesoc.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

public class ToyManagerMgr implements ToyManager {
	private final String FILE_NAME="toy.dat";
	private List<Toy> toyList;			// 각종 Toy 정보를 담을 리스트

	private FileInputStream fis;		// 파일을 읽기 위한 객체
	private FileOutputStream fos;		// 파일을 쓰기 위한 객체
	private ObjectInputStream ois;		// 객체를 읽기 위한 객체
	private ObjectOutputStream oos;		// 객체를 쓰기 위한 객체
	
	/** 생성자 
	 * @throws Exception
	 */
	public ToyManagerMgr(){
		// 이전에 등록된 toy 정보가 등록된 파일의 정보를 읽어들인다.

		if(new File(FILE_NAME).exists()){
			loadFile();
		} else {
			toyList = new ArrayList<Toy>();
		}
	}
	/**
	 * 파일에 쓰여진 모든 Toy 객체 정보를 읽어들인다.
	 * */
	@SuppressWarnings("unchecked")
	public void loadFile() {
		try{
			// 파일 스트림으로부터 파일명에 해당하는 파일을 읽어들인다
			fis = new FileInputStream(FILE_NAME);
			
			// 파일 스트림으로부터 오브젝트 스트림 형태로 변경
			ois = new ObjectInputStream(fis);
			
			toyList = (ArrayList<Toy>) ois.readObject();
			
		} catch(Exception e) {
			// e.printStackTrace();
			System.out.println("오류 >>>>> 파일 읽기에 실패하였습니다.");
		} finally {
			try {
				if (oos != null) oos.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 등록된 모든 Toy 객체 정보를 파일에 기록한다.
	 * @return 파일 쓰기 성공 여부
	 * */
	public boolean saveFile(){
		boolean result = false;
		try{
			fos = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(toyList);
			result = true;
		} catch(Exception e){
			System.out.println("오류 >>>>> 파일 쓰기에 실패했습니다.");
		} finally {
			try {
				if (oos != null) oos.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		return result;
	}

	/**
	 * 제품의 일련 번호를 이용해 해당하는 제품이 있는지 찾는다.
	 * @param serialNum 제품번호
	 * 
	 * @return 제품번호에 의해 검색된 제품 정보, 검색된 내용이 없을 경우 null이 리턴된다.
	 */
	@Override
	public Toy searchToy(String serialNum) {
		Iterator<Toy> toyes = toyList.iterator();

		while(toyes.hasNext()) {
			Toy findToy = toyes.next();
			if (findToy.getSerialNum().equals(serialNum)) 
				return findToy;
		}
		return null;
	}
	
	/**
	 * 제품 번호를 이용해 해당 제품을 찾았을 경우 제품을 목록에서 삭제하고, 파일에 저장한 후 true릉 리턴한다.
	 * 제품번호를 찾지 못했을 경우 false를 리턴한다.
	 * @param serialNum
	 * @return 삭제 여부
	 */
	@Override
	public boolean deleteToy(String serialNum) {
		Toy original = searchToy(serialNum);
		if(original != null) {
			toyList.remove(original);
			return true;
			
		}
		return false;
	}

	/**
	 * 최소금액과, 최대금액을 전달받아 해당하는 값을 전달받아 그 영역사이의 가격인 장난감을 리턴한다.
	 * @param 최소값, 최대값
	 * @return 지정한 금액 안에 존재하는 장난감의 목록
	 */
	@Override
	public List<Toy> toyListForPrice(int minPrice, int maxPrice) {
		List<Toy> pList = new ArrayList<>();
		for(int i = 0, len = toyList.size(); i < len; i++) {
			int toyPrice = toyList.get(i).getPrice();
			if(toyPrice >= minPrice && toyPrice <= maxPrice) {
				pList.add(toyList.get(i));
			}
		}
		
		return pList;
	}

	/**
	 * 전달된 타입의 장난감 목록을 출력한다.
	 * @param 장난감 타입
	 * @return 검색된 장난감 목록
	 */
	@Override
	public List<Toy> printToyInfo(int type) {
		List<Toy> toys = new ArrayList<>();
		Toy toy = null;

		switch(type) {
		case 1: // all
			for(int i = 0 ; i < toyList.size(); i++) {
				toy = toyList.get(i);
				toys.add(toy);
			}
			break;
		case 2: // bicycle
			for(int i = 0 ; i < toyList.size(); i++) {
				toy = toyList.get(i);
				if(toy instanceof Bicycle) {
					toys.add(toy);
				}
			}
			break;
		case 3: // drone
			for(int i = 0 ; i < toyList.size(); i++) {
				toy = toyList.get(i);
				if(toy instanceof Drone) {
					toys.add(toy);
				}
			}
			break;
		case 4: // gameconsole
			for(int i = 0 ; i < toyList.size(); i++) {
				toy = toyList.get(i);
				if(toy instanceof GameConsole) {
					toys.add(toy);
				}
			}
		}
		return toys;
	}
	
	/**
	 * 전달받은 Toy 객체를 List에 추가
	 * @param list에 추가할 Toy객체
	 * @return 추가여부 
	 */
	@Override
	public boolean insertToy(Toy toy) {
		if(searchToy(toy.getSerialNum()) == null) {
			toyList.add(toy);
			return true;
		}
		return false;
	}
}

