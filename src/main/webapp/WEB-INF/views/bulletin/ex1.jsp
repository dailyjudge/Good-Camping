<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<!-- 클래식 에디터 -->
	<script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>

<title>Insert title here</title>

	<!-- 넓이 높이 조절 -->
	<style>
	.ck.ck-editor {
    	max-width: 500px;
	}
	.ck-editor__editable {
	    min-height: 300px;
	}
	</style>

</head>
<body>
    <h3>Classic editor</h3>
    <div id="classic">
        <p>This is some sample content.</p>
    </div>
    <script>
        ClassicEditor
            .create( document.querySelector( '#classic' ))
            .catch( error => {
                console.error( error );
            } );
    </script>
</body>
</html>