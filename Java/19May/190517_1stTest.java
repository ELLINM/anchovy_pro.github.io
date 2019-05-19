//Vo
//Product
package global.sesoc.vo;

import java.io.Serializable;

public class Product implements Serializable {
	private String productId;	// 제품고유번호
	private String productName;	// 물품명
	private int unitPrice;		// 단가
	private int quantity;		// 재고수량
	private int price;			// 판매가
	
	public Product() { }
	public Product(String productId, String productName, int unitPrice, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.price = unitPrice + (int)( unitPrice*0.3);
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
		this.price = unitPrice + (int)( unitPrice*0.15);
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String temp = null;
		temp = String.format("%4s  %-10s  %,6d원   %5d개  %,11d원", productId, productName, unitPrice, quantity, price);
		
		return temp;
	}
}

//CustomerPurchase
package global.sesoc.vo;

public class CustomerPurchase extends Product {
	private String email;			// 이메일
	private String productId;		// 구매한 제품고유번호
	private int buyQuantity;		// 구매한 수량

	// constructor
	public CustomerPurchase() { }

	public CustomerPurchase(String email, String productId, int buyQuantity) {
		this.productId = productId;
		this.email = email;
		this.buyQuantity = buyQuantity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getBuyQuantity() {
		return buyQuantity;
	}

	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}

	@Override
	public String toString() {
		String temp = null;
		temp = String.format("%-10s  %5d개  ", super.getProductName(), buyQuantity);
		return temp;
	}
}


//Main
package global.sesoc.test;

import global.sesoc.ui.PurchaseUI;

public class Main {
	public static void main(String[] args) {
		new PurchaseUI();
	}
}	


//UI
package global.sesoc.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import global.sesoc.service.PurchaseServiceImpl;
import global.sesoc.vo.Product;
import global.sesoc.vo.CustomerPurchase;

public class PurchaseUI {
	Scanner keyin = new Scanner(System.in);
	Scanner keyin2 = new Scanner(System.in);
	PurchaseServiceImpl service = new PurchaseServiceImpl();
	private boolean flag = true;
	
	public PurchaseUI() {
		String choice = null;
		
		while(flag) {
			mainMenu();
			choice = keyin.next();
				switch(choice) {
				case "1" : 
					ownerProcess();
					break;
				case "2" : 
					customerProcess();
					break;
						
				case "0" :
					System.out.println("** 프로그램을 종료합니다.");						
					service.saveFile();
					flag = false;
					// 모든 파일을 저장하고 종료
					
				default : 
					System.out.println("다시입력해주세요");
					return;
			}
		}
	}

	/**
	 * 주메뉴
	 */
	private void mainMenu() {
		System.out.println();
		Calendar calendar = Calendar.getInstance();
		int year  = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int date   = calendar.get(Calendar.DATE);
		
		System.out.println("         << 나미야 문방구 >>");
		System.out.println(year+"년 " + month + "월 " + date +"일");
		System.out.println("==============================");
		System.out.println("    1. 판매자");
		System.out.println("    2. 고  객");
		System.out.println("    0. 종  료");
		System.out.println("==============================");
		System.out.print  ("    >> 선택 : ");
	}

	///////////////////////// 판매자 관련 업무 ///////////////////////////
	/**
	 * 판매자 관련 메뉴를 화면에 출력함
	 */
	private void ownerProcess() {
		String choice = null;
		try {
			while(true) {
				ownerMenu();
				choice = keyin.next();
			
				switch(choice) {
				case "1" : 	// 판매자가 판매할 물품을 구매하여 재고를 확보
					ownerBuy();
					break;
				case "2" : 	// 판매자가 현재 재고를 확인
					stockCheck();
					break;

				case "3" : 	// 판매자가 오늘의 판매 수익을 확인
					profitCheck();
					break;

				case "0" : 	// 이전 화면으로 돌아감
					return;

				default : 
					System.out.println("** 오류 : 메뉴를 다시 선택해 주세요");
					keyin.nextLine();
				}
			}
		}catch (Exception e) {
			System.out.println("다시 입력해 주세요");
			keyin.nextLine();
			return;
		}
	}

	/**
	 * 판매자 메뉴
	 */
	private void ownerMenu() {
		System.out.println();
		System.out.println("           << 판매자 >>");
		System.out.println("==============================");
		System.out.println("    1. 물품 구입");
		System.out.println("    2. 재고 확인");
		System.out.println("    3. 판매 수익 확인");
		System.out.println("    0. 이전 메뉴로");
		System.out.println("==============================");
		System.out.print  ("    >> 선택 : ");
	}
	/**
	 * 판매자가 판매 물품 전체에 대한 재고를 확인
	 */
	private void stockCheck() {
		ArrayList<Product> productList = service.stockCheck();

		if(productList.size() == 0 ) {
			System.out.println("** 재고 물품이 하나도 없습니다. 판매할 물품의 재고를 확보하세요");
			return;
		}
		System.out.println("\n          [ 현재 판매 가능한 재고 수량 ]");
		System.out.println(" 품목번호      품목명                단가          재고              판매가 ");
		System.out.println("===============================================");

		for(Product product : productList)
			System.out.println(product);

	}
	/**
	 * 판매자가 물품 구매
	 */
	private void ownerBuy() {
		// 지역변수 선언
		String productId   = null;
		String productName = null;
		int quantity       = 0;
		int unitPrice      = 0;

		try {
			System.out.print("1) 제품 일련번호 : ");
			productId = keyin.next();

			// 기존 제품이 존재하는지 확인
			Product product = service.stockCheck(productId);

			// 이전에 판매한 적 있는 물품 등록
			if(product != null) {
				System.out.println(product);
				System.out.print("2) 구매 수량 : ");	
				quantity = keyin2.nextInt();

				service.stockUpdate(productId, quantity);
			} 

			// 이전에 판매한 적 없는 새로운 물품
			else {
				System.out.print("2) 물품명 : ");
				productName = keyin.next();
				System.out.print("3) 단가 : ");
				unitPrice = keyin2.nextInt();
				System.out.print("4) 구매 수량 : ");
				quantity = keyin2.nextInt();

				service.stockCreate(new Product(productId, productName, unitPrice, quantity));
			}
		} catch(Exception e) {
			System.out.println("** 입력 데이터 오류. 처음으로 돌아갑니다.");
			keyin.nextLine();

			return;
		}

		System.out.println("** 물품 구매 완료");
	}
	
	/**
	 * 현재 판매 이윤체크
	 */
	private void profitCheck() {
		ArrayList<Product> todaySales = service.nowSalesList();
		String result = "";
		
		if(todaySales.size() == 0) {
			System.out.println("** 오늘은 한 개도 판매하지 못했습니다.");
			return;
		}
		
		int totalPrice = service.totalSold();
		
		System.out.println("\n                [ 현재 판매 총액 및 이윤 ]");
		System.out.println(" 물품번호      물품명                단가         판매 수량         판매가              판매이익 ");
		System.out.println("============================================================");
		for (Product p : todaySales) {
			result += p + "\n";
		}
		System.out.println(result);
		// Code Here
		
		System.out.println("=======================================================");
		System.out.println("현재까지 총 이윤 : " + service.totalSold());
	}

	///////////////////////// 구매자 관련 업무 ///////////////////////////
	private void customerProcess() {
		String choice = null;
			while(true) {
				customerMenu();

				choice = keyin.next();

			switch(choice) {
			case "1" : 		// 구매하기
				customerBuy();
				break;
			case "2" : 		// 구매 내역 확인
				purchaseCheck();
				break;
			case "0" : 		// 이전 화면으로
				return;
				default : 
				System.out.println("** 메뉴를 다시 선택해 주세요");
				keyin.nextLine();
			}
		}
	}
	
	/**
	 * 구매자 메뉴
	 */
	private void customerMenu() {
		System.out.println();
		System.out.println("           << 구매자 >>");
		System.out.println("==============================");
		System.out.println("    1. 물건 구매하기");
		System.out.println("    2. 구매 내역 확인");
		System.out.println("    0. 이전 메뉴로");
		System.out.println("==============================");
		System.out.print  ("    >> 선택 : ");
	}

	/**
	 * 고객이 물건 구매 하기
	 */
	private void customerBuy() {
		String email = null;			// 고객 이메일
		String productId = null;		// 구매품 일련변호
		int buyQuantity = 0;				// 구매수량
		
		ArrayList<Product> product = service.stockCheck();
		boolean flag = false;
		
		System.out.println("\n>> 구매 가능한 품목");
		for(Product p : product) {
			if(p.getQuantity() > 0) {
				System.out.printf("%s)\t%s(%d개)\t%,6d원%n", p.getProductId(), p.getProductName(), p.getQuantity(), p.getPrice());
				flag = true;
			}
		}
			System.out.println("고객 이메일");
			email = keyin.next();
		
			System.out.println("구매할 품목 고유번호");
			productId = keyin.next();
		
			System.out.println("구매 수량");
			buyQuantity = keyin2.nextInt();
		
			service.todaySales(new CustomerPurchase(email, productId, buyQuantity));
			if(!flag) {
				System.out.println("** 죄송합니다. 오늘은 판매할 물건이 없습니다. 다음에 이용해 주세요");
				return;
			}
	
		// 고객이 물건을 구매하는 프로세스 처리
		// 이메일, 구매할 품목 고유번호를 입력받고 해당 고유번호와 동일한 품목이 있는지 검사한 후
		// 해당 품목이 존재하지 않을 경우 고객에게 알림
		// 구매수량을 입력받았는데, 재고수량보다 많은 경우 판매할 수 없다는 메시지 출력
		// Code Here

	}
	
	/**
	 * 고객이 자신이 오늘 구매한 품목을 확인함
	 */
	public void purchaseCheck() {
		String email = null;			// 고객 이메일
		int total = 0;					// 총 구매가
		String result = "";
		
		System.out.println(">> 고객 이메일 : ");
		email = keyin.next();
		
		ArrayList<CustomerPurchase> buyList = service.todayPurchase(email);
		
		if (buyList != null) {
			System.out.println("\n     [ 고객님의 구매 내역 ]");
			System.out.println("> 고객님 이메일 : " + email);
			System.out.println(" 물품번호      물품명             구매수량        총 구매가");
			System.out.println("===================================");
			for (int i = 0; i < buyList.size(); i++) {
				result += buyList.get(i).getProductId() +" " 
						+ buyList.get(i).getProductName() + " " 
						+ buyList.get(i).getBuyQuantity() 
						+ " " + (buyList.get(i).getUnitPrice()*buyList.get(i).getBuyQuantity());
			}
			System.out.println(result);
		}else {
			System.out.println("** 구매 내역이 없습니다.");
		}
	}

		
		// 고객의 이메일을 입력받아 그 고객이 구매한 내쳑을 출력하고, 총 구매한 가격도 계산하여 출력한다.
		// 만약 구매한 내역이 없으면 구매 내역이 없다는 메시지 출력
		// Code Here

}


//Service
package global.sesoc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import global.sesoc.vo.Product;
import global.sesoc.vo.CustomerPurchase;

public class PurchaseServiceImpl implements PurchaseService  {
	ArrayList<Product> productList = new ArrayList<>();				// 판매자가 판매하는 모든 물품
	ArrayList<Product> todaySales  = new ArrayList<>();				// 판매자가 오늘 판매한 모든 물품
	ArrayList<CustomerPurchase> customerSales = new ArrayList<>();	// 고객이 구매한 물품 목록
	
	private final String file = "purchaseList.dat";
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private int totalSold = 0;
	
	public PurchaseServiceImpl() {
		try {
			loadFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}
	
	/** 
	 * 특정 물품에 대한 재고 확인
	 * @param productId : 재고를 확인할 품목에 대한 id
	 * @return 
	 */
	@Override
	public Product stockCheck(String productId) {
		// Code Here
		for (Product p : productList) {
			if (productId.equals(p.getProductId())) {
				return p;
			}
		}
		return null;
	}

	/**
	 * 전체 물품에 대한 재고 확인
	 */
	@Override
	public ArrayList<Product> stockCheck() {
		ArrayList <Product> pList = new ArrayList<>();
		for (Product p : productList) {
			pList.add(p);
		}
		return pList;
	}
	
	/**
	 * 새로운 물품 등록
	 * @param product : 판매자가 판매할 새로운 물품을 등록하낟.
	 * @return	등록 여부
	 */
	@Override
	public boolean stockCreate(Product product) {
			if (stockCheck(product.getProductId()) == null) {
				productList.add(product);
				return true;
			}
		return false;
		}

	/**
	 * 판매자가 기존에 판매하던 물품의 수량을 업데이트
	 * @param productId : 물품 ID
	 * @param quantity  : 추가 구매 수량
	 * @return
	 */
	@Override
	public boolean stockUpdate(String productId, int quantity) {
		// Code Here
		int total = 0;
		if (stockCheck(productId) != null) {
			for(Product p : productList) {
				if(productId.equals(p.getProductId())) {
					total = p.getQuantity();
					total += quantity;
					p.setQuantity(total);
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * 오늘 판매한 내용을 리턴함
	 * @return
	 */
	@Override
	public ArrayList<Product> nowSalesList() {
		ArrayList<Product> sList = new ArrayList<>();
		for(Product p : todaySales) {
			sList.add(p);
		}
		return sList;
	}
	
	/**
	 * 고객에게 물품을 판매함
	 * 고객이 물품을 구매하면 구매한 품목온 todaySales 목록에 추가하고
	 * 전체 품목 리스트에서는 판매한 만큼 수량을 뺀다.
	 * @param purchase : 고객이 구매한 폼목
	 */
	@Override
	public boolean todaySales(CustomerPurchase purchase) {
		// 전체 물품 리스트에서 판매한 만큼 수량을 뺌

		ArrayList <Product> proList = new ArrayList<>();
		for (Product p : productList) {
			proList.add(p);
		}
		for(int i = 0; i < proList.size(); i++) {
			if(purchase.getBuyQuantity() < proList.get(i).getQuantity()) {
				todaySales.add(proList.get(i));
				todaySales.get(i).setQuantity(todaySales.get(i).getQuantity() * 0);
				todaySales.get(i).setQuantity(todaySales.get(i).getQuantity() + purchase.getBuyQuantity());
				totalSold += proList.get(i).getUnitPrice() * purchase.getBuyQuantity() 
						+ (proList.get(i).getUnitPrice() * purchase.getBuyQuantity()* 0.3);
				return true;
			}
			productList.get(i).setQuantity(productList.get(i).getQuantity() - purchase.getBuyQuantity());
			customerSales.add((CustomerPurchase)todaySales.get(i));
			if(purchase.getBuyQuantity() > productList.get(i).getQuantity()) {
				return false;				
			}
		}
		// Code Here
		return false;
	}
	
	/**
	 * 고객이 자신의 이메일을 통해 총 구매 내역을 확인한다.
	 * @param email
	 * @return
	 */
	@Override
	public ArrayList<CustomerPurchase> todayPurchase(String email) {
		
		ArrayList<CustomerPurchase> buyList = new ArrayList<>();
		
		for(int i = 0; i < customerSales.size(); i++) {
			if(email.equals(customerSales.get(i).getEmail())) {
				buyList.get(i);
			}
		}
		// Code Here
		return buyList;
	}
	
	/**
	 * 판매하는 모든 물품의 재고내역을 파일에서 불러옴
	 */
	@Override
	public void loadFile() throws Exception{
		if(new File(file).exists()) {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			
			productList = (ArrayList<Product>)ois.readObject();
			
			ois.readObject();
			ois.close();
		}
		// Code Here
	}
	/**
	 * 판매하는 모든 물품의 재고 내역을 파일로 저장함
	 */
	@Override
	public void saveFile() {

		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(productList);
			
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Code Here
	}
	
	public int totalSold() {
		
		return totalSold;
	}
}


//Interface
package global.sesoc.service;

import java.util.ArrayList;

import global.sesoc.vo.Product;
import global.sesoc.vo.CustomerPurchase;

public interface PurchaseService {
	/** 
	 * 특정 품목에 대한 재고 확인하는 메서드
	 * @param   productId : 재고를 확인할 품목에 대한 id
	 * @return  Product   : 재고가 확인된 품목 객체
	 */
	public Product stockCheck(String productId);

	/**
	 * 판매하는 전체 품목에 대한 재고 확인
	 * @return  ArrayList<Product>   : 판매하는 모든 품목에 대한 재고 목록
	 */
	public ArrayList<Product> stockCheck();
	
	/**
	 * 새로운 물품 등록
	 * @param   product : 판매자가 판매할 새로운 물품을 등록한다.
	 * @return	등록 여부 (true:등록완료, false:등록불가)
	 */
	public boolean stockCreate(Product product);

	/**
	 * 판매자가 기존에 판매하던 품목의 수량을 수정
	 * @param productId : 품목 ID
	 * @param quantity  : 추가 구매 수량
	 * @return
	 */
	public boolean stockUpdate(String productId, int quantity);

	/**
	 * 현재 판매한 매출 내역 조회
	 * @return ArrayList<Product> : 현재 판매한 매출 내역 집계를 위한 전체 목록  
	 */
	public ArrayList<Product> nowSalesList();
	
	/**
	 * 고객이 물품을 구매하면 구매한 품목온 todaySales 목록에 추가하고
	 * 전체 품목 리스트에서는 판매한 만큼 수량을 뺀다.
	 * @param purchase : 고객이 구매한 폼목
	 */

	public boolean todaySales(CustomerPurchase purchase);
	
	/**
	 * 고객이 자신의 이메일을 통해 총 구매 내역을 확인
	 * @param email
	 * @return
	 */
	public ArrayList<CustomerPurchase> todayPurchase(String email);
	
	/**
	 * 판매하는 모든 물품의 재고내역을 파일에서 불러옴
	 * @throws Exception 
	 */
	public void loadFile() throws Exception ;

	/**
	 * 판매하는 모든 물품의 재고 내역을 파일로 저장함
	 */
	public void saveFile();
}

