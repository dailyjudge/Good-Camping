<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
	      <!--Import Google Icon Font-->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	      <!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css"  media="screen,projection"/>
	  
    <link rel="stylesheet" href="resources/css/account-regN.css" />
    <link rel="stylesheet" href="resources/css/account-button.css" />
    <script src="resources/js/loginHead.js" ></script>

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
            <form action="accountReg.do" name="join_form" method="post" class="login-form" enctype="multipart/form-data">

                <div class="row first_row">
                    <div class="input-field col s12 center">
                       <a href="go.to.Main"><img src="resources/account-img/logo.png"></a>
                    </div>
                </div>
                <div class="row margin">
                    <div class="filebox_wrap">
                        <div id="image_container" class="profile"><img id="test-img" src="https://cdn-icons-png.flaticon.com/128/5309/5309035.png"></div>
                        <div class="filebox">
                            <label for="ac_file">????????????</label>
                            <input type="file" onchange="changeImg(event);" name="ac_file" id="ac_file" multiple="multiple" style="display: none">
                        </div>
                    </div>
                </div>
	<div class="input-name-gender"> 
            <div class="row margin">
	            <div class="input-field col s12">
	                <!-- <i class="mdi-social-person-outline prefix"></i> -->
	                <i class="material-icons prefix">account_circle</i>
	                <input id="ac_name" name="ac_name" type="text" placeholder="??????"/>
	                <label for="ac_name" class="active"></label>
	            </div>
            </div>
            <div class="row margin">
           	 	<div class="input-field gender">
				     <select name="ac_gender" id="ac_gender">
					    <option value="???" selected>??????</option>
					    <option value="???">??????</option>
					</select>
				</div>
            </div>
       </div>
            <div class="row margin">
            <div class="input-field img_div col s12">
                <!-- <i class="mdi-social-person-outline prefix"></i> -->
                <i class="material-icons prefix">email</i>
                <input id="ac_id" name="ac_id" type="text" />
                <label for="ac_id" class="active">Email</label>
                <img class="search_img" src="resources/account-img/searchimg2.png" onclick="checkidsame()">
            </div>
                <br>
                <div class="set_center" >
                <span id="check-id-result"></span>
                </div>
            </div>
    
            <div class="row margin">
            <div class="input-field col s12">
                <!-- <i class="mdi-action-lock-outline prefix"></i> -->
                <i class="material-icons prefix">vpn_key</i>
                <input id="ac_pw" name="ac_pw" type="password" onKeyup="safetyPasswordPattern(this);" disabled/>
                <label for="ac_pw" class="active">Password</label>
                <br>
                <div class="set_center">
                <span id="makyText">:: id ?????? ?????? ?????????????????? ::</span>
                </div>
            </div>
            </div>
    
            <div class="row margin">
            <div class="input-field col s12">
                <!-- <i class="mdi-action-lock-outline prefix"></i> -->
                <i class="material-icons prefix">vpn_key</i>
                <input id="ac_pw2" name="ac_pw2" type="password" disabled />
                <label for="ac_pw2" class="active">Password again</label>
            </div>
            </div>

            <div class="row margin">
	            <div class="input-field img_div col s12">
	                <!-- <i class="mdi-action-lock-outline prefix"></i> -->
	                <i class="material-icons prefix">phone</i>
	                <input id="phone" name="ac_phone" type="text" oninput="autoHyphen2(this)" maxlength="13"/>
	                <label for="phone" class="active">????????? ??????</label>
	                <img id="sendMessage" src="resources/account-img/searchimg2.png" onclick="sendSMS()">
	            </div>
	        </div>
		            	<div id="check-id-result2" style="display: none" > <!--  -->
				          	<input id="Random-num-input" type="hidden">
		                	<input id="makeNumCheck" type="text" size="13" maxlength="6" placeholder="???????????? 6??????">
		                	<button type="button" id="completion" class="w-btn2 w-btn-gra1" onclick="checkCompletion()">??????</button>
		                	<input id="checkPhoneNum" type="hidden">
		              	</div>
                <div id="phoneText" class="set_center">
                <span id="check-id-result">????????? ?????? ?????? ????????????</span>
                </div>
            <div class="row margin">
                <div class="input-field col s12">
                    <i class="material-icons prefix">calendar_month</i>
                    <input id="ac_birth" name="ac_birth" type="text" maxlength="6" disabled/>
                    <label for="ac_birth" class="active">???????????? ex)990101</label>
                </div>
            </div>

            <div class="row margin">
                <div class="input-field img_div col s12">
                    <!-- <i class="mdi-action-lock-outline prefix"></i> -->
                    <i class="material-icons prefix">home</i>
                    <input id="postcode" name="ac_postcode" type="text" disabled/>
                    <label for="postcode"></label>
                    <img class="search_img" src="resources/account-img/searchimg2.png" onclick="daumPostcode()">
                </div>
	                <div id="user_postcode" style="display: none" >
			            <br> <input type="text" name="ac_address" id="address" placeholder="??????"> 
			            <br> <input type="text" name="ac_detailAddress" id="detailAddress" placeholder="????????????">
			            <br> <input type="text" name="ac_extraAddress" id="extraAddress" placeholder="????????????">
	            	</div>
            	
            </div>

            <div class="row">
                <div class="input-field col s12">
                    <button type="button" onclick="signUpCheck();" class="btn waves-effect waves-light col s12">????????????</button>
                </div>
                <div class="input-field col s12">
                    <p class="margin center medium-small sign-up"><a href="login.go">????????? ?????????</a>??? ???????????? </p>
                </div>
            </div>
 
            </form>
            </div>
    </div>
</div>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.js"></script>
</body>
</html>