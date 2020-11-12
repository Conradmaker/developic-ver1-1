<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>DeveloPic | SIGN</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css" />
    <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js"></script>
    
  <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    
  </head>
  <body>
  
  
 <%@ include file="../../common/menubar.jsp" %>  
  
 	<div class="container" id="app">
    
      <!-- Sign In -->
      
       <!-- 1. 로그인 전에 보여지는 로그인form -->
  <div class="container__form container--signin">
  	   <!-- Sign Up -->
       <!-- <div class="container__form container--signup"> -->
        <form action="/dia/insert.us" method="post" class="form" id="form1">
          <h2 class="form__title">회원가입</h2>
          <input type="text" placeholder="ID" id="userId" name="userId" class="input" maxlength="12" required/>
          <div class="check_font" id="checkText"></div>
       
            <input
            type="password"
            placeholder="PASSWORD"
            name="userPwd"
            class="input"
            required
            maxlength="15" 
          />
          <input type="password" placeholder="PASSWORD-CHECK" class="input" maxlength="15" required/>
          <input type="text" placeholder="NAME" name="userName" class="input" required/>  
          <input type="email" placeholder="EMAIL" name="email" class="input" required/>

          <span class="password--error">동일한 비밀번호를 확인해주세요</span>
          <button class="login-btn" type="submit" id="formSubmit" disabled>회원가입</button>
        </form>
      </div>
      
      
<script>

// 아이디 중복 확인 & 유효성 검사 

// 알파벳 숫자만 입력 가능, 4~12자리 
var idJ = /^[a-z0-9]{4,12}$/;

// 아이디 유효성 검사
	$("#userId").blur(function() {

		var userId = $('#userId').val();

		
		$.ajax({
			url:"/dia/idCheck.us",
			type:"get",	
			success: function(result) {
				console.log("fail = 중복o / success = 중복x : "+ data);							
				
				if (result == "fail") {
						// fail : 아이디가 중복되는 문구
						$("#checkText").text("중복된 아이디입니다.");
						$("#checkText").css("color", "red");
						$("#formSubmit").attr("disabled", true);
					} else {
						
						if(idJ.test(userId)){
							// success : 아이디 길이 / 문자열 검사
							$("#checkText").text("");
							$("#formSubmit").attr("disabled", false);
						
						} else if(userId == ""){
							
							$('#checkText').text('아이디를 입력해주세요.');
							$('#checkText').css('color', 'red');
							$("#formSubmit").attr("disabled", true);				
							
						} else {
							
							$('#checkText').text("아이디는 소문자와 숫자 4~12자리만 가능합니다.");
							$('#checkText').css('color', 'red');
							$("#formSubmit").attr("disabled", true);
						}
						
					}
				}, error : function() {
						console.log("실패");
				}
		});
	});
</script>
<script src="${pageContext.request.contextPath}/assets/js/login/index.js" defer></script>  
  </body>
</html>
