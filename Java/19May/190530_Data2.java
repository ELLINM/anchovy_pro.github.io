//ResultSetTest

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTest {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String id = "hr";
		String pass = "hr";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pass);
			System.out.println("DB연결 성공!");
			String sql = "select * from member";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String ID = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				System.out.printf("ID : %s\t PW : %s\t Name : %s\t Age : %d%n", ID, password, name, age);
			}
        
       
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}


//PreparedStatementTest

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String id = "hr";
		String pass = "hr";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pass);
			System.out.println("DB연결 성공!");
			
			String ID [] = {"aaa", "bbb", "ccc"};
			String password [] = {"PassA", "PassB", "PassC"};
			String name [] = {"강슬기", "손승완", "배주현"};
			int age [] = {26, 26, 28};
			String sql = "insert into member values (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			con.setAutoCommit(false);
			for(int i = 0; i < 3; i++) {
				pstmt.setString(1, ID[i]); 
				pstmt.setString(2, password[i]);
				pstmt.setString(3, name[i]);
				pstmt.setInt(4, age[i]);
				pstmt.executeUpdate();
				
			}
			con.commit();
			con.setAutoCommit(true);
			
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
