//DriverLoadingTest

package Test;

public class DriverLoadingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		/*
		 실행하여 "jdbc driver 로딩 성공"과 "오라클 연결 성공"이 나오면 정상적으로 완료
		 위의 소스 코드 중 url의 jdbc:oracle:thin:@localhost:1521:xe는 본인의 오라클 주소에 해당하는 내용
		 localhost는 접속할 데이터베이스의 ip 주소를 입력
		 동일한 컴퓨터이면 자신의 ip를 의미하는 localhost를 작성
		 1521은 리스너 포트 번호를 의미, 변경하지 않았으면 기본값이 1521
		 xe는 SID를 의미
		 SID를 모르면 system 계정으로 sqlplus에 로그인하여 select name from v$database; 를 입력하면 확인이 가능하
		 user와 password는 본인이 접속할 오라클 계정의 아이디와 비밀번호*/
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
