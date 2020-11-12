<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

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
            onclick="location.href='${pageContext.request.contextPath}/allpost.pr?userNo=<%= u.getUserNo() %>';"
            >ALL POST</a
          >
        </li>
        <li>
          <a
            href="#"
            id="pro--picBtn"
            class="pro--tab-select"
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
    
      <% for(Picstorys p : picList) { %>
	      <div class="pro--item">
	        <img
	          src="${pageContext.request.contextPath}/assets/uploads/<%= p.getPhotoSrc() %>"
	          onclick="location.href='${pageContext.request.contextPath}/picphoto.pr?userNo=<%= userNo %>&picId=<%= p.getPicstoryId() %>&picName=<%= p.getPicstoryName() %>'"
	        />
	        <p><%= p.getPicstoryCreatedAt() %></p>
	        <span><%= p.getPicstoryName() %></span>
	      </div>
      <% } %>
       
    </div>
    
  </main>
</div>

    <script
      src="${pageContext.request.contextPath}/assets/js/profile.js"
      defer
    ></script>
  </body>
</html>
