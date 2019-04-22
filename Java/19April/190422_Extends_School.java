//VO

package VO;

public class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
 
	public void print() {
		System.out.println("이름 : "+name+" 나이 : "+ age);
	}

}


package VO;

public class Student extends Person {

	private String stNo;

	public Student(String name, int age, String stNo) {
		super(name, age);
		this.stNo = stNo;
	}

	public Student() {
	}

	public String getStNo() {
		return stNo;
	}

	public void setStNo(String stNo) {
		this.stNo = stNo;
	}

	public void print() {
		System.out.println("이름 : " + super.getName() + " 나이 : " + super.getAge() + "학번 : " + stNo);
	}

}


package VO;

public class Teacher extends Person {

	private String tNo;

	public Teacher(String name, int age, String tNo) {
		super(name, age);
		this.tNo = tNo;
	}

	public Teacher() {
	}

	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}

	public void print() {
		System.out.println("이름 : " + super.getName() + " 나이 : " + super.getAge() + "교번 : " + tNo);
	}

}


//Main

package Main;

import UI.SchoolUI;

public class SchoolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new SchoolUI();
	}

}

//UI

package UI;

import java.util.Scanner;

import Service.SchoolService;
import VO.Student;
import VO.Teacher;

public class SchoolUI {

	private SchoolService ss=new SchoolService();
	private int choice,age;
	private String name,stNo,tNo;
	private Scanner sc=new Scanner(System.in);
	
	public SchoolUI() {
		
		while(true) {
			menu();
			choice=sc.nextInt();
			switch(choice) {
			case 1://등록하기
				subMenu();
				choice=sc.nextInt();
				
				System.out.println("이름 입력 : ");
				name=sc.next();
				System.out.println("나이 입력 : ");
				age=sc.nextInt();
				
				switch(choice) {
				case 1://학생등록하기
					System.out.println("학번 입력 : ");
					stNo=sc.next();
					
					Student st=new Student(name,age,stNo);
					ss.insertPerson(st);
					
					
					break;
				case 2://교사등록하기
					System.out.println("교번 입력 : ");
					tNo=sc.next();
					
					Teacher t=new Teacher(name,age,tNo);
					ss.insertPerson(t);
					
					break;
				}
				
				
				break;
			case 2:
				
				ss.printAll();
				
				break;
			}
		}
		
	}
	
	public void menu() {
		System.out.println("============");
		System.out.println("1.등록");
		System.out.println("2.전체출력");
		System.out.println("============");
	}
	
	public void subMenu() {
		System.out.println("============");
		System.out.println("1.학생등록");
		System.out.println("2.교사등록");
		System.out.println("============");
	}
}


//Service

package Service;

import VO.Person;

public class SchoolService {
	
	private Person [] pArray=new Person[10000];
	private int cnt=0;
	
	public void insertPerson(Person p) {
		pArray[cnt++]=p;
	}
	public void printAll() {
		for(int i=0;i<cnt;i++) {
			pArray[i].print();
		}
	}

}

