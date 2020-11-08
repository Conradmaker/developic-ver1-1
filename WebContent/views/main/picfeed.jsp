<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dia.photo.model.vo.*, java.util.ArrayList" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Photo> list = (ArrayList<Photo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <title>PICFEED | DEVELOPIC</title>
  </head>
  <body>
  
    <%@ include file="../common/menubar.jsp" %>

        <!-- 여기에 컨텐츠 작성 -->
        <div class="feed--banner">
          <div class="btn--wrapper">
            <button class="btn btn-blue btn-big">🌊 SHAKE PIC</button>
          </div>
        </div>
        <h2 class="main--title">PICFEED</h2>
        <ul class="feed--category">
          <a href="/dia/loadFeed?currentPage=1&category=0">
            <li>ALL</li>
          </a>
          <a href="/dia/loadFeed?currentPage=1&category=10">
            <li>ANIMALS</li>
          </a>
          <a href="/dia/loadFeed?currentPage=1&category=20">
            <li>PEOPLE</li>
          </a>
          <a href="/dia/loadFeed?currentPage=1&category=30">
            <li>URBAN</li>
          </a>
          <a href="/dia/loadFeed?currentPage=1&category=40">
            <li>NATURE</li>
          </a>
          <a href="/dia/loadFeed?currentPage=1&category=50">
            <li>ETC</li>
          </a>
        </ul>
<% if(list.isEmpty()) { %>
					<tr>
	                    <th colspan="6">조회된 게시글이 없습니다.</th>
	                </tr>
<% } else { %>

        <div class="feed--container">
        
         <% for(Photo p : list) { %>
         
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/uploads/<%= p.getPhotoSrc() %>" alt="" />
            <div class="feed--summary">
              <input hidden value='<%= p.getPhotoId() %>'>
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1><%= p.getPhotoName() %></h1>
              <p>- <%= p.getUserNickname() %></p>
            </div>
          </div>
         
         <% } %>
        </div>
<% } %>
        <a class="top-arrow" href="#">
          <i class="fas fa-arrow-circle-up fa-3x"> </i>
        </a>
      </main>
      <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js"></script>
    </div>
  </body>
</html>
