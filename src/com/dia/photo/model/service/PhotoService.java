package com.dia.photo.model.service;
import static com.dia.common.JDBCTemplate.close;
import static com.dia.common.JDBCTemplate.getConnection;
import static com.dia.common.JDBCTemplate.commit;
import static com.dia.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.dia.comment.model.dao.CommentDao;
import com.dia.photo.model.dao.PhotoDao;
import com.dia.shop.model.vo.PageInfo;
import com.dia.photo.model.vo.Comment;
import com.dia.photo.model.vo.Photo;
import com.dia.photo.model.vo.PhotoInsert;
import com.dia.photo.model.vo.Picstory;

public class PhotoService {

	public int selectFeedListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new PhotoDao().selectFeedListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Photo> selectFeedList(PageInfo pi,int catagory){
		
		Connection conn = getConnection();
		
		ArrayList<Photo> list = new PhotoDao().selectFeedList(conn, pi,catagory);
		
		close(conn);
		
		return list;
		
	}

	public int insertPhoto(PhotoInsert p) {
		
		Connection conn = getConnection();
		
		int result = new PhotoDao().insertPhoto(conn, p);
		
		System.out.println("55555555555");
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
		
//		디테일조회
		public Photo selectBoard(int pno) {
			
			Connection conn = getConnection();
			Photo p = new PhotoDao().selectDetail(conn, pno);
			close(conn);
			return p;
		}
//		댓글조회
		public ArrayList<Comment> selectComment(int pno) {
			Connection conn = getConnection();
			ArrayList<Comment> cm = new PhotoDao().selectComment(conn, pno);
			close(conn);
			return cm;
		}
//		작품신고
		public int declarePhoto(String content,int pid,int uid) {
			Connection conn = getConnection();
			
			int result = new PhotoDao().declarePhoto(conn,content, pid,uid);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
		}
//		작품삭제
		public int deletePhoto(int pid) {
			Connection conn = getConnection();
			
			int result = new PhotoDao().deletePhoto(conn, pid);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
		}
//		좋아요
		public int likePhoto(int pid,int uno) {
			Connection conn = getConnection();
			
			int result = new PhotoDao().likePhoto(conn, pid,uno);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
		}
		
//		픽스토리조회
		public ArrayList<Picstory> selectPicstory(int uno) {
			Connection conn = getConnection();
			ArrayList<Picstory> p = new PhotoDao().selectPicstory(conn, uno);
			close(conn);
			return p;
		}
		public int makePicstory(String pName,int uno) {
			Connection conn = getConnection();
			
			int result = new PhotoDao().makePicstory(conn,pName, uno);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
		}
		//생성된 작품 조회
		public int selectMakedPhoto(PhotoInsert p) {
			Connection conn = getConnection();
			int pid = new PhotoDao().selectMakedPhoto(conn, p);
			close(conn);
			return pid;
		}
		//픽스토리에 작품
		public int insertPicstory(int pid,int picNo) {
			Connection conn = getConnection();
			
			int result = new PhotoDao().insertPicstory(conn,pid, picNo);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
		}
		
}
