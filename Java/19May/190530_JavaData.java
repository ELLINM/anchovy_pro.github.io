//VO

package member.vo;

public class MemberVO {

	private String id;
	private String password;
	private String name;
	private int age;
	
	public MemberVO() {}
	
	public MemberVO(String id, String password, String name, int age) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return String.format("ID : %s, Password : %s, Name : %s, Age : %d%n",
				id, password, name, age);
	}
	
}


//Test
package member.main;

import member.dao.MemberDAO;

public class MemberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MemberDAO();
	}
}


//Service
package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import member.vo.MemberVO;

public class MemberDAO {
	
	private String id;
	private String password;
	private String name;
	private int age;
	private Scanner sc = new Scanner(System.in);
	private ArrayList <MemberVO> member = new ArrayList<>();
	
	//DB Driver Loading
	public MemberDAO () {
		
	}
	
	/**
	  * 새로운 회원 정보를 등록
	 * @return 회원 등록을 성공하면 true, 실패하면 false를 반환
	 * @parameter vo 등록하고자 하는 회원정보
	 * */
	
	public boolean insertMember(MemberVO vo) {
		boolean result = false;
		Connection con = getConnection();
		try {
			String sql = "insert into member values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			for(int i = 0; i < 3; i++) {
				pstmt.setString(1, vo.getId()); 
				pstmt.setString(2, vo.getPassword());
				pstmt.setString(3, vo.getName());
				pstmt.setInt(4, vo.getAge());
				int count = pstmt.executeUpdate();
				if(count == 1) result = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}
	
	/*
	 * 주어진 ID에 해당하는 멤버 정보를 반환
	 * @param id 검색하고자 하는 회원의 ID
	 * @return 회원정보
	 * */
	
	public MemberVO getMember(String id) {
		MemberVO vo = null;
		
		return vo;
	}
	
	/*
	 * 등록된 모든 회원 정보를 조회
	 * @return 모든 회원 정보
	 */
	public ArrayList<MemberVO> getAllMembers(){
		ArrayList<MemberVO> allData = new ArrayList<>();
		
		return allData;
	}
	
	/*
	 * 주어진 ID에 해당하는 회원 정보를  삭제
	 * @param id 삭제하고자 하는 회원 ID
	 * @return 삭제를 성공하면 true, 실패하면 false를 반환
	 * */
	
	public boolean deleteMember(String id) {
		boolean result = false;
		
		return result;
	}
	
	/*
	 * 회원정보 수정
	 * @param vo 수정할 값을 가지고 있는 회원정보
	 * @return 수정을 성공하면 true, 실패하면 false를 반환
	 * **/
	
	public boolean updateMember(MemberVO vo) {
		boolean result = false;
		
		return result;
	}
	
	private void close(Connection con) {
		try {
			if (con != null) con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
}
