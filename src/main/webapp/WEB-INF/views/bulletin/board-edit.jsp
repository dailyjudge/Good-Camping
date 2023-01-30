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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/board-style.css">
<link rel="stylesheet" href="resources/css/comu-media.css">

<script src="resources/js/board.js" ></script>
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
   <form action="do.edit.thisBoard" method="post" enctype="multipart/form-data">
        <div class="board_write_wrap">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input type="text" name="comu_title" placeholder="${this_comu_vo.comu_title}" ></dd>
                        <dd><input type="hidden" name="comu_no" value="${this_comu_vo.comu_no}"/></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt>파일</dt>
                        <dd><input type="file" name="comu_file">${this_comu_vo.comu_file}</dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea placeholder="내용 입력" name="comu_content">
						${this_comu_vo.comu_content}
					</textarea>
                </div>
            </div>
            <div class="bt_wrap">
                <button>수정</button>
                <button type="button" onclick='history.back(-1);'>취소</button>
            </div>
        </div>
        </form>
    </div>
</body>
</html>