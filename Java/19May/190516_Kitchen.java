//VO
//Food
package vo;

import java.io.Serializable;

public class Food implements Serializable {

	private String orderNo;
	private String name;
	private int price;

	public Food(String orderNo, String name, int price) {
		super();
		this.orderNo = orderNo;
		this.name = name;
		this.price = price;
	}

	public Food() {

	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
		return "음식명=" + name + ", 가격=" + price + ", 주문번호=" + orderNo;
	}
}

//Customer
package vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {

	private String name;// 이름
	private String phoneNum;// 전화번호
	private ArrayList<Food> orderList = new ArrayList<>();// 주문목록

	public Customer(String name, String phoneNum) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
	}

	public Customer() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public ArrayList<Food> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Food> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 전화번호=" + phoneNum + ", 주문내역=" + orderList;
	}
}

//DineIn
package vo;

import java.io.Serializable;

public class DineIn extends Food implements Serializable {

	private String tableNo;

	public DineIn(String orderNo, String name, int price, String tableNo) {
		super(orderNo, name, price);
		this.tableNo = tableNo;
	}

	public DineIn() {
		super();
	}

	public String getTableNo() {
		return tableNo;
	}

	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}

	@Override
	public String toString() {
		return super.toString() + ", 테이블번호=" + tableNo;
	}
}

//TakeOut
package vo;

import java.io.Serializable;

public class TakeOut extends Food implements Serializable {

	private String address;

	public TakeOut(String orderNo, String name, int price, String address) {
		super(orderNo, name, price);
		this.address = address;
	}

	public TakeOut() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return super.toString() + ", 주소=" + address;
	}
}

//Main

//HallMain
package main;

import ui.HallUI;
import ui.KitchenUI;

public class HallMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HallUI();
	}
}

//Kitchen
package main;

import ui.KitchenUI;

public class KitchenMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KitchenUI();
	}
}


//UI
//HallUI
package ui;

import java.util.Scanner;

import service.KitchenService;
import vo.Customer;
import vo.DineIn;
import vo.Food;
import vo.TakeOut;

public class HallUI {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private boolean flag = true;
	private int choice, price;
	private String name, address, phoneNum, tableNo, orderNo;
	private KitchenService ks = new KitchenService();

	public HallUI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if (ks.insertCustomer(makeCustomer())) {
					System.out.println("등록성공");
				} else {
					System.out.println("등록실패****(같은 핸드폰번호존재)");
				}
				break;
			case 2:
				System.out.println("주문 하는 사람의 핸드폰번호 입력 : ");
				phoneNum = scLine.nextLine();

				if (ks.orderFood(phoneNum, makeFood())) {
					System.out.println("주문성공");
				} else {
					System.out.println("존재하지 않는 고객입니다.");
				}

				break;
			case 3:
				System.out.println("검색 하는 사람의 핸드폰번호 입력 : ");
				phoneNum = scLine.nextLine();
				Customer c = ks.searchCustomer(phoneNum);
				if (c == null) {
					System.out.println("검색하려는 사람이 없습니다.");
				} else {
					System.out.println(c);
				}
				break;
			case 4:
				System.out.println("검색 하려는 음식의 주문번호 입력 : ");
				orderNo = scLine.nextLine();
				Food f = ks.searchFood(orderNo);
				if (f == null) {
					System.out.println("검색하려는 음식이 없습니다.");
				} else {
					System.out.println(f);
				}
				break;
			case 5:
				System.out.println(ks.getComplete());
				break;
			case 6:
				System.out.println("완료된 음식 주문 번호 : ");
				orderNo = scLine.nextLine();
				System.out.println(ks.serveFood(orderNo));
				break;
			case 7:
				System.out.println(ks.mostBoughtCustomer());
				break;
			case 8:
				System.out.println(ks.calculateAll());
				break;
			case 9:
				ks.saveFoodFile();
				ks.saveCustomerFile();
				flag = false;
				break;
			}
		}
	}

	public void menu() {
		System.out.println("===================");
		System.out.println("1.고객등록");
		System.out.println("2.음식주문");
		System.out.println("3.고객검색");
		System.out.println("4.주문음식검색");
		System.out.println("5.완성된음식확인");
		System.out.println("6.완성된음식서빙/배달");
		System.out.println("7.단골고객확인");
		System.out.println("8.매출확인");
		System.out.println("9.종료");
		System.out.println("===================");
	}

	public Customer makeCustomer() {
		System.out.println("이름 입력 : ");
		name = scLine.nextLine();
		System.out.println("핸드폰 입력 : ");
		phoneNum = scLine.nextLine();

		return new Customer(name, phoneNum);
	}

	public Food makeFood() {

		Food result = null;
		System.out.println("1.매장내주문");
		System.out.println("2.배달주문");
		System.out.println("===================");
		choice = sc.nextInt();

		System.out.println("주문번호 입력 : ");
		orderNo = scLine.nextLine();
		System.out.println("이름 입력 : ");
		name = scLine.nextLine();
		System.out.println("가격 입력 : ");
		price = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("테이블번호 입력 : ");
			tableNo = scLine.nextLine();

			result = new DineIn(orderNo, name, price, tableNo);
			break;
		case 2:
			System.out.println("주소 입력 : ");
			address = scLine.nextLine();

			result = new TakeOut(orderNo, name, price, address);
			break;
		}
		return result;
	}
}

//Kitchen
package ui;

import java.util.Scanner;

import service.KitchenService;

public class KitchenUI {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private boolean flag = true;
	private int choice, price;
	private String name, address, phoneNum, tableNo, orderNo;
	private KitchenService ks = new KitchenService();

	public KitchenUI() {
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				ks.loadFoodFile();
				System.out.println(ks.getOrderList());
				break;
			case 2:

				System.out.println("주문번호 입력:");
				orderNo = scLine.nextLine();
				
				ks.completeFood(ks.searchFood(orderNo));
				
				break;
			}
		}
	}

	public void menu() {
		System.out.println("====================");
		System.out.println("1.만들어야하는 음식리스트");
		System.out.println("2.완성음식등록(주문번호로)");
		System.out.println("=====================");
	}
}


//Service
//Kitchen
package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.Customer;
import vo.Food;

public class KitchenService implements ServiceInterface{
	
	private ArrayList<Food> orderList = new ArrayList<Food>();
	private ArrayList<Food> completeList = new ArrayList<Food>();
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	private int count = 0;
	
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private FileOutputStream fos;
	private FileInputStream fis;
	
	private final String FOODFILENAME = ("kitchen.dat");
	private final String CUSTOMERFILENAME = ("hall.dat");
	
	@Override
	public boolean insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		if(searchCustomer(c.getPhoneNum()) == null) {
			customerList.add(c);
			return true;
		}
		return false;
	}

	@Override
	public boolean orderFood(String phoneNum, Food f) {
		// TODO Auto-generated method stub
		for (Customer c : customerList) {
			if (phoneNum.equals(c.getPhoneNum())) {
				orderList.add(f);
				c.getOrderList().add(f);
				return true;
			}
		}
		return false;
	}

	@Override
	public Customer searchCustomer(String phoneNum) {
		// TODO Auto-generated method stub
		for(Customer c : customerList) {
			if (phoneNum.equals(c.getPhoneNum())) {
				return c;
			}
		}
		return null;
	}

	@Override
	public Food searchFood(String orderNum) {
		// TODO Auto-generated method stub
		for (Food f : orderList) {
			if(orderNum.equals(f.getOrderNo())) {
				return f;
			}
		}
		return null;
	}

	@Override
	public void completeFood(Food f) {
		// TODO Auto-generated method stub
		for(Food food : orderList) {
			if(food.getOrderNo().equals(f.getOrderNo())) {
				completeList.add(f);
			}
			orderList.remove(f);
		}
	}

	@Override
	public String serveFood(String orderNum) {
		// TODO Auto-generated method stub
		String result = "";
		for(Food f : completeList) {
			if (orderNum.equals(f.getOrderNo())) {
				result += f + "\n";
				completeList.remove(f);
				
			}
		}
		return null;
	}

	@Override
	public String mostBoughtCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String calculateAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComplete() {
		String result = "";
		// TODO Auto-generated method stub
		for(Food f : completeList) {
			result += f + "\n";
			return result;
		}
		return null;
	}

	@Override
	public String getOrderList() {
		// TODO Auto-generated method stub
		String result = "";
		for (Food f : orderList) {
			result += f + "\n";
		}
		return result;
	}

	@Override
	public String getCustomerList() {
		// TODO Auto-generated method stub
		String result = "";
		for(Customer c : customerList) {
			result += c + "\b";
		}
		return result;
	}

	@Override
	public void saveFoodFile() {
		// TODO Auto-generated method stub
		try {
			fos = new FileOutputStream(FOODFILENAME);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(orderList);
			oos.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadFoodFile() {
		// TODO Auto-generated method stub
		try {
			fis = new FileInputStream(FOODFILENAME);
			ois = new ObjectInputStream(fis);
			orderList = (ArrayList<Food>) ois.readObject();
			
			saveFoodFile();
		}catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public void saveCustomerFile() {
		// TODO Auto-generated method stub
		try {
			fos = new FileOutputStream(CUSTOMERFILENAME);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(customerList);
			oos.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadCustomerFile() {
		// TODO Auto-generated method stub
		try {
			fis = new FileInputStream(CUSTOMERFILENAME);
			ois = new ObjectInputStream(fis);
			customerList = (ArrayList<Customer>) ois.readObject();

			saveFoodFile();
		}catch (Exception e) {
				e.printStackTrace();
		}
	}
}

