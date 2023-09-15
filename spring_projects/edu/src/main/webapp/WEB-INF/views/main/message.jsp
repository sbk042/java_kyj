<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

<script type="text/javascript">
	let msg = '${msg}';
	let url = '${url}';
	// msg가 빈 문자열이면 잘못된 접근입니다. 아니면 msg출력
	msg = msg == '' ? '잘못된 접근입니다.' : msg;
	alert(msg);
	location.href = '<c:url value=""/>' + url;
	
</script>
</body>
</html>
