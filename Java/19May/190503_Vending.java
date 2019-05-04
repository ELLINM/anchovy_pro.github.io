//VO
//Product
package vo;

public class Product {

	private String name;// 제품명
	private String pCode;// 제품코드
	private int price;// 가격
	private int amount;// 현재수량

	public Product(String name, String pCode, int price, int amount) {
		super();
		this.name = name;
		this.pCode = pCode;
		this.price = price;
		this.amount = amount;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "이름 = " + name + ", 제품코드 = " + pCode + ", 가격 = " + price + ", 현재수량 = " + amount;
	}
}

//Drink
package vo;

public class Drink extends Product {

	private String volume;// ml 용량

	public Drink(String name, String pCode, int price, int amount, String volume) {
		super(name, pCode, price, amount);
		this.volume = volume;
	}

	public Drink() {
		super();
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return super.toString() + ", 용량 = " + volume;
	}
}

//Snack
package vo;

public class Snack extends Product{

	private String weight;//무게 gram

	public Snack(String name, String pCode, int price, int amount, String weight) {
		super(name, pCode, price, amount);
		this.weight = weight;
	}

	public Snack() {
		super();
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return super.toString()+", 무게 = " + weight;
	}
}


//Account
package vo;

public class Account {

	private String id;//관리자 계정 id
	private String pw;//관리자 계정 pw

	public Account(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public Account() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "관리자계정ID = " + id + ", 관리자계정PW = " + pw;
	}
}


//Main
package main;

import ui.VendingUI;

public class VendingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VendingUI();
	}
}


//Interface
package service.interfaceImp;

import java.util.ArrayList;

import vo.Product;

public interface ServiceInterface {

	public String insertMoney(int price);//고객에 지폐를 넣는다.(고객용)
	public int buyProduct(int buttonNumber);//상품사기(고객용)
	public String showProducts();//비치된 상품 보여주기(고객용)
	public String amountZeroList();//재고충전이 필요한 상품리스트 출력(관리자용) //재고가 10개 미만인 재품
	public boolean setProduct(String pCode,int amount);//재고충전(관리자용) //어떤 상품을 몇개 채울것인가
	public ArrayList<Product> soldListStatistics();//판매된 상품 리스트출력(관리자용)
	public boolean loginAdmin(String id, String pw);//관리자 로그인(관리자용)
}


//UI

package ui;

import java.util.ArrayList;
import java.util.Scanner;

import service.VendingService;
import vo.Drink;
import vo.Product;
import vo.Snack;

public class VendingUI {
	
	private int buttonNumber, price, amount;
	private String name, pCode, volume, weight, id, pw;
	private boolean flag = true;
	private Scanner sc = new Scanner(System.in);
	private Scanner sc2 = new Scanner(System.in);
	private VendingService vs = new VendingService(); 

	public VendingUI() {
		
		while (flag) {
			menu();
			buttonNumber = sc.nextInt();
			
			switch(buttonNumber) {
			case 1:
				System.out.println(vs.showProducts());
				break;
			case 2:
				System.out.println("금액을 넣어주세요");
				price = sc.nextInt();
				
				vs.insertMoney(price);
				System.out.println(vs.insertMoney(price));
				break;
			case 3:
				productMenu();
				buttonNumber = sc.nextInt();
				
				vs.buyProduct(buttonNumber);
				System.out.println(vs.buyProduct(buttonNumber));
				break;
			case 4:
				System.out.println("id를 입력 하세요");
				id  =  sc2.next();
				
				System.out.println("pw를 입력 하세요");
				pw = sc2.next();
				
				adminMenu();
				buttonNumber = sc.nextInt();
				boolean f = vs.loginAdmin(id, pw);
				if (f = true) {
					adminMenu();
					buttonNumber = sc.nextInt();
					switch(buttonNumber) {
					case 1:
						System.out.println("충전할 제품 코드를 입력하세요");
						pCode = sc2.next();
						
						System.out.println("충전할 제품 수량을 입력 하세요");
						amount = sc.nextInt();
						
						vs.setProduct(pCode, amount);
						break;
					case 2:
						showAmountZeroList();
						break;
					case 3:
						soldListStatistics();
						break;
						
					}
				}else {
					System.out.println("다시 입력해 주세요");
				}
				break;
				
			}
		}

	}

	public void menu() {
		System.out.println("==========사용자메뉴==========");
		System.out.println("1.상품보기"); // 전체 메뉴 출력
		System.out.println("2.지폐넣기"); // 입금 확인 프로그램
		System.out.println("3.상품구매"); // sell 프로그램
		System.out.println("4.관리자 로그인"); // 관리자 메뉴 전환 id,pw 입력 지정된 id, pw 와 비교 
		System.out.println("===========================");
	}

	public void adminMenu() {
		System.out.println("===========관리자용============");
		System.out.println("1.재고충전"); //각 메뉴 배열 insert
		System.out.println("2.재고가필요한상품목록"); //수량이 10개 미만 메뉴 출력
		System.out.println("3.판매된제품통계"); // 전체 판매 내역 출력
		System.out.println("===========================");
	}
	
	public void productMenu() {
		System.out.println("========전체메뉴========");
		System.out.println("1. 초코감자칩 1500원");	
		System.out.println("2. 츄러츄러스 1800원");	
		System.out.println("3. 촉촉오징어 2100");	
		System.out.println("4. 하늘보리칩 1600원");	
		System.out.println("5. 정브라우니 1800원");	
		System.out.println("6. 히말라야츄 1500원");	
		System.out.println("7. 밀크소다 1000원");	
		System.out.println("8. 비암강장제  1800원");	
		System.out.println("9. 핵사이다 1500원");	
		System.out.println("10. 강탄산수 1000원");	
		System.out.println("11. 한강점프콜라 1200원");
		System.out.println("12. 골든티  1000원");	
		System.out.println("=======================");
		
	}
	
	public void showAmountZeroList() {
		System.out.println(vs.amountZeroList());
	}
	public void soldListStatistics() {
		
		String result = "";
		ArrayList<Product> sellingList = vs.soldListStatistics();
		
		for (Product nowProduct : sellingList) {
			result += nowProduct + "\n";
		}
		
		if (result.equals("")) {
			result = "판매된 제품이 없습니다. (^^;;)\n";
		}
		
		System.out.println(result);
	}
}


//Service

package service;

import java.util.ArrayList;

import service.interfaceImp.ServiceInterface;
import vo.Account;
import vo.Drink;
import vo.Product;
import vo.Snack;

public class VendingService implements ServiceInterface{

	private ArrayList<Product> sellingList;// 판매중인 리스트
	private ArrayList<Product> soldList;// 판매된 상품리스트
	private ArrayList<Account> adminAccount;// 관리자 계정정보
	private int money;//고객이 넣은 지폐

	public VendingService() {
		sellingList = new ArrayList<>();
		soldList = new ArrayList<>();
		adminAccount = new ArrayList<>();
		// 상품 초기화					name	pCode	price amount volume,weight
		sellingList.add(new Snack("초코감자칩", "001", 1500, 100, "100g"));	//버튼 1번
		sellingList.add(new Snack("츄러츄러스", "002", 1800, 100, "120g"));	//버튼 2번
		sellingList.add(new Snack("촉촉오징어", "003", 2100, 100, "200g"));	//버튼 3번
		sellingList.add(new Snack("하늘보리칩", "004", 1600, 100, "140g"));	//버튼 4번
		sellingList.add(new Snack("정브라우니", "005", 1800, 100, "110g"));	//버튼 5번
		sellingList.add(new Snack("히말라야츄", "006", 1500, 100, "90g"));		//버튼 6번
		sellingList.add(new Drink("밀크소다", "007", 1000, 100, "150ml"));	//버튼 7번
		sellingList.add(new Drink("비암강장제", "008", 1800, 100, "150ml"));	//버튼 8번
		sellingList.add(new Drink("핵사이다", "009", 1500, 100, "250ml"));	//버튼 9번
		sellingList.add(new Drink("강탄산수", "010", 1000, 100, "150ml"));	//버튼 10번
		sellingList.add(new Drink("한강점프콜라", "011", 1200, 100, "180ml")); //버튼 11번
		sellingList.add(new Drink("골든티", "012", 1000, 100, "150ml"));		//버튼 12번

		adminAccount.add(new Account("admin", "1234"));//관리자 계정 초기화
	}


	@Override
	public String insertMoney(int price) {//사용자가 지폐(price)를 넣는다. 얼마를 넣냐에 따라 무엇을 살수있는지, 제품명과 가격만 String 으로 보여준다.
		// TODO Auto-generated method stub
		String result = "";
		money = price;
		for (int i = 0; i < sellingList.size(); i++) {
			if (price>=sellingList.get(i).getPrice()) {
				result += (i+1) +". " + sellingList.get(i).getName() + " " + sellingList.get(i).getPrice() + "\n";
			}
		}
		return result;
	}
	
	/*public String insertMoney(int price) {//사용자가 지폐(price)를 넣는다. 얼마를 넣냐에 따라 무엇을 살수있는지, 제품명과 가격만 String 으로 보여준다.
		// TODO Auto-generated method stub
		String result = "";
		money = price;
		for (Product p : sellingList) {
			if (price>=p.getPrice()) {
				result += p.getName() + " " + p.getPrice() + "\n";
			}
		}
		return result;
	}*/

	@Override
	public int buyProduct(int buttonNumber) {//사용자에게 버튼을 입력 받아 구매 성공여부를 리턴한다. 한번에 1개씩만 구매하고 거스름돈을 준다.
		// TODO Auto-generated method stub
		int change = 0;
		if (money >= sellingList.get(buttonNumber-1).getPrice()) {
				change = money - sellingList.get(buttonNumber-1).getPrice();			
		}
		return change;
	}

	@Override
	public String showProducts() {//지폐를 넣기전 사용자가 상품 전체리스트를 본다.
		// TODO Auto-generated method stub
		String result = "";

		for (int i = 0; i < sellingList.size(); i++) {
			result += i + ". "+ sellingList.get(i).getName() + " " + sellingList.get(i).getPrice() + "\n";
		}
		
		return result;
	}

	@Override
	public String amountZeroList() {//관리자가 사용하는 재고가 10개 미만인 상품리스트 출력 관리자용 메서드
		// TODO Auto-generated method stub
		String result = "";
		for(Product p : sellingList) {
			if(p.getAmount() < 10) {
				result += p + "\n";
			}
		}
		if (result.equals("")) {
			result = "모든 제품이 재고가 충분합니다. (^^)\n";
		}
		return result;
	}

	@Override
	public boolean setProduct(String pCode, int amount) {//부족한 재고를 채워넣는 관리자용 메서드
		// TODO Auto-generated method stub
		boolean flag = true;
		for (Product p : sellingList) {
			if(p.getpCode().equals(pCode)) {
				if (p.getAmount()<10) {
					p.setAmount(p.getAmount() + amount);
				}
			}
		}
		return flag;
	}

	@Override
	public ArrayList<Product> soldListStatistics() {//판매 리스트를 확인하는 관리자용 메서드
		// TODO Auto-generated method stub
		return soldList;
	}

	@Override
	public boolean loginAdmin(String id, String pw) {//관리자로그인, 관리자계정으로 로그인해야 사용할 수 있는 기능등이 있다.
		// TODO Auto-generated method stub
		boolean flag = true;
		for (int i = 0; i < adminAccount.size(); i++) {
			if (id.equals(adminAccount.get(i).getId())&&id.equals(adminAccount.get(i).getPw())) {
				flag = true;
			}else {
				flag = false;
			}
		}
		return flag;
	}
}

