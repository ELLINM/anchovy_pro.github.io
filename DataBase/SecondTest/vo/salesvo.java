package global.sesoc.comshop.vo;

import java.util.ArrayList;

/**
 * 판매 정보 VO
 */
public class SalesVO {
	private int num;
	private String date;
	private String code;
	private int quantity;
	private ArrayList<ProductVO> pList = new ArrayList<>();

	public SalesVO(int num, String date, String code, int quantity) {
		super();
		this.num = num;
		this.date = date;
		this.code = code;
		this.quantity = quantity;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDate() {
		return date; 
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return num + "         " + code + "       " + quantity + "     " + date;
	}
}
