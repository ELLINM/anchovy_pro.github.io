//DriverLoadingTest

package Test;

public class DriverLoadingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
         		System.out.println("드라이버 로딩 성공!");
     		} catch (ClassNotFoundException e) {
        	 	e.printStackTrace();
     		}
	}
}


//JDBC
package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	public static void main(String [] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String id = "hr";
	String pass = "hr";
	
	try {
		Connection con = DriverManager.getConnection(url, id, pass);
		System.out.println("DB연결 성공!");
	} catch(SQLException e) {
		e.printStackTrace();
	}
	}
}


//Statement
package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement {
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
	        try {
	            Connection con = DriverManager.getConnection(url, id, pass);
	            System.out.println("DB연결 성공!");
	            
	            Statement stmt = con.createStatement();
	            String sql = "insert into member values ('java','pass','김자바',26)";
	            int row = stmt.executeUpdate(sql);
	            System.out.printf("%d행 삽입 성공%n", row);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
