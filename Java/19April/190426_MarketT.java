//VO

//Product

package vo;

public class Product {

	private String name;// 제품명
	private String pCode;// 상품코드
	private int number;// 수량
	private int price;// 가격

	public Product(String name, String pCode, int number, int price) {
		super();
		this.name = name;
		this.pCode = pCode;
		this.number = number;
		this.price = price;
	}

	public Product() {
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "제품명=" + name + ", 제품코드=" + pCode + ", 수량=" + number + ", 가격=" + price;
	}

}

//Food

package vo;

public class Food extends Product {

	private int calorie;
	private String dueDate;

	public Food(String name, String pCode, int number, int price, int calorie, String dueDate) {
		super(name, pCode, number, price);
		this.calorie = calorie;
		this.dueDate = dueDate;
	}

	public Food() {
		super();
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return super.toString()+", 칼로리=" + calorie + ", 유통기한=" + dueDate;
	}

}

//Medicine

package vo;

public class Medicine extends Product {

	private String kind;
	private String shelfLife;

	public Medicine(String name, String pCode, int number, int price, String kind, String shelfLife) {
		super(name, pCode, number, price);
		this.kind = kind;
		this.shelfLife = shelfLife;
	}

	public Medicine() {
		super();
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	@Override
	public String toString() {
		return super.toString() + ", 약종류=" + kind + ", 유효기간=" + shelfLife;
	}

}


//Main

package main;

import ui.ConUI;

public class ConMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConUI();
	}

}


//UI

package ui;

import java.util.Scanner;

import service.ConService;
import vo.Food;
import vo.Medicine;
import vo.Product;

public class ConUI {

	private ConService cs;
	private Scanner sc = new Scanner(System.in);
	private Scanner sc2 = new Scanner(System.in);
	private int choice, calorie, price, number;
	private String name, pCode, dueDate, shelfLife, kind;
	private boolean flag = true;

	public ConUI() {
		cs = new ConService();

		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) { //온전히 입출력만을 보여주는 method
			case 1:
				subMenu();
				choice = sc.nextInt();
				Product made = insertProduct(choice);
				//Product Calss를 made라 정하고  insertProduct Mehthod의 choice값을 넣는다.
				cs.insertProduct(made);
				break;
			case 2:
				System.out.println(cs.printAll());
				break;
			case 3:
				System.out.println("검색할 제품코드 입력 : ");
				pCode = sc2.nextLine();
				System.out.println(searchProduct(pCode));
				break;
			case 4:
				System.out.println("삭제할 제품코드 입력 : ");
				pCode = sc2.nextLine();
				boolean result = deleteProduct(pCode); //return받은 값의 true Or false를 통해 
				if (result) {
					System.out.println("삭제성공");
				} else {
					System.out.println("**ERROR -없는 제품 번호");
				}
				break;
			case 5:
				System.out.println("구매할 제품코드 입력 : ");
				pCode = sc2.nextLine();
				System.out.println("구매 수량 입력 : ");
				number = sc.nextInt();
				result = sellProduct(number, pCode);
				if (result) {
					System.out.println("구매성공");
				} else {
					System.out.println("**ERROR -구매 실패(수량과 제품번호를 잘 입력해주세요 ***)");
				}
				break;
			case 6:
				System.out.println("총 판매 액 : " + cs.getTotalSold() + "원");
				break;
			case 7:
				System.out.println("유통기한 입력 : ");
				dueDate = sc2.nextLine();
				String info = cs.searchByDueDate(dueDate);
				if (!info.equals("")) {
					System.out.println(info);
				} else {
					System.out.println("검색 결과 없음");
				}
				break;
			case 8:
				System.out.println("약품유효기한 입력 : ");
				shelfLife = sc2.nextLine();
				info = cs.searchBySelfLife(shelfLife);
				if (!info.equals("")) {
					System.out.println(info);
				} else {
					System.out.println("검색 결과 없음");
				}
				break;
			case 9:
				System.out.println(cs.allFood());
				break;
			case 10:
				System.out.println(cs.allMedicine());
				break;
			case 11:
				System.out.println(cs.allProduct());
				break;
			case 12:
				System.out.println(cs.zeroAmountProduct());
				break;
			case 13:
				System.out.println("**SYSTEM - 종료합니다.");
				flag=false;
				break;
			}
		}
	}

	public void menu() {//메인메뉴 출력
		System.out.println("====================================");
		System.out.println("1.등록");
		System.out.println("2.전체출력");
		System.out.println("3.제품코드검색");
		System.out.println("4.제품삭제(제품코드입력)");
		System.out.println("5.판매(수량,제품코드입력)");
		System.out.println("6.총판매액계산");
		System.out.println("7.식품유통기한검색");
		System.out.println("8.약품유효기간검색");
		System.out.println("9.식품총출력");
		System.out.println("10.약품총출력");
		System.out.println("11.일반제품총출력");
		System.out.println("12.수량 0 인제품출력");
		System.out.println("13.종료");
		System.out.println("====================================");
	}

	public void subMenu() {//서브메뉴 출력
		System.out.println("====================================");
		System.out.println("1.일반제품등록");
		System.out.println("2.식품등록");
		System.out.println("3.약품등록");
		System.out.println("====================================");
	}

	/*
	이 메서드가 받는 값 :사용자가 서브메뉴에서 선택한 값 1:일반제품, 2:식품, 3:약품
	이 메서드가 주는 값 :사용자가 입력한 정보로 만들어진 완성된 객체*/
	//아래부터 Service Class에서 받은 값으로 어떻게 출력할지 결정하고 입출력 문으로 보냄
	public Product insertProduct(int choice) { //menu를 상단 switch문에서 만들지 않고 menu만 입력할 수 있도록 가독성이 좋도록 함

		System.out.println("제품명 입력 : ");
		name = sc2.nextLine();
		System.out.println("제품코드 입력 : ");
		pCode = sc2.nextLine();
		System.out.println("수량 입력 : ");
		number = sc.nextInt();
		System.out.println("가격 입력 : ");
		price = sc.nextInt();

		switch (choice) { //Method에서 선택된 값을 상단에서 Product Class에 대입
		case 1:
			return new Product(name, pCode, number, price); //VO Product Class에 parameter값을 입력 저장
		case 2:
			System.out.println("칼로리 입력 : ");
			calorie = sc.nextInt();
			System.out.println("유통기한 입력 : ");
			dueDate = sc2.nextLine();
			return new Food(name, pCode, number, price, calorie, dueDate);//VO Food Class에 parameter값을 입력 저장
		case 3:
			System.out.println("약품종류 입력 : ");
			kind = sc2.nextLine();
			System.out.println("유효기한 입력 : ");
			shelfLife = sc2.nextLine();
			return new Medicine(name, pCode, number, price, kind, shelfLife);//VO Medicine Class에 parameter값을 입력 저장
		}
		return null;// 각 case에서 return 값을 주기 때문에 switch문 전체에서는 return값이 없음
	}


	/*
	이 메서드가 받는 값 :제품코드
	이 메서드가 주는 값 :해당 제품코드를 가진 객체의 정보, Service에서 받아온다.*/
	public String searchProduct(String pCode) {
		int index = cs.searchIndex(pCode);
		String result = cs.searchByIndex(index);
		return result;
	}

	/*
	이 메서드가 받는 값 :제품코드
	이 메서드가 주는 값 :삭제 성공 여부, Service에서 받아온다.*/
	public boolean deleteProduct(String pCode) {
		boolean result = cs.deleteProduct(pCode);
		return result; // Service Clss에서 return값을 받아서 상단의 UI항목에 
	}

	/*
	이 메서드가 받는 값 :수량,제품코드
	이 메서드가 주는 값 :구매 성공 여부, Service에서 받아온다.*/
	public boolean sellProduct(int amount, String pCode) {
		boolean result = cs.sellProduct(amount, pCode);
		return result;
	}

}


//Service

package service;

import java.util.ArrayList;

import vo.Food;
import vo.Medicine;
import vo.Product;

public class ConService {

	private ArrayList<Product> pList = new ArrayList<>();
	private int totalSold = 0;

/*
	이 메서드가 받는 값 :등록할 객체
	이 메서드가 주는 값 :등록성공여부(boolean) */ 
	public boolean insertProduct(Product p) {
		boolean flag = true;

		for (Product pro : pList) {
			if (pro.getpCode().equals(p.getpCode())) { //같은 제품코드가 있는지 검사
				flag = false;
			}
		}
		if (flag) {
			pList.add(p);
		}
		return flag;
	}

	/*
	이 메서드가 받는 값 :없음
	이 메서드가 주는 값 :등록된 객체의 전체 정보 누적한 String (toString()으로 가져옴) */ 
	public String printAll() {
		String result = ""; //result variable에 공백을 대입하여 초기화

		for (Product pro : pList) { //pList만큼 반복하여 result 에 pro값을 입력
			result += pro + "\n";
		}
		return result;
	}

	/*
	이 메서드가 받는 값 :제품코드
	이 메서드가 주는 값 :등록된 객체의 익덱스 위치 없다면 -1 를 돌려준다. (-1은 인덱스 값으로 존재할수 없기때문에, 위치와 존재여부를 동시에 알수 있다.)*/ 
	public int searchIndex(String pCode) {
		int result = -1;
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getpCode().equals(pCode)) {//제품코드가 같다면
				result = i;
			}
		}
		return result;
	}
	/*
	이 메서드가 받는 값 :등록된 객체의 익덱스 위치
	이 메서드가 주는 값 :등록된 객체의 정보 String */ 
	public String searchByIndex(int index) {
		String result = null;

		result = pList.get(index).toString();

		return result;
	}
	/*
	이 메서드가 받는 값 :제품코드
	이 메서드가 주는 값 :삭제성공 여부 boolean */
	public boolean deleteProduct(String pCode) { //제품의 code를 받아옴
		//boolean값으로 보냄
		boolean result = true; //return해줄 result값을 만듬
		int index = searchIndex(pCode);
		if (index != -1) { //-1이 아닐때 제품이 존재한다고 판단
			pList.remove(index);
		} else {
			result = false;// 삭제실패
		}
		return result;
	}
	
	/*
	이 메서드가 받는 값 :수량, 제품코드
	이 메서드가 주는 값 :구매성공 여부 boolean */
	public boolean sellProduct(int amount, String pCode) {
		boolean result = true;

		int index = searchIndex(pCode);//객체의 위치를 Service 인덱스 찾는 메서드로 찾는다.
		if (index != -1) {//객체가 리스트안에 있다면..

			if (pList.get(index).getNumber() < amount) {
				//index안의 제품의 수량이 구매하려는 수량다 적다면
				result = false; //값을 false로 주어 구매 할 수 없도록함
				return result;
			} else {
				totalSold += pList.get(index).getNumber() * amount;//누적변수에 판매 금약을 누적한다.
				pList.get(index).setNumber(pList.get(index).getNumber() - amount);//원래수량에 구매 수량 만큰 뺀다.
				return result; //그렇지않고 수량보다 많거나 같을경우 setNumber에 수정한 getNumber값을 입력한다.
			}
		} else {//리스트 안에 없다면..
			result = false;
			return result;
		}
	}
	/*
	이 메서드가 받는 값 :유통기한
	이 메서드가 주는 값 :해당 유통기한을 가진 객체의 정보 String */
	public String searchByDueDate(String dueDate) {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Food) {
				if (((Food) pList.get(i)).getDueDate().equals(dueDate)) {
					result += pList.get(i) + "\n";
				}
			}
		}
		return result;
	}

	/*
	이 메서드가 받는 값 :약품유효기한
	이 메서드가 주는 값 :해당 유효기한을 가진 객체의 정보 String */
	public String searchBySelfLife(String shelfLife) {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Medicine) {
				if (((Medicine) pList.get(i)).getShelfLife().equals(shelfLife)) {
					result += pList.get(i) + "\n";
				}
			}
		}
		return result;
	}
	/*
	이 메서드가 받는 값 :없음
	이 메서드가 주는 값 :전체 Food 객체의 정보 String */
	public String allFood() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Food) {
				result += pList.get(i) + "\n";

			}
		}
		return result;
	}

	/*
	이 메서드가 받는 값 :없음
	이 메서드가 주는 값 :전체 Medicine 객체의 정보 String */
	public String allMedicine() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Medicine) {
				result += pList.get(i) + "\n";

			}
		}
		return result;
	}

	/*
	이 메서드가 받는 값 :없음
	이 메서드가 주는 값 :전체 Product 객체의 정보 String */
	public String allProduct() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (!(pList.get(i) instanceof Medicine)&&!(pList.get(i) instanceof Food)) {
				result += pList.get(i) + "\n";
			}
		}
		return result;
	}

	/*
	이 메서드가 받는 값 :없음
	이 메서드가 주는 값 :전체 리스트안의 객체중 수량이 0인 객체의 누적정보 String*/
	public String zeroAmountProduct() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getNumber()==0) {
				result += pList.get(i) + "\n";
			}
		}
		return result;
	}

	/*
	이 메서드가 받는 값 :없음
	이 메서드가 주는 값 :누적 판매액 int*/
	public int getTotalSold() {
		return totalSold;
	}
}
