const autoHyphen2 = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}
function daumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
							: data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById("extraAddress").value = extraAddr;


            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
            document.getElementById("user_postcode").style.display = 'block';
        }
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
	  //생년월일
	  let birth = document.getElementById("ac_birth");
	  //주소
	  let postcode = document.getElementById("postcode");
	  let address = document.getElementById("address");
	  let detailAddress = document.getElementById("detailAddress");
	  let extraAddress = document.getElementById("extraAddress");
	  
	  //값 입력 확인
		  if (email == "") { 
			    alert("아이디를 입력하세요.");
			    user_email.focus(); 
			    return false; 
			  };
		  if (pwd.value == "" || pwd.value.length < 4) {
		    alert("비밀번호를 입력하세요.");
		    pwd.focus();
		    return false;
		  };
		  if (uname.value == "") {
			  alert("이름을 입력하세요.");
			  uname.focus();
			  return false;
		  };
		  if (files.value == "") {
			  alert("파일을 업로드해주세요.");
			  files.focus();
			  return false;
		  };
		  if (gender.value == "") {
			  alert("성별을 입력하세요.");
			  gender.focus();
			  return false;
		  };
		  if (mobile.value == "") {
			  alert("휴대폰 번호를 입력하세요.");
			  mobile.focus();
			  return false;
		  };
		  if (birth.value == "" || birth.value.length !=6 ) {
			  alert("생년월일을 입력하세요.");
			  birth.focus();
			  return false;
		  };
		  if (postcode.value == "") {
			  alert("우편번호를 입력하세요.");
			  postcode.focus();
			  return false;
		  };
		  if (address.value == "") {
			  alert("주소를 입력하세요.");
			  address.focus();
			  return false;
		  };
		  if (detailAddress.value == "") {
			  alert("상세주소를 입력하세요.");
			  detailAddress.focus();
			  return false;
		  };
		  if (extraAddress.value == "") {
			  alert("참고항목을 입력하세요.");
			  extraAddress.focus();
			  return false;
		  };

		  //비밀번호 재확인
		  if (repwd.value !== pwd.value) {
			    alert("비밀번호가 일치하지 않습니다..");
			    repwd.focus();
			    return false;
			  };			  
	  // 이메일확인
		var idCheck = /@./;

		if (!idCheck.test(email)) {
		    alert("이메일 형식으로 입력해주세요.");
		    user_email.focus();
		    return;
		};

		alert("성공!");
		  //입력 값 전송
		  document.join_form.submit(); //유효성 검사의 포인트   

	}
function checkidsame(){
	var id = document.getElementById('ac_id');
	let idValue = id.value;
	var idCheck = /@./;

	if (!idCheck.test(idValue)) {
	    alert("이메일 형식으로 입력해주세요.");
	    id.focus();
	    return;
	};
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
		}).done(function(res) {
			// 0 or 1
			if (res == 0) {
				// check-id-result
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

function makeNum() {
	const token = String(Math.floor(Math.random() * 1000000)).padStart(6, "0");
	alert(token);
	document.getElementById("sendMessage").innerText = token;
	document.getElementById("completion").disabled = false;
}

function checkCompletion() {
	let makeNumCheck = document.getElementById("makeNumCheck").value;
	const token = document.getElementById("sendMessage").innerText;

	if (makeNumCheck == token) {
		alert("문자 인증이 완료되었습니다.");
		document.getElementById("completion").innerHTML = "인증완료";
	} else {
		alert("인증번호가 다릅니다.");
	}
}

function sendSMS() {
	let sendToNum = document.getElementById("phone").value;

	var phone = document.getElementById('phone');

	if (sendToNum == "") {
		alert("휴대폰 번호를 입력하시오.");
		phone.focus();
		return;
	}

	//document.getElementById("check-id-result").style.display = "block";

  		$.ajax({
  			url: "sendSms.do",
  			data: {
  				"num" : sendToNum
  				}
  		}).done(function(res) {
  			$('#check-id-result2').css('display','flex');
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
    		$('#ac_birth').attr("disabled", false);
    		$('#postcode').attr("disabled", false);
    		$('#phoneText').attr('style', "display:none;");
    		 /*	$('#regSubmit').attr("disabled", 'false'); */
    	} else {
    		alert("본인 인증에 실패하였습니다.");
    		$("#makeNumCheck").focus();
    	}
    	

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
		} else {
			alert("이름/이메일 주소를 다시 확인해주세요");
			pwFind_id2.focus();
			return;
		}
	});
}

function goChangePw2() {
	// 이름, 아이디, 인증번호 받기
	// $('#pwFind_auth').val()
	// pwFind-auth-hidden

	let originNum = $('#pwFind-auth-hidden').val();
	let userNum = $('#pwFind_auth').val();

	if (originNum == userNum) {
		// 이름과 id 받기

		let ac_id = $('#pwFind_id').val();
	    
	    location.href = 'changePw.after.findPw.go?ac_id=' + ac_id; 
	}else{
		alert("인증번호가 맞지 않습니다.");
		return;

	}

}

function searchID() {
	let idFind_name = $('#idFind_name').val();
	let idFind_phone = $('#idFind_phone').val();

	// 예외처리 부분

	$.ajax({
		url : "searchID.do",

		data : {
			"ac_name" : idFind_name,
			"ac_phone" : idFind_phone
		}
	}).done(function(res) {

		if (res != 0) {
			$("#modal").fadeIn(300);
			$(".modal1").fadeIn(300);
			$('#idFind-auth-hidden').val(res);
			$('.findId_span').text(res);
		}
	});
}

function double_check_pw() {
	let pw_check = $('#ask_pw_check').val();
	let real_id = $('.ask_pw_check3').val();

	// 예외처리 부분

	//
	$.ajax({
		type : 'post',
		url : "doubleCheckPw.go",
		data : {
			"ac_pw4" : pw_check,
			"ac_id4" : real_id
		}
	}).done(function(res) {

		if (res != 1) {
			$('#ask_pw_check2').show();

		} else {
			location.href = 'myPage.do'; // 페이지 이동
		}
	});

}

function deleteUserA(user_id) {
	let delConfirm = confirm("정말 탈퇴하시겠습니까?");
	
	if(delConfirm){
		location.href='deleteUser.do?ac_id='+user_id; //페이지 이동
	}else{
		alert("취소하였습니다");
	}
	
}

function safetyPasswordPattern(str) {

    var pass = str.value;
    var message = "";
    var color = "";
    var checkPoint = 0;

    // 입력값이 있을경우에만 실행
    if(pass.length) {

        // 최대 입력 글자수를 제한한다.
        if(pass.length < 4 || pass.length > 16) {
            message = ":: 최소 4자 이상, 최대 16자 이하 ::";
            color = "#A23E48";
        }

        // 문자열의 길이가 8 ~ 16 인경우
        else {

            // 비밀번호 문자열에 숫자 존재 여부 검사
            var pattern1 = /[0-9]/;  // 숫자
            if(pattern1.test(pass) == false) {
                checkPoint = checkPoint + 1;
            }

            // 비밀번호 문자열에 영문 소문자 존재 여부 검사
            var pattern2 = /[a-z]/;
            if(pattern2.test(pass) == false) {
                checkPoint = checkPoint + 1;
            }

            // 비밀번호 문자열에 영문 대문자 존재 여부 검사
            var pattern3 = /[A-Z]/;
            if(pattern3.test(pass) == false) {
                checkPoint = checkPoint + 1;
            }

            // 비밀번호 문자열에 특수문자 존재 여부 검사
            var pattern4 = /[~!@#$%^&*()_+|<>?:{}]/;  // 특수문자
            if(pattern4.test(pass) == false) {
                checkPoint = checkPoint + 1;
            }

            if(checkPoint >= 3) {
                message = ":: 보안성이 취약한 비밀번호 ::";
                color = "#A23E48";
            } else if(checkPoint == 2) {
                message = ":: 보안성이 낮은 비밀번호 ::";
                color = "#FF8C42";
            } else if(checkPoint == 1) {
                message = ":: 보안성이 보통인 비밀번호 ::";
                color = "#FF8C42";
            } else {
                message = ":: 보안성이 강력한 비밀번호 ::";
                color = "#0000CD";
            }
        }
    }

    else {
        message = ":: 비밀번호를 입력해 주세요 ::";
        color = "#000000";
    }

    document.getElementById("makyText").innerHTML = message;
    document.getElementById("makyText").style.color = color;
}

