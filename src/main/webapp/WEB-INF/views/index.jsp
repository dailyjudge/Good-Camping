<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Good Camping</title>
<link rel="stylesheet" href="resources/css/camping-search.css" />
<link rel="stylesheet" href="resources/css/home.css" />
<link rel="stylesheet" href="resources/css/camping-detail.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" />
<link rel="stylesheet" href="resources/css/account.css" />
<link rel="stylesheet" href="resources/css/camping-stuff.css" />
<link rel="stylesheet" href="resources/css/camping-stuff-detail.css" />
<link rel="stylesheet" href="resources/css/camping-stuff-cart.css" />
<link rel="stylesheet" href="resources/css/camping-stuff-payment.css">
<link rel="stylesheet" href="resources/css/camping-like.css">
  <head>
    <meta charset="UTF-8" />
    <title>Good Camping</title>
    <link rel="stylesheet" href="resources/css/camping-search.css" />
    <link rel="stylesheet" href="resources/css/home.css" />
    <link rel="stylesheet" href="resources/css/camping-detail.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap"
    />
    <link rel="stylesheet" href="resources/css/account.css" />
    <link rel="stylesheet" href="resources/css/camping-stuff.css" />
    <link rel="stylesheet" href="resources/css/camping-stuff-detail.css" />
    <link rel="stylesheet" href="resources/css/camping-stuff-cart.css" />
    <link rel="stylesheet" href="resources/css/camping-theme.css" />
    <link rel="stylesheet" href="resources/css/modalcss.css" />
    
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script type="text/javascript" src="resources/js/campingSearch.js"></script>
<script type="text/javascript" src="resources/js/account.js"></script>
<script type="text/javascript" src="resources/js/home.js"></script>
<script type="text/javascript" src="resources/js/campingDetail.js"></script>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/campingStuff.js"></script>
<script type="text/javascript" src="resources/js/campingTheme.js"></script>

<script type="text/javascript" src="resources/js/campingStuff.js"></script>
<script type="text/javascript" src="resources/js/campingStuffPayment.js"></script>

<script type="text/javascript" src="resources/js/campingDetailReview.js"></script>
<script type="text/javascript" src="resources/js/campingLike.js"></script>

<style type="text/css">
.areaDiv {
	margin: 0;
}
</style>
<style>
.wrap {
	position: absolute;
	left: 0;
	bottom: 40px;
	width: 288px;
	height: 132px;
	margin-left: -144px;
	text-align: left;
	overflow: hidden;
	font-size: 12px;
	font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
	line-height: 1.5;
}

.wrap * {
	padding: 0;
	margin: 0;
}

.wrap .info {
	width: 286px;
	height: 120px;
	border-radius: 5px;
	border-bottom: 2px solid #ccc;
	border-right: 1px solid #ccc;
	overflow: hidden;
	background: #fff;
}

.wrap .info:nth-child(1) {
	border: 0;
	box-shadow: 0px 1px 2px #888;
}

.info .title {
	padding: 5px 0 0 10px;
	height: 30px;
	background: #eee;
	border-bottom: 1px solid #ddd;
	font-size: 18px;
	font-weight: bold;
}

.info .close {
	position: absolute;
	top: 10px;
	right: 10px;
	color: #888;
	width: 17px;
	height: 17px;
	background:
		url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png");
}

.info .close:hover {
	cursor: pointer;
}

.info .body {
	position: relative;
	overflow: hidden;
}

.info .desc {
	position: relative;
	margin: 13px 0 0 90px;
	height: 75px;
}

.desc .ellipsis {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.desc .jibun {
	font-size: 11px;
	color: #888;
	margin-top: -2px;
}

.info .img {
	position: absolute;
	top: 6px;
	left: 5px;
	width: 73px;
	height: 71px;
	border: 1px solid #ddd;
	color: #888;
	overflow: hidden;
}

.info:after {
	content: "";
	position: absolute;
	margin-left: -12px;
	left: 50%;
	bottom: 0;
	width: 22px;
	height: 12px;
	background:
		url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}

.info .link {
	color: #5085bb;
}
</style>
</head>
  <body>
    <div class="container">
      <div class="areaDiv">
        <jsp:include page="${loginPage}"></jsp:include>
      </div>
      <div class="areaDiv">
        <jsp:include page="${contentPage}"></jsp:include>
      </div>
    </div>
    
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=14fb48386afd214fbe82e4cc27f58743"
    ></script>
  </body>
</html>
