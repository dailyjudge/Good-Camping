<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="changePw.after.findPw.do" method="post">
	<input type="hidden" name="ac_id" value="${ac_id }">
	<input type="text" id="re_Pw" name="ac_pw">
	<button>비밀번호 재설정</button>
</form>
</body>
</html>