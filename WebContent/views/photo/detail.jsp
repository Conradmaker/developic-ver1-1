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
    <title><%= p.getPhotoName() %> | DETAIL</title>
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
            </div>

            <div class="detail--1">
              <div class="detail--1L">
                <div class="detail--imageWrapper">
                  <img src="${pageContext.request.contextPath}/assets/uploads/<%= p.getPhotoSrc() %>" alt="" />
                </div>
                <div class="detail--label">
                  <label id='like-photo-btn' onclick="likePhoto()">
                    <i id='like-icon' class="far fa-heart"></i> 
                    <i id='like-length'>304</i> 
                  </label>
                  <label @click='setDeclarePhotoOpen'>⚠ 신고</label>
                </div>
              </div>
              <div class="detail--1R">
                <span>
                  <h2><%= p.getPhotoName() %></h2>
                  <h3><%= p.getUserName() %></h3>
                  <a href="${pageContext.request.contextPath}/allpost.pr?userNo=<%= p.getUserNo() %>">More Picture &gt;</a>	
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
                <label class="detail--delLabel"  @click='setDeletePhotoOpen'>🚫 삭제</label>
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
                    <div class="comment-user" onClick='location.href="/dia/allpost.pr?userNo=<%= c.getUserNo()%>"'>

                      <span><%= c.getUserNickname() %></span>
                    </div>
                    <% if(loginUser != null&& loginUser.getUserNo() == c.getUserNo()){ %> 
                    <div class="comment-remove">
                      <span onClick='removeContent(<%= c.getCommentId()%>)'>remove</span>
                      <i class="far fa-trash-alt"></i>
                    </div>
                    <% } %>
                  </div>
                  <div class="comment-bottom">
                    <p class='comment-value'><%= c.getCommentContent() %></p>
                    <div class="icon-box">
                      <% if(loginUser != null&& loginUser.getUserNo() == c.getUserNo()){ %>  
                      <div @click='setFixCommentOpen' onClick='setIndex(<%=commentIndex %>)' class="comment-icon">
                        <small>수정</small>
                        <i class="fas fa-pencil-ruler"></i>
                      </div>
                      <% }%>
                      <% if(loginUser != null&& loginUser.getUserNo() != c.getUserNo()){ %>  
                      <div @click='setDeclareCommentOpen' onClick='setIndex(<%=commentIndex %>)' class="comment-icon">
                        <small>신고</small>
                        <i class="fas fa-balance-scale"></i>
                      </div>
                      <% }%>
                    </div>
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
      
      <!-- 댓글수정 -->
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
     <!-- 댓글신고 -->
     <div class="modal--container" :class='{modalActive:declareCommentModal}'>
      <div class="modal--box">
        <h1>🚔 댓글을신고하시겠습니까?</h1>
        <div class="gap"></div>
        <input type="text" class="modal--input"  id='declare-content' placeholder="사유를 입력해주세요"/>
        <div class="gap"></div>
        <div class="modal--btn-box">
          <button class="btn" @click='setDeclareCommentOpen'>취소</button>
          <button class="btn btn-yellow" onClick='declareComment()'>신고</button>
        </div>
      </div>
    </div>
         <!-- 작품신고 -->
         <div class="modal--container" :class='{modalActive:declarePhotoModal}'>
          <div class="modal--box">
            <h1>🚔 작품을 신고하시겠습니까?</h1>
            <div class="gap"></div>
            <input type="text" class="modal--input"  id='declare-photo' placeholder="사유를 입력해주세요"/>
            <div class="gap"></div>
            <div class="modal--btn-box">
              <button class="btn" @click='setDeclarePhotoOpen'>취소</button>
              <button class="btn btn-yellow" onClick='declarePhoto()'>신고</button>
            </div>
          </div>
        </div>

        <!-- 작품삭제 -->
        <div class="modal--container" :class='{modalActive:deletePhotoModal}'>
          <div class="modal--box">
            <h1>작품을 렬루 삭제하시겠습니까?</h1>
            <div class="gap"></div>
            <div class="gap"></div>
            <div class="modal--btn-box">
              <button class="btn" @click='setDeletePhotoOpen'>취소</button>
              <button class="btn btn-yellow" onClick='deletePhoto()'>삭제</button>
            </div>
          </div>
        </div> 
      
      </div>


<script defer>



    const userNo = document.querySelector('#userNo').value;
    const photoId = document.querySelector('#photoId').value;
    const commentBtn = document.querySelector('#comment--submit');
    const commentId = document.querySelectorAll('.comment-id');
    const likeIcon = document.querySelector('#like-icon');
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
      const response = await axios.get('/dia/fix.cm?cid='+commentId[commentIndex].value+'&content='+document.querySelector('#fix-content').value);
      if(response.data==='success'){
        location.reload();
      }else{
        alert(response.data);
      }
    };
    const declareComment = async()=>{
      const response = await axios.get('/dia/declare.cm?cid='+commentId[commentIndex].value+'&content='+document.querySelector('#declare-content').value + '&uid='+userNo);
      if(response.data==="신고가 접수되었습니다."){
        alert(response.data);
        location.reload();
      }else{
        alert(response.data);
      }
    };

    const declarePhoto = async()=>{
      const response = await axios.get('/dia/declare.ph?pid='+photoId+'&content='+document.querySelector('#declare-photo').value + '&uid='+userNo);
      if(response.data==="신고가 접수되었습니다."){
        alert(response.data);
        location.reload();
      }else{
        alert(response.data);
      }
    };
    const deletePhoto = async()=>{
      const response = await axios.get('/dia/delete.ph?pid='+photoId);
      if(response.data==="success"){
        alert(response.data);
        location.href='/dia/'
      }else{
        alert(response.data);
      }
    };

  const likePhoto =()=>{
    if(document.querySelector('#like-icon').classList.contains('far')){
      console.log(11);
      document.querySelector('#like-icon').className = 'fas fa-heart'
      document.querySelector('#like-length').innerText = parseInt(document.querySelector('#like-length').innerText) +1;
    }else if(document.querySelector('#like-icon').classList.contains('fas')){
      console.log(22);
          document.querySelector('#like-icon').className = 'far fa-heart';
          document.querySelector('#like-length').innerText = parseInt(document.querySelector('#like-length').innerText) -1;
    }
  }
    const setIndex = (i)=>{
      commentIndex=i;
      document.querySelector('#fix-content').value = document.querySelectorAll('.comment-value')[commentIndex].innerText;
    }
  </script>
 

  
  <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js"></script>
  </body>
  
</html>
