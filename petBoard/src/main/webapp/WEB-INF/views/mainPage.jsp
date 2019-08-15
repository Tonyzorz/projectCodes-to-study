<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>petBoard</title>
	<link href="${pageContext.request.contextPath}/resources/css/petBoard.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/petBoard2.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
   
</head>
<body>

	<%@include file="header.jsp" %>
<!-- 		<div id="myBtnContainer"> -->
<!-- 	  				<button class="btn active" onclick="filterSelection('all')"> Show all</button> -->
<!-- 	  				<button class="btn" onclick="filterSelection('nature')"> 강아지</button> -->
<!-- 	  				<button class="btn" onclick="filterSelection('nature')"> 고양이</button> -->
<!-- 	  				<button class="btn" onclick="filterSelection('cars')"> 파충류</button> -->
<!-- 	 				<button class="btn" onclick="filterSelection('people')"> 공충</button> -->
<!-- 				</div> -->
		<div class="main">
				<div class="row">
			<c:forEach var="ab" items="${aallList}" begin="1" end="10">
				  <div class="column">
				    <div class="content">
				      <a href="aSelectBoard?abNum=${ab.abNum}"><span>
				      <img src="${path}/resources/images/${ab.abPicUrl}" id="picSize"></span>
				      <h4>${ab.abTitle}</h4><br>
				      <span>${ab.abKind }</span>&nbsp&nbsp<span>${ab.abAge }살</span>&nbsp&nbsp<span>성:${ab.abGender }</span><br><span>${ab.abPrice},000원</span></a>
				    </div>
				  </div>
<!-- 				  <table class="column"> -->
<!-- 				  	<tr class="content"> -->
<%-- 				  		<td>${ab.Title }</td> --%>
<!-- 				  	</tr> -->
<!-- 				  	<tr> -->
<%-- 				  		<td>${ab.abKind }</td> --%>
<%-- 				  		<td>${ab.abAge }</td> --%>
<%-- 				  		<td>${ab.abGender }</td> --%>
<!-- 				  	</tr> -->
<!-- 				  </table> -->
			</c:forEach> 
				</div>
				  
				<div id="content2">
					<span id="content2header" onclick="goJMainBoard()">분양일지</span><br>
					<table>
						<colgroup>
							<col width="200px">
							<col width="100px">
							<col width="100px">
							<col width="300px">
						</colgroup>
						<tr>
							<th>제목</th>
							<th>작성자</th>
							<th>작성 시간</th>
							<th>조회수</th>
						</tr>
					<c:forEach var="jb" items="${jallList }">
						<tr>
							<td><c:choose>
									<c:when test="${jb.jbIndent>0 }">
										<a href="jSelectBoard?jbNum=${jb.jbNum }">&nbsp re:${jb.jbTitle }</a>
									</c:when>
									<c:otherwise>
										<a href="jSelectBoard?jbNum=${jb.jbNum }">${jb.jbTitle }</a>
									</c:otherwise>
								</c:choose></td>		
							<td>${jb.jbWriter }</td>		
							<td>${jb.jbDate }</td>		
							<td>${jb.jbHit }</td>		
						<tr>
					</c:forEach>
					</table>
				</div>
		</div>
				
				
				
				
				
			
			
		<div id="footer">
			here lies the footer
		</div>
		

<script>

</script>	
</body>
</html>