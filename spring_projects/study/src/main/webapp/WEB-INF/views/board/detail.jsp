<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세</h1>
	<h3>제목 : ${board.bo_title }</h3>
	<h3>작성자 : ${board.bo_me_id }</h3>
	<h3>조회수 : ${board.bo_views }</h3>
	<hr>
	<div>${board.bo_contents }</div>
	<h3>첨부파일</h3>
	<c:forEach items="${fileList}" var="file">
		<a  href="<c:url 
			value='/download${file.fi_name}'/>" 
			download="${file.fi_ori_name }"
		>${file.fi_ori_name }</a> <br>
	</c:forEach>
	<div>${board.bo_contents }</div>
	<a href="<c:url value='/board/update?bo_num=${board.bo_num}'/>">수정</a>
	<a href="<c:url value='/board/delete?bo_num=${board.bo_num}'/>">삭제</a>
	<!-- 댓글 등록 시작 -->
	<hr>
	<h2>댓글</h2>
	<textarea rows="" cols="" placeholder="댓글 등록" id="inputComment"></textarea>
	<button id="btnCommentInsert">댓글 등록</button>
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		$('#btnCommentInsert').click(function(){
			let co_contents = $('#inputComment').val();
			let co_me_id = '${user.me_id}';
			let co_bo_num = '${board.bo_num}';
			
			// 만약 로그인 정보가 없으면 로그인을 해야하는 안내창을 띄운다.
			if(co_me_id == ''){
				if(confirm('로그인이 필요한 서비스입니다. 로그인하시겠습니까?')){
					// 로그인창으로 넘어가는 url입력
					location.href = '<c:url value="/member/login"/>'
				}
				return;
			}
			// 만약 댓글을 아무것도 입력을 안 하고 등록을 누르면 안내창이 뜬다.
			if(co_contents.trim() == ''){
				alert('댓글 내용을 입력하세요.');
				$('#inputComment').focus();
				return;
			}
			
			let comment = {
					co_contents : co_contents,
					co_me_id : co_me_id,
					co_bo_num : co_bo_num
			}
			/* 객체를 만들고 ajax로 보내준다. */
			$.ajax({
				async : false,
				method : 'post',
				url : '<c:url value="/comment/insert"/>',
				data: JSON.stringify(comment),
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				success : function(data){ /*<= 이름을 꼭 data로 할 필요는 없다.  */
					if(data.res){
						alert('댓글 등록 성공');
						$('#inputComment').val('');
					}else{
						alert('댓글 등록 실패');
					}
				}
			})
		});
	</script>
</body>
</html>