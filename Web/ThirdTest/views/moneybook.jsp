<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 가계부</title>
<style>
	.default_flex {
		display: flex;
	}
	
	.default_center {
		text-align: center;
	}
	
	.default_inlineBlock {
		display: block;
	}
	
	.width_top {
		width: 200px;
	}
	
	.width_table_1 {
		width: 300px;
	}
	
	.width_table_2 {
		width: 100px;
	}
</style>
<script src='<c:url value="/js/jquery-3.4.1.js" />'></script>
<script>
	function loadInfo(){
		var inputdate = document.getElementById("inputdate");
		var contentTable = document.getElementById("contentTable");
		
		$.ajax({
			"url" : "/moneybook/note/getInfo",
			"type" : "get",
			"data" : {
				"date" : inputdate.value
			},
			"success" : function (result){
				contentTable.innerHTML = "";
				contentTable.innerHTML
					+= "<tr>"
					 + "<th class='width_table_1'>메모</th>"
					 + "<th class='width_table_1'>금액</th>"
					 + "<th class='width_table_2'>삭제</th>"
					 + "</tr>";
					 
				$(reult).each(function (index, item){
					contentTable.innerHTML
						+= "<tr>"
						 + "<th class='width_table_1'>" + item.memo + "</th>"
						 + "<th class='width_table_1'>" + item.amount + "</th>"
						 + "<th class='width_table_2'>"
						 + "<input type='radio' id='deleteRadio' class='radioClass' name='deleteRadio' formaction='deleteRadioForm' value=" + item.infonum + ">"
						 + "</th>"
						 + "</tr>";
				});
			},
			"error" : function () {
				
			}
		});
	}
	
	function registerInfo(){
		var userid = document.getElementById("userid");
		var type = document.getElementById("type");
		var inputdate = document.getElementById("inputdate");
		var memo = document.getElementById("memo");
		var amount = document.getElementById("amount");
		
		if(inputdate.value === ''){
			alert("날짜를 입력하세요.");
			return;
		}
		
		if(memo.value.length === 0){
			alert("메모를 입력하세요.");
			return;
		}
		
		if(amount.value.length === 0){
			alert("금액을 입력하세요.");
			return;
		}
		
		if(isNaN(amount.value)){
			alert("숫자를 입력하세요.");
			return;
		}
		
		$.ajax({
			"url" : "/moneybook/note/registerInfo",
			"type" : "post",
			"data" : {
				"userid" : userid.value,
				"memo" : memo.value,
				"type" : type.value,
				"amunt" : amount.value,
				"inputdate" : inputdate.value
			},
			"success" : function(reult){
				var contentTable = document.getElementById("contentTable");
				
				contentTable.innerHTML = "";
				contentTable.innerHTML
					+= "<tr>"
					 + "<th class='width_table_1'>메모</th>"
					 + "<th class='width_table_1'>금액</th>"
					 + "<th class='width_table_2'>삭제</th>"
					 + "</tr>";
					 
				$(result).each(function(index, item){
					contentTable.innerHTML
						+= "<tr>"
						 + "<th class='width_table_1'>" + item.memo + "</th>"
						 + "<th class='width_table_1'>" + item.amount + "</th>"
						 + "<th class='width_table_2'>"
						 + "<input type='radio' id='deleteRadio' class='radioClass' name='delteRadio' formaction='deleteRadioForm' value" + item.infonum + ">"
						 + "</th>"
						 + "</tr>";
				});
			},
			"error" : function(){
				
			}
		});
	}
	
	function deleteInfo(){
		var radios = document.getElementsByClassName("radioClass");
		var radio;
		var isSelected = false;
		for (var i=0; i<radios.length; i++) {
			if (radio[i].checked === true) {
				radio = radios[i];
				isSelected = true;
				break;
			}
		}
		
		if (isSelected === false) {
			alert("삭제할 항목을 선택해 주세요.");
			return;
		}
		
		var inputdate = document.getElementById("inputdate");
		
		$.ajax({
			"url" : "/moneybook/note/deleteInfo",
			"type" : "get",
			"data" : {
				"inform" : radio.value,
				"inputdate" : inputdate.value
			},
			"success" : function (result) {
				radio.parentNode.parentNode.remove();
			},
			"error" : function(){
				
			}
		});
	}
	
</script>
</head>
<body>
	<input type="hidden" id="userid" value="${sessionScope.userid}">
	<div>
		<div class="default_flex">
			<select id="type">
				<option>수입</option>
				<option>지출</option>
			</select>
			
			<input type="date" id="inputdate" oninput="loadInfo()">
		</div>
		<div>
			<div class="default_flex">
				<div class="default_center width_top">
					<h2>메모</h2>
				</div>
				<div class="default_center width_top">
					<h2>금액</h2>
				</div>
			</div>
			<div class="default_flex">
				<div class="default_center width_top">
					<input type="text" id="memo" placeholder="내용입력">
				</div>
				<input type="button" id="registerBtn" value="등록" onclick="registerInfo()">
				<input type="button" id="deleteBtn" value="삭제" onclick="deleteInfo()">
			</div>
		</div>
		<table id="contentTable">
			<tr>
				<th class="width_table_1">메모</th>
				<th class="width_table_1">금액</th>
				<th class="width_table_2">삭제</th>
			</tr>
		</table>
	</div>
</body>
</html>
