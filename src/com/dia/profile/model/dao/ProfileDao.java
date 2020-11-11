package com.dia.profile.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.dia.profile.model.vo.Picstorys;
import com.dia.user.model.vo.User;

public class ProfileDao {
	
	private Properties prop = new Properties();
	
	public ProfileDao() {
		try {
			prop.loadFromXML(new FileInputStream(ProfileDao.class.getResource("/sql/profile/profile-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> selectUser(Connection conn, int userNo){
		
		ArrayList<User> userList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUser");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			// 담아줘야함
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Picstorys> selectPicList(Connection conn, int userNo){
		
		ArrayList<Picstorys> picList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPicList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			// 이제 담아줘야함 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
