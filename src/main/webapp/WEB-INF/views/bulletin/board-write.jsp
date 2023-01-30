<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/board-comu.css">
<script src="https://kit.fontawesome.com/ece9d84a35.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="resources/css/board-style.css">
<link rel="stylesheet" href="resources/css/comu-media.css">

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

		<div class="board_wrap">
			<div class="board_title">
				<strong>공지사항</strong>
				<p>공지사항을 빠르고 정확하게 안내해드립니다.</p>
			</div>
			<form action="do.upload-board" method="post" enctype="multipart/form-data">
				<div class="board_write_wrap">
					<div class="board_write">
						<div class="title">
							<dl>
								<dt>제목</dt>
								<dd>
									<input type="text" name="comu_title" placeholder="제목 입력">
								</dd>
							</dl>
						</div>
						<div class="info">
							<dl>
								<dt>파일</dt>
								<dd>
									<input type="file" name="comu_file">
								</dd>
							</dl>
						</div>
						<div class="cont">
<!-- 							<div id="classic">
								<p>This is some sample content.</p>
							</div> -->
							<textarea placeholder="내용 입력" name="comu_content">
							</textarea>
						</div>
					</div>
					<div class="bt_wrap">
						<button>등록</button>
						<button type="button" onclick="location.href='go.board.comu'">취소</button>
					</div>
				</div>
			</form>
		</div>

	</div>

	<script>
        ClassicEditor
            .create( document.querySelector( '#classic' ), {
                language: 'ko' //언어설정
            })
            .catch( error => {
                console.error( error );
            } );
   </script>
</body>
</html>