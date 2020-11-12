package com.dia.profile.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.photo.model.vo.PhotoInsert;
import com.dia.profile.model.service.ProfileService;
import com.dia.profile.model.vo.Picstorys;
import com.dia.user.model.vo.User;

/**
 * Servlet implementation class ProfilePicFormController
 */
@WebServlet("/piclist.pr")
public class ProfilePicFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilePicFormController() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// /dia/piclist.pr?userNo=x  로 넘어온 userNo
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		// profile 페이지 상단의 user정보 조회해오기
		User u = new ProfileService().selectUser(userNo);
		
		// 해당 작가의 모든 사진리스트 조회해오기 (사진 총 개수 세어주기 위해 얘도 가져옴)
		ArrayList<PhotoInsert> photoList = new ProfileService().selectPhotos(userNo);

		// 해당 작가의 모든 픽스토리 리스트 조회해오기
		ArrayList<Picstorys> picList = new ProfileService().selectPicList(userNo);
		
		// 각 픽스토리에 대한 썸네일 src 조회해오기
		for(int i=0; i<picList.size(); i++) {
			Picstorys src = new ProfileService().selectPicThumbnail(picList.get(i).getPicstoryId());
			if(src != null) {
				picList.get(i).setPhotoId(src.getPhotoId());
				picList.get(i).setPhotoSrc(src.getPhotoSrc());
			}else {
				picList.get(i).setPhotoSrc("picstoryEmpty.jpg");
			}
		}
		
		System.out.println(picList);
		
		request.setAttribute("user", u);
		request.setAttribute("photoList", photoList);
		request.setAttribute("picList", picList);
		
		request.getRequestDispatcher("views/profile/picstoryList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
