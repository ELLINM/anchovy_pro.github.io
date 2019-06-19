<!--signup-->

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

	<form action="frontAction" method="post">
		<h2>회원 가입</h2>
			<p>
			<label for="Email" class="floatLabel">ID : </label>
			<input id="Email" name="userId" value="${userID} type="text">
			<br><font color="red">${message}</font>
			</p>
			<p>
			<label for="password" class="floatLabel">PW : </label>
			<input id="password" name="userPw" value="${userID}" type="password">
			</p>
			<p>
			<input type="submit" value="회원가입" id="submit">
			</p>
	<script>
			//Problem: Hints are shown even when form is valid
			//Solution: Hide and show them at appropriate times
			var $password = $("#password");
			var $confirmPassword = $("#confirm_password");

			//Hide hints
			$("form span").hide();

			function isPasswordValid() {
  				return $password.val().length > 8;
			}

			function arePasswordsMatching() {
  				return $password.val() === $confirmPassword.val();
			}

			function canSubmit() {
  				return isPasswordValid() && arePasswordsMatching();
			}

			function passwordEvent(){
   				 //Find out if password is valid  
  				  if(isPasswordValid()) {
     			 //Hide hint if valid
    			  $password.next().hide();
 			   } else {
 			     //else show hint
 			     $password.next().show();
   				 }
			}

			function confirmPasswordEvent() {
  			//Find out if password and confirmation match
  				if(arePasswordsMatching()) {
    				//Hide hint if match
    				$confirmPassword.next().hide();
 			 	} else {
   					 //else show hint 
   				 	$confirmPassword.next().show();
  					}
			}

			function enableSubmitEvent() {
  				$("#submit").prop("disabled", !canSubmit());
			}

			//When event happens on password input
			$password.focus(passwordEvent).keyup(passwordEvent).keyup(confirmPasswordEvent).keyup(enableSubmitEvent);

			//When event happens on confirmation input
			$confirmPassword.focus(confirmPasswordEvent).keyup(confirmPasswordEvent).keyup(enableSubmitEvent);

			enableSubmitEvent();
		</script>
	</form>

</body>
</html>


<!--Login-->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="frontAction" method="post">
		<h2>로그인하기</h2>
			<p>
			<label for="Email" class="floatLabel">ID</label>
			<input id="Email" name="userId" value="${userID} type="text">
			<br><font color="red"></font>
			</p>
			<p>
			<label for="password" class="floatLabel">PW</label>
			<input id="password" name="userPw" value="${userID}" type="password">
			</p>
			<p>
			<input type="submit" value="회원가입" id="submit">
			</p>
	<script>
			//Problem: Hints are shown even when form is valid
			//Solution: Hide and show them at appropriate times
			var $password = $("#password");
			var $confirmPassword = $("#confirm_password");

			//Hide hints
			$("form span").hide();

			function isPasswordValid() {
  				return $password.val().length > 8;
			}

			function arePasswordsMatching() {
  				return $password.val() === $confirmPassword.val();
			}

			function canSubmit() {
  				return isPasswordValid() && arePasswordsMatching();
			}

			function passwordEvent(){
   				 //Find out if password is valid  
  				  if(isPasswordValid()) {
     			 //Hide hint if valid
    			  $password.next().hide();
 			   } else {
 			     //else show hint
 			     $password.next().show();
   				 }
			}

			function confirmPasswordEvent() {
  			//Find out if password and confirmation match
  				if(arePasswordsMatching()) {
    				//Hide hint if match
    				$confirmPassword.next().hide();
 			 	} else {
   					 //else show hint 
   				 	$confirmPassword.next().show();
  					}
			}

			function enableSubmitEvent() {
  				$("#submit").prop("disabled", !canSubmit());
			}

			//When event happens on password input
			$password.focus(passwordEvent).keyup(passwordEvent).keyup(confirmPasswordEvent).keyup(enableSubmitEvent);

			//When event happens on confirmation input
			$confirmPassword.focus(confirmPasswordEvent).keyup(confirmPasswordEvent).keyup(enableSubmitEvent);

			enableSubmitEvent();
		</script>
	</form>


</body>
</html>


<!--index-->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

 <a href="signup.jsp">회원가입하기</button>

</body>
</html>

