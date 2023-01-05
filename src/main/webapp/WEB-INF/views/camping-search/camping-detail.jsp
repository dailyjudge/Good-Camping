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
  	<input id="mapX" type="hidden" value="${m.c_mapX }">
  	<input id="mapY" type="hidden" value="${m.c_mapY }">
  	<input id="detail-facltNm" type="hidden" value="${m.c_facltNm}">
  	<input id="detail-firstImageUrl" type="hidden" value="${m.c_firstImageUrl }">
  	<input id="detail-homepage" type="hidden" value="${m.c_homepage }">
  	<input id="detail-zipcode" type="hidden" value="${m.c_zipcode }">
  	<input id="detail-addr1" type="hidden" value="${m.c_addr1 }">
  	
    <div class="camping-detail-item-container camping-detail-top-container">
      <div class="camping-detail-desc-container camping-detail-title">
        ${m.c_facltNm}
      </div>
    </div>
    
    <div class="camping-detail-item-container">
      <div class="camping-detail-desc-container">
        <img
          class="camping-detail-item-img"
          src="${m.c_firstImageUrl }"
          alt=""
        />
        <div class="camping-detail-item-desc-container">
          <div class="camping-detail-item-desc-items">
            <span class="camping-detail-item-category">주소</span>
            <span class="camping-detail-item-separator">|&nbsp;&nbsp;</span>
            <span>${m.c_addr1} </span>
          </div>
          <div class="camping-detail-item-desc-items">
            <span class="camping-detail-item-category">운영기간</span>
            <span class="camping-detail-item-separator">|&nbsp;&nbsp;</span>
            <span>${m.c_operPdCl }</span>
          </div>
          <div class="camping-detail-item-desc-items">
            <span class="camping-detail-item-category">운영일</span>
            <span class="camping-detail-item-separator">|&nbsp;&nbsp;</span>
            <span>${m.c_operDeCl }</span>
          </div>
          <div class="camping-detail-item-desc-items">
            <span class="camping-detail-item-category">홈페이지</span>
            <span class="camping-detail-item-separator">|&nbsp;&nbsp;</span>
            
            <c:if test="${m.c_homepage != '#' }">
	            <span class="camping-detail-item-content">
	              <a href="${m.c_homepage }" target="_blank">홈페이지 바로가기</a>
	              <img class="camping-detail-content-img" src="resources/camping-detail-icon/link.png"/>
	            </span>
            </c:if>
          </div>
          <div class="camping-detail-item-desc-items">
            <span class="camping-detail-item-category">주변이용가능시설</span>
            <span class="camping-detail-item-separator">|&nbsp;&nbsp;</span>
            <span>${m.c_posblFcltyCl }</span>
          </div>
        </div>
      </div>
    </div>
	
    <div class="camping-detail-type-list">
      <div class="camping-detail-type-item camping-category-selected"><span class="camping-category-item">캠핑장 소개</span></div>
      <div class="camping-detail-type-item"><span class="camping-category-item">지도로 보기</span></div>
      <div class="camping-detail-type-item"><span class="camping-category-item">리뷰</span></div>
    </div>
    
	<div class="camping-category-item1 camping-category-item-on">

    <div class="camping-datail-list-type-item camping-detail-list-type-additional">
      <div class="camping-detail-additional-item">
        <span>캠핑장 소개</span>
      </div>
    </div>

    <div class="camping-datail-list-type-item">
      <span>
        ${m.c_intro }
      </span>
    </div>

    <div class="camping-datail-list-type-item camping-detail-list-type-additional">
      <div class="camping-detail-additional-item">
        <span>캠핑장 시설 정보</span>
      </div>
    </div>
    
    <div class="camping-datail-list-type-item camping-detail-list-type-additional">
   		<div class="camping-detail-facilities">
			<c:forEach var="f" items="${m.facilities }">
				<div class="camping-detail-facilities-items">
					<img class="camping-detail-facilities-icon" src="${f.image }" alt=""> 
					<span>${f.desc }</span>
				</div>
			</c:forEach>
		</div>
    </div>
    
    <div class="camping-datail-list-type-item camping-detail-list-type-additional">
      <div class="camping-detail-additional-item">
        <span>기타 주요시설</span>
      </div>
    </div>

    <div class="camping-datail-list-type-item camping-detail-list-type-item-etc">
      <p><img class="camping-detail-list-type-item-img" src="resources/camping-detail-icon/check.png"><span class="camping-detail-list-type-item-etc-category">반려 동물 출입</span><span>| &nbsp;&nbsp;${m.c_animalCmgCl }</span></p>
      <p><img class="camping-detail-list-type-item-img" src="resources/camping-detail-icon/check.png"><span class="camping-detail-list-type-item-etc-category">테마 환경</span><span>| &nbsp;&nbsp;${m.c_themaEnvrnCl }</span></p>
      <p><img class="camping-detail-list-type-item-img" src="resources/camping-detail-icon/check.png"><span class="camping-detail-list-type-item-etc-category">화로대</span><span>| &nbsp;&nbsp;${m.c_brazierCl }</span></p>
      <p><img class="camping-detail-list-type-item-img" src="resources/camping-detail-icon/check.png"><span class="camping-detail-list-type-item-etc-category">객실 환경</span><span>| &nbsp;&nbsp;화장실(${m.c_toiletCo }), 개수대(${m.c_wtrplCo })</span></p>
      <p><img class="camping-detail-list-type-item-img" src="resources/camping-detail-icon/check.png"><span class="camping-detail-list-type-item-etc-category">툴팁</span><span>| &nbsp;&nbsp;${m.c_tooltip }</span></p>
    </div>
   </div>
   
   <div class="camping-category-item2">
   		<div id="map" style="width:48%;height:500px;"></div>
   		<div class="camping-detail-find-way" style="width:50%;height:80%">
            <!-- <div class="camping-find-way-button-container">
                <span class="camping-find-way-span">내 위치에서 얼마나 걸릴까?</span>
                <button>확인하기</button>
            </div> -->
            
            
            <div class="camping-find-way-button-container">
            	<button class="camping-find-way-button" onclick="findWay()">캠핑장? 얼마나 걸릴까?</button>
            </div>
            
            <div class="camping-find-way-button-container camping-find-way-spinner-container">
            	 <div class="spinner"><i class="fas fa-spinner fa-2x"></i></div>
            	 <div style="margin-left: 30px"><span>계산중...</span></div>
            </div>
            
            <div class="camping-find-way-items">
                <div class="camping-find-way-item camping-find-way-category">
                    <span>거리 및 시간 정보</span>
                </div>
                <div class="camping-find-way-item">
                    <span>총 이동거리 : 약 </span><span id="camping-find-way-distance"></span>
                </div>
                <div class="camping-find-way-item">
                    <span>총 소요시간 : 약 </span><span id="camping-find-way-duration"></span>
                </div>
                <div class="camping-find-way-item camping-find-way-category">
                    <span>기타 요금 정보</span>
                </div>
                <div class="camping-find-way-item">
                    <span>택시 요금 :  </span><span id="camping-find-way-feeOfTaxi"></span>
                </div>
                <div class="camping-find-way-item">
                    <span>톨게이트비 : </span><span id="camping-find-way-feeOfToll"></span>
                </div>
            </div>
        </div>
   </div>
   	
   
   <div class="camping-category-item3">
   	 <c:if test="${sessionScope.loginAccount != null }">
   		<div class="camping-detail-type-review">
        <div class="review-user-container">
            <img class="review-user-img" src="resources/camping-detail-review/images.jpeg" alt="">
        </div>
        <form id="camping-create-review-form" action="do.create.review" onsubmit="return createReview()">
        <input name="cr_author" type="hidden" value="${sessionScope.loginAccount.ac_id }">
        <input name="cr_campingSiteNo" type="hidden" value="${m.c_no }">
        <div class="review-content-container">
            <div class="review-content-title">
                <span>제목</span> <span>별점</span>
                
                <div>
                    <button class="review-content-control review-content-control-button">등록하기</button>
                </div>
            </div>

            <input name="cr_title" class="camping-review-write-title">
            	<span class="star">
              	  ★★★★★
           	    <span>★★★★★</span>
            <input name="cr_no" id="camping-review-star" type="range" oninput="drawStar(this)" value="1" step="1" min="0" max="10">
            </span>
            <br><br>
            <span>내용</span>
            <div class="review-content-comment">
                <textarea name="cr_content" class="camping-review-write-content"></textarea>
            </div>

        </div>
        </form>
    </div>
   </c:if>	
   
     <c:forEach var="r" items="${reviews }">
     	<div class="camping-detail-type-review camping-detail-${r.cr_no }">
        	<div class="review-user-container">
          	  <img class="review-user-img" src="resources/camping-detail-review/images.jpeg" alt="">
           	  <span>별점: ${r.cr_star }</span>
       	    </div>
       	    
       	    <div class="review-content-container">
            	<div class="review-content-title">
                	<span class="review-content-title-span review-visible-${r.cr_no } review-visible-${r.cr_no}-title">${r.cr_title }</span>
                	<input class="review-content-title-span review-hidden-${r.cr_no } review-hidden-${r.cr_no}-title" value="${r.cr_title }" style="display: none">
                	
                	
                	<div>
                	<c:if test="${sessionScope.loginAccount.ac_id == r.cr_author }">
                    	<span class="review-content-control review-visible-${r.cr_no }" onclick="openHiddenContents('${r.cr_no}')">수정</span>
                    	<span class="review-content-control review-visible-${r.cr_no }" onclick="deleteReview('${r.cr_no}')">삭제</span>
                    	<span class="review-content-control review-hidden-${r.cr_no }" onclick="updateReview('${r.cr_no}')" style="display: none; margin-bottom: 10px">수정하기</span>
           				<span class="review-content-control review-hidden-${r.cr_no }" onclick="closeHiddenContents('${r.cr_no}')" style="display: none">취소하기</span>
  				  	</c:if>             
                	</div>
            </div>

            <div class="review-content-content review-visible-${r.cr_no }">
                <span class="review-content-content-star"><img class="camping-content-star-img" src="resources/star/star-${r.cr_star }.jpeg"></span><span class="review-content-content-separaotr">|</span>
                <span class="review-content-content-author">${r.cr_author }</span>
                <span class="review-content-content-date">작성일 : ${r.cr_date }</span> 
            </div>
            
            <div class="review-content-comment">
                <span class="review-visible-${r.cr_no } review-visible-${r.cr_no}-content">${r.cr_content}</span>
                <textarea class="review-hidden-${r.cr_no } review-hidden-${r.cr_no}-content" style="display: none">${r.cr_content}</textarea>
            </div>
        </div>
     </div>
     </c:forEach>
   </div>
   
   
  </body>
</html>