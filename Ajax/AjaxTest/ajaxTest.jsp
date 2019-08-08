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
		$('#btn3').on('click', test3);
		$('#btn4').on('click', test4);
		$('#btn5').on('click', test5);
		$('#btn6').on('click', test6);
		$('#btn7').on('click', test7);
		$('#btn8').on('click', test8);
	});
	
	function test1(){
		$.ajax({
			url:"test1",
			type:"get",
			data:{"id": "testid", "name": "testname"},
			success: function() {alert("Success")},
			error: function() {alert("Error")}
		});
	}
		

	function test2() {
		$.ajax({
			url : "test2",
			type : "post",
			data : {"id" : "testid", "name" : "testname"},
			success : function() {alert("Success")},
			error : function() {alert("Error")}
		});
	}

	function test3() {
		$.ajax({
			url : "test3",
			type : "post",
			contentType : "application/json; charset=utf-8",
			//서버에 전송되는 데이터 타입을 json 으로 명시
			data : JSON.stringify({
			//JSON.stringify() 로 object 를 JSON 문자열로 변환 
				"id" : "아이디1",
				"name" : "이름1"
			}),
			//JSON.stringify() 는 javascript 의 데이터를 JSON 문자열로 변환
			//JSON.stringify() 를 이용하여 서버에 데이터를 전송할 경우, POST 방식을 이용
			success : function() {alert("Success")},
			error : function() {alert("Error")}
		});
	}

	function test4() {
		$.ajax({
			url : "test4",
			type : "post",
			data : $("#test4").serialize(),
			///test/test4?id=아이디&name=이름 형식으로 서버에 전송됨
			success : function() {alert("Success")},
			error : function() {alert("Error")}
		});
		//form 태그 내부에 선언된 요소들을 한 번에 서버로 보낼 때 유용
		//파일을 서버에 보낼 경우, FormData 를 사용(파일전송 슬라이드 참조)

	}
	
	var temp;
	function test5(){
		$.ajax({
			url : "test5",
			type : "post",
			dataType: "json",
			success : function(result){
			//서버로부터의  반환 데이터를 매개변수 result 에 전달
				$(result).each(function(index, item){
					$("#here").append("<tr><td>" + item.id + "</td><td>" + item.name + "</td></tr>")
				})
			},
			error : function() {alert("Error")}
		});
	}
	
	function test6(){
		$.ajax({
			url : "test6",
			type : "post",
			contentType : "application/json; charset=utf-8",
			//서버에 전송되는 데이터 타입을json 으로 명시
			data: JSON.stringify([1, 'a', 'haha']),
			//JSON.stringify() 로 Array 를 JSON 문자열로 변환 
			success : function(result){
				$(result).each(function(index, item){
					$("#here").append("<tr><td>" + item.id + "</td><td>" + item.name + "</td></tr>")
				});
			},
			error : function() {alert("Error")}
		});
	}
	
	function test7(){
		$.ajax({
			url : "test7",
			type : "post",
			dataType: "json",
			success : function(result){
				$("#li").append("<tr><td>" + result.id + "</td><td>" + result.name + "</td></tr>");
			},
			error : function() {alert("Error")}
		});
	}
	
	function test8(){
		$.ajax({
			url : "test8",
			type : "post",
			dataType: "json",
			success : function(result){
				$(result).each(function(index, item){
					$("#li").append("<tr><td>" + item.id + "</td><td>" + item.name + "</td></tr>")
				});
			},
			error : function() {alert("Error")}
		});
	}
</script>
</head>
<body>

	<form id="test4">
		ID: <input type="text" name="id"><br>
		NAME: <input type="text" name="name"><br>
	</form>

	<input type="button" id="btn1" value="test1"><br>
	<input type="button" id="btn2" value="test2"><br>
	<input type="button" id="btn3" value="test3"><br>
	<input type="button" id="btn4" value="test4"><br>
	<input type="button" id="btn5" value="test5"><br>
	<input type="button" id="btn6" value="test6"><br>
	<input type="button" id="btn7" value="test7"><br>
	<input type="button" id="btn8" value="test8"><br>
	
	<div>
		<table id="here">
			<tr>
				<th>ID</th>				
				<th>NAME</th>
			</tr>						
		</table>
	</div>
	<div>
		<table id="li">
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
		</table>
	</div>
</body>
</html>
