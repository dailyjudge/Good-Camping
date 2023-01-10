<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>popUp으로 표시</h1>

<c:choose>
<c:when test="${idCheckResult eq 'ok'}">
<h2>${ac_id2 } 는 이용이 가능합니다!</h2>
</c:when>
<c:when test="${idCheckResult eq 'no'}">
<h2>${ac_id2 } 는 이용이 안 됩니다..</h2>
</c:when>
</c:choose>

<br>
<button onclick="history.go(-1)">다시 Back</button>
유효성 검사 다시 적용해야함
</body>
</html>