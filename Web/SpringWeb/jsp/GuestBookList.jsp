<!--GuestBookList-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<script>
	function guestbookWrite() {
		if(confirm("등록 하시겠습니까?")) {
			var form = document.getElementById("writeForm");
			form.submit();
		}
	}
	
	function mainpage() {
		location.href = "/web/"
	}
	
	
	function guestbookDelete() {
		if(confirm("삭제 하시겠습니까?")) {
			var form = document.getElementById("deleteForm");
			form.submit();
		}
	}
</script>
</head>
<body>
<c:choose>
	<c:when test="${writeResult == true}">
		<script>alert("등록 완료")</script>
	</c:when>
	<c:when test="${writeResult == false}">
		<script>alert("등록 실패")</script>
	</c:when>
</c:choose>

<h1>[ 방명록 ]</h1>
	<form action="/web/guestbook/write" id="writeForm" method="post" enctype="multipart/form-data">
		<fieldset>
		<legend>
			<input type="button" value="글쓰기" onclick="guestbookWrite()"/>
			<input type="button" value="메인화면" onclick="mainpage()"/>
		</legend>
			<p>작성자<input type="text" name="name"></p>
			내용<textarea rows="3" name="content"></textarea><br>
			첨부파일<input type="file" name="uploadFile"><br>
			비밀번호<input type="password" name="pwd" />
		</fieldset>
	</form>
	<br>
	
	<form action="web/guestbook/guestbookList" method="get">
		<input type="hidden" name="searchItem" value="name">
		<!--searchItem은 입력받는 값인 searchKeyword가 vo객체에 저장되어있는지 확인하기 위하여 hidden으로 생성-->
		작성자<input type="text" name="searchKeyword">
		<input type="submit" value="검색">
	</form>
	
	<!-- 방명록 리스트 출력 -->
	<c:forEach items="${list}" var="guestbook">
		<fieldset>
			<legend>#${guestbook.seq}</legend>
			<p>작성자 : ${guestbook.name}</p>
			<p>작성일 : 
			<fmt:parseDate value="${guestbook.regdate}" var="parsedRegdate" pattern="yyyy-MM-dd HH:mm:ss" />
			<fmt:formatDate value="${parsedRegdate}" pattern="yyyy-MM-dd"/>
			</p>
			<p>
				첨부파일 : <a href="/web/guestbook/download?seq=${guestbook.seq}">${guestbook.originalFilename }</a>
			</p>
			<pre>${guestbook.content }</pre>
		<form action="/web/guestbook/delete" id="deleteForm" method="post">
			비밀번호 <input type="password" name="pwd" />
			<input type="hidden" name="seq" value="${guestbook.seq}">
			<input type="button" value="글삭제" onclick="guestbookDelete()" /><br><br>
		</form>
		</fieldset>
		<br>
	</c:forEach>
	
</body>
</html>
