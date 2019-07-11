<!--GuestBookList-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
<h1>[ 방명록 ]</h1>
	<form action="/web/guestbook/write" method="post">
		<fieldset>
		<legend>
			<input type="submit" value="글쓰기" />
		</legend>
			<p>작성자<input type="text" name="name"></p>
			내용<textarea rows="3" name="content"></textarea><br>
			비밀번호<input type="password" name="pwd" />
		</fieldset>
	</form>
	<br>
	
	<!-- 방명록 리스트 출력 -->
	<c:forEach items="${list}" var="guestbook">
		<fieldset>
			<legend>#${guestbook.seq}</legend>
			<p>작성자 : ${guestbook.name}</p>
			<p>작성일 : ${guestbook.regdate}</p>
			<pre>${guestbook.content }</pre>
		<form action="/web/guestbook/delete" method="post">
			비밀번호 <input type="password" name="pwd" />
			<input type="hidden" name="seq" value="${guestbook.seq}">
			<input type="submit" value="글삭제" /><br><br>
		</form>
		</fieldset>
		<br>
	</c:forEach>
	
</body>
</html>
