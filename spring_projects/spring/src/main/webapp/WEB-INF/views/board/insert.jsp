<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8" %>
<!doctype html>
<html lang="ko">
<head>
 	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<h1>게시글 등록</h1><!-- 게시글은 양이 많으므로 post로 전송해야한다. -->
	<form action="<c:url value='/board/insert'/>" method="post" enctype="multipart/form-data"> <!-- ebctype 첨부파일을 위한 --> 
		<input type="hidden" name="bo_ori_num" value="${bo_ori_num}">
		
		<div class="form-group">
			<label>게시판명</label>
			<select class="form-control" name="bo_bt_num">
				<c:forEach items="${typeList}" var="type">
					<option value="${type.bt_num}">${type.bt_title}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label>제목</label>
			<input type="text" class="form-control" name="bo_title">
		</div>
		<div class="form-group">
			<label>작성자</label>
			<input type="text" class="form-control" name="bo_me_id" value="${user.me_id}" readonly>
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea name="bo_contents" id="summernote"></textarea>
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<input type="file" class="form-control" name="files2">
			<input type="file" class="form-control" name="files2">
			<input type="file" class="form-control" name="files2">
		</div>
		<button class="btn btn-outline-success col-12">등록하기</button>
	</form>
	<script>
	// typeList사이즈가 0과 같으면 알림창이 뜨게 만듬
	if(${typeList.size()} == 0){
		alert('작성 가능한 게시판이 없습니다.');
		location.href = '<c:url value="/board/list"/>'
	}
      $('#summernote').summernote({
        placeholder: '내용을 입력하세요.',
        tabsize: 2,
        height: 400
      });
    </script>
</body>
</html>