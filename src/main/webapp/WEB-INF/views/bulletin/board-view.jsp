<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	<div class="board_wrap">
		<div class="board_view_wrap">
			<div class="board_view">
				<div class="title">${this_comu_vo.comu_title}</div>
				<div class="info">
					<dl>
						<dt>번호</dt>
						<dd>${this_comu_vo.comu_no}</dd>
					</dl>
					<dl>
						<dt>글쓴이</dt>
						<dd>${this_comu_vo.comu_write_id}</dd>
					</dl>
					<dl>
						<dt>작성일</dt>
						<dd>
							<fmt:formatDate value="${this_comu_vo.comu_w_time}" type="both"
								dateStyle="short" timeStyle="short" />
						</dd>
					</dl>
					<dl>
						<dt>조회</dt>
						<dd>${this_comu_vo.comu_readcount}</dd>
					</dl>
				</div>
				<div class="cont">${this_comu_vo.comu_content}</div>
				<div>
					<img style="width: 200px;" class="board-detail-img-container" src="resources/comu-img/${this_comu_vo.comu_file}">
				</div>
			</div>
			<div class="bt_wrap">
				<a href="go.board.comu" class="on">목록</a> 
				<c:if test="${this_comu_vo.comu_write_id == sessionScope.loginAccount.ac_id }">
					<a href="edit.thisBoard?comu_no=${this_comu_vo.comu_no}">수정</a>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>