package com.dia.photo.model.dao;

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

import com.dia.photo.model.vo.PageInfo;
import com.dia.photo.model.vo.Photo;
import com.dia.user.model.dao.UserDao;

public class PhotoDao {

	private Properties prop = new Properties();
	
	public PhotoDao() {
		
		String fileName = UserDao.class.getResource("/sql/photo/photo-mapper.xml").getPath();
		
		try {
			
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectFeedListCount(Connection conn) {
		int listFeedCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectFeedListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listFeedCount = rset.getInt("LISTCOUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listFeedCount;
	}
	
	public ArrayList<Photo> selectFeedList(Connection conn, PageInfo pi){
		ArrayList<Photo> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loadFeed");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			System.out.println(startRow);
			System.out.println(endRow);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Photo(rset.getInt("photo_id"),
						 		   rset.getString("photo_name"),
						 		   rset.getInt("photo_sale"),
						 		   rset.getInt("photo_price"),
						 		   rset.getDate("photo_createdat"),
						 		   rset.getInt("photo_state"),
						 		   rset.getString("photo_src"),
						 		   rset.getString("photo_info"),
						 		   rset.getDate("photo_updateAt"),
						 		   rset.getInt("a.user_no"),
						 		   rset.getInt("catagory_id")));
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
