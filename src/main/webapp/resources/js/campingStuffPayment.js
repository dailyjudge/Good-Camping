function searchAddr() {
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

				addr += extraAddr;

				// 조합된 참고항목을 해당 필드에 넣는다.
				// document.getElementById("stuff-extraAddress").value =
				// extraAddr;

			} else {
				// document.getElementById("stuff-extraAddress").value =
				// extraAddr;
				addr += '';
			}
			console.log(addr);
			console.log(extraAddr);
			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('stuff-postcode').value = data.zonecode;
			document.getElementById("stuff-Address").value = addr;
			// stuff-extraAddress
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("stuff-detailAddress").focus();

		}
	}).open();

}
function goOrderPage() {
	let data = '';
	$('.id_input').each(function(index, element) {
		data += $(element).val() + ",";
		console.log(data);
	})
	$('.so_data').val(data);
	return true;
}


function kakao_pay(items) {
	
	console.log('k1');
	console.log(items);
	
	
	
	$.ajax({
		url : 'kakao.ready.popup',
		type: 'post',	
		data : {'items' : items},
		dataType : 'json',
		success : function(data) {
			console.log(data);
			console.log(data.next_redirect_pc_url);

			
			console.log(data.tid);
			var win = window.open(data.next_redirect_pc_url, "PopupWin", "width=500,height=600,left=500");
			
			
			console.log('팝업 열리고 나서?');
			
			

		},
		error : function(error) {
			alert('결제실패');
			console.log('k3');
		}

	});

}

function goPaymentPage() {
	// input에 체크 된 친구를 찾아야됨

	let items = "";


		
	$('.stuff-in-cart-check').each(function(index, element) {
		if ($(element).is(':checked')) {
			items += $(element).val() + "," // id
		}
	});

	console.log(items);

	if (value = "") {
		alert('선택한 항목이 없습니다.');
		return;
	}

	location.href = "go.stuff.payment?items=" + items;
}
