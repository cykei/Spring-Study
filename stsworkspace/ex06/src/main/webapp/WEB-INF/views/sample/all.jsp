<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>lallal</h1>
	<h1>/sample/all page</h1>
	
	<sec:authorize access="isAnonymous()">
		<p>isAnonymous() : 익명의 사용자의 경우 true</p> 
		<a href="/customLogin">로그인</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<p>isAuthenticted() : 인증된 사용자의 경우 true</p>
		<a href="/customLogout">로그아웃</a>
	</sec:authorize>
	
</body>
</html>