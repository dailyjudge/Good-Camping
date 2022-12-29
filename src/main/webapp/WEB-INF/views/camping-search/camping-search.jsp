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
		<c:forEach var="c" items="${campingSites }">
			<div class="camping-item-container">
				<div class="camping-item-desc">
					<span class="camping-item-desc-item camping-item-desc-item1">관광사업자
						등록업체</span> <span class="camping-item-desc-item camping-item-desc-item2">리뷰수
						0</span> <span class="camping-item-desc-item camping-item-desc-item3">조회수
						20557</span> <span class="camping-item-desc-item camping-item-desc-item4">추천수
						2</span>
				</div>

				<div class="camping-item-box-container">
					<div class="camping-item-img-container">
						<img src="${c.c_firstImageUrl }" alt="">
					</div>
					<div class="camping-item-desc2">
						<div class="camping-item-desc2-title camping-item-desc2-header">
							<a>[${c.c_doNm } ${c.c_sigunguNm }] ${c.c_facltNm }</a>
						</div>
						<div class="camping-item-desc2-title camping-item-desc2-content">
							<a>${c.c_lineIntro }</a>
						</div>
						<div class="camping-item-desc2-title camping-item-desc2-info">
							<img class="camping-item-desc2-title-icon-position"
								src="resources/facilities-icon/position.png" alt=""> <span>${c.c_addr1 }
							</span> <img class="camping-item-desc2-title-icon-phone"
								src="resources/facilities-icon/phoneCall.png" alt=""> <span>${c.c_tel }</span>

							<img class="camping-item-desc2-title-icon-phone"
								src="resources/facilities-icon/map.png" alt=""> <span
								onclick="showCampingSiteView()">지도로 보기 </span> <input
								type="hidden" id="mapX" value="${c.c_mapX }"> <input
								type="hidden" id="mapY" value="${c.c_mapY }">
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