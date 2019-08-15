<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> aMainBoard </title>
	<link href="${pageContext.request.contextPath}/resources/css/petBoard.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/petBoard2.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
<script type="text/javascript">
	$(
		function(){
		$("#aWriterView").click(function(){
			location.href="<c:url value='aWriterView'/>"
		});	
	});
</script>
<style>
#aMain{
	margin-left:150px;
	overflow:hidden;
	max-width:1300px;
}
#aMain #aBlock{
	float: left;
	width: 23%;
}
#aMain #aBlock #aContent{
	background-color: white;
	padding: 35px;
	border: 3px;
	margin:20px 20px 20px 20px;
	list-style-type: none;
}
#aWriterView{
	float:right;
}
#aPicSize{
	width:200px;
	height:200px;
}
</style>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div id="aMain">
		<input type="button" id="aWriterView" value="글쓰기" />
		
			
				
		<c:forEach var="ab" items="${allList}">
			<div id="aBlock">	
					<div id="aContent">
						<input type="hidden" name="abcRef" value="${ab.abNum}" />
						<input type="hidden" name="abcWriter" value="${ab.abWriter}" />
							<img src="${path}/resources/images/${ab.abPicUrl}" id="aPicSize" ></span>
							<li><a href="aSelectBoard?abNum=${ab.abNum}">${ab.abTitle }</a></li>
							<li>조회수:${ab.abHit }</li>
							<li>추천수[${ab.abLike }]</li>
							<li>종류: ${ab.abCategory}</li>
							<li>작성자: ${ab.abWriter }</li>
							<li>성: ${ab.abGender }&nbsp&nbsp${ab.abAge }살</li>
							<li>${ab.abPrice },000원</li>
					</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>