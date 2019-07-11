<!--BoardList-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/default.css"/>" />

</head>
<body>
	<h1>[ 게시판 ]</h1>
	<table>
		<tr>
			<td class="right" colspan="5">
				<a href="#"><img src="<c:url value="/img/write_64.png"/>"></a>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="boardVO">
			<tr>
				<td class="center">${boardVO.boardNum}</td>
				<td class="center">${boardVO.userid}</td>
				<td id="title"><a href="/web/board/boardRead?boardNum=${boardVO.boardNum}">${boardVO.title}</a></td>
				<td class="center">${boardVO.hit}</td>
				<td id="inputdate">${boardVO.inputdate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
