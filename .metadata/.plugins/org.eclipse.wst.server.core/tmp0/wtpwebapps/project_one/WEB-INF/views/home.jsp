<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<script>
	function showLogin() { 
		window.open("login", "login", "width=500, height=500"); 
	}
	
	function showRegister(){
		window.open("register", "register", "width=600, height=600");
	}
</script>
</head>
<body>
	<h1>main page</h1>
	<input type="button" value="로그인" onclick="showLogin();" />
	<input type="button" value="회원가입" onclick="showRegister();"/>
</body>
</html>