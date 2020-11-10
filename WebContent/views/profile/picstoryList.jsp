<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.dia.user.model.vo.User"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>PROFILE | DEVELOPIC</title>
  </head>
  <body>
    <%@ include file="profile.jsp" %>

    <div class="pro--tab">
      <ul>
        <li>
          <a
            href="#"
            id="pro--allBtn"
            class=""
            onclick="location.href='${pageContext.request.contextPath}/allpost.pr';"
            >ALL POST</a
          >
        </li>
        <li>
          <a
            href="#"
            id="pro--picBtn"
            class="pro--tab-select"
            onclick="location.href='${pageContext.request.contextPath}/piclist.pr';"
            >PICSTORY</a
          >
        </li>
      </ul>
    </div>
    <div class="pro-gap"></div>

    <!-- PICSTORY LIST -->
    <div class="pro--btnWrapper">
      <i id="pro-changeBtn">🔄</i>
    </div>
    <div class="pro-gap"></div>
    <div id="pro--picstory" class="pro--picstory pro--twoC">
      <div class="pro--item">
        <img
          src="${pageContext.request.contextPath}/assets/images/cherry.jpg"
        />
        <p>2020-11-06</p>
        <span>Seriesssssssssss</span>
      </div>
      <div class="pro--item">
        <img src="${pageContext.request.contextPath}/assets/images/film.jpg" />
        <p>2020-11-06</p>
        <span>Series</span>
      </div>
      <div class="pro--item">
        <img src="${pageContext.request.contextPath}/assets/images/moon.jpg" />
        <p>2020-11-06</p>
        <span>Series</span>
      </div>
      <div class="pro--item">
        <img src="${pageContext.request.contextPath}/assets/images/pizza.jpg" />
        <p>2020-11-06</p>
        <span>Series</span>
      </div>
      <div class="pro--item">
        <img
          src="${pageContext.request.contextPath}/assets/images/pengsu.jpg"
        />
        <p>2020-11-06</p>
        <span>Series</span>
      </div>
      <div class="pro--item">
        <img src="${pageContext.request.contextPath}/assets/images/lemon.jpg" />
        <p>2020-11-06</p>
        <span>Series</span>
      </div>
      <div class="pro--item">
        <img src="${pageContext.request.contextPath}/assets/images/city.jpg" />
        <p>2020-11-06</p>
        <span>Series</span>
      </div>
    </div>
    
  </main>
</div>

    <script
      src="${pageContext.request.contextPath}/assets/js/profile.js"
      defer
    ></script>
  </body>
</html>
