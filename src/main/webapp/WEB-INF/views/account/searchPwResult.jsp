<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//휴대폰 번호 입력 부분
	function changeNum1() {
		const pw1 = document.getElementById("pw1").value // 010
		if (pw1.length === 1) {
			document.getElementById("pw2").focus();
		}
	}
	function changeNum2() {
		const pw2 = document.getElementById("pw2").value // 010
		if (pw2.length === 1) {
			document.getElementById("pw3").focus();
		}
	}
	function changeNum3() {
		const pw3 = document.getElementById("pw3").value // 010
		if (pw3.length === 1) {
			document.getElementById("pw4").focus();
		}
	}
	function changeNum4() {
		const pw4 = document.getElementById("pw4").value // 010
		if (pw4.length === 1) {
			document.getElementById("sendPw").focus();
			document.getElementById("sendPw").setAttribute("style","background-color:yellow;")
		}
	}
	// 문자인증+타이머 부분
	function initButton(){
	  document.getElementById("sendMessage").disabled = true;
	  document.getElementById("completion").disabled = true;
	  document.getElementById("certificationNumber").innerHTML = "000000";
	  document.getElementById("timeLimit").innerHTML = "03:00";
	  document.getElementById("sendMessage").setAttribute("style","background-color:none;")
	  document.getElementById("completion").setAttribute("style","background-color:none;")
	}

	let processID = -1;
	const getToken = () => {

		  if (processID != -1) clearInterval(processID);
		  const token = String(Math.floor(Math.random() * 1000000)).padStart(6, "0");
		  document.getElementById("certificationNumber").innerText = token;
		  let time = 180;
		  processID = setInterval(function () {
		    if (time < 0 || document.getElementById("sendMessage").disabled) {
		      clearInterval(processID);
		      initButton();
		      return;
		    }
		    let mm = String(Math.floor(time / 60)).padStart(2, "0");
		    let ss = String(time % 60).padStart(2, "0");
		    let result = mm + ":" + ss;
		    document.getElementById("timeLimit").innerText = result;
		    time--;
		  }, 50);
		};
</script>
</head>
<body>
	${email }으로 보안 숫자가 발송되었습니다.
	<br> 메일을 확인하신 다음 인증 번호 4자리를 입력해주시오.
	<br>
	<!-- css로 이쁘게 4자리 입력하게 -->
	<!-- 유효성 검사 -->
	<!-- 시간 3분 표시될 수 있게 토큰 이용 -->
	<form action="changePw.after.findPw.go">
		<input type="text" id="pw1" name="pw1" oninput="changeNum1()">
		<input type="text" id="pw2" name="pw2" oninput="changeNum2()">
		<input type="text" id="pw3" name="pw3" oninput="changeNum3()">
		<input type="text" id="pw4" name="pw4" oninput="changeNum4()"> <br>
		<button id="sendPw">인증</button>
	</form>
</body>
</html>