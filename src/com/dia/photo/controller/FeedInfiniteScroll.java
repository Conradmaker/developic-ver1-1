package com.dia.photo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.photo.model.service.PhotoService;
import com.dia.photo.model.vo.PageInfo;
import com.dia.photo.model.vo.Photo;
import com.google.gson.Gson;

/**
 * Servlet implementation class FeedInfiniteScroll
 */
@WebServlet("/FeedAxios")
public class FeedInfiniteScroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedInfiniteScroll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int category;
		int listCount;			
		int currentPage;		
		int pageLimit;			
		int boardLimit; 		
		
		int maxPage;			
		int startPage;			
		int endPage;			
		
		
		listCount = new PhotoService().selectFeedListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		category = Integer.parseInt(request.getParameter("category"));
		System.out.println(category);
		System.out.println(currentPage);
		pageLimit = 10;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Photo> list = new PhotoService().selectFeedList(pi,category);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		gson.toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
