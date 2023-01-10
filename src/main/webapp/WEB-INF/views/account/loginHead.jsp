<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LoginPage</title>

<link rel="stylesheet" href="resources/css/loginHead.css" />
</head>

<body>
<!-- 
<c:if test="${sessionScope.loginAccount.ac_name != null}">
	<button onclick="location.href='myPage.go'">마이페이지</button>
	<button onclick="location.href='logout.do'">로그아웃</button>
</c:if>
<c:if test="${sessionScope.loginAccount.ac_name == null}">
	<button class="btn-open-popup">로그인/회원가입</button>
</c:if>
 -->
     <div class="wrap2">
        <div class="login2">
            <h2>Log-in</h2>
            <div class="login_sns2">
            <li><a href=""><i class="fab fa-instagram"></i></a></li>
            <li><a href=""><i class="fab fa-facebook-f"></i></a></li>
            <li><a href=""><i class="fab fa-twitter"></i></a></li>
            </div>
            <div>
            <form action="do.account.login" method="post">
            <div class="login_id2">
                <h4>E-mail</h4>
                <input type="email" name="ac_id" id="ac_id" placeholder="Email">
            </div>
            <div class="login_pw2">
                <h4>Password</h4>
                <input type="password" name="ac_pw" id="ac_pw" placeholder="Password">
            </div>
            <div class="login_etc2">
                <div class="checkbox">
                <input type="checkbox" name="loginallways" value="on" id="">Remember Me?
                </div>
                <div class="forgot_pw2">
                <a href="seachpw.go">Forgot Password?</a>
            	</div>
            </div>
            <div class="login_etc2">
                <a href="accountReg.go">sign up</a>
            </div>
            <div class="submit2">
                <input type="submit" value="submit">
            </div>
            </form>
            </div>
			
        </div>
    </div>		 
</body>
</html>