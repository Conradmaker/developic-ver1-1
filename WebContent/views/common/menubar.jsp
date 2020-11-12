<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.dia.user.model.vo.User"%>

<%@ page import="com.dia.photo.model.vo.*, java.util.ArrayList" %> 

<%
	User loginUser = (User)session.getAttribute("loginUser");
	// 로그인 요청전 : null
	// 로그인 성공후 : 로그인 성공한 회원정보가 담겨있는 User객체
	
	String alertMsg = (String)session.getAttribute("alertMsg");
	// 요청전 : null
	// 성공후 : alert로 띄워줄 메세지 문구
	
	String contextPath = request.getContextPath(); // "/dia" 
%>    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <title>DEVELOPIC</title>
  </head>
  <body>
    <% if(alertMsg != null){ %>
    <script>
      alert("<%= alertMsg %>");
    </script>

    <% // 알람창 띄워준 후 session에 담긴 메세지 지우기
    session.removeAttribute("alertMsg"); %> <% } %> 

    <div id="app">
      <header class="header--container">
        <div class="header--box">
          <a href="${pageContext.request.contextPath}">
            <img
              src="${pageContext.request.contextPath}/assets/images/logo.png"
              width="250px"
              alt=""
            />
          </a>
          <% if(loginUser == null) { %>
          <div class="header--right">
            <a href="<%= contextPath %>/loginForm.us">LOGIN</a>
            <a href="<%= contextPath %>/enrollForm.us">SIGNUP</a
            ><i @click="setSearchOpen"
              ><i class="fas fa-search" @click=""></i
            ></i>
          </div>
          <% }else { %>
          <div class="header--right">
            <a href="<%= contextPath %>/allpost.pr?userNo=<%= loginUser.getUserNo() %>"
              ><%= loginUser.getUserName() %>님</a
            >
            <a href="<%= contextPath %>/myPage.us">MYPAGE</a
            ><a href="<%= contextPath %>/logout.us">LOGOUT</a
            ><i @click="setSearchOpen"
              ><i class="fas fa-search" @click=""></i
            ></i>
          </div>
          <%} %>
        </div>
      </header>
      <div class="search--container" :class="{searchActive:searchOpen}">
        <form class="search--box" method="POST" action="">
          <label><input type="checkbox" id='saleCheck' name="saleCheck" />판매여부</label>
          <input type="text" placeholder="SEARCH" id='searchInput'/>
          <i class="fas fa-search" onClick='onSearch()'></i
          ><i class="fas fa-times" @click="setSearchOpen"></i>
        </form>
      </div>
      <main class="main--container">
        <ul class="navigation--main">
          <a href="<%= contextPath %>/loadFeed?currentPage=1&category=0">
            <li>PICFEED</li>
          </a>
          <a href="<%= contextPath %>/shopCateList.ph?currentPage=1&category=0">
            <li>PICSHOP</li>
          </a>
          <a href="<%= contextPath %>/about.cs">
            <li>ABOUT</li>
          </a>
        </ul>
<script>
    window.addEventListener("scroll", () => {
  if (window.pageYOffset > 40) {
    document
      .querySelector(".header--box")
      .classList.add("header--down");
  } else {
    document
      .querySelector(".header--box")
      .classList.remove("header--down");
  }
});
const onSearch = ()=>{
  console.log(document.querySelector('#searchInput').value)
  console.log(document.querySelector('#saleCheck').checked)
  document.querySelector('#saleCheck').checked?
  location.href = '/dia/searchShop.sr?text='+ document.querySelector('#searchInput').value + '&currentPage=1&category=0' :
  location.href = '/dia/searchFeed.sr?text='+ document.querySelector('#searchInput').value + '&currentPage=1&category=0'
}

</script>
 
