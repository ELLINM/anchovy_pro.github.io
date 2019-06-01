// Vo
package vo;

public class Fitness {
	private int userId;
	private String userName;
	private String gender;
	private double height;
	private double weight;
	private double bmi;
	private String userResult;

	public Fitness() {
		// TODO Auto-generated constructor stub
	}

	
	public Fitness(int userId, String userName, String gender, double height, double weight) {
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		bmi = weight / ((height/100)*(height/100));
		if(bmi < 18.5) {
			userResult = "저체중";
		} else if(bmi >= 18.5 && bmi <= 22.9) {
			userResult = "정상체중";
		} else if(bmi >= 23 && bmi <= 29.9) {
			userResult = "비만 1단계";
		} else {
			userResult = "비만 2단계";
		}
	}


	public Fitness(int userId, String userName, String gender, double height,
			double weight, double bmi, String userResult) {
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.userResult = userResult;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getUserResult() {
		return userResult;
	}

	public void setUserResult(String userResult) {
		this.userResult = userResult;
	}

	@Override
	public String toString() {
		return String.format("아이디: %3d | 이름:%10s | 성별:%s | 키(cm): %.1f | 몸무게(kg): %.1f | BMI: %.2f | 결과:%5s %n", userId, userName, gender, height, weight, bmi, userResult);
	}
}


//Main
package main;

import ui.FitnessUI;

public class FitnessMain {

	public static void main(String[] args) {
		FitnessUI ui = new FitnessUI();
	}
}


//Sql

create table fitness (
	userid number(4) primary key,
	username varchar2(20) not null,
	gender varchar2(6) default '남성',
	height number(6,2) not null,
	weight number(6,2) not null,
	bmi number(6,2) default 0,
	userresult varchar2(20) default '정상체중'
)

create sequence fitness_seq 
start with 1
increment by 1


//Interface
package dao;

import java.sql.Connection;
import java.util.List;

import vo.Fitness;

public interface FitnessDAOImpl {

	/**
	 * 사용할 DB와 연결된 커넥션 객체를 반환한다.
	 * @return 사용할 DB와 연결 정보를 갖는 java.sql.Connection 객체
	 * */
	public Connection getConnection();
	
	/**
	 * 사용한 DB 커넥션을 닫는다.
	 * @param con 연결을 해제할 Connection 객체
	 * */
	public void disconnect(Connection con);
	
	/**
	 * 휘트니스 회원 정보를 등록한다
	 * @param vo 등록할 휘스트니 회원정보
	 * @return DB에 등록된 레코드(row) 수
	 * */
	public int insert(Fitness vo);
	
	/**
	 * 등록된 한 명의 휘트니스 회원정보를 삭제한다.
	 * @param userId 삭제하고자 하는 회원 ID
	 * @return DB에서 삭제된 레코드(row) 수
	 * */
	public int delete(int userId);
	
	/**
	 * 휘트니스 회원 정보를 수정한다.
	 * @param vo 수정할 새로운 휘트니스 회원정보
	 * @return DB에서 수정된 레코드(row) 수
	 * */
	public int update(Fitness vo);
	
	/**
	 * 등록된 모든 휘트니스 회원정보를 조회한다.
	 * @return 등록된 모든 회원정보를 저장한 ArrayList 객체
	 * */
	public List<Fitness> getAllData();
	
	/**
	 * 등록된 한 명의 휘트니스 회원정보를 조회한다.
	 * @param userId 조회하고자 하는 회원 ID
	 * @return 조회된 한 명의 휘트니스 회원정보
	 * */
	public Fitness getData(int userId);
	
	/**
	 * 등록된 회원정보 수를 조회한다.
	 * @return 등록된 회원정보 수
	 * */
	public int getAllDataCount();
	
	/**
	 * 새로운 회원정보 등록 시 자동 증가에 의해 다음에 사용될 userID를 반환한다.	 
	 * @return 다음 회원정보 입력 시 사용될 userID 
	 * */
	public int getNextUserId();
	
}


//Ui
package ui;

import java.util.ArrayList;
import java.util.Scanner;

import dao.FitnessDAO;
import vo.Fitness;

public class FitnessUI {
	
	private Scanner sc = new Scanner(System.in);
	private FitnessDAO dao = new FitnessDAO();
	
	public FitnessUI() {
		while(true) {
			displayMainMenu();
			int no = sc.nextInt();
			switch(no) {
				case 1: int nextUserId = dao.getNextUserId();
						System.out.printf("아이디: %d%n", nextUserId);
						Fitness inserVO = makeFitnessVO(nextUserId);
						int result = dao.insert(inserVO);
						if(result == 1) 
							System.out.println("정상적으로 등록 되었습니다.");
						else
							System.out.println("등록을 실패 했습니다.");
					break;
				case 2: System.out.print("수정할 회원 ID 입력: ");
						int userId = sc.nextInt();
						Fitness updateVO = dao.getData(userId);
						if(updateVO == null) {
							System.out.println("수정할 회원ID가 존재하지 않습니다.");
						} else {
							System.out.println(updateVO);
							System.out.println("** 수정할 정보를 입력하세요 **");
							Fitness vo = makeFitnessVO(userId);
							int u_result = dao.update(vo);
							if(u_result == 1) 
								System.out.println("정상적으로 수정 되었습니다.");
							else
								System.out.println("수정을 실패 했습니다.");
						}
					break;
				case 3: System.out.print("삭제할 회원 ID 입력: ");
						int d_userId = sc.nextInt();
						int d_result = dao.delete(d_userId);
						if(d_result == 1) 
							System.out.println("정상적으로 삭제 되었습니다.");
						else
							System.out.println("삭제를 실패 했습니다.");
					break;
				case 4: ArrayList<Fitness> allData = (ArrayList<Fitness>) dao.getAllData();
						for(Fitness user : allData)
							System.out.println(user);
					break;
				case 9: System.out.println("Bye~!");
						System.exit(0);
					break;
				default: System.out.println("메뉴선택 오류!");
			}//switch
		}//while
	}
	
	private void displayMainMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│    Fitness Club Manager      │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.등록                                       │");	
		System.out.println("│2.수정                                       │");	
		System.out.println("│3.삭제                                       │");	
		System.out.println("│4.전체출력                                 │");	
		System.out.println("│9.종료                                       │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");	
	}
	
	public Fitness makeFitnessVO(int userId) {
		Fitness vo = null;
		System.out.print("이름: ");
		String userName = sc.next();
		System.out.print("성별(남자/여자): ");
		String gender = sc.next();
		System.out.print("키(cm): ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg): ");
		double weight = sc.nextDouble();
		vo = new Fitness(userId, userName, gender, height, weight);
		
		return vo;
	}
}


//Dao
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Fitness;

public class FitnessDAO implements FitnessDAOImpl {

	public FitnessDAO() {
		try {
//			String driver = "com.mysql.cj.jdbc.Driver";
			String driver = "oracle.jdbc.driver.OracleDriver";
			// java를 이용하여 oracle을 이용하기 위해 연결하는 경로값 때문에 연결하고 try, catch로 잡아준다.
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection getConnection() {
//		String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
//		String user = "root";
//		String password = "root";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		// 연결한 경로값에서 본인의 오라클 주소에 해당하는 내용
		String user = "hr";
		//sql에서 table을 등록한 id와 pw입력
		String password = "hr";
		Connection con = null;
        
		try {
			con = DriverManager.getConnection(url,user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void disconnect(Connection con) {
		try {
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Fitness vo) {
//		String sql = "insert into fitness (username, gender, height, weight, bmi, userresult) values (?,?,?,?,?,?)";
		String sql = "insert into fitness values (?,?,?,?,?,?,?)";
		/*문자열 함수인 sql안에 fitness에 들어가는 변수값들을 입력 해줄 수 있도록 함
		각 위치마다 각 값이 들어가도록 아래서 설정*/
		Connection con = getConnection();	
		//Connection을 자료값로하는 con변수를 선언하고 위의 getConnection() method를 사용할 수 있도록함
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			//PreparedStatement를 이용하여 데이터베이스와 연결된 sql변수에 각 vo의 값을 넣어 줄 수 있도록 함
			pstmt.setInt(1, vo.getUserId());
			pstmt.setString(2, vo.getUserName());
			pstmt.setString(3, vo.getGender());
			pstmt.setDouble(4, vo.getHeight());
			pstmt.setDouble(5, vo.getWeight());
			pstmt.setDouble(6, vo.getBmi());
			pstmt.setString(7, vo.getUserResult());
			// 각 자리마다 저장될 값의 위치를 지정
			result = pstmt.executeUpdate();
			//위 내용의 실행결과를 executrUpdate를 통해 Int형으로 반환함
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(con);
		}
		return result;
	}

	@Override
	public int delete(int userId) {
		String sql = "delete from fitness where userid = ?";
		//sql문 안에서 userid의 위치를 찾아서 삭제함 ?에는 입력받은 userid가 들어감
		int result = 0;
		Connection con = getConnection();
		//데이터베이스와 연결
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			//userid는 입력된 각 자료들 중에서 1번에 위치해 있기 때문에 일치하는 값을 검색
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(con);
		}
		return result;
	}

	@Override
	public int update(Fitness vo) {
		String sql = "update fitness set userName = ?, gender = ?, height = ?, weight = ? where userId = ?";
		//sql문을 통해서 수정을 함
		int result = 0;
		Connection con = getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserName());
			pstmt.setString(2, vo.getGender());
			pstmt.setDouble(3, vo.getHeight());
			pstmt.setDouble(4, vo.getWeight());
			pstmt.setInt(5, vo.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(con);
		}
		return result;
	}

	@Override
	public List<Fitness> getAllData() {
		String sql = "select * from fitness";
		//전체출력구문 
		ArrayList<Fitness> allData = new ArrayList<>();
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			// ResultSet 객체에 결과값을 담아줌
			while(rs.next()) {
				int userId = rs.getInt(1);
				String userName = rs.getString(2);
				String gender = rs.getString(3);
				double height = rs.getDouble(4);
				double weight = rs.getDouble(5);
				double bmi = rs.getDouble(6);
				String userResult = rs.getString(7);
				//각 변수값에 ResultSet에서 불러온 결과값을 저장해줌
				Fitness vo = new Fitness(userId, userName, gender, height, weight, bmi, userResult);
				//vo에 새롭게 값을 저장해주고 ArrayList에 저장
				allData.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(con);
		}
		return allData;
	}

	@Override
	public Fitness getData(int userId) {
		String sql = "select * from fitness where userId = ?";
		//sql문으로 입력받은 userid가 저장된 위치를 검색해서 갖고옴
		Fitness result = null;
		Connection con = getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			//PreparedStatement값에 입력받은 userid를 입력
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String userName = rs.getString(2);
				String gender = rs.getString(3);
				double height = rs.getDouble(4);
				double weight = rs.getDouble(5);
				double bmi = rs.getDouble(6);
				String userResult = rs.getString(7);
				//userid는 입력과 동시에 저장하고 userid에 상응하는 값에 대해서 뽑아야함
				result = new Fitness(userId, userName, gender, height, weight, bmi, userResult);
				//result값에 저장하여 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(con);
		}
		return result;
	}

	@Override
	public int getAllDataCount() {
		String sql = "select count(userId) from fitness";
		//등록되어 있는 userid의 갯수를 검색
		int count = 0;
		Connection con = getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				//re.next()로 전체 자료의 갯수를 확인
				count = rs.getInt(1);
			//count에 1번 자리 즉 userid 수를 하나씩 넣어 갯수를 측정
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(con);
		}
		return count;
	}
	
	public int getNextUserId() {
		String sql = "select fitness_seq.nextval from dual";
		//userid는 순차적으로 등록됨으로 다음으로 쓰일 id의 번호를 예측한다.
		int result = 0;
		Connection con = getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				//위의 전체 갯수를 검색하는것과 비슷함 결국 모든 회원의 수를 알아야 다음 번호를 예측
				result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(con);
		}
		
		return result;
	}
}

