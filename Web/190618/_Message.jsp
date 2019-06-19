<!--index-->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${messageList}" var="words">
<h5>${words}</h5>
</c:forEach>
	<form action="messageInsert" method="post">
		<input type="text" name="message">
		<input type="submit" value="전송">
	</form>
</body>
</html>
