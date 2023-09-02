package coupang;

import java.io.Serializable;

public class Seller extends Person  {
	private String company;
	private String sellerId;
	private String sellerPwd;
	
	public Seller( String sellerId, String sellerPwd, String name, String residentNumber, int phone, String address, String company ) {
		super(name, residentNumber, phone, address);
		this.company = company;
		this.sellerId = sellerId;
		this.sellerPwd = sellerPwd;
		
	}
	
	public Seller(String name, String residentNumber, String sellerId, String sellerPwd) {
		super(name, residentNumber);
		this.sellerId = sellerId;
		this.sellerPwd = sellerPwd;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getCompany() {
		return this.company;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getSellerId() {
		return this.sellerId;
	}
	public void setSellerPwd(String sellerPwd) {
		this.sellerPwd = sellerPwd;
	}
	
	public String getSellerPwd() {
		return this.sellerPwd;
	}
	
	public String inform() {
		return "회원정보 : "+super.getName() +"님의 번호는"+ super.getPhone() + "이고 주소는 "+ this.address + "이고 화사는 " + this.company+ "입니다";
	}

}
