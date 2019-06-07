//vo
package VO;

public class UserAccount {

	private String name;
	private String id;
	private String password;

	public UserAccount(String name, String id, String password) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
	}

	public UserAccount() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 아이디=" + id + ", 비밀번호=" + password;
	}

}

package VO;

public class UserMemo {

	private String memoseq;
	private String title;
	private String content;
	private String indate;
	private String id;

	public UserMemo(String memoseq, String title, String content, String indate, String id) {
		super();
		this.memoseq = memoseq;
		this.title = title;
		this.content = content;
		this.indate = indate;
		this.id = id;
	}

	public UserMemo() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "메모일련번호=" + memoseq + ", 제목=" + title + ", 작성일=" + indate;
	}

}

package VO;

public class AirPlane {
	private String pno;
	private String dep;
	private String arr;
	private String dept;
	private String arrt;
	
	public AirPlane(String pno, String dep, String arr, String dept, String arrt) {
		super();
		this.pno = pno;
		this.dep = dep;
		this.arr = arr;
		this.dept = dept;
		this.arrt = arrt;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	
	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getArrt() {
		return arrt;
	}

	public void setArrt(String arrt) {
		this.arrt = arrt;
	}

	@Override
	public String toString() {
		return "항공기 등록번호 =" + pno + ", 출발지 = " + dep + ", 도착지 = " + arr + ", 출발시간 = " + dept + ", 도착시간 = " + arrt;
	}	
	
}

package VO;

public class Admin {
	private String name;
	private String id;
	private String password;

	public Admin(String name, String id, String password) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
	}

	public Admin() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 아이디=" + id + ", 비밀번호=" + password;
	}
}

//main
package Main;

import UI.MemoUI;

public class MemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemoUI();
	}

}


//ui
package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Dao.MemoDaoManager;
import Manager.MemoManager;
import VO.AirPlane;
import VO.UserAccount;
import VO.UserMemo;

public class MemoUI {

	private MemoManager manager = new MemoManager(); // 요청과 관련된 처리를 하기 위해 생성한
														// MemoManager 클래스의 객체
	private MemoDaoManager mdm = new MemoDaoManager();
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private boolean accountflag = true;
	private boolean memoflag = true;
	private boolean airflag = true;
	private boolean adminflag = true;
	private boolean planeflag = true;
	private boolean bookingflag = true;

	/**
	 * <pre>
	 * 메모 관리 프로그램의 사용자 화면을 구성하고 사용자 입력을 대기한다.
	 * 프로그램은 종료 메뉴를 선택하기 전까지 무한 반복하여 처리 된다.
	 * </pre>
	 */
	public MemoUI() {
		while (airflag) {
		menu();
		
		switch(sc.nextInt()) {
		case 1:
			while (adminflag) {
				adminMenu();
				switch(sc.nextInt()) {
				case 1:
					loginAdmin();
					
					while(planeflag) {
						airMenu();
						
						switch(sc.nextInt()) {
						case 1:
							insertAir();
							break;
						case 2:
							searchAir();
							break;
						case 3:
							searchAllAir();
							break;
						case 4:
							updateAir();
							break;
						case 5:
							deleteAir();
							break;
						case 6:
							searchBookPno();
							break;
						case 9:
							planeflag = false;
							break;
						}
					}
					break;
				case 9:
					adminflag = false;
					break;
				}
			break;
			}
		case 2:
			while (accountflag) {
				memoflag = true;
				
				mainMenu();
				switch (sc.nextInt()) {
				case 1:
					insertAccount();
					break;
				case 2:
					deleteAccount();
					break;
				case 3:
					loginAccount();
					
					while (memoflag) {
						subMenu();
						switch (sc.nextInt()) {
						case 1:
							insertMemo();
							break;
						case 2:
							searchMemo();
							break;
						case 3:
							searchAllMemo();
							break;
						case 4:
							searhOneMemo();
							break;
						case 5:
							updateMemo();
							break;
						case 6:
							deleteMemo();
							break;
						case 9:
							memoflag = false;
							break;
						}
					}
					break;
				case 9:
					accountflag = false;
					break;
				}
			}
			break;
		case 3:
			bookingMenu();
			switch(sc.nextInt()) {
			case 1:
				insertAccount();
				break;
			case 2:
				deleteAccount();
				break;
			case 3:
				loginAccount();
				while(bookingflag) {
					bookingSubMenu();
					switch(sc.nextInt()) {
					case 1:
						searchAllAir();
						insertBook();
						break;
					case 2:
						searchBook();
						break;
					case 3:
						searchAllAir();
						updateBook();
						break;
					case 4:
						deleteBook();
						break;
					case 9:
						bookingflag = false;
						break;
						
					}
				}
				break;
			}
			break;
		case 9:
			airflag = false;
			break;	
			}
		}
	}
	
	public void menu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Soft Engineer Memo   계정            │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.AIRPLANE                    │");
		System.out.println("│2.MEMO                        │");
		System.out.println("│3.BOOKING AIRPLANE            │");
		System.out.println("│9.종료                                                         │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}
	
	public void mainMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Soft Engineer Memo   계정            │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.회원가입                                                   │");
		System.out.println("│2.회원탈퇴                                                   │");
		System.out.println("│3.로그인                                                      │");
		System.out.println("│9.종료                                                         │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}

	public void subMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Soft Engineer Memo   메모            │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.메모등록                                                   │");
		System.out.println("│2.메모검색(제목+내용)              │");
		System.out.println("│3.메모전체보기                                             │");
		System.out.println("│4.메모상세보기                                             │");
		System.out.println("│5.메모수정                                                   │");
		System.out.println("│6.메모삭제                                                   │");
		System.out.println("│9.종료                                                         │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}
	
	public void adminMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ AirPlane Admin   계정 	       │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.관리자 로그인                                            │");
		System.out.println("│9.종료                                                         │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}
	
	public void airMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ AirPlane Admin   계정           │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.항공편 등록                                               │");
		System.out.println("│2.항공검색(비행번호)				   │");
		System.out.println("│3.항공편 출력					   │");
		System.out.println("│4.항공편 수정					   │");
		System.out.println("│5.항공편 삭제                                               │");
		System.out.println("│6.예약확인(스케쥴 번호)			   │");
		System.out.println("│9.종료                                                         │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}
	
	public void bookingMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ BOOKING AIRPLANE             │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.회원가입                                                   │");
		System.out.println("│2.회원탈퇴                                                   │");
		System.out.println("│3.로그인                                                      │");
		System.out.println("│9.종료                                                         │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}
	
	public void bookingSubMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Soft Engineer Memo   메모            │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.예약등록                                                   │");
		System.out.println("│2.예약확인(사용자 id)			   │");
		System.out.println("│3.예약수정					   │");
		System.out.println("│4.예약삭제                                                   │");
		System.out.println("│9.종료                                                         │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}

	public void loginAccount() {
		while (true) {
			System.out.println("ID를 입력 해주세요 => ");
			String id = scLine.nextLine();
			System.out.println("비밀번호를 입력 해주세요 => ");
			String password = scLine.nextLine();
			if ((id == null || id.equals("")) || (password == null || password.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				UserAccount result = manager.loginAccount(new UserAccount(null, id, password));
				if (result != null) {
					System.out.println("로그인 완료 " + manager.getId() + "(" + manager.getName() + "님) 환영합니다.");
					break;
				} else {
					System.out.println("******ERROR 아이디/비밀번호가 일치하지 않습니다.");
				}
			}
		}
	}

	public void insertAccount() {
		while (true) {
			System.out.println("이름을 입력 해주세요 => ");
			String name = scLine.nextLine();
			System.out.println("ID를 입력 해주세요 => ");
			String id = scLine.nextLine();
			System.out.println("비밀번호를 입력 해주세요 => ");
			String password = scLine.nextLine();
			if ((name == null || name.equals("")) || (id == null || id.equals(""))
					|| (password == null || password.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = manager.insertAccount(new UserAccount(name, id, password));
				if (result) {
					System.out.println("계정등록 완료");
					break;
				} else {
					System.out.println("******ERROR 같은아이디가 존재합니다.");
				}
			}
		}
	}
	

	public void deleteAccount() {
		while (true) {
			System.out.println("ID를 입력 해주세요 => ");
			String id = scLine.nextLine();
			System.out.println("비밀번호를 입력 해주세요 => ");
			String password = scLine.nextLine();
			if ((id == null || id.equals("")) || (password == null || password.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				manager.deleteAllMemo(id);
				boolean result = manager.deleteAccount(new UserAccount(null, id, password));
				if (result) {
					System.out.println("계정삭제 완료");
					break;
				} else {
					System.out.println("******ERROR 삭제실패.");
				}
			}
		}
	}

	public void insertMemo() {

		while (true) {
			System.out.println("제목을 입력 해주세요 => ");
			String title = scLine.nextLine();
			System.out.println("내용을 입력 해주세요 => ");
			String content = scLine.nextLine();
			if ((title == null || title.equals("")) || (content == null || content.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = manager.insertMemo(new UserMemo(null, title, content, null, null));
				if (result) {
					System.out.println("메모등록 완료");
					break;
				} else {
					System.out.println("******ERROR 메모등록에 실패했습니다.");
				}
			}
		}
	}

	public void searchMemo() {
		while (true) {
			System.out.println("제목또는 내용을 입력 해주세요 => ");
			String searchWord = scLine.nextLine();
			if ((searchWord == null || searchWord.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				ArrayList<UserMemo> result = manager.searchMemo(searchWord);
				if (result != null) {
					printAllMemo(result);
					break;
				} else {
					System.out.println("******ERROR 메모검색에 실패했습니다.");
				}
			}
		}
	}

	public void searchAllMemo() {
		while (true) {

			ArrayList<UserMemo> result = manager.getMemoList();
			if (result != null) {
				printAllMemo(result);
				break;
			} else {
				System.out.println("******ERROR 메모조회에 실패했습니다.");
			}

		}
	}

	public void searhOneMemo() {
		while (true) {
			System.out.println("메모 일련번호를 입력 해주세요 => ");
			String memoseq = scLine.nextLine();
			if ((memoseq == null || memoseq.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				UserMemo result = manager.searchOneMemo(memoseq);
				if (result != null) {
					System.out.println("제목 : "+result.getTitle());
					System.out.println("내용 : "+result.getContent());
					break;
				} else {
					System.out.println("******ERROR 메모검색에 실패했습니다.");
				}
			}
		}
	}

	public void deleteMemo() {
		while (true) {
			System.out.println("삭제할 메모 일련번호를 입력 해주세요 => ");
			String memoseq = scLine.nextLine();
			if ((memoseq == null || memoseq.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = manager.deleteMemo(memoseq);
				if (result) {
					System.out.println("삭제에 성공했습니다.");
					break;
				} else {
					System.out.println("******ERROR 메모삭제에 실패했습니다.");
				}
			}
		}
	}
	
	public void updateMemo(){
		while (true) {
			System.out.println("수정할 메모 일련번호를 입력 해주세요 => ");
			String memoseq = scLine.nextLine();
			if ((memoseq == null || memoseq.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				
				System.out.println("제목을 입력 해주세요 => ");
				String title = scLine.nextLine();
				System.out.println("내용을 입력 해주세요 => ");
				String content = scLine.nextLine();
				if ((title == null || title.equals("")) || (content == null || content.equals(""))) {
					System.out.println("******ERROR 다시입력해주세요.");
				} else {
					boolean result = manager.updateMemo(memoseq,new UserMemo(null, title, content, null, null));
					if (result) {
						System.out.println("메모수정 완료");
						break;
					} else {
						System.out.println("******ERROR 메모수정에 실패했습니다.");
					}
				}
			}
		}
	}

	public void printAllMemo(ArrayList<UserMemo> memos) {
		for (UserMemo memo : memos) {
			System.out.println(memo);
		}
	}
	
	public void loginAdmin() {
		while (true) {
			System.out.println("ID를 입력 해주세요 => ");
			String id = scLine.nextLine();
			System.out.println("비밀번호를 입력 해주세요 => ");
			String password = scLine.nextLine();
			if (mdm.loginAdmin(id, password) != true) {
				System.out.println("******ERROR 아이디/비밀번호가 일치하지 않습니다.");
			} else {
				System.out.println("로그인 완료 환영합니다.");
				break;
			}
		}
	}
	
	public void insertAir() {

		while (true) {
			System.out.println("출발지를 입력해 주세요 => ");
			String dep = scLine.nextLine();
			System.out.println("도착지를 입력해 주세요 => ");
			String arr = scLine.nextLine();
			System.out.println("출발 날짜를 입력해 주세요 => ");
			
			System.out.println("연도 => ");
			String year = scLine.nextLine();
			
			System.out.println("월 => ");
			String month = scLine.nextLine();
			
			System.out.println("일=> ");
			String day = scLine.nextLine();
			
			String dept = year+"-"+month+"-"+day;
			System.out.println("도착 날짜를 입력해 주세요=> ");
			System.out.println("연도 => ");
			String year2 = scLine.nextLine();
			
			System.out.println("월 => ");
			String month2 = scLine.nextLine();
			
			System.out.println("일 => ");
			String day2 = scLine.nextLine();
			
			String arrt = year2+"-"+month2+"-"+day2;
			if ((dep == null || dep.equals("")) 
					|| (arr == null || arr.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = manager.insertAir(new AirPlane(null, dep, arr, dept, arrt));
				if (result) {
					System.out.println("스케쥴 등록 완료");
					break;
				} else {
					System.out.println("******ERROR 스케쥴 등록에 실패했습니다.");
				}
			}
		}
	}
	
	public void searchAir() {
		while (true) {
			System.out.println("항공기 번호를 입력하세요 => ");
			String pno = scLine.nextLine();
			if ((pno == null || pno.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				ArrayList<UserMemo> result = manager.searchMemo(pno);
				if (result != null) {
					System.out.println(mdm.searchAir(pno));
					break;
				} else {
					System.out.println("******ERROR 검색에 실패했습니다.");
				}
			}
		}
	}
	
	public void searchAllAir() {
		while (true) {

			ArrayList<AirPlane> result = manager.getAirList();
			if (result != null) {
				printAllAir(result);
				break;
			} else {
				System.out.println("******ERROR 조회에 실패했습니다.");
			}

		}
	}
	
	public void updateAir(){
		while (true) {
			System.out.println("수정할 스케쥴를 입력 해주세요 => ");
			String pno = scLine.nextLine();
			if ((pno == null || pno.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				
				System.out.println("출발지를 입력 해주세요 => ");
				String dep = scLine.nextLine();
				System.out.println("도착지 입력 해주세요 => ");
				String arr = scLine.nextLine();
				
				System.out.println("출발 날짜를 입력해 주세요 => ");
				
				System.out.println("연도 => ");
				String year = scLine.nextLine();
				
				System.out.println("월 => ");
				String month = scLine.nextLine();
				
				System.out.println("일=> ");
				String day = scLine.nextLine();
				
				String dept = year+"-"+month+"-"+day;
				System.out.println("도착 날짜를 입력해 주세요=> ");
				System.out.println("연도 => ");
				String year2 = scLine.nextLine();
				
				System.out.println("월 => ");
				String month2 = scLine.nextLine();
				
				System.out.println("일 => ");
				String day2 = scLine.nextLine();
				
				String arrt = year2+"-"+month2+"-"+day2;
				if ((dep == null || dep.equals("")) || (arr == null || arr.equals(""))
						|| (year == null || year.equals("")) || (month == null || month.equals("")) || (day == null || day.equals(""))
						||(year2 == null || year2.equals("")) || (month2 == null || month2.equals("")) || (day2 == null || day2.equals(""))) {
					System.out.println("******ERROR 다시입력해주세요.");
				} else {
					boolean result = manager.updateAir(pno,new AirPlane(null, dep, arr, dept, arrt));
					if (result) {
						System.out.println("스케쥴수정 완료");
						break;
					} else {
						System.out.println("******ERROR 스케쥴수정에 실패했습니다.");
					}
				}
			}
		}
	}
	
	public void deleteAir() {
		while (true) {
			System.out.println("삭제할 스케쥴 번호를 입력 해주세요 => ");
			String pno = scLine.nextLine();
			if ((pno == null || pno.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = manager.deleteAir(pno);
				if (result) {
					System.out.println("삭제에 성공했습니다.");
					break;
				} else {
					System.out.println("******ERROR 스케쥴삭제에 실패했습니다.");
				}
			}
		}
	}
	
	public void printAllAir(ArrayList<AirPlane> ap) {
		for (AirPlane air : ap) {
			System.out.println(air);
		}
	}
	
	public void insertBook() {
		System.out.println("예약자 ID를 입력하세요");
		String id = scLine.nextLine();
		
		System.out.println("예약하실 스케쥴 번호를 입력하세요");
		String pno = scLine.nextLine();
		if ((pno == null || pno.equals(""))) {
			System.out.println("******ERROR 다시입력해주세요.");
		}else {
			boolean result = mdm.insertBook(id, pno);
			if (result) {
				System.out.println("예약에 성공했습니다.");
			}else {
				System.out.println("******ERROR 예약에 실패했습니다.");
			}
		}
	}
	
	public void searchBook() {
		System.out.println("예약자 ID를 입력하세요");
		String id = scLine.nextLine();
		
		if ((id == null || id.equals(""))) {
			System.out.println("******ERROR 다시입력해주세요.");
		} else {
			if (mdm.searchBook(id) != null) {
				System.out.println(mdm.searchBook(id));
			} else {
				System.out.println("******ERROR 검색에 실패했습니다.");
			}
		}
		
	}
	
	public void searchBookPno() {
		System.out.println("스케쥴을 입력하세요");
		String pno = scLine.nextLine();
		
		
		if ((pno == null || pno.equals(""))) {
			System.out.println("******ERROR 다시입력해주세요.");
		} else {
			if (mdm.searchBookPno(pno) != null) {
				System.out.println(mdm.searchBookPno(pno));
			} else {
				System.out.println("******ERROR 검색에 실패했습니다.");
			}
		}
		
	}
	
	public void updateBook(){
		while (true) {
			System.out.println("수정할 ID를 입력 해주세요 => ");
			String id = scLine.nextLine();
			if ((id == null || id.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				
				System.out.println("예약하고 싶은 스케쥴을 입력하세요");
				String pno = scLine.nextLine();
				if (pno == null || pno.equals("")) {
					System.out.println("******ERROR 다시입력해주세요.");
				} else {
					boolean result = mdm.updateBook(id, pno);
					if (result) {
						System.out.println("스케쥴수정 완료");
						break;
					} else {
						System.out.println("******ERROR 스케쥴수정에 실패했습니다.");
					}
				}
			}
		}
	}
	
	public void deleteBook() {
		while (true) {
			System.out.println("삭제할 ID를 입력 해주세요 => ");
			String id = scLine.nextLine();
			if ((id == null || id.equals(""))) {
				System.out.println("******ERROR 다시입력해주세요.");
			} else {
				boolean result = mdm.deleteBook(id);
				if (result) {
					System.out.println("삭제에 성공했습니다.");
					break;
				} else {
					System.out.println("******ERROR 삭제에 실패했습니다.");
				}
			}
		}
	}
}


//sql
-- 테이블 삭제
drop table useraccount;
drop table usermemo;
drop sequence memoseq;

--메모일련번호
create sequence memoseq;

--유저정보
create table useraccount (
	name varchar2(20) not null,			-- 회원이름 문자열 null존재불가
	id varchar2(20) primary key,		-- 아이디 null존재불가 
	password varchar2(20) not null		-- 비밀번호  null존재불가 
);

--메모정보
create table usermemo (
	memoseq varchar2(60) primary key,
    title varchar2(60) not null, 	--메모 제목
    content varchar2(2000) not null,--메모내용
    indate date default sysdate,    --메모작성일
    id varchar2(20),				--작성자
	constraint id_fk 
	foreign key (id) 
	references useraccount(id)	
);
-- 커밋
commit;


delete useraccount;
delete usermemo;


//manager
package Manager;

import java.util.ArrayList;

import Dao.MemoDaoManager;
import VO.AirPlane;
import VO.UserAccount;
import VO.UserMemo;

public class MemoManager {

	private MemoDaoManager mdm = null;
	private String id;// 로그인한 ID
	private String name;// 로그인한 이용자 이름
	private String pno;

	public MemoManager() {

		this.mdm = new MemoDaoManager();
	}

	public boolean insertAccount(UserAccount user) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.insertAccount(user);
		return result;
	}

	public UserAccount loginAccount(UserAccount user) {
		// TODO Auto-generated method stub
		UserAccount result = null;
		result = mdm.loginAccount(user);
		if (result != null) {
			this.id = result.getId();
			this.name = result.getName();
		}
		return result;
	}

	public boolean deleteAccount(UserAccount user) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.deleteAccount(user);
		return result;
	}

	public boolean insertMemo(UserMemo memo) {
		// TODO Auto-generated method stub
		boolean result = false;
		memo.setId(this.id);
		result = mdm.insertMemo(memo);
		return result;
	}

	public ArrayList<UserMemo> getMemoList() {
		// TODO Auto-generated method stub
		ArrayList<UserMemo> result = null;
		result = mdm.getMemoList(this.id);
		return result;
	}

	public ArrayList<UserMemo> searchMemo(String searchword) {
		// TODO Auto-generated method stub

		ArrayList<UserMemo> result = null;
		result = mdm.searchMemo(searchword, this.id);
		return result;
	}

	public UserMemo searchOneMemo(String seq) {
		// TODO Auto-generated method stub
		UserMemo result = null;
		result = mdm.searchOneMemo(seq, this.id);
		return result;
	}

	public boolean updateMemo(String seq,UserMemo memo) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.updateMemo(seq,memo);
		return result;
	}

	public boolean deleteMemo(String seq) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.deleteMemo(seq);
		return result;
	}

	public boolean deleteAllMemo(String id) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.deleteAllMemo(id);
		return result;
	}

	public boolean logout() {

		if (this.name == null) {
			return false;
		}

		this.name = null;
		this.id = null;
		return true;
	}
	
	public boolean insertAir(AirPlane ap) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.insertAir(ap);
		return result;
	}
	
	public ArrayList<AirPlane> searchAir(String pno) {
		// TODO Auto-generated method stub

		ArrayList<AirPlane> result = null;
		result = mdm.searchAir(pno);
		return result;
	}
	
	public ArrayList<AirPlane> getAirList() {
		// TODO Auto-generated method stub
		ArrayList<AirPlane> result = null;
		result = mdm.getAirList();
		return result;
	}
	
	public boolean updateAir(String pno,AirPlane ap) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.updateAir(pno, ap);
		return result;
	}
	
	public boolean deleteAir(String pno) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.deleteAir(pno);
		return result;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}
}

//dao
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";	// JDBC driver 패키지명
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";	// URL
	private static final String dbid = "hr";	// 데이터베이스 ID
	private static final String dbpw = "hr";	// 데이터베이스 비밀번호

	// JDBC 드라이버 로딩
	static {
		try{
			// 문자열로 클래스를 찾는다
			Class.forName(driver); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 생성자를 private으로 설정한다
	// 이유: 단 하나의 객체만 생성하고 다른 어떤 이도 이 클래스를 계속 생성할 수 없게 막기 위함
	private ConnectionManager() {}
		
	/**
	 * 드라이버 매니저로부터 Connection을 생성하여 반환한다
	 * @return Connection 객체
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			// 드라이버 매니저를 이용하여 연결을 시도한다
			con = DriverManager.getConnection(url, dbid, dbpw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * Connection 연결을 종료한다 
	 * @param con Connection 객체
	 */
	public static void close(Connection con) {
		try {
			// 매개변수로 입력받은 Connection 객체가 null이 아니라면 종료한다
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


package Manager;

import java.util.ArrayList;

import Dao.MemoDaoManager;
import VO.UserAccount;
import VO.UserMemo;

public class MemoManager {

	private MemoDaoManager mdm = null;
	private String id;// 로그인한 ID
	private String name;// 로그인한 이용자 이름

	public MemoManager() {

		this.mdm = new MemoDaoManager();
	}

	public boolean insertAccount(UserAccount user) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.insertAccount(user);
		return result;
	}

	public UserAccount loginAccount(UserAccount user) {
		// TODO Auto-generated method stub
		UserAccount result = null;
		result = mdm.loginAccount(user);
		if (result != null) {
			this.id = result.getId();
			this.name = result.getName();
		}
		return result;
	}

	public boolean deleteAccount(UserAccount user) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.deleteAccount(user);
		return result;
	}

	public boolean insertMemo(UserMemo memo) {
		// TODO Auto-generated method stub
		boolean result = false;
		memo.setId(this.id);
		result = mdm.insertMemo(memo);
		return result;
	}

	public ArrayList<UserMemo> getMemoList() {
		// TODO Auto-generated method stub
		ArrayList<UserMemo> result = null;
		result = mdm.getMemoList(this.id);
		return result;
	}

	public ArrayList<UserMemo> searchMemo(String searchword) {
		// TODO Auto-generated method stub

		ArrayList<UserMemo> result = null;
		result = mdm.searchMemo(searchword, this.id);
		return result;
	}

	public UserMemo searchOneMemo(String seq) {
		// TODO Auto-generated method stub
		UserMemo result = null;
		result = mdm.searchOneMemo(seq, this.id);
		return result;
	}

	public boolean updateMemo(String seq,UserMemo memo) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.updateMemo(seq,memo);
		return result;
	}

	public boolean deleteMemo(String seq) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.deleteMemo(seq);
		return result;
	}

	public boolean deleteAllMemo(String id) {
		// TODO Auto-generated method stub
		boolean result = false;
		result = mdm.deleteAllMemo(id);
		return result;
	}

	public boolean logout() {

		if (this.name == null) {
			return false;
		}

		this.name = null;
		this.id = null;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}


package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.AirPlane;
import VO.UserAccount;
import VO.UserMemo;
import Dao.MemoInterface;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MemoDaoManager implements MemoInterface {

	public boolean insertAccount(UserAccount user) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection();
			String sql = "insert into useraccount values (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getId());
			pstmt.setString(3, user.getPassword());
			
			int temp = pstmt.executeUpdate();
			if(temp != 0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn != null)
			ConnectionManager.close(conn);
		}
		return result;
	}

	@Override
	public UserAccount loginAccount(UserAccount user) {
		// TODO Auto-generated method stub
		UserAccount  result = null;
		Connection con = null;
		
		con = ConnectionManager.getConnection();
		String sql = " select name, id, password"+ " from useraccount"+" where id = ? and password =?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String password = rs.getString("password");
				result = new UserAccount(name, id, password);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con != null)
			ConnectionManager.close(con);
		}
		return result;
	}

	@Override
	public boolean deleteAccount(UserAccount user) {
		boolean result = false; 
		 Connection con = null;
		 
		 con = ConnectionManager.getConnection();
		 String sql = "delete useraccount where id = ? and password = ?";
		 PreparedStatement pstmt;
		 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			
			int tempt = pstmt.executeUpdate();
			if(tempt !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insertMemo(UserMemo memo) {
		boolean result = false;
		Connection con = null;
		
		con = ConnectionManager.getConnection();
		String sql ="insert into usermemo values(memoseq.nextval,?,?,default,?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memo.getTitle());
			pstmt.setString(2, memo.getContent());
			pstmt.setString(3, memo.getId());
			
			int temp = pstmt.executeUpdate();
			if(temp !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<UserMemo> getMemoList(String id) {
		ArrayList<UserMemo> mList = new ArrayList<>();
		Connection con = null; 
		
		con =ConnectionManager.getConnection();
		String sql ="select * from usermemo where id = ? order by indate asc";
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String memoseq = rs.getString("memoseq");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String indate = rs.getString("indate");
				id = rs.getString("id");
				mList.add(new UserMemo(memoseq, title, content, indate, id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public ArrayList<UserMemo> searchMemo(String searchword, String id) {
		 ArrayList<UserMemo> mList = new ArrayList<>();
		 Connection con = null;
		 
		 con = ConnectionManager.getConnection();
		 String sql = "select * from usermemo where id = ? and title like ? or content like ?";
		 PreparedStatement pstmt;
		 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, "%"+searchword+"%");
			pstmt.setString(3, "%"+searchword+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String memoseq = rs.getString("memoseq");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String indate = rs.getString("indate");
				id = rs.getString("id");
				mList.add(new UserMemo(memoseq, title, content, indate, id));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public UserMemo searchOneMemo(String seq, String id) {
			UserMemo result = null;
			Connection con = null; 

			con = ConnectionManager.getConnection();
			String sql = "select * from usermemo where id = ? and memoseq =?";
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, seq);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					String memoseq = rs.getString("memoseq");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String indate = rs.getString("indate");
					id = rs.getString("id");
					result = new UserMemo(memoseq, title, content, indate, id);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public boolean updateMemo(String seq, UserMemo memo) {
		boolean result = false;
		String sql = "update usermemo set title = ?, content = ? where memoseq = ?";
		Connection con = null;
		
		con = ConnectionManager.getConnection();
		PreparedStatement pstm;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, memo.getTitle());
			pstm.setString(2, memo.getContent());
			pstm.setString(3, seq);
			
			int temp = pstm.executeUpdate();
			if(temp !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteMemo(String seq) {
		boolean result = false; 
		 Connection con = null;
		 
		 con = ConnectionManager.getConnection();
		 String sql = "delete usermemo where memoseq = ?";
		 PreparedStatement pstmt;
		 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			int tempt = pstmt.executeUpdate();
			if(tempt !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteAllMemo(String id) {
		boolean result = false; 
		 Connection con = null;
		 
		 con = ConnectionManager.getConnection();
		 String sql = "delete usermemo where id = ?";
		 PreparedStatement pstmt;
		 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int tempt = pstmt.executeUpdate();
			if(tempt !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean loginAdmin(String id, String password) {
		boolean result = false;
		if(id.equals("admin")&&password.equals("1234")) {
			result = true;
		}
		return result;
	}
	
	public boolean insertAir(AirPlane ap) {
		boolean result = false;
		Connection con = null;
		
		con = ConnectionManager.getConnection();
		String sql ="insert into airplane values(pno.nextval,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ap.getDep());
			pstmt.setString(2, ap.getArr());
			pstmt.setString(3, ap.getDept());
			pstmt.setString(4, ap.getArrt());			
			
			int temp = pstmt.executeUpdate();
			if(temp !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<AirPlane> searchAir(String pno) {
		 ArrayList<AirPlane> airList = new ArrayList<>();
		 Connection con = null;
		 
		 con = ConnectionManager.getConnection();
		 String sql = "select pno, dep, arr, to_char(dept, 'mon/dd dy') as dept, to_char(dept, 'mon/dd dy') as arrt from airplane where pno = ?";
		 PreparedStatement pstmt;
		 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pno);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String pNo = rs.getString("pno");
				String dep = rs.getString("dep");
				String arr = rs.getString("arr");
				String dept = rs.getString("dept");
				String arrt = rs.getString("arrt");
				airList.add(new AirPlane(pNo, dep, arr, dept, arrt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airList;
	}
	
	public ArrayList<AirPlane> getAirList() {
		ArrayList<AirPlane> airList = new ArrayList<>();
		Connection con = null; 
		
		con =ConnectionManager.getConnection();
		String sql ="select pno, dep, arr, to_char(dept, 'mon/dd dy') as dept, to_char(dept, 'mon/dd dy') as arrt from airplane";
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String pno = rs.getString("pno");
				String dep = rs.getString("dep");
				String arr = rs.getString("arr");
				String dept = rs.getString("dept");
				String arrt = rs.getString("arrt");
				airList.add(new AirPlane(pno, dep, arr, dept, arrt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airList;
	}
	
	public boolean updateAir(String pno, AirPlane ap) {
		boolean result = false;
		String sql = "update airplane set dep = ?, arr = ?, dept = ?, arrt = ?  where pno = ?";
		Connection con = null;
		
		con = ConnectionManager.getConnection();
		PreparedStatement pstm;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, ap.getDep());
			pstm.setString(2, ap.getArr());
			pstm.setString(3, ap.getDept());
			pstm.setString(4, ap.getArrt());
			pstm.setString(5, pno);
			
			int temp = pstm.executeUpdate();
			if(temp !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteAir(String pno) {
		boolean result = false; 
		 Connection con = null;
		 
		 con = ConnectionManager.getConnection();
		 String sql = "delete airplane where pno = ?";
		 PreparedStatement pstmt;
		 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pno);
			
			int tempt = pstmt.executeUpdate();
			if(tempt !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean insertBook(String id, String pno) {
		boolean result = false;
		
		Connection con = null;
		con = ConnectionManager.getConnection();
		
		String sql = "insert into booking values(?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pno);
			
			int temp = pstmt.executeUpdate();
			if(temp !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String searchBook(String id) {
		String result = "";
		
		Connection con = null;
		con = ConnectionManager.getConnection();
		String sql = "select a.id, b.pno, b.dep, to_char(b.dept, 'mon/dd dy') as dept, b.arr, to_char(b.arrt, 'mon/dd dy') as arrt "
				+ "from useraccount a, airplane b, booking c "
				+ "where a.id = c.id2 and b.pno = c.pno and a.id = ?";
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				result += "예약 id : " + rs.getString(1) + " \n스케쥴 번호 : " + rs.getString(2) 
				+ "\n출발지 : " + rs.getString(3) + "\n출발시간 : " + rs.getString(4) 
				+ "\n 도착지 : " + rs.getString(5) + "\n도착시간 :  " + rs.getString(6);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	}
	
	public String searchBookPno(String pno) {
		String result = "";
		
		Connection con = null;
		con = ConnectionManager.getConnection();
		String sql = "select b.pno, a.id, b.dep, to_char(b.dept, 'mon/dd dy') as dept, b.arr, to_char(b.arrt, 'mon/dd dy') as arrt "
				+ "from useraccount a, airplane b, booking c "
				+ "where a.id = c.id2 and b.pno = c.pno and b.pno = ?";
		PreparedStatement pstmt;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pno);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				result += "스케쥴 번호 : " + rs.getString(1) + " \n예약 id : " + rs.getString(2) 
				+ "\n출발지 : " + rs.getString(3) + "\n출발시간 : " + rs.getString(4) 
				+ "\n 도착지 : " + rs.getString(5) + " \n도착시간 :  " + rs.getString(6);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	
	}
	
	public boolean updateBook(String id, String pno) {
		boolean result = false;
		String sql = "update booking set id2 = ?, pno = ?";
		Connection con = null;
		
		con = ConnectionManager.getConnection();
		PreparedStatement pstm;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pno);
			
			int temp = pstm.executeUpdate();
			if(temp !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteBook(String id) {
		boolean result = false; 
		 Connection con = null;
		 
		 con = ConnectionManager.getConnection();
		 String sql = "delete booking where id2 = ?";
		 PreparedStatement pstmt;
		 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int tempt = pstmt.executeUpdate();
			if(tempt !=0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
