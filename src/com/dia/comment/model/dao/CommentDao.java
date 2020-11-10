package com.dia.comment.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.dia.photo.model.vo.Comment;
import static com.dia.common.JDBCTemplate.getConnection;
import static com.dia.common.JDBCTemplate.close;
import static com.dia.common.JDBCTemplate.rollback;
import static com.dia.common.JDBCTemplate.commit;

public class CommentDao {
	private Properties prop = new Properties();
	
	public CommentDao() {
		try {
			prop.loadFromXML(new FileInputStream(CommentDao.class.getResource("/sql/comment/comment-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertComment(Connection conn, Comment cm) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cm.getCommentContent());
			pstmt.setInt(2, cm.getUserNo());
			pstmt.setInt(3, cm.getPhotoId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteComment(Connection conn, int cid) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int fixComment(Connection conn,String content, int cid) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("fixComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, content);
			pstmt.setInt(2, cid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
