package book.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import book.model.vo.Book;

/*
 * DAO(Database Access Object) : DB와 연결되는 클래스로 CRUD와 관련된 쿼리 실행
 * 
 * C : create (INSERT)
 * R : read   (SELECT)
 * U : update (UPDATE)
 * D : delete (DELETE)
 */

public class BookDao {

	public ArrayList<Book> selectAllBooks(Connection conn) {
		ArrayList<Book> list = new ArrayList();
		Statement stmt = null;
		ResultSet rset = null;
		
//		String query = "SELECT * FROM BOOK";
		
		try {
			// query도 Properties를 활용해서 해보자.
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("selectAllBooks");
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Book b = new Book();
				b.setBid(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPub(rset.getString("publisher"));
				b.setPub_date(rset.getString("publisher_date"));
				b.setPrice(rset.getInt("price"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int insertBook(Connection conn, Book b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = "INSERT INTO BOOK VALUES(SEQ.NEXTVAL,?,?,?,?,?)";
		
		try {
			
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("insertBook");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPub());
			pstmt.setString(4, b.getPub_date());
			pstmt.setInt(5, b.getPrice());
			
			result = pstmt.executeUpdate();
						
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public Book selectBook(Connection conn, int bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Book b = null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("selectBook");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bid);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				b = new Book();
				b.setBid(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPub(rset.getString("publisher"));
				b.setPub_date(rset.getString("publisher_date"));
				b.setPrice(rset.getInt("price"));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
				
		return b;
	}

	public int deleteBook(Connection conn, int bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("deleteBook");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bid);
			
			result = pstmt.executeUpdate();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int updateBook(Connection conn, Book b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("updateBook");
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getAuthor());
			pstmt.setString(3, b.getPub());
			pstmt.setString(4, b.getPub_date());
			pstmt.setInt(5, b.getPrice());
			pstmt.setInt(6, b.getBid());
			
			result = pstmt.executeUpdate();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Book> searchBookTitle(Connection conn, String title) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList();
		
		// query구문 like 쓸 때 조심~!
//		String query = "select * from book where title like '%'||?||'%'";
		
		try {
			
			Properties prop = new Properties();
			prop.load(new FileReader("query.properties"));
			String query = prop.getProperty("selectBookTitle");
			
			pstmt = conn.prepareStatement(query);	
			pstmt.setString(1, title);			
			rset = pstmt.executeQuery();
			
			Book b = null;
			while(rset.next()) {
				b = new Book();
				
				b.setBid(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPub(rset.getString("publisher"));
				b.setPub_date(rset.getString("publisher_date"));
				b.setPrice(rset.getInt("price"));			
			
				list.add(b);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

}






