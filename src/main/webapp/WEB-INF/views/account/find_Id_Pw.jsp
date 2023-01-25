<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<img class="camping-login-wave"
		src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/wave.png">
	<div class="camping-login-container">
		<div class="camping-login-img">
			<img
				src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/bg.svg">
		</div>
		<div class="camping-login-content">
			<div class="camping-login-form-container">
				<img src="resources/home_img/logo.png">
				<div class="camping-login-find-category-container">
					<div id="find-id-button" id="camping-login-find-category-id">
						<span>아이디 찾기</span>
					</div>
					<div id="find-pw-button" class="camping-login-find-category-pw">
						<span>비밀번호 찾기</span>
					</div>
				</div>
				<div id="camping-login-category-find-id-container">
					<div class="camping-login-input-div one">
						<div class="i">
							<i class="fas fa-user"></i>
						</div>
						<div class="camping-login-input-div2">
							<h5>UserName</h5>
							<input id="camping-login-input-name" placeholder="이름을 입력하세요."
								type="email" name="ac_id" class="input">
						</div>
					</div>
					<div id="camping-login-category-id"
						class="camping-login-input-div pass camping-login-category-id">
						<div class="i">
							<i class="fas fa-phone"></i>
						</div>
						<div class="camping-login-input-div2">
							<h5>Phone</h5>
							<input id="camping-login-input-phone"
								placeholder="휴대폰 번호를 입력하세요." type="text" name="ac_pw"
								class="input">
						</div>
					</div>
					<div id="camping-login-category-pw"
						class="camping-login-input-div pass">
						<div class="i">
							<i class="fas fa-envelope"></i>
						</div>
						<div class="camping-login-input-div2">
							<h5>UserEmail</h5>
							<input id="camping-login-input-email" placeholder="이메일을 입력하세요."
								type="email" name="ac_pw" class="input">
						</div>
					</div>

					<!-- 인증 번호 -->
					<div id="camping-login-category-pw-email"
						class="camping-login-input-div pass">
						<div class="i">
							<i class="fas fa-check"></i>
						</div>
						<div class="camping-login-input-div2">
							<h5>Certification</h5>
							<input id="camping-login-input-valid" placeholder="인증번호를 입력하세요."
								type="password" name="ac_pw" class="input">
						</div>
					</div>

					<!-- 인증번호 저장 -->
					<input type="hidden" id="auth-input-num"> <span
						id="guide-info-span"></span>
					<button id="camping-find-button-2" class="camping-login-button">ID
						찾기</button>
					<a href="go.Login.Head"
						class="camping-login-remember camping-login-sign-up">로그인 페이지로
						돌아가기</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>