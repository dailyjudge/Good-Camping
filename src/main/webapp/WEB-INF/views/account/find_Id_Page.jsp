<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/find_id_modal.css" />
</head>
<body>
	<!-- <div class="top_wrap">
<div class="left_id">
<div class="wrap3">
유효성 검사 추가하기
		<form action="searchID.do" id ="IdSearch" name="IdSearch" method="post" onsubmit="return searchId()">
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
						<button id="searchId" >아이디 찾기</button> 
					</div>
				</div>
					<p align="center">
						로그인 페이지로 가시려면 <button type="button" onclick="location.href='accountHome.go'">로그인페이지</button>를 클릭하세요.
					</p>
		</form>
	</div>
	 </div>
	
	
pw 찾기
<div class="right_pw">
		<div class="wrap3">
		<form action="searchPW.do" name="PwSearch" id="PwSearch" method="post" onsubmit="return searchPw()">
				<div class="find">
					<h2>비밀번호 찾기</h2>
					<div class="account_type">
						<h4>이름</h4>
						<input type="text" id="pwFind_name" name="pwFind_name">
					</div>
					<div class="account_type">
						<h4>E-mail</h4>
						<input type="email" id="pwFind_id" name="pwFind_id" placeholder="이메일 형식">
					</div>
					<div class="account_type account-auth">
						<h4>인증번호 입력</h4>
						<input type="text" id="pwFind_auth" name="pwFind_auth" placeholder="인증번호 입력">
						<input type="hidden" id="pwFind-auth-hidden">
					</div>
					<div class="submit">
						<button id="searchPw" onclick="findPw2()">비밀번호 찾기</button>
					</div>
				</div>
						<button id="searchPw-confirm" class="account-auth" onclick="goChangePw2()">확인</button>
					<p align="center">
						로그인 페이지로 가시려면 <button type="button" onclick="location.href='accountHome.go'">로그인페이지</button>를 클릭하세요.
					</p>
		</form>
	</div>
	</div>
</div>  -->
	<img class="camping-login-wave"
		src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/wave.png">
	<div class="camping-login-container">
		<div class="camping-login-img">
			<img
				src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/bg.svg">
		</div>
		<div class="camping-login-content">

			<div class="camping-login-form">
				<img src="resources/home_img/logo.png">
				<div class="camping-login-find-category-container">
					<div class="camping-login-find-category-id">
						<span onclick="location.href='searchTheId.go'">아이디 찾기</span>
					</div>
					<div class="camping-login-find-category-pw">
						<span onclick="location.href='searchThePw.go'">비밀번호 찾기</span>
					</div>
				</div>

				<div id="camping-login-category-find-id-container">
					<div class="camping-login-input-div one">
						<div class="i">
							<i class="fas fa-user"></i>
						</div>
						<div class="camping-login-input-div2">
							<h5>UserName</h5>
							<input placeholder="이름을 입력하세요." type="email" name="ac_name"
								id="idFind_name" class="input">
						</div>
					</div>
					<div class="camping-login-input-div pass">
						<div class="i">
							<i class="fas fa-phone"></i>
						</div>
						<div class="camping-login-input-div2">
							<h5>Phone</h5>
							<input placeholder="휴대폰 번호를 입력하세요." type="password"
								name="ac_phone" id="idFind_phone" maxlength="13" class="input">
						</div>
					</div>
					<button class="camping-login-button" onclick="searchID();">ID
						찾기</button>
					<a href="go.Login.Head"
						class="camping-login-remember camping-login-sign-up">로그인 페이지로
						돌아가기</a>
				</div>
			</div>
		</div>
	</div>

	<div>
		<div id="modal"></div>
		<input type="hidden" id="idFind-auth-hidden">
		<div class="modal-con modal1">
		<a href="javascript:;" class="close">X</a>
			<p class="title">찾았습니다!!</p>
			<div class="con">회원님 아이디는 <span class="findId_span"></span>입니다</div>
			<br> <div id="backToHome"><a href="accountHome.go">로그인</a>하러 가기</div>
		</div>
	</div>
	
	<script type="text/javascript">
	$("#modal, .close").on('click',function(){
		  $("#modal").fadeOut(300);
		  $(".modal-con").fadeOut(300);
		});
	</script>
</body>
</html>