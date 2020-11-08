package com.dia.photo.model.service;

import static com.dia.common.JDBCTemplate.*;

import java.sql.Connection;

import com.dia.photo.model.dao.PhotoDao;
import com.dia.photo.model.vo.Photo;

public class PhotoService {
	
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
