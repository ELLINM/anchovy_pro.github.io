<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF_8">
<title>Insert title here</title>
	<script>
		funciton check(){
		var userid=document.getElementById("userid");
		var userpwd=document.getElementById("userpwd");

		if(userid.value.length < 3 || userid.value.length < 10){
			alert("ID는 3~10자리로 입력 해주세요");
			return false;
		}
	
		if(userpwd.value.length < 3 || userpwd.value.length < 10){
			alert("PassWord는 3~10자리로 입력 해주세요");
			return false;
		}
	}
</script>
</head>
<body>
	<form>
		아이디 <input type="text" id="userid"><br>
		비밀번호 <input type="password" id="userpwd"><br>
		<input type="submit" onclick="return check()">
	</form>
</body>
</html>
