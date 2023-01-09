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
	<div id="cart-div">
		<div id="stuff-cart-list">
			<div class="stuff-cart-top">
				<input id="stuff-in-cart-allcheck" type="checkbox" />전체선택&nbsp;&nbsp;|&nbsp;&nbsp;<span
					onclick="deleteCheckedItem()">선택삭제</span>
			</div>
			<c:forEach var="c" items="${carts }">
				<div class="stuff-in-cart stuff-in-cart-${c.sc_cart_id }">
					<input class="stuff-in-cart-check" type="checkbox"
						value="${c.sc_cart_id }" />
					<div class="stuff-in-cart-img">
						<img src="${c.s_image }" />
					</div>
					<div class="stuff-in-cart-title">${c.s_title }</div>
					<div class="stuff-in-cart-amount">${c.sc_amount }</div>
					<div class="stuff-in-cart-price">
						<input class="stuff-hidden-price-input" type="hidden"
							value="${c.s_price *c.sc_amount }">
						<fmt:formatNumber value="${c.s_price *c.sc_amount }"
							pattern="#,###" />
						원
					</div>
				</div>
			</c:forEach>
			<c:if test="${ !empty  carts}">
				<div class="stuff-total-price">
					<span class="stuff-total-price-span"> 결제예정금액&nbsp;&nbsp; <fmt:formatNumber
							value="${money }" pattern="#,###" />원 &nbsp;&nbsp;
					</span>
					<button class="stuff-buy-btn" onclick="goPaymentPage()">구매하기</button>
				</div>
			</c:if>
			<c:if test="${ empty carts }">
				<div class="stuff-is-empty-div">
					<div class="stuff-is-empty">
						<span>장바구니에 담긴 상품이 없습니다</span>
					</div>
					<div class="stuff-is-empty-btn">
						<button onclick="location.href='go.camping.shop'">쇼핑하러가기</button>
					</div>
				</div>
			</c:if>

		</div>
	</div>
</body>
</html>