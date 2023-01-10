<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 마이페이지 </h1>
<table border="1">

<tr>
<td>아이디 :</td>
<td>${sessionScope.loginAccount.ac_id }</td>
</tr>

<tr>
<td>비밀번호 :</td>
<td>${sessionScope.loginAccount.ac_pw  }</td>
</tr>

<tr>
<td>이름 :</td>
<td>${sessionScope.loginAccount.ac_name }</td>
</tr>

<tr>
<td>생년월일 :</td>
<td>${sessionScope.loginAccount.ac_birth }</td>
</tr>


<tr>
<td>전화번호 :</td>
<td>${sessionScope.loginAccount.ac_phone }</td>
</tr>

<tr>
<td>postcode :</td>
<td>${sessionScope.loginAccount.ac_postcode }</td>
</tr>

<tr>
<td>detailAddress :</td>
<td>${sessionScope.loginAccount.ac_detailAddress }</td>
</tr>

<tr>
<td>extraAddress :</td>
<td>${sessionScope.loginAccount.ac_extraAddress }</td>
</tr>

<tr>
<td>성별 :</td>
<td>${sessionScope.loginAccount.ac_gender }</td>
</tr>

<tr>
<td>프로필 사진</td>
<td><img alt="" src="resources/filse/${sessionScope.loginAccount.ac_file }">  </td>
</tr>

</table>

</body>
</html>