<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.dia.shop.model.vo.Photo"%>
    
    
<%@ page import="com.dia.shop.model.vo.*, java.util.ArrayList" %>

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
    <title>PICSHOP | DEVELOPIC</title>
  </head>
  <body>
  
  
 	<%@ include file="/../views/common/menubar.jsp" %>
  
  	
        <!-- 로그인 시 보여지는 버튼 -->
         <% if(loginUser != null){ %>
        <div class="shop--banner">
         <div class="btn--wrapper">
          <!--  <button class="btn btn-outline-green">PROFILE</button> -->
          <button class="btn btn-green" onclick="location.href='pEnrollForm.ph'">Upload</button> <!--(임시)-->
        </div> 
        </div>
		<% } %>
		
        <h2 class="main--title">PICSHOP</h2>
        <ul class="feed--category">
          <a href="">
            <li>ALL</li>
          </a>
          <a href="">
            <li>ANIMALS</li>
          </a>
          <a href="">
            <li>PEOPLE</li>
          </a>
          <a href="">
            <li>URBAN</li>
          </a>
          <a href="">
            <li>NATURE</li>
          </a>
          <a href="">
            <li>ETC</li>
          </a>
        </ul>
        <div class="shop--container">
		<% for(Photo p: list){ %>        
          <div class="shop--item--wrapper">
            <div class="item-thumb">
              <a href=""><img src="${pageContext.request.contextPath}/assets/uploads/<%= p.getPhotoSrc() %>" alt="" /></a>
            </div>
            <div class="item-info">
              <span><%= p.getPhotoName() %></span>
              <strong><%= p.getPhotoPrice() %></strong>
            </div>
          </div>
         <% } %>
    
<!--         
          <div class="shop--item--wrapper">
            <div class="item-thumb">
              <a href=""
                ><img
                  src="${pageContext.request.contextPath}/assets/images/picfeedimg (1).jpg"
                  alt=""
                  srcset=""
              /></a>
            </div>
            <div class="item-info">
              <span>풀문</span>
              <strong>100,000</strong>
            </div>
          </div>
          <div class="shop--item--wrapper">
            <div class="item-thumb">
              <a href=""
                ><img src="${pageContext.request.contextPath}/assets/images/mirror.jpg" alt="" srcset=""
              /></a>
            </div>
            <div class="item-info">
              <span>풀문</span>
              <strong>100,000</strong>
            </div>
          </div>
          <div class="shop--item--wrapper">
            <div class="item-thumb">
              <a href=""
                ><img src="${pageContext.request.contextPath}/assets/images/picfeedimg (3).jpg" alt=""
              /></a>
            </div>
            <div class="item-info">
              <span>풀문</span>
              <strong>100,000</strong>
            </div>
          </div>
          <div class="shop--item--wrapper">
            <div class="item-thumb">
              <a href=""
                ><img src="${pageContext.request.contextPath}/assets/images/picfeedimg (4).jpg" alt=""
              /></a>
            </div>
            <div class="item-info">
              <span>풀문</span>
              <strong>100,000</strong>
            </div>
          </div>
          <div class="shop--item--wrapper">
            <div class="item-thumb">
              <a href=""
                ><img src="${pageContext.request.contextPath}/assets/images/picfeedimg (5).jpg" alt=""
              /></a>
            </div>
            <div class="item-info">
              <span>풀문</span>
              <strong>100,000</strong>
            </div>
          </div>
          <div class="shop--item--wrapper">
            <div class="item-thumb">
              <a href=""
                ><img src="${pageContext.request.contextPath}/assets/images/picfeedimg (6).jpg" alt=""
              /></a>
            </div>
            <div class="item-info">
              <span>풀문</span>
              <strong>100,000</strong>
            </div>
          </div>
          <div class="shop--item--wrapper">
            <div class="item-thumb">
              <a href=""><img src="${pageContext.request.contextPath}/assets/images/lemon.jpg" alt="" /></a>
            </div>
            <div class="item-info">
              <span>풀문</span>
              <strong>100,000</strong>
            </div>
          </div>
          <div class="shop--item--wrapper">
            <div class="item-thumb">
              <a href=""
                ><img src="${pageContext.request.contextPath}/assets/images/moon.jpg" alt="" srcset=""
              /></a>
            </div>
            <div class="item-info">
              <span>풀문</span>
              <strong>100,000</strong>
            </div>
          </div>
        </div>
        
         --> 
        <!-- 페이징 처리 / 위치 고정시키기 -->
     <!--  <div class="page_nation_container"> -->
        <div class="page_nation">
          <!-- <a class="arrow pprev" href="#"></a> -->
	<% if(pi.getCurrentPage() != 1){ %>	
          <a class="arrow prev" href="/dia/shoplist.ph?currentPage=<%=pi.getCurrentPage()-1%>"></a>
      <% } %>
      <% for(int p=pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
          <a href="/dia/shoplist.ph?currentPage=<%= p %>"><%= p %></a>
      <% } %>  
          <% if(pi.getCurrentPage() != pi.getMaxPage()){ %>
          <a class="arrow next" href="/dia/shoplist.ph?currentPage=<%=pi.getCurrentPage()+1%>"></a>
          	<% } %>
          <!-- <a class="arrow nnext" href="#"></a> -->
        </div>
	</div>
        <a class="top-arrow" href="#">
          <i class="fas fa-arrow-circle-up fa-3x"> </i>
        </a>
      </main>
    </div>
    <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js"></script>
  </body>
</html>
