package com.dia.user.model.service;

import static com.dia.common.JDBCTemplate.*;

import java.sql.Connection;

import com.dia.user.model.dao.UserDao;
import com.dia.user.model.vo.User;

/**
 * @author letth
 *
 */
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
	
	
	/**
	 * 2. 회원가입용 서비스
	 * @param u
	 * @return
	 */
	public int insertUser(User u) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().insertUser(conn, u);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}


	public User updateUser(User u) {
	
		Connection conn = getConnection();
		
		int result = new UserDao().updateUser(conn, u);
		
		User updateUs = null;
		if(result > 0) { // update 성공 했을 경우
			commit(conn);
			// 갱신된 회원 다시 조회
			updateUs = new UserDao().selectUser(conn, u.getUserId());
			
		}else { // update 실패 했을 경우
			rollback(conn);
		}
		close(conn);
		
		return updateUs;

	}

	
	public User updatePwdUser(String userId, String userPwd, String updatePwd) {
	
		Connection conn = getConnection();
		
		int result = new UserDao().updatePwdUser(conn, userId, userPwd, updatePwd);
		
		User updateUs = null;
		if(result > 0) { // 비밀번호변경 성공 시 
			commit(conn);
			
			// 갱신된 회원 재조회
			updateUs = new UserDao().selectUser(conn, userId);
			
		}else { // 변경 실패 시 
			rollback(conn);
		}
		
		close(conn);
		
		return updateUs;
				
	}
	

	public int deleteUser(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().deleteUser(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public int idCheck(String checkId) {
	
		Connection conn = getConnection();
		
		int count = new UserDao().idCheck(conn, checkId);
		
		close(conn);
		
		return count;
	}



}












