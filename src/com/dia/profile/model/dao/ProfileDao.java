package com.dia.profile.model.dao;

import static com.dia.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.dia.photo.model.vo.PhotoInsert;
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
	
	public User selectUser(Connection conn, int userNo){
		
		User u = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUser");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new User( rset.getInt("USER_NO")
						    , rset.getString("USER_ID")
						    , rset.getString("USER_NAME")
						    , rset.getString("USER_NICKNAME")
						    , rset.getString("PHONE")
						    , rset.getString("EMAIL")
						    , rset.getString("SNS")
						    , rset.getString("USER_INFO")
						    , rset.getString("USER_AVATAR_SRC")
						    , rset.getInt("USER_ROLE")
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
	
	public ArrayList<PhotoInsert> selectPhotos(Connection conn, int userNo){
		
		ArrayList<PhotoInsert> photoList = new ArrayList<>();		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPhotos");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				PhotoInsert p = new PhotoInsert( rset.getInt("PHOTO_ID")
						                       , rset.getString("PHOTO_NAME")
						                       , rset.getInt("PHOTO_SALE")
						                       , rset.getInt("PHOTO_PRICE")
						                       , rset.getDate("PHOTO_CREATEDAT")
						                       , rset.getInt("PHOTO_STATE")
						                       , rset.getString("PHOTO_SRC")
						                       , rset.getString("PHOTO_INFO")
						                       , rset.getDate("PHOTO_UPDATEAT")
						                       , rset.getInt("USER_NO")
						                       , rset.getInt("CATEGORY_ID")
						                       );
				photoList.add(p);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		return photoList;
		
	}
	
	public ArrayList<Picstorys> selectPicList(Connection conn, int userNo){
		
		ArrayList<Picstorys> picList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPicList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Picstorys p = new Picstorys( rset.getInt("PICSTORY_ID")
						                   , rset.getString("PICSTORY_NAME")
						                   , rset.getDate("PICSTORY_CREATEDAT")
						                   , rset.getInt("USER_NO")
						                   );
				picList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return picList;
		
	}
	
	public Picstorys selectPicThumbnail(Connection conn, int picId) {
		
		Picstorys p = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPicThumbnail");
		
		System.out.println(picId);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, picId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Picstorys(  rset.getInt("PHOTO_ID")
						          , rset.getString("PHOTO_SRC")
						         );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return p;
		
	}
	
	public ArrayList<PhotoInsert> selectPicPhoto(Connection conn, int userNo, int picId){
		
		ArrayList<PhotoInsert> picPhoto = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPicPhoto");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, picId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				PhotoInsert p = new PhotoInsert(  rset.getInt("PHOTO_ID")
						                        , rset.getString("PHOTO_NAME")
						                        , rset.getInt("PHOTO_SALE")
						                        , rset.getInt("PHOTO_PRICE")
						                        , rset.getDate("PHOTO_CREATEDAT")
						                        , rset.getInt("PHOTO_STATE")
						                        , rset.getString("PHOTO_SRC")
						                        , rset.getString("PHOTO_INFO")
						                        , rset.getDate("PHOTO_UPDATEAT")
						                        , rset.getInt("USER_NO")
						                        , rset.getInt("CATEGORY_ID")
						                       );
				picPhoto.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return picPhoto;
		
	}

}
