package com.dia.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.comment.model.service.CommentService;

/**
 * Servlet implementation class CommentDeclare
 */
@WebServlet("/declare.cm")
public class CommentDeclare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeclare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		int cid = Integer.parseInt(request.getParameter("cid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		int result = new CommentService().declareComment(content,cid,uid);
		
		if(result > 0) {
			response.getWriter().print("신고가 접수되었습니다.");
		}else {
			response.getWriter().print("이미 신고하셨습니다.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
