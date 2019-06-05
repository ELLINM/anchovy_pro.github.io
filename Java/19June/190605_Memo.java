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

import Manager.MemoManager;
import VO.UserAccount;
import VO.UserMemo;

public class MemoUI {

	private MemoManager manager = new MemoManager(); // 요청과 관련된 처리를 하기 위해 생성한
														// MemoManager 클래스의 객체
	private Scanner sc = new Scanner(System.in);
	private Scanner scLine = new Scanner(System.in);
	private boolean accountflag = true;
	private boolean memoflag = true;

	/**
	 * <pre>
	 * 메모 관리 프로그램의 사용자 화면을 구성하고 사용자 입력을 대기한다.
	 * 프로그램은 종료 메뉴를 선택하기 전까지 무한 반복하여 처리 된다.
	 * </pre>
	 */
	public MemoUI() {

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

	}

	public void mainMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Soft Engineer Memo   계정            │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.회원가입                                                   │");
		System.out.println("│2.회원탈퇴                                                   │");
		System.out.println("│3.로그인                                                      │");
		System.out.println("│4.종료                                                         │");
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
import java.sql.Statement;
import java.util.ArrayList;
import VO.UserAccount;
import VO.UserMemo;
import Dao.MemoInterface;

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
}
