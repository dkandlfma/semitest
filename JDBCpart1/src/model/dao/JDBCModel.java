package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Employee;

public class JDBCModel {
	public JDBCModel() {}
	
	public void testJDBC() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
	// 1. 해당 데이터베이스(DBMS)에 대한 라이브러리 등록작업(드라이버 등록)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. 데이터베이스와 연결함
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"JDBC","JDBC"
					);
	// 3. 쿼리문 가지고 DB에 가서 쿼리문 실행시키고 결과 가지고 오는 객체 생성함
			String query = "SELECT * FROM EMPLOYEE";
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				System.out.println(rset.getString("emp_id") + ", " +
									rset.getString("emp_name") + ", " +
									rset.getString("emp_no") + ", " +
									rset.getString("EMAIL") + ", " +
									rset.getString("PHONE") + ", " +
									rset.getDate("HIRE_DATE") + ", " +
									rset.getString("JOB_ID") + ", " +
									rset.getInt("SALARY") + ", " +
									rset.getDouble("BONUS_PCT") + ", " +
									rset.getString("MARRIAGE") + ", " +
									rset.getString("MGR_ID") + ", " +
									rset.getString("DEPT_ID"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	// 4. DB와 관련된 객체는 반드시 close 해야 함
			try {
				rset.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void testJDBC2(String empId) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"JDBC","JDBC"
					);
			
			// Statement 방식
//			String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = " + empId;
//							
//			stmt = conn.createStatement();
//			
//			rset = stmt.executeQuery(query);
			
			// PreparedStatement 방식
			String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, empId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				System.out.println(rset.getString("emp_id") + ", " +
						rset.getString("emp_name") + ", " +
						rset.getString("emp_no") + ", " +
						rset.getString("EMAIL") + ", " +
						rset.getString("PHONE") + ", " +
						rset.getDate("HIRE_DATE") + ", " +
						rset.getString("JOB_ID") + ", " +
						rset.getInt("SALARY") + ", " +
						rset.getDouble("BONUS_PCT") + ", " +
						rset.getString("MARRIAGE") + ", " +
						rset.getString("MGR_ID") + ", " +
						rset.getString("DEPT_ID"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
//				stmt.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public void testInsert(Employee emp) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		// ResultSet은 필요 X(왜나면 DML(INSERT) 작업을 해줄 꺼라서 반환형이 int이므로)
		// DQL : SELECT -> 반환형이 Result Set
		// DML : INSERT, UPDATE, DELETE -> 반환형이 int(몇 행을 DML작업을 했는지를 int로 반환)
		int result = 0;
		System.out.println(emp);
		
		// 1) Statement로 하는 법
//		String query = "INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, SALARY, BONUS_PCT)\r\n" + 
//				"VALUES('"+emp.getEmpId()+"','"+emp.getEmpName()+"','"+emp.getEmpNo()+"','"+
//				emp.getHireDate()+"', "+	emp.getSalary()+","+emp.getBonusPct()+")";
		
		// 2) PreparedStatement로 하는 법
		String query = "INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, SALARY, BONUS_PCT)"
				+ "VALUES(?,?,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"JDBC","JDBC"
					);
			
			// 1) Statement로 하는 법
//			stmt = conn.createStatement();
//			result = stmt.executeUpdate(query);
			
			// 2) PreparedStatement로 하는 법
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpNo());
			pstmt.setDate(4, emp.getHireDate());
			pstmt.setInt(5, emp.getSalary());
			pstmt.setDouble(6, emp.getBonusPct());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "개의 행이 추가되었습니다.");
				conn.commit();
			}else {
				System.out.println("insert 작업이 실패했습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//				stmt.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	
}
