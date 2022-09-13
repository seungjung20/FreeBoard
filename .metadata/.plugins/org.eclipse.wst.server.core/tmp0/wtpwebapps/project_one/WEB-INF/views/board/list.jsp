<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list</title>
</head>
<body>
	<h1>board list page 입니다</h1>
	<c:if test="${not empty login}">
		<h1>로그아웃</h1>
	</c:if>
	<c:if test="${empty login}">
		<h1>로그인 또는 회원가입</h1>
	</c:if>
</body>
</html>