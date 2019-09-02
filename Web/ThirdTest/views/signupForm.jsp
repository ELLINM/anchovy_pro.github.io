<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	function registerUser(){
		var registerForm = document.getElementById("registerForm");
		var	userid = document.getElementById("userid");
		var userpwd = document.getElementById("userpwd");
		var userpwd2 = document.getElementById("userpwd");
		
		if(userid.value.length >= 3 &&userid.value.length <= 10){
			if(userpwd.value.length >= 3 && userpwd.value.length <= 10){
				if(userpwd.value !== userpwd2.value){
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}
				
				registerForm.submit();
				return;
			}
			
			alert("비밀번호는 3~10 글자를 입력하세요");
			return;
		}
		
		function moveToHome(){
			window.location.href = "/moneybook/goMain";
		}
	}
</script>
</head>
<body>
	<h1>[회원가입]</h1>
	<form id="registerForm" action="/moneybook/user/goSignup" method="post">
		아이디<input type="text" id="userid" name="userid"><br>
		비밀번호<input type="password" id="userpwd" name="userpwd"><br>
		비밀번호 확인<input type="password" id="userpwd" name="userpwd"><br>
		<input type="button" id="registerBtn" value="가입"><br>
		<input type="button" id="cancelBtn" value="취소"><br>
	</form>
</body>
</html>
