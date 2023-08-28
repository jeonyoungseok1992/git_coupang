package coupang;
import java.util.*;


public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void MainMenu() {
		Boolean isTrue = true;
		while(isTrue) {
			System.out.println("1. 회원 등록");
			System.out.println("2. 회원 관리");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 회원 정보");
			System.out.println("9. 종료");
			System.out.println("메뉴번호 : ");
			int num = sc.nextInt();
			switch(num){

				case 1 :{	
					System.out.println("등록할 회원의 유형을 선택해 주세요 (1. 판매자 2.구매자) ");
					int num1 = sc.nextInt();
					if(num1 == 1) {										
						System.out.println("이름 : ");
						String name = sc.next();
						System.out.println("주민번호 : ");
						String residentNumber = sc.next();
						if(!mc.overlapSeller(name, residentNumber)) 
							continue;							
						System.out.println("회사 이름 : ");
						String company = sc.next();
						System.out.println("핸드폰 번호 : ");
						int phone = sc.nextInt();
						System.out.println("주소 : ");
						String address = sc.next();
						mc.insertSeller(name, residentNumber, phone, address, company);
					}
					else if(num1 == 2) {
						System.out.println("이름 : ");
						String name = sc.next();
						System.out.println("주민번호 : ");
						String residentNumber = sc.next();
						if(!mc.overlapCustomer(name, residentNumber))
							continue;					
						System.out.println("핸드폰 번호 : ");
						int phone = sc.nextInt();
						System.out.println("주소 : ");
						String address = sc.next();			
						mc.insertCustomer(name, residentNumber, phone, address);
					}
				}break;
				case 2 :{
					System.out.println("회원 타입 (1.판매자 2.구매자) : ");
					int num1 = sc.nextInt();
					if (num1 == 1) {
						if(!mc.checkSeller()) {							
							continue;
						}
						System.out.println("판매자 이름 : ");
						String name = sc.next();
						System.out.println("판매자 주민번호 : ");
						String residentNumber = sc.next();

					Boolean isTrue2 = true;
					while(isTrue2) {
					System.out.println("1. 회사이름");
					System.out.println("2. 핸드폰 번호");
					System.out.println("3. 주소");
					System.out.println("9. 메인메뉴로");
					System.out.println("메뉴번호 : ");
					int num2 = sc.nextInt();
					switch(num2) {
						case 1 :{
							System.out.print("수정 할 회사이름을 입력하세요 : ");
							String company = sc.next();
							mc.modifySellerCompany(name, residentNumber, company);
						}break;
						case 2 :{
							System.out.print("수정 할 핸드폰 번호를 입력하세요 : ");
							int phone = sc.nextInt();
							mc.modifySellerPhone(name, residentNumber, phone);
						}break;
						case 3 :{
							System.out.print("수정 할 주소를 입력하세요 : ");
							String address = sc.next();
							mc.modifySellerAddress(name, residentNumber, address);
						}break;
						case 9 :{
							isTrue2 = false;
						}break;
						default :{
							System.out.println("잘 못 입력하셨습니다");
						}
					}
					}
					
				}
					else if (num1 == 2) {
						if(!mc.checkCustomer()) {
							continue;
						}
						System.out.println("구매자 이름 : ");
						String name = sc.next();
						System.out.println("구매자 주민번호 : ");
						String residentNumber = sc.next();

					Boolean isTrue2 = true;
					while(isTrue2) {
					System.out.println("1. 핸드폰 번호");
					System.out.println("2. 주소");
					System.out.println("9. 메인메뉴로");
					System.out.println("수정 할 메뉴번호 : ");
					int num2 = sc.nextInt();
					switch(num2) {
						case 1 :{
							System.out.print("수정 할 핸드폰 번호를 입력하세요 : ");
							int phone = sc.nextInt();
							mc.modifyCustomerPhone(name, residentNumber, phone);
						}break;
						case 2 :{
							System.out.print("수정 할 주소를 입력하세요 : ");
							String address = sc.next();
							mc.modifyCustomerAddress(name, residentNumber, address);
						}break;
						case 9 :{
							isTrue2 = false;
						}break;
						default :{
							System.out.println("잘 못 입력하셨습니다");
						}
					}
					}
					
				}break;
				}case 3 :{
					System.out.println("삭제 할 회원의 타입(1.판매자 2.구매자)");
					int num1 = sc.nextInt();
					if (num1 == 1) {
						if(!mc.checkSeller()) {
							continue;
						}
						System.out.println("이름 : ");
						String name = sc.next();
						System.out.println("주민번호 : ");
						String residentNumber = sc.next();
						mc.deleteSeller(name, residentNumber);
					}
					else if (num1 == 2) {
						if(!mc.checkCustomer()) {
							continue;
						}
						System.out.println("이름 : ");
						String name = sc.next();
						System.out.println("주민번호 : ");
						String residentNumber = sc.next();
						mc.deleteCustomer(name, residentNumber);
					}
					else 
						System.out.println("잘 못 입력하셨습니다");
						
				}break;
				case 4 :{
					System.out.println("1. 회원 전체보기");
					System.out.println("2. 회원 검색");
					System.out.println("메뉴 번호 : ");
					int num1 = sc.nextInt();
					switch(num1) {
						case 1 :{
							mc.printMemberAll();
						}break;
						case 2 :{
							System.out.println("회원 이름 : ");
							String name = sc.next();
							System.out.println("회원 주민번호 : ");
							String residentNumber = sc.next();
							mc.printMemberOne(name, residentNumber);
						}
					}
					
				}break;
				case 9 :{
					isTrue = false;
				}break;
				default :{
					System.out.println("잘 못 입력하셨습니다");
				}
			}
		}
	}
}
