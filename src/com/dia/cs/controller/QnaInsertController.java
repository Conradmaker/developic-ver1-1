package com.dia.cs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.cs.model.service.CsService;
import com.dia.cs.model.vo.Qna;

/**
 * Servlet implementation class QnaInsertController
 */
@WebServlet("/insert.qn")
public class QnaInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");

		String queTitle = request.getParameter("queTitle");
		String queContent = request.getParameter("queContent");
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		Qna q = new Qna();
		q.setQueTitle(queTitle);
		q.setQueContent(queContent);
		q.setQuserNo(userNo);
		
		System.out.println(q);
		
		
		int result = new CsService().insertQna(q);
		
		if(result > 0) { // 성공 => /about.cs => about 페이지
			
			request.getSession().setAttribute("alertMsg", "1:1문의 등록 완료되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/about.cs");
			
			
		}else { // 실패 => 에러페이지
			System.out.println("실패");
			
			request.setAttribute("errorMsg", "1:1문의 작성 실패했습니다.");
			request.getRequestDispatcher("Views/common/errorPage.jsp").forward(request, response);
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
