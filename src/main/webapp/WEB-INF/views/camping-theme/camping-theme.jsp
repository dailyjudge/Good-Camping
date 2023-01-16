<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="camping-choice-main-container">
			<div class="camping-choice-container">

				<form class="camping-choice-toggle">
					
					<input type="radio" id="choice1" name="choice" value="creative">
					<label for="choice1">테마로 검색</label> <input type="radio"
						id="choice2" name="choice" value="productive"> <label
						for="choice2">지도로 검색</label>

					<div id="flap">
						<span class="camping-choice-content"></span>
						<input id="option-value" type="hidden" value="theme">
					</div>

				</form>

			</div>
	</div>
		
	<div class="camping-search-theme-main-container">
		<div class="theme-container">테마를 선택해주세요</div>

		<div class="theme-container theme-category-container">
			<span class="theme-category-span">자연환경</span>
			<div class="theme-items-container">
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/valley.png" alt=""> <span>계곡</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/sea.png" alt=""> <span>바다</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/mountain.png" alt=""> <span>산</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/river.png" alt=""> <span>강변</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/tree.png" alt=""> <span>자연휴양림</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/fishing.png" alt=""> <span>낚시터</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/park.png" alt=""> <span>국립공원</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/amuse.png" alt=""> <span>유원지</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/park2.png" alt=""> <span>공원</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/lake.png" alt=""> <span>호수</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/ski.png" alt=""> <span>스키장</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/nature/golf.png" alt=""> <span>골프장</span>
				</div>
			</div>
		</div>

		<div class="theme-container theme-category-container">
			<span class="theme-category-span">편의시설 및 환경</span>
			<div class="theme-items-container">
				<div class="theme-item-container">
					<img src="resources/theme-icon/facilities/market.png" alt="">
					<span>매점</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/facilities/pet.png" alt=""> <span>반려동물</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/facilities/wifi.png" alt=""> <span>와이파이</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/facilities/firewood.png" alt="">
					<span>장작판매</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/facilities/shower.png" alt="">
					<span>샤워시설</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/facilities/elec.png" alt=""> <span>전기</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/facilities/hotwater.png" alt="">
					<span>온수제공</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/facilities/sauna.png" alt="">
					<span>찜질방</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/facilities/library.png" alt="">
					<span>도서관</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/facilities/cafe.png" alt=""> <span>카페</span>
				</div>
			</div>
		</div>
		<div class="theme-container theme-category-container">
			<span class="theme-category-span">즐길거리</span>
			<div class="theme-items-container">
				<div class="theme-item-container">
					<img src="resources/theme-icon/program/fishing.png" alt=""> <span>낚시</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/program/pool.png" alt=""> <span>수영장</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/program/water_party.png" alt="">
					<span>물놀이</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/program/exercise.png" alt="">
					<span>체육시설</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/program/sing.png" alt=""> <span>노래방</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/program/leisure.png" alt=""> <span>수상레저</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/program/atv.png" alt=""> <span>ATV</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/program/sled.png" alt=""> <span>썰매장</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/program/riding.png" alt=""> <span>승마</span>
				</div>
				<div class="theme-item-container">
					<img src="resources/theme-icon/program/billiards.png" alt="">
					<span>당구장</span>
				</div>
			</div>
		</div>
		<div class="theme-btn-container">
			<button class="theme-btn">테마 검색</button>
		</div>
	</div>

	<!-- 지도로 찾기 -->
	<div class="camping-search-map-main-container">
		
		<div class="camping-search-map-title-container">
			<span class="camping-search-desc">지도에서 영역을 선택해주세요.</span>
			<div class="sticky-container">
				<div class="toggle-button-cover">
					<div class="button-cover">
						<div class="button-map b2" id="button-16">
							<input id="visible-input" type="hidden" value="view"> <input
								type="checkbox" class="checkbox" />
							<div class="knobs"></div>
							<div class="layer"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="camping-search-map-container">
			<div class="map-canvas-container">
				<div id="canvas">
					<div id="south"></div>
					<div id="seoul">
						<span>서울특별시</span>
					</div>
					<div id="gygg">
						<span>경기도</span>
					</div>
					<div id="incheon">
						<span>인천광역시</span>
					</div>
					<div id="gangwon">
						<span>강원도</span>
					</div>
					<div id="chungbuk">
						<span>충청북도</span>
					</div>
					<div id="chungnam">
						<span>충청남도</span>
					</div>
					<div id="daejeon">
						<span>대전광역시</span>
					</div>
					<div id="sejong">
						<span>세종특별자치시</span>
					</div>
					<div id="gwangju">
						<span>광주광역시</span>
					</div>
					<div id="jeonbuk">
						<span>전라북도</span>
					</div>
					<div id="jeonnam">
						<span>전라남도</span>
					</div>
					<div id="gyeongbuk">
						<span>경상북도</span>
					</div>
					<div id="gyeongnam">
						<span>경상남도</span>
					</div>
					<div id="daegu">
						<span>대구광역시</span>
					</div>
					<div id="busan">
						<span>부산광역시</span>
					</div>
					<div id="ulsan">
						<span>울산광역시</span>
					</div>
					<div id="jeju">
						<span>제주특별자치도</span>
					</div>
				</div>
			</div>
			<div class="camping-container">
				<div class="camping-item-container">
					<div class="camping-item-desc">
						<span class="camping-item-desc-item camping-item-desc-item1">관광사업자
							등록업체</span> <span class="camping-item-desc-item camping-item-desc-item2">리뷰수
							0</span> <span class="camping-item-desc-item camping-item-desc-item3">조회수
							0</span> <span class="camping-item-desc-item camping-item-desc-item4">
							<img class="camping-like-img-tag" alt=""
							src="resources/camping-detail-icon/like.png"> <span
							class="camping-like-count camping-like-count-${c.c_no }">0</span>
						</span>
					</div>

					<div class="camping-item-box-container">
						<div class="camping-item-img-container">
							<img
								src="https://www.gocamping.or.kr/upload/camp/100176/thumb/thumb_720_0368UkURq5VT2hcfdDaB8fo2.jpg"
								onerror="this.src='resources/camping-search-img/campingSiteDefaultImg.png'"
								alt="">
						</div>
						<div class="camping-item-desc2">
							<div class="camping-item-desc2-title camping-item-desc2-header">
								<a href="go.camping.detail?c_no=${c.c_no }"> [경상남도 거창군] 수승대
									오토캠핑장 </a>
								<!-- <c:choose>
                                        <c:when test="${c.isLiked == 1 }">
                                            <img onclick="heartClick('${c.c_no }')" class="camping-like-img camping-like-img-${c.c_no }" alt="" src="resources/camping-detail-icon/like.png">
                                        </c:when>
                                        <c:otherwise>
                                            <img onclick="heartClick('${c.c_no}')" class="camping-like-img camping-like-img-${c.c_no }" alt="" src="resources/camping-detail-icon/not-like.png">
                                        </c:otherwise>
                                    </c:choose> -->

							</div>
							<div class="camping-item-desc2-title camping-item-desc2-content">
								<a href="go.camping.detail?c_no=${c.c_no }">캠핑과 물놀이를 한꺼번에 즐길
									수 있는 수승대오토캠핑장.</a>
							</div>
							<div class="camping-item-desc2-title camping-item-desc2-info">
								<img class="camping-item-desc2-title-icon-position"
									src="position.png" alt=""> <span> 경상남도 거창군 위천면
									은하리길 2 </span> <img class="camping-item-desc2-title-icon-phone"
									src="phoneCall.png" alt=""> <span>055-940-8530</span>
							</div>
						</div>
					</div>

					<div class="camping-item-facilities">
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
					</div>
				</div>
				<div class="camping-item-container">
					<div class="camping-item-desc">
						<span class="camping-item-desc-item camping-item-desc-item1">관광사업자
							등록업체</span> <span class="camping-item-desc-item camping-item-desc-item2">리뷰수
							0</span> <span class="camping-item-desc-item camping-item-desc-item3">조회수
							0</span> <span class="camping-item-desc-item camping-item-desc-item4">
							<img class="camping-like-img-tag" alt=""
							src="resources/camping-detail-icon/like.png"> <span
							class="camping-like-count camping-like-count-${c.c_no }">0</span>
						</span>
					</div>

					<div class="camping-item-box-container">
						<div class="camping-item-img-container">
							<img
								src="https://www.gocamping.or.kr/upload/camp/100176/thumb/thumb_720_0368UkURq5VT2hcfdDaB8fo2.jpg"
								onerror="this.src='resources/camping-search-img/campingSiteDefaultImg.png'"
								alt="">
						</div>
						<div class="camping-item-desc2">
							<div class="camping-item-desc2-title camping-item-desc2-header">
								<a href="go.camping.detail?c_no=${c.c_no }"> [경상남도 거창군] 수승대
									오토캠핑장 </a>
								<!-- <c:choose>
                                        <c:when test="${c.isLiked == 1 }">
                                            <img onclick="heartClick('${c.c_no }')" class="camping-like-img camping-like-img-${c.c_no }" alt="" src="resources/camping-detail-icon/like.png">
                                        </c:when>
                                        <c:otherwise>
                                            <img onclick="heartClick('${c.c_no}')" class="camping-like-img camping-like-img-${c.c_no }" alt="" src="resources/camping-detail-icon/not-like.png">
                                        </c:otherwise>
                                    </c:choose> -->

							</div>
							<div class="camping-item-desc2-title camping-item-desc2-content">
								<a href="go.camping.detail?c_no=${c.c_no }">캠핑과 물놀이를 한꺼번에 즐길
									수 있는 수승대오토캠핑장.</a>
							</div>
							<div class="camping-item-desc2-title camping-item-desc2-info">
								<img class="camping-item-desc2-title-icon-position"
									src="position.png" alt=""> <span> 경상남도 거창군 위천면
									은하리길 2 </span> <img class="camping-item-desc2-title-icon-phone"
									src="phoneCall.png" alt=""> <span>055-940-8530</span>
							</div>
						</div>
					</div>

					<div class="camping-item-facilities">
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
					</div>
				</div>
				<div class="camping-item-container">
					<div class="camping-item-desc">
						<span class="camping-item-desc-item camping-item-desc-item1">관광사업자
							등록업체</span> <span class="camping-item-desc-item camping-item-desc-item2">리뷰수
							0</span> <span class="camping-item-desc-item camping-item-desc-item3">조회수
							0</span> <span class="camping-item-desc-item camping-item-desc-item4">
							<img class="camping-like-img-tag" alt=""
							src="resources/camping-detail-icon/like.png"> <span
							class="camping-like-count camping-like-count-${c.c_no }">0</span>
						</span>
					</div>

					<div class="camping-item-box-container">
						<div class="camping-item-img-container">
							<img
								src="https://www.gocamping.or.kr/upload/camp/100176/thumb/thumb_720_0368UkURq5VT2hcfdDaB8fo2.jpg"
								onerror="this.src='resources/camping-search-img/campingSiteDefaultImg.png'"
								alt="">
						</div>
						<div class="camping-item-desc2">
							<div class="camping-item-desc2-title camping-item-desc2-header">
								<a href="go.camping.detail?c_no=${c.c_no }"> [경상남도 거창군] 수승대
									오토캠핑장 </a>
								<!-- <c:choose>
                                        <c:when test="${c.isLiked == 1 }">
                                            <img onclick="heartClick('${c.c_no }')" class="camping-like-img camping-like-img-${c.c_no }" alt="" src="resources/camping-detail-icon/like.png">
                                        </c:when>
                                        <c:otherwise>
                                            <img onclick="heartClick('${c.c_no}')" class="camping-like-img camping-like-img-${c.c_no }" alt="" src="resources/camping-detail-icon/not-like.png">
                                        </c:otherwise>
                                    </c:choose> -->

							</div>
							<div class="camping-item-desc2-title camping-item-desc2-content">
								<a href="go.camping.detail?c_no=${c.c_no }">캠핑과 물놀이를 한꺼번에 즐길
									수 있는 수승대오토캠핑장.</a>
							</div>
							<div class="camping-item-desc2-title camping-item-desc2-info">
								<img class="camping-item-desc2-title-icon-position"
									src="position.png" alt=""> <span> 경상남도 거창군 위천면
									은하리길 2 </span> <img class="camping-item-desc2-title-icon-phone"
									src="phoneCall.png" alt=""> <span>055-940-8530</span>
							</div>
						</div>
					</div>

					<div class="camping-item-facilities">
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
					</div>
				</div>
				<div class="camping-item-container">
					<div class="camping-item-desc">
						<span class="camping-item-desc-item camping-item-desc-item1">관광사업자
							등록업체</span> <span class="camping-item-desc-item camping-item-desc-item2">리뷰수
							0</span> <span class="camping-item-desc-item camping-item-desc-item3">조회수
							0</span> <span class="camping-item-desc-item camping-item-desc-item4">
							<img class="camping-like-img-tag" alt=""
							src="resources/camping-detail-icon/like.png"> <span
							class="camping-like-count camping-like-count-${c.c_no }">0</span>
						</span>
					</div>

					<div class="camping-item-box-container">
						<div class="camping-item-img-container">
							<img
								src="https://www.gocamping.or.kr/upload/camp/100176/thumb/thumb_720_0368UkURq5VT2hcfdDaB8fo2.jpg"
								onerror="this.src='resources/camping-search-img/campingSiteDefaultImg.png'"
								alt="">
						</div>
						<div class="camping-item-desc2">
							<div class="camping-item-desc2-title camping-item-desc2-header">
								<a href="go.camping.detail?c_no=${c.c_no }"> [경상남도 거창군] 수승대
									오토캠핑장 </a>
								<!-- <c:choose>
                                        <c:when test="${c.isLiked == 1 }">
                                            <img onclick="heartClick('${c.c_no }')" class="camping-like-img camping-like-img-${c.c_no }" alt="" src="resources/camping-detail-icon/like.png">
                                        </c:when>
                                        <c:otherwise>
                                            <img onclick="heartClick('${c.c_no}')" class="camping-like-img camping-like-img-${c.c_no }" alt="" src="resources/camping-detail-icon/not-like.png">
                                        </c:otherwise>
                                    </c:choose> -->

							</div>
							<div class="camping-item-desc2-title camping-item-desc2-content">
								<a href="go.camping.detail?c_no=${c.c_no }">캠핑과 물놀이를 한꺼번에 즐길
									수 있는 수승대오토캠핑장.</a>
							</div>
							<div class="camping-item-desc2-title camping-item-desc2-info">
								<img class="camping-item-desc2-title-icon-position"
									src="position.png" alt=""> <span> 경상남도 거창군 위천면
									은하리길 2 </span> <img class="camping-item-desc2-title-icon-phone"
									src="phoneCall.png" alt=""> <span>055-940-8530</span>
							</div>
						</div>
					</div>

					<div class="camping-item-facilities">
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
						<div class="camping-item-facilities-items">
							<img class="camping-item-facilities-icon" src="hotwater.png"
								alt=""> <span>온수</span>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>