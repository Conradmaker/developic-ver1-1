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
		
		Users loginUser = new UsersDao().loginUsers(conn, userId, userPwd);
		
		/*JDBCTemplate.*/close(conn);
		
		return loginUser;
		
	}
	
	/**
	 * 2. 회원가입용 서비스	
	 * @param m		사용자가입력한 아이디,비밀번호,이름,전화번호,이메일,주소,취미가 담겨있는 객체
	 * @return		처리된 행 수
	 */
	public int insertUsers(Users m) {
		
		Connection conn = getConnection();
		
		int result = new UsersDao().insertUsers(conn, m);
		
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
	public Users updateUsers(Users m) {
		
		Connection conn = getConnection();
		
		int result = new UsersDao().updateUsers(conn, m);
		
		Users updateMem = null;
		if(result > 0) { // update 성공 했을 경우
			commit(conn);
			// 갱신된 회원 다시 조회해오기
			updateMem = new UsersDao().selectUsers(conn, m.getUserId());
			
		}else { // update 실패 했을 경우
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
		
	}
	
	/**
	 * 4. 비밀번호 변경 요청용 서비스
	 * @param userId		변경요청한 아이디
	 * @param userPwd		현재 비밀번호
	 * @param updatePwd		변경할 비밀번호
	 * @return				갱신된 회원객체/null
	 */
	public Users updatePwdUsers(String userId, String userPwd, String updatePwd) {
		
		Connection conn = getConnection();
		
		int result = new UsersDao().updatePwdUsers(conn, userId, userPwd, updatePwd);
		
		Users updateMem = null;
		if(result > 0) { // 비밀번호변경 성공
			commit(conn);
			
			// 갱신된 회원 재 조회
			updateMem = new UsersDao().selectUsers(conn, userId);
			
		}else { // 실패
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
	}
	
	/**
	 * 5. 회원 탈퇴용 서비스
	 * @param userId	탈퇴요청한 회원의 아이디
	 * @param userPwd	탈퇴요청한 회원의 비밀번호
	 * @return			처리된 행수 
	 */
	public int deleteUsers(String userId, String userPwd) {
		Connection conn = getConnection();
		
		int result = new UsersDao().deleteUsers(conn, userId, userPwd);
		
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
		
		int count = new UsersDao().idCheck(conn, checkId);
		
		close(conn);
		
		return count;
		
	}
	

}










