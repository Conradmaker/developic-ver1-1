package com.dia.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dia.user.model.service.UserService;

import com.dia.user.model.vo.User;

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
	
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		String updatePwd = request.getParameter("updatePwd");
		
		User updateUs = new UserService().updatePwdUser(userId, userPwd, updatePwd);
		
		if(updateUs != null) {
	
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateUs);
			session.setAttribute("alertMsg", "비밀번호 변경에 성공했습니다.");
			
			response.sendRedirect(request.getContextPath() + "/myPage.us");
			
		}else {  
			
			request.setAttribute("errorMsg", "비밀번호 변경에 실패했습니다");
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
