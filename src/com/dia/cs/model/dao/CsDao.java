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

		
		
}



