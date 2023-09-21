<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>게시글 등록</title>
</head>
<body>
	<h1 class="pt-5">게시글 상세</h1>
	<div class="form-group">
		<label>제목</label>
		<input type="text" class="form-control" readonly value="${board.bo_title}">
	</div>
	<div class="form-group">
		<label>작성자</label>
		<input type="text" class="form-control" readonly value="${board.bo_me_id}">
	</div>
	<div class="form-group">
		<label>조회수</label>
		<input type="text" class="form-control" readonly value="${board.bo_views}">
	</div>
	<div class="form-group">
		<label>내용</label> <!-- 최소 400px이 되도록 min-height를 이용했음 -->
		<textarea type="text" class="form-control" readonly style="min-height:400px">${board.bo_contents}</textarea> 
	</div>
	<div class="form-group">
		<label>첨부파일</label>
		<!-- fileList에서 하나 꺼냈을 때의 이름을 file로 지정한다. -->
		<!-- 왜 c:forEach로 감싸요? >> 첨부파일이 하나가 아닌 여러개라서! -->
		<c:forEach items="${fileList}" var="file">
			<!-- 이 다운로드를 클릭하면  -->
			<a href="<c:url value='/download${file.fi_name}'/>" download="${file.fi_ori_name }">${file.fi_ori_name}</a>
		</c:forEach>
	</div>
</body>
</html>