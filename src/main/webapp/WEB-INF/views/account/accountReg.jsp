<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/modaljs.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script type="text/javascript">
function checkid() {
	const idValue = document.getElementById("ac_id").value;
	
	location.href='check.id?ac_id2='+idValue;
}
//휴대폰 번호 인증
var code2 = "";
$("#phoneChk").click(function(){
	alert("인증번호 발송이 완료되었습니다.\n휴대폰에서 인증번호 확인을 해주십시오.");
	var phone = $("#phone").val();
	$.ajax({
        type:"GET",
        url:"phoneCheck?phone=" + phone,
        cache : false,
        success:function(data){
        	if(data == "error"){
        		alert("휴대폰 번호가 올바르지 않습니다.")
				$(".successPhoneChk").text("유효한 번호를 입력해주세요.");
				$(".successPhoneChk").css("color","red");
				$("#phone").attr("autofocus",true);
        	}else{	        		
        		$("#phone2").attr("disabled",false);
        		$("#phoneChk2").css("display","inline-block");
        		$(".successPhoneChk").text("인증번호를 입력한 뒤 본인인증을 눌러주십시오.");
        		$(".successPhoneChk").css("color","green");
        		$("#phone").attr("readonly",true);
        		code2 = data;
        	}
        }
    });
});
</script>
</head>
<body>
<h1>회원가입 페이지 (Good Camping)</h1>
<form action="accountReg.do" method="post" enctype="multipart/form-data">
	<table border='1'>
		<tr>
			<td>
			<label for="ac_id">아이디</label><p>
			<input name="ac_id" id="ac_id" type="text" placeholder="ex) asd@naver.com">
			<button type="button" onclick="checkid()">Id 중복 확인</button>
			</td>
		</tr>
		<tr>
			<td>
			<label for="ac_pw">비밀번호</label><p>
			<input name="ac_pw" id="ac_pw" type="text" placeholder="비밀번호를 입력해주세요">
			</td>
		</tr>
		<tr>
			<td>
			<label for="ac_pw2">비밀번호 재확인</label><p>
			<input name="ac_pw2" id="ac_pw2" type="text" placeholder="비밀번호를 다시 입력해주세요">
			</td>
		</tr>
		<tr>
			<td>
			<label for="ac_name">이름</label><p>
			<input name="ac_name" id="ac_name" type="text" placeholder="">
			</td>
		</tr>
		<tr>
			<td>
			<label for="ac_birth">생년월일</label><p>
			<input name="ac_birth" id="ac_birth" type="text" maxlength="6" placeholder="6자리 ex)990101">
			</td>
		</tr>
		<tr>
		<td>
		<!--  
		<label for="ac_phone">전화번호</label><p>
		    <input id="ac_phone" name="ac_phone" oninput="autoHyphen(this)" type="text" size="13" maxlength="13" placeholder=" '-' 입력 X">
            <button type="button" onclick="sendSms();">인증번호 받기(중복 검사까지)</button>
            <br>
             
            <input type="text" name="sms" id="sms" placeholder="인증 번호 입력" disabled required>
    		<button type="button" onclick="phoneCheck();">인증</button>
		</td>
		-->
		<!-- NCSMH2UDME7WGBSB / DF0VOHPG4VCEU4LI7PIQQKEDHIKKUTL8 -->
<table>
<tr class="mobileNo">
	<th>
		<label for="phone">휴대폰 번호</label>
	</th>
	<td>
		<p>
			<input id="phone" type="text" name="phone" title="전화번호 입력" required/>
			<span id="phoneChk" class="doubleChk">인증번호 보내기</span><br/>
			<input id="phone2" type="text" name="phone2" title="인증번호 입력" disabled required/>
			<span id="phoneChk2" class="doubleChk">본인인증</span>
			<span class="point successPhoneChk">휴대폰 번호 입력후 인증번호 보내기를 해주십시오.</span>
			<input type="hidden" id="phoneDoubleChk"/>
		</p>
		<p class="tip">
			최초 가입 시에만 사용하고 있습니다. 따로 저장되지 않습니다.(번호만 입력해주세요.)
		</p>
	</td>
</tr>
</table>
		</tr>
		<tr>
		<td>
		<label for="ac_postcode">주소</label> <br>
		<input type="text" name="ac_postcode" id="postcode" placeholder="우편번호">
		<button type="button" id="find_button" onclick="daumPostcode()">우편번호 찾기</button><br>
		
		<input type="text" name="ac_address" id="address" placeholder="주소">
		<input type="text" name="ac_detailAddress" id="detailAddress" placeholder="상세주소"> <br>
		<input type="text" name="ac_extraAddress" id="extraAddress" placeholder="참고항목">
		</td>
		</tr>
		<tr>
			<td>
			<label for="ac_gender_man">남자 : </label>
            <input id="ac_gender_man" type="radio" name="ac_gender" value="남">  
            <label for="ac_gender_woman">여자 : </label>
            <input id="ac_gender_woman" type="radio" name="ac_gender" value="여">
			</td>
		</tr>
		<tr>
		<td>
		프로필 사진 :<input type="file" name="ac_file" multiple="multiple">
		</td> <!-- 사진 한개만 전송 가능하게 -->
		</tr>
		<tr>
		<td>
		<button onclick="signUpCheck()">회원가입</button>
		</td>
		</tr>
	</table>
</form>

</body>
</html>