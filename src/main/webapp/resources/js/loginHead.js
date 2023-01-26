const autoHyphen2 = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}
function daumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
            document.getElementById("user_postcode").style.display = 'block';
        }
    }).open();
}
function signUpCheck(){
	  //변수에 담아주기
	  let files = document.getElementById("ac_file");
	  var uname = document.getElementById("ac_name");
	  //성별
	  var gender = document.getElementById("ac_gender");
	  //아이디
	  let email = document.getElementById("ac_id").value;
	  let user_email = document.getElementById("ac_id");
	  let email_check = document.getElementById("ac_id").value;
	  //비밀번호
	  var pwd = document.getElementById("ac_pw");
	  var repwd = document.getElementById("ac_pw2");
	  //모바일
	  var mobile = document.getElementById("phone");
	  let birth = document.getElementById("ac_birth");
	  //주소
	  let area = document.getElementById("postcode");
	  
	  // 이메일확인
	  if(email.includes('@')){
	    let emailId = email.split('@')[0]
	    let emailServer = email.split('@')[1]
	    if(emailId === "" || emailServer === ""){
	      document.getElementById("emailError").innerHTML="이메일이 올바르지 않습니다."
	    }
	    else{
	      document.getElementById("emailError").innerHTML=""
	    }
	  }else{
	    document.getElementById("emailError").innerHTML="이메일이 올바르지 않습니다."
	  }





	}
function joinform_check() {
	  //변수에 담아주기
	  var uid = document.getElementById("uid");
	  var pwd = document.getElementById("pwd");
	  var repwd = document.getElementById("repwd");
	  var uname = document.getElementById("uname");
	  var female = document.getElementById("female");
	  var male = document.getElementById("male");
	  var mobile = document.getElementById("mobile");
	  var email_id = document.getElementById("email_id");
	  var agree = document.getElementById("agree");

	  if (uid.value == "") { //해당 입력값이 없을 경우 같은말: if(!uid.value)
	    alert("아이디를 입력하세요.");
	    uid.focus(); //focus(): 커서가 깜빡이는 현상, blur(): 커서가 사라지는 현상
	    return false; //return: 반환하다 return false:  아무것도 반환하지 말아라 아래 코드부터 아무것도 진행하지 말것
	  };

	  if (pwd.value == "") {
	    alert("비밀번호를 입력하세요.");
	    pwd.focus();
	    return false;
	  };

	  //비밀번호 영문자+숫자+특수조합(8~25자리 입력) 정규식
	  var pwdCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;

	  if (!pwdCheck.test(pwd.value)) {
	    alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
	    pwd.focus();
	    return false;
	  };

	  if (repwd.value !== pwd.value) {
	    alert("비밀번호가 일치하지 않습니다..");
	    repwd.focus();
	    return false;
	  };

	  if (uname.value == "") {
	    alert("이름을 입력하세요.");
	    uname.focus();
	    return false;
	  };

	  if (!female.checked && !male.checked) { //둘다 미체크시
	    alert("성별을 선택해 주세요.");
	    female.focus();
	    return false;
	  }

	  var reg = /^[0-9]+/g; //숫자만 입력하는 정규식

	  if (!reg.test(mobile.value)) {
	    alert("전화번호는 숫자만 입력할 수 있습니다.");
	    mobile.focus();
	    return false;
	  }

	  if (email_id.value == "") {
	    alert("이메일 주소를 입력하세요.");
	    email_id.focus();
	    return false;
	  }

	  //입력 값 전송
	  document.join_form.submit(); //유효성 검사의 포인트   
	}
function checkidsame(){
	var id = document.getElementById('ac_id');
	let idValue = id.value;
	   
	if(idValue == ""){
      alert("아이디를 입력하시오."); 
      id.focus();
 	} else{
 		
	// ajax : 비동기 통신 기술
	// url : 어디로 보낼지?
	// data : parameter로 뭘 보낼지?
	// dataType : 어떤걸 받을지?
	// contentType : 어떤걸 보낼지?
	// success : 성공했을 때 실행할 콜백 (함수)
	// onError : 실패했을 때 
	
	$.ajax({
		url: "check.id",
		data: {
			"ac_id2" : idValue
			}
	}).done(function(res){
	//0 or 1
			if(res == 0) {
				//check-id-result
				// 현재 텍스트 :$('#check-id-result').text();
				// 값 세팅 $('#check-id-result').text(값);
				$('#check-id-result').css('color', 'green');
				$('#check-id-result').text('가능합니다');
				$("#ac_pw").attr("disabled",false);
				$('#ac_pw2').attr("disabled",false); 
				console.log('가능합니다.');
			} else {
				console.log('불가합니다.');
				$('#check-id-result').css('color', 'red');
				$('#check-id-result').text('불가합니다');
			}
		})
	}
}

function makeNum(){
	const token = String(Math.floor(Math.random() * 1000000)).padStart(6, "0");
	alert(token);
  	document.getElementById("sendMessage").innerText = token;
  	document.getElementById("completion").disabled = false;
}

function checkCompletion(){
	let makeNumCheck = document.getElementById("makeNumCheck").value;
	const token = document.getElementById("sendMessage").innerText;
	
	if(makeNumCheck == token){
	  alert("문자 인증이 완료되었습니다.");
	  document.getElementById("completion").innerHTML="인증완료";
	}else{
		alert("인증번호가 다릅니다.");
	}
}

function sendSMS(){
	let sendToNum = document.getElementById("phone").value;
		
		var phone = document.getElementById('phone');
		
		if(sendToNum == ""){
			alert("휴대폰 번호를 입력하시오."); 
			phone.focus();
			return;
		}
		
  		document.getElementById("check-id-result").style.display = "block";
  		
  		$.ajax({
  			url: "sendSms.do",
  			data: {
  				"num" : sendToNum
  				}
  		}).done(function(res) {
  			$('#check-id-result').attr("display","block");
			$('#Random-num-input').val(res);
		})
    }
    function checkCompletion(){
    	
    	let ranNum = $('#Random-num-input').val();
    	let userNum = $('#makeNumCheck').val();
    	
    	console.log(typeof ranNum);
    	console.log(typeof userNum);
    	
    	console.log(ranNum == userNum);
    	
    	if(userNum == '') {
    		alert("인증번호를 입력하세요.");
    		return;
    	}
    	
    	if(ranNum == userNum) {
    		alert("본인 인증에 성공하였습니다.");
    		 /*	$('#regSubmit').attr("disabled", 'false'); */
    	} else {
    		alert("본인 인증에 실패하였습니다.");
    		$("#makeNumCheck").focus();
    	}
    	
    /*	let makeNumCheck = document.getElementById("makeNumCheck").value;
    	var resultNum = document.getElementById( 'completion' ).getAttribute( 'value' );
    	var check2 = document.getElementById("makeNumCheck");
    	
    	if(makeNumCheck != null){
	    	if(makeNumCheck == resultNum){
	    		alert("본인인증에 성공하셨습니다");
	    		document.getElementById("regSubmit").disabled = false;
	    	}else{
	    		alert("본인인증 실패");
	    		check2.focus();
	    	}
	    }else{
	    	alert("인증코드를 입력하시오");
	    	check2.focus();
	    }*/
    }
      function changeImg(event) {
        let reader = new FileReader();
        
        reader.onload = function (event) {
          $("#user-reg-image").remove();
          let img = document.createElement("img");
          img.setAttribute("src", event.target.result);
          img.setAttribute("width", "100%");
          img.setAttribute("height", "100%");
          img.setAttribute("id", "user-reg-image");
          img.setAttribute("style", "border-radius: 50%");
          $("#test-img").css("display", "none");
          document.querySelector("div#image_container").appendChild(img);
        };
        reader.readAsDataURL(event.target.files[0]);
      }
      
      
      
function findPw2(){
	//pwFind_id 이메일 
    //pwFind_name 이름
    
	let pwFind_id2 = $('#pwFind_id');
	let pwFind_id = $('#pwFind_id').val();
    let pwFind_name = $('#pwFind_name').val();	  
    
    // 예외처리 부분
    
    
    $.ajax({
    	url: "searchPW.do",
    	type: "POST",
    	data: {
    		"pwFind_id" : pwFind_id,
    		"pwFind_name" : pwFind_name
    	}
    }).done(function(res) {
		
		if(res != 0) {
			$('#isPwEx').css('display','block');
			$('.camping-login-button').css('display','none');
			$('.camping-login-button2').css('display','block');
			$('#pwFind-auth-hidden').val(res);
		}else{
			alert("이름/이메일 주소를 다시 확인해주세요");
			pwFind_id2.focus();
			return;
		}
	});
}

function goChangePw2() {
	// 이름, 아이디, 인증번호 받기
//	$('#pwFind_auth').val()
	//pwFind-auth-hidden
	
	let originNum = $('#pwFind-auth-hidden').val();
	let userNum = $('#pwFind_auth').val();
	
	if(originNum == userNum) {
		//이름과 id 받기
		
		let ac_id = $('#pwFind_id').val();
	    
	    location.href = 'changePw.after.findPw.go?ac_id=' + ac_id; 
	}else{
		alert("인증번호가 맞지 않습니다.");
		return;
	}
	
}
function searchID(){
	let idFind_name = $('#idFind_name').val();
    let idFind_phone = $('#idFind_phone').val();	  
    
    // 예외처리 부분
    
    $.ajax({
    	url: "searchID.do",
    	
    	data: {
    		"ac_name" : idFind_name,
    		"ac_phone" : idFind_phone
    	}
    }).done(function(res) {
		
		if(res != 0) {
			$("#modal").fadeIn(300);
			$(".modal1").fadeIn(300);
			$('#idFind-auth-hidden').val(res);
			$('.findId_span').text(res);
		}
	});
}
function double_check_pw(){
	let pw_check = $('#ask_pw_check').val();
	let real_id = $('.ask_pw_check3').val();
    
    // 예외처리 부분
    
	//
    $.ajax({
    	type: 'post',
    	url: "doubleCheckPw.go",
    	data: {
    		"ac_pw4" : pw_check,
    		"ac_id4" : real_id
    	}
    }).done(function(res) {
		
		if(res != 1) {
			 $('#ask_pw_check2').show();
			
		}else{
			location.href='myPage.do'; //페이지 이동
		}
	});

	
}
function deleteUser(user_id) {
	
	if(confirm("정말 탈퇴하시겠습니까?")){
		location.href='deleteUser.do?ac_id'+user_id; //페이지 이동
	}else{
		return;
	}
	
}

