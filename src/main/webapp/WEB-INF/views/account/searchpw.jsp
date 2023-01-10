<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

	<h2 align="center">비밀번호 찾기</h2>
	<div align="center">
		<p>ID(EMAIL)와 생년월일을 입력해 주세요.</p>
		<form action="sendpw.do" name="pwsearch" method="post">
			<table border="1">

				<tr>
					<td>아이디 @</td>
					<td>생년월일</td>
				</tr>
				<tr>
					<td><input type="text" name="id" placeholder="이메일 형식"></td>
					<td><input type="text" name="birth" placeholder="6글자 ex)990101" ></td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="button" value="비밀번호 찾기" onclick="search()" /></td>
				</tr>
			</table>

		</form>
	</div>
	<p align="center">
		로그인 페이지로 가시려면 <a href="goHome">로그인페이지</a>를 클릭하세요.
	</p>
</body>
</html>