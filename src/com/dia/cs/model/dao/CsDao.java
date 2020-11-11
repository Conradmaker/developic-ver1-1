package com.dia.cs.model.dao;


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

import com.dia.cs.model.vo.Faqs;
import com.dia.cs.model.vo.Notices;
import com.dia.cs.model.vo.Qnas;

	
public class CsDao {

		private Properties prop = new Properties();
		
		public CsDao() {
			
			String fileName = CsDao.class.getResource("/sql/cs/cs-mapper.xml").getPath();
			
			try {
				prop.loadFromXML(new FileInputStream(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			
		}

		public ArrayList<Notices> selectNoticeList(Connection conn){
			ArrayList<Notices> list = new ArrayList<>();
			
			Statement stmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectNoticeList");
			
			try {
				stmt = conn.createStatement();
				
				rset = stmt.executeQuery(sql);
				
				while(rset.next()) {
						list.add(new Notices(rset.getString("notice_title"),
											 rset.getString("notice_content")));
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			
			return list;
			
		}
		
		public int insertNotice(Connection conn, Notices n) {
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertNotice");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, n.getNoticeTitle());
				pstmt.setString(2, n.getNoticeContent());
				pstmt.setInt(3,n.getNoticeId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
			
			
		}
		
		
		public ArrayList<Faqs> selectFaqsList(Connection conn){
			
			ArrayList<Faqs> list = new ArrayList<>();
			
			Statement stmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectFaqList");
			try {
				stmt = conn.createStatement();
				
				rset = stmt.executeQuery(sql);
				
				while(rset.next()) {
					list.add(new Faqs(rset.getString("faq_title")
									 ,rset.getString("faq_content")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			
			return null;
			
		}
		
		public int insertFaqs(Connection conn, Faqs f) {
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertFaqs");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, f.getFaqTitle());
				pstmt.setString(2, f.getFaqContent());
				pstmt.setInt(3, f.getFaqId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
			
			
		}
		
		public ArrayList<Qnas> selectQnasList(Connection conn) {
			
			ArrayList<Qnas> list = new ArrayList<>();
			
			Statement stmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectQnasList");
			
			try {
				stmt = conn.createStatement();

				rset = stmt.executeQuery(sql);
				
				while(rset.next()) {
					list.add(new Qnas(rset.getInt("que_id"),
							          rset.getString("que_title"),
							          rset.getDate("que_createDat"),
							          rset.getDate("aus_createdat"),
							          rset.getInt("quser_no"),
							          rset.getInt("auser_no")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			
			return null;
		}

		public int insertQnas(Connection conn, Qnas q) {
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertQnas");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, q.getQueTitle());
				pstmt.setString(2, q.getQueContent());
				pstmt.setString(3, q.getAusContent());
				pstmt.setInt(4, q.getQueId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
			
			
		}
		
}



