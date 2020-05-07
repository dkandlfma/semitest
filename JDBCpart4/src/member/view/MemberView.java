package member.view;

import java.util.ArrayList;

import member.model.vo.Member;

public class MemberView {

	public void display(ArrayList<Member> list) {
		for(Member m : list) {
			System.out.println(m);
		}
	}

	public void displayError(String error) {
		switch(error) {
			case "insert" : System.out.println("회원 가입 실패"); break;
			case "update" : System.out.println("회원 수정 실패"); break;
			case "delete" : System.out.println("회원 탈퇴 실패"); break;
			default : System.out.println("알 수 없는 에러 발생"); break;
		}	
	}
	
	public void displayMember(Member member) {
		System.out.println(member);
	}
	
	

}
