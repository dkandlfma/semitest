package member.view;

import java.util.Scanner;

import member.controller.MemberController;
import member.model.vo.Member;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	MemberController mControl = new MemberController();
	
	public void displayMenu() {
		do {
			System.out.println("*** 회원 관리 프로그램 ***");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 모든 회원 조회");
			System.out.println("3. 아이디로 회원 조회");
			System.out.println("4. 성별로 회원 조회");
			System.out.println("5. 암호 수정");
			System.out.println("6. 이메일 변경");
			System.out.println("7. 전화번호 변경");
			System.out.println("8. 주소 변경");
			System.out.println("9. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();
			sc.nextLine(); 	// 엔터 제거용
			
			switch(no) {
				case 1: mControl.insertMember(inputMember()); break;
				case 2: mControl.selectAll(); break;
				case 3: mControl.selectMember(inputMemberId()); break;
				case 4: mControl.selectGender(inputGender()); break;
				case 5: mControl.updatePassword(inputMemberId(),inputPassword()); break;
				case 6: break;
				case 7: break;
				case 8: break;
				case 9: mControl.deleteMember(inputMemberId()); break;
				case 0: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못된 번호입니다. 다시 입력해 주세요.");break;
			}
			
			
		}while(true);
		
	}
	private Object inputGender() {
		System.out.println("조회 할 회원 성별 입력(남:M/여:F) : ");
		
		return sc.nextLine();
	}
	private String inputPassword() {
		System.out.println("변경 할 회원 비밀번호 :");
		
		return sc.nextLine();
	}
	private String inputMemberId() {
		System.out.print("조회 할 회원 아이디 : ");
		
		return sc.nextLine();
	}

	private Member inputMember() {
		Member m = new Member();
		
		System.out.print("회원 아이디 : ");
		m.setMemberId(sc.nextLine());
		System.out.print("암호 : ");
		m.setMemberPwd(sc.nextLine());
		System.out.print("이름 : ");
		m.setMemberName(sc.nextLine());
		System.out.print("성별(남:M/여:F) : ");
		m.setGender(sc.nextLine().toUpperCase());
		System.out.print("이메일 : ");
		m.setEmail(sc.nextLine());
		System.out.print("전화번호(-포함) : ");
		m.setPhone(sc.nextLine());
		System.out.print("나이 : ");
		m.setAge(sc.nextInt());
		sc.nextLine(); 	// 엔터 제거
		System.out.print("주소 : ");
		m.setAddress(sc.nextLine());
		
		return m;
	}
	
	
	
	
	
	
	

}
