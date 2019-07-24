package global.sesoc.comshop.ui;

import java.util.ArrayList;
import java.util.Scanner;

import global.sesoc.comshop.dao.ShopDAO;
import global.sesoc.comshop.vo.ProductVO;
import global.sesoc.comshop.vo.SalesVO;

/**
 * 프로그램의 UI
 * 
 * [ 전자제품 판매관리 ]
 * 1. 상품 등록
 * 2. 상품 전체 보기
 * 3. 판매정보 등록
 * 4. 판매정보 전체보기
 * 5. 판매정보 수정
 * 6. 판매정보 삭제
 * 7. 상품별 판매현황
 * 0. 종료
 * 선택> 
 */
public class ShopUI {
	boolean flag = true;
	Scanner sc = new Scanner(System.in);
	Scanner scLine = new Scanner(System.in);
	ShopDAO sd = new ShopDAO();
	
	/** 
	 * 생성자. 반복적으로 메인 메뉴를 보여주고 번호 입력받아 해당 기능 실행.
	 */
	public ShopUI() {
		
		while (flag) {
			mainMenu();
			try {
				int choice = sc.nextInt();
				switch (choice) {
				case 1://상품등록
					menu1();
					break;
				case 2://상품 전체 보기
					menu2();
					break;
				case 3://판매정보 등록
					menu3();
					break;
				case 4://판매정보 전체보기
					menu4();
					break;
				case 5://판매정보 수정
					menu5();
					break;
				case 6://판매정보 삭제
					menu6();
					break;
				case 7://상품별 판매현황
					menu7();
					break;
				case 0://종료
					System.out.println("프로그램을 종료합니다.");
					flag = false;
					break;
				default://다른번호 선택시
					System.out.println("프로그램을 종료합니다.");
					flag = false;
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("* 오류 발생. 다시 시도해 주세요.");
				sc = new Scanner(System.in);
			}
		}
	}

	public void mainMenu() {
		// TODO Auto-generated method stub
		System.out.println("[ 전자제품 판매관리 ]");
		System.out.println("1. 상품 등록");
		System.out.println("2. 상품 전체 보기");
		System.out.println("3. 판매정보 등록");
		System.out.println("4. 판매정보 전체보기");
		System.out.println("5. 판매정보 수정");
		System.out.println("6. 판매정보 삭제");
		System.out.println("7. 상품별 판매현황");
		System.out.println("0. 종료");
		System.out.print("선택 > ");
		
	}

	public void menu1() {
		// TODO Auto-generated method stub
		System.out.println("[ 상품 정보 등록 ]");
		System.out.print("상품코드 : ");
		String code = scLine.nextLine();
		System.out.print("상품명 : ");
		String pname = scLine.nextLine();
		System.out.print("단가 : ");
		int price = sc.nextInt();
		
		ProductVO pv = new ProductVO(code, pname, price);
		
		if (sd.insertProduct(pv)!=0) {//추가된 행 수가 0이 아니면(insert가 제대로 완료되면)
			System.out.println("* 저장되었습니다.");
			System.out.println();
		} else {
			System.out.println("* 저장 실패했습니다.");
			System.out.println();
		}
	}

	public void menu2() {
		// TODO Auto-generated method stub
		if (sd.listProduct()!=null) {
			System.out.println("상품코드         상품명           가격");
			System.out.println("=====================");
			for (ProductVO pv : sd.listProduct()) {
				System.out.println(pv.toString());
			}
			System.out.println();
		} else {
			System.out.println("* 불러오기 실패 : 저장된 정보가 존재하지 않거나, 알수없는 오류로 불러오기에 실패하였습니다.");
			System.out.println();
		}
	}

	public void menu3() {
		// TODO Auto-generated method stub
		System.out.println("[ 판매 정보 등록 ]");
		System.out.print("상품코드 : ");
		String code = scLine.nextLine();
		System.out.print("판매수량 : ");
		int quantity = sc.nextInt();
		
		SalesVO sv = new SalesVO(0, null, code, quantity);
		
		if(sd.insert(sv)!=0) {
			System.out.println("* 저장되었습니다.");
			System.out.println();
		} else {
			System.out.println("* 저장 실패했습니다.");
			System.out.println();
		}
	}

	public void menu4() {
		// TODO Auto-generated method stub
		if (sd.listProduct()!=null) {
			System.out.println("일련번호         상품코드           수량             판매일");
			System.out.println("===================================");
			for (SalesVO sv : sd.list()) {
				System.out.println(sv.toString());
			}
			System.out.println();
		} else {
			System.out.println("* 불러오기 실패 : 저장된 정보가 존재하지 않거나, 알수없는 오류로 불러오기에 실패하였습니다.");
			System.out.println();
		}
	}

	public void menu5() {
		// TODO Auto-generated method stub
		System.out.println("[ 판매 정보 수정 ]");
		System.out.print("수정할 번호 : ");
		int num = sc.nextInt();
		System.out.print("판매 수량 : ");
		int quantity = sc.nextInt();
		
		SalesVO sv = new SalesVO(num, null, null, quantity);
		
		if (sd.update(sv)!=0) {
			System.out.println("* 수정되었습니다.");
			System.out.println("");
		} else {
			System.out.println("* 수정실패하였습니다.");
			System.out.println("");
		}
	}

	public void menu6() {
		// TODO Auto-generated method stub
		System.out.println("[ 판매 정보 삭제 ]");
		System.out.print("삭제할 번호 : ");
		int num = sc.nextInt();
		
		if (sd.delete(num)!=0) {
			System.out.println("* 삭제되었습니다.");
			System.out.println("");
		} else {
			System.out.println("* 삭제실패하였습니다.");
			System.out.println("");
		}
	} 

	public void menu7() {
		// TODO Auto-generated method stub
		if (sd.sales()!=null) {
			System.out.println("[ 상품별 판매 현황 ]");
			System.out.println("상품코드             상품명              수량            판매금액");
			System.out.println("===================================");
			for (SalesVO sv : sd.sales()) {
				System.out.println(sv.getDate()+"       "+sv.getCode()+"               "+sv.getNum()+"      "+sv.getQuantity());
			}//여기에서만 SalesVO의 date는 상품코드, Code는 상품명, Num는 수량, Quantity는 판매금액
			System.out.println();
		} else {
			System.out.println("* 불러오기 실패 : 저장된 정보가 존재하지 않거나, 알수없는 오류로 불러오기에 실패하였습니다.");
			System.out.println();
		}
	}
	

}
