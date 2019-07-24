package global.sesoc.comshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import global.sesoc.comshop.vo.ProductVO;
import global.sesoc.comshop.vo.SalesVO;

/**
 * DB관련 처리 DAO 클래스.
 * AbstractShopDAO 인터페이스를 구현하여 정의한다.
 */
public class ShopDAO implements AbstractShopDAO{

	ConnectionManager conn = null;
	@Override
	public int insertProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		int row = 0;
		
		Connection con = conn.getConnection();
		
		String sql = "insert into com_product values (?, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCode());
			ps.setString(2, vo.getPname());
			ps.setInt(3, vo.getPrice());
			row = ps.executeUpdate();
			
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return row;
		}
	}

	@Override
	public ArrayList<ProductVO> listProduct() {
		// TODO Auto-generated method stub
		ArrayList<ProductVO> pList = new ArrayList<>();
		
		Connection con = conn.getConnection();
		
		String sql = "select * from com_product order by code asc";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String code = rs.getString(1);
				String pname = rs.getString(2);
				int price = rs.getInt(3);
				
				ProductVO pv = new ProductVO(code, pname, price);
				
				pList.add(pv);
			}
			
			return pList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public int insert(SalesVO vo) {
		// TODO Auto-generated method stub
		int row = 0;
		
		Connection con = conn.getConnection();
		
		String sql = "insert into com_sales values (com_sales_seq.nextval, sysdate, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCode());
			ps.setInt(2, vo.getQuantity());
			row = ps.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return row;
		}
	}

	@Override
	public ArrayList<SalesVO> list() {
		// TODO Auto-generated method stub
		ArrayList<SalesVO> sList = new ArrayList<>();
		
		Connection con = conn.getConnection();
		
		String sql = "select num, TO_CHAR(inputdate,'YY/MM/DD'), code, quantity from com_sales order by num asc";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int num = rs.getInt(1); 
				String inputdata = rs.getString(2);
				String code = rs.getString(3);
				int quantity = rs.getInt(4);
				
				SalesVO sv = new SalesVO(num, inputdata, code, quantity);
				
				sList.add(sv);
			}
			
			return sList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public int update(SalesVO vo) {
		// TODO Auto-generated method stub
		int row = 0;
		
		Connection con = conn.getConnection();
		
		String sql = "update com_sales set quantity = ? where num = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getQuantity());
			ps.setInt(2, vo.getNum());
			row = ps.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return row;
		}
	}

	@Override
	public int delete(int num) {
		// TODO Auto-generated method stub
		int row = 0;
		
		Connection con = conn.getConnection();
		
		String sql = "delete from com_sales where num = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			row = ps.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return row;
		}
	}

	@Override
	public ArrayList<SalesVO> sales() {
		// TODO Auto-generated method stub
		ArrayList<SalesVO> sList = new ArrayList<>();
		
		Connection con = conn.getConnection();
		
		String sql = "select s.code, p.pname, sum(s.quantity), sum(s.quantity*p.price) " + 
				"from com_product p, com_sales s " + 
				"where p.code = s.code " + 
				"group by s.code, p.pname";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {//여기에서만 SalesVO의 quantity를 수량으로, sum을 합쳐진 구매가으로 만듦. num은 금액으로 함
				String code = rs.getString(1);
				String name = rs.getString(2);
				int quantity = rs.getInt(3);
				int sum = rs.getInt(4);
				
				SalesVO sv = new SalesVO(quantity, code, name, sum);
				
				sList.add(sv);
			}
			return sList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block\
			e.printStackTrace();
			return null;
		}
	}
	

}
