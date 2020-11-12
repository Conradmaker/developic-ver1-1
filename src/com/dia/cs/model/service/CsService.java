package com.dia.cs.model.service;

import static com.dia.common.JDBCTemplate.close;
import static com.dia.common.JDBCTemplate.getConnection;
import static com.dia.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.dia.cs.model.dao.CsDao;
import com.dia.cs.model.vo.Faqs;
import com.dia.cs.model.vo.Notices;
import com.dia.cs.model.vo.Qna;

public class CsService {
	

		
		
		public ArrayList<Notices> selectNoticesList(){
			
			Connection conn = getConnection();
			
			ArrayList<Notices> list = new CsDao().selectNoticesList(conn);
			
			close(conn);
			
			return list;		
		
		}
		 
		
		 public ArrayList<Faqs> selectFaqsList(){
			
			Connection conn = getConnection();
			
			ArrayList<Faqs> list = new CsDao().selectFaqsList(conn);
			
			close(conn);
			
			return list;
		}
		 

		public int insertQna(Qna q) {
		
			Connection conn = getConnection();
			
			int result = new CsDao().insertQna(conn, q);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
		}

		
	}



