<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.dia.user.model.vo.User"%> <% User loginUser =
(User)session.getAttribute("loginUser"); // > 로그인 요청전 : null // > 로그인
성공후 : 로그인 성공한 회원정보가 담겨있는 User객체 String alertMsg =
(String)session.getAttribute("alertMsg"); // > 서비스 요청전 : null // > 서비스
성공후 : alert로 띄워줄 메세지문구 %>

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
    <div id="app">
      <header class="header--container">
        <div class="header--box">
          <a href="#">
            <img
              src="${pageContext.request.contextPath}/assets/images/logo.png"
              width="250px"
              alt=""
            />
          </a>
          <% if(loginUser == null) { %>
          <div class="header--right">
            <a href="/dia/loginForm.us">LOGIN</a>
            <a href="/dia/enrollForm.us">SIGNUP</a
            ><i @click="setSearchOpen"
              ><i class="fas fa-search" @click=""></i
            ></i>
          </div>
          <% }else { %>
          <div class="header--right">
            <a href="/dia/loginForm.us"><%= loginUser.getUserName() %>님</a>
            <a href="/dia/myPage.us">MYPAGE</a
            ><a href="/dia/logout.us">LOGOUT</a
            ><i @click="setSearchOpen"
              ><i class="fas fa-search" onClick="onSearch"></i
            ></i>
          </div>
          <%} %>
        </div>
      </header>
      <div class="search--container" :class="{searchActive:searchOpen}">
        <form class="search--box" method="POST" action="">
          <label><input type="checkbox" name="saleCheck" />판매여부</label>
          <input type="text" placeholder="SEARCH" />
          <i class="fas fa-search"></i
          ><i class="fas fa-times" @click="setSearchOpen"></i>
        </form>
      </div>
      <main class="main--container">
        <ul class="navigation--main">
          <a href="">
            <li>PICFEED</li>
          </a>
          <a href="/dia/shoplist.ph?currentPage=1">
            <li>PICSHOP</li>
          </a>
          <a href="/dia/about.cs">
            <li>ABOUT</li>
          </a>
        </ul>
      </main>
    </div>
  </body>
</html>
