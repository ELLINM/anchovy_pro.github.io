<!--BoardRead-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title}</title>

<link rel="stylesheet" type="text/css" href="<c:url value="/css/default.css" />" />
</head>
<body>

<h1>[ 글 읽기 ]</h1>
<table>
	<tr>
		<td class="right" colspan="2">
			<c:if test="${sessionScope.userid == vo.userid}">
				<a href="#"><input type="button" value="수정"></a>
				<a href="/web/board/boardDelete?boardNum=${vo.boardNum}"><input type="button" value="삭제"></a>
			</c:if>
			<a href="/web/board/boardList"><input type="button" value="목록"></a>
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<td>${vo.boardNum}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${vo.userid}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${vo.inputdate}</td>
	</tr>
	<tr>
		<th>조회</th>
		<td>${vo.hit}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${vo.title}</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea readonly="readonly">${vo.content}</textarea></td>
	</tr>
</table>
</body>
</html>
