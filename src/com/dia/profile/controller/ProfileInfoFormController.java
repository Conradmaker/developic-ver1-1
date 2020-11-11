package com.dia.profile.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dia.profile.model.service.ProfileService;
import com.dia.user.model.vo.User;

/**
 * Servlet implementation class ProfileInfoFormController
 */
@WebServlet("/userInfo.pr")
public class ProfileInfoFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileInfoFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userNo = Integer.parseInt(request.getParameter(""));
		
		ArrayList<User> userList = new ProfileService().selectUser(userNo);
		
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("views/profile/profile.jsp").forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
