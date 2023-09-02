package coupang;
import java.util.*;
import java.io.*;

public class MemberController {

	ArrayList<Seller> seller = new ArrayList<>(); 
	ArrayList<Member> member = new ArrayList<>(); 

	
	//회원가입 시 기본정보 입력 후 더 입력 시 
	public void UpgradeSeller(String sellerId, String sellerPwd, String name, String residentNumber, int phone, String address, String company) {
		Seller se = new Seller(sellerId, sellerPwd, name, residentNumber, phone, address, company);
		seller.add(se);
		System.out.println("등록 완료");
}

	//기본 회원가입	
	public void InsertMember(String name, String residentNumber, String sellerId, String sellerPwd) {
		Member me = new Member(sellerId, sellerPwd, name, residentNumber);
		member.add(me);
		System.out.println("등록 완료");
	}
	
	
	public Boolean overlapSeller(String id, String residentNumber) {
		Boolean isTrue = true;
		if(!seller.isEmpty()) {
			for(Seller se : seller) {
				if (se.getSellerId().equals(id) || se.getResidentNumber().equals(residentNumber))	{	
					System.out.println("이미 판매자로 등록 되어 있는 회원입니다");	
					isTrue = false;
					break;		
					
			}
			}
		}
						
			
		
			return isTrue;
	}
	
	public Boolean overlapMember(String name, String residentNumber) {	
		Boolean isTrue = true;
		if (!member.isEmpty()) {
			for(Member me : member) {
				if (me.getName().equals(name) && me.getResidentNumber().equals(residentNumber))	{	
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
			//System.out.println("판매자 권한이 없습니다");
			isTrue = false;
		}


		return isTrue;
	}
	
	public Boolean checkMember() {	
		Boolean isTrue = true;
		if(member.isEmpty()) {
			isTrue = false;
			return isTrue;
		}
		else 		
		return isTrue;
	}
	
	public void modifySellerCompany(String id, String company) {
		for(Seller se : seller) {
			if(se.getSellerId().equals(id)) {				
				se.setCompany(company);
				System.out.println("회사이름 수정 완료");
				break;
			}
		}
	}

	public void modifyMemberPhone(String mid, int phone) {
		for(Member me : member) {
			if(me.getMemberId().equals(mid)) {				
				me.setPhone(phone);
				System.out.println("번호 수정 완료");
				break;
			}
		}
	}
	public void modifyMemberAddress(String mid, String address) {
		for(Member me : member) {
			if(me.getMemberId().equals(mid)) {				
				me.setAddress(address);
				System.out.println("주소 수정 완료");
				break;
			}
		}
	}



	
	
	
	public void deleteMember(String id) {
		if(member.isEmpty() && seller.isEmpty()) {
			System.out.println("등록된 회원이 없습니다");	
			return;
		}
		else if(!member.isEmpty()) {				
			for(int i = 0 ; i < member.size() ; i++) {
				if(member.get(i).getMemberId().equals(id)) {
					member.remove(i);
				System.out.println("회원삭제 완료되었습니다");
				break;
				}
				else
					System.out.println("해당 정보로 등록된 회원이 없습니다");
			}
		}
		else if(!seller.isEmpty()) {
			for(Seller se : seller) {
				if(se.getSellerId().equals(id)) {
					seller.remove(se);
				}
			}
			
		}
	
}
		

	
	public void printMemberAll() {
		if (member.isEmpty() && seller.isEmpty()) {
			System.out.println("등록 된 정보가 없습니다");
			return;
		}
		else{
			for(Seller se : seller)
				System.out.println(se.inform());
			
			for(Member me : member) 
				System.out.println(me.inform());
													
			}
		}
				

	
	public void printMemberOne(String id) {
		if(member.isEmpty() && seller.isEmpty()) {
			System.out.println("등록 되지 않은 회원입니다");
			return;
		}
		else{
			for(Seller se : seller) {
					if(se.getSellerId().equals(id)) {
						System.out.println(se.inform());
						break;
			}
		}
			for(Member me : member) {
				if(me.getMemberId().equals(id)) {
					System.out.println(me.inform());
					break;
		}
				
			}
				
		}

	}
	
	public void saveMemberToFile(ArrayList<Member> list) {
		File f = new File("일반회원 파일.txt");
		try {
			f.createNewFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		try (BufferedWriter bfw = new BufferedWriter(new FileWriter(f))){			
			for(Member cu : list) {
			bfw.write(cu.inform());
			bfw.newLine();
			}
			System.out.println("저장완료");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	public void saveSellerToFile(ArrayList<Seller> sellerlist) {
		File f2 = new File("판매자 파일.txt");
		try {
			f2.createNewFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	//------------외계어 나옴---------------------------
//		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f2))){			
//			for(Seller se : sellerlist) {
//			oos.writeObject(se);
//			}
//			System.out.println("저장완료");
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(f2))) {
		        for (Seller se : sellerlist) {
		            writer.write(se.inform());
		            writer.newLine();
		        }
		        System.out.println("파일에 저장완료");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		

	
	}
	

}
