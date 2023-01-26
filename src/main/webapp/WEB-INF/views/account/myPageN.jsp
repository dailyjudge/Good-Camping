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
            <form action="accountUpdate.do" method="post" class="login-form" enctype="multipart/form-data">
                <div class="row first_row">
                    <div class="input-field col s12 center">
                       <a href="go.to.Main"><img src="resources/account-img/logo.png"></a>
                    </div>
                </div>
                <div class="row margin">
                    <div class="filebox_wrap">
                        <div class="profile"><img id="user-profile" src="resource/profile_img/${sessionScope.loginAccount.ac_file}"></div>
                        <div class="filebox">
                            <label for="ac_file">파일찾기</label>
                            <input type="file" onchange="changeImg(event);" name="ac_file" id="ac_file" multiple="multiple">
                        </div>
                    </div>
                </div>

            
  	<div class="input-name-gender"> 
            <div class="row margin">
	            <div class="input-field col s12">
	                <!-- <i class="mdi-social-person-outline prefix"></i> -->
	                <i class="material-icons prefix">account_circle</i>
	                <input id="ac_name" name="ac_name" type="text"/>
	                <label for="ac_name">${sessionScope.loginAccount.ac_name }</label>
	            </div>
            </div>
            <div class="row margin">
           	 	<div class="input-field gender">
				     <select name="ac_gender" id="ac_gender">
					    <option value="남">남성</option>
					    <option value="여">여성</option>
					</select>
				</div>
            </div>
       </div>
            <div class="row margin">
            <div class="input-field img_div col s12">
                <!-- <i class="mdi-social-person-outline prefix"></i> -->
                <i class="material-icons prefix">email</i>
                <input id="ac_id" name="ac_id" type="email" disabled style="cursor: auto;" />
                <label for="ac_id">${sessionScope.loginAccount.ac_id }</label>
                <img class="search_img" src="resources/account-img/searchimg2.png">
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
	                <input id="phone" name="phone" type="text" oninput="autoHyphen2(this)" maxlength="13"/>
	                <label for="phone">${sessionScope.loginAccount.ac_phone }</label>
	                <img id="sendMessage" src="resources/account-img/searchimg2.png" onclick="sendSMS()">
	            </div>
	        </div>
		            	<div id="check-id-result" style="display: none">
				          	<input id="Random-num-input" type="hidden">
		                	<input id="makeNumCheck"  type="text" size="13" maxlength="6" placeholder="인증코드 6자리">
		                	<button type="button" id="completion" onclick="checkCompletion()">인증</button>
		              	</div>

            <div class="row margin">
                <div class="input-field col s12">
                    <!-- <i class="mdi-action-lock-outline prefix"></i> -->
                    <i class="material-icons prefix">calendar_month</i>
                    <input id="ac_birth" name="ac_birth" type="text" maxlength="6"/>
                    <label for="ac_birth">${sessionScope.loginAccount.ac_birth }</label>
                </div>
            </div>

            <div class="row margin">
                <div class="input-field img_div col s12">
                    <!-- <i class="mdi-action-lock-outline prefix"></i> -->
                    <i class="material-icons prefix">home</i>
                    <input id="postcode" name="ac_postcode" type="text" disabled/>
                    <label for="postcode">${sessionScope.loginAccount.ac_postcode }</label>
                    <img class="search_img" src="resources/account-img/searchimg2.png" onclick="daumPostcode()">
                </div>
                <div id="user_postcode">
		            <br> <input type="text" name="ac_address" id="address" placeholder="${sessionScope.loginAccount.ac_address }"> 
		            <br> <input type="text" name="ac_detailAddress" id="detailAddress" placeholder="${sessionScope.loginAccount.ac_detailAddress }">
		            <br> <input type="text" name="ac_extraAddress" id="extraAddress" placeholder="${sessionScope.loginAccount.ac_extraAddress }">
            	</div>
            </div>

            <div class="row">
                <div class="input-field col s12">
                    <button type="submit" class="btn waves-effect waves-light col s12">회원정보 수정</button>
                    
                </div>
                <div class="input-field col s12">
                    <p class="margin center medium-small sign-up"><a href="login.go">로그인 페이지</a>로 돌아가기 </p>
                </div>
                <div class="input-field col">
                <button type="button" id="deleteUserId"class="btn waves-effect waves-light col" onclick="deleteUser(${sessionScope.loginAccount.ac_id});">회원 탈퇴</button>
                </div>
            </div>
            </form>
            </div>
    </div>
</div>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>