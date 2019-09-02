<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
</head>
<body>
	<h1>[일일 가계부]</h1>
	<c:if test="${sessionScope.userid == null}">
		<a href="/moneybook/user/moveSignup">회원가입</a>
		<a href="/moneybook/login/moveLogin">로그인</a>
	</c:if>
	<c:if test="${sessionScope.userid != null}">
		<h2>${sessionScope.userid}님 환영합니다!</h2>
		<a href="/moneybook/note/moveNote">내 가계부</a>
		<a href="/moneybook/login/goLogout">로그아웃</a>
	</c:if>
</body>
</html>
