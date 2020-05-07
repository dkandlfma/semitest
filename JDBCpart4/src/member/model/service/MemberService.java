package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public ArrayList<Member> selectAll() {
		MemberDao mDao = new MemberDao();
		Connection conn = getConnection();
		
		ArrayList<Member> list = mDao.selectAll(conn);
		
		close(conn);
				
		return list;
	}

	public int insertMember(Member m) {
		MemberDao mDao = new MemberDao();
		Connection conn = getConnection();
		
		int result = mDao.insertMember(conn,m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Member selectOne(String id) {
		MemberDao mDao = new MemberDao();
		Connection conn = getConnection();
		
		Member m = mDao.selectOne(conn, id);
		
		close(conn);
		
		return m;
	}

	public int updatePassword(String id, String pwd) {
		MemberDao mDao = new MemberDao();
		Connection conn = getConnection();
		int result = 0;
		
		result = mDao.updatePassword(conn, id, pwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public int deleteMember(String id) {
		MemberDao mDao = new MemberDao();
		Connection conn = getConnection();
		int result = 0;
		
		result = mDao.deleteMember(conn, id);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public ArrayList<Member> selectGender(String gender) {
		MemberDao mDao = new MemberDao();
		Connection conn = getConnection();
		
		ArrayList<Member> list = mDao.selectGender(conn,gender);
		
		close(conn);
		
		
		
		
		return list;
	}
		

	
	
	
	
	
}
