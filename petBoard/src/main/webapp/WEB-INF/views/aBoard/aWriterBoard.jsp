<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> aWriterView</title>
<link href="${pageContext.request.contextPath}/resources/css/petBoard.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/petBoard2.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    
    
		<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

		<!-- include summernote css/js -->
		<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
		<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
		<link href="resources/editor/dist/summernote.css" rel="stylesheet">
		<script src="resources/editor/dist/summernote.js"></script>
		<script>
			$(function() {
				$('#summernote').summernote({
					height : 600,
					fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
					fontNamesIgnoreCheck : [ '맑은고딕' ],
					focus : true,
					});
				})
		</script>    
</head>
<body>
	<%@include file="../header.jsp" %>
	<div id="divA">
		<form action="aWriterBoard" method="post" enctype="multipart/form-data">
		<div>
			<input type="file" name="files" id="files">
		</div>
		<div>
			<select id="abCategory" name="abCategory">
				<option value="강아지">강아지</option>
				<option value="고양이">고양이</option>
				<option value="파충류">파충류</option>
				<option value="곤충">곤충</option>
			</select>
		</div>
		<div>
			<input type="text" name="abTitle" id="abTitle" placeholder="제목을 입력해 주세요"/><br />
			<input type="text" name="abKind" id="abKind" placeholder="품종" />
			<input type="text" name="abAge" id="abAge" placeholder="나이" />
			<input type="text" name="abGender" id="abGender" placeholder="성별" />
			<input type="text" name="abPrice" id="abPrice" placeholder="분양가" />
		</div>
		<div>
			<textarea name="abContent" id="summernote"></textarea>
		</div>
			<input type="submit" value="등록" >
		</form>
		
	</div>
</body>
</html>