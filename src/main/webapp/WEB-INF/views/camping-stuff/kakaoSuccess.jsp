<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<script>
$(function() {
	let pg_token = $("#pg_token").val();
	
	opener.document.getElementById("pInput").value = document.getElementById("pg_token").value;
	opener.document.getElementById("approveForm").submit();
	window.close();
});

</script>
</head>
<body>
<h2>결제 처리중..</h2>
<input id="pg_token" type="hidden" name="pg_token"  value="${param.pg_token }">

</body>
</html>

