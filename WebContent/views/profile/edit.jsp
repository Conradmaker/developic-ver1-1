<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.dia.user.model.vo.User"%>
<%@ page import = "oracle.sql.CLOB" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>DeveloPic | Edit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/edit.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
    />

    <!-- Styles -->
    <link rel="stylesheet" href="https://uicdn.toast.com/tui-editor/latest/tui-editor.css"></link>
    <link rel="stylesheet" href="https://uicdn.toast.com/tui-editor/latest/tui-editor-contents.css"></link>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.css"></link>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/github.min.css"></link>
    <!-- Scripts -->
    <script src="https://uicdn.toast.com/tui-editor/latest/tui-editor-Editor-full.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  </head>
  <body>
  
  	  <%@ include file="../common/menubar.jsp" %>
  

      <!-- 여기에 컨텐츠 작성 -->

      <div class="buy--container">
        <form action="/dia/insert.ph" method="get" name="editEnroll">
          <div class="buy--body">
            <div class="buy--title">
              <!-- detail 로고랑 오른쪽에 >next 들어가는 영역 -->
              <div class="title">
                <h5>EDIT</h5>
              </div>
              <!-- <a href="#">NEXT ＞</a> -->
              <a href="#">＜ BACK</a>
            </div>

			<!-- 작품 등록시, userNo를 같이 넘길수 있게 -->
      		<input type="text" name="userNo" id="editUserNo"  value="<%= loginUser.getUserNo() %>" hidden >
			
            <div class="buy--upload">
              <div class="buy-gap"></div>
              <h2>UPLOAD PHOTO</h2>
              <div class="buy-gap"></div>

              <!-- 파일 선택하는 부분 -->
              <div class="buy--fileWrapper">
                <label for="fileBtn" id="fileLabel" ></label>
                <input type="file" id="hiddenFileBtn" hidden required>
                <button type="button" id="fileBtn" class="btn btn-green">SELECT A FILE</button>
				        <input type="text" id="hiddenFileSrc" name="photoSrc" hidden> 
              </div>
              <div class="buy-gap"></div>
              <p>미리보기</p>
              <div class="buy--imageWrapper">
                <img src="" id="fileImage" />
              </div>
            </div>
            <div class="buy--info">
              <div class="buy-gap"></div>
              <div class="buy-gap"></div>
              <h2>INFORMATION</h2>
              <div class="buy-gap"></div>
              <table>
                <tr>
                  <th><label for="">제목</label></th>
                  <td colspan="2"><input type="text" name="photoName" placeholder="TITLE" required /></td>
                </tr>
                <tr>
                  <th><label for="">카테고리</label></th>
                  <td colspan="2">
                    <select name="categoryId">
                      <option value="10">ANIMALS</option>
                      <option value="20">PEOPLE</option>
                      <option value="30">URBAN</option>
                      <option value="40">NATURE</option>
                      <option value="50" selected>ETC</option>
                    </select>
                  </td>
                </tr>
                <tr>
                  <th><label for="">판매여부</label></th>
                  <td>
                    <div class="buy--saleWrapper">
                      <div class="buy--saleLa">판매가능</div>
                      <div class="buy--saleLa">판매불가</div>
                      <input type="text" id="buy--photoSale" name="photoSale" value="0" hidden>
                      <div id="buy-saleBtn" class="saleSelectY saleSelectN"></div>
                    </div>
                  </td>
                  <td>
                    <input type="number" name="photoPrice" class="buy--photoPrice" placeholder="₩" hidden>
                  </td>
                </tr>
                <tr>
                  <th colspan="3" ><label for="">소개</label></th>
                </tr>
                <tr>
                  <td colspan="3">
                      <!-- api 에디터 부분!! -->
                      <div>
                          <div id="editorSection"></div>
                      </div>
                      <textarea name="photoInfo" id="editorHidden" hidden required></textarea>
                  </td>
                </tr>
                <tr>
                	<td colspan="3"></td>
                </tr>
                <tr>
                  <th><label for="">픽스토리</label></th>
                  <td colspan="2">
                    <div class="picsWrapper">
                      <label for="" id="picsLabel"></label>
                      <!-- <input type="text" name="  -->
                      <button type="button" id="picsBtn" class="btn btn-green btn-small">SELECT</button>
                      <!-- <span></span>
                      <button class="btn btn-green btn-small">SELECT</button> -->
                    </div>
                  </td>
                </tr>
              </table>
              <div class="buy-gap"></div>
              <div class="buy-gap"></div>
              <div class="buy--btnWrapper">
                <button type="submit" class="btn btn-yellow btn-small" >등록</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </main>

    <script src="${pageContext.request.contextPath}/assets/js/edit.js" defer></script>
    <script src="${pageContext.request.contextPath}/assets/js/mypage/index.js"></script>
</div>
  </body>
</html>
