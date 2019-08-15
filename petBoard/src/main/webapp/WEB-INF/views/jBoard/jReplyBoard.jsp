<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="${pageContext.request.contextPath}/resources/css/petBoard.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/petBoard2.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    <link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<link href="resources/editor/dist/summernote.css" rel="stylesheet">
<script src="resources/editor/dist/summernote.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#summernote').summernote({
		height: 600,
		fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
		fontNamesIgnoreCheck : [ '맑은고딕' ],
		focus: true,
		
		callbacks: {
			onImageUpload: function(files, editor, welEditable) {
	            for (var i = files.length - 1; i >= 0; i--) {
	            	sendFile(files[i], this);
	            }
	        }
		}
		
	});

})

function sendFile(file, el) {
	var form_data = new FormData();
  	form_data.append('file', file);
  	$.ajax({
    	data: form_data,
    	type: "POST",
    	url: '/fileUpload',
    	cache: false,
    	contentType: false,
    	enctype: 'multipart/form-data',
    	processData: false,
    	success: function(img_name) {
      		$(el).summernote('editor.insertImage', img_name);
    	}
  	});
}
</script>
</head>
<style>
#official{
	margin-left:160px;
}
</style>
<body>

<%@include file="../header.jsp" %>
<div id="official">
	<form action="jReplyBoardReply" method="post" enctype="multipart/form-data">
		<div>
			<input type="file" name="files" id="files">
		</div>
		<input type="hidden" name="jbNum" value="${select.jbNum}" />
		<input type="hidden" name="jbStep" value="${select.jbStep}" />
		<input type="hidden" name="jbIndent" value="${select.jbIndent}" />
		<input type="hidden" name="jbGroup" value="${select.jbGroup}" />
			제목:<input class="intitle" type="text" name="jbTitle"><br>
		<textarea name="jbContent" id="summernote"></textarea>
			<input type="submit" value="답글 달기">
	</form>
</div>
</body>
</html>