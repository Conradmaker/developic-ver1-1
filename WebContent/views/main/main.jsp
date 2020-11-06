<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>DEVELOPIC</title>
  </head>
  <body>
    <div id="app">
      <header class="header--container">
        <div class="header--box">
          <a href="#">
            <img src="${pageContext.request.contextPath}/assets/images/logo.png" width="250px" alt="" />
          </a>
          <div class="header--right">
            <a href="../user/login/login.html">LOGIN</a>
            <a href="../user/login/login.html">SIGNUP</a
            ><i @click="setSearchOpen"
              ><i class="fas fa-search" @click=""></i
            ></i>
          </div>
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
          <a href="">
            <li>PICSHOP</li>
          </a>
          <a href="">
            <li>ABOUT</li>
          </a>
        </ul>

        <!-- 여기에 컨텐츠 작성 -->
        <div class="main--banner">
          <div class="btn--wrapper">
            <button class="btn btn-outline-pink">LOG IN</button>
            <button class="btn btn-pink">SIGN UP</button>
          </div>
        </div>
        <!-- PICFEED -->
        <h2 class="main--title">PICFEED</h2>
        <div class="feed--container">
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/city.jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/picfeedimg (1).jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/brown.jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/picfeedimg (3).jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/picfeedimg (4).jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/picfeedimg (5).png" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/film.jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/cat.jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/cherry.jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/picfeedimg (6).jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/lemon.jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/pizza.jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/moon.jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/mirror.jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
          <div class="feed--item">
            <img src="${pageContext.request.contextPath}/assets/images/sunset.jpg" alt="" />
            <div class="feed--summary">
              <i class="fa fa-fw fa-heart fa-lg"></i>
              <h1>작품명</h1>
              <p>- 작가명</p>
            </div>
          </div>
        </div>

        <div class="more">
          <a href=""><button class="btn btn-outline-green">MORE</button> </a>
        </div>

        <div class="ad--banner">
          <a href="">
            <img src="${pageContext.request.contextPath}/assets/images/adbanner.jpg" alt="" />
          </a>
        </div>

        <!-- PICSHOP -->
        <h2 class="main--title">PICSHOP</h2>
        <div class="shop--container">
          <div class="shop--item--wrapper">
            <div class="item-thumb">
              <a href=""><img src="${pageContext.request.contextPath}/assets/images/city.jpg" alt="" /></a>
            </div>
            <div class="item-info">
              <span>풀문</span>
              <strong>100,000</strong>
            </div>
          </div>
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

        <div class="more">
          <a href=""><button class="btn btn-outline-green">MORE</button> </a>
        </div>

        <a class="top-arrow" href="#">
          <i class="fas fa-arrow-circle-up fa-3x"> </i>
        </a>
      </main>
      <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js"></script>
    </div>
  </body>
</html>
