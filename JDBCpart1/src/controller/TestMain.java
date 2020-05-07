package controller;

import java.util.Calendar;
import java.util.Scanner;

import model.dao.JDBCModel;
import model.vo.Employee;

public class TestMain {
		static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JDBCModel model = new JDBCModel();

		// 사원 전체 조회
//		model.testJDBC();
		
		// 사원번호에 따른 사원 한명 조회
//		System.out.println("조회 할 사번을 입력하시오 : ");
//		String empId = sc.nextLine();
//		model.testJDBC2(empId);
//		
//		// 객체 생성 후 삽입
//		주 목적 : Calendar -> sql.Date형으로
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());	// 1) Calendar -> util.Date
		
		// 2) util.Date -> sql.Date형으로
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		
		System.out.print("empId 입력 : ");
		String empId = sc.nextLine();
		System.out.print("empName 입력 : ");
		String empName = sc.nextLine();
		System.out.print("empNo 입력 : ");
		String empNo = sc.nextLine();
		// hireDate 같은 경우는 위에 있는 dqlDate값을 활용할 예정
		
		System.out.print("salary 입력(int) : ");
		int salary = sc.nextInt();
		System.out.print("bonusPct 입력(double : ");
		double bonusPct = sc.nextDouble();
		
		Employee emp = new Employee(empId, empName, empNo, sqlDate, salary, bonusPct);
		
		model.testInsert(emp);
		
		
		
	}

}
