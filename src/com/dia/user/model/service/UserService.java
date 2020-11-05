package com.dia.user.model.service;

import static com.dia.common.JDBCTemplate.*;

import java.sql.Connection;

import com.dia.user.model.dao.UserDao;
import com.dia.user.model.vo.Users;

public class UserService {
	
	/**
	 * 1. 로그인용 서비스
	 * @param userId	사용자가 입력한 아이디값
	 * @param userPwd	사용자가 입력한 비밀번호값
	 * @return			해당 아이디와 비밀번호가 일치하는 조회된 회원객체 / null
	 */
	public Users loginUsers(String userId, String userPwd) {
		
		Connection conn = /*JDBCTemplate.*/getConnection();
		
		Users loginUser = new UserDao().loginUsers(conn, userId, userPwd);
		
		/*JDBCTemplate.*/close(conn);
		
		return loginUser;
		
	}
	
	
	/**
	 * 2. 회원가입용 서비스	
	 * @param m		사용자가입력한 아이디,비밀번호,이름,전화번호,이메일,주소,취미가 담겨있는 객체
	 * @return		처리된 행 수
	 */ 
	public int insertUsers(Users u) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().insertUsers(conn, u);
		
		if(result > 0) {
			/*JDBCTemplate.*/commit(conn);
		}else {
			/*JDBCTemplate.*/rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	
	/**
	 * 3. 정보변경용 서비스
	 * @param m		변경할 내용들+변경요청한회원의아이디 가 담겨있는 객체
	 * @return		갱신된 회원 객체/null
	 */	 
	public Users updateUsers(Users u) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().updateUsers(conn, u);
		
		Users updateUser = null;
		if(result > 0) { 
			commit(conn);
			updateUser = new UserDao().selectUsers(conn, u.getUser_id());
			
		}else { 
			rollback(conn);
		}
		
		close(conn);
		
		return updateUser;
		
	}
	
	/**
	 * 4. 비밀번호 변경 요청용 서비스
	 * @param userId		변경요청한 아이디
	 * @param userPwd		현재 비밀번호
	 * @param updatePwd		변경할 비밀번호
	 * @return				갱신된 회원객체/null
	 */
	public Users updatePwdUsers(String user_id, String user_password, String update_Password) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().updatePwdUsers(conn, user_id, user_password, update_Password);
		
		Users updateUser = null;
		if(result > 0) { 
			commit(conn);
			
			updateUser = new UserDao().selectUsers(conn, user_id);
			
		}else { 
			rollback(conn);
		}
		
		close(conn);
		
		return updateUser;
	}
	
	
	// 탈퇴용
	public int deleteUsers(String user_id, String user_Password) {
		Connection conn = getConnection();
		
		int result = new UserDao().deleteUsers(conn, user_id, user_Password);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int idCheck(String check_id) {
		
		Connection conn = getConnection();
		
		int count = new UserDao().idCheck(conn, check_id);
		
		close(conn);
		
		return count;
		
	}
	

}










