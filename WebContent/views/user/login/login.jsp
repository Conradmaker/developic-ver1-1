<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>DeveloPic | SIGN</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css" />
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  </head>
  <body>
    <div class="container" id="app">
      <!-- Sign Up -->
      <div class="container__form container--signup">
        <form action="${pageContext.request.contextPath}/signup.us" method="POST" class="form" id="form1">
          <h2 class="form__title">회원가입</h2>
          <input type="text" placeholder="ID" name="userId" class="input" />
          <input
            type="password"
            placeholder="PASSWORD"
            name="userPwd"
            class="input"
          />
          <input type="password" placeholder="PASSWORD-CHECK" class="input" />
          <input type="email" placeholder="EMAIL" name="userEmail" class="input" />
          <input type="text" placeholder="NAME" name="userName" class="input" />
          <span class="password--error">동일한 비밀번호를 확인해주세요</span>
          <button class="login-btn">회원가입</button>
        </form>
      </div>

      <!-- Sign In -->
      <div class="container__form container--signin">
        <form action="${pageContext.request.contextPath}/login.us" method="POST" class="form" id="form2">
          <h2 class="form__title">로그인</h2>
          <input type="text" placeholder="id" name="userId" class="input" />
          <input
            type="password"
            placeholder="Password"
            name="userPwd"
            class="input"
          />
          <span @click="setFindIdOpen">아이디가 기억나지 않으세요?</span>
          <button class="login-btn"  type='submit'>로그인</button>
          <a class="login-btn" href="${pageContext.request.contextPath}/views/main/main.html"> 홈으로 </a>
        </form>
      </div>

      <!-- Overlay -->
      <div class="container__overlay">
        <div class="overlay">
          <div class="overlay__panel overlay--left">
            <button class="login-btn" id="signIn">로그인</button>
          </div>
          <div class="overlay__panel overlay--right">
            <button class="login-btn" id="signUp">회원가입</button>
          </div>
        </div>
      </div>

      <!-- 아이디찾기 -->
      <div class="modal--container" :class="{modalActive:findIdModal}">
        <form method='POST' action='${pageContext.request.contextPath}/findid.us' class="modal--box modal--login">
          <h2 class="form__title">아이디찾기</h2>
          <input type="email" placeholder="EMAIL" name="userEmail" class="input" />
          <input type="text" placeholder="NAME" name="userPwd" class="input" />
          <div>
            <button class="login-btn" @click="setFindIdOpen">닫기</button>
            <button type='submit' class="login-btn">찾기</button>
          </div>
        </form>
      </div>
    </div>

    <script src="${pageContext.request.contextPath}/assets/js/login/index.js" defer></script>
    <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js"></script>
  </body>
</html>
