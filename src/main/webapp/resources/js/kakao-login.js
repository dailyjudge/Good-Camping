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