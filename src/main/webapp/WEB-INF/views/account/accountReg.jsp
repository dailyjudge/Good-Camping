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
	<form action="accountReg.do" method="post" enctype="multipart/form-data" onsubmit="return signUpCheck()">
		<div class="wrap3">
			<div class="accountReg3">
				<div class="account_top">
					<h2>Sign up</h2>
					<div class="account_type">
						<h4>profile</h4>
						<p>
							<input type="file" name="ac_file" multiple="multiple">
							<!-- img 띄우고 없는 경우 카메라 모양으로 -->
					</div>
				</div>
				<div class="account_left">
					<div class="account_type">
						<h4>
							<label for="ac_id">e-mail</label>
						</h4>
						<input name="ac_id" id="ac_id" type="email"
							placeholder="ex) asd@naver.com">
						<p>
							<button type="button" onclick="checkidsame()">Id 중복 확인</button>
					</div>

					<div class="account_type">
						<h4>
							<label for="ac_pw">Password</label>
						</h4>
						<input name="ac_pw" id="ac_pw" type="text"
							placeholder="비밀번호를 입력해주세요">
					</div>

					<div class="account_type">
						<h4>
							<label for="ac_pw2">Password check</label>
						</h4>
						<input name="ac_pw2" id="ac_pw2" type="text"
							placeholder="비밀번호를 다시 입력해주세요">
					</div>
				</div>
				<div class="account_right">
					<div class="account_type">
						<h4>
							<label for="ac_name">name</label>
						</h4>
						<input name="ac_name" id="ac_name" type="text" placeholder="">
					</div>

					<div class="account_type">
						<h4>
							<label for="ac_birth">BirthDay</label>
						</h4>
						<input name="ac_birth" id="ac_birth" type="text" maxlength="6"
							placeholder="6자리 ex)990101">
					</div>
					<div class="account_gender">
						<label for="ac_gender_man">남자 : </label> <input id="ac_gender_man"
							type="radio" name="ac_gender" value="남"> <label
							for="ac_gender_woman">여자 : </label> <input id="ac_gender_woman"
							type="radio" name="ac_gender" value="여">
					</div>
</div>
					<div class="account_bottom">

					<div class="account_type">
						<h4><label for="phone">휴대폰 번호</label></h4>
							<input id="phone" type="text" name="phone" title="전화번호 입력" oninput="autoHyphen(this)" size="13" maxlength="13" placeholder=" '-' 입력 X" required/>
							    <button type="button" disabled id="sendMessage" onclick="makeNum()">인증번호 전송</button> <br>
							    <input id="makeNumCheck" type="text" size="6" maxlength="6">
					            <button type="button" disabled id="completion" onclick="checkCompletion()">인증확인</button>
					        </div>
					
					<div class="account_type">
						<h4><label for="ac_postcode">주소</label></h4> <br> 
						<input type="text" name="ac_postcode" id="postcode" placeholder="우편번호">
						<button type="button" id="find_button" onclick="daumPostcode()">우편번호 찾기</button>
						<br> <input type="text" name="ac_address" id="address" placeholder="주소"> 
							<input type="text" name="ac_detailAddress" id="detailAddress" placeholder="상세주소">
						<br> <input type="text" name="ac_extraAddress" id="extraAddress" placeholder="참고항목">
					</div>

</div>
				

				<div class="account_submit">
					<input type="submit" value="submit">
				</div>
			</div>
			</div>
	</form>

  <script>
    function sendSMS(){
    	var phone = document.getElementById('phone');
    	let sendto = document.getElementById('phone').value;
		if(sendto == ""){
		     alert("휴대폰 번호를 입력하시오."); 
		     phone.focus();
		}else{
		location.href="sendSms.do?phone_num="+sendto;
		}
    }
  </script>
  
</body>
</html>