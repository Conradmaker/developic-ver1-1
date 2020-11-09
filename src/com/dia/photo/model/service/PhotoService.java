package com.dia.photo.model.service;
import static com.dia.common.JDBCTemplate.getConnection;
import static com.dia.common.JDBCTemplate.close;
import java.sql.Connection;
import java.util.ArrayList;
import com.dia.photo.model.dao.PhotoDao;
import com.dia.shop.model.vo.PageInfo;
import com.dia.photo.model.vo.Photo;

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

		public int insertPhoto(Photo p) {
		
		Connection conn = getConnection();
		
		int result = new PhotoDao().insertPhoto(conn, p);
		
		System.out.println("22222222222");
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

}
