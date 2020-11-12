package com.dia.photo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.photo.model.service.PhotoService;
import com.dia.photo.model.vo.Comment;
import com.dia.photo.model.vo.Photo;
import com.dia.photo.model.vo.Picstory;
import com.google.gson.Gson;

/**
 * Servlet implementation class LoadPicstory
 */
@WebServlet("/loadpicstory.ph")
public class LoadPicstory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadPicstory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uno = Integer.parseInt(request.getParameter("uno"));
		
		// 사진 정보 조회 (Photo)
		Picstory p = new PhotoService().selectPicstory(uno);
		
		
		request.setAttribute("p", p);
		
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		gson.toJson(p, response.getWriter());
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
