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
import javax.servlet.http.HttpSession;

import Service.BoardService;
import Vo.Member;

@WebServlet("/frontAction")
public class BoardServlet extends HttpServlet{
	
	private BoardService bs = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
				
		if(action.equals("login")) {
			
			String id=req.getParameter("userId");
			String pw=req.getParameter("userPw");
			
			Member mem = new Member(id,pw);
			
			Member result = bs.selectMember(mem);
			
			if(result==null) {
				
				System.out.println((String)req.getAttribute("message"));
				
				req.setAttribute("userId", id);
				req.setAttribute("userPw", pw);
				req.setAttribute("message", "로그인 실패");

				RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
				
			}else {
				HttpSession session=req.getSession();
				session.setAttribute("loginId", id);
				
				resp.sendRedirect("index.jsp");
			}
		}else if(action.equals("logout")){
			
			HttpSession session=req.getSession();
			
			session.setAttribute("loginId", null);
			
			resp.sendRedirect("index.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=req.getParameter("action");
		
		if(action.equals("signup")) {
			
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
						
						RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
						rd.forward(req, resp);
					}
				}	
			}
		}else if(action.equals("delete")) {
			
			HttpSession session = req.getSession();
			String id = (String)session.getAttribute("loginId");
			String pw = req.getParameter("userPw");
			
			Member mem = new Member(id, pw);
			
			boolean result = bs.deleteMember(mem);
			
			if(result) { //탈퇴 성공시
				req.getSession().invalidate();
				resp.sendRedirect("index.jsp");
			}else { //탈퇴 실패시
				req.setAttribute("userPw", pw);
				req.setAttribute("message", "비밀번호가 일치 하지 않습니다");
				
				RequestDispatcher rd=req.getRequestDispatcher("delete.jsp");
				rd.forward(req, resp);
			}
		}
	}
}


//Service
//BoardService
package Service;

import java.util.ArrayList;

import Dao.BoardDAO;
import Vo.Board;
import Vo.Member;

public class BoardService {

	private BoardDAO dao = new BoardDAO();

	public boolean insertMember(Member mem) {
		boolean flag = true;

		flag = dao.insertMember(mem);

		return flag;
	}

	public Member selectMember(Member mem) {
		Member result = null;

		result = dao.selectMember(mem);

		return result;
	}

	public boolean deleteMember(Member mem) {
		boolean flag = true;

		flag = dao.deleteMember(mem);

		return flag;
	}

	public boolean insertBoard(Board b) {
		boolean flag = true;

		flag = dao.insertBoard(b);

		return flag;
	}

	public ArrayList<Board> selectAllBoard() {

		return dao.selectAllBoard();
	}

	public Board selectBoard(String boardSeq) {

		return dao.selectlBoard(boardSeq);
	}
	
	public void deleteBoard(String boardSeq) {
		dao.deleteBoard(boardSeq);
	}
	
	public void updateBoard(Board board) {
		dao.updateBoard(board);
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Vo.Board;
import Vo.Member;

public class BoardDAO {

	ConnectionManager conn;

	public boolean insertMember(Member mem) {
		boolean flag = true;

		Connection con = conn.getConnection();

		String sql = "INSERT INTO BOARDMEMBER VALUES(";
		sql += "?,";
		sql += "?";
		sql += ")";

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

	public Member selectMember(Member mem) {
		Member result = null;

		Connection con = conn.getConnection();

		String sql = "SELECT ID,PW FROM BOARDMEMBER WHERE ";
		sql += "ID=?";
		sql += " AND ";
		sql += "PW=?";

		try {
			PreparedStatement ptst = con.prepareStatement(sql);
			ptst.setString(1, mem.getId());
			ptst.setString(2, mem.getPw());

			ResultSet rs = ptst.executeQuery();

			String resultId = null;
			String resultPw = null;

			while (rs.next()) {
				resultId = rs.getString(1);
				resultPw = rs.getString(2);
			}

			if (resultId != null && resultPw != null) {
				result = new Member(resultId, resultPw);
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean deleteMember(Member mem) {
		boolean flag = true;

		Connection con = conn.getConnection();

		String sql = "DELETE BOARDMEMBER WHERE ";
		sql += "ID=?";
		sql += " AND ";
		sql += "PW=?";

		try {
			PreparedStatement ptst = con.prepareStatement(sql);
			ptst.setString(1, mem.getId());
			ptst.setString(2, mem.getPw());

			int result = ptst.executeUpdate();

			if (result == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
			return flag;
		}
	}

	public boolean insertBoard(Board b) {
		boolean flag = true;

		Connection conn = ConnectionManager.getConnection();
		String sql = "INSERT INTO BOARD ";
		sql += " (BOARDSEQ,TITLE,ID,CONTENT,INDATE) ";
		sql += " VALUES ";
		sql += " (BOARDSEQ.NEXTVAL,?,?,?,SYSDATE) ";

		try {
			PreparedStatement ptst = conn.prepareStatement(sql);

			ptst.setString(1, b.getTitle());
			ptst.setString(2, b.getId());
			ptst.setString(3, b.getContent());

			ptst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return flag;
	}

	public ArrayList<Board> selectAllBoard() {
		ArrayList<Board> boardList = new ArrayList<>();

		Connection conn = ConnectionManager.getConnection();

		String sql = " SELECT BOARDSEQ,TITLE,ID,CONTENT,INDATE FROM BOARD ORDER BY INDATE DESC";

		try {
			PreparedStatement ptst = conn.prepareStatement(sql);

			ResultSet rs = ptst.executeQuery();

			while (rs.next()) {
				String boardseq = rs.getString(1);
				String title = rs.getString(2);
				String id = rs.getString(3);
				String content = rs.getString(4);
				String indate = rs.getString(5);

				boardList.add(new Board(boardseq, id, title, content, indate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardList;
	}

	public Board selectlBoard(String boardSeq) {
		Board board = null;

		Connection conn = ConnectionManager.getConnection();

		String sql = " SELECT BOARDSEQ,TITLE,ID,CONTENT,INDATE FROM BOARD";
		sql += " WHERE BOARDSEQ=? ";

		try {
			PreparedStatement ptst = conn.prepareStatement(sql);

			ptst.setString(1, boardSeq);

			ResultSet rs = ptst.executeQuery();

			while (rs.next()) {
				String boardseq = rs.getString(1);
				String title = rs.getString(2);
				String id = rs.getString(3);
				String content = rs.getString(4);
				String indate = rs.getString(5);

				board = new Board(boardseq, id, title, content, indate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}
	
	public void deleteBoard(String boardSeq) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String sql = "DELETE BOARD WHERE BOARDSEQ=? ";
		
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setString(1, boardSeq);
			ptst.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void updateBoard(Board board) {
		
		Connection conn = ConnectionManager.getConnection();
		
		String sql = "UPDATE BOARD SET "
				+ " TITLE=?, "
				+ " CONTENT=? "
				+ " WHERE"
				+ " BOARDSEQ=? ";
		
		try {
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setString(1, board.getTitle());
			ptst.setString(2, board.getContent());
			ptst.setString(3, board.getBoardSeq());
			
			ptst.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


//mainServlet
package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.BoardService;
import Vo.Board;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

@WebServlet("/boardAction")
public class MainServlet extends HttpServlet {

	private BoardService bs = new BoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");

		if (action.equals("board")) {

			checkLogin(req, resp);

			req.setAttribute("bList", bs.selectAllBoard());

			RequestDispatcher rd = req.getRequestDispatcher("board.jsp");
			rd.forward(req, resp);

		} else if (action.equals("boardWrite")) {
			checkLogin(req, resp);
			resp.sendRedirect("boardWrite.jsp");

		} else if (action.equals("detail")) {

			String boardSeq = req.getParameter("boardSeq");

			Board board = bs.selectBoard(boardSeq);

			req.setAttribute("board", board);

			RequestDispatcher rd = req.getRequestDispatcher("boardDetail.jsp");
			rd.forward(req, resp);

		} else if(action.equals("goUpdate")) {
			
			
			String boardSeq=req.getParameter("boardSeq");
			
			Board board=bs.selectBoard(boardSeq);
			
			req.setAttribute("board", board);	

			RequestDispatcher rd=req.getRequestDispatcher("boardWrite.jsp");
			rd.forward(req, resp);
			
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");

		if (action.equals("write")) {
			String title = req.getParameter("title");
			String contents = req.getParameter("content");
			String id = (String) req.getSession().getAttribute("loginId");

			Board board = new Board(null, id, title, contents, null);

			bs.insertBoard(board);

			resp.sendRedirect("boardAction?action=board");
			// get으로 보내서 게시물을 select해옴
		} else if (action.equals("delete")) {
			String boardSeq = req.getParameter("boardSeq");

			bs.deleteBoard(boardSeq);
			resp.sendRedirect("boardAction?action=board");
		}else if (action.equals("update")) {

			String boardSeq = req.getParameter("boardSeq");
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			bs.updateBoard(new Board(boardSeq, null, title, content, null));
			
			resp.sendRedirect("boardAction?action=detail&boardSeq="+boardSeq);
		}
	}

	public void checkLogin(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String loginId = (String) session.getAttribute("loginId");

		if (loginId == null) { // 로그인X
			try {
				resp.sendRedirect("Login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
