//UI
//Hall
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
package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.Customer;
import vo.DineIn;
import vo.Food;
import vo.TakeOut;

public class KitchenService implements ServiceInterface {

	private ArrayList<Food> orderList = new ArrayList<Food>();
	private ArrayList<Food> completeList = new ArrayList<Food>();
	private ArrayList<Customer> customerList = new ArrayList<Customer>();

	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	private final String FOODFILENAME = "kitchen.dat";
	private final String CUSTOMERFILENAME = "hall.dat";

	public KitchenService() {
		loadFoodFile();
		loadCustomerFile();
	}

	public boolean insertCustomer(Customer c) {
		boolean result = false;

		if (searchCustomer(c.getPhoneNum()) == null) {
			customerList.add(c);
			saveCustomerFile();
			result = true;
		}

		return result;

	}

	public boolean orderFood(String phoneNum, Food f) {

		boolean result = false;

		if (searchCustomer(phoneNum) == null) {
			return result;
		} else if (searchFood(f.getOrderNo()) == null) {
			orderList.add(f);
			searchCustomer(phoneNum).getOrderList().add(f);
			saveCustomerFile();
			saveFoodFile();
			result = true;
		}

		return result;
	}

	public Customer searchCustomer(String phoneNum) {
		Customer result = null;
		for (Customer cus : customerList) {
			if (cus.getPhoneNum().equals(phoneNum)) {
				result = cus;
			}
		}
		return result;
	}

	public Food searchFood(String orderNum) {
		loadFoodFile();
		Food result = null;
		for (Food food : orderList) {
			if (food.getOrderNo().equals(orderNum)) {
				result = food;
			}
		}
		for (Food food : completeList) {
			if (food.getOrderNo().equals(orderNum)) {
				result = food;
			}
		}
		return result;
	}

	public void completeFood(Food f) {
		orderList.remove(f);
		completeList.add(f);
		saveFoodFile();
	}

	public String serveFood(String orderNum) {
		String result = "";
		boolean flag = false;
		
		ArrayList<Food> cfList=new ArrayList<>();
		cfList.addAll(completeList);
		
		
		for(int i=0;i<cfList.size();i++) {
			if (cfList.get(i).getOrderNo().equals(orderNum)) {
				result += cfList.get(i) + "\n";
				completeList.remove(i);
				saveFoodFile();
				flag = true;
			}
		}

		for (Customer c : customerList) {
			for (int i = 0; i < c.getOrderList().size(); i++) {
				if (c.getOrderList().get(i).getOrderNo().equals(orderNum)) {

					if (c.getOrderList().get(i) instanceof DineIn) {
						result += "�꽌鍮� �뀒�씠釉� : " + ((DineIn) c.getOrderList().get(i)).getTableNo();
					} else if (c.getOrderList().get(i) instanceof TakeOut) {
						result += "諛곕떖 二쇱냼 : " + ((TakeOut) c.getOrderList().get(i)).getAddress();
					}

					flag = true;
				}
			}
		}

		if(flag) {
			saveFoodFile();
		}
		return result;
	}

	public String mostBoughtCustomer() {
		String result = "";
		Customer temp = null;

		for (int i = 0; i < customerList.size(); i++) {
			for (int j = i + 1; j < customerList.size(); j++) {
				if (customerList.get(i).getOrderList().size() < customerList.get(j).getOrderList().size()) {
					temp = customerList.get(i);
					customerList.set(i, customerList.get(j));
					customerList.set(j, temp);
				}
			}
		}

		for (Customer c : customerList) {
			result += c + "\n";
		}

		return result;
	}

	public String calculateAll() {
		String result = "珥� �뙋留ㅼ븸 : ";
		int total = 0;
		for (int i = 0; i < customerList.size(); i++) {
			for (int j = 0; j < customerList.get(i).getOrderList().size(); j++) {
				total += customerList.get(i).getOrderList().get(j).getPrice();

			}
		}
		result += total + "�썝";

		return result;
	}

	public String getComplete() {
		String result = "";
		loadFoodFile();
		for (Food f : completeList) {
			result += f + "\n";
		}
		return result;
	}

	public String getOrderList() {
		String result = "";
		loadFoodFile();
		for (Food f : orderList) {
			result += f + "\n";
		}
		return result;
	}

	public String getCustomerList() {

		String result = "";
		loadCustomerFile();
		for (Customer c : customerList) {
			result += c + "\n";
		}
		return result;
	}

	public void saveFoodFile() {
		try {
			ArrayList<ArrayList<Food>> fList = new ArrayList<>();
			fList.add(orderList);
			fList.add(completeList);
			oos = new ObjectOutputStream(new FileOutputStream(new File(FOODFILENAME)));
			oos.writeObject(fList);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void loadFoodFile() {
		if (new File(FOODFILENAME).exists()) {
			try {
				ArrayList<ArrayList<Food>> fList = new ArrayList<>();
				ois = new ObjectInputStream(new FileInputStream(new File(FOODFILENAME)));
				fList = (ArrayList<ArrayList<Food>>) ois.readObject();
				orderList = (ArrayList<Food>) fList.get(0);
				completeList = (ArrayList<Food>) fList.get(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (ois != null)
					try {
						ois.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}

	public void saveCustomerFile() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(CUSTOMERFILENAME)));
			oos.writeObject(customerList);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void loadCustomerFile() {
		if (new File(CUSTOMERFILENAME).exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(new File(CUSTOMERFILENAME)));
				customerList = (ArrayList<Customer>) ois.readObject();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (ois != null)
					try {
						ois.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}

}
