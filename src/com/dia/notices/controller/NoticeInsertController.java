package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String noticeWriter = request.getParameter("userNo"); // "1"
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
		Notice n = new Notice();
		n.setNoticeWriter(noticeWriter);
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		
		int result = new NoticeService().insertNotice(n);
		
		if(result > 0) { // 성공 => /list.no  => 공지사항리스트페이지
			
			request.getSession().setAttribute("alertMsg", "성공적으로 공지사항 등록됐습니다!!");
			
			// forwarding방식으로 띄울경우?
			// => request 객체에 ArrayList를 담지 않아서 NullPointerException뜰꺼임 
			/*
			RequestDispatcher view = request.getRequestDispatcher("views/notice/noticeListView.jsp");
			view.forward(request, response);
			*/
			
			// redirect방식으로 url 재요청 하면됨!!
			response.sendRedirect(request.getContextPath() + "/list.no");
			
			
		}else { // 실패 => 에러페이지로 포워딩 (에러문구 담아서)
			
			request.setAttribute("errorMsg", "공지사항 작성 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
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
