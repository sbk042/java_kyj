<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>게시글 등록</title>
</head>
<body>
	<h1 class="pt-5">게시글 등록</h1>
	<form action="<c:url value='/board/insert'/>" method="post">
		<div class="form-group">
			<input class="form-control" placeholder="제목" name="bo_title">
		</div>
		<div class="form-group">
			<textarea class="form-control" placeholder="내용" name="bo_contents" style="min-height:400px"></textarea>
		</div>
		<button class="btn btn-danger">게시글 등록</button>
	</form>
</body>
</html>