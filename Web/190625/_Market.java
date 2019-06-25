//vo
//admins
package vo;

public class admins {
	
	private String adminId;
	private String adminPw;
	
	public admins(String adminId, String adminPw) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	@Override
	public String toString() {
		return "admins [adminId=" + adminId + ", adminPw=" + adminPw + "]";
	} 	
}


//product
package vo;

public class product {
	
	private String productSeq;
	private String name;
	private int quantity;
	private String price;
	private String comments;
	private String inDate;
	
	public product(String productSeq, String name, int quantity, String price, String comments, String inDate) {
		super();
		this.productSeq = productSeq;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.comments = comments;
		this.inDate = inDate;
	}

	public String getProductSeq() {
		return productSeq;
	}

	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	@Override
	public String toString() {
		return "product [productSeq=" + productSeq + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ ", comments=" + comments + ", inDate=" + inDate + "]";
	}
}


//customer
package vo;

public class customer {

	private String customerId;
	private String customerPw;
	private String name;
	private String phone;
	private String birthDate;
	private String address;
	private String inDate;
	
	public customer(String customerId, String customerPw, String name, String phone, String birthDate, String address,
			String inDate) {
		super();
		this.customerId = customerId;
		this.customerPw = customerPw;
		this.name = name;
		this.phone = phone;
		this.birthDate = birthDate;
		this.address = address;
		this.inDate = inDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	@Override
	public String toString() {
		return "customer [customerId=" + customerId + ", customerPw=" + customerPw + ", name=" + name + ", phone="
				+ phone + ", birthDate=" + birthDate + ", address=" + address + ", inDate=" + inDate + "]";
	}
}


//sold
package vo;

public class sold {
	private String soldSeq;
	private String customerId;
	private String productSeq;
	private String inDate;
	private int quantity;
	public sold(String soldSeq, String customerId, String productSeq, String inDate, int quantity) {
		super();
		this.soldSeq = soldSeq;
		this.customerId = customerId;
		this.productSeq = productSeq;
		this.inDate = inDate;
		this.quantity = quantity;
	}
	public String getSoldSeq() {
		return soldSeq;
	}
	public void setSoldSeq(String soldSeq) {
		this.soldSeq = soldSeq;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductSeq() {
		return productSeq;
	}
	public void setProductSeq(String productSeq) {
		this.productSeq = productSeq;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "sold [soldSeq=" + soldSeq + ", customerId=" + customerId + ", productSeq=" + productSeq + ", inDate="
				+ inDate + ", quantity=" + quantity + "]";
	}
}

