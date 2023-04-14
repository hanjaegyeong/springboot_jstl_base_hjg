<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="common.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <meta charset="UTF-8" />
</head>

<body>
  <div class="container">
    <div class="row mt-2">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                <form method="post" action="/login_check.do" modelAttribute="memberDTO">
                  <input id="comment-input-box" class="comment-input-items" name="userid" type="text"/>
                  <input id="comment-input-box" class="comment-input-items" name="passwd" type="text"/>
                  <button class="comment-input-items" type="submit">등록</button>
                  <c:if test="${message == 'error'}">
                    <div style="color:red;"> 아이디 또는 비밀번호가 일치하지 않습니다.
                    </div>
                  </c:if>
                  <c:if test="${message == 'logout'}">
                    <div style="color:red;"> 로그아웃되었습니다.
                    </div>
                  </c:if>
                  </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>