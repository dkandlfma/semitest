package controller;

import java.util.Scanner;

import model.dao.EmployeeModel;
import model.vo.Student;

public class TestJDBC {

	public static void main(String[] args) {
		EmployeeModel model = new EmployeeModel();
		
		// 모든 학생 조회
//		model.selectAll();
		
		// 키보드로 아이디를 입력 받아 학생 한명 조회
//		System.out.print("아이디 : ");
//		System.out.println(model.selectOne(new java.util.Scanner(System.in).nextLine()));
		
		// 학생 추가를 위해 입력받은 정보를 insert
//		Scanner sc = new Scanner(System.in);
//		System.out.print("회원 아이디 : ");
//		String id = sc.nextLine();
//		
//		System.out.print("회원 패스워드 : ");
//		String password = sc.nextLine();
//		
//		System.out.print("회원명 : ");
//		String name = sc.nextLine();
//		
//		System.out.print("성별 : ");
//		String gender = sc.nextLine();
//		
//		System.out.print("이메일 : ");
//		String email = sc.nextLine();
//		
//		System.out.print("전화번호 : ");
//		String phone = sc.nextLine();
//		
//		System.out.print("주소 : ");
//		String address = sc.nextLine();
//		
//		System.out.print("나이 : ");
//		int age = sc.nextInt();
//		
//		Student st = new Student(id, password, name, gender, email, phone,
//				address, age);
//		
//		model.insertEmployee(st);
		
		
		
//		 학생 추가를 위해 입력받은 정보를 update
		
		// 수정할 학생 조회
		// 키보드로 아이디를 입력 받아 학생 한명 조회
		System.out.print("수정 할 아이디 : ");
		String result = model.selectOne(new java.util.Scanner(System.in).nextLine());
		System.out.println("수정 할 아이디는 " + result);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("회원 패스워드 : ");
		String password = sc.nextLine();
		
		System.out.print("회원명 : ");
		String name = sc.nextLine();
		
		System.out.print("성별 : ");
		String gender = sc.nextLine();
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		Student st = new Student(id, password, name, gender, email, phone,
				address, age);
		
		model.updateStudent(result, st);
	
		
		// 키보드로 삭제할  아이디를 입력 받아 학생 한명 조회
//		System.out.print("아이디 : ");
//		model.delete(new java.util.Scanner(System.in).nextLine());
		
		
	}

	
	
	
	
	
	
}
