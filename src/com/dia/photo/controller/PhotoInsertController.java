package com.dia.photo.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.dia.photo.model.service.PhotoService;
import com.dia.photo.model.vo.PhotoInsert;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class PhotoInsertFormController
 */
@WebServlet("/insert.ph")
public class PhotoInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 20 * 1024 * 1024;
			
			ServletContext context = request.getSession().getServletContext();
			String realPath = context.getRealPath("/assets/uploads");
			
			MultipartRequest multiRequest = new MultipartRequest(request, realPath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			String photoName = multiRequest.getParameter("photoName");
			String photoSale = multiRequest.getParameter("photoSale");
			String photoPrice = multiRequest.getParameter("photoPrice");
			String photoSrc = multiRequest.getParameter("photoSrc");
			String photoInfo = multiRequest.getParameter("photoInfo");
			String userNo = multiRequest.getParameter("userNo");
			String categoryId = multiRequest.getParameter("categoryId");
			int picNo = Integer.parseInt(multiRequest.getParameter("picNo"));
			
			PhotoInsert p = new PhotoInsert();
			p.setPhotoName(photoName);
			p.setPhotoSale(Integer.parseInt(photoSale));
			p.setPhotoPrice(Integer.parseInt(photoPrice));
			p.setPhotoSrc(photoSrc);
			p.setPhotoInfo(photoInfo);
			p.setUserNo(Integer.parseInt(userNo));
			p.setCategoryId(Integer.parseInt(categoryId));
			
			System.out.println(p);
			
			int result = new PhotoService().insertPhoto(p);
			//생성된 작품 아이디 불러오기
			int pid =  new PhotoService().selectMakedPhoto(p);
			//작품이랑 그거 넣기
			int resultPic = new PhotoService().insertPicstory(pid,picNo);
			
			if(resultPic > 0) { // 성공 => profile 페이지 요청
				
				request.getSession().setAttribute("alertMsg", "작품이 성공적으로 등록되었습니다!!!");
				response.sendRedirect(request.getContextPath());
				
			}else { // 실패 => 업로드된 파일 찾아 삭제 => 에러문구 담은 후 에러페이지로 포워딩
				
				request.setAttribute("errorMsg", "작품 등록 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
			}
			
		}else {
			System.out.println("안돼!!");
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
