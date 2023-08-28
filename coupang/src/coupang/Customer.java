package coupang;

public class Customer extends Person {
	
	public Customer(String name, String residentNumber, int phone, String address) {
		super(name, residentNumber, phone, address);
		
	}
	
	
	
	public String inform() {
		return "회원정보 : 구매자 "+super.getName() +"님의 번호는"+ super.getPhone() + "이고 주소는 "+ this.address + "입니다";
	}
	

}
