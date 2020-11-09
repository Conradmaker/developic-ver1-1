package com.dia.notices.model.service;

import static com.dia.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.dia.notices.model.dao.NoticesDao;
import com.dia.notices.model.vo.Notices;

public class NoticesService {
	
	/**
	 * 1. 공지사항 전체조회용 서비스
	 * @return		조회된 공지사항 리스트
	 */
	public ArrayList<Notices> selectNoticeList(){
		
		Connection conn = getConnection();
		
		ArrayList<Notices> list = new NoticesDao().selectNoticeList(conn);
		
		close(conn);
		
		return list;		
	}
	
	/**
	 * 2. 공지사항 작성용 서비스
	 * @param n		사용자가 입력한 제목,내용, 로그인한사용자번호가 담긴 Notice 객체
	 * @return		처리된 행 수
	 */
	public int insertNotice(Notices n) {
		
		Connection conn = getConnection();
		
		int result = new NoticesDao().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	/**
	 * 3_1. 상세조회요청한 공지사항 조회수 증가용 서비스
	 * @param nno		상세조회 요청한 해당 공지사항 글 번호
	 * @return			처리된 행 수
	 */
	public int increaseCount(int nno) {
		Connection conn = getConnection();
		
		int result = new NoticesDao().increaseCount(conn, nno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Notices selectNotice(int nno) {
		Connection conn = getConnection();
		
		Notices n = new NoticesDao().selectNotices(conn, nno);
		
		close(conn);
		
		return n;
	}
	
	public int updateNotice(Notices n) {
		Connection conn = getConnection();
		
		int result = new NoticesDao().updateNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int deleteNotice(int nno) {
		Connection conn = getConnection();
		
		int result = new NoticesDao().deleteNotice(conn, nno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
}




