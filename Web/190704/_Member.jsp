<!--home-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<a href="signupForm?a=a">회원가입</a>
	<a href="login?a=a.jsp">로그인</a>
	
	<!--href의 name은 갖고 오고자 하는 페이지의 method와 같은 이름으로 설정-->
	
	<br>
	<c:if test="${vo!=null}"> <!--EL문의 경우 원하고자 하는 조건을 등록하여 -->
	<!--model이 보내온 값을 vo로 받아서 출력한다.-->
	ID : ${vo.userid}<br>
	PW : ${vo.userpwd}<br>
	NAME : ${vo.username}<br>
	Address : ${vo.address}<br>
	Hobby : ${vo.hobby}<br>
	Married : ${vo.marital}<br>
	Root : ${vo.joinpath}<br>
	</c:if>
</body>
</html>


<!--signup-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 양식</title>
</head>
<body>
<div class="wrapper">
	<form action="signupaction" method="post">
<!--action을 통하여 controller에서 사용하려는 action을 구분함 같은 페이지 안에 여러 action이 있다하더라고 action name으로 구분하기 때문에 -->
	<table border="1">
		<caption>회원가입 양식</caption>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userid" placeholder="아이디 입력">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="userpwd">
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="username">
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>
				<input type="text" name="phone" >
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" name="address" placeholder="주소" width="50" >
			</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				낚시 <input type="checkbox" name="hobby" value="fishing" > &nbsp;
				농구 <input type="checkbox" name="hobby" value="basketball" > &nbsp;
				독서 <input type="checkbox" name="hobby" value="reading" > &nbsp;
				영화감상 <input type="checkbox" name="hobby" value="climbing" > &nbsp;
				게임 <input type="checkbox" name="hobby" value="climbing" > &nbsp;
			</td>
		</tr>
		<tr>
			<th>결혼여부</th>
			<td>
				미혼 <input type="radio" name="marital" value="single">&nbsp;
				기혼 <input type="radio" name="marital" value="married">&nbsp;
			</td>
		</tr>
		<tr>
			<th>가입경로</th>
			<td>
				<textarea name="joinpath" rows="7" cols="60"></textarea>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="submit">가입</button>
				<button type="reset">취소</button>
			</th>
		</tr>		
	</table>

	</form>
</div>
</body>
</html>
