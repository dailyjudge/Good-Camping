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
	<div id="order-div">
		<div class="stuff-order-list">
			<div class="stuff-order-no">
				<span>주문내역</span>
			</div>

			<div class="stuff-in-order">
				<img
					src="http://www.coleman.co.kr/shop/data/goods/1590125678367m0.jpg" />
				<div class="stuff-in-order-title">1등급 야자활성탄 1kg 공기정화용 새집증후군제거
					냄새제거 숯 김민재 활명탄</div>
				<div class="stuff-in-order-price">12,900 원</div>
			</div>


			<div class="stuff-order-paymentdiv">
				<h2>결제 정보</h2>
			</div>
			<div class="stuff-order-totalPrice">
				<span>결제 금액</span> 10000000
			</div>
			<div class="stuff-order-paymenttool">
				<span>결제 수단</span> 카카오페이
			</div>

			<div class="stuff-order-info">
				<h2>주문 정보</h2>
			</div>
			<div class="stuff-order-number">
				<span>주문번호</span>001
			</div>
			<div class="stuff-order-username">
				<span>주문하신 분</span>${sessionScope.loginAccount.ac_name }</div>
			<div class="stuff-order-date">
				<span>결제 일시</span>2023-01-10
			</div>

			<div class="stuff-order-addrinfo">
				<h2>배송 정보</h2>
			</div>
			<div class="stuff-order-tel">
				<span>연락처</span>010-0000-0000
			</div>
			<div class="stuff-order-addrress">
				<span>주소</span>서울시 어쩌구 어쩌구
			</div>
		</div>
	</div>

</body>
</html>