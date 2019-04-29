//Ex1
package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMain {
	
	public static void main(String [] args) {
		
	Scanner sc = new Scanner(System.in);
	int num = 0;
		
	System.out.println("숫자 입력");
	
	try { //try문안에서 선언된것은 try문 안에서만 사용가능
		num = sc.nextInt(); //try에서 문제가 발생하면 catch로 넘어감
		// 입력하는 순간 대입이 되는데 오류를 입력하게되면 대입을 하지않고 초기값을 가지고옴
		System.out.println("입력성공");
	}catch(InputMismatchException exc) {
		//catch(Exception exc) 을 사용하여 모든 Exception을 처리 할 수 있음
	/*catch(Exception e) {
		e.printStackTrace();
	}를 통하여 프로그램을 정상 종료 시키고 오류를 확인 할 수 있음*/
		num = 99;
		System.out.println("입력오류");
		//초기값을 설정해줄 수 있음
	}
	System.out.println("프로그램 종료 입력한 값 : " + num);
	}
}


//Ex2

package ui;

import java.util.Scanner;

import service.ConService;
import vo.Food;
import vo.Medicine;
import vo.Product;

public class ConUI {

	private ConService cs;
	private Scanner sc = new Scanner(System.in);
	private Scanner sc2 = new Scanner(System.in);
	private int choice, calorie, price, number;
	private String name, pCode, dueDate, shelfLife, kind, info;
	private boolean flag = true;
	private boolean result;

	public ConUI() {
		cs = new ConService();

		while (flag) { //while문 전체를 try문으로 묶어도 된다.
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				subMenu();
				try {
					choice = sc.nextInt();
					Product made = insertProduct(choice);
					cs.insertProduct(made);	
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 2:
				System.out.println(cs.printAll());
				break;
			case 3:
				System.out.println("검색할 제품코드 입력 : ");
				try{
					pCode = sc2.nextLine();
					System.out.println(searchProduct(pCode));
				}catch(Exception e) {
					e.printStackTrace();	
				}
				break;
			case 4:
				System.out.println("삭제할 제품코드 입력 : ");
				try{
					pCode = sc2.nextLine();
					result = deleteProduct(pCode);
					if (result) {
						System.out.println("삭제성공");
					} else {
						System.out.println("**ERROR -없는 제품 번호");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					System.out.println("구매할 제품코드 입력 : ");
					pCode = sc.next();
					System.out.println("구매 수량 입력 : ");
					number = sc.nextInt();
					result = sellProduct(number, pCode);
					if (result) {
						System.out.println("구매성공");
					} else {
						System.out.println("**ERROR -구매 실패(수량과 제품번호를 잘 입력해주세요 ***)");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("총 판매 액 : " + cs.getTotalSold() + "원");
				break;
			case 7:
				try{
					System.out.println("유통기한 입력 : ");
					dueDate = sc2.nextLine();
					info = cs.searchByDueDate(dueDate);
					if (!info.equals("")) {
						System.out.println(info);
					} else {
						System.out.println("검색 결과 없음");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 8:
				try{
					System.out.println("약품유효기한 입력 : ");
					shelfLife = sc2.nextLine();
					info = cs.searchBySelfLife(shelfLife);
					if (!info.equals("")) {
						System.out.println(info);
					} else {
						System.out.println("검색 결과 없음");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				System.out.println(cs.allFood());
				break;
			case 10:
				System.out.println(cs.allMedicine());
				break;
			case 11:
				System.out.println(cs.allProduct());
				break;
			case 12:
				System.out.println(cs.zeroAmountProduct());
				break;
			case 13:
				System.out.println("**SYSTEM - 종료합니다.");
				flag=false;
				break;

			}
		}

	}

	public void menu() {//메인메뉴 출력
		try{
			System.out.println("====================================");
			System.out.println("1.등록");
			System.out.println("2.전체출력");
			System.out.println("3.제품코드검색");
			System.out.println("4.제품삭제(제품코드입력)");
			System.out.println("5.판매(수량,제품코드입력)");
			System.out.println("6.총판매액계산");
			System.out.println("7.식품유통기한검색");
			System.out.println("8.약품유효기간검색");
			System.out.println("9.식품총출력");
			System.out.println("10.약품총출력");
			System.out.println("11.일반제품총출력");
			System.out.println("12.수량 0 인제품출력");
			System.out.println("13.종료");
			System.out.println("====================================");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void subMenu() {//서브메뉴 출력
		try{
			System.out.println("====================================");
			System.out.println("1.일반제품등록");
			System.out.println("2.식품등록");
			System.out.println("3.약품등록");
			System.out.println("====================================");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Product insertProduct(int choice) {

		try{
			System.out.println("제품명 입력 : ");
			name = sc2.nextLine();
			System.out.println("제품코드 입력 : ");
			pCode = sc2.nextLine();
			System.out.println("수량 입력 : ");
			number = sc.nextInt();
			System.out.println("가격 입력 : ");
			price = sc.nextInt();
		}catch(Exception e) {
			e.printStackTrace();
		}

		switch (choice) {
		case 1:
			return new Product(name, pCode, number, price);
		case 2:
			try{
				System.out.println("칼로리 입력 : ");
				calorie = sc.nextInt();
				System.out.println("유통기한 입력 : ");
				dueDate = sc2.nextLine();
				return new Food(name, pCode, number, price, calorie, dueDate);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		case 3:
			try{
				System.out.println("약품종류 입력 : ");
				kind = sc2.nextLine();
				System.out.println("유효기한 입력 : ");
				shelfLife = sc2.nextLine();
				return new Medicine(name, pCode, number, price, kind, shelfLife);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			return null;
	}
	public String searchProduct(String pCode) {
		int index = cs.searchIndex(pCode);
		String result = cs.searchByIndex(index);
		return result;
	}
	public boolean deleteProduct(String pCode) {
		boolean result = cs.deleteProduct(pCode);
		return result;
	}
	public boolean sellProduct(int amount, String pCode) {
		boolean result = cs.sellProduct(amount, pCode);
		return result;
	}

}
