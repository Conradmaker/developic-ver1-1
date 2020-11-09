package com.dia.notices.model.dao;

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

import com.dia.notices.model.vo.Notices;

public class NoticesDao {

	private Properties prop = new Properties();
	
	public NoticesDao() {
		
		String fileName = NoticesDao.class.getResource("/sql/notices/notices-mapper.xml").getPath();
		
		
			try {
				prop.loadFromXML(new FileInputStream(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	public ArrayList<Notices> selectNoticeList(Connection conn) {
		
		ArrayList<Notices> list = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				list.add(new Notices(rset.getInt("notice_id"),
						 			 rset.getString("notice_title"),
						 			 rset.getInt("user_no"),
						 			 rset.getDate("notice_createdat"),
						 			 rset.getDate("notice_updateat")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return null;
	}

	public int insertNotice(Connection conn, Notices n) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int increaseCount(Connection conn, int nno) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
			
	}
	
	public Notices selectNotices(Connection conn, int nno) {
		
		Notices n = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notices(rset.getInt("notice_id"),
								rset.getString("notice_title"),
								rset.getString("notice_content"),
								rset.getInt("user_no"),
								rset.getDate("notice_createdat"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}
	
	public int updateNotice(Connection conn, Notices n) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteNotice(Connection conn, int nno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setInt(1, nno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
