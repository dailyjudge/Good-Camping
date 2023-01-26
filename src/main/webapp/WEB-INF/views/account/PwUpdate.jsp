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
<%-- <form action="changePw.after.findPw.do" method="post">
	<input type="hidden" name="ac_id" value="${ac_id }">
	<input type="text" id="re_Pw" name="ac_pw">
	<button>비밀번호 재설정</button>
</form> --%>
<div class="ask-pw-top"> 
    <div class="ask-pw-con">
        <div class="lock-img-con"> 
            <img src="resources/account-img/lock-img-png.png" class="lock-img"> 
            <h2>비밀번호 재설정</h2> 
            <h4>${ac_id }님의 새로운 비밀번호를 입력해주세요</h4> 

        </div>
     <form action="changePw.after.findPw.do" method="POST">
		        <div class="ask-pw-div">
		                <input type="text" style="text-align: center" id="ask_id_check" placeholder="${ac_id }" disabled><br>
		                <br>
		    <div class="input-contain">
		    	<input type="hidden" name="ac_id" value="${ac_id }">
		        <input type="password" style="text-align: center" id="ask_pw_check" name="ac_pw" autocomplete="off" aria-labelledby="placeholder-fname">
		       
		        <label class="placeholder-text" for="ask_pw_check" id="placeholder-fname">
		            <div class="text">비밀번호를 입력하시오</div>
		        </label>
		    </div><br>       
		    		<button class="w-btn w-btn-gra1" >재설정</button>         
		        </div>
        </form>
    </div>
</div>

</body>
</html>