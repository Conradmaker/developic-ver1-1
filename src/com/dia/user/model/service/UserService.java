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
	
}












