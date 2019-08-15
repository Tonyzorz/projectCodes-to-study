<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
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
		
	});

})

</script>
<meta charset="UTF-8">
<style type="text/css">
.title, .intitle {
	width: 100%;
}
</style>
<title>분양일지 글쓰기</title>
</head>

<body>
	<form action=jWriterBoard method="post" enctype="multipart/form-data">
		<div class="title">
			제목:<input class="intitle" type="text" name="jbTitle"><br>
		</div>
		<textarea name="jbContent" id="summernote"></textarea>
		<div class="">
			<input width="100%" type="submit" value="글쓰기"><br>
		</div>
	</form>
</body>
</html>