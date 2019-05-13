//VO
package vo;

public class Person {
	
	private String name;
	private String ssn;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
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
		return "이름 = " + name + ", 주민등록 번호 = " + ssn;
	}
}


//Main
package main;

import ui.PersonUI;

public class PersonMain {
 
	public static void main(String [] args) {
		new PersonUI();
	}
}


//UI
package ui;

import java.util.*;

import service.PersonService;
import vo.Person;

public class PersonUI {
	
	private Scanner sc = new Scanner(System.in);
	private String ssn, name;
	private int choice;
	private boolean flag = true;
	private PersonService ps = new PersonService();

	public PersonUI() {
		
		while (flag) {
			
			menu();
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				Person p = insertPerson();
				ps.insertPerson(p);
				break;
			case 2:
				System.out.println("주민 번호르 입력하세요");
				ssn = sc.next();
				
				System.out.println(ps.searchPerson(ssn));
				break;
			case 3:
				System.out.println(ps.printAll());
				break;
			case 4:
				break;
			case 5:
				break;
				
			}
		}
	}
	
	public void menu() {
		System.out.println("==============");
		System.out.println("1. 등록하기");
		System.out.println("2. 주민번호 검색");
		System.out.println("3. 전체출력");
		System.out.println("4. 주민삭제");
		System.out.println("5. 주민정보 수정");
		System.out.println("==============");
	}
	
	public Person insertPerson() {
		System.out.println("이름 입력");
		name = sc.next();
		
		System.out.println("주민번호 입력");
		ssn = sc.next();
		
		return new Person(name, ssn);
	}
}


//Service

package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import vo.Person;

public class PersonService {
	
	private Map <String, Person> pMap = new HashMap<>();
		// String : key값 Person : 해당하는 사람의 정보
	public boolean insertPerson(Person p){
		boolean flag = true;
		Set<String> keys = pMap.keySet();
		
		for(String s : keys) {
			if (s.equals(p.getSsn())) {
				flag = false;
			}
		}
		if (flag) {
			pMap.put(p.getSsn(),p);
		}
		return flag;
	}
	
	public String printAll() {
		String result = "";
		Set<String> keys = pMap.keySet();
		
		for(String s : keys) {
			result += pMap.get(s) + "\n";
		}
		return result;
	}
	
	public String searchPerson(String ssn) {
		String result = "";
		Set<String> keys = pMap.keySet();
		
		for (String s : keys) {
			if (s.equals(ssn)) {
				result += pMap.get(s) + "\n";
			}
		}
		return result;
	}
}
