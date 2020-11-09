package com.dia.notices.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.notices.model.service.NoticesService;
import com.dia.notices.model.vo.Notices;

/**
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/detail.no")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nno = Integer.parseInt(request.getParameter("nno")); // "7" --> 7
		
		int result = new NoticesService().increaseCount(nno);
		
		if(result > 0) { // 유효한 공지사항 번호일 경우 => 해당공지사항상세조회한 후 => 상세페이지 띄우기
			
			Notices n = new NoticesService().selectNotice(nno);
			
			request.setAttribute("n", n);
			request.getRequestDispatcher("views/cs/cs.jsp").forward(request, response);
			
		}else { // 유효한 공지사항이 아님 => 에러페이지 (에러문구 담아서)
			
			
			
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
