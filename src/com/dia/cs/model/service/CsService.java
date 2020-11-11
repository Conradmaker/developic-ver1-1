package com.dia.cs.model.service;

import static com.dia.common.JDBCTemplate.*;
import static com.dia.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.dia.cs.model.dao.CsDao;
import com.dia.cs.model.vo.Faqs;
import com.dia.cs.model.vo.Notices;
import com.dia.cs.model.vo.Qnas;

public class CsService {
	

		
		
		public ArrayList<Notices> selectNoticeList(){
			
			Connection conn = getConnection();
			
			ArrayList<Notices> list = new CsDao().selectNoticeList(conn);
			
			close(conn);
			
			return list;		
		
		}
		
		public int insertNotice(Notices n) {
		
			Connection conn = getConnection();
			
			int result = new CsDao().insertNotice(conn, n);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
		}
		
		 public ArrayList<Faqs> selectFaqsList(){
			
			Connection conn = getConnection();
			
			ArrayList<Faqs> list = new CsDao().selectFaqsList(conn);
			
			close(conn);
			
			return list;
		}
		 
		 public int insertFaqs(Faqs f) {
				
				Connection conn = getConnection();
				
				int result = new CsDao().insertFaqs(conn, f);
				
				if(result > 0) {
					commit(conn);
				}else {
					rollback(conn);
				}
				
				close(conn);
				
				return result;
				
			}
	

		public ArrayList<Qnas> selectQnasList(){
			
			Connection conn = getConnection();
			
			ArrayList<Qnas> list = new CsDao().selectQnasList(conn);
			
			close(conn);
			
			return list;
		}
		
		public int insertQnas(Qnas q) {
			
			Connection conn = getConnection();
			
			int result = new CsDao().insertQnas(conn, q);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
		}
	}



