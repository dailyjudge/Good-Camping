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
	${sessionScope.result }



	<div id="order-div">
		<div class="stuff-order-list">
			<div class="stuff-order-no">
				<span>주문내역</span>
			</div>
			
			<c:forEach items="${carts }" var="c">
				<div class="stuff-in-order">
					<img
						src="${c.s_image }" />
					<div class="stuff-in-order-title">
						<span>${c.s_title }</span>
					</div>
					<div class="stuff-in-order-price">
						<span>
							<fmt:formatNumber value="${c.s_price }" pattern="#,###" />원
						</span>
					</div>
				</div>
			</c:forEach>


			<div class="stuff-order-paymentdiv">
				<h2>결제 정보</h2>
			</div>
			<div class="stuff-order-totalPrice">
				<span>결제 금액</span> <span id="totalPrice">원</span> 
			</div>
			<div class="stuff-order-paymenttool">
				<span>결제 수단</span> 카카오페이
			</div>

			<div class="stuff-order-info">
				<h2>주문 정보</h2>
			</div>
			<div class="stuff-order-number">
				<span>주문번호</span> <span>${userOrder.so_no }</span>
			</div>
			<div class="stuff-order-username">
				<span>주문하신 분</span>${sessionScope.loginAccount.ac_name }</div>
			<div class="stuff-order-date">
				<span>결제 일시</span>${formattedDate }
			</div>

			<div class="stuff-order-addrinfo">
				<h2>배송 정보</h2>
			</div>
			<div class="stuff-order-tel">
				<span>연락처</span>010-0000-0000
			</div>
			<div class="stuff-order-addrress">
				<span>주소</span><span>${userOrder.so_user_addr } (${userOrder.so_user_detailAddr })</span>
			</div>
		</div>
	</div>
<script>
	let obj = ${sessionScope.result }
	let totalPrice = obj.amount.total;
	let item_name = obj.item_name;
	let quantity = obj.quantity;
</script>
</body>
</html>