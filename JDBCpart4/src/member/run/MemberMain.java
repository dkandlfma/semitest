package member.run;

import member.view.MemberMenu;



public class MemberMain {
	public static void main(String[] args) {
		// MVC2 디자인 패턴을 적용한 JDBC 회원 관리 프로그램 테스트
		new MemberMenu().displayMenu();
		
	}
}
