package com.dia.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dia.user.model.service.UserService;

import com.dia.user.model.vo.Users;

/**
 * Servlet implementation class MemberUpdatePwdController
 */
@WebServlet("/updatePwd.us")
public class UserUpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdatePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		
		String update_Pwd = request.getParameter("update_Pwd");
		
		Users updateUser = new UserService().updatePwdUsers(user_id, user_password, update_Pwd);
		
		if(updateUser == null) {
			request.setAttribute("errorMsg", "비밀번호 변경 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}else {  
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateUser);
			session.setAttribute("alertMsg", "성공적으로 비밀번호 변경됐습니다.");
			
			response.sendRedirect(request.getContextPath() + "/myPage.me");
			
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
