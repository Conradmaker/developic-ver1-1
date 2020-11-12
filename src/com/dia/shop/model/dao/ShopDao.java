package com.dia.shop.model.dao;

import static com.dia.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.dia.shop.model.vo.PageInfo;
import com.dia.shop.model.vo.Photo;



public class ShopDao {

	
	private Properties prop = new Properties();
	
	public ShopDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(ShopDao.class.getResource("/sql/shop/shop-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

	
	public int selectListcount(Connection conn) {
		
		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt("LISTCOUNT");
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}	
	
	
	// picshop 리스트 조회용	
	public ArrayList<Photo> selectPhotoList(Connection conn, PageInfo pi) {
		
		ArrayList<Photo> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPhotoList");
	
		try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
				int endRow = startRow + pi.getBoardLimit() - 1;
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Photo p = new Photo();
					p.setPhotoId(rset.getInt("PHOTO_ID"));
					p.setPhotoName(rset.getString("PHOTO_NAME"));
					p.setPhotoPrice(rset.getInt("PHOTO_PRICE"));
					p.setPhotoSrc(rset.getString("PHOTO_SRC"));
					p.setCategoryId(rset.getInt("CATEGORY_ID"));
					p.setUserNickname(rset.getString("USER_NICKNAME"));
					
					list.add(p);
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;

	}

	// 검색한 text에 대한 picshop 조회용
	public ArrayList<Photo> selectSearchPhotoList(Connection conn, String text, PageInfo pi) {
		
		ArrayList<Photo> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSearchPhotoList");
	
		try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
				int endRow = startRow + pi.getBoardLimit() - 1;
				
				pstmt.setString(1, "%"+text+"%");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
								
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Photo p = new Photo();
					p.setPhotoId(rset.getInt("PHOTO_ID"));
					p.setPhotoName(rset.getString("PHOTO_NAME"));
					p.setPhotoPrice(rset.getInt("PHOTO_PRICE"));
					p.setPhotoSrc(rset.getString("PHOTO_SRC"));
					p.setCategoryId(rset.getInt("CATEGORY_ID"));
					p.setUserNickname(rset.getString("USER_NICKNAME"));
					
					list.add(p);
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;

	}


	public ArrayList<Photo> selectShopCateList(Connection conn, PageInfo pi, int category) {
	ArrayList<Photo> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPhotoList");
	
		if(category!=0) {
			   sql = prop.getProperty("selectShopCateList");
		}
		
		try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
				int endRow = startRow + pi.getBoardLimit() - 1;
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				if(category!=0) {
					pstmt.setInt(1,category);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
				}
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Photo p = new Photo();
					p.setPhotoId(rset.getInt("PHOTO_ID"));
					p.setPhotoName(rset.getString("PHOTO_NAME"));
					p.setPhotoPrice(rset.getInt("PHOTO_PRICE"));
					p.setPhotoSrc(rset.getString("PHOTO_SRC"));
					p.setCategoryId(rset.getInt("category_id"));
					p.setUserNickname(rset.getString("USER_NICKNAME"));
					
					list.add(p);
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
}

}
