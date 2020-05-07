package member.controller;

import java.util.ArrayList;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.view.MemberView;

public class MemberController {
	MemberView mview = new MemberView();
	
	public void selectAll() {
		MemberService mService = new MemberService();
		ArrayList<Member> list = mService.selectAll();
		
		if(list.isEmpty()) {
			System.out.println("조회 할 회원 없음!");
		}else {
			mview.display(list);
		}
		
	}

	public void insertMember(Member m) {
		MemberService mService = new MemberService();
		int result = mService.insertMember(m);
		
		if(result > 0) {
			System.out.println("회원 가입 성공");
		}else {
			mview.displayError("insert");
		}
	}

	public void selectMember(String id) {
		MemberService mService = new MemberService();
		Member member = mService.selectOne(id);
		
		if(member == null) {
			System.out.println("조회 할 회원 없음");
		}else {
			mview.displayMember(member);
		}
	}

	public void updatePassword(String id, String pwd) {
		MemberService mService = new MemberService();
		
		int result = 0;
		
		result = mService.updatePassword(id, pwd);
		
		if(result > 0) {
			System.out.println(id + "회원 비밀번호 수정 성공");
		}else {
			mview.displayError("update");
		}
	}

	public void deleteMember(String id) {
MemberService mService = new MemberService();
		
		int result = 0;
		
		result = mService.deleteMember(id);
		
		if(result > 0) {
			System.out.println(id + "회원 탈퇴 성공");
		}else {
			mview.displayError("delete");
		}
		
	}

	public void selectGender(String gender) {
		MemberService mService = new MemberService();
		ArrayList<Member> list = mService.selectGender(gender);
		
		if(list.isEmpty()) {
			System.out.println("조회 할 회원 없음");
		} else {
			mview.display(list);
		}
		
	}

}









