package com.dia.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dia.user.model.service.UserService;
import com.dia.user.model.vo.Users;;



/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 요청처리용 controller		
		
		// 1. 요청시 전달값에 한글이 있을 경우 대비해서 인코딩 (post방식일때)
		request.setCharacterEncoding("utf-8");
		
		// 2. 요청시 전달값 뽑기 (request의 parameter영역으로부터)
		String user_id = request.getParameter("user_id");	
		String user_password = request.getParameter("user_password");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
	
		
		// 기본생성자로 생성한 후 각필드의 setter메소드 이용해서 담기
		// "아싸리 매개변수 생성자를 이용해서 담기"
		Users u = new Users(user_id, user_password, user_name, user_email);
		
		// 3. 요청을 처리해주는 서비스 클래스의 메소드 호출 후 결과 받기
		int result = new Userservice().insertMember(m);
		
		// 4. 반환 받은 결과를 가지고 사용자가 보게될 응답페이지 지정
		if(result > 0) { // 회원가입 성공 => 인덱스페이지 띄우기
			//System.out.println("회원가입 성공!!");
			
			// session영역에 alert로 띄워줄 일회성 메세지 담기
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원가입이 됐습니다!");			
			
			// redirect 방식 (url을 재요청)
			response.sendRedirect(request.getContextPath());
			
			
		}else { // 회원가입 실패 => 에러페이지 띄우기
			//System.out.println("회원가입 실패!!");
			
			request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
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
