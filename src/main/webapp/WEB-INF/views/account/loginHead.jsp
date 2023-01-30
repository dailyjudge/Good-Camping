<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LoginPage</title>
  
<link rel="stylesheet" href="resources/css/loginHead.css" />
<link rel="stylesheet" href="resources/js/kakao-login.js" />
</head>

<body>	
	<img class="camping-login-wave" src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/wave.png">
  <div class="camping-login-container">
    <div class="camping-login-img">
      <img src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/bg.svg">
    </div>
    <div class="camping-login-content">
      <form action="do.account.login" method="post" class="camping-login-form">
        <img src="resources/home_img/logo.png">
              <div class="camping-login-input-div one">
                 <div class="i">
                    <i class="fas fa-user"></i>
                 </div>
                 <div class="camping-login-input-div2">
                    <h5>UserEmail</h5>
                    <input placeholder="Email" type="email" name="ac_id2" class="input">
                 </div>
              </div>
              <div class="camping-login-input-div pass">
                 <div class="i"> 
                    <i class="fas fa-lock"></i>
                 </div>
                 <div class="camping-login-input-div2">
                    <h5>Password</h5>
                    <input placeholder="Password" type="password" name="ac_pw2" class="input">
                 </div>
              </div>
              <div>
                <div class="camping-login-option-container">
                  <div class="camping-auto-login-container">
                    <input type="checkbox" name="loginallways" value="on">
                    <span>자동 로그인</span>
                  </div>
                  <a href="searchTheId.go" class="camping-login-remember">ID/PW를 잊었나요?</a>
                </div>
              </div>
              <button class="camping-login-button">로그인</button>
              <a href="accountReg.go" class="camping-login-remember camping-login-sign-up">회원이 아닌가요?</a>
            </form>
        </div>
    </div>
    
</body>
</html>