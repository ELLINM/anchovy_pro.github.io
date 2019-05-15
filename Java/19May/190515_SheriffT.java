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
// if 문으로 처음 p가 Sheriff에 포함되는지 확인 포함된다면 ssn과 officernum이 null값인지 아닌지 확인하여 null이라면 true로 리턴
		} else if (p instanceof Criminal) {

			if (searchPersonBySsn(p.getSsn()) == null
					&& searchCriminalByCriminalNum(((Criminal) p).getCriminalNum()) == null) {
				result = true;
				pList.add(p);
			}
//else if 문에서 p가 Criminal에 포함되는지 확인 포함된다면 ssn과 criminalnum이 null값인지 아닌지 확인하여 null이라면 true로 리턴
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
		// Sheriff 와 Criminal의 search Method에서 null값이 return된다면
			s.getcList().add(c);
		// Sheriff vo의 cList에 검색된 c를 추가해준다.
			pList.remove(c);
		// 그리고 pList에서 c에대한 정보를 삭제
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
		//Sheriff를 sList로 선언한 ArrayList에 대입하기 위하여 instanceof를 실행

		for (int i = 0; i < sList.size(); i++) {
			for (int j = i; j < sList.size(); j++) {
				if (sList.get(i).getcList().size() < sList.get(j).getcList().size()) {
					temp = sList.get(i);
					sList.set(i, sList.get(j));
					sList.set(j, temp);
		// Sheriff가 등록된 sList를 for문을 사용하여 각 위치의 Sheriff의 길이를 구하여 길이가 긴 Sheriff를 정렬 시킨다.
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
		//bounty비교를 위해 Criminal을 대입할 ArrayList를 선언
		Criminal temp = null;
		// 비교연산에 필요한 Criminal형의 temp를 선언
		String result = "";
		// result -> 출력에 필요한 String 변수 선언

		for (Person p : pList) {
			if (p instanceof Criminal) {
			//Person형의 p가 Criminal에 포함되는지 확인
				criList.add((Criminal) p);
				//포함된p를 Criminal형으로 criList에 저장
			} else if (p instanceof Sheriff) {
			//체포되어있을 경우를 판단하여 p가 Sheriff에 포함되는지 확인 
				for (int j = 0; j < ((Sheriff) p).getcList().size(); j++) {
				//포함되어 있다면 p의 bounty를 알기 위해서 for문으로 검색
					criList.add(((Sheriff) p).getcList().get(j));
					//마찬가지로 criList에 저장
				}
			}
		}

		for (int i = 0; i < criList.size(); i++) {
			//p를 저장한 criList를 for문으로 검색
			for (int j = i; j < criList.size(); j++) {
				if (criList.get(i).getBounty() < criList.get(j).getBounty()) {
				//i 와 j문으로 검색하여 각각 bounty값을 비교해 준다.
					temp = criList.get(i);
					//비교 값중에 작은 값을 마련된 temp에 저장
					criList.set(i, criList.get(j));
					//저장하고 남은 criList(i)값에서 set변수를 가져와 j를
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
