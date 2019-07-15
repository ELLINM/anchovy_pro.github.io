<!--BoardWriteForm-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/default.css"/>" />
</head>
<body>
<script>
	function boardWrite() {
		if(confirm("등록 하시겠습니까?")) {
			var writeForm = document.getElementById("writeForm");
			writeForm.submit();
		}
	}
</script>

<h1>[ 글쓰기 ]</h1>
<form action="/web/board/boardWrite" id="writeForm" method="post">
	<table>
		<tr>
			<th>작성자</th>
			<td>${sessionScope.userid}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" required="required"></td>
		</tr>
		<tr>
			<th>첨부 파일</th>
			<td></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" required="required"></textarea></td>
		</tr>
		<tr>
			<td class="right" colspan="2">
				<input type="button" value="확인" onclick="boardWrite()">
				<a href="/web/board/boardList"><input type="button" value="취소"></a>
			</td>
		</tr>
	</table>
	<input type="hidden" name="userid" value="${sessionScope.userid}">
</form>
</body>
</html>
