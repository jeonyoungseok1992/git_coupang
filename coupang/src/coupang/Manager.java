package coupang;

public class Manager {
	public final static String Id = "manager123";
	public final static String PWD = "pass123";
	
	public static boolean login(String id, String pwd) {
		if(id.equals(Id) && pwd.equals(PWD)) {
			System.out.println("로그인 성공");
			return true;
		}
		else{
			System.out.println("로그인 실패");
			return false;
		}
	}

}

