package coupang;

import java.io.Serializable;

public class Member extends Person  {
	private String memeberId;
	private String memberPwd;
	

	
	public Member(String Id, String Pwd, String name, String residentNumber, int phone, String address) {
		super(name, residentNumber, phone, address);
		this.memeberId = Id;
		this.memberPwd = Pwd;
		
	}
	
	public Member(String Id, String Pwd, String name, String residentNumber) {
		super(name, residentNumber);
		this.memeberId = Id;
		this.memberPwd = Pwd;
		
	}
	
	public void setMemberId(String customerId) {
		this.memeberId = customerId;
	}
	
	public String getMemberId() {
		return this.memeberId;
	}
	
	public String getMemberPwd() {
		return this.memberPwd;
	}
	
	
	
	public String inform() {
		return "회원정보 : "+super.getName() +"님의 번호는"+ super.getPhone() + "이고 주소는 "+ this.address + "입니다";
	}
	

}
