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

import com.dia.shop.model.vo.PageInfo;
import com.dia.photo.model.vo.Comment;
import com.dia.photo.model.vo.Photo;
import com.dia.user.model.dao.UserDao;
import static com.dia.common.JDBCTemplate.close;


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
	
	public ArrayList<Photo> selectFeedList(Connection conn, PageInfo pi,int category){
		ArrayList<Photo> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loadFeed");
		
		if(category!=0) {
			   sql = prop.getProperty("loadFeedCategory");
		}
	

		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			System.out.println(startRow);
			System.out.println(endRow);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			if(category!=0) {
				pstmt.setInt(1, category);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			}

			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Photo(rset.getInt("photo_id"),
						 		   rset.getString("photo_name"),
						 		   rset.getInt("photo_sale"),
						 		   rset.getInt("photo_price"),
						 		   rset.getDate("photo_createdat"),
						 		   rset.getString("photo_src"),
						 		   rset.getString("photo_info"),
						 		   rset.getDate("photo_updateAt"),
						 		   rset.getInt("category_id"),
						 		   rset.getInt("user_no"),
						 		   rset.getString("user_name"),
						 		   rset.getString("user_nickname")));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	
		public int insertPhoto(Connection conn, Photo p) {
		// insert문 => 처리된 행수
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPhoto");

		try{ 
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
		
		//게시글조회
		public Photo selectDetail(Connection conn, int pno) {
			Photo p = null;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			//SQL문 쓰자
			String sql = prop.getProperty("selectDetail");  
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, pno);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					p = new Photo(rset.getInt("photo_id"),
					 		   rset.getString("photo_name"),
					 		   rset.getInt("photo_sale"),
					 		   rset.getInt("photo_price"),
					 		   rset.getDate("photo_createdat"),
					 		   rset.getString("photo_src"),
					 		   rset.getString("photo_info"),
					 		   rset.getDate("photo_updateAt"),
					 		   rset.getInt("category_id"),
					 		   rset.getInt("user_no"),
					 		   rset.getString("user_name"),
					 		   rset.getString("user_nickname"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return p;
			
			
		}
		
		//댓글조회
		public ArrayList<Comment> selectComment(Connection conn, int pno) {
			ArrayList<Comment> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectComment");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, pno);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Comment(rset.getInt("comment_id"),
							 		   rset.getString("comment_content"),
							 		   rset.getDate("comment_createdAt"),
							 		   rset.getDate("comment_updatedAt"),
							 		   rset.getInt("user_no"),
							 		   rset.getString("user_name"),
							 		   rset.getString("user_nickname"),
							 		   rset.getInt("photo_id")));
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
