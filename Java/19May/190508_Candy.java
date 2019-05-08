//VO

package VO;

import java.io.Serializable;

public class Candy implements Serializable {
	
	private String name;
	private String color;
	private int amount;
	private String flavor;
	private String pCode;
	public Candy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candy(String name, String color, int amount, String flavor, String pCode) {
		super();
		this.name = name;
		this.color = color;
		this.amount = amount;
		this.flavor = flavor;
		this.pCode = pCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	@Override
	public String toString() {
		return "제품명 = " + name + ", 색상 = " + color + ", 수량 = " + amount + ", 맛 = " + flavor + ", 제품 코드 = "
				+ pCode;
	}
	
}


//Main

package main;

import UI.CandyUI;

public class CandyMain {
	public static void main(String[] args) {
		new CandyUI();
	}
}



//UI

package UI;

import java.util.Scanner;

import Service.CandyService;
import VO.Candy;

public class CandyUI {
	
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private String pCode, name, color, flavor;
	private int amount, choice;
	private boolean flag = true;
	private CandyService cs;
	
	public CandyUI() {
		cs=new CandyService();
		while (flag) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				cs.insertCandy(makeCandy());
				break;
			case 2:
				System.out.println(cs.printAll());
				break;
			case 9:
				flag=false;
				break;
			}
		}
	}
	
	public void menu() {
		System.out.println("================");
		System.out.println("1. 제품 등록");
		System.out.println("2. 전체 출력");
		System.out.println("9. 종료");
		System.out.println("================");
		
	}
	
	public Candy makeCandy() {
		
		System.out.println("이름 입력 : ");
		name = scLine.nextLine();
		System.out.println("색상 입력 : ");
		color = scLine.nextLine();
		System.out.println("수량 입력 : ");
		amount = sc.nextInt();
		System.out.println("맛 입력 : ");
		flavor = scLine.nextLine();
		System.out.println("제품코드 입력 : ");
		pCode = scLine.nextLine();

		return new Candy(name, color, amount, flavor, pCode);
	}
}


//Service

package Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import VO.Candy;

public class CandyService {
	
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ArrayList<Candy> cList = new ArrayList<>();
	
	// 파일을 추가할 때마다 저장해주는 방법
	// 종료를 누를 때 전부 저장하는 방법
	// 전체 출력은 시스템이 켜질때
	public CandyService() {
		loadData();
	}
	
	public void insertCandy(Candy c) {//등록하기
		cList.add(c);
		saveDate();
	}
	
	public String printAll() {//전체출력
		String con = "";

		for (Candy c : cList) {
			con += c + "\n";
		}
		return con;
	}
	
	public void saveDate() { //파일 저장하기
		File f = new File("C:/test/Candy.dat");
		
		try {
			fos = new FileOutputStream(f); //파일 경로로 선언된 fos를 통해 f로 파일을 보냄
			oos = new ObjectOutputStream(fos); // fos에 object를 작성
			oos.writeObject(cList); //writer를 통해 데이터를 작성하고 cList에 저장
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void loadData() { //파일 읽어오기
		File f = new File("C:/test/Candy.dat");
		//File f 선언
		if (f.exists()) { //f가 있는지 없는지 체크한다,
			try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			cList = (ArrayList<Candy>)ois.readObject();			
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void closeStream() { //프로그램 종료
		
		if(oos!=null) {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(ois!=null) {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
