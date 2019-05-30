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
