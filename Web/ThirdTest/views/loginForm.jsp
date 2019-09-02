<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	function startLogin(){
		var loginForm = document.getElementById("loginForm");
		var userid = document.getElementById("userid");
		var userpwd = document.getElementById("userpwd");
		
		if(userid.value.length >= 3 && userid.value.length <= 10){
			if(userpwd.value.length >= 3 && userpwd.value.length <= 10){
				loginForm.submit();
				return;
			}
			alert("비밀번호는 3~10글자를 입력하세요");
			return;
		}
		alert("아이디는 3~10 글자를 입력하세요");
		return;
	}
	
	function moveToHome(){
		window.location.href = "/moneybook/goMain";
	}
</script>
</head>
<body>
	<h1>[로그인]</h1><br>
	<form id="logiForm" action="/moneybook/login/goLogin" method="post">
		아이디<input type="text" id="userid" name="userid"><br>
		비밀번호<input type="password" id="userpwd" name="userpwd"><br>
		<input type="button" value="로그인" onclick="startLogin()">
		<input type="button" value="취소" onclick="moveToHome()">
	</form>
</body>
</html>
