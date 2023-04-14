<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <!--이미지 파일 업로드-->
                        <div class="container">
                            <div class="row mt-2">
                                <div class="col-12">
                                    <div class="card">
                                    <form action="${pageContext.request.contextPath}/file/${post.boardId}/upload.do" method="post" enctype="multipart/form-data">
                                        <label><input type="file" name="upload" /></label>
                                        <input type="submit" value="업로드" />
                                    </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>