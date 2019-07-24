package global.sesoc.comshop.dao;

import java.util.ArrayList;

import global.sesoc.comshop.vo.ProductVO;
import global.sesoc.comshop.vo.SalesVO;

/**
 * ShopDAO에서 구현할 메소드들이 정의된 인터페이스
 */
public interface AbstractShopDAO {

	/**
	 * 상품 정보를 DB에 저장한다.
	 * @param vo 저장할 상품 정보 VO 객체
	 */
	public int insertProduct(ProductVO vo);
	
	/**
	 * DB에 저장된 모든 상품정보를 코드 순으로 읽어온다.
	 * @return 상품정보들이 저장된 리스트
	 */
	public ArrayList<ProductVO> listProduct();
	
	/**
	 * 판매 정보를 DB에 저장한다.
	 * @param vo 판매 정보 VO객체
	 * @return 저장된 레코드 수
	 */
	public int insert(SalesVO vo);
	
	/**
	 * DB에 저장된 모든 판매 정보를 판매 날짜순으로 정렬하여 읽어온다.
	 * @return 판매정보들이 저장된 리스트
	 */
	public ArrayList<SalesVO> list();
	
	/**
	 * 번호와 판매수량을 전달받아 해당 번호의 데이터를 수정한다.
	 * @param vo 수정할 번호와 판매수량이 저장된 VO객체
	 * @return 수정 성공한 레코드 수
	 */
	public int update(SalesVO vo);
	
	/**
	 * 번호를 전달받아 해당 판매 정보를 삭제한다.
	 * @param num 삭제할 번호
	 * @return 삭제 성공한 레코드 수
	 */
	public int delete(int num);
	
	/**
	 * 상품별로 총 판매수량과 판매금액을 구한다.
	 * @return 판매정보가 담긴 리스트
	 */
	public ArrayList<SalesVO> sales();
}

