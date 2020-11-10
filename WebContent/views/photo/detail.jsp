<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="com.dia.photo.model.vo.Photo, com.dia.photo.model.vo.Comment, java.util.ArrayList" %>
<%
	Photo p = (Photo)request.getAttribute("p");
	ArrayList<Comment> list = (ArrayList<Comment>)request.getAttribute("cm");
%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>작품상세페이지</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/detail.css" />
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  </head>
  <body>
    
    <%@ include file="../common/menubar.jsp" %>
    
        <!-- 여기에 컨텐츠 작성 -->

        <div class="detail--container" style="border: 0px">
          <!-- 상세 (detail--body)    |   네이게이션바(detail--navi) -->
          <div class="detail--body">
            <div id="detail" class="detail--title">
              <!-- detail 로고랑 오른쪽에 >next 들어가는 영역 -->
              <div class="title">
                <h5>DETAIL</h5>
              </div>
              <a href="#">NEXT ＞</a>
              <!-- <a href="#">＜ BACK</a> -->
            </div>

            <div class="detail--1">
              <div class="detail--1L">
                <div class="detail--imageWrapper">
                  <img src="${pageContext.request.contextPath}/assets/uploads/<%= p.getPhotoSrc() %>" alt="" />
                </div>
                <div class="detail--label">
                  <label>♡ 304</label>
                  <label>⚠ 신고</label>
                </div>
              </div>
              <div class="detail--1R">
                <!-- 가격정보 (detail--price) -->
                <span>
                  <h2><%= p.getPhotoName() %></h2>
                  <h3><%= p.getUserName() %></h3>
                  <a href="#">More Picture &gt;</a>	
                  <h4><%= p.getPhotoCreatedAt() %></h4>
<% if(p.getPhotoSale() == 1){ %>
                  <p><%= p.getPhotoPrice() %> ₩</p>
<% } %>
                  <br />
                </span>
                <div class="btn--wrappers">

<% if(p.getPhotoSale() == 1){ %>	

                  <button class="btn btn-yellow">BUY NOW</button>
                  <button class="btn btn-yellowBo">ADD CART</button>
<% }else{ %>

                  <button class="btn btn-green">NOT FOR SALE</button>

<% } %>
                </div>
              </div>
            </div>
            <div id="about-photo" class="detail--2title">
              <h2>ABOUT THIS PHOTO</h2>
              <% if(loginUser != null&& loginUser.getUserNo() == p.getUserNo()){ %>          
              <span>
                <label>✐ 수정</label>
                <label class="detail--delLabel">🚫 삭제</label>
              </span>
              <% }else{ } %>
            </div>
            <div class="detail--2">
              <!-- 사진 설명 (detail--detail) -->
              <%= p.getPhotoInfo() %>

            </div>
            <div id="comment-list" class="detail--3">
              <!-- 댓글 (detail--comments) -->
              <h2>COMMENTS</h2>
              <br /><br />
              <h3>댓글작성</h3>
              <br />
              <form>
                <% if(loginUser != null){ %> 

                <input id='comment--input'
                name='asd'
                  type="text"
                  placeholder="맑고 깨끗한 댓글문화를 만듭시다!"
                >
                <input type="text" hidden id='userNo' value="<%=loginUser.getUserNo() %>">
                <input type="text"hidden  id='photoId' value='<%=p.getPhotoId() %>'>
                <% }else{ %> 
                  <input 
                  disabled
                  type="text"
                  placeholder="로그인후 댓글작성이 가능합니다."
                />
                <% } %> 
                <button type='button' onClick='fetchComment()' id='comment--submit' class="btn btn-small">등록</button>
              </form>
              <div class="detail-gap"></div>
              <ul class="comment--container">

<% int commentIndex =0; %>  
<% for(Comment c: list){ %>  
                <input type="text" class='comment-id' hidden value='<%= c.getCommentId()%>'>
                <li class="comment--item">
                  <div class="comment-top">
                    <div class="comment-user">
                      <img src="${pageContext.request.contextPath}/assets/images/오로라.jpg" alt="" />
                      <span><%= c.getUserNickname() %></span>
                    </div>
                    <% if(loginUser != null&& loginUser.getUserNo() == c.getUserNo()){ %> 
                    <div class="comment-remove">
                      <span onClick='removeContent(<%= c.getCommentId()%>)'>remove</span>
                      <i>X</i>
                    </div>
                    <% } %>
                  </div>
                  <div class="comment-bottom">
                    <p class='comment-value'><%= c.getCommentContent() %></p>
                    <% if(loginUser != null&& loginUser.getUserNo() == c.getUserNo()){ %>  
                    <div class="icon-box">
                      <div @click='setFixCommentOpen'onClick='setIndex(<%=commentIndex %>)' class="comment-icon">
                        <small>수정</small>
                        <i>X</i>
                      </div>
                      <div class="comment-icon">
                        <small>신고</small>
                        <i>X</i>
                      </div>
                    </div>
                    <% } %>
                  </div>
                </li>

<% commentIndex++; } %>

              </ul>
            </div>
          </div>
          <div class="detail--navi">
            <div class="detail--navi-bar">
              <a href="#detail">＞ 작품 정보</a>
              <a href="#about-photo">＞ 작가의 설명</a>
              <a href="#comment-list">＞ COMMENT</a>
              <a href="#">＞ TOP</a>
            </div>
          </div>
        </div>
      </main>   
      
    <div class="modal--container" :class='{modalActive:fixCommentModal}'>
      <div class="modal--box">
        <h1>댓글수정</h1>
        <div class="gap"></div>
        <input type="text" class="modal--input" id='fix-content'>
        <div class="gap"></div>
        <div class="modal--btn-box">
          <button class="btn" @click='setFixCommentOpen'>취소</button>
          <button class="btn btn-yellow" onClick='fixContent()'>수정</button>
        </div>
      </div>
     </div>
   </div>

 
  </body>

  <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js" defer></script>
  <script defer>
    const userNo = document.querySelector('#userNo').value;
    const photoId = document.querySelector('#photoId').value;
    const commentBtn = document.querySelector('#comment--submit');
    const commentId = document.querySelectorAll('.comment-id');
    let commentIndex = 0;

    const fetchComment = async()=>{
      const response = await axios.get('/dia/insert.cm?content='+document.querySelector('#comment--input').value+'&userNo='+userNo+'&photoId='+photoId)
      if(response.data==='success'){
        location.reload();
      }else{
        alert(response.data);
      }
    };
    const removeContent = async(commentId)=>{
      const response = await axios.get('/dia/delete.cm?cid='+commentId)
      if(response.data==='success'){
        location.reload();
      }else{
        alert(response.data);
      }
    }
    
    const fixContent = async()=>{
      console.log(1)
      const response = await axios.get('/dia/fix.cm?cid='+commentId[commentIndex].value+'&content='+document.querySelector('#fix-content').value);
      if(response.data==='success'){
        location.reload();
      }else{
        alert(response.data);
      }
    }
    const setIndex = (i)=>{
      commentIndex=i;
      document.querySelector('#fix-content').value = document.querySelectorAll('.comment-value')[commentIndex].innerText;
    }
  </script>
</html>
