<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분양일지 게시판</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>

<style type="text/css">
.mainTable{width:100%; margin:0 auto; }
.table{width:100%;}
.WriteBtn{overflow: hidden;width:100%;}
.WriteBtn > input{float: right;}
#divJ{margin-left: 150px;}
</style>
<link href="${pageContext.request.contextPath}/resources/css/petBoard.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/petBoard2.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</head>
<style>
th{
text-align: center;
background-color: silver;
}.num, .writer, .date, .hit, .like{
text-align: center;
}.date{
width: 200px;
}.num,.hit, .like{
width: 40px;
}
.writer{
width: 90px;
}
#title{
padding: 5px;
}
</style>
<body>
	<%@include file="../header.jsp" %>
	<div id="divJ">
		<div class="mainTable" >
			
			<form action="jWriterView" method="post">
			<div class="WriteBtn" >
				<input  type="submit" value="글쓰기">
			</div>
				</form>
		<table class="table" border="1" >
				<thead>
					<tr>
						<th>번호</th>	<th>제목</th>	<th>작성자</th><th>작성일</th>
						<th>조회수</th><th>추천</th>
					</tr>			
				</thead>
				<tbody>
				<c:forEach var="jb" items="${allList}">
				<tr>
					<td>${jb.jbNum }<a href="#"></a></td>
					
					
<%-- 					<td ><a href="jSelectBoard?jbNum=${jb.jbNum }" > ${jb.jbTitle }</a></td> --%>
					<td id="title"><c:forEach begin="1" end="${jb.jbIndent }">&nbsp;</c:forEach>
						<c:choose>
							<c:when test="${jb.jbIndent>0 }">
								<a href="jSelectBoard?jbNum=${jb.jbNum }">re:${jb.jbTitle }</a>
							</c:when>
							<c:otherwise>
								<a href="jSelectBoard?jbNum=${jb.jbNum }">${jb.jbTitle }</a>
							</c:otherwise>
						</c:choose>
					
					</td>
					
					<td id="writer">${jb.jbWriter }</td>
					<td>${jb.jbDate }</td>	
					<td>${jb.jbHit }</td>	
					<td>${jb.jbLike }</td>	
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>