<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/js/email-find.js" />
<link rel="stylesheet" href="resources/css/email-find.css" />
<head>
<link rel="icon" type="image/png" href="resources/img/jmclogo.png" />
<title>비밀번호 찾기</title>
<script type="text/javascript">
		function search(){
			if((pwsearch.id.value!=null)&&(pwsearch.email.value!=null)){
				pwsearch.submit();
			}else if(pwsearch.id.value==null) {
				alert("아이디를 입력하세요.")
			}else if(pwsearch.email.value==null) {
				alert("이메일주소를 입력하세요.")
			}
		
		}function showMsg(m){
			
			if(m==0){
				
			}else if(m==1){
				alert("입력하신 정보가 등록하신 정보와 다릅니다.");
				window.open("searchpw.do","_self", "" );
			}
		}function login(){
			window.open("login.do","_self","");
		}
	
	</script>

</head>
<body onload="showMsg(${msg})">
		<div class="wrap3">
		<form action="sendpw.do" name="pwsearch" method="post">
				<div class="findPw">
					<h2>비밀번호 찾기</h2>
					<div class="account_type">
						<h4>E-mail</h4>
						<input type="email" name="id" placeholder="이메일 형식">
					</div>
					<div class="account_type">
						<h4>생년월일</h4>
						<input type="text" name="birth" placeholder="6글자 ex)990101"> <br>
						<button type="button" onclick="location.href='searchID.go'">ID찾기</button>
					</div>
					<div class="submit">
						<input type="button" value="비밀번호 찾기" onclick="search()" />
					</div>
				</div>
					<p align="center">
						로그인 페이지로 가시려면 <button type="button" onclick="location.href='accountHome.go'">로그인페이지</button>를 클릭하세요.
					</p>
		</form>
	</div>

</body>
</html>