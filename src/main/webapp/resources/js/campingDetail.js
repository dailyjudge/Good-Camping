let lat;
let lon;
$(function() {
	$('.camping-find-way-button').hover(function() {
		$('.camping-find-way-button').text("확인하러 가기!");
	},function(){
		$('.camping-find-way-button').text("캠핑장? 얼마나 걸릴까?");
	});
	
	$('.camping-detail-type-item').click(function() {
		$('.camping-detail-type-item').removeClass('camping-category-selected');
		$(this).addClass('camping-category-selected');
		
		let val = $(this).children('span').text();
		
		$('.camping-category-item1').removeClass('camping-category-item-on');
		$('.camping-category-item2').removeClass('camping-category-item-on');
		$('.camping-category-item3').removeClass('camping-category-item-on');
		
		if(val == '캠핑장 소개') $('.camping-category-item1').addClass('camping-category-item-on');
		else if(val == '지도로 보기'){
			console.log($('#mapX').val());
			console.log($('#mapY').val());
			$('.camping-category-item2').addClass('camping-category-item-on');
			let x = $('#mapX').val();
			let y = $('#mapY').val();

			getUserLocation();
			
			showCampingSiteView(x, y);
		}
		else if(val == '리뷰') $('.camping-category-item3').addClass('camping-category-item-on');
	});

});



function findWay() {
	// 스피너 시작
	$('.camping-find-way-spinner-container').css('display', 'flex');
	
	// 현재 위치 알아내서 lat, lon 변수에 저장
	// lat : Y좌표 , lon : X좌표

	
	// 요청 데이터 전송 포맷 : "경도, 위도"
	// 출발지
	origin = lon + "," + lat;
	// 도착지
	destination = $('#mapX').val() + "," + $('#mapY').val();
	
	console.log("origin : " + origin)
	console.log("destination : " + destination);
	
	$.ajax({
		url: "https://apis-navi.kakaomobility.com/v1/directions",
		type: "GET",
		beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization","KakaoAK 5032cf67026bb5b8bfbeefb9dc40b496");
        },
        dataType: "json",
        data: {"origin": origin,
        	   "destination": destination}
	}).done(function(data) {
		let routes_data = data.routes[0];
		
		// 총 이동거리(m)
		let distance = Math.floor(routes_data.summary.distance / 1000) + "km"; 
		// 총 소요시간(s)
		let duration = Math.floor(routes_data.summary.duration / 3600) + "시간" + Math.floor((routes_data.summary.duration % 3600) / 60) + "분"; 
		// 택시 요금 (원)
		let feeOfTaxi = routes_data.summary.fare.taxi + "원";
		// 톨게이트비(원)
		let feeOfTollGate = routes_data.summary.fare.toll + "원";
		
		console.log("distance : " + distance);
		console.log("duration : " + duration);
		console.log("feeOfTaxi : " + feeOfTaxi);
		console.log("feeOfTollGate : " + feeOfTollGate);
		
		// 값 세팅
		$('#camping-find-way-distance').text(distance);
		$('#camping-find-way-duration').text(duration);
		$('#camping-find-way-feeOfTaxi').text(feeOfTaxi);
		$('#camping-find-way-feeOfToll').text(feeOfTollGate);
		
		// 스피너 끄기
		$('.camping-find-way-spinner-container').css('display', 'none');
		
		// 화면 보여주기
		$('.camping-find-way-items').css('display', 'flex');
	})
}

function success({ coords, timestamp }) {
	lat = coords.latitude;   // 위도
	lon = coords.longitude; // 경도
}

function getUserLocation() {
    if (!navigator.geolocation) {
        throw "위치 정보가 지원되지 않습니다.";
    }
    navigator.geolocation.getCurrentPosition(success);
}

function setBounds() {
    // LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
    // 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
    map.setBounds(bounds);
}
