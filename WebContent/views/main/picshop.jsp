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
    <title>PICSHOP | DEVELOPIC</title>
  </head>
  <body>
    <div id="app">
      <header class="header--container">
        <div class="header--box">
          <a href="#">
            <img src="${pageContext.request.contextPath}/assets/images/logo.png" width="250px" alt="" />
          </a>
          <div class="header--right">
            <a href="${pageContext.request.contextPath}/views/user/login/login.html">LOGIN</a>
            <a href="${pageContext.request.contextPath}/views/user/login/login.html">SIGNUP</a
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
        <div class="shop--banner">
          <!-- <div class="btn--wrapper">
          <button class="btn btn-outline-green">PROFILE</button>
          <button class="btn btn-green">MYPAGE</button>
        </div> -->
        </div>

        <h2 class="main--title">PICSHOP</h2>
        <ul class="feed--category">
          <a href="">
            <li>ALL</li>
          </a>
          <a href="">
            <li>ANIMALS</li>
          </a>
          <a href="">
            <li>PEOPLE</li>
          </a>
          <a href="">
            <li>URBAN</li>
          </a>
          <a href="">
            <li>NATURE</li>
          </a>
          <a href="">
            <li>ETC</li>
          </a>
        </ul>
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
        <!-- 페이징 처리 -->

        <div class="page_nation">
          <!-- <a class="arrow pprev" href="#"></a> -->
          <a class="arrow prev" href="#"></a>
          <a href="#" class="active">1</a>
          <a href="#">2</a>
          <a href="#">3</a>
          <a href="#">4</a>
          <a href="#">5</a>
          <a class="arrow next" href="#"></a>
          <!-- <a class="arrow nnext" href="#"></a> -->
        </div>

        <a class="top-arrow" href="#">
          <i class="fas fa-arrow-circle-up fa-3x"> </i>
        </a>
      </main>
    </div>
    <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js"></script>
  </body>
</html>
