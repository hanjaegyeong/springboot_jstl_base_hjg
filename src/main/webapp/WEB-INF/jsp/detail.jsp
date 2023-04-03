<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row mt-2">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                    <c:choose>
                        <c:when test="${post != null}">
                            <h5 class="card-title">${post.title}</h5>
                            <p class="card-text mt-3">${post.nickname}</p>
                            <h6 class="card-subtitle mb-2 text-muted"><fmt:formatDate value="${post.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/></h6>
                            <p class="card-subtitle mb-2 text-muted">주소: ${post.address}</p>
                            <p class="card-subtitle mb-2 text-muted">${post.area}평</p>
                            <p class="card-text mt-3">${post.content}</p>
                            <a href="/form/${post.boardId}" class="card-link">수정</a>
                            <a href="/delete/${post.boardId}" class="card-link">삭제</a>
                            <a href="/" class="card-link">목록</a>
                        </c:when>
                        <c:otherwise>
                            작성글이 존재하지 않습니다.
                        </c:otherwise>
                    </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <!--파일 업로드-->
    <div class="container">
        <div class="row mt-2">
            <div class="col-12">
                <div class="card">
                <form action="${pageContext.request.contextPath }/file/upload.do" method="post" enctype="multipart/form-data">
                    <label><input type="file" name="upload" /></label>
                    <input type="submit" value="업로드" />
                </form>
                </div>
            </div>
        </div>
    </div>
    <br>
    <!--댓글-->
    <div class="container">
        <div class="row mt-2">
            <div class="col-12">
                <div class="card">
                    <!-- 댓글입력 -->
                    <div class="comment-input-container">
                        예약 등록
                        <form method="post" action="/comment/${post.boardId}" modelAttribute="postCommentReq">
                            <input id="comment-input-box" class="comment-input-items" name="content" type="text"/>
                            <button class="comment-input-items" type="submit">등록</button>
                        </form>
                        <!-- <iframe name='blankifr' style='display:none;'></iframe>  -->
                        <!-- submit했을 때 페이지 이동 안시키기 위함-->
                    </div>
                
                    <!-- 댓글들 -->
                    <div class="comments">
                        <c:forEach items="${comments}" var="comment">
                            <p>${comment.content}</p>
                        </c:forEach>
                    </div>
                    </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>