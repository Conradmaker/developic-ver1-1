package com.dia.profile.model.service;

import static com.dia.common.JDBCTemplate.close;
import static com.dia.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.dia.profile.model.dao.ProfileDao;
import com.dia.profile.model.vo.Picstorys;
import com.dia.user.model.vo.User;

public class ProfileService {
	
	/**
	 * 작가 프로필 페이지의 상단에 띄워줄 해당 작가 정보를 조회해오는 메소드 
	 * @param userNo
	 * @return
	 */
	public ArrayList<User> selectUser(int userNo){
		
		Connection conn = getConnection();
		
		ArrayList<User> userList = new ProfileDao().selectUser(conn, userNo);
		
		close(conn);
		
		return userList;
		
	}
	
	/**
	 * 해당 작가의 picstory 리스트 조회해오는 메소드
	 * @param userNo	어떤 작가의 picstory인지 해당 유저의 userNo
	 * @return
	 */
	public ArrayList<Picstorys> selectPicList(int userNo){
		
		Connection conn = getConnection();
		
		ArrayList<Picstorys> picList = new ProfileDao().selectPicList(conn, userNo);
		
		close(conn);
		
		return picList;
		
	}

}
