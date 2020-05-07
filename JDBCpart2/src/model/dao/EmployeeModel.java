package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Student;

public class EmployeeModel {

	public void selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			// DBMS의 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Connection 객체 만들기 (길)
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"student","student");
			
			// query 생성 (짐)
			String query = "SELECT * FROM MEMBER";
			
			// Statement 객체 생성 
			stmt = conn.createStatement();
			// DB를 다녀오기(완성된 짐을 싣고 DB 다녀오기 (이미 쿼리가 완성 되어 있어야 됨))
			rset = stmt.executeQuery(query);
			
			// ResultSet을 확인
			while(rset.next()) {
				System.out.println(rset.getString("member_id"));	
				// 1. DB테이블의 컬럼명과 완전 동일하게
				// 2. 자료형도 동일하게(getString, getInt, getDouble, getDate)
			}
			
			// 밑에 finally 추가해서 close 빼먹지 말자!!
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 세가지 객체 close()!
				conn.close();
				stmt.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public String selectOne(String memberId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String result = null;
		
		// DBMS의 드라이버 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connection 객체 만들기 (길)
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"student","student");
			
			String query = "SELECT * FROM MEMBER WHERE MEMBER_ID = '" + memberId
							+"'";
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				result = rset.getString("member_id");
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public void insertEmployee(Student st) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO MEMBER \r\n" + 
				"VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"student","student");
			
			// 미완성 된(?가 있는) 쿼리를 지니고 객체 생성
			// 물론, 물음표가 없어도 쓸 수 있다.(완성된 쿼리문도 가능)
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, st.getMemberId());
			pstmt.setString(2, st.getMemberPwd());
			pstmt.setString(3, st.getMemberName());
			pstmt.setString(4, st.getGender());
			pstmt.setString(5, st.getEmail());
			pstmt.setString(6, st.getPhone());
			pstmt.setString(7, st.getAddress());
			pstmt.setInt(8, st.getAge());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println(result+"개의 행이 추가 되었습니다.");
				conn.commit();
			}else {
				System.out.println("실패");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public void updateStudent(String memberId, Student st) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"student","student");
			
			String query = "UPDATE MEMBER SET MEMBER_PWD = ?,  WHERE MEMBER_ID = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, st.getMemberPwd());
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println(result + "개의 행이 수정되었습니다.");
				conn.commit();
			}else {
				System.out.println("실패");
				conn.rollback();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	
	
	
	
	
	
	
	
}
