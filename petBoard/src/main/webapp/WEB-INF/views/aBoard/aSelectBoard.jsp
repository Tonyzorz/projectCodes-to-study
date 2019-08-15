<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aSelectBoard</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		if ($('#abWriter').val() == $('#sessionId').val()) {
			$('#aDeleteBoard').show();
			$('#aModifyView').show();
		} else {
			$('#aDeleteBoard').hide();
			$('#aModifyView').hide();
		}
	});

	$(document).ready(function() {
		if ($('#abcWriter').val() == $('#sessionId').val()) {
			$('#deleteBtn').show();
			$('#modifyBtn').show();
		} else {
			$('#deleteBtn').hide();
			$('#modifyBtn').hide();
		}
	});
	
	$(document).ready(function() {
		document.getElementById("selectBtn").onclick=function(){
			var abNum = document.getElementById("abNum").value;
			$.ajax({
				type:"post",
				url:"aBoardLike",
				data:"abNum="+abNum,
				success:function(result){
					alert(result);
					var currentLike = $("#abLike").text();
					var nn = Number(currentLike)+1;
					$("#abLike").text(nn);
				}
			});
		}
	});
	
</script>

<link
	href="${pageContext.request.contextPath}/resources/css/petBoard.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/petBoard2.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/adoption.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</head>
<body>
	<%@include file="../header.jsp"%>
	<div id="divA">
		<div id="headerA">
			<form action="aModifyView">
				<input type="hidden" id="abWriter" name="abWriter" value="${select.abWriter}" /> 
				<input type="hidden" id="sessionId" value="${sessionScope.userId}" /> 
				<input type="hidden" id="abNum" name="abNum" value="${select.abNum}" />
				<div>
					<label>번호 |</label>
					<td>${select.abNum}</td>&nbsp;&nbsp;&nbsp; <label>제목 |</label>
					<td>${select.abTitle}</td>&nbsp;&nbsp;&nbsp; <label>카테고리 |</label>
					<td>${select.abCategory}</td>&nbsp;&nbsp;&nbsp; <label>작성자
						|</label>
					<td>${select.abWriter}</td>&nbsp;&nbsp;&nbsp; <label>조회수 |</label>
					<td>${select.abHit}</td>&nbsp;&nbsp;&nbsp; <label>추천 |</label>
					<td><span id="abLike">${select.abLike}</span></td>&nbsp;&nbsp;&nbsp; <label>작성일 |</label>
					<td>${select.abDate}</td>&nbsp;&nbsp;&nbsp; <label>품종 |</label>
					<td>${select.abKind}</td>&nbsp;&nbsp;&nbsp; <label>나이 |</label>
					<td>${select.abAge}</td>&nbsp;&nbsp;&nbsp; <label>성별 |</label>
					<td>${select.abGender}</td>&nbsp;&nbsp;&nbsp; <label>분양가 |</label>
					<td>${select.abPrice}</td>
					<br />
				</div>

				<div id="titleBox">
					<span> <img
						src="${path}/resources/images/${select.abPicUrl}" wdith="200" height="200">
					</span> <span>${select.abContent}</span>
				</div>
				<div id="modifyBtn">
					<input type="submit" value="수정" id="aModifyView" />
				</div>
			</form>
			<div id="titleBtn">
				<form action="aDeleteBoard">
					<input type="hidden" id="abNum" name="abNum" value="${select.abNum}" />
					<input type="submit" id="aDeleteBoard" value="글 삭제" />
				</form>
<%-- 				<a href="aBoardLike?abNum=${select.abNum}">추천</a> --%>
					<input type="button" id="selectBtn" value="추천">
				<form action="aMainBoard">
					<input type="submit" id="aMainBoard" value="목록으로" />
				</form>
			</div>
		</div>
	</div>
	<br />
	<br />
	<div id="divA2">
		<div>
				<input type="hidden" id="sessionId" value="${sessionScope.userId}" />
				<c:forEach items="${selectC}" var="sel">
							<input type="hidden" id="abNum" name="abNum" value="${select.abNum}">
					<table id="comment">
						<tr>
							<td width="30%">${sel.abcWriter}</td>
							<br />
							<td width="70%">${sel.abcDate}</td>
							<a href="aDeleteBoardComment?abcNum=${sel.abcNum}" id="deleteBtn">삭제</a>
						</tr>
						<tr>
							<td colspan="2">${sel.abcContent }</td>
						</tr>
					</table>
				</c:forEach>
		</div>
		<div>
			<form action="aWriterBoardComment">
				<input type="hidden" id="abNum" name="abNum" value="${select.abNum}" />
				<input type="hidden" id="abcWriter" name="abcWriter" value="${sessionScope.userId}" readonly="readonly" /> 
				<input type="text" id="abcContent" name="abcContent" style="height:80px; width:800px; "> 
				<input type="submit" value="댓글 작성" />
			</form>
		</div>
	</div>
</body>
</html>