//VO
//Class Product
package VO;

public class Product {
	private String name;
	private String pCode;
	private int price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, String pCode, int price) {
		super();
		this.name = name;
		this.pCode = pCode;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "상품명 = " + name + ", 제품 코드 = " + pCode + ", 가격 = " + price;
	}
	
}

//Class Note
package VO;

public class Note extends Product {
	private int noPage;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(String name, String pCode, int price, int noPage) {
		super(name, pCode, price);
		// TODO Auto-generated constructor stub
		this.noPage = noPage;
	}

	public int getNoPage() {
		return noPage;
	}

	public void setNoPage(int noPage) {
		this.noPage = noPage;
	}

	@Override
	public String toString() {
		return super.toString() + ", 페이지 = " + noPage;
	}	
}

//Class Pencil
package VO;

public class Pencil extends Product {
	private String kind;

	public Pencil() {
		super();
	}

	public Pencil(String name, String pCode, int price, String kind) {
		super(name, pCode, price);
		// TODO Auto-generated constructor stub
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return super.toString() + "종류 = " + kind;
	}

}


//Main
package Main;

import UI.ProductUI;

public class Main {
	public static void main(String [] args) {
		new ProductUI();
	}

}

//UI

package UI;

import java.util.*;

import Service.ProductServicce;
import VO.Note;
import VO.Pencil;
import VO.Product;

public class ProductUI {
	private Scanner sc = new Scanner(System.in);
	private int choice, page, price;
	private String name, kind, pCode;
	private ProductServicce ps = new ProductServicce();
	
	public ProductUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				subMenu();
				choice = sc.nextInt();
				
				System.out.println("젱품명 입력 : ");
				name = sc.next();
				
				System.out.println("가격 입력 : ");
				price = sc.nextInt();
				
				System.out.println("제품 코드 입력 : ");
				pCode = sc.next();
				
				switch (choice) {
				case 1:
					Product p  = new Product(name, pCode, price);
					ps.insertProduct(p);
					break;
				case 2:
					System.out.println("장 수 입력 : ");
					page = sc.nextInt();
					
					Note n = new Note(name, pCode, price, page);
					ps.insertProduct(n);
					break;
				case 3:
					System.out.println("종류 입력 : ");
					kind = sc.next();
					
					Pencil pe = new Pencil(name, pCode, price, kind);
					ps.insertProduct(pe);					
					break;
				}
				break;
			case 2:
				String print = ps.printAll(); //SErvice에서 return값을 받아 프린트 변수에 입력
				System.out.println(print); //출력을 담당하기 위해 print값을 받아 
				break;
			case 3:
				System.out.println("제품번호 입력 : ");
				pCode = sc.next();
				
				ps.checkProduct(pCode);
				break;
			}
		}
	}
	
	public void menu() {
		System.out.println("===============");
		System.out.println("1. 등록");
		System.out.println("2. 전체 출력");
		System.out.println("===============");
	}
	
	public void subMenu() {
		System.out.println("===============");
		System.out.println("1. 일반 제품");
		System.out.println("2. 노트 제품");
		System.out.println("3. 연필 제품");
		System.out.println("===============");
	}
	

}

//Service

package Service;

import VO.Product;

public class ProductServicce {
	private Product [] pArray = new Product[10000];
	private int cnt = 0;
	
	public void insertProduct(Product p) {
		pArray[cnt++] = p;
	}
	public String printAll() {
		String result = "";
		
		for (int i = 0; i < cnt; i++) {
			result += pArray[i].toString() + "\n";
		}
		return result;
	} //출력은 UI에서 담당하도록 return값을 만들어 
	public boolean checkProduct(String pCode) {
		boolean flag = false;
		for (int i = 0; i < cnt; i++) {
			if (pArray[i].getpCode().equals(pCode)) {
				flag = true;
				System.out.println(pArray[i]);
			}
		}
		return flag;
	}
}
