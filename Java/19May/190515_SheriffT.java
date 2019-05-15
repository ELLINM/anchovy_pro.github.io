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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import vo.Criminal;
import vo.Person;
import vo.Sheriff;

public class SheriffService implements ServiceInterface{

	private ArrayList<Person> pList = new ArrayList<>();
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private final String FILENAME = "sheriff.dat";

	public SheriffService() {
		loadFile();
	}

	public boolean insertPerson(Person p) {
		boolean result = false;

		if (p instanceof Sheriff) {
			if (searchPersonBySsn(p.getSsn()) == null
					&& searchSheriffByOfficerNum(((Sheriff) p).getOfficerNum()) == null) {
				result = true;
				pList.add(p);
			}
		} else if (p instanceof Criminal) {

			if (searchPersonBySsn(p.getSsn()) == null
					&& searchCriminalByCriminalNum(((Criminal) p).getCriminalNum()) == null) {
				result = true;
				pList.add(p);
			}
		}

		return result;
	}

	public Person searchPersonBySsn(String ssn) {
		Person result = null;

		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Sheriff) {
				for (int j = 0; j < ((Sheriff) pList.get(i)).getcList().size(); j++) {
					if (((Sheriff) pList.get(i)).getcList().get(j).getSsn().equals(ssn)) {
						return ((Sheriff) pList.get(i)).getcList().get(j);
					}
				}
				if (pList.get(i).getSsn().equals(ssn)) {
					return pList.get(i);
				}
			} else if (pList.get(i) instanceof Criminal) {
				if (pList.get(i).getSsn().equals(ssn)) {
					return pList.get(i);
				}
			}
		}

		return result;
	}

	public Sheriff searchSheriffByOfficerNum(String officerNum) {
		Sheriff result = null;

		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Sheriff) {
				if (((Sheriff) pList.get(i)).getOfficerNum().equals(officerNum)) {
					result = (Sheriff) pList.get(i);
				}
			}
		}
		return result;
	}

	public Criminal searchCriminalByCriminalNum(String criminalNum) {
		Criminal result = null;

		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i) instanceof Sheriff) {
				for (int j = 0; j < ((Sheriff) pList.get(i)).getcList().size(); j++) {
					if (((Sheriff) pList.get(i)).getcList().get(j).getCriminalNum().equals(criminalNum)) {
						result = ((Sheriff) pList.get(i)).getcList().get(j);
					}
				}
			} else if (pList.get(i) instanceof Criminal) {
				if (((Criminal) pList.get(i)).getCriminalNum().equals(criminalNum)) {
					result = (Criminal) pList.get(i);
				}
			}
		}

		return result;
	}

	public boolean caughtCriminal(String officerNum, String criminalNum) {
		Sheriff s = searchSheriffByOfficerNum(officerNum);
		Criminal c = searchCriminalByCriminalNum(criminalNum);
		if (s != null && c != null) {
			s.getcList().add(c);
			pList.remove(c);
		}
		return s != null && c != null;
	}

	public String orderSheriffByHighCaught() {
		ArrayList<Sheriff> sList = new ArrayList<>();
		Sheriff temp = null;
		String result = "";

		for (Person p : pList) {
			if (p instanceof Sheriff) {
				sList.add((Sheriff) p);
			}
		}

		for (int i = 0; i < sList.size(); i++) {
			for (int j = i; j < sList.size(); j++) {
				if (sList.get(i).getcList().size() < sList.get(j).getcList().size()) {
					temp = sList.get(i);
					sList.set(i, sList.get(j));
					sList.set(j, temp);
				}
			}
		}
		for (Sheriff s : sList) {
			result += s + "\n";
		}

		return result;

	}

	public String orderCriminalByHighBounty() {
		ArrayList<Criminal> criList = new ArrayList<>();
		Criminal temp = null;
		String result = "";

		for (Person p : pList) {
			if (p instanceof Criminal) {
				criList.add((Criminal) p);
			} else if (p instanceof Sheriff) {
				for (int j = 0; j < ((Sheriff) p).getcList().size(); j++) {
					criList.add(((Sheriff) p).getcList().get(j));
				}
			}
		}

		for (int i = 0; i < criList.size(); i++) {
			for (int j = i; j < criList.size(); j++) {
				if (criList.get(i).getBounty() < criList.get(j).getBounty()) {
					temp = criList.get(i);
					criList.set(i, criList.get(j));
					criList.set(j, temp);
				}
			}
		}

		for (Criminal s : criList) {
			result += s + "\n";
		}

		return result;

	}

	public String unCaughtCriminalList() {
		String result = "";
		ArrayList<Criminal> criList = new ArrayList<>();
		for (Person p : pList) {
			if (p instanceof Criminal)
				criList.add((Criminal) p);
		}
		for (Criminal c : criList) {
			result += c + "\n";
		}

		return result;
	}

	public String printAll() {
		ArrayList<Person> printList = new ArrayList<>();
		String result = "";
		for (Person p : pList) {
			if (p instanceof Sheriff)
				printList.add(p);
		}

		for (Person p : pList) {
			if (p instanceof Criminal)
				printList.add(p);
		}

		for (Person p : printList) {
			result += p + "\n";
		}

		return result;

	}

	public void saveFile() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(FILENAME)));
			oos.writeObject(pList);

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

	public void loadFile() {
		if (new File(FILENAME).exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(new File(FILENAME)));
				pList = (ArrayList<Person>) ois.readObject();
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
