package com.dia.user.model.service;

import static com.dia.common.JDBCTemplate.*;

import java.sql.Connection;

import com.dia.user.model.dao.UserDao;
import com.dia.user.model.vo.User;

public class UserService {
	
	
	/** 
	 * 1. 로그인용 서비스 
	 * @param userId 
	 * @param userPwd
	 * @return	해당 아이디/비밀번호 일치해 조회된 회원객체 / null
	 */
	public User loginUser(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		User loginUser = new UserDao().loginUser(conn, userId, userPwd);
		
		close(conn);
		
		return loginUser;
		
	}
	
//	
//	
//	
//	public int insertUsers(Users u) {
//		
//		Connection conn = getConnection();
//		
//		int result = new UserDao().insertUsers(conn, u);
//		
//		if(result > 0) {
//			/*JDBCTemplate.*/commit(conn);
//		}else {
//			/*JDBCTemplate.*/rollback(conn);
//		}
//		
//		close(conn);
//		
//		return result;
//		
//	}
//	
//	public Users updateUsers(Users u) {
//		
//		Connection conn = getConnection();
//		
//		int result = new UserDao().updateUsers(conn, u);
//		
//		Users updateUser = null;
//		if(result > 0) { 
//			commit(conn);
//			updateUser = new UserDao().selectUsers(conn, u.getUserId());
//			
//		}else { 
//			rollback(conn);
//		}
//		
//		close(conn);
//		
//		return updateUser;
//		
//	}
//	
//	
//	public Users updatePwdUsers(String userId, String userPwd, String updatePwd) {
//		
//		Connection conn = getConnection();
//		
//		int result = new UserDao().updatePwdUsers(conn, userId, userPwd, updatePwd);
//		
//		Users updateUser = null;
//		if(result > 0) { 
//			commit(conn);
//			
//			updateUser = new UserDao().selectUsers(conn, userId);
//			
//		}else { 
//			rollback(conn);
//		}
//		
//		close(conn);
//		
//		return updateUser;
//	}
//	
//	
//	
//	public int deleteUsers(String userId, String userPwd) {
//		Connection conn = getConnection();
//		
//		int result = new UserDao().deleteUsers(conn, userId, userPwd);
//		
//		if(result > 0) {
//			commit(conn);
//		}else {
//			rollback(conn);
//		}
//		
//		close(conn);
//		
//		return result;
//	}
//	
//	public int idCheck(String checkId) {
//		
//		Connection conn = getConnection();
//		
//		int count = new UserDao().idCheck(conn, checkId);
//		
//		close(conn);
//		
//		return count;
//		
//	}
}












