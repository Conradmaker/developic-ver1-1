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
	
	
	public int insertUser(Connection conn, User u) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertUser"); 
		
		try {
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPwd());
			pstmt.setString(3, u.getUserName());
			pstmt.setString(4, u.getEmail());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int updateUser(Connection conn, User u) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateUser");
		
		System.out.println(u.getUserName());
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
		    pstmt.setString(1, u.getUserName());
		//	pstmt.setString(2, u.getUserPwd());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getUserNickname());
			pstmt.setString(4, u.getPhone());
			pstmt.setString(5, u.getAddress());
			pstmt.setString(6, u.getSns());
			pstmt.setString(7, u.getUserInfo());
			pstmt.setString(8, u.getUserAvatarSrc());
			pstmt.setString(9, u.getUserId());
		
			result = pstmt.executeUpdate();
	
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public User selectUser(Connection conn, String userId) {
	
		User u = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
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

	
	

	public int updatePwdUser(Connection conn, String userId, String userPwd, String updatePwd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePwdUser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int deleteUser(Connection conn, String userId, String userPwd) {
		
		int result = 0; 
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteUser");
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

}








