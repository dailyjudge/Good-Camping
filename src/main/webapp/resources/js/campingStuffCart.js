$(function() {

	$('.stuff-in-cart-check').click(function() {
		
		let total = 0;
		$('.stuff-in-cart-check').each(function(index, element) {
			if($(element).is(':checked')) {
				// 수량
				let amount = $(this).next().next().next().text();
				
				// 가격
				let price = $(this).next().next().next().next().val();
				
				total += amount * price;
			}
		});
		$('#stuff-total-span').text(total.toLocaleString());
	});
});	