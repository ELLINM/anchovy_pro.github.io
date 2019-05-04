//UI

package ui;

import java.util.ArrayList;

import vo.Product;

import java.util.Scanner;
import service.VendingService;

public class VendingUI {
	private Scanner sc = new Scanner(System.in);
	private VendingService vs = new VendingService();
	
	private int price, btnNumber, amount;
	private String id, pw, pCode;
	
	private int choice = 0;

	private boolean isRun = true;

	public VendingUI() {
		while (isRun) {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				showProducts();
				break;
			case 2:
				insertMoney();
				break;
			case 3:
				buyProduct();
				break;
			case 4:
				loginAdmin();
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요.\n");
				break;
			}
		}
	}

	public void menu() {
		System.out.println("==========사용자메뉴==========");
		System.out.println("1.상품보기");
		System.out.println("2.지폐넣기");
		System.out.println("3.상품구매");
		System.out.println("4.관리자 로그인");
		System.out.println("===========================");
	}
	
	public void showProducts() {
		System.out.println(vs.showProducts());
	}
	
	public void insertMoney() {
		System.out.print("지폐 금액 입력 : ");
		price = sc.nextInt();
		System.out.println();
		if (price <= 0) {
			System.out.println("삽입한 금액이 없습니다. 다시 입력해주세요.\n");
		} else {
			System.out.println(vs.insertMoney(price));
		}
	}
	
	public void buyProduct() {
		System.out.print("상품 버튼 입력 : ");
		btnNumber = sc.nextInt();
		System.out.println();
		
		if (vs.buyProduct(btnNumber) == 0) {
			System.out.println("상품 구매에 성공하였습니다.\n");
		} else {
			System.out.println("상품 구매에 실패하였습니다.\n");
		}
	}
	
	public void loginAdmin() {
		System.out.print("관리자 ID 입력 : ");
		id = sc.next();
		System.out.print("관리자 비번 입력 : ");
		pw = sc.next();
		System.out.println();
		
		if (vs.loginAdmin(id, pw)) {
			System.out.println("관리자 로그인에 성공하였습니다.\n");
			
			adminMenu();
			System.out.print("관리자 메뉴 선택 : ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				setProduct();
				break;
			case 2:
				showAmountZeroList();
				break;
			case 3:
				soldListStatistics();
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요.\n");
				break;
			}
			
		} else {
			System.out.println("관리자 로그인에 실패하였습니다.\n");
		}
	}

	public void adminMenu() {
		System.out.println("===========관리자용============");
		System.out.println("1.재고충전");
		System.out.println("2.재고가필요한상품목록");
		System.out.println("3.판매된제품통계");
		System.out.println("===========================");
	}
	
	public void setProduct() {
		System.out.print("재고 충전 제품 코드 입력 : ");
		pCode = sc.next();
		System.out.print("충전하고자 하는 재고 량 : ");
		amount = sc.nextInt();
		
		if (vs.setProduct(pCode, amount)) {
			System.out.println("재고 충전에 성공하였습니다.\n");
		} else {
			System.out.println("재고 충전에 실패하였습니다.\n");
		}
	}
	
	public void showAmountZeroList() {
		System.out.println("재고가 부족한 상품 리스트");
		System.out.println(vs.amountZeroList());
	}
	
	public void soldListStatistics() {
		// 우리의 고객(?)님이 어지간히 만들기 귀찮으셨는지 리스트를 그대로 반환하는 interface를 제공해주셨다.
		// 이런 경우에는 절대로 당황하지 말고 하나의 예외상황(!)이라고 생각하며 Service에서 구현해야 할 부분을 UI소스에서 그냥 구현해 주면 된다.
		
		// 참고로 초기의 UI소스 상단에 'import java.util.ArrayList;'와 'import vo.Product;'가 있던 이유는
		// 결국 여기서 써먹기 위한 밑밥(?!) 이였던 셈이다.
		
		String result = "";
		ArrayList<Product> sellingList = vs.soldListStatistics();
		
		for (Product nowProduct : sellingList) {
			result += nowProduct + "\n";
		}
		
		if (result.equals("")) {
			result = "판매된 제품이 없습니다. (^^;;)\n";
		}
		
		System.out.println(result);
	}
}


//Service

package service;

import java.util.ArrayList;

import service.interfaceImp.ServiceInterface;
import vo.Account;
import vo.Drink;
import vo.Product;
import vo.Snack;

public class VendingService implements ServiceInterface{

	private ArrayList<Product> sellingList;// 판매중인 리스트
	private ArrayList<Product> soldList;// 판매된 상품리스트
	private ArrayList<Account> adminAccount;// 관리자 계정정보
	private int money;//고객이 넣은 지폐

	public VendingService() {
		sellingList = new ArrayList<Product>();
		soldList = new ArrayList<Product>();
		adminAccount = new ArrayList<Account>();
		// 상품 초기화
		sellingList.add(new Snack("초코감자칩", "001", 1500, 100, "100g"));	//버튼 1번
		sellingList.add(new Snack("츄러츄러스", "002", 1800, 100, "120g"));	//버튼 2번
		sellingList.add(new Snack("촉촉오징어", "003", 2100, 100, "200g"));	//버튼 3번
		sellingList.add(new Snack("하늘보리칩", "004", 1600, 100, "140g"));	//버튼 4번
		sellingList.add(new Snack("정브라우니", "005", 1800, 100, "110g"));	//버튼 5번
		sellingList.add(new Snack("히말라야츄", "006", 1500, 100, "90g"));		//버튼 6번
		sellingList.add(new Drink("밀크소다", "007", 1000, 100, "150ml"));	//버튼 7번
		sellingList.add(new Drink("비암강장제", "008", 1800, 100, "150ml"));	//버튼 8번
		sellingList.add(new Drink("핵사이다", "009", 1500, 100, "250ml"));	//버튼 9번
		sellingList.add(new Drink("강탄산수", "010", 1000, 100, "150ml"));	//버튼 10번
		sellingList.add(new Drink("한강점프콜라", "011", 1200, 100, "180ml")); //버튼 11번
		sellingList.add(new Drink("골든티", "012", 1000, 100, "150ml"));		//버튼 12번

		adminAccount.add(new Account("admin", "1234"));//관리자 계정 초기화
	}


	@Override
	public String insertMoney(int price) {//사용자가 지폐(price)를 넣는다. 얼마를 넣냐에 따라 무엇을 살수있는지, 제품명과 가격만 String 으로 보여준다.
		// TODO Auto-generated method stub
		money += price;
		
		String result = "";
		
		result += "현재 삽입된 금액 : " + money + "\n";
		result += "구매 가능한 제품 리스트\n";
		
		for (int i=0; i<sellingList.size(); i++) {
			if (sellingList.get(i).getPrice() <= price) {
				result += "버튼 번호 : " + (i+1) + ", 상품 이름 : " + sellingList.get(i).getName() + ", 가격 : " + sellingList.get(i).getPrice() + "\n";
			}
		}
		
		return result;
	}
	
	@Override
	public int buyProduct(int buttonNumber) {//사용자에게 버튼을 입력 받아 구매 성공여부를 리턴한다. 한번에 1개씩만 구매하고 거스름돈을 준다.
		// TODO Auto-generated method stub
		
		// 1. 버튼 번호(buttonNumber)에 대한 유효성 검사
		if (buttonNumber <= 0 || (buttonNumber-1) >= sellingList.size())
			return -1;
		
		// 2. 현재 자판기에 주입된 돈(money)에 대한 액수 검사 
		if (sellingList.get(buttonNumber-1).getPrice() > money) {
			return -1;
		} else {
			
			// 2-1. 누른 버튼(buttonNumber)에 대한 상품의 현재 보유 수량(amount)에 대한 검사
			if (sellingList.get(buttonNumber-1).getAmount() > 0) {
				money -= sellingList.get(buttonNumber-1).getPrice();
				sellingList.get(buttonNumber-1).setAmount(sellingList.get(buttonNumber-1).getAmount()-1);
			} else {
				return -1;
			}
			
		}
		
		// 3. 판매된 상품 리스트(soldList)에 등록이 된 상품인지 아닌지에 대한 검사
		for (Product nowProduct : soldList) {
			
			// 3-1. 만약에 판매된 상품 리스트(soldList) 안에 있는 상품 이라면 판매 숫자(amount)만 1을 더해주며
			//		동시에 현재 남아 있는 잔액(money)을 반환하며 메소드 종료
			if (nowProduct.getpCode().equals(sellingList.get(buttonNumber-1).getpCode())) {
				nowProduct.setAmount(nowProduct.getAmount() + 1);
				return money;
			}
			
		}


		// 4. 판매된 상품 리스트(soldList)에 등록이 안된 상품이라면 새로 등록해 주어야 하는데
		//		기존의 보유 상품 리스트(sellingList)에 있는 상품에 대한 정보를 임시로 받아온다.
		Product tmpProduct = sellingList.get(buttonNumber-1);
		
		// 4-1. 기존의 보유 상품 리스트에는 총 3개의 클래스 객체가 들어갈 수 있으니
		//		클래스에 따라서 데이터 역시 맞춤형으로 캐스팅하여 넣어준다.
		if (tmpProduct instanceof Drink) {
			
			// 4-2. 모든 데이터가 동일하게 들어가는 가운데 유일하게  수량은 1로서 초기화 하여
			//		판매된 상품 리스트(soldList)에 신규 추가한다.
			soldList.add(new Drink(((Drink)tmpProduct).getName(),
							((Drink)tmpProduct).getpCode(),
							((Drink)tmpProduct).getPrice(),
							1,		// 이게 amount
							((Drink)tmpProduct).getVolume()));
			
		} else if (tmpProduct instanceof Snack) {
			
			soldList.add(new Snack(((Snack)tmpProduct).getName(),
							((Snack)tmpProduct).getpCode(),
							((Snack)tmpProduct).getPrice(),
							1,		// 이놈이 amount
							((Snack)tmpProduct).getWeight()));
			
		} else {
			
			soldList.add(new Product(tmpProduct.getName(),
							tmpProduct.getpCode(),
							tmpProduct.getPrice(),
							1));	// 하여튼 이놈의 짜식이 amount
			
		}
		
		/* soldList에 add를 하여 객체를 새롭게 추가하는 이유는 기존의 리스트에 있는 내용을 그대로 add하여 추가하게 되는 경우
		 * 해당 객체의 '메모리 주소'가 삽입되는 이유로 해당 메모리 주소를 똑같이 참조하는 리스트가 sellingList에서 soldList까지
		 * 모두 2개의 리스트로 늘어버릴 우려가 있기 때문에 sellingList에서 가져오는 기존의 객체에 대한 내용을 하나씩 copy하여 입력한다.
		 * (C언어를 배운 사람이라면 pointer의 개념에 대해 곰곰히 생각해보자.)
		 * 
		 * 예를 들어보자..
		 * soldList.add(sellingList.get(0));  이라는 코드를 수행하였을 때의 객체 참조관계는 아래와 같다.
		 * 
		 * 				before
		 * ┌────────────────┐          ┌─────────────┐ 
		 * │  A객체의 메모리 주소   │ ───────> │ sellingList │
		 * └────────────────┘          └─────────────┘
		 * 
		 * 				after
		 * ┌────────────────┐          ┌─────────────┐ 
		 * │  A객체의 메모리 주소   │ ───┬───> │ sellingList │
		 * └────────────────┘    │     └─────────────┘ 
		 *                       │	   ┌─────────────┐
		 *                       └───> │   soldList  │
		 *                		       └─────────────┘
		 *                
		 * 이렇게 되버리면.. sellingList.get(0).setAmount(200); 이라는 코드를 이후에 실행한다면
		 * 결국 soldList.get(0).getAmount(); 를 실행하였을때 동일하게 200이라는 보유 수량이 입력되는 것을 확인 할 수 있다.
		 * 
		 * 하나의 객체를 여러 리스트가 공유를 하게 되는 효과를 보기 때문에 특수하게 여러개의 list에서 동일하게 공유되는 내용의 객체를
		 * 넣어서 처리하지 않는한 최대한 객체를 새로 생성하여 list에 넣어 주어야 한다.
		 * 
		 * 바로 아래와 같이~!!
		 * 
		 * ┌────────────────┐          ┌─────────────┐ 
		 * │  A객체의 메모리 주소   │ ───────> │ sellingList │
		 * └────────────────┘          └─────────────┘
		 * ┌────────────────┐          ┌─────────────┐ 
		 * │  B객체의 메모리 주소   │ ───────> │   soldList  │
		 * └────────────────┘          └─────────────┘
		 * 
		 */
		
		// 4-3. 판매된 상품 리스트(soldList)에 대한 편집이 끝났다면 잔돈을 반환해주며 메소드 종료
		return money;
	}

	@Override
	public String showProducts() {//지폐를 넣기전 사용자가 상품 전체리스트를 본다.
		// TODO Auto-generated method stub
		String result = "";
		
		result += "현재 삽입된 금액 : " + money + "\n";
		
		for (int i=0; i<sellingList.size(); i++) {
			result += "버튼 번호 : " + (i+1) + ", 상품 : " + sellingList.get(i) + "\n";
		}
		
		return result;
	}

	@Override
	public String amountZeroList() {//관리자가 사용하는 재고가 10개 미만인 상품리스트 출력 관리자용 메서드
		// TODO Auto-generated method stub
		String result = "";
		
		for (Product nowProduct : sellingList) {
			if (nowProduct.getAmount() < 10) {
				result += nowProduct + "\n";
			}
		}
		
		if (result.equals("")) {
			result = "모든 제품이 재고가 충분합니다. (^^)\n";
		}
		
		return result;
	}

	@Override
	public boolean setProduct(String pCode, int amount) {//부족한 재고를 채워넣는 관리자용 메서드
		// TODO Auto-generated method stub
		
		// 1. 입력한 수량에 대한 유효성 검사
		if (amount <= 0) {
			return false;
		}
		
		// 2. 기존의 보유 상품 리스트(sellingList)의 값을 하나씩 인덱스 순으로 조회 시작
		
		//	인덱스에 대한 예시 : sellingList.size() = n 이라면 'for-each'문에서
		//		[ sellingList.get(0), sellingList.get(1), ... , sellingList.get(n-2), sellingList.get(n-1) ] 의 순서대로
		//		데이터가 자동으로 담기면서 처리되기 때문에 프로그래밍하는 입장에서 굉장히 수월하게 구현할 수 있다..
		
		for (Product nowProduct : sellingList) {
			
			// 2-1. '함수의 인자값으로 받아온 pCode'와 '인덱스 순으로 받아오는 상품의 pCode'와 비교하여
			//		현재 내가 찾고자 하는 상품의 존재여부를 확인한다.
			if (pCode.equals(nowProduct.getpCode())) {
				 
				if (nowProduct.getAmount() >= 10) {
					// 2-2-1. pCode가 일치하는 상품(nowProduct)를 발견하는 경우
					//		해당 상품에 대한 보유 수량(nowProduct.getAmount())를 확인하여 10개 이상 남아 있는 경우 false로서 반환하며 메소드 종료
					
					return false;
					
				} else {
					
					// 2-2-2. pCode가 일치하는 상품(nowProduct)의 보유 수량(nowProduct.getAmount())가 10개 이상 남아 있지 않는 경우
					//		  입력받은 수량(amount) 만큼을 추가로 더해준다.
					
					nowProduct.setAmount(nowProduct.getAmount() + amount);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Product> soldListStatistics() {//판매 리스트를 확인하는 관리자용 메서드
		// TODO Auto-generated method stub
		return soldList;
	}

	@Override
	public boolean loginAdmin(String id, String pw) {//관리자로그인, 관리자계정으로 로그인해야 사용할 수 있는 기능등이 있다.
		// TODO Auto-generated method stub
		
		for (Account ac : adminAccount) {
			if (ac.getId().equals(id) && ac.getPw().equals(pw)) {
				return true;
			}
		}
		return false;
	}
}
