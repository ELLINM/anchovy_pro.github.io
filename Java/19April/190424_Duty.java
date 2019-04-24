//VO
//Staff
package VO;

public class Staff {
	private String name; //변수 선언
	private String ssn;
	private String position;
	
	public Staff() {
		super();
	}

	public Staff(String name, String ssn, String position) { //입력값을 받아줄 변수
		super();
		this.name = name;
		this.ssn = ssn;
		this.position = position;
	}

	public String getName() { //getter생성
		return name;
	}

	public void setName(String name) { //setter생성
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() { //toString으로 정보값을 출력
		return "이름 = " + name + "\n주민번호 = " + ssn + "\n직급 = " + position;
	}	
}

//Teacher
package VO;

public class Teacher extends Staff { //Teacher Class를 Staff Class로 상속시킴 Teacher Class는 Staff Class의 변수를 소유
	private String tsn; //Teacher Class에 필요한 tsn변수만을 선언

	public Teacher() {
		super();
	}

	public Teacher(String name, String ssn, String position, String tsn) {
		super(name, ssn, position);
		this.tsn = tsn;
	}

	public String getTsn() {
		return tsn;
	}

	public void setTsn(String tsn) {
		this.tsn = tsn;
	}

	@Override
	public String toString() { //override로 toString을 받아 Teacher Class에 맞에 변환, 
		return toString() + "\n교번 = " + tsn;
	}
	
}

//Cleaner
package VO;

public class Cleaner extends Staff{
	private String offDay;

	public Cleaner() {
		super();
	}

	public Cleaner(String name, String ssn, String position, String offDay) {
		super(name, ssn, position);
		this.offDay = offDay;
	}

	public String getOffDay() {
		return offDay;
	}

	public void setOffDay(String offDay) {
		this.offDay = offDay;
	}

	@Override
	public String toString() {
		return toString() + "\n비법 = " + offDay;
	}
}


//Main
package Main;

import UI.DutyUI;

public class DutyMain {
	public static void main(String [] args) {
		new DutyUI();		
	}
}


//UI

package UI;

import java.util.Scanner;

import Manager.DutyManager;
import VO.Staff;
import VO.Cleaner;
import VO.Teacher;


public class DutyUI {
	
	private Scanner sc = new Scanner(System.in);
	private int choice;
	private String name, ssn, position, tsn, offday;
	private DutyManager dm = new DutyManager();
	
	public DutyUI() {
		while (true) {
			menu();
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				subMenu();
				choice = sc.nextInt();
				
				System.out.println("이름입력 : ");
				name = sc.next();
				
				System.out.println("주민번호 입력 : ");
				ssn = sc.next();
				
				System.out.println("직급 입력 : ");
				position = sc.next();
				
				switch (choice) {
				case 1:
					Staff s = new Staff(name, ssn, position);
					dm.insertStaff(s);
					break;
				case 2:
					System.out.println("교번 입력 : ");
					tsn = sc.next();
					
					Teacher t = new Teacher(name, ssn, position, tsn);
					dm.insertStaff(t);
					
					break;
				case 3:
					System.out.println("비번 입력 : ");
					offday = sc.next();
					
					Cleaner c = new Cleaner(name, ssn, position, offday);
					dm.insertStaff(c);
					
					break;
				}
				break;
			case 2:
				String print = dm.printAll();
				System.out.println(print);
				break;
			case 3:
				System.out.println("주민번호를 입력하세요");
				ssn = sc.next();
				
				dm.deleteStaff(ssn);		
				break;
			case 4:
				System.out.println("주민번호를 입력하세요");
				ssn = sc.next();
				
				dm.searchStaff(ssn);			
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
				
			}
		}
	}
	
	public void menu() {
		System.out.println("==============");
		System.out.println("1. 등록");
		System.out.println("2. 전체 출력");
		System.out.println("3. 삭제");
		System.out.println("4. 주민번호 검색");
		System.out.println("5. 직급 검색");
		System.out.println("6. 교번 검색");
		System.out.println("7. 비번날 검색");
		System.out.println("8. 직급별 인원 출력");
		System.out.println("==============");	
	}
	
	public void subMenu() {
		System.out.println("===========");
		System.out.println("1. 교직원");
		System.out.println("2. 교사");
		System.out.println("3. 청소업체");
		System.out.println("===========");
	}

}


//Manager

package Manager;

import VO.Staff;
import VO.Cleaner;
import VO.Teacher;


public class DutyManager {
	private Staff [] sArray = new Staff[10000];
	private int cnt = 0;
	
	public void insertStaff(Staff s) {
		sArray[cnt++] = s;
	}
	public String printAll() {
		String result = "";
		
		for (int i = 0; i < cnt; i++) {
			result += sArray[i].toString() + "\n";
		}
		return result;
	}
	public void deleteStaff(String ssn) {
		for (int i = 0; i < cnt; i++) {
			if (sArray[i].getSsn().equals(ssn)) {
				for (int j = i; j < cnt-1; j++) {
					sArray[j] = sArray[j+1];
				}
				cnt--;
			}
		}
	}
	public void searchStaff(String ssn) {
		
		boolean flag=true;
		for(int i=0;i<cnt;i++) {
			if(sArray[i].getSsn().equals(ssn)) {
				sArray[i].toString();
				flag=false;
			}
		}
		
		if(flag) {
			System.out.println("검색 하려는 직원이 없음");
		}
	}

}

/*현재까지 오류 사항
컴파일 오류 없음 런타임중에 1번 실행후 1번등록 이상없음 2번 출력 이상없음
다시 1-2 또는 3으로 등록후에 2번 출력하면 출력이 안됨
4번 검색시 아무것도 나오지 않음*/
