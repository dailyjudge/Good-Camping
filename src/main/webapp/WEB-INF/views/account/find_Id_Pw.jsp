<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
const autoHyphen = (target) => {
	target.value = target.value
	.replace(/[^0-9]/g, '')
	.replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
	}
</script>
<link rel="stylesheet" href="resources/css/email-find.css" />

</head>
<body>
<div class="top_wrap">
<div class="left_id">
<div class="wrap3">
<!-- 유효성 검사 추가하기 -->
		<form action="searchID.do" name="IdSearch" method="post">
				<div class="find">
					<h2>E-mail 찾기</h2>
					<div class="account_type">
						<h4>이름</h4>
						<input type="text" name="sr_name" id="sr_name" placeholder="성함을 입력하시오">
					</div>
					<div class="account_type">
						<h4>휴대폰 번호</h4>
						<input type="text" name="sr_phone" id="sr_phone" oninput="autoHyphen(this)" maxlength="13"  placeholder=" (-) 자동입력">
					</div>
					<div class="submit">
						<button>아이디 찾기</button> 
					</div>
				</div>
					<p align="center">
						로그인 페이지로 가시려면 <button type="button" onclick="location.href='accountHome.go'">로그인페이지</button>를 클릭하세요.
					</p>
		</form>
	</div>
	 </div>
	
	
<!-- pw 찾기 -->
<div class="right_pw">
		<div class="wrap3">
		<form action="searchPW.do" name="PwSearch" method="post">
				<div class="find">
					<h2>비밀번호 찾기</h2>
					<div class="account_type">
						<h4>이름</h4>
						<input type="text" name="pwFind_name">
					</div>
					<div class="account_type">
						<h4>E-mail</h4>
						<input type="email" name="pwFind_id" placeholder="이메일 형식">
					</div>
					<div class="submit">
						<button onclick="search()">비밀번호 찾기</button>
					</div>
				</div>
					<p align="center">
						로그인 페이지로 가시려면 <button type="button" onclick="location.href='accountHome.go'">로그인페이지</button>를 클릭하세요.
					</p>
		</form>
	</div>
	</div>
</div>
</body>
</html>