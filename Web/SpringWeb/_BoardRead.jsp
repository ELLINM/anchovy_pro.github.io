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
		
		function replyWrite(){
			var replytext = document.getElementById("replytext");
			if(replytext.value.length == 0){
				alert("댓글을 입력하세요");
				return; 
				//아무것도 입력하지 않았을때 다음 단계로 넘어가지않고 다시 입력을 할 수 있도록 반환
			}
			document.getElementById("replyWrite").submit();
		}
		
		function replyModify(replynum, replytext){
			document.getElementById("replytext").value = replytext;
			document.getElementById("replysubmit").value = '댓글 수정';
			
			document.getElementById("replysubmit").onclick = function(){
				var updatetext = document.getElementById("replytext").value;
				location.href="/web/board/replyUpdate?replyNum=" + replynum + "&boardNum=" + "${vo.boardNum}&replytext=" + updatetext;
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
<!-- 댓글입력 -->
<form action="/web/board/replyWrite" id="replyWrite" method="post">
	<input type="hidden" name="boardNum" value="${vo.boardNum}">
	<input type="text" id="replytext" name="replytext" required="required">
	<input type="button" id="replysubmit" value="댓글 입력" onclick="replyWrite()">
	
</form>
<div id="replydisplay">
	<table class="reply">
		<c:forEach items="${replyList}" var="reply">
			<tr>
				<td class="replytext">
					${reply.replytext}
				</td>
				<td class="replyid">
					${reply.userid}
				</td>
				<td class="replydate">
					${reply.inputdate}
				</td>
				<td>
				<c:if test="${sessionScope.userid == reply.userid}">
					<input type="button" value="수정" onclick="replyModify('${reply.replyNum}','${reply.replytext}')">
					<input type="button" value="삭제">
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>
