<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="stuff-detail-div">
		<div class="stuff-img">
			<img src="${stuffs.s_image }" />
		</div>
		<div class="stuff-details">
			<div class="stuff-details-second">
				<div class="stuff-title">
					<b>${stuffs.s_title} </b>
				</div>

				<div class="stuff-category">
					<b>Category: </b><span>${stuffs.s_category }</span>
				</div>

				<c:if test="${stuffs.s_brand eq '미제공'}">
					<div class="stuff-brand">
						<b>Brand: </b><span>${stuffs.s_brand }</span>
					</div>
				</c:if>
				<div id="amount-div">
					<input type="button" value="-" onclick="count('minus')"
						name="minus" /> <span id="stuff-amount-result"
						type="text" name="amount" value="1" size="2" max="99">
						1 </span> <input type="button" value="+" onclick="count('plus')"
						name="add" />
					<div type="text" id="sum"></div>
				</div>
				<div class="stuff-price">
					<b><fmt:formatNumber value="${stuffs.s_price }" pattern="#,###" />
						원</b>
				</div>
				<div class="box bg-3">
					<button onclick="insertCart('${sessionScope.loginAccount.ac_id}')"
						id="insertCart-btn" value="${stuffs.s_no }"
						class="button button--aylen button--border-thick button--inverted button--text-upper button--size-s">
						ADD TO CART</button>
					<button onclick="location.href='go.buynow?items=${stuffs.s_no}'"
						id="goBuyNow-btn" value="${stuffs.s_no }"
						class="button button--aylen button--border-thick button--inverted button--text-upper button--size-s">
						BUY NOW</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>