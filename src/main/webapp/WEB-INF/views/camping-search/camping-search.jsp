<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="camping-container">
        <div class="camping-item-container camping-item-search-count-container">
            <span>총 <span class="search-count-span">${searchCount }</span>개의 캠핑장이 검색되었습니다.</span>
        </div>
    </div>

	<div class="camping-container">
		<c:forEach var="c" items="${campingSites }">
			<input type="hidden" id="camping-login-id-${c.c_no }" value="${sessionScope.loginAccount.ac_id }">
			<input type="hidden" id="camping-site-id-${c.c_no }" value="${c.c_no }">
			<div class="camping-item-container">
				<div class="camping-item-desc">
					<span class="camping-item-desc-item camping-item-desc-item1">관광사업자
						등록업체</span> <span class="camping-item-desc-item camping-item-desc-item2">리뷰수
						${c.reviewCount }</span> <span class="camping-item-desc-item camping-item-desc-item3">조회수
						${c.siteViewCount }</span> 
						<span class="camping-item-desc-item camping-item-desc-item4">
								<img class="camping-like-img-tag" alt="" src="resources/camping-detail-icon/like.png">
								<span class="camping-like-count camping-like-count-${c.c_no }">${c.siteLikeCount }</span>
						</span>
				</div>

				<div class="camping-item-box-container">
					<div class="camping-item-img-container">
						<img src="${c.c_firstImageUrl }" onerror="this.src='resources/camping-search-img/campingSiteDefaultImg.png'" alt="">
					</div>
					<div class="camping-item-desc2">
						<div class="camping-item-desc2-title camping-item-desc2-header">
								<a href="go.camping.detail?c_no=${c.c_no }">[${c.c_doNm } ${c.c_sigunguNm }] ${c.c_facltNm }</a>
								<c:choose>
									<c:when test="${c.isLiked == 1 }">
										<img onclick="heartClick('${c.c_no }')" class="camping-like-img camping-like-img-${c.c_no }" alt="" src="resources/camping-detail-icon/like.png">
									</c:when>
									<c:otherwise>
										<img onclick="heartClick('${c.c_no}')" class="camping-like-img camping-like-img-${c.c_no }" alt="" src="resources/camping-detail-icon/not-like.png">
									</c:otherwise>
								</c:choose>
								
						</div>
						<div class="camping-item-desc2-title camping-item-desc2-content">
							<a href="go.camping.detail?c_no=${c.c_no }">${c.c_lineIntro }</a>
						</div>
						<div class="camping-item-desc2-title camping-item-desc2-info">
							<img class="camping-item-desc2-title-icon-position"
								src="resources/facilities-icon/position.png" alt=""> <span>${c.c_addr1 }
							</span> <img class="camping-item-desc2-title-icon-phone"
								src="resources/facilities-icon/phoneCall.png" alt=""> <span>${c.c_tel }</span>
						</div>
					</div>
				</div>

				<div class="camping-item-facilities">
					<c:forEach var="f" items="${c.facilities }">
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="${f.image }"
								alt=""> <span>${f.desc }</span>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:forEach>		
	</div>
	
	<div class="camping-custom-btn-container">
		<c:if test="${curPage != 1 }">
			<button class="custom-btn btn-16" onclick="location.href='do.camping.change?p=${curPage - 1}'">이전 페이지</button>
		</c:if>
		<c:if test="${curPage != pageCount }">
			<button class="custom-btn btn-15" onclick="location.href='do.camping.change?p=${curPage + 1}'">다음 페이지</button>
		</c:if>
	</div>
	
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=14fb48386afd214fbe82e4cc27f58743"></script>
	
</body>
</html>