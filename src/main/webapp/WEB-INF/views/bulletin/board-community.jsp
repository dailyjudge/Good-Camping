<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/board-comu.css">
<script src="https://kit.fontawesome.com/ece9d84a35.js"
	crossorigin="anonymous"></script>
<!-- 넓이 높이 조절 -->
<style>
.ck.ck-editor {
	max-width: 600px;
	margin: auto;
}

.ck-editor__editable {
	min-height: 500px;
}
</style>

<!-- 클래식 에디터 -->
<script
	src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>

</head>
<body>

	<div id="board-top-wrap">
		<nav id="start-left-board">
			<ul>
				<li onclick="location.href='go.Bulletin.Main'">
					<div class="home-icon col-dif">
						<img class="nav-img" src="resources/board-img/weather.png">
					</div>
				</li>
				<li>
					<div class="about-icon">
						<img class="nav-img" src="resources/board-img/mail.png">
					</div>
				</li>
				<li>
					<div class="work-icon col-dif">
						<img class="nav-img" src="resources/board-img/money.png">
					</div>
				</li>
				<li onclick="location.href='go.board.comu'">
					<div class="mail-icon">
						<img class="nav-img" src="resources/board-img/comu.png">
					</div>
				</li>
			</ul>
		</nav>

		<div class="top_wrap_main">
			<div class="section2" style="border: 1px solid red;">
				<!--include 예정-->
			</div>
			<div class="section">
				<h3>커뮤니티</h3>
				<div id="classic">
					<p>작성 시작</p>
				</div>
				<div class="opje" style="border: 1px solid red;"></div>
			</div>

		</div>
	</div>
</body>
<script>
        ClassicEditor
            .create( document.querySelector( '#classic' ))
            .catch( error => {
                console.error( error );
            } );
    </script>
</html>