<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Test</title>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	$(function(){
		$('#btn1').on('click', test1);
		$('#btn2').on('click', test2);
	});
	
	function test1(){
		$.ajax({
			url:"test1",
			type:"get",
			gata:{"id": "testid", "name": "testname"},
			success: function() {alert("Success")},
			error: function() {alert("Error")}
		});
	}
		
	function test2(){
			$.ajax({
				url:"test2",
				type:"post",
				gata:{"id": "testid", "name": "testname"},
				success: function() {alert("Success")},
				error: function() {alert("Error")}
			});
	}
</script>
</head>
<body>

	<input type="button" id="btn1" value="test1"><br>
	<input type="button" id="btn2" value="test2"><br>

</body>
</html>
