<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/email-find.css" />
</head>
<body>

<div class="wrap3">
		<form action="searchID.do" name="pwsearch" method="post">
				<div class="findPw">
					<h2>E-mail 찾기</h2>
					<div class="account_type">
						<h4>이름</h4>
						<input type="text" name="sr_name" id="sr_name" placeholder="성함을 입력하시오">
					</div>
					<div class="account_type">
						<h4>생년월일</h4>
						<input type="text" name="sr_birth" id="sr_birth" placeholder="6글자 ex)990101"> <br>
						<button type="button" onclick="location.href='seachPw.go'">PW찾기</button>
					</div>
					<div class="submit">
						<input type="button" value="아이디 찾기" onclick="search()" />
					</div>
				</div>
					<p align="center">
						로그인 페이지로 가시려면 <button type="button" onclick="location.href='accountHome.go'">로그인페이지</button>를 클릭하세요.
					</p>
		</form>
	</div>

</body>
</html>