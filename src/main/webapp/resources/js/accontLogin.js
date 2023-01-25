const inputs = document.querySelectorAll(".input");


function addcl(){
  let parent = this.parentNode.parentNode;
  parent.classList.add("focus");
}

function remcl(){
  let parent = this.parentNode.parentNode;
  if(this.value == ""){
    parent.classList.remove("focus");
  }
}


inputs.forEach(input => {
  input.addEventListener("focus", addcl);
  input.addEventListener("blur", remcl);
});

$(function() {
	$('#find-id-button').click(function() {
		$('#find-id-button span').css('color', '#32be8f');
		$('#find-pw-button span').css('color', '#999');
		$('#camping-login-category-id').css('display', 'grid');
		$('#camping-login-category-pw').css('display', 'none');
		$('#camping-find-button-2').text('ID 찾기');
	});
	
	$('#find-pw-button').click(function() {
		$('#find-id-button span').css('color', '#999');
		$('#find-pw-button span').css('color', '#32be8f');
		$('#camping-login-category-id').css('display', 'none');
		$('#camping-login-category-pw').css('display', 'grid');
		$('#camping-find-button-2').text('PW 찾기');
	});
	
	$('#camping-find-button-2').click(function() {
		let buttonVal = $('#camping-find-button-2').text();
		console.log(buttonVal);
		$('#camping-login-category-pw-email').css('display', 'grid');
		
	
		if(buttonVal == 'ID 찾기') {
			let phoneNum = $("#camping-login-input-phone").val();
			console.log("phoneNum : " + phoneNum);
			$.ajax({
				url: "sendSms.do",
				data: {"num" : phoneNum}
			}).done(function(res) {
				$('#camping-login-input-valid').val(res);
				console.log("휴대폰 인증번호 : " + res);
				console.log('휴대폰 인증번호 저장 완료');
				$('#camping-find-button-2').text('휴대폰 인증번호 입력 확인');
			});
		} else if(buttonVal == 'PW 찾기') {
			let email = $("#camping-login-input-email").val();
			let name = $("#camping-login-input-name").val();
			console.log("name : " + name);
			console.log("email : " + email);
//			String ac_id = (String) req.getParameter("pwFind_id");
//			String name = (String) req.getParameter("pwFind_name");
			$.ajax({
				url: "searchPW.do",
				type: "POST",
				data: {
					   "ac_id": email,
					   "ac_name": name
					   }
			}).done(function(res) {
				console.log("이메일 인증번호 : " + res);
				
				$('#auth-input-num').val(res);
				
				console.log('이메일 인증번호 저장 완료');
				$('#camping-find-button-2').text('이메일 인증번호 입력 확인');
			})
		} else if(buttonVal == '이메일 인증번호 입력 확인' || buttonVal == '휴대폰 인증번호 입력 확인') {
			let validNum = $('#camping-login-input-valid').val();
			if(validNum == '---') {
				// 빈공간으로 수정해야함
				alert('인증번호를 입력해주세요.');
				$('#camping-login-input-valid').focus();
			} else if(validNum != $('#auth-input-num').val()) {
				alert("인증번호가 일치하지 않습니다.")
				$('#camping-login-input-valid').focus();
			} else {
				alert("인증번호 일치 !!");
				let phoneNum = $("#camping-login-input-phone").val();
				let name = $("#camping-login-input-name").val();
				
				if(buttonVal == '휴대폰 인증번호 입력 확인') {
					$.ajax({
						url: "searchID.do",
						data: {"sr_name": name,
							   "sr_phone": phoneNum
							   },
						type: "POST"
					}).done(function(res) {
						$('#guide-info-span').text('ID는 ' + res + '입니다.')
					})
				} else if(buttonVal == '이메일 인증번호 입력 확인') {
					location.href="changePw.after.findPw.go?ac_id=" + $("#camping-login-input-email").val();
				}
				
			}
		} 
	});
});
