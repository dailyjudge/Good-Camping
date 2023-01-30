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
<link rel="stylesheet" href="resources/css/account-button.css">

<script src="resources/js/board.js" ></script>
</head>
<body>
		<div class="top_wrap_main">
			<div class="board_wrap">
				<div class="board_title">
					<strong>공지사항</strong>
					<p>공지사항을 빠르고 정확하게 안내해드립니다.</p>
				
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
</html>