<!--LoginForm-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

	<h1>login</h1>
	<form action="/web/member/login" method="post">
		ID : <input type="text" name="userid"><br>
		PW : <input type="password" name="userpwd"><br>
		 <input type="submit" value="login"><br>
	</form>

	<c:if test="${result == false}">
	ID 또는 PW가 일치 하지 않습니다.
	</c:if>
	
</body>
</html>
