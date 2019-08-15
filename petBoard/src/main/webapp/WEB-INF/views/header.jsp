<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	$(function(){
		$("#title").click(function(){
			location.href="<c:url value='/'/>"
		});
	});
</script>
<body>
	${sessionScope.userId}<br>
	<input type="hidden" id="sessionId" value="${sessionScope.userId}">
	<div id="header">
			<label id="title">강아지분양할고양고양</label>
			<div id="userButton">
				<span id="loginPart"><input type="button" class="button" id="login" onclick="goLogin()" value="login"></span>
				<span id="logoutPart"><input type="button" class="button" onclick="goLogout()" value="logout" id="logout"></span>
				<span id="signUp"><input type="button" class="button" onclick="goSignup()" value="signup" id="signup"></span>
			</div>
		</div>
		<div id="wrap">
			<div class="sidenav">
				<span><a href="aMainBoard">분양게시판</a></span>
					<a href="aCategoryBoardSelect?abCategory=강아지">강아지</a>
					<a href="aCategoryBoardSelect?abCategory=고양이">고양이</a>
					<a href="aCategoryBoardSelect?abCategory=파충류">파충류</a>
					<a href="aCategoryBoardSelect?abCategory=곤충">곤충</a>
				<span><a href="jMainBoard">분양일지</a></span>
			</div>
			
		</div>
</body>
</html>