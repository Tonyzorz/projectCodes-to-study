<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="${pageContext.request.contextPath}/resources/css/petBoard.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/petBoard2.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		if ($('#jbWriter').val() == $('#sessionId').val()) {
			$('#update').show();
			$('#delete').show();
		} else {
			$('#update').hide();
			$('#delete').hide();
		}
	});

</script>
<style type="text/css">
.writer {
	background-color: white;
}
.top{
size:100%;
}
.title, .writer, .date, .hit, .like{
border-right: solid;
border-right-width: thin;
border-bottom-width: thin;
}
.title{
width: 500px;}
.writer, .date, .hit, .like{
width: auto;
vertical-align: mid;
}
.bottom{
	overflow: hidden;
	width: 100%;
}

.list {
	float: left;
}

.delete, .update {
	float: right;
}
.content{
width: auto;
}
#official{
margin-left:160px;
}
</style>
<meta charset="UTF-8">
<title>분양일지 게시판</title>

</head>
<body>
	<%@include file="../header.jsp" %>
<!-- 	<div class="title"> -->
<%-- 		<input type="hidden" id="sessionId" value="${sessionScope.userId}"> --%>
<%-- 		<input type="hidden" name="jbNum" value="${select.jbNum}"> 제목:<label>${select.jbTitle}</label>| --%>
<!-- 		작성자<label><input id="jbWriter" type="hidden" name="jbWriter" -->
<%-- 			value="${select.jbWriter}" />${select.jbWriter}</label> | 작성일: <label>${select.jbDate }</label> --%>
<%-- 		| 조회수: <label>${select.jbHit}</label> | 추천: <label>${select.jbLike }</label><br> --%>
<!-- 	</div> -->
<%-- 	<div class="content">${select.jbContent }</div> --%>
	<div id="official">	
		<div><div class="top">
				
				<input type="hidden" id="sessionId" value="${sessionScope.userId}">
				<table class="table" >
					
						<tr> <td class="title" > <label>제목:${select.jbTitle}</label></td>
						<td class="writer"><label><input id="jbWriter" type="hidden" name="jbWriter"value="${select.jbWriter}" />작성자:${select.jbWriter}</label></td> 
						<td class="date"> <label>작성일:${select.jbDate}</label> </td>
						<td class="hit"> <label>조회수:${select.jbHit}</label>  </td>
						<td class="like"> <label>추천:${select.jbLike }</label> </td>
						<td>
					<form action="jLikeBoard" method="post">
						<input type="hidden" name="jbNum" value="${select.jbNum}"> 
						<input type="submit" value="추천">
					</form>
				</td>
				</tr>
				</table>
				</div>
				<div>
					${select.jbContent}
				</div>
			</div>
		<div class="bottom" >
			<div class="list" >
				<form action="jMainBoard" method="get">
					<input type="submit" value="목록">
				</form>
			</div>
			<div class="delete" >
				<form action="jDeleteBoard" method="post">
					<input type="hidden" name="jbNum" value="${select.jbNum}"> <input
						id="delete" type="submit" value="삭제">
				</form>
			</div>
			<div class="update">
				<form action="jModifyView" method="post">
					<input type="hidden" name="jbNum" value="${select.jbNum}"> <input
						id="update" type="submit" value="수정">
				</form>
			</div>
			<div class="reply">
			<form action="jReplyBoard" method = "post" enctype="multipart/form-data">
				<input type="hidden" name="jbNum" value="${select.jbNum}">
				<input type="hidden" name="jbIndent" value="${select.jbIndent}" />
				<input type="hidden" name="jbStep" value="${select.jbStep}" />
				<input type="hidden" name="jbGroup" value="${select.jbGroup}" />
				<input type="submit" name="jbReply" value="답글 달기">
			</form> 
			</div>
		</div>
	</div>
</body>
</html>