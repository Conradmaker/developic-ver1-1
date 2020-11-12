package com.dia.comment.model.service;
import static com.dia.common.JDBCTemplate.getConnection;
import static com.dia.common.JDBCTemplate.close;
import static com.dia.common.JDBCTemplate.rollback;
import static com.dia.common.JDBCTemplate.commit;
import java.sql.Connection;
import java.util.ArrayList;

import com.dia.comment.model.dao.CommentDao;
import com.dia.photo.model.vo.Comment;

public class CommentService {
	
	public int insertComment(Comment cm) {
		Connection conn = getConnection();
		
		int result = new CommentDao().insertComment(conn, cm);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int deleteComment(int cid) {
		Connection conn = getConnection();
		
		int result = new CommentDao().deleteComment(conn, cid);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int fixComment(String content,int cid) {
		Connection conn = getConnection();
		
		int result = new CommentDao().fixComment(conn,content, cid);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int declareComment(String content,int cid,int uid) {
		Connection conn = getConnection();
		
		int result = new CommentDao().declareComment(conn,content, cid,uid);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public ArrayList<Comment> selectCommentList(int userNo){
		
		Connection conn = getConnection();
		
		ArrayList<Comment> list = new CommentDao().selectCommentList(conn, userNo);
		
		close(conn);
		
		return list;
	}
	
	
}
