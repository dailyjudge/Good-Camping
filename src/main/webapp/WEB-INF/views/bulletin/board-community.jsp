<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<!-- 			<div class="section">
				<h3>커뮤니티</h3>
				<div id="classic">
					<p>작성 시작</p>
				</div>
			</div> -->
			<div class="board_wrap">
				<div class="board_title">
					<strong>공지사항</strong>
					<p>공지사항을 빠르고 정확하게 안내해드립니다.</p>
					<div>검색<input type="text" ></div>
					<div>
						지역 검색 <select id="whereToSearch" name="'whereToSearch'" onchange="whereSearch();">
							<option selected value="서울특별시">서울특별시</option>
							<option value="인천광역시">인천광역시</option>
							<option value="대전광역시">대전광역시</option>
							<option value="광주광역시">광주광역시</option>
							<option value="대구광역시">대구광역시</option>
							<option value="울산광역시">울산광역시</option>
							<option value="부산광역시">부산광역시</option>
							<option value="경기도">경기도</option>
							<option value="강원도">강원도</option>
							<option value="충청북도">충청북도</option>
							<option value="충청남도">충청남도</option>
							<option value="전라북도">전라북도</option>
							<option value="전라남도">전라남도</option>
							<option value="경상북도">경상북도</option>
							<option value="경상남도">경상남도</option>
							<option value="제주도">제주도</option>
						</select>
					</div>
				</div>
				<div class="board_list_wrap">
					<div class="board_list">
						<div class="top">
							<div class="num">번호</div>
							<div class="title">제목</div>
							<div class="writer">글쓴이</div>
							<div class="date">작성일</div>
							<div class="count">조회</div>
						</div>
						<c:forEach var="c" items="${comus }">
							<div>
								<div class="num">${c.comu_no }</div>
								<div class="title">
									<a href="go.board.view?comu_no=${c.comu_no }">${c.comu_title }</a>
								</div>
								<div class="writer">${c.comu_write_id }</div>
								<div class="date"><fmt:formatDate value="${c.comu_w_time }" type="both" dateStyle="short" timeStyle="short"/></div>
								<div class="count">${c.comu_readcount }</div>
							</div>
						</c:forEach>
					</div>
					<div class="board_page">
						<a href="board.page.change?p=${curPage -1 }" class="bt prev">&lt;</a>
						<a href="board.page.change?p=${curPage}" class="num">${curPage}</a> 
						<a href="board.page.change?p=${curPage +1 }" class="bt next">&gt;</a> 
					</div>
					<div class="bt_wrap">
						<a href="go.board.write" class="on">등록</a>
						<!--<a href="#">수정</a>-->
					</div>
				</div>
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