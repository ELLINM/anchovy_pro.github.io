//VO
//Member
package Vo;

public class Member {
	private String id;
	private String pw;
	
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + "]";
	}
}

//Board
package Vo;

public class Board {
	
	private String boardseq;
	private String id;
	private String title;
	private String content;
	private String indate;
	
	public Board(String boardseq, String id, String title, String content, String indate) {
		super();
		this.boardseq = boardseq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.indate = indate;
	}

	public String getBoardseq() {
		return boardseq;
	}

	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Board [boardseq=" + boardseq + ", id=" + id + ", title=" + title + ", content=" + content + ", indate="
				+ indate + "]";
	}
}


//Servlet
//BoardServlet
package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BoardService;
import Vo.Member;

@WebServlet("/frontAction")
public class BoardServlet extends HttpServlet{
	
	private BoardService bs = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("userId");
		String pw=req.getParameter("userPw");
		
		if(id!=null&&pw!=null) {
			if(!id.equals("")&&!pw.equals("")) {
				Member mem = new Member(id,pw);
				boolean result = bs.insertMember(mem);
				
				if(result) { //가입 성공시
					resp.sendRedirect("index.jsp");
				}else { //가입 실패시
					req.setAttribute("userId", id);
					req.setAttribute("userPw", pw);
					req.setAttribute("message", "아이디가 중복되었습니다");
					
					RequestDispatcher rd=req.getRequestDispatcher("");
					rd.forward(req, resp);
				}
			}
		}
	}
}


//Service
//BoardService
package Service;

import Dao.BoardDAO;
import Vo.Member;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();
	
		public boolean insertMember(Member mem) {
			boolean flag = true;
			
			flag=dao.insertMember(mem);
			
			return flag;
		}
	
}


//Dao
//ConnectionManager
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

//BoardDao
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Vo.Member;

public class BoardDAO {
	
	ConnectionManager conn;
	
	public boolean insertMember(Member mem) {
		boolean flag = true;
		
		Connection con = conn.getConnection();
		
		
		String sql="INSERT INTO BOARDMEMBER VALUES(";
		sql+="?,";
		sql+="?";
		sql+=")";
		
		try {
			PreparedStatement ptst = con.prepareStatement(sql);
			ptst.setString(1, mem.getId());
			ptst.setString(2, mem.getPw());
			
			ptst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
			return flag;
		}
		return flag;
	}
}

