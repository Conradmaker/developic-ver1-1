package com.dia.user.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.dia.common.JDBCTemplate.*;
import com.dia.user.model.vo.Users;

public class UserDao {
	
	private Properties prop = new Properties();
	
	public UserDao() {
		
		String fileName = UserDao.class.getResource("/sql/user.xml").getPath();
		
		try {
			
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Users loginMember(Connection conn, String userId, String userPwd) {
		
		
		Users u = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("loginUsers");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { 
				u = new Users(
							   rset.getString("user_id"), 
							   rset.getString("user_email"),
							   rset.getString("user_password"),
							   rset.getString("user_name"),
							   rset.getString("user_nickname"),
							   rset.getString("user_phone"),
							   rset.getString("user_address"),
							   rset.getString("user_sns"),
							   rset.getString("user_info"),
							   rset.getString("user_avatar_src"),
							   rset.getDate("user_lastLogin"),
							   rset.getDate("use_createAt"),
							   rset.getInt("user_role")
							  );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*JDBCTemplate.*/close(rset);
			/*JDBCTemplate.*/close(pstmt);
		}
		
		return u; 
	}
	
	public int insertUsers(Connection conn, Users u) {
		
		
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertUsers"); // 誘몄셿�꽦
		
		try {
			pstmt = conn.prepareStatement(sql); // �떞湲� sql臾몄씠 誘몄셿�꽦
			
			
			pstmt.setString(1, u.getUser_id());
			pstmt.setString(2, u.getUser_password());
			pstmt.setString(3, u.getUser_name());
			pstmt.setString(4, u.getUser_phone());
			pstmt.setString(5, u.getUser_email());
			pstmt.setString(6, u.getUser_address());
			
			
			// �떎�뻾
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int updateUsers(Connection conn, Users u) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateUsers");
		
		try {
			pstmt = conn.prepareStatement(sql); // 誘몄셿�꽦�맂 sql臾�
			
			
			pstmt.setString(1, u.getUser_name());
			pstmt.setString(2, u.getUser_phone());
			pstmt.setString(3, u.getUser_email());
			pstmt.setString(4, u.getUser_address());			
			pstmt.setString(5, u.getUser_id());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Users selectUsers(Connection conn, String userId) {
		
		Users u = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUsers");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new Users(    
								rset.getString("user_id"), 
								rset.getString("user_email"),
								rset.getString("user_password"),
								rset.getString("user_name"),
								rset.getString("user_nickname"),
								rset.getString("user_phone"),
								rset.getString("user_address"),
								rset.getString("user_sns"),
								rset.getString("user_info"),
								rset.getString("user_avatar_src"),
								rset.getDate("user_lastLogin"),
								rset.getDate("use_createAt"),
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
	
	public int updatePwdUsers(Connection conn, String userId, String userPwd, String updatePwd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePwdUsers");
		
		try {
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int deleteUsers(Connection conn, String userId, String userPwd) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteUsers");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int idCheck(Connection conn, String checkId) {
		
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
		
		
	}

}








