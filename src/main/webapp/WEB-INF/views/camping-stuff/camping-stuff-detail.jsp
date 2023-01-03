<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<b>Category: </b>${stuffs.s_category }</div>
				<div class="stuff-brand">
					<b>Brand: </b>${stuffs.s_brand }</div>
				<div class="stuff-price">
					<b><fmt:formatNumber value="${stuffs.s_price }" pattern="#,###" />
						원</b>
				</div>
				<div class="box bg-3">
					<button
						class="button button--aylen button--border-thick button--inverted button--text-upper button--size-m">
						ADD TO CART</button>
					<button
						class="button button--aylen button--border-thick button--inverted button--text-upper button--size-s">
						BUY NOW</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>