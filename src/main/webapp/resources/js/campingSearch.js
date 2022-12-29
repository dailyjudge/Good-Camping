function showCampingSiteView(x, y) {
	console.log($('#mapX').val());
	console.log($('#mapY').val());
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng($('#mapY').val(), $('#mapX').val()), // 지도의 중심좌표
		level : 3
	};
	var map = new kakao.maps.Map(mapContainer, mapOption);
	
	$('.modal-wrapper').toggleClass('open');
	$('.page-wrapper').toggleClass('blur-it');
	
	return false;
}

$(document).ready(function() {
	$('.trigger').on('click', function() {
		$('.modal-wrapper').toggleClass('open');
		$('.page-wrapper').toggleClass('blur-it');
		return false;
	});
	
	$('.modal-wrapper').on('click', function() {
		console.log("하이!");
		$('.modal-wrapper').removeClass('open');
		$('.page-wrapper').removeClass('blur-it');
	});
});
