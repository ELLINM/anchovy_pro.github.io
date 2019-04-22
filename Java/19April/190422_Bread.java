// VO

package Vo;

public class Bread {
	private String name;
	private String bsn;
	private String maker;
	private int price;
	public Bread() {}
	public Bread(String name, String bsn, String maker, int price) {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBsn() {
		return bsn;
	}
	public void setBsn(String bsn) {
		this.bsn = bsn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public void print() {
		System.out.println("제품명 : " + name + "\n제조 번홍 : " + bsn + "\n가격 : " + price + "\n제조자 : " + maker);		
	}
}


//Main

package BreadMain;

import BreadUI.BreadUI;

public class BreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BreadUI();
	}
}

//UI

package BreadUI;
import java.util.Scanner;

import BreadManager.BreadManager;
import Vo.Bread;

public class BreadUI {
	Scanner sc = new Scanner(System.in);
	private String name, bsn, maker;
	private int price, choice;
	private BreadManager bm = new BreadManager();
	
	public BreadUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("제품명 : ");
				name = sc.next();
				
				System.out.println("제조 번호 : ");
				bsn = sc.next();
				
				System.out.println("제품 가격 : ");
				price = sc.nextInt();
				
				System.out.println("제조자 : ");
				maker = sc.next();
				
				Bread b = new Bread(name, bsn, maker, price);
				
				bm.insertBread(b);
				
				break;
			case 2:
				bm.print();
				break;
			case 3:
				System.out.println("제조 번호 입력 : ");
				bsn = sc.next();
				
				boolean f = bm.deleteBread(bsn);
				break;
			case 4:
				System.out.println("제조 번호 입력: ");
				bsn = sc.next();				
				
				boolean f1 = bm.checkBsn(bsn);
				if (f1 = true) {
					System.out.println("제품명 : " + name + "\n제조 번홍 : " + bsn + "\n가격 : " + price + "\n제조자 : " + maker);
				}
				break;
			}
		}
	}
	
	public void menu() {
		System.out.println("================");
		System.out.println("1. 제품 등록 : ");
		System.out.println("2. 전체 출력");
		System.out.println("3. 제품 삭제");
		System.out.println("4. 제조 번호 검색");
		System.out.println("================");
	}
}


//Manager

package BreadManager;

import Vo.Bread;

public class BreadManager {
	private Bread [] bArray = new Bread[1000];
	private int count = 0;
	
	public void insertBread(Bread b) {
		boolean flag = true;
		for (int i = 0; i < count; i++) {
			if (bArray[i].getBsn().equals(b.getBsn())) {
				flag = false;
			}
		}
		if (flag) {
			bArray[count++] = b;
		}
		
	}
	public void print() {
		for (int i = 0; i < count; i++) {
			bArray[i].print();
		}
	}
	public boolean deleteBread(String bsn) {
		boolean flag = false;
		for (int i = 0; i < count-1; i++) {
			if (bArray[i].getBsn().equals(bsn))
				for (int j = i; j < count; j++) {
					bArray[j] = bArray[j+1];
				}
			count--;
			flag = true;
		}
		return flag;
	}
	public boolean checkBsn(String bsn) {
		boolean flag = false;
		for (int i = 0; i < count; i++) {
			if (bArray[i].getBsn().equals(bsn)) {
				flag = true;
			}
		}
		return flag;
	}
}

// 오류 : 두번이상 입력하면 작동하지 않음, 등록이 제대로 되지 않음, 제조번호 검색시 
// 의문 : 선생님이 만든 코딩은 import + 다른 Class를 하지 않아도 되는데 내건 해야함
