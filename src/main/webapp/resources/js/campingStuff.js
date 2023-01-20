function deleteCheckedItem() {
	
	// 이런 클래스 이름을 가진 친구들을 리스트로 for문 배열 돌려야함
	// checked 된 친구만 실제 db에 가서 삭제
	// 체크된 체크박스 찾기
	let count = 0;
	
	$('.stuff-in-cart-check').each(function(index, element) {
		if($(element).is(':checked')) count++;
	});
	
	if(count == 0) {
		alert('선택된 항목이 없습니다.');
		return;
	}
	
	$('.stuff-in-cart-check').each(function(index, element) {
		// 체크 돼있으면
		if($(element).is(':checked')) {
			console.log($(element));
			let cart_id = $(element).val();
			
			console.log("cart_id : " + cart_id);
			// 비동기로 삭제처리
			
			// url, 타입, 데이터, 데이터 타입(내가 받을거), 컨텐트 타입(내가 줄거)
			$.ajax({
				url: "do.delete.stuff.cart",
				type: "GET",
				data: {"sc_cart_id": cart_id},
			}).done(function(response) {
				console.log(response);
				if(response == 1) {
					$('#stuff-total-span').text(0);
				} else {
					console.log("장바구니 아이템 삭제 에러!!");
				}
				$('.stuff-in-cart-' + cart_id).remove();
			})
		}
	});
	
		alert("삭제가 완료되었습니다!");
}

$(function() {
	$('#stuff-in-cart-allcheck').click(function() {
		let isChecked = $(this).is(':checked');
		console.log(isChecked);
		
		if(isChecked) {
			let total = 0;
			$('.stuff-in-cart-check').each(function(index, element) {
				$(element).prop('checked',isChecked);
				
				// 수량
				let amount = $(this).next().next().next().text();
				// 가격
				let price = $(this).next().next().next().next().val();
				total += amount * price;
			});
			$('#stuff-total-span').text(total.toLocaleString());
		} else {
			
			$('.stuff-in-cart-check').each(function(index, element) {
				$(element).prop('checked', false);
			});
			
			$('#stuff-total-span').text(0);
		}
		
	});
});


function insertCart(id) {
	
	if(id == '') {
		alert('로그인이 필요한 서비스입니다.');
		return;
	}
	
	// 실시간으로 카트에 데이터를 삽입하는 일
	$.ajax({
		url:"do.insert.cart",
		data:{
			"s_no": $("#insertCart-btn").val()
			}
	}).done(function(data) {
		console.log(data)
		if(data == 1) {
			alert($("#insertCart-btn").val()+"장바구니 담기 성공!");
		} else {
			alert("장바구니 담기 실패");
		}
	});
	
}

$(function() {
	
	$('태그 클릭하는 버튼 클래스 or id 이름').click(function() {
		// 그 클릭한 키워드에 대한 정제 역할.
		// 2개 클릭했을 땐 이렇게 못함
//		let value = $(this).val();
		
		// 총 선택된 태그 이름들 다 리스트에 집어넣기
		let list = [];
		$('.태그 클래스 돌리기').each(function(index, element) {
			if($(element).색깔 == 체크된색깔) {
				list.add($(element.val()))
			}
		});
		
		let tag = '';
		// tag에 list에 들어가있는 문자열 다 합치기.
		// ex) list = ['랜턴', '로프']
		// tag = 랜턴로프
		for(let i = 0; i < list.length; i++) {
			tag += list[i];
		}
		
		// ajax로 비동기 요청해서 실시간으로 12개 데이터 받아와버리기!
		let query = "";
	});
});


function count(type) {
	  // 결과를 표시할 element
	  const resultElement = document.getElementById("stuff-amount-result");

	  // 현재 화면에 표시된 값
	  let number = resultElement.innerText;

	  // 더하기/빼기
	  if (type === "plus") {
	    number = parseInt(number) + 1;
	  } else if (type === "minus") {
	    if (parseInt(number) - 1 < 1) {
	      number = 1;
	    } else {
	      number = parseInt(number) - 1;
	    }
	  }

	  // 결과 출력
	  resultElement.innerText = number;
	}


	
