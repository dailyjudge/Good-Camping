<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <img class="camping-login-wave" src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/wave.png">
  <div class="camping-login-container">
    <div class="camping-login-img">
      <img src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/bg.svg">
    </div>
    <div class="camping-login-content">
      <form action="" method="post" class="camping-login-form">
        <img src="resources/home_img/logo.png">
        	<div class="camping-login-find-category-container">
        		<div class="camping-login-find-category-id2"><span onclick="location.href='searchTheId.go'" >아이디 찾기</span></div>
        		<div class="camping-login-find-category-pw2"><span onclick="location.href='searchThePw.go'">비밀번호 찾기</span></div>
        	</div>
        	
              <div id="camping-login-category-find-id-container">
              <div class="camping-login-input-div one">
                 <div class="i">
                    <i class="fas fa-user"></i>
                 </div>
                 <div class="camping-login-input-div2">
                    <h5>UserName</h5>
                    <input placeholder="이름을 입력하세요." type="email" name="ac_id" class="input">
                 </div>
              </div>
              <div class="camping-login-input-div pass">
                 <div class="i"> 
                    <i class="fas fa-solid fa-envelope"></i>
                 </div>
                 <div class="camping-login-input-div2">
                    <h5>E-mail</h5>
                    <input placeholder="이메일을 입력하세요." type="password" name="ac_pw" class="input">
                 </div>
              </div>
              <button class="camping-login-button">PW 찾기</button>
              	<a href="go.Login.Head" class="camping-login-remember camping-login-sign-up">로그인 페이지로 돌아가기</a>
              </div>	
              
            </form>
        </div>
    </div> 
</body>
</body>
</html>