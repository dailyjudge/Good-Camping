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
					console.log(cart_id + "번 데이터 삭제");
					//stuff-in-cart-${carts.sc_cart_id }
					$('.stuff-in-cart-' + cart_id).remove();
					
					// 여기서 모든 값들을 저장
					let money = 0;
					
					$('.stuff-hidden-price-input').each(function(index, element) {
						console.log($(element).val());
						money += parseInt($(element).val());
					})
					console.log(money);
					money = money.toLocaleString();
					//10000 => 10,000
					
					let spanText =  "결제예정금액   " + money + "원  ";
					console.log("spanText : " + spanText);
					if(money == 0) {
						$('.stuff-total-price').css("display", "none");
					}
					$('.stuff-total-price-span').text(spanText);
				} else {
					console.log("장바구니 아이템 삭제 에러!!");
				}
			})
		}
	});
	
		alert("삭제가 완료되었습니다!");
}

$(function() {
	$('#stuff-in-cart-allcheck').click(function() {
		let isChecked = $(this).is(':checked');
		console.log(isChecked);
		
		$('.stuff-in-cart-check').each(function(index, element) {
			$(element).prop('checked',isChecked);
		});
	});
});


function insertCart() {
	
	
	$.ajax({
		
		url:"do.insert.cart",
		data:{"s_no": $("#insertCart-btn").val()}
	}).done(function(data) {
		console.log(data)
		alert($("#insertCart-btn").val()+"장바구니 담기 성공!");
		
	});
	
}


	
