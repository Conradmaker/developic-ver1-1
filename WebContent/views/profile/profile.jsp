<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.dia.user.model.vo.User"%>

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
      href="${pageContext.request.contextPath}/assets/css/profile.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/main.css"
    />

    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  </head>
  <body>
    <%@ include file="../common/menubar.jsp" %>

    <div class="pro--container">
      <div class="pro--title">
        <!-- profile 로고 들어가는 영역 -->
        <div class="title">
          <h5>PROFILE</h5>
        </div>
      </div>
      <div class="pro--profile">
        <div class="profile-L">
          <div class="pro--userImgWrapper">
            <img
              id="pro--userImg"
              class="pro--userImgY"
              src="${pageContext.request.contextPath}/assets/images/cat.jpg"
            />
          </div>
          <h2>User</h2>
          <p>email@gmail.com</p>
          <ul>
            <li id="pro--sns-in"><i class="fab fa-instagram"></i></li>
            <li id="pro--sns-fa"><i class="fab fa-facebook-f"></i></li>
            <li id="pro--sns-tw"><i class="fab fa-twitter"></i></li>
          </ul>
        </div>
        <div class="profile-R">
          <h2>ABOUT ARTIST</h2>
          <div class="pro-gap"></div>
          <ul class="pro--ulNum">
            <li>144</li>
            <li>14</li>
            <li>342</li>
          </ul>
          <ul class="pro--ulName">
            <li>Pictures</li>
            <li>PicStory</li>
            <li>Liked</li>
          </ul>
          <div class="pro-gap"></div>
          <span>
            소금이라 대고, 일월과 것이다. 싶이 밥을 사라지지 노년에게서
            위하여서. 듣기만 주며, 하였으며, 그들에게 인생에 불러 있는가? 길지
            되려니와, 생의 가슴에 힘있다. 천자만홍이 물방아 것은 있으랴?소금이라
            대고, 일월과 것이다.그들에게 인생에 불러 있는가? 길지 되려니와, 생의
            가슴에 힘있다. 천자만홍이 물방아 것은 있으랴?소금이라 대고, 일월과
            것이다.
          </span>
        </div>
      </div>
      <div class="pro--btnWrapper">
        <!-- 작가 본인의 프로필일때 : 작품등록버튼 -->
        <!-- <button class="btn btn-yellow" onclick="location.href='${pageContext.request.contextPath}/views/profile/edit.jsp';">작품등록</button> -->
        <button
          class="btn btn-yellow"
          onclick="location.href='${pageContext.request.contextPath}/edit.ph';"
        >
          작품등록
        </button>
        <!-- 타유저일때 : 파도타기버튼 -->
        <!-- <button class="btn btn--wave">🌊</button> -->
      </div>
      <div class="pro-gap"></div>
      <div class="pro-gap"></div>

      <!-- ALLPOST -->
      <!-- PICSTORY -->
    </div>

    <script
      src="${pageContext.request.contextPath}/assets/js/profile.js"
      defer
    ></script>
  </body>
</html>
