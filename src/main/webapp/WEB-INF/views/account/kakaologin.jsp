<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="javascript:void(0)" onclick="kakaoLogin();"> <img
		style="width: 30px;"
		src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/KakaoTalk_logo.svg/480px-KakaoTalk_logo.svg.png">
	</a>
	<a href="javascript:void(0)" onclick="kakaoLogout();"> <span>카카오
			로그아웃</span>
	</a>
	<!-- 카카오 스크립트 -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script>
		window.Kakao.init('8d3fc53af9696b2b55fc63b67784a525'); //발급받은 키 중 javascript키를 사용해준다.
		console.log(Kakao.isInitialized()); // sdk초기화여부판단

		//카카오로그인
		function kakaoLogin() {
			window.Kakao.Auth.login({
				scope : 'account_email,gender',
				success : function(response) {
					window.Kakao.API.request({
						url : 'http://localhost/modal',
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
					url : 'http://localhost/modal',
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
</body>
</html>