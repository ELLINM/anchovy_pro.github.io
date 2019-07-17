<!--BoardRead-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	//id 가 replytext 인 태그(댓글 입력상자)의 value 속성값에 인자값으로 전달받은 text 를 대입 -> 댓글 입력창에 수정할 댓글 텍스트가 입력됨
			document.getElementById("replysubmit").value = '댓글 수정';
	//id 가 replysubmit 인 태그의 value 속성값에 “댓글 수정” 을 대입 -> 「댓글 입력」버튼이 「댓글 수정」으로 변경됨		
			document.getElementById("replysubmit").onclick = function(){
			//id 가 replysubmit 인 태그의 onclick 속성에 직접 자바스크립트 메서드를 정의
				var updatetext = document.getElementById("replytext").value;
		//id 가 replysubmit 인 태그를 클릭시, id 가 replytext 인 태그의 value 속성값(댓글 입력상자의 텍스트)을 updatetext 변수에 대입
				location.href="/web/board/replyUpdate?replyNum=" + replynum + "&boardNum=" + "${vo.boardNum}&replytext=" + updatetext;
				//서버에 /web/board/replyUpdate 로 요청을 보내면서 replynum 과 boardNum, replytext 를 파라미터로 보냄
			}
		}
		
		function replyDelete(replynum){
			if(confirm("댓글을 삭제하시겠습니까?")){
				 location.href="/web/board/replyDelete?replyNum=" + replynum + "&boardNum=" + ${vo.boardNum};
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
		<c:when test="${deleteResult == true}">
			<script>alert("삭제 완료");</script>
		</c:when>
		<c:when test="${deleteResult == false}">
			<script>alert("삭제 실패")</script>
		</c:when>
	</c:choose>
<h1>[ 글 읽기 ]</h1>
<table>
	<tr>
		<td class="right" colspan="2">
			<c:if test="${sessionScope.userid == vo.userid}">
				<a href="/web/board/boardUpdateForm?boardNum=${vo.boardNum}"><input type="button" value="수정"></a>
			<!--수정 버튼을 클릭하면 자바스크립트의 replyModify 메서드를 호출하면서 replynum 과 replytext 를 인자값으로 전달-->
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
		<th>
		작성일
		</th>
		<td>
			<fmt:parseDate value="${vo.inputdate}" var="parsedRegdate" pattern="yyyy-MM-dd HH:mm:ss" /> 
			<fmt:formatDate	value="${parsedRegdate}" pattern="yyyy년MM월dd일" />
			</td>
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
					<input type="button" value="삭제" onclick="replyDelete('${reply.replyNum}')">
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>
