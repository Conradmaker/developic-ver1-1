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
       <!-- Sign In -->
       <!-- 1. 로그인 전에 보여지는 로그인form -->
  	   <div class="container__form container--signin">
  	   <!-- Sign Up -->
       <!-- <div class="container__form container--signup"> -->
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
      
      
<script>

//아이디 중복 확인 & 유효성 검사 

// 알파벳 숫자만 입력 가능, 4~12자리 
var idJ = /^[a-z0-9]{4,12}$/;
    
  document.querySelector('#userId').addEventListener('input', async (e)=>{

    try {
      const response = await axios.get('/dia/idCheck.us?checkId='+e.target.value)
      //  console.log(response.data)
        if(response.data==='fail'){// 1 : 아이디가 중복되는 문구
            document.querySelector("#checkText").innerText="사용중인 아이디입니다.";
            document.querySelector("#checkText").style.color = "red";
            document.querySelector("#formSubmit").setAttribute("disabled", true);

			} else {

            if(idJ.test(e.target.value)){
                      // success : 아이디 길이 / 문자열 검사
                      document.querySelector("#checkText").innerText="";
                      document.querySelector("#formSubmit").disabled=false;
                     // console.log(document.querySelector("#formSubmit").disabled);
                    }else if(e.target.value===""){ //
                      document.querySelector("#checkText").innerText="아이디를 입력해주세요.";
                      document.querySelector("#checkText").style.color = "red";
                      document.querySelector("#formSubmit").disabled=true;
                     // console.log(document.querySelector("#formSubmit").disabled);
                    } else {
                      document.querySelector("#checkText").innerText="아이디는 소문자와 숫자 4~12자리만 가능합니다.";
                      document.querySelector("#checkText").style.color = "red";
                      document.querySelector("#formSubmit").disabled=true;
                    // console.log(document.querySelector("#formSubmit").disabled);
                    }
                  }
    } catch (e) {
      console.error(e)
    }



                }
              ); 
	// 비밀번호 유효성 검사 
    document.querySelector('#password-check').addEventListener('input',(e)=>{
      if(document.querySelector('#password-input').value!==e.target.value){
        document.querySelector('#password-error').innerText= '비밀번호를 다시 확인해주세요.'
        document.querySelector('#password-error').style.color='red';
      }else{
        document.querySelector('#password-error').innerText= ''
      }
    })



</script>
<script src="${pageContext.request.contextPath}/assets/js/login/index.js" defer></script>  
  </body>
</html>
