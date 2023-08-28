package coupang;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
	
	public Customer(String name, String residentNumber, int phone, String address) {
		super(name, residentNumber, phone, address);
		
	}
	
	
	
	public String inform() {
		return "회원정보 : 구매자 "+super.getName() +"님의 번호는"+ super.getPhone() + "이고 주소는 "+ this.address + "입니다";
	}
	

}
