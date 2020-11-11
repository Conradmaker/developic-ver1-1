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
      href="${pageContext.request.contextPath}/assets/css/main.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
    />
  </head>
  <body>
    <%@ include file="profile.jsp" %>

    <div class="pro--tab">
      <ul>
        <li>
          <a
            href="#"
            id="pro--allBtn"
            class="pro--tab-select"
            <!-- onclick="location.href='${pageContext.request.contextPath}/allpost.pr';" -->
            >ALL POST</a
          >
        </li>
        <li>
          <a
            href="#"
            id="pro--picBtn"
            class=""
            onclick="location.href='${pageContext.request.contextPath}/piclist.pr';"
            >PICSTORY</a
          >
        </li>
      </ul>
    </div>
    <div class="pro-gap"></div>

    <!-- ALL POST -->
    <div class="pro--allpost">
      <div class="feed--container">
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/city.jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/picfeedimg (1).jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/brown.jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/picfeedimg (3).jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/picfeedimg (4).jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/picfeedimg (5).png"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/film.jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/cat.jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/cherry.jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/picfeedimg (6).jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/lemon.jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/pizza.jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/moon.jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/mirror.jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
        <div class="feed--item">
          <img
            src="${pageContext.request.contextPath}/assets/images/sunset.jpg"
            alt=""
          />
          <div class="feed--summary">
            <i class="fa fa-fw fa-heart fa-lg"></i>
            <h1>작품명</h1>
            <p>- 작가명</p>
          </div>
        </div>
      </div>

      <a class="top-arrow" href="#">
        <i class="fas fa-arrow-circle-up fa-3x"> </i>
      </a>
    </div>
    
  </main>
</div>

    <script
      src="${pageContext.request.contextPath}/assets/js/profile.js"
      defer
    ></script>
  </body>
</html>
