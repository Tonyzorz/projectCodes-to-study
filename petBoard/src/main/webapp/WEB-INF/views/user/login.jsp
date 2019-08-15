<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>로그인</title>
	<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</head>
<body>
<div id="loginMain">

	<form action="loginCheck" method="post">
		<label id="UserName">User Name</label><br>
		<input type="text" name="userId"><br>
		<label id="Password">Password</label><br>
		<input type="password" name="userPw"><br>
		<input type="submit" value="login"><br>
	</form>
	<p class="createAccount">New User?<a href="signup">Create an account</a></p>
</div>
</body>
</html>