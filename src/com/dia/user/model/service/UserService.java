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
	 * @param userId 사용자가 입력한 아이디
	 * @param userPwd 사용자가 입력한 비밀번호
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
	 * @param u 사용자가 입력한 아이디, 비밀번호, 이름, 이메일 담긴 객체  
	 * @return 처리된 행 수 
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


	/**
	 * 3. 회원정보수정 서비스 
	 * @param u 변경할정보+변경요청한회원아이디 담긴 객체
	 * @return 갱신된 회원 객체/null
	 */
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
	
	/**
	 * 4. 비밀번호 변경 서비스 
	 * @param userId 변경요청한 아이디
	 * @param userPwd 현재비밀번호
	 * @param updatePwd 변경할비밀번호
	 * @return 갱신된 회원 객체/null
	 */
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
	

	/**
	 * 5. 회원탈퇴 서비스 
	 * @param userId 탈퇴요청 회원 아이디
	 * @param userPwd 탈퇴요청 회원 비밀번호 
	 * @return 처리된 행 수 
	 */
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


	/**
	 * 6. 아이디 중복체크&유효성 검사 서비스 
	 * @param checkId 
	 * @return
	 */
	public int idCheck(String checkId) {
	
		Connection conn = getConnection();
		
		int count = new UserDao().idCheck(conn, checkId);
		
		close(conn);
		
		return count;
	}



}












