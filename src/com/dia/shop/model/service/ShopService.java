package com.dia.shop.model.service;

import static com.dia.common.JDBCTemplate.close;
import static com.dia.common.JDBCTemplate.commit;
import static com.dia.common.JDBCTemplate.getConnection;
import static com.dia.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.dia.photo.model.dao.PhotoDao;
import com.dia.shop.model.dao.ShopDao;
import com.dia.shop.model.vo.PageInfo;
import com.dia.shop.model.vo.Photo;

public class ShopService {

	
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new ShopDao().selectListcount(conn);
		
		close(conn);
		
		return listCount;

	}
	
	
	public ArrayList<Photo> selectPhotoList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Photo> list = new ShopDao().selectPhotoList(conn, pi);
		
		close(conn);
		
		return list;
	}

	
	public ArrayList<Photo> selectShopCateList(PageInfo pi,int category){
		
		Connection conn = getConnection();
		
		ArrayList<Photo> list = new ShopDao().selectShopCateList(conn, pi, category);
		
		close(conn);
		
		return list;
		
	}

}
