<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</head>
<body>
	<form action="signupCheck" method="post" onsubmit="return check()">
		<label id="UserName">User Name</label><br>
		<input type="text" id="userId" name="userId"><br>
		<label id="Password">Password</label><br>
		<input type="text" id="userPw" name="userPw"><br>		<label id="email">Email</label><br>
		<input type="text" id="userEmail" name="userEmail" ><br>
		<label id="PhoneNum">Phone Number</label><br>
		<input type="text" id="userPhoneNum" name="userPhoneNum" size="11"><br>
		<input type="submit" value="Sign Up"><br>
	</form>
</body>
</html>