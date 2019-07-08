<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
	<h1><a href="/web/test/testInsert?a=가나다라&b=1234">testInsert</a></h1>
	<h1><a href="/web/member/signupForm">회원가입</a></h1>
	<h1><a href="#">로그인</a></h1>
	
	<c:if test="${result == true}">
		<h3>가입 성공</h3>
	</c:if>
	
	<c:if test="${memberVO != null}">
		<h3>회원정보 : ${memberVO}</h3>
	</c:if>
	
</body>
</html>
