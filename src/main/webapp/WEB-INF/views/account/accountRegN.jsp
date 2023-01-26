<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
	      <!--Import Google Icon Font-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	      <!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css"  media="screen,projection"/>
	  
    <link rel="stylesheet" href="resources/css/account-regN.css" />
    <link rel="stylesheet" href="resources/js/loginHead.js" />
</head>
<body>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<img class="camping-login-wave" src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/wave.png">
<div class="camping-login-img2">
    <img src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/bg.svg">
</div>
<div class="top-wrap"> 
    <div id="login-page" class="row">
        <div class="main-wrap col s12 z-depth-4 card-panel">
            <form action="accountReg.do" method="post" class="login-form" enctype="multipart/form-data">

                <div class="row first_row">
                    <div class="input-field col s12 center">
                       <a href="go.to.Main"><img src="resources/account-img/logo.png"></a>
                    </div>
                </div>
                <div class="row margin">
                    <div class="filebox_wrap">
                        <div class="profile"><img id="user-profile" src=""></div>
                        <div class="filebox">
                            <label for="ac_file">파일찾기</label>
                            <input type="file" onchange="changeImg(event);" name="ac_file" id="ac_file" multiple="multiple">
                        </div>
                    </div>
                </div>

            <div class="row margin">
	            <div class="input-field col s12">
	                <!-- <i class="mdi-social-person-outline prefix"></i> -->
	                <i class="material-icons prefix">account_circle</i>
	                <input id="ac_name" name="ac_name" type="text"/>
	                <label for="ac_name">성함</label>
	            </div>
            </div>
             <div class="account_gender">
                	<label for="ac_gender_man"><b> 남자 :</b></label> 
                	<input id="ac_gender_man" type="radio" name="ac_gender" value="남"> 
                	<label for="ac_gender_woman"><b> 여자 :</b></label> 
                	<input id="ac_gender_woman" type="radio" name="ac_gender" value="여">
            </div>
            <div class="row margin">
            <div class="input-field img_div col s12">
                <!-- <i class="mdi-social-person-outline prefix"></i> -->
                <i class="material-icons prefix">email</i>
                <input id="ac_id" name="ac_id" type="email" style="cursor: auto;" />
                <label for="ac_id">Email</label>
                <img class="search_img" src="resources/account-img/searchimg2.png" onclick="checkidsame()">
                <br><span id="check-id-result"></span>
            </div>
            </div>
    
            <div class="row margin">
            <div class="input-field col s12">
                <!-- <i class="mdi-action-lock-outline prefix"></i> -->
                <i class="material-icons prefix">vpn_key</i>
                <input id="ac_pw" name="ac_pw" type="password" />
                <label for="ac_pw">Password</label>
            </div>
            </div>
    
            <div class="row margin">
            <div class="input-field col s12">
                <!-- <i class="mdi-action-lock-outline prefix"></i> -->
                <i class="material-icons prefix">vpn_key</i>
                <input id="ac_pw2" name="ac_pw2" type="password" />
                <label for="ac_pw2">Password again</label>
            </div>
            </div>

            <div class="row margin">
	            <div class="input-field img_div col s12">
	                <!-- <i class="mdi-action-lock-outline prefix"></i> -->
	                <i class="material-icons prefix">phone</i>
	                <input id="phone" name="phone" type="text" maxlength="12"/>
	                <label for="phone">휴대폰 번호</label>
	                <img id="sendMessage" src="resources/account-img/searchimg2.png" onclick="sendSMS()">
	            </div>
	        </div>
		            	<div id="check-id-result" style="display: none">
				          	<input id="Random-num-input" type="hidden">
		                	<input id="makeNumCheck" type="text" size="13" maxlength="6" placeholder="인증코드 6자리">
		                	<button type="button" id="completion" onclick="checkCompletion()">인증</button>
		              	</div>

            <div class="row margin">
                <div class="input-field col s12">
                    <!-- <i class="mdi-action-lock-outline prefix"></i> -->
                    <i class="material-icons prefix">calendar_month</i>
                    <input id="ac_birth" name="ac_birth" type="text" maxlength="6"/>
                    <label for="ac_birth">생년월일</label>
                </div>
            </div>

            <div class="row margin">
                <div class="input-field img_div col s12">
                    <!-- <i class="mdi-action-lock-outline prefix"></i> -->
                    <i class="material-icons prefix">home</i>
                    <input id="ac_postcode" name="ac_postcode" type="text" disabled/>
                    <label for="ac_postcode">주소</label>
                    <img class="search_img" src="resources/account-img/searchimg2.png" onclick="daumPostcode()">
                </div>
                <div id="user_postcode" style="display: none">
		            <br> <input type="text" name="ac_address" id="address" placeholder="주소"> 
		            <br> <input type="text" name="ac_detailAddress" id="detailAddress" placeholder="상세주소">
		            <br> <input type="text" name="ac_extraAddress" id="extraAddress" placeholder="참고항목">
            	</div>
            </div>

            <div class="row">
                <div class="input-field col s12">
                    <button type="submit" class="btn waves-effect waves-light col s12">회원가입</button>
                    
                </div>
                <div class="input-field col s12">
                    <p class="margin center medium-small sign-up"><a href="login.go">로그인 페이지</a>로 돌아가기 </p>
                </div>
            </div>
 
            </form>
            </div>
    </div>
</div>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>