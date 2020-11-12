package com.dia.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dia.user.model.service.UserService;
import com.dia.user.model.vo.User;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.us")
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
		
		// 1. 전송 파일 용량 제한 : 10Mbyte
		int maxSize = 10 * 1024 * 1024;
							
		// 2. 전달되는 파일이 저장되는 폴더 물리적 경로  // 아바타 저장용 폴더 따로 만들지?
		String savePath = request.getSession().getServletContext().getRealPath("/assets/uploads/"); 
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		//System.out.println(request.getParameter("userName"));
		
		String userId = request.getParameter("userId");	
		String userName = request.getParameter("userName");
//		String userPwd = request.getParameter("userPwd");
		String email = request.getParameter("email");
		String userNickname = request.getParameter("userNickname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String sns = request.getParameter("sns");
		String userInfo = request.getParameter("userInfo"); 
		String userAvatarSrc = request.getParameter("userAvatarSrc");
		
		User u = new User();
		
		u.setUserId(userId);
		u.setUserName(userName);
//		u.setUserPwd(userPwd);
		u.setEmail(email);
		u.setUserNickname(userNickname);
		u.setPhone(phone);
		u.setAddress(address);
		u.setSns(sns);
		u.setUserInfo(userInfo);
//		u.setUserAvatarSrc(userAvatarSrc);
		
		
		
		
		User updateUser = new UserService().updateUser(u);
		
		if(updateUser == null) {
			
			request.setAttribute("errorMsg", "회원정보 수정에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
		}else { 
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateUser); 
			session.setAttribute("alertMsg", "성공적으로 회원정보를 수정했습니다");
			
			response.sendRedirect(request.getContextPath() + "/myPage.us");
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
