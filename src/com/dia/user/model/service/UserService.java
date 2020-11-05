package com.dia.user.model.service;

import static com.dia.common.JDBCTemplate.*;

import java.sql.Connection;



import com.dia.user.model.dao.UserDao;
import com.dia.user.model.vo.Users;

public class UserService {
	
	/**
	 * 1. 濡�洹몄�몄�� ��鍮���
	 * @param userId	�ъ�⑹��媛� ���ν�� ���대��媛�
	 * @param userPwd	�ъ�⑹��媛� ���ν�� 鍮�諛�踰��멸�
	 * @return			�대�� ���대���� 鍮�諛�踰��멸� �쇱����� 議고���� ����媛�泥� / null
	 */
	public Users loginUsers(String userId, String userPwd) {
		
		Connection conn = /*JDBCTemplate.*/getConnection();
		
		Users loginUser = new UserDao().loginUsers(conn, userId, userPwd);
		
		/*JDBCTemplate.*/close(conn);
		
		return loginUser;
		
	}
	
	
	/**
	 * 2. ����媛����� ��鍮���	
	 * @param m		�ъ�⑹��媛����ν�� ���대��,鍮�諛�踰���,�대�,����踰���,�대���,二쇱��,痍⑤�멸� �닿꺼���� 媛�泥�
	 * @return		泥�由щ�� �� ��
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
	 * 4. 鍮�諛�踰��� 蹂�寃� ��泥��� ��鍮���
	 * @param userId		蹂�寃쎌��泥��� ���대��
	 * @param userPwd		���� 鍮�諛�踰���
	 * @param updatePwd		蹂�寃쏀�� 鍮�諛�踰���
	 * @return				媛깆���� ����媛�泥�/null
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
	
	
	// ���댁��
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












