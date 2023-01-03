<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/camping-search.css">
<link rel="stylesheet" href="resources/css/home.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap">
<link rel="stylesheet" href="resources/css/account.css">
<link rel="stylesheet" href="resources/css/camping-stuff.css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script type="text/javascript" src="resources/js/campingSearch.js"></script>
<script type="text/javascript" src="resources/js/account.js"></script>
<script type="text/javascript" src="resources/js/home.js"></script>
<style type="text/css">
.areaDiv{
margin: 0;
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
		<div>
		  <footer id="footer">
      <div id="footer-div">
        <div id="footer-logo">
          <img src="resources/home_img/logo.png" />
        </div>
        <div id="address">
          <ul>
            <p>서울특별시 종로구 종로12길 15 우)03190</p>
            <p>Copyright 2022.GoodC⛺mping. All rights reserved.</p>
          </ul>
        </div>
      </div>
    </footer>
		</div>
	</div>
</body>
</html>