//VO
//Class Bread
package VO;

public class Bread {
	
	private String name;
	private int price;
	public Bread() {
		super(); //super는  object의 생성자
	}
	public Bread(String name, int price) {
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
	@Override
	public String toString() {
		return "빵이름 =" + name + ", 가격 = " + price;
	}

}

//Class Cake
package VO;

public class Cake extends Bread {
	
	private int size;

	public Cake() {
		super();
	}

	public Cake(String name, int prince, int size) {
		super(name, prince);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return super.toString() + "몊 호 = " + size;
	}
}

//Class Roll
package VO;

public class Roll extends Bread{
	
	private int length;

	public Roll() {
		super();
	}

	public Roll(String name, int price, int length) {
		super(name, price);
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return super.toString() + "길이 = " + length;
	}
}


//Main

package MAin;

import UI.BakeryUI;

public class BakeryMain {
	
	public static void main(String [] args) {
		new BakeryUI();
	}
}

//UI

package UI;

import java.util.Scanner;

import Service.BakeryService;
import VO.Bread;
import VO.Cake;
import VO.Roll;

public class BakeryUI {
	
	private Scanner sc = new Scanner(System.in);
	private int choice, length, size, price;
	private String name;
	private BakeryService bs = new BakeryService();
	
	public BakeryUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				
				subMenu();
				choice = sc.nextInt();
				
				System.out.println("이름 입력 : ");
				name = sc.next();
				
				System.out.println("가격 입력 : ");
				price = sc.nextInt();
				
				switch (choice) {
				case 1:
					Bread b = new Bread(name, price);
					bs.insertBread(b);
					break;
				case 2:
					System.out.println("사이즈(호) 입력 : ");
					size = sc.nextInt();
					
					Cake c = new Cake(name, price, size);
					bs.insertBread(c);
					break;
				case 3:
					System.out.println("길이(cm) 입력 : ");
					length = sc.nextInt();
					
					Roll r = new Roll(name, price, length);
					bs.insertBread(r);
					break;
				}
				
				break;
			case 2:
				bs.print();
				break;
			}
		}
		
	}
	
	public void menu() {
		System.out.println("===================");
		System.out.println("1. 등록");
		System.out.println("2. 전체 출력");
		System.out.println("===================");
		
	}
	
	public void subMenu() {
		System.out.println("===================");
		System.out.println("1. 일반 빵");
		System.out.println("1. 케이크");
		System.out.println("2. 롤");
		System.out.println("===================");
		
	}

}

//Service

package Service;

import VO.Bread;

public class BakeryService {
	
	private Bread [] bArray = new Bread[10000];
	private int cnt = 0;
	
	public void insertBread(Bread b) {//부로 형변화되어 자동으로 전부받을수 있음
		bArray[cnt++] = b;
	}
	public void print() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(bArray[i]);
		}//toString을 정의하여 주소값을 적지 않아도 출력 가능
	}

}
