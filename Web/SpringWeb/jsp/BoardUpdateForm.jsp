<!--boardUpdateForm-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title}</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/default.css" />" />
	<script>
		function boardUpdate() {
			if(confirm("수정 하시겠습니까?")) {
				var updateForm = document.getElementById("updateForm");
				updateForm.submit();
			}
		}
	</script>
</head>
<body>
<h1>[ 글 수정 ]</h1>
<form action="/web/board/boardUpdate" id="updateForm" method="post">
	<table>
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
			<td><input type="text" name="title" id="title" value="${vo.title}" required="required"></td>
		</tr>
		<tr>
			<th>첨부 파일</th>
			<td>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" required="required">${vo.content}</textarea></td>
		</tr>
		<tr>
			<td class="right" colspan="2">
				<input type="button" value="수정" onclick="boardUpdate()">
				<a href="/web/board/boardList"><input type="button" value="취소"></a>
			</td>
		</tr>
	</table>
	<input type="hidden" name="boardNum" value="${vo.boardNum}">
	<!-- 수정시 사용자에게는 보이지 않지만  boardNum값을 같이 가져가게 해줌-->
</form>
</body>
</html>
