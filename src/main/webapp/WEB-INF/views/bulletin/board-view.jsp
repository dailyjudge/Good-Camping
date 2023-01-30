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

<link rel="stylesheet" href="resources/css/board-style.css">
<link rel="stylesheet" href="resources/css/comu-media.css">
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
		</div>
    <div class="board_wrap">
        <div class="board_title">
            <strong>공지사항</strong>
            <p>공지사항을 빠르고 정확하게 안내해드립니다.</p>
        </div>
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">
                    글 제목이 들어갑니다.
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd>1</dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd>김이름</dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd>2021.1.16</dd>
                    </dl>
                    <dl>
                        <dt>조회</dt>
                        <dd>33</dd>
                    </dl>
                </div>
                <div class="cont">
                    글 내용이 들어갑니다<br>
                    글 내용이 들어갑니다<br>
                    글 내용이 들어갑니다<br>
                    글 내용이 들어갑니다<br>
                    글 내용이 들어갑니다<br>
                    글 내용이 들어갑니다<br>
                    글 내용이 들어갑니다<br>
                    글 내용이 들어갑니다
                </div>
            </div>
            <div class="bt_wrap">
                <a href="list.html" class="on">목록</a>
                <a href="edit.html">수정</a>
            </div>
        </div>
    </div>
</body>>
</html>