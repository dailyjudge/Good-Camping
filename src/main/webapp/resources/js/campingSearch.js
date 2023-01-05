function showCampingSiteView(x, y) {

	console.log("x : " + x);
	console.log("y : " + y);

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div

	mapOption = {
		center : new kakao.maps.LatLng(y, x), // 지도의 중심좌표
		level : 3
	};
	var map = new kakao.maps.Map(mapContainer, mapOption);

	var markerPosition = new kakao.maps.LatLng(y, x);

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position : markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);

	let facltNm = $('#detail-facltNm').val();
	let firstImageUrl = $('#detail-firstImageUrl').val();
	let homepage = $('#detail-homepage').val();
	let zipcode = $('#detail-zipcode').val();
	let addr = $('#detail-addr1').val();

	// 커스텀 오버레이에 표시할 컨텐츠 입니다
	// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
	// 별도의 이벤트 메소드를 제공하지 않습니다
	var content = homepage != '#' ? '<div class="wrap">'
			+ '    <div class="info">' + '        <div class="title">'
			+

			facltNm
			+

			'            <div class="close" onclick="closeOverlay()" title="닫기"></div>'
			+ '        </div>'
			+ '        <div class="body">'
			+ '            <div class="img">'
			+ '                <img src="'
			+ firstImageUrl
			+ '" width="73" height="70">'
			+ '           </div>'
			+ '            <div class="desc">'
			+ '                <div class="ellipsis">'
			+ addr
			+ '</div>'
			+ '                <div class="jibun ellipsis">(우) '
			+ zipcode
			+ '(지번) 영평동 2181</div>'
			+ '                <div><a href="'
			+ homepage
			+ '" target="_blank" class="link">홈페이지</a></div>'
			+ '            </div>' + '        </div>' + '    </div>' + '</div>'
			:

			'<div class="wrap">' + '    <div class="info">'
					+ '        <div class="title">' +

					facltNm +

					'            <div class="close" onclick="closeOverlay()" title="닫기"></div>'
					+ '        </div>' + '        <div class="body">'
					+ '            <div class="img">'
					+ '                <img src="' + firstImageUrl
					+ '" width="73" height="70">' + '           </div>'
					+ '            <div class="desc">'
					+ '                <div class="ellipsis">' + addr
					+ '</div>'
					+ '                <div class="jibun ellipsis">(우) '
					+ zipcode + '(지번) 영평동 2181</div>' + '            </div>'
					+ '        </div>' + '    </div>' + '</div>';

	// 마커 위에 커스텀오버레이를 표시합니다
	// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
	var overlay = new kakao.maps.CustomOverlay({
		content : content,
		map : map,
		position : marker.getPosition()
	});

	// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
	kakao.maps.event.addListener(marker, 'click', function() {
		overlay.setMap(map);
	});

}

// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다
function closeOverlay() {
	overlay.setMap(null);
}

function searchCampingSite() {

	let searchVal = $('#search-input').val();
	console.log(searchVal);

	// 아무것도 입력되지 않았으면
	if (searchVal === '') {
		alert("검색어를 입력하세요");
		$('#search-input').focus();
		return false;
	}

	// 두글자 이상 입력
	if (searchVal.length < 2) {
		alert("검색어는 두 글자 이상 입력하세요.");
		$('#search-input').focus();
		return false;
	}

	return true;
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

function heartClick(no) {
	let src = $('.camping-like-img-' + no).attr('src')
	let userId = $('#camping-login-id-'+ no).val();
	let siteNo = $('#camping-site-id-' + no).val();
	
	console.log("userId : " + userId);
	console.log("siteNo : " + siteNo);
	// 로그인 되지 않았다면 처리!
	
	if (src == 'resources/camping-detail-icon/not-like.png') {
		// 좋아요 누른 상태
		$('.camping-like-img-' + no).attr('src',
				'resources/camping-detail-icon/like.png');

		$(".camping-like-img-" + no).animate({
			width: "25px" 
		}, 300 ); 
		
		$(".camping-like-img-" + no).animate({			
			width: "20px"	
		}, 300 ); 
		
		// 좋아요를 실제 디비에 적용
		$.ajax({
			url: "do.create.campingSite.like",
			type: "GET",
			data: {"cl_userId": userId,
				   "cl_siteNo": siteNo}
		}).done(function(res) {
			console.log(res);
			console.log("생성 성공!!");
			//camping-like-count-${c.c_no }
			$('.camping-like-count-' + siteNo).text(res); 
		});
	} else {
		// 좋아요 취소
		$('.camping-like-img').attr('src',
				'resources/camping-detail-icon/not-like.png');
		
		// 좋아요를 실제 디비에 적용
		$.ajax({
			url: "do.delete.campingSite.like",
			type: "GET",
			data: {"cl_userId": userId,
				   "cl_siteNo": siteNo}
		}).done(function(res) {
			console.log(res);
			console.log("삭제 성공!!");
			//camping-like-count-${c.c_no }
			$('.camping-like-count-' + siteNo).text(res); 
		});
	}
}
