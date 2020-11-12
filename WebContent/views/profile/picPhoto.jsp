<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.dia.photo.model.vo.PhotoInsert" %>
<%
	String picName = (String)request.getAttribute("picName");
	ArrayList<PhotoInsert> picPhoto = (ArrayList<PhotoInsert>)request.getAttribute("picPhoto");
%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>PROFILE | DEVELOPIC</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/index.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/common.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/main.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
    />
  </head>
  <body>
    <%@ include file="profile.jsp" %>

    <div class="pro--tab">
      <ul>
        <li>
          <a
            href="#"
            id="pro--allBtn"
            class=""
            onclick="location.href='${pageContext.request.contextPath}/allpost.pr?userNo=<%= u.getUserNo() %>';"
            >ALL POST</a
          > 
        </li>
        <li>
          <a
            href="#"
            id="pro--picBtn"
            class="pro--tab-select"
            onclick="location.href='${pageContext.request.contextPath}/piclist.pr?userNo=<%= u.getUserNo() %>';"
            >PICSTORY</a
          >
        </li>
      </ul>
    </div>
    <div class="pro-gap"></div>
    <h2 id="pro-picphoto-name"><%= picName %></h2>
    <div class="pro-gap"></div>

    <!-- ALL POST -->
    <div class="pro--allpost">
      <div class="feed--container">
      
        <% for(PhotoInsert p : picPhoto) { %>
	        <div class="feed--item">
	          <img
	            src="${pageContext.request.contextPath}/assets/uploads/<%= p.getPhotoSrc() %>"
	            alt=""
	          />
	          <div class="feed--summary"
	            onclick="location.href='${pageContext.request.contextPath}/LoadDetailController?pno=<%= p.getPhotoId() %>'">
	            <i class="fa fa-fw fa-heart fa-lg"></i>
	            <h1><%= p.getPhotoName() %></h1>
	          </div>
	        </div>
        <% } %>
        
      </div>

      <a class="top-arrow" href="#">
        <i class="fas fa-arrow-circle-up fa-3x"> </i>
      </a>
    </div>
    
  </main>
</div>

    <script
      src="${pageContext.request.contextPath}/assets/js/profile.js"
      defer
    ></script>
  </body>
</html>
