$(function() {
	$('#cart-choice-1')
			.click(
					function() {
						$(this).css('background-color', '#3cb371').css('color',
								'#fff');
						$('#cart-choice-2').css('background-color', '#fff')
								.css('color', 'black');

						$('#cart-div').css('display', 'flex');
						$('#cart-div2').css('display', 'none');
					});

	$('#cart-choice-2')
			.click(
					function() {
						$(this).css('background-color', '#3cb371').css('color',
								'#fff');
						$('#cart-choice-1').css('background-color', '#fff')
								.css('color', 'black');

						$('#cart-div').css('display', 'none');
						$('#cart-div2').css('display', 'block');
					});
});