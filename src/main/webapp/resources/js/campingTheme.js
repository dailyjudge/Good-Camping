$(function(){
    $('.theme-item-container').click(function(){
        let curSrc = $(this).children('img').attr('src');

        // 클릭이 된 상태라면
        if(curSrc.includes('click')) {
            curSrc = curSrc.slice(0, curSrc.length - 10) + ".png"

            // 이미지 처리
            $(this).children('img').attr('src', curSrc);

            // 글자색 변경
            $(this).children('span').css('color', 'black')
            
            // 배경 border
            $(this).css('border', '2px solid #fff');
        } else {
            curSrc = curSrc.slice(0, curSrc.length - 4) + "_click.png";
            
            // 이미지 처리
            $(this).children('img').attr('src', curSrc);

            // 글자색 변경
            $(this).children('span').css('color', '#8ec3b0')
            
            // 배경 border
            $(this).css('border', '2px solid #8ec3b0');
        }
    });
    
    $('.theme-btn').click(function() {
		// 보낼 문자열 
    	let data = "do.theme.search?";
    	
    	// 파라미터 이름
    	let paramName = ['t_valley', 't_sea', 't_mountain', 't_river',
    	't_tree', 't_fishingArea', 't_nationalPark', 't_amusement',
    	't_park', 't_lake', 't_skiArea', 't_golfArea', 't_market',
    	't_pet', 't_wifi', 't_firewood', 't_shower', 't_electric',
    	't_hotWater', 't_sauna', 't_library', 't_cafe', 't_fishing',
    	't_swimmingArea', 't_waterPlay', 't_exercise', 't_singArea',
    	't_leisure', 't_atv', 't_sled', 't_riding', 't_billiards'];
    	
    	// 보낼 데이터
    	let paramData = ['계곡', '바다', '산', '강변', '자연', '낚시', '국립공원',
    		'유원지', '공원', '호수', '스키', '골프', '매점', '가능', '무선인터넷',
    		'장작', '샤워', '전기', '온수', '사우나', '도서관', '카페', '낚시', '수영',
    		'물놀이', '운동시설', '노래방', '레저', 'atv', '썰매', '승마', '당구'];
    	
    	// 처음 삽입되는 데이터일 경우 & 생략
    	let flag = false;
    	
    	$('.theme-item-container').each(function(i, element) {
    		console.log('클릭3');
			// span 색상으로 확인!
    		let span = $(element).children('span');
    		
			let spanColor = $(span).css('color');
			
			// 검정색이 아니면!!
			if(spanColor != 'rgb(0, 0, 0)') {
				// 보낼 데이터의 이름에 따라 속성 이름 다르게
				// ThemeDTO
				if(!flag) {
					data += paramName[i] + "=" + paramData[i];
					flag = true;
				} else {
					data += '&' + paramName[i] + "=" + paramData[i];
				}
			} else {
				if(!flag) {
					data += paramName[i] + '=""';
					flag = true;
				} else {
					data += '&' + paramName[i] + '=""';
				}
			}
			
		})
		location.href = data;
	});
});