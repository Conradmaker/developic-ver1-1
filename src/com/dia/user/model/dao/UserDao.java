package com.dia.user.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.dia.common.JDBCTemplate.*;
import com.dia.user.model.vo.User;

public class UserDao {
	
	private Properties prop = new Properties();
	
	public UserDao() {
		
		String fileName = UserDao.class.getResource("/sql/user/user-mapper.xml").getPath();
		
		try {
			
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public User loginUser(Connection conn, String userId, String userPwd) {
		
		User u = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("loginUser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { 
				u = new User(
						   rset.getInt("user_no"), 
						   rset.getString("user_id"),
						   rset.getString("user_pwd"),
						   rset.getString("user_name"),
						   rset.getString("user_nickname"),
						   rset.getString("phone"),
						   rset.getString("email"),
						   rset.getString("address"),
						   rset.getString("sns"),
						   rset.getString("user_info"),
						   rset.getString("user_avatar_src"),
						   rset.getDate("user_lastlogin"),
						   rset.getDate("user_createdat"),
						   rset.getInt("user_role")
						  );
										
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return u; 
	}
	
//	
//	public int insertUsers(Connection conn, Users u) {
//		
//		
//		
//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		
//		String sql = prop.getProperty("insertUsers"); 
//		
//		try {
//			pstmt = conn.prepareStatement(sql); 
//			
//			
//			pstmt.setString(1, u.getUser_id());
//			pstmt.setString(2, u.getUser_email());
//			pstmt.setString(3, u.getUser_password());
//			pstmt.setString(4, u.getUser_name());
//			pstmt.setString(5, u.getUser_nickname());
//			pstmt.setString(6, u.getUser_phone());
//			pstmt.setString(7, u.getUser_address());
//			pstmt.setString(8, u.getUser_sns());
//			pstmt.setString(9, u.getUser_info());
//			pstmt.setString(10, u.getUser_avatar_src());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//		
//	}
//	
//	public int updateUsers(Connection conn, Users u) {
//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		
//		String sql = prop.getProperty("updateUsers");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, u.getUser_name());
//			pstmt.setString(2, u.getUser_phone());
//			pstmt.setString(3, u.getUser_email());
//			pstmt.setString(4, u.getUser_address());			
//			pstmt.setString(5, u.getUser_id());
//			
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}
//	
//	public Users selectUsers(Connection conn, String user_id) {
//		
//		Users u = null;
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String sql = prop.getProperty("selectUsers");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, user_id);
//			
//			rset = pstmt.executeQuery();
//			
//			if(rset.next()) {
//				u = new Users(    
//								rset.getString("user_id"), 
//								rset.getString("user_email"),
//								rset.getString("user_password"),
//								rset.getString("user_name"),
//								rset.getString("user_nickname"),
//								rset.getString("user_phone"),
//								rset.getString("user_address"),
//								rset.getString("user_sns"),
//								rset.getString("user_info"),
//								rset.getString("user_avatar_src"),
//								rset.getDate("user_lastLogin"),
//								rset.getDate("use_createAt"),
//								rset.getInt("user_role")
//							  );
//			}
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return u;
//		
//	}
//	
//	public int updatePwdUsers(Connection conn, String user_id, String user_password, String updatePwd) {
//		
//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		
//		String sql = prop.getProperty("updatePwd.u");
//		
//		try {
//			pstmt = conn.prepareStatement(sql); 
//			
//			pstmt.setString(1, updatePwd);
//			pstmt.setString(2, user_id);
//			pstmt.setString(3, user_password);
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}
//	
//	
//	public int deleteUsers(Connection conn, String user_id, String user_password) {
//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		String sql = prop.getProperty("delete.u");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, user_id);
//			pstmt.setString(2, user_password);
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//		
//	}
//	
//	public int idCheck(Connection conn, String checkId) {
//		
//		int count = 0;
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String sql = prop.getProperty("idCheck");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, checkId);
//			
//			rset = pstmt.executeQuery();
//			
//			if(rset.next()) {
//				count = rset.getInt(1);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return count;
//		
//		
//	}
//
}








