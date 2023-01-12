<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="user-like-title-container">
        <span>관심 캠핑장</span>
    </div>
	<!-- camping_like -->
	<div class="user-like-container">
		<c:forEach items="${camping_like }" var="c">
	        <div class="user-like-item user-like-item-${c.c_no }" onclick="location.href='go.camping.detail?c_no=${c.c_no}'">
	            <input class="user-hidden-input-id" type="hidden" value="${sessionScope.loginAccount.ac_id }">
	            <img class="user-hidden-like-item user-hidden-like-item-${c.c_no } user-like-item-like user-like-trash user-like-trash-${c.c_no }" src="resources/camping-like/trash.png">
	        	<input class="user-hidden-input-no" type="hidden" value="${c.c_no }">
	            <img class="user-like-item-img user-like-item-img-${c.c_no }" src="${c.c_firstImageUrl }" alt="">
	            <div class="user-like-item-like-container user-visible-like-item user-visible-like-item-${c.c_no }">
	                <img class="user-like-item-like" src="resources/camping-like/like.png" alt="">
	                <span>${c.siteLikeCount }</span>
	            </div>
	            <span class="user-visible-like-item user-visible-like-item-${c.c_no }">[${c.c_doNm } ${c.c_sigunguNm }]</span>
	            <span  class="user-visible-like-item user-visible-like-item-${c.c_no }">${c.c_facltNm }</span>
	
	            <div class="user-like-item-like-container user-hidden-like-item user-hidden-like-item-${c.c_no }">
	                <img class="user-like-item-like" src="resources/camping-like/star.png" alt="">
	                <span>${c.reviewStarAvg }</span>
	            </div>
	            <span class="user-hidden-like-item user-hidden-like-item-${c.c_no }">${c.siteViewCount }명이 이 캠핑장을 찾아봤어요</span>
	            <div class="user-hidden-tag user-hidden-like-item user-hidden-like-item-${c.c_no }">
	            	<c:forEach items="${c.hashtagList }" var="h">
	            		<button>${h }</button>
	            	</c:forEach>
	            </div>
	        </div>
		</c:forEach>
    </div>
</body>
</html>