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
	<h1>게시글 리스트</h1>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>추천/비추천</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board"> <!-- var는 꺼냈을 때의 이름 -->
				<tr>
					<td>${board.bo_num}</td> <!-- get방식은 ? 내가 보내려는 이름을 쓰고 값을 써준다. -->
					<td><a href="<c:url value='/board/detail?bo_num=${board.bo_num}'/>">${board.bo_title}</a></td>
					<td>${board.bo_me_id}</td> 
					<td>${board.bo_views}</td>
					<td>${board.bo_up}/${board.bo_down}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value='/board/insert'/>"><button>게시판 글쓰기</button></a>
</body>
</html>