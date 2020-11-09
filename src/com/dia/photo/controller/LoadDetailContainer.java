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

/**
 * Servlet implementation class LoadDetailContainer
 */
@WebServlet(name = "LoadDetailController", urlPatterns = { "/LoadDetailController" })
public class LoadDetailContainer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDetailContainer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		// 사진 정보 조회 (Photo)
		Photo p = new PhotoService().selectBoard(pno);
		
		// 댓글 정보 조회 (Comment)
		ArrayList<Comment> cm = new PhotoService().selectComment(pno);
		
		request.setAttribute("p", p);
		request.setAttribute("cm", cm);
		
		request.getRequestDispatcher("views/photo/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
