<!--BoardRead-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title}</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/default.css" />" />
	<script>
		function boardDelete() {
			if(confirm("삭제 하시겠습니까?")) {
				location.href="/web/board/boardDelete?boardNum=${vo.boardNum}";
			}
		}
	</script>
</head>
<body>
	<c:choose>
		<c:when test="${updateResult == true}">
			<script>alert("수정 완료");</script>
		</c:when>
		<c:when test="${updateResult == false}">
			<script>alert("수정 실패")</script>
		</c:when>
	</c:choose>
<h1>[ 글 읽기 ]</h1>
<table>
	<tr>
		<td class="right" colspan="2">
			<c:if test="${sessionScope.userid == vo.userid}">
				<a href="/web/board/boardUpdateForm?boardNum=${vo.boardNum}"><input type="button" value="수정"></a>
				<input type="button" value="삭제" onclick="boardDelete()">
			</c:if>
			<a href="/web/board/boardList"><input type="button" value="목록"></a>
			<!--이전 글 목록으로 돌아 가도록 -->
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
	<!--각항목은 EL태그로 저장된 내용을 불러올 수 있도록함 또한 content의 경우 읽을 수 만 있도록 함-->
</table>
</body>
</html>
