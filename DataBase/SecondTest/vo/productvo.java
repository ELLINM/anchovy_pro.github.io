package global.sesoc.comshop.vo;

/**
 * 상품 정보 VO
 */
public class ProductVO {
	private String code;
	private String pname;
	private int price;

	public ProductVO(String code, String pname, int price) {
		super();
		this.code = code;
		this.pname = pname;
		this.price = price;
	} 

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return code + "     " + pname + "     " + price;
	}
}
