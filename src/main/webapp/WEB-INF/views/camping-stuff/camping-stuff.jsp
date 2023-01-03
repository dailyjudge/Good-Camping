<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="top-div">
		<div class="stuff-search">
			<input placeholder="상품명 입력" />
			<button>검색</button>
		</div>
		<div class="wrap-second">

			<c:forEach var="stuffs" items="${stuffs }">

				<div class="second-div">
					<div class="product-img">
						<img onclick="loaction.href='go.stuff.detail?s_no=${stuffs.s_no}'" src="${stuffs.s_image }" />
					</div>
					<div class="product-name">
						<span onclick="loaction.href='go.stuff.detail?s_no=${stuffs.s_no}'">${stuffs.s_title }</span>
					</div>
					<div class="product-price">
						<fmt:formatNumber value="${stuffs.s_price }" pattern="#,###" />
						원
					</div>
				</div>
			</c:forEach>

		</div>
		<div id="shop-paging-btn">
			<c:if test="${sp != 1 }">

				<button onclick="location.href='do.stuff.change?sp=${sp -1}'">Pre</button>

			</c:if>
			<c:if test="${sp != stuffCount }">

				<button onclick="location.href='do.stuff.change?sp=${sp +1}'">Next</button>

			</c:if>
		</div>

	</div>

</body>
</html>