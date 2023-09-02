package coupang;



public class Person {
	private String name;
	private String residentNumber;
	private int phone;
	protected String address;
	

	public Person(String name, String residentNumber, int phone, String address) {
		this.name = name;
		this.residentNumber = residentNumber;
		this.phone = phone;
		this.address = address;
		
	}
	
	public Person(String name, String residentNumber) {
		this.name = name;
		this.residentNumber = residentNumber;
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setResidentNumber(String residentNumber) {
		this.residentNumber = residentNumber;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getResidentNumber() {
		return this.residentNumber;
	}
	
	public int getPhone() {
		return this.phone;
	}
	
	public String getAddress() {
		return this.address;
	}

	
	public String inform() {
		return this.name +"님의 번호는"+ phone + "이고 주소는 "+ address + "입니다";
	}
	
	
	
	

}
