<!--index1-->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="insertMember" method="post">
	ID : <input type="text" name="userId"><br>
	PW : <input type="password" name="userPw"><br>
	이름 : <input type="text" name="userName"><br>
	주소 : <input type="text" name="userAd"><br>
	<input type="submit" value="전송하기">
</form>

</body>
</html>

<!--index2-->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>



<h1>${userId}님, 환영합니다.</h1>

</body>
</html>
