//VO
//Person
package vo;

import java.io.Serializable;

public class Person implements Serializable {

	private String name;// 이름
	private String ssn;// 등록번호

	public Person(String name, String ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 등록번호=" + ssn;
	}
}

//Sheriff
package vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Sheriff extends Person implements Serializable {

	private String officerNum;// 보안관번호
	private ArrayList<Criminal> cList = new ArrayList<Criminal>();// 보안관이 잡은 범죄자
																	// 리스트

	public Sheriff(String name, String ssn, String officerNum, ArrayList<Criminal> cList) {
		super(name, ssn);
		this.officerNum = officerNum;
		this.cList = cList;
	}

	public Sheriff(String name, String ssn, String officerNum) {
		super(name, ssn);
		this.officerNum = officerNum;
	}

	public Sheriff() {
	}

	public String getOfficerNum() {
		return officerNum;
	}

	public void setOfficerNum(String officerNum) {
		this.officerNum = officerNum;
	}

	public ArrayList<Criminal> getcList() {
		return cList;
	}

	public void setcList(ArrayList<Criminal> cList) {
		this.cList = cList;
	}

	@Override
	public String toString() {
		return super.toString() + ", 보안관번호=" + officerNum + ", 잡은 범죄자목록=" + cList;
	}
}

//Criminal
package vo;

import java.io.Serializable;

public class Criminal extends Person implements Serializable {

	private String crimeTitle;// 범죄명
	private int bounty;// 현상금
	private String criminalNum;// 범죄자등록번호

	public Criminal(String name, String ssn, String crimeTitle, int bounty, String criminalNum) {
		super(name, ssn);
		this.crimeTitle = crimeTitle;
		this.bounty = bounty;
		this.criminalNum = criminalNum;
	}

	public Criminal() {
	}

	public String getCrimeTitle() {
		return crimeTitle;
	}

	public void setCrimeTitle(String crimeTitle) {
		this.crimeTitle = crimeTitle;
	}

	public int getBounty() {
		return bounty;
	}

	public void setBounty(int bounty) {
		this.bounty = bounty;
	}

	public String getCriminalNum() {
		return criminalNum;
	}

	public void setCriminalNum(String criminalNum) {
		this.criminalNum = criminalNum;
	}

	@Override
	public String toString() {
		return super.toString() + ", 죄목명=" + crimeTitle + ", 현상금=" + bounty + "원, 범죄자등록번호=" + criminalNum;
	}
}


//Main
package main;

import ui.SheriffUI;

public class SheriffMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SheriffUI();
	}
}


//UI
package ui;

import java.util.Scanner;

import service.SheriffService;
import vo.Criminal;
import vo.Sheriff;

public class SheriffUI {

	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private SheriffService ss = new SheriffService();
	private boolean flag = true;
	private int choice, bounty;
	private String name, ssn, crimeTitle, criminalNum, officerNum;

	public SheriffUI() {

		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if (insertPerson()) {
					System.out.println("등록성공");
				} else {
					System.out.println("등록실패 ****");
				}
				break;
			case 2:
				System.out.println("주민번호입력 : ");
				ssn = scLine.nextLine();
				System.out.println(ss.searchPersonBySsn(ssn));
				break;
			case 3:
				System.out.println("보안관번호입력 : ");
				officerNum = scLine.nextLine();
				System.out.println(ss.searchSheriffByOfficerNum(officerNum));
				break;
			case 4:
				System.out.println("범죄자번호입력 : ");
				criminalNum = scLine.nextLine();
				System.out.println(ss.searchCriminalByCriminalNum(criminalNum));
				break;
			case 5:
				System.out.println("잡은보안관번호입력 : ");
				officerNum = scLine.nextLine();
				System.out.println("잡힌범죄자번호입력 : ");
				criminalNum = scLine.nextLine();
				if (ss.caughtCriminal(officerNum, criminalNum)) {
					System.out.println("맵핑성공");
				} else {
					System.out.println("맵핑실패");
				}
				break;
			case 6:
				System.out.println(ss.orderSheriffByHighCaught());
				break;
			case 7:
				System.out.println(ss.orderCriminalByHighBounty());
				break;
			case 8:
				System.out.println(ss.unCaughtCriminalList());
				break;
			case 9:
				System.out.println(ss.printAll());
				break;
			case 99:
				ss.saveFile();
				flag = false;
				break;
			}
		}

	}

	public void menu() {
		System.out.println("============================");
		System.out.println("1.인적사항등록");
		System.out.println("2.주민번호로사람검색");
		System.out.println("3.보안관번호로검색");
		System.out.println("4.범죄자등록번호로검색");
		System.out.println("5.잡힌범죄자등록");
		System.out.println("6.보안관출력(범죄자검거수순으로)");
		System.out.println("7.범죄자출력(높은현상금순으로)");
		System.out.println("8.미검거범죄자 전체출력");
		System.out.println("9.모든사람 전체출력(보안관 ->범죄자순)");
		System.out.println("99.프로그램종료");
		System.out.println("============================");
	}

	public boolean insertPerson() {
		boolean result = false;
		System.out.println("1.보안관 등록");
		System.out.println("2.범죄자 등록");
		System.out.println("============================");
		choice = sc.nextInt();

		System.out.println("이름 입력 : ");
		name = scLine.nextLine();
		System.out.println("주민번호 입력 : ");
		ssn = scLine.nextLine();
		switch (choice) {
		case 1:
			System.out.println("보안관 번호 입력 : ");
			officerNum = scLine.nextLine();
			result = ss.insertPerson(new Sheriff(name, ssn, officerNum));
			break;
		case 2:
			System.out.println("범죄명 입력 : ");
			crimeTitle = scLine.nextLine();
			System.out.println("현상금 입력 : ");
			bounty = sc.nextInt();
			System.out.println("범죄자 등록번호 입력 : ");
			criminalNum = scLine.nextLine();
			result = ss.insertPerson(new Criminal(name, ssn, crimeTitle, bounty, criminalNum));
			break;
		}
		return result;
	}
}


//Service

package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.Criminal;
import vo.Person;
import vo.Sheriff;

public class SheriffService implements ServiceInterface {
	ArrayList<Person> pList = new ArrayList<>();
	ArrayList<Criminal> cList = new ArrayList<>();
	ArrayList<Sheriff> sList = new ArrayList<>();
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private File file = new File("C:/test/SpeedWagon.txt");

	@Override
	public boolean insertPerson(Person p) {
		// TODO Auto-generated method stub

		if ((searchPersonBySsn(p.getSsn()) == null)) {
			if ((p instanceof Sheriff && searchSheriffByOfficerNum(((Sheriff) p).getOfficerNum()) == null)
					|| ((p instanceof Criminal
							&& searchCriminalByCriminalNum(((Criminal) p).getCriminalNum()) == null))) {

				pList.add(p);
				return true;
			}
		}

		return false;
	}

	@Override
	public Person searchPersonBySsn(String ssn) {
		// TODO Auto-generated method stub

		for (Person person : pList) {
			if (ssn.equals(person.getSsn())) {
				return person;
			}
		}
		return null;
	}

	@Override
	public Sheriff searchSheriffByOfficerNum(String officerNum) {
		// TODO Auto-generated method stub
		for (Person p : pList) {
			if (p instanceof Sheriff) {
				if (officerNum.equals(((Sheriff) p).getOfficerNum())) {
					return (Sheriff) p;
				}
			}
		}
		return null;
	}

	@Override
	public Criminal searchCriminalByCriminalNum(String criminalNum) {
		// TODO Auto-generated method stub
		for (Person p : pList) {
			if (p instanceof Criminal) {
				if (criminalNum.equals(((Criminal) p).getCriminalNum())) {
					return (Criminal) p;
				}
			}
		}
		return null;
	}

	@Override
	public boolean caughtCriminal(String officerNum, String criminalNum) {
		// TODO Auto-generated method stub
		int count = 0;
		Criminal c = new Criminal();
		Sheriff s = new Sheriff();
		for (Person p : pList) {
			if (p instanceof Criminal || p instanceof Sheriff) {
				if (officerNum.equals(s.getOfficerNum()) || criminalNum.equals(c.getCriminalNum())) {

					count++;
				}
			}
		}
		return false;
	}

	@Override
	public String orderSheriffByHighCaught() {
		// TODO Auto-generated method stub
		String result = "";
		for (Person p : pList) {
			if (p instanceof Sheriff) {

			}
		}
		return null;
	}

	@Override
	public String orderCriminalByHighBounty() {
		// TODO Auto-generated method stub
		String result = "";
		for (Person p : pList) {
			if (p instanceof Criminal) {
				cList.add((Criminal) p);
				for (int i = 0; i < cList.size() - 1; i++) {
					int num = i;
					int temp;
					for (int j = 0; j < cList.size(); j++) {
						if (cList.get(i).getBounty() > cList.get(j).getBounty()) {
							num = i;
						}
					}
					/*
					 * temp = i; i = cList.get(j); items[i] = temp;
					 */
				}
			}
		}
		return null;
	}

	@Override
	public String unCaughtCriminalList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printAll() {
		// TODO Auto-generated method stub
		String result = "";

		for (Person p : pList) {
			if (p instanceof Sheriff) {
				result += p + "\n";
			}
		}
		for (Person p : pList) {
			if (p instanceof Criminal) {
				result += p + "\n";
			}
		}
		return result;
	}

	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(pList);
			oos.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadFile() {
		// TODO Auto-generated method stub
		try {
			if (file.exists()) {
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);
				pList = (ArrayList<Person>) ois.readObject();
			}
			saveFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
