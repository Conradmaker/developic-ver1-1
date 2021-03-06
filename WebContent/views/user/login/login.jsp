<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.dia.user.model.vo.User"%>

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
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>DeveloPic | SIGN</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css" />
	<script src="${pageContext.request.contextPath}/assets/js/mypage/index.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  </head>
  <body>
  
  <div class="container" id="app">    
      <!-- Sign Up -->
      <div class="container__form container--signup">
      <form action="<%= contextPath %>/insert.us" method="post" class="form" id="form1">
          <h2 class="form__title">회원가입</h2>
          <input type="text" placeholder="ID" id="userId" name="userId" class="input" maxlength="12" required/>
          <div class="check_font" id="checkText"></div>
            <input
            type="password"
            placeholder="PASSWORD"
            name="userPwd"
            class="input"
            required
            id='password-input'
            maxlength="15" 
          />
          <input type="password" id='password-check' placeholder="PASSWORD-CHECK" class="input" maxlength="15" required/>
          <input type="text" placeholder="NAME" name="userName" class="input" required/>  
          <input type="email" placeholder="EMAIL" name="email" class="input" required/>

          <span class="password--error" id='password-error'>동일한 비밀번호를 확인해주세요</span>
          <button class="login-btn" type="submit" id="formSubmit" disabled>회원가입</button>
        </form>
      </div>
      <!-- Sign In -->
       <!-- 1. 로그인 전에 보여지는 로그인form -->
      <div class="container__form container--signin">
        <form action="login.us" method="POST" class="form" id="form2">
          <h2 class="form__title">로그인</h2>
          <input type="text" placeholder="id" name="userId" class="input" required/>
          <input
            type="password"
            placeholder="Password"
            name="userPwd"
            class="input"
            required
          />
      <!--  <span @click="setFindIdOpen">아이디가 기억나지 않으세요?</span>  --> 
          <button  onClick="location.href='login.us'" type='submit' class="login-btn">로그인</button>
          <a class="login-btn" href="${pageContext.request.contextPath}"> 홈으로 </a>
        </form>
      </div>

      <!-- Overlay -->
      <div class="container__overlay">
        <div class="overlay">
          <div class="overlay__panel overlay--left">
            <button class="login-btn" onClick='document.querySelector(".container").classList.remove("right-panel-active")' id="signIn">로그인</button>
          </div>
          <div class="overlay__panel overlay--right">
            <button class="login-btn" onClick='document.querySelector(".container").classList.add("right-panel-active")' id="signUp">회원가입</button>
          </div>
        </div>
      </div>
     <!--  
     <!-- 아이디찾기 -->
     <!--  
      <div class="modal--container" :class="{modalActive:findIdModal}">
        <form method='POST' action='dia/findid.us' class="modal--box modal--login">
          <h2 class="form__title">아이디찾기</h2>
          <input type="email" placeholder="EMAIL" name="email" class="input" required />
          <input type="text" placeholder="NAME" name="userName" class="input" required />
          <div>
            <button class="login-btn" @click="setFindIdOpen">닫기</button>
            <button type='submit' class="login-btn">찾기</button>
          </div>
        </form>
      </div>
      -->
      
 </div>  

 <script src="${pageContext.request.contextPath}/assets/js/login/index.js" defer></script>  
 <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js" defer></script>
 </body>
</html>
