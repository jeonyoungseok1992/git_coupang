package coupang;
import java.util.*;


public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void MainMenu() {
		boolean login = true;
		while(login) {
		System.out.println("1.관리자 2.회원 9.종료");
		int choiceNum = sc.nextInt();
		sc.nextLine();
		switch(choiceNum) {
			case 1 :
				System.out.print("아이디를 입력해주세요 : ");
				String id = sc.next();
				System.out.println("비밀번호를 입력해주세요 : ");
				String pwd = sc.next();
				if(!Manager.login(id, pwd)) {
					break;
				}
				this.ManagerMenu();
			break;
			case 2 :
				System.out.println("1.로그인 2.회원가입");
				int slogin = sc.nextInt();
				sc.nextLine();
				if(slogin == 1) {
					if(!mc.checkMember() && !mc.checkSeller()) {
						System.out.println("등록 된 회원이 없습니다");
						break;
					}
					
					this.MemberMenu();
					
					
				}
				else if(slogin == 2) {
					System.out.println("아이디를 입력하세요");
					String mId = sc.next();
					System.out.println("비밀번호를 입력하세요");
					String mPwd = sc.next();
					System.out.println("이름 : ");
					String mName = sc.next();
					System.out.println("주민번호 : ");
					String mNumber = sc.next();
					if(!mc.overlapMember(mId, mNumber)) 
						continue;							
					System.out.println("추가로 판매자 등록까지 하시겠습니까? (y/n)");
					char yesNo = sc.next().charAt(0);
					if(yesNo == 'y' || yesNo == 'Y') {						
						System.out.println("회사 이름 : ");
						String company = sc.next();
						System.out.println("핸드폰 번호 : ");
						int phone = sc.nextInt();
						System.out.println("주소 : ");
						String address = sc.next();
						mc.UpgradeSeller(mId, mPwd, mName, mNumber, phone, address, company);						
					}
					else
						mc.InsertMember(mName, mNumber, mId, mPwd);
				}
			break;
			case 9 :
				login = false;
				
			break;
			default : 
				System.out.println("다시 입력해 주세요");
			
	
			
		}	
					
		}			
			
		
	}

	
	public static boolean mlogin(String id, String pwd, ArrayList<Member> mm) {
		boolean slogin = false;
		for(Member me : mm) {
			if(id.equals(me.getMemberId()) && pwd.equals(me.getMemberPwd())) {
				System.out.println("로그인 성공");
				slogin = true;
				break;
			}
			break;
									
		}
			return slogin;
	
		
	}
	
	public static boolean slogin(String id, String pwd, ArrayList<Seller> ss) {
		boolean slogin = false;
		for(Seller se : ss) {
			if(id.equals(se.getSellerId()) && pwd.equals(se.getSellerPwd())) {
				System.out.println("로그인 성공");
				slogin = true;
				break;
			}
			break;
									
		}
			return slogin;
	
		
	}
	
	
	
	public void ManagerMenu() {
		Boolean isTrue = true;
		while(isTrue) {
			System.out.println("1. 회원 관리");
			System.out.println("2. 회원 삭제");
			System.out.println("3. 회원 정보");
			System.out.println("4. 회원 정보 파일로 저장");
			System.out.println("9. 종료");
			System.out.println("메뉴번호 : ");
			try{
			int num = sc.nextInt();			
			sc.nextLine();
			switch(num){								

				case 1 :{
						if(!mc.checkMember()) {							
							continue;
						}
						System.out.println("회원 id : ");
						String id = sc.next();


					Boolean isTrue2 = true;
					while(isTrue2) {
					System.out.println("1. 회사이름");
					System.out.println("2. 핸드폰 번호");
					System.out.println("3. 주소");
					System.out.println("9. 메인메뉴로");
					System.out.println("메뉴번호 : ");
					int num2 = sc.nextInt();
					sc.nextLine();
					switch(num2) {
						case 1 :{
							System.out.print("수정 할 회사이름을 입력하세요 : ");
							String company = sc.next();
							mc.modifySellerCompany(id, company);
						}break;
						case 2 :{
							System.out.print("수정 할 핸드폰 번호를 입력하세요 : ");
							int phone = sc.nextInt();
							mc.modifyMemberPhone(id, phone);
						}break;
						case 3 :{
							System.out.print("수정 할 주소를 입력하세요 : ");
							String address = sc.next();
							mc.modifyMemberAddress(id, address);
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
				 case 2 :{
					if(!mc.checkMember()) {
						continue;
					}
					System.out.println("삭제 할 회원 아이디 : ");
					String xid = sc.next();
					System.out.println("정말 삭제 하시겠습니까? (y/n)");
					String str = sc.next();
					if(str.equalsIgnoreCase("Y"))
						mc.deleteMember(xid);
					else
						System.out.println("삭제를 취소합니다");
					
					
						
				}break;
				case 3 :{
					System.out.println("1. 회원 전체보기");
					System.out.println("2. 회원 검색");
					System.out.println("메뉴 번호 : ");
					int num1 = sc.nextInt();
					sc.nextLine();
					switch(num1) {
						case 1 :{
							mc.printMemberAll();
						}break;
						case 2 :{
							System.out.println("회원 id : ");
							String id = sc.next();
							mc.printMemberOne(id);
						}
					}
					
				}break;
				case 4 :{
					System.out.println("저장할 회원타입(1.판매자 2.구매자)");
					int num4 = sc.nextInt();
					sc.nextLine();
					switch(num4) {
						case 1 :{
							mc.saveSellerToFile(mc.seller);
						}break;
						case 2 :{
							
						}
							mc.saveMemberToFile(mc.member);
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
			catch( InputMismatchException x) {
				x.printStackTrace();
				System.out.println("잘 못 입력하셨습니다 숫자를 입력해주세요");
				sc.nextLine();
			}

		}
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	public void MemberMenu() {
		System.out.print("아이디를 입력해주세요 : ");
		String sid = sc.next();
		sc.nextLine();
		System.out.println("비밀번호를 입력해주세요 : ");
		String spwd = sc.next();
		sc.nextLine();
		if(!this.mlogin(sid, spwd, mc.member) && !this.slogin(sid, spwd, mc.seller)) { 
			return;	
		}
		try{
		Boolean isTrue = true;
		while(isTrue) {
			mc.printMemberOne(sid);
			System.out.println("1. 내정보관리");
			System.out.println("9. 종료");
			System.out.println("메뉴번호 : ");
			
			int num = sc.nextInt();			
			sc.nextLine();
			switch(num){								

				case 1 :{
					Boolean isTrue2 = true;
					while(isTrue2) {
					System.out.println("1. 회사이름");
					System.out.println("2. 핸드폰 번호");
					System.out.println("3. 주소");
					System.out.println("9. 메인메뉴로");
					System.out.println("메뉴번호 : ");
					int num2 = sc.nextInt();
					sc.nextLine();
					switch(num2) {
						case 1 :{
							if(!mc.checkSeller()) {
								System.out.println("판매자 권한이 없습니다");
								isTrue2 = false;	
								break;
							}
							System.out.print("수정 할 회사이름을 입력하세요 : ");
							String company = sc.next();
							mc.modifySellerCompany(sid , company);
						}break;
						case 2 :{
							System.out.print("수정 할 핸드폰 번호를 입력하세요 : ");
							int phone = sc.nextInt();
							mc.modifyMemberPhone(sid, phone);
						}break;
						case 3 :{
							System.out.print("수정 할 주소를 입력하세요 : ");
							String address = sc.next();
							mc.modifyMemberAddress(sid, address);
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
				break;
				case 9 :{
					isTrue = false;
				}break;
				default :{
					
					System.out.println("잘 못 입력하셨습니다");
				}
			}
		}
		}
			catch( InputMismatchException x) {
				x.printStackTrace();
				System.out.println("잘 못 입력하셨습니다 숫자를 입력해주세요");
				sc.nextLine();
			}
	}
}

		
		
	
	
	
		
		
