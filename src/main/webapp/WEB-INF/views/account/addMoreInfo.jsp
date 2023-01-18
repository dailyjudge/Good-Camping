<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/js/loginHead.js" />
<link rel="stylesheet" href="resources/css/account-reg.css" />
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<h1>네이버 로그인 추가 입력 사항 (비밀번호 / 주소)</h1>
	<h2>안녕하세요 ${reg_name } / ${reg_email}님</h2>
	<form action="naver.addMoreInfo.do" method="post">
		<input type="password" maxlength="20" name="ac_pw" placeholder="비밀번호를 입력하시오"> <br>
		<div class="account_type">
			<h4>
				<label for="ac_postcode">주소</label>
			</h4>
			<br> <input type="text" name="ac_postcode" id="postcode"
				placeholder="우편번호">
			<button type="button" id="find_button" onclick="daumPostcode()">우편번호
				찾기</button>
			<br> <input type="text" name="ac_address" id="address"
				placeholder="주소"> <input type="text" name="ac_detailAddress"
				id="detailAddress" placeholder="상세주소"> <br> <input
				type="text" name="ac_extraAddress" id="extraAddress"
				placeholder="참고항목">
		</div> <br>
		<button>가입하기!</button>
	</form>
</body>
</html>