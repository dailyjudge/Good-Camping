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
<form action="go.stuff.buy" onsubmit="return goOrderPage()" method="post">
	<input class="so_data" name="so_data" type="hidden">
	<div class="stuff-payment-page">
		<div class="stuff-payment-list">
			<div class="stuff-payment-orderstuff">
				<h2>주문 상품</h2>
			</div>
			<c:forEach items="${carts2 }" var="c">
				<div class="stuff-payment-in-cart">
					<input class="id_input" type="hidden" value="${c.sc_cart_id }">
					<img src="${c.s_image }" />
					<div class="stuff-in-cart-title">${c.s_title }</div>
					<div class="stuff-in-cart-price">
					<fmt:formatNumber value="${c.s_price * c.sc_amount }"
							pattern="#,###" />
						원</div>
				</div>
			</c:forEach>

			<div class="stuff-payment-userinfo">
				<h2>주문자 정보</h2>
			</div>
			<div class="stuff-payment-user-name">
				<span>주문자 성함</span>${sessionScope.loginAccount.ac_name }
			</div>
			<div class="stuff-payment-user-tel">
				<span> 핸드폰 번호</span>010-1234-2345
			</div>

			<div class="stuff-payment-addrinfo">
				<h2>배송 정보</h2>
			</div>
			<div class="stuff-payment-addr-daum">
				<input type="text" name="so_user_zoncode" id="stuff-postcode" placeholder="우편번호" readonly="readonly"/> 
				<input type="button" onclick="searchAddr()" value="우편번호 찾기"
					class="stuff-payment-user-addr" /><br /> 
				<input type="text" name="so_user_addr" id="stuff-Address" placeholder="주소" />
			<!-- 	<span id="guide" style="color: #999; display: none"></span> -->
				 <input type="text" name="so_user_detailAddr" id="stuff-detailAddress" placeholder="상세주소" />
				<!-- <input type="text" id="stuff-extraAddress" placeholder="참고항목" /> -->
			</div>
			<div class="stuff-payment-gobuy">
				<div class="stuff-payment-btn">
					<button class="stuff-payment-btn-btn">결제하러가기</button>
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>