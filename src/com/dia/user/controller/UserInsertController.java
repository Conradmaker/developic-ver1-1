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
@WebServlet("/signup.us")
public class UserInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		String user_id = request.getParameter("user_id");	
		String user_password = request.getParameter("user_password");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
	
		Users u = new Users(user_id, user_password, user_name, user_email);
		
		int result = new UserService().insertUsers(u);
				
		if(result > 0) { 
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "���������� ȸ�������� �ƽ��ϴ�!");			
			
			
			response.sendRedirect(request.getContextPath());
			
			
		}else { 
			
			request.setAttribute("errorMsg", "ȸ�����Կ� �����߽��ϴ�.");
			
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
