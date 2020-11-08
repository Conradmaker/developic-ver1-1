package com.dia.photo.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.dia.photo.model.vo.Photo;

import static com.dia.common.JDBCTemplate.close;

public class PhotoDao {

	private Properties prop = new Properties();
	
	public PhotoDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(PhotoDao.class.getResource("/sql/photo/photo-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int insertPhoto(Connection conn, Photo p) {
		// insert문 => 처리된 행수
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPhoto");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getPhotoName());
			pstmt.setInt(2, p.getPhotoSale());
			pstmt.setInt(3, p.getPhotoPrice());
			pstmt.setString(4, p.getPhotoSrc());
			pstmt.setString(5, p.getPhotoInfo());
			pstmt.setInt(6, p.getUserNo());
			pstmt.setInt(7, p.getCategoryId());
			
			result = pstmt.executeUpdate();			
			
			System.out.println("333333333333");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
}
