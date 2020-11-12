package com.dia.cs.model.dao;


import static com.dia.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.dia.cs.model.vo.Faqs;
import com.dia.cs.model.vo.Notices;
import com.dia.cs.model.vo.Qna;
	
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

		public ArrayList<Notices> selectNoticesList(Connection conn){
			ArrayList<Notices> list = new ArrayList<>();
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectNoticesList");
			
			try {

				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
						list.add(new Notices(rset.getString("notice_title"),
											 rset.getString("notice_content")));
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
			
		}
		
		
		
		
		public ArrayList<Faqs> selectFaqsList(Connection conn){
			
			ArrayList<Faqs> list = new ArrayList<>();
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectFaqsList");
			try {
				
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Faqs(rset.getString("faq_title"),
									 rset.getString("faq_content")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
			
		}
		
		
	
		public int insertQna(Connection conn, Qna q) {
			// insert문 => 처리된 행수
			
			int result = 0;
			
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("insertQna");
			
			try {
				pstmt = conn.prepareStatement(sql); 
				
				pstmt.setString(1, q.getQueTitle());
				pstmt.setString(2, q.getQueContent());
				pstmt.setInt(3, q.getQuserNo());
	
				result = pstmt.executeUpdate();
				
				System.out.println("hi");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
			
			
		}
	}

		
		




