<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/ask_pw_page.css">
<link rel="stylesheet" href="resources/css/account-button.css">

</head>
<body>
<div class="ask-pw-top"> 
    <div class="ask-pw-con">
        <div class="lock-img-con"> 
            <img src="resources/account-img/lock-img-png.png" class="lock-img"> 
            <h2>비밀번호 확인</h2> 
            <h4>${sessionScope.loginAccount.ac_name }님의 개인정보 보호를 위해 <br>비밀번호를 다시 한번 입력해주세요</h4> 

        </div>
        <div class="ask-pw-div">
                <input type="text" style="text-align: center" id="ask_id_check" placeholder="${sessionScope.loginAccount.ac_id }" disabled><br>
                <br>
    <div class="input-contain">
        <input type="password" style="text-align: center" id="ask_pw_check" name="ask_pw_check" autocomplete="off" aria-labelledby="placeholder-fname">
        <label class="placeholder-text" for="ask_pw_check" id="placeholder-fname">
            <div class="text">비밀번호를 입력하시오</div>
        </label>
    </div><br>                
                <div id="ask_pw_check2" style="color : red;">비밀번호가 일치하지 않습니다</div><br>
                <input type="hidden" class="ask_pw_check3" value="${sessionScope.loginAccount.ac_id}">
                <button class="w-btn w-btn-gra1"  onclick="double_check_pw()">입력</button>
        </div>
        <div> 
            <a class="go_main" href="go.to.Main">HOME으로 돌아가기</a>
        </div>
    </div>
</div>
    <script type="text/javascript">
    $('#ask_pw_check2').hide();
    </script>
</body>
</html>