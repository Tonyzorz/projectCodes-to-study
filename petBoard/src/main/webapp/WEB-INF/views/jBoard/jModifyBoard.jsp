<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분양일지 글쓰기</title>
<link href="${pageContext.request.contextPath}/resources/css/petBoard.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/petBoard2.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
    
    <!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<link href="/editor/dist/summernote.css" rel="stylesheet">
<script src="/editor/dist/summernote.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#summernote').summernote({
		height: 600,
		fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
		fontNamesIgnoreCheck : [ '맑은고딕' ],
		focus: true,
		
		
	});

})


</script>

<style type="text/css">
.title {
	width: 90%;
}

.top {
	size: 100%;
}
</style>


</head>
<body>
	
	<form action="jModifyBoard" method="post" enctype="multipart/form-data">
				<input type="hidden" name="jbNum" value="${modify.jbNum }">
			<div>
			<div class="top">
				제목:<input class="title" type="text" name="jbTitle" value="${modify.jbTitle }">
			</div>
				내용<br> <textarea name="jbContent" id="summernote">${modify.jbContent}</textarea>
			</div>
			<input type="submit" value="완료">
	</form>
	
</body>
</html>