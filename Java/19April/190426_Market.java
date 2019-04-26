//VO

//product
package VO;

public class Product {
	
	private String name;
	private String pCode;
	private int number;
	private int price;
	
	public Product() {
		super();
	}

	public Product(String name, String pCode, int number, int price) {
		super();
		this.name = name;
		this.pCode = pCode;
		this.number = number;
		this.price = price;
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
		return "제품명 = " + name + ", 제품 코드 = " + pCode + ", 수량 = " + number + ", 가격 = " + price;
	}
	
}

//Food

package VO;

public class Food extends Product{
	
	private int calorie;
	private String dueDate;
	
	public Food() {
		super();
	}
	

	public Food(String name, String pCode, int number, int price, int calorie, String dueDate) {
		super(name, pCode, number, price);
		this.calorie = calorie;
		this.dueDate = dueDate;
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
		return super.toString() + "칼로리 = " + calorie + ", 유통기한 = " + dueDate;
	}
	

}

//Medicine

package VO;

public class Medicine extends Product {
	
	private String kind;
	private String shelfLife;
	
	public Medicine() {
		super();
	}
	
	public Medicine(String name, String pCode, int number, int price, String kind, String shelfLife) {
		super(name, pCode, number, price);
		this.kind = kind;
		this.shelfLife = shelfLife;
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
		return super.toString() + "약품 = " + kind + ", 유효기간 = " + shelfLife;
	}
	
	
}


//Main

package Main;

import UI.ProductUI;

public class ProductMain {
	public static void main(String[] args) {
		new ProductUI();
	}
}


//UI

package UI;

import java.util.Scanner;

import Manager.ProductManager;
import VO.Food;
import VO.Medicine;
import VO.Product;

public class ProductUI {
	
	private Scanner sc = new Scanner(System.in);
	private int choice, calorie, number, price;
	private String name, pCode, dueDate, kind, shelfLife;
	private ProductManager pm = new ProductManager();
	
	public ProductUI() {
		
		while (true) {
			
			menu();
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				subMenu();
				choice = sc.nextInt();
				
				System.out.println("제품명 입력");
				name = sc.next();
				
				System.out.println("제품코드 입혁");
				pCode = sc.next();
				
				System.out.println("수량 입력");
				number = sc.nextInt();
				
				System.out.println("가격 입력");
				price = sc.nextInt();
				
				switch(choice) {
				case 1:
					Product p = new Product(name, pCode, number, price);
					pm.insertProduct(p);
					break;
				case 2:
					System.out.println("칼로리 입력");
					calorie = sc.nextInt();
					
					System.out.println("유통기한 입력");
					dueDate = sc.next();
					
					Food f = new Food(name, pCode, number, price, calorie, dueDate);
					pm.insertProduct(f);
					break;
				case 3:
					System.out.println("약품 종류 입력");
					kind = sc.next();
					
					System.out.println("유효 기간 입력");
					shelfLife = sc.next();
					
					Medicine m = new Medicine(name, pCode, number, price, kind, shelfLife);
					pm.insertProduct(m);
					break;
				}
				break;
			case 2:
				pm.print();
				break;
			case 3:
				System.out.println("제품 코드를 입력하세요");
				pCode = sc.next();
				
				System.out.println(pm.searchProduct(pCode));
				break;
			case 4:
				System.out.println("제품 코드를 입력하세요");
				pCode = sc.next();
				
				pm.deleteProduct(pCode);
				break;
			case 5:
				System.out.println("수량 입력");
				number = sc.nextInt();
				
				System.out.println("제품 코드 입력");
				pCode = sc.next();
				break;
			case 6:
				int print5 = pm.selllProduct();
				System.out.println(print5);
				break;
			case 7:	
				System.out.println("식품 유통기한 입력");
				dueDate = sc.next();
				
				System.out.println(pm.searchDuedate(dueDate));
				break;
			case 8:
				System.out.println("약품 유효기간 입력");
				shelfLife = sc.next();
				
				System.out.println(pm.searchShelfLife(shelfLife));
				break;
			case 9:
				String print = pm.searchFood();
				System.out.println(print);	
				break;
			case 10:
				String print2 = pm.searchMedicine();
				System.out.println(print2);
				break;
			case 11:
				String print3 = pm.searchProduct();
				System.out.println(print3);
				break;
			case 12:
				String print4 = pm.searchZero();
				System.out.println(print4);
				break;
				
			}
		}
		
	}
	
	public void menu() {
		System.out.println("=========================");
		System.out.println("1. 등록");
		System.out.println("2. 전체 출력");
		System.out.println("3. 제품 코드 검색");
		System.out.println("4. 제품 삭제(제품코드 입력)");
		System.out.println("5. 판매(수량, 제품코드 입력)");
		System.out.println("6. 총  판매액 계산");
		System.out.println("7. 식품 유통기한 검색");
		System.out.println("8. 약품 유효기간 검색");
		System.out.println("9. 식품 총 출력");
		System.out.println("10. 약품 총 출력");
		System.out.println("11. 일반제품 총 출력");
		System.out.println("12. 재고0 제품 출력");
		System.out.println("=========================");
	}
	
	public void subMenu() {
		System.out.println("==============");
		System.out.println("1. 일반 제품");
		System.out.println("2. 식품");
		System.out.println("3. 의약 제품");
		System.out.println("==============");
		
	}

}


//Manger

package Manager;

import java.util.ArrayList;

import VO.Product;
import VO.Food;
import VO.Medicine;

public class ProductManager {
	
	private ArrayList <Product> pList = new ArrayList<>();
	private int total = 0;
	
	public void insertProduct(Product p) {
		pList.add(p);
	}
	public void print() {
		for (Product product:pList) {
			System.out.println(product);
		}
	}
	public String searchProduct(String pCode) {
		String result = "";
		
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getpCode().equals(pCode)) {
				result += pList.get(i);
			}
		}
		return result;
	}
	public void deleteProduct(String pCode) {
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getpCode().equals(pCode)) {
				pList.remove(i);
			}
		}
	}
	
	public int sellProduct(String pCode, int number) {
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getpCode().equals(pCode)&&pList.get(i).getNumber()>=number) {
				total += pList.get(i).getPrice()*number;
				pList.get(i).getNumber() -= number;
			}
		}
		return total;
	}
	
	public String searchDuedate(String dueDate) {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getpCode().equals(dueDate)) {
				result += pList.get(i).toString();
			}
		}
		return result;
	}
	
	public String searchShelfLife(String shelfLife) {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getpCode().equals(shelfLife)) {
				result += pList.get(i).toString();
			}
		}
		return result;
	}
	public String searchFood() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Food) {
				result += pList.get(i).toString();
			}
			
		}
		return result;
	}
	
	public String searchMedicine() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Medicine) {
				result += pList.get(i).toString();
			}
		}
		return result;
	}
	
	public String searchProduct() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Product) {
				result += pList.get(i).toString();
			}
		}
		return result;
	}
	public String searchZero() {
		String result = "";
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).getNumber() == 0) {
				result += pList.get(i);
			}
		}
		return result;
	}
}
