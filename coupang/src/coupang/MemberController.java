package coupang;
import java.util.*;

public class MemberController {

	ArrayList<Seller> seller = new ArrayList<>(); 
	ArrayList<Customer> customer = new ArrayList<>(); 
	//ArrayList<Person> person = new ArrayList<>(); 

		
	public void insertSeller(String name, String residentNumber, int phone, String address, String company) {
			Seller se = new Seller(name, residentNumber, phone, address, company);
			seller.add(se);
			System.out.println("등록 완료");
	}
	public void insertCustomer(String name, String residentNumber, int phone, String address) {
		Customer cu = new Customer(name, residentNumber, phone, address);
		customer.add(cu);
		System.out.println("등록 완료");		
	}
	
	public Boolean overlapSeller(String name, String residentNumber) {
		Boolean isTrue = true;
		if(!seller.isEmpty()) {
			for(Seller se : seller) {
				if (se.getName().equals(name) && se.getResidentNumber().equals(residentNumber))	{	
					System.out.println("등록 되어 있는 회원입니다");	
					isTrue = false;
					break;		
					
			}
			}
		}
		else if(seller.isEmpty()) {
			isTrue = true;
		}
			
			
			
		
			return isTrue;
	}
	
	public Boolean overlapCustomer(String name, String residentNumber) {	
		Boolean isTrue = true;
		if (!customer.isEmpty()) {
			for(Customer cu : customer) {
				if (cu.getName().equals(name) && cu.getResidentNumber().equals(residentNumber))	{	
					System.out.println("등록 되어 있는 회원입니다");					
					break;						
				}
			}
			
		}
		return isTrue;
	}

	
	public Boolean checkSeller() {
		Boolean isTrue = true;
		if(seller.isEmpty()) {
			System.out.println("등록 된 회원이 없습니다");
			isTrue = false;
			return isTrue;
		}
		else 

		return isTrue;
	}
	
	public Boolean checkCustomer() {	
		Boolean isTrue = true;
		if(customer.isEmpty()) {
			System.out.println("등록 된 회원이 없습니다");
			isTrue = false;
			return isTrue;
		}
		else 		
		return isTrue;
	}
	
	public void modifySellerCompany(String name, String residentNumber, String company) {
		for(Seller se : seller) {
			if(se.getName().equals(name) && se.getResidentNumber().equals(residentNumber)) {				
				se.setCompany(company);
			}
		}
	}
	public void modifySellerPhone(String name, String residentNumber, int phone) {
		for(Seller se : seller) {
			if(se.getName().equals(name) && se.getResidentNumber().equals(residentNumber)) {				
				se.setPhone(phone);
			}
		}
	}
	public void modifySellerAddress(String name, String residentNumber, String address) {
		for(Seller se : seller) {
			if(se.getName().equals(name) && se.getResidentNumber().equals(residentNumber)) {				
				se.setAddress(address);
			}
		}
	}
	public void modifyCustomerPhone(String name, String residentNumber, int phone) {
		for(Customer cu : customer) {
			if(cu.getName().equals(name) && cu.getResidentNumber().equals(residentNumber)) {				
				cu.setPhone(phone);
			}
		}
	}
	public void modifyCustomerAddress(String name, String residentNumber, String address) {
		for(Customer cu : customer) {
			if(cu.getName().equals(name) && cu.getResidentNumber().equals(residentNumber)) {				
				cu.setAddress(address);
			}
		}
	}



	
	public void deleteSeller(String name, String residentNumber) {		
			if(seller.isEmpty()) 
				System.out.println("등록된 회원이 없습니다");	
			else if(!seller.isEmpty()) {				
				for(int i = 0 ; i < seller.size() ; i++) {
					if(seller.get(i).getName().equals(name)&& seller.get(i).getResidentNumber().equals(residentNumber)) {
					seller.remove(i);
					System.out.println("판매자 회원삭제 완료되었습니다");
					break;					
					}
					else 
						System.out.println("해당 정보로 등록된 회원이 없습니다");
				}
			}
		
	}
	
	
	public void deleteCustomer(String name, String residentNumber) {
		if(customer.isEmpty()) 
			System.out.println("등록된 회원이 없습니다");	
		else if(!customer.isEmpty()) {				
			for(int i = 0 ; i < customer.size() ; i++) {
				if(customer.get(i).getName().equals(name)&& customer.get(i).getResidentNumber().equals(residentNumber)) {
					customer.remove(i);
				System.out.println("구매자 회원삭제 완료되었습니다");
				break;
				}
				else
					System.out.println("해당 정보로 등록된 회원이 없습니다");
			}
		}
	
}
		

	
	public void printMemberAll() {
		if (customer.isEmpty() && seller.isEmpty()) {
			System.out.println("등록 된 정보가 없습니다");
			return;
		}
		if(!customer.isEmpty()) {
		for(Customer cu : customer) 			
				System.out.println(cu.inform());
		}
		if(!seller.isEmpty()) {
		for(Seller se : seller) 		
				System.out.println(se.inform());
		}

	}
	
	public void printMemberOne(String name, String residentNumber) {
		if(seller.isEmpty() && customer.isEmpty()) {
			System.out.println("등록 되지 않은 회원입니다");
			return;
		}
		if(!seller.isEmpty()) {
		for(Seller se : seller) {
			if(!seller.isEmpty() &&se.getName().equals(name) && se.getResidentNumber().equals(residentNumber)) {								
				System.out.println(se.inform());
			}
		}
		}
		if(!customer.isEmpty()) {
		for(Customer cu : customer) {
			if(!customer.isEmpty() && cu.getName().equals(name) && cu.getResidentNumber().equals(residentNumber)) {				
				System.out.println(cu.inform());
				
			}
		}
		}
	}
}
