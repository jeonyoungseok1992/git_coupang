package coupang;

import java.io.Serializable;

public class Seller extends Person implements Serializable {
	private String company;
	
	public Seller(String name, String residentNumber, int phone, String address, String company ) {
		super(name, residentNumber, phone, address);
		this.company = company;
		
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getCompany() {
		return this.company;
	}
	
	public String inform() {
		return "회원정보 : 판매자 "+super.getName() +"님의 번호는"+ super.getPhone() + "이고 주소는 "+ this.address + "이고 화사는 " + this.company+ "입니다";
	}

}
