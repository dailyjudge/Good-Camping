// 휴대폰 번호 입력 부분
const autoHyphen = (target) => {
target.value = target.value
.replace(/[^0-9]/g, '')
.replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");

    const phone = document.getElementById("phone").value // 010
    if(phone.length === 13){
      document.getElementById("sendMessage").focus();
      document.getElementById("sendMessage").setAttribute("style","background-color:yellow;")
      document.getElementById("sendMessage").disabled = false;
    }
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
        }
    }).open();
}
function signUpCheck(){

	  let email = document.getElementById("ac_id").value
	  let password = document.getElementById("ac_pw").value
	  let passwordCheck = document.getElementById("ac_pw2").value
	  let name = document.getElementById("ac_name").value
	  let birth = document.getElementById("ac_birth").value
	  
	  let area = document.getElementById("postcode").value
	  let gender_man = document.getElementById("ac_gender_man").checked
	  let gender_woman = document.getElementById("ac_gender_woman").checked
	  let files = document.getElementById("ac_files")
	  let check = true;
  
	  // 이메일확인
	  if(email.includes('@')){
	    let emailId = email.split('@')[0]
	    let emailServer = email.split('@')[1]
	    if(emailId === "" || emailServer === ""){
	      document.getElementById("emailError").innerHTML="이메일이 올바르지 않습니다."
	      check = false
	    }
	    else{
	      document.getElementById("emailError").innerHTML=""
	    }
	  }else{
	    document.getElementById("emailError").innerHTML="이메일이 올바르지 않습니다."
	    check = false
	  }


	  // 이름확인
	  if(name===""){
	    document.getElementById("nameError").innerHTML="이름이 올바르지 않습니다."
	    check = false
	  }else{
	    document.getElementById("nameError").innerHTML=""
	  }


	  // 비밀번호 확인
	  if(password !== passwordCheck){
	    document.getElementById("passwordError").innerHTML=""
	    document.getElementById("passwordCheckError").innerHTML="비밀번호가 동일하지 않습니다."
	    check = false
	  }else{
	    document.getElementById("passwordError").innerHTML=""
	    document.getElementById("passwordCheckError").innerHTML=""
	  }

	  if(password===""){
	    document.getElementById("passwordError").innerHTML="비밀번호를 입력해주세요."
	    check = false
	  }else{
	    // document.getElementById("passwordError").innerHTML=""
	  }
	  if(passwordCheck===""){
	    document.getElementById("passwordCheckError").innerHTML="비밀번호를 다시 입력해주세요."
	    check = false
	  }else{
	    // document.getElementById("passwordCheckError").innerHTML=""
	  }


	  // 지역선택 확인
	  if(area === ""){
	    document.getElementById("areaError").innerHTML="지역을 선택해주세요."
	    check = false
	  }else{
	    document.getElementById("areaError").innerHTML=""
	  }

	  // 성별체크확인
	  if(!gender_man && !gender_woman){
	    document.getElementById("genderError").innerHTML="성별을 선택해주세요."
	    check = false
	  }else{
	    document.getElementById("genderError").innerHTML=""
	  }
	  
	  if(check){
	    document.getElementById("emailError").innerHTML=""
	    document.getElementById("nameError").innerHTML=""
	    document.getElementById("passwordError").innerHTML=""
	    document.getElementById("passwordCheckError").innerHTML=""
	    document.getElementById("areaError").innerHTML=""
	    document.getElementById("genderError").innerHTML=""
	    
	    // 비동기 처리이벤트
	    setTimeout(function() {
	      alert("가입이 완료되었습니다.")
	  },0);
	  }
	}
	
function checkidsame(){
	var id = document.getElementById('ac_id');
	let idValue = document.getElementById("ac_id").value;
	   
	if(idValue == ""){
      alert("아이디를 입력하시오."); 
      id.focus();
 	}
  else{
	location.href='check.id?ac_id2='+idValue;
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
		
  		document.getElementById("completion").disabled = false;
  		
  		location.href='sendSms.do?num='+sendToNum;
    }
    function checkCompletion(){
    	let makeNumCheck = document.getElementById("makeNumCheck").value;
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
          $("#user-profile").css("display", "none");
          document.querySelector("div#profile").appendChild(img);
        };
        reader.readAsDataURL(event.target.files[0]);
      }
