<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.dia.user.model.vo.User" %>

<%@ page import="com.dia.cs.model.vo.*, java.util.ArrayList" %>


<%
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("qnaList");
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/common.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/userinfo.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/about.css" />
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
   </head>
  <body>
      
 <%@ include file="../../common/menubar.jsp" %>
 
 
 <% if(list != null && loginUser !=null){ %>
 
        <!-- 여기에 컨텐츠 작성 -->
        <div class="mypage-container">
          <div class="mypage-left">
            <div class="title">
              <h5>MYPAGE</h5>
            </div>
            <!-- 마이페이지 컨텐츠 -->
            <div class="label">
              1:1문의내역
              <em></em>
            </div>
			 
            <div class="faq-and-qna">
              <div class="faq-box">
                <span class="small-title">1:1문의 목록</span>
                <!-- 아이템 -->
                <ul class="qna-list">
                <% for(Qna q: list){ %> 
                  <li>
                    <div class="about-list-title">
                      <h1><%= q.getQueTitle()%></h1>
                      ▼
                    </div>
                    <div class="about-list-detail">
                      <p>
                      <%= q.getQueContent()%>
                      </p>
                      <br>
                       <p>
                      <%= q.getAusContent()%>
                      </p>
                    </div>
                     <% } %>
                  </li>
                </ul>
       	<% } %>        

              </div>

              <div class="qna-box">
                <div class="label">1:1문의<em></em></div>
                <span>
                  원하는 답이 없다면
                  <br />
                  1:1문의를 이용하세요.
                  <p>
                    Open at AM 10:00 ~ PM 17:00
                    <br />
                    Lunch at PM 12:00 ~ 13:00
                  </p>
                  <div>
                    <a href="<%= contextPath %>/about.cs">
                      <button class="btn btn-yellow">고객센터</button>
                    </a>
                  </div>
                </span>
              </div>
            </div>
          </div>
          <div class="mypage-right">
            <!-- 네비게이션바 -->
            <ul class="right-nav">
              <li>
                <a href="<%= contextPath %>/myPage.us">▷개인정보수정</a>
              </li>
              <li>
      <!--   <a href="likelist.html">▷좋아요목록</a>
              </li>
              <li>
                <a href="buylist.html">▷구매내역</a>
              </li>
              <li>
                <a href="cart.html">▷장바구니</a>
              </li>
              <li>
                <a href="applyresult.html">▷작가신청결과 OR</a>
              </li>
              <li>
                <a href="selllist.html">▷판매내역</a>
              </li>   -->
              <li>
                <a href="commentList.html">▷나의 댓글 목록</a>
              </li>
              <li>
                <a href="#" class="nav--active">▷1:1문의내역</a>
              </li>
            </ul>
          </div>
        </div>
        <!-- 여기까지 -->
      </main>
      <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js"></script>
    </div>
  </body>
</html>
