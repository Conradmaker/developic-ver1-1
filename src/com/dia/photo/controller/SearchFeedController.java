package com.dia.photo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.photo.model.service.PhotoService;
import com.dia.photo.model.vo.Photo;
import com.dia.shop.model.vo.PageInfo;

/**
 * Servlet implementation class SearchFeedController
 */
@WebServlet("/searchFeed.sr")
public class SearchFeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFeedController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int catagory;
		int listCount;			
		int currentPage;		
		int pageLimit;			
		int boardLimit; 		
		
		int maxPage;			
		int startPage;			
		int endPage;			
		
		
		listCount = new PhotoService().selectFeedListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		catagory = Integer.parseInt(request.getParameter("category"));
		
		pageLimit = 10;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		String text = request.getParameter("text");
		
		ArrayList<Photo> list = new PhotoService().selectSearchFeedList(text, pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/main/picfeed.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
