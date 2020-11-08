package com.dia.photo.model.service;
import static com.dia.common.JDBCTemplate.getConnection;
import static com.dia.common.JDBCTemplate.close;
import java.sql.Connection;
import java.util.ArrayList;

import com.dia.photo.model.dao.PhotoDao;
import com.dia.photo.model.vo.PageInfo;
import com.dia.photo.model.vo.Photo;

public class PhotoService {
	
	public int selectFeedListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new PhotoDao().selectFeedListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Photo> selectFeedList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Photo> list = new PhotoDao().selectFeedList(conn, pi);
		
		close(conn);
		
		return list;
		
	}
}
