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
		// ȸ������ ��ûó���� controller		
		
		// 1. ��û�� ���ް��� �ѱ��� ���� ��� ����ؼ� ���ڵ� (post����϶�)
		request.setCharacterEncoding("utf-8");
		
		// 2. ��û�� ���ް� �̱� (request�� parameter�������κ���)
		String user_id = request.getParameter("user_id");	
		String user_password = request.getParameter("user_password");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
	
		
		// �⺻�����ڷ� ������ �� ���ʵ��� setter�޼ҵ� �̿��ؼ� ���
		// "�ƽθ� �Ű����� �����ڸ� �̿��ؼ� ���"
		Users u = new Users(user_id, user_password, user_name, user_email);
		
		// 3. ��û�� ó�����ִ� ���� Ŭ������ �޼ҵ� ȣ�� �� ��� �ޱ�
		int result = new Userservice().insertMember(m);
		
		// 4. ��ȯ ���� ����� ������ ����ڰ� ���Ե� ���������� ����
		if(result > 0) { // ȸ������ ���� => �ε��������� ����
			//System.out.println("ȸ������ ����!!");
			
			// session������ alert�� ����� ��ȸ�� �޼��� ���
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "���������� ȸ�������� �ƽ��ϴ�!");			
			
			// redirect ��� (url�� ���û)
			response.sendRedirect(request.getContextPath());
			
			
		}else { // ȸ������ ���� => ���������� ����
			//System.out.println("ȸ������ ����!!");
			
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
