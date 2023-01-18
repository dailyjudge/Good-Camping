<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LoginPage</title>
  
<link rel="stylesheet" href="resources/css/loginHead.css" />
<link rel="stylesheet" href="resources/js/kakao-login.js" />
</head>

<body>

	<div class="wrap2">
		<div class="login2">
			<h2>Log-in</h2>
			<div class="login_sns2">
				<li><a href="javascript:void(0)" onclick="kakaoLogin();"><img alt="" src="resources/social-img/Kakao_logo.jpg"></a></li>
				<li><a href=""><i class="fab fa-google"></i></a></li>
				<li><div id="naver_id_login"><a href="${url}"><img alt="" src="resources/social-img/naver-image.png"></a></div></li>
			</div> 
			<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

			<div>
				<form action="do.account.login" method="post">
					<div class="login_id2">
						<h4>E-mail</h4>
						<input type="email" name="ac_id" id="ac_id" placeholder="Email">
					</div>
					<div class="login_pw2">
						<h4>Password</h4>
						<input type="password" name="ac_pw" id="ac_pw"
							placeholder="Password">
					</div>
					<div class="login_etc2">
						<div class="checkbox">
							<input type="checkbox" name="loginallways" value="on" id="loginallways">Remember
							Me?
							<label for="loginallways"></label>
						</div>
						<div class="forgot_pw2">
							<a href="searchPW.go">비밀번호 찾기</a>
						</div>
					</div>
					<div class="login_etc2">
						<a href="accountReg.go">회원가입</a>
					</div>
					<div class="submit2">
						<input type="submit" value="submit">
					</div>
				</form>
			</div>

		</div>
	</div>
	
		<script>
		window.Kakao.init('8d3fc53af9696b2b55fc63b67784a525'); //발급받은 키 중 javascript키를 사용해준다.
		console.log(Kakao.isInitialized()); // sdk초기화여부판단

		//카카오로그인
		function kakaoLogin() {
			window.Kakao.Auth.login({
				scope : 'account_email,gender',
				success : function(response) {
					window.Kakao.API.request({
						url : 'http://localhost:8080/camping/go.Login.Head',
						success : function(response) {
							console.log(response)
						},
						fail : function(error) {
							console.log(error)
						},
					})
				},
				fail : function(error) {
					console.log(error)
				},
			})
		}
		//카카오로그아웃  
		function kakaoLogout() {
			if (Kakao.Auth.getAccessToken()) {
				Kakao.API.request({
					url : 'http://localhost:8080/camping/go.Login.Head',
					success : function(response) {
						console.log(response)
					},
					fail : function(error) {
						console.log(error)
					},
				})
				Kakao.Auth.setAccessToken(undefined)
			}
		}
	</script>
	<script type="text/javascript">
    var naverLogin = new naver.LoginWithNaverId(
        {
            clientId: "Uh1tF3zF15ZOgjkmBw4K",
              // 본인의 Client ID로 수정, 띄어쓰기는 사용하지 마세요.
            callbackUrl: "http://localhost:8080/camping/go.Login.Head.callback",
              // 본인의 callBack url로 수정하세요.
            isPopup: false,
            loginButton: {color: "white", type: 1, height: 40}
              // 네이버 로그인버튼 디자인 설정. 한번 바꿔보세요:D
        }
    );
naverLogin.init();
</script>
</body>
</html>