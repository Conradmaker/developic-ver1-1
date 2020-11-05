package com.dia.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dia.user.model.service.UserService;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/delete.us")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		
		
		int result = new UserService().deleteUsers(user_id, user_password);
		
		
		if(result > 0) {
		
			HttpSession session = request.getSession();
			
			session.removeAttribute("loginUser");
			
			session.setAttribute("alertMsg", "성공적으로 회원탈퇴 되었습니다.");
			
			response.sendRedirect(request.getContextPath());
			
		}else {
		
			request.setAttribute("errorMsg", "회원탈퇴에 실패했습니다.");
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
