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
 * Servlet implementation class ProfilePicPhotoController
 */
@WebServlet("/picphoto.pr")
public class ProfilePicPhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilePicPhotoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// /dia/picphoto.pr?userNo=x  로 넘어온 userNo
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		// /dia/picphoto.pr?picId=x  로 넘어온 picId
		int picId = Integer.parseInt(request.getParameter("picId"));
		// /dia/picphoto.pr?picName=x  로 넘어온 picName
		String picName = request.getParameter("picName");
		
		// profile 페이지 상단의 user정보 조회해오기
		User u = new ProfileService().selectUser(userNo);
		
		// 해당 작가의 모든 사진리스트 조회해오기 (이 작가가 업로드한 사진 총 개수 세주기 위해)
		ArrayList<PhotoInsert> photoList = new ProfileService().selectPhotos(userNo);
		
		// 해당 작가의 모든 픽스토리 리스트 조회해오기 (이 작가의 총 픽스토리의 개수를 세주기 위해)
		ArrayList<Picstorys> picList = new ProfileService().selectPicList(userNo);
		
		// 넘어온 picId에  들어있는 사진리스트만 조회해오기
		ArrayList<PhotoInsert> picPhoto = new ProfileService().selectPicPhoto(userNo, picId);
		
		request.setAttribute("userNo", userNo);
		request.setAttribute("picName", picName);
		request.setAttribute("user", u);
		request.setAttribute("photoList", photoList);
		request.setAttribute("picList", picList);
		request.setAttribute("picPhoto", picPhoto);
		
		request.getRequestDispatcher("views/profile/picPhoto.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
