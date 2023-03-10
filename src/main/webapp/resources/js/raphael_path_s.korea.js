window.onload = function () {
 	var R = Raphael("south", 320, 400);
	var attr = {
		fill: "#fff",
		stroke: "#666",
		"stroke-width": 0.5,
		"stroke-linejoin": "round"
	};
	var aus = {};

// 경기도 : 좌상단 부터 시작
	aus.gygg = R.path("M69,74 76,76 78,74 78,68 81,67 83,64 94,67 98,62 102,60 111,58 114,68 119,68 122,72 128,74 130,79 140,88 140,90 134,94 137,100 135,107 154,116 148,118 150,124 147,129 146,139 144,145 139,146 134,152 127,153 125,159 120,162 109,158 107,161 94,160 98,157 97,153 92,156 93,146 87,147 85,141 91,143 95,137 91,136 89,133 92,131 97,131 97,123 108,125 112,120 120,113 120,112, 117,110 112,107 112,105 111,104 113,102, 109,98 102,104 89,102 86,96 82,99 71,92 73,87 69,85 71,82 69,79 69,74z").attr(attr);

// 서울 : 우하단 경기도와 경계에서 오른쪽시계방향으로 시작.
	aus.seoul = R.path("M112,118 118,112 111,108 110,104 111,102 109,100 102,106 98,109 99,113 104,116 110,118 112,118z").attr(attr);

// 인천 : 서울왼쪽상단 경계에서 아래쪽으로 시작
	aus.incheon = R.path("M96,109 98,115 102,117 108,119 110,120 107,123.5 98,121, 97,122 95,120 96,119 90,110 89,110 89,104 99,105z M79,105 84,105 85,107 85,111 80,110 79,105z").attr(attr);

	//aus.ganghwa = R.path("M79,105 84,105 85,107 85,111 80,110 79,105z").attr(attr);

// 강원도 : 서울오른쪽상단겹치는부분에서 시작
	aus.gangwon = R.path("M98,60 104,58 113,56 116,68 121,68 124,72 130,74 132,79 142,88 142,90 136,94 139,100 137,107 156,116 150,118 152,124 149,129 148,139 146,145 152,150 152,150 153.5,145 157,137 160,135 161,138 169,141 181,140 175,146 189,147 192,149 199,148 205,153 207,148 211,153 224,150 231,154 239,143 234,139 234,132 225,118 222,108 199,81 180,33 175,34 151,6 147,7 142,4 145,18 137,16 134,22 130,23 131,30 125,29 124,20 121,18 123,8 120,5 115,11 117,17 108,20 106,18 105,24 99,25 93,30 86,31 90,40 87,45 89,47 91,53 98,60 z").attr(attr);

	aus.chungbuk = R.path("M145,148 152,152 154,152 155,148 157,140 159,138 161,140 169,143 176,142 171.5,148 189,149 192,151 199,150 186,160 184,169 175,167 162,171 163,175 156,175 156,185 151,182 149,185 154,191 155,200 150,207 158,208 164,215 159,217 155,226, 146,227 140,224 135,218 136,213 133,209 133,208 132,203 140,199 124,193 127,186 131,182 127,178 128,173 121,163 128,160 128,155 133,155 135,155 140,147z").attr(attr);

	aus.daejeon = R.path("M131,209 131,208 130,203 135,199 122,195 116,204 116,214 118,215 121,211 124,214 z").attr(attr);

	aus.sejong = R.path("M125,186 129,182 125,178 126,173 121,166 118,170 117,181 123,190 z").attr(attr);

	aus.chungnam = R.path("M119,166 116,170 115,181 121,190 119,196 114,204 113,214 118,218 121,214 125,216 132,211 135,218 139,225 134,225 131,231 120,219 115,222 112,220 107,223 102,216 93,216 91,222 80,227 73,221 76,217 73,207 75,206 71,202 75,198 71,190 72,183 68,175 65,182 57,173 65,164 71,168 77,167 74,160 75,153 81,163 88,162 90,174 100,166 101,162.5 106,164 110,161 117,163.5 120,164 z").attr(attr);

	aus.jeonbuk = R.path("M142,227 136,227 131,233 120,221 115,224 112,222 107,225 102,218 93,218 91,224 80,229 77,238 85,238 83,242 84,248 77,249 65,259 78,264 70,268 71,274 75,276 81,273 86,264 95,268 101,267 102,271 101,277 104,279 116,277 122,280 128,275 137,279 139,273 139,265 135,258 138,252 148,237 154,235 155,228 150,230 z").attr(attr);

	aus.gwangju = R.path("M77,292 78,284 84,283 90,285 94,281 101,288 98,298 92,298 89,300 85,298 85,294 80,291 78,293 77,292z").attr(attr);

	aus.jeonnam = R.path("M68,270 70,276 75,278 81,275 86,266 95,270 101,269 102,273 101,279 104,281 116,279 122,282 128,277 137,281 135,290 144,301 144,310 140,309 138,315 132,313 135,321 141,319 140,328 134,326 133,333 131,333 130,319 120,325 121,329 125,337 115,345 106,339 111,337 111,332 115,334 116,327 105,330 98,333 93,334 94,346 87,347 81,336 78,343 70,355 63,354 63,343 66,341 63,336 71,335 64,326 74,321 69,313 61,319 62,306 58,305 61,300 55,288 63,277 63,273 68,270z M77,292 78,293 80,291 85,294 85,298 89,300 92,298 98,298 101,288 94,281 90,285 84,283 78,284 77,292z").attr(attr);

	aus.gyeongbuk = R.path("M198,153 188,160 186,171 177,169 165,172 166,177 158,177 158,187 152,185 151,185 156,191 157,200 153,205 161,207 166,216 161,218 157,226 156,236 160,241 168,241 173,253 180,256 178,252 183,250 182,246 189,241 184,238 186,232 193,232 200,230 203,233 207,241 200,249 194,248 191,254 193,259 201,260 207,264 215,258 220,259 229,249 238,255 240,251 246,255 250,240 252,232 248,235 241,235 244,227 242,213 246,176 245,157 241,144 233,154 230,156 224,152 211,155 208,151 206,155.5 200,151 198,153z M273,145 276,142 278,141 283,140 280,148 276,147 275,145 273,145z M306,150 310,150 309,152z M311,152 315,150 314,152z").attr(attr);

	//aus.ulleung = R.path("M273,145 276,144 283,140 280,148 276,147 275,145 273,145 z").attr(attr);

	//aus.dokdo = R.path("M312,150 316,150 315,152z M317,152 321,150 320,152z").attr(attr);

	aus.daegu = R.path("M184,258 180,253 185,251 184,247 191.5,241 185.5,237 187.5,234 193,234 200,232 201.5,235 205.5,241 199.5,247 193,247 189.5,253 191,259 186,256 184,258 z").attr(attr);

	aus.gyeongnam = R.path("M147,301 138,288 141,275 142,264 138,258 142,251 146,244 152,238 155,238 159,243 166,244 172,256 180,258 184,261 186,259 192,262 198,262 208,267 213,262 219,260 216,264 221,268 229,272 229,276 220,284 213,287 205,300 194,296 194,302 184,301 181,307 186,308 181,315 181,318 175,315 168,317 162,313 161,304 157,304 154,309 151,308 146,312 z").attr(attr);

	aus.ulsan = R.path("M224,258 229.5,251 238,257 241,253 245,257 245,272 241,271 238,278 231,274 232,271 224,267 219,264 222,260 z").attr(attr);

	aus.busan = R.path("M232,277 224,284 215,289 213,293 209,298 212,299 217,299 220,303 225,302 231,296 232,290 239,282 235,279 z").attr(attr);

	aus.jeju = R.path("M96,377 105,367 120,368 126,365 134,365 142,370 136,380 127,384 114,386 104,384 100,385 94,377 z").attr(attr);

	var current = null;
	for (var state in aus) {
		aus[state].color = Raphael.getColor();
		console.log(aus[state].color);
		(function (st, state) {
			st[0].style.cursor = "pointer";
			st[0].onmouseover = function () { // onover
				current && aus[current].animate({fill: "#fff", stroke: "#666"}, 500) && (document.getElementById(current).style.display = "");
				
				switch(state){
					case "seoul":
						st.animate({fill: "#f3a683", stroke: "black"}, 500);
						break;
					case "gygg":
						st.animate({fill: "#f7d794", stroke: "black"}, 500);
						break;
					case "incheon":
						st.animate({fill: "#778beb", stroke: "black"}, 500);
						break;
					case "gangwon":
						st.animate({fill: "#C4DFAA", stroke: "black"}, 500);
						break;
					case "chungbuk":
						st.animate({fill: "#ffb8b8", stroke: "black"}, 500);
						break;
					case "chungnam":
						st.animate({fill: "#f19066", stroke: "black"}, 500);
						break;
					case "daejeon":
						st.animate({fill: "#f5cd79", stroke: "black"}, 500);
						break;
					case "sejong":
						st.animate({fill: "#546de5", stroke: "black"}, 500);
						break;
					case "jeonbuk":
						st.animate({fill: "#D6A2E8", stroke: "black"}, 500);
						break;
					case "gwangju":
						st.animate({fill: "#f0932b", stroke: "black"}, 500);
						break;
					case "jeonnam":
						st.animate({fill: "#f8a5c2", stroke: "black"}, 500);
						break;
					case "gyeongbuk":
						st.animate({fill: "#78e08f", stroke: "black"}, 500);
						break;
					case "daegu":
						st.animate({fill: "#ea8685", stroke: "black"}, 500);
						break;
					case "gyeongnam":
						st.animate({fill: "#7ed6df", stroke: "black"}, 500);
						break;
					case "ulsan":
						st.animate({fill: "#f8c291", stroke: "black"}, 500);
						break;
					case "busan":
						st.animate({fill: "#f78fb3", stroke: "black"}, 500);
						break;
					case "jeju":
						st.animate({fill: "#e056fd", stroke: "black"}, 500);
						break;

					default:
						st.animate({fill: "rgb(142, 195, 176)", stroke: "#3CB371"}, 500);
						break;
				}
				
				//st.toFront();
				R.safari();
				document.getElementById(state).style.display = "block";
				current = state;
 			}

			st[0].onmouseout = function () {
				st.animate({fill: "#fff", stroke: "#666"}, 500);
				//st.toFront();
				R.safari();
				document.getElementById(state).style.display = "none";
			};

			if ((sca == '01' && state == "seoul") || (sca == '09' && state == "gangwon")
			|| (sca == '08' && state == "gygg") || (sca == '04' && state == "incheon")
			|| (sca == '11' && state == "chungnam") || (sca == '10' && state == "chungbuk")
			|| (sca == '06' && state == "daejeon") || (sca == '17' && state == "sejong")
			|| (sca == '12' && state == "jeonbuk") || (sca == '05' && state == "gwangju")
			|| (sca == '13' && state == "jeonnam") || (sca == '14' && state == "gyeongbuk")
			|| (sca == '03' && state == "daegu") || (sca == '15' && state == "gyeongnam")
			|| (sca == '07' && state == "ulsan") || (sca == '02' && state == "busan")
			|| (sca == '16' && state == "jeju") )
			{
//				st[0].onmouseover();
			}


			st[0].onclick = function () {
				
				current = state;
				
				let area = '';
				
				switch(state) {
					case 'seoul':
						area = '서울';
						break;
					case 'gangwon':
						area = '강원도';
						break;
					case 'gygg':
						area = '경기도';
						break;
					case 'incheon':
						area = '인천';
						break;
					case 'chungnam':
						area = '충청남도';
						break;
					case 'chungbuk':
						area = '충청북도';
						break;
					case 'daejeon':
						area = '대전';
						break;
					case 'sejong':
						area = '세종';
						break;
					case 'jeonbuk':
						area = '전라북도';
						break;
					case 'gwangju':
						area = '광주시';
						break;
					case 'jeonnam':
						area = '전라남도';
						break;
					case 'gyeongbuk':
						area = '경상북도';
						break;
					case 'daegu':
						area = '대구';
						break;
					case 'gyeongnam':
						area = '경상남도';
						break;
					case 'ulsan':
						area = '울산';
						break;
					case 'busan':
						area = '부산';
						break;
					case 'jeju':
						area = '제주';
						break;
					default:
						area = 'error';
						break;
				}
				
				$.ajax({
					url: 'do.map.search',
					data: {"area": area}
				}).done(function(obj) {
					let campingSites = obj.campingSites;
					// 가장 외부 div 비워주기
					$('.camping-container').empty();
					// 요소 하나하나 추가해주기.
					$('.camping-theme-search-result').css('display', 'block');
					$('.camping-theme-search-result span').text("'" + area + "'에 관련된 정보");
					
					let count = 0;
					
					let reviewCount, c_no, siteLikeCount, cv_viewCount, c_firstImageUrl, c_doNm, c_sigunguNm, c_facltNm, c_lineIntro, c_addr1, c_tel, facilities;
					for(let i = 0; i < campingSites.length; i++) {
						let cv_viewCount = campingSites[i].cv_viewCount;
						let reviewCount = campingSites[i].reviewCount;
						let c_no = campingSites[i].c_no;
						let siteLikeCount = campingSites[i].siteLikeCount;
						let c_firstImageUrl = campingSites[i].c_firstImageUrl;
						let c_doNm = campingSites[i].c_doNm;
						let c_sigunguNm = campingSites[i].c_sigunguNm;
						let c_facltNm = campingSites[i].c_facltNm;
						let c_lineIntro = campingSites[i].c_lineIntro;
						let c_addr1 = campingSites[i].c_addr1;
						let c_tel = campingSites[i].c_tel;
						let facilities = campingSites[i].facilities;
						
						$('.camping-container').append(
						'<div class="camping-item-container">' +
							'<div class="camping-item-desc">' + 
								'<span class="camping-item-desc-item camping-item-desc-item1">관광사업자 등록업체</span>' +
								'<span class="camping-item-desc-item camping-item-desc-item2">리뷰수' + reviewCount +'</span>' +
								'<span class="camping-item-desc-item camping-item-desc-item3">조회수' + cv_viewCount + '</span>' +
								'<span class="camping-item-desc-item camping-item-desc-item4">' +
									'<img class="camping-like-img-tag" alt="" src="resources/camping-detail-icon/like.png">' +
									'<span class="camping-like-count camping-like-count-' + c_no + '">' + siteLikeCount + '</span>' +
								'</span>' +
							'</div>' +
							'<div class="camping-item-box-container">' +
								'<div class="camping-item-img-container">' +
									'<img src="' + c_firstImageUrl + '" onerror="this.src="resources/camping-search-img/campingSiteDefaultImg.png" alt = "">' +  
								'</div>' +
								'<div class="camping-item-desc2">' + 
									'<div class="camping-item-desc2-title camping-item-desc2-header">' +
										'<a href="go.camping.detail?c_no=' + c_no +'">[' + c_doNm + ' ' + c_sigunguNm + '] ' + c_facltNm + '</a>' +
									'</div>' + 
									'<div class="camping-item-desc2-title camping-item-desc2-content">' +
										'<a href="go.camping.detail?c_no=' + c_no + '">' + c_lineIntro + '</a>' +
									'</div>' +
									'<div class="camping-item-desc2-title camping-item-desc2-info">' +
										'<img class="camping-item-desc2-title-icon-position" src="resources/facilities-icon/position.png" alt="">' +
										'<span>' + c_addr1 + '</span>' +
										'<img class="camping-item-desc2-title-icon-phone" src="resources/facilities-icon/phoneCall.png" alt="">' +
										'<span>' + c_tel + '</span>' + 
									'</div>' + 
								'</div>' +
							'</div>' +
							'<div class="camping-item-facilities camping-item-facilities-' + c_no + '">' +
							'</div>' + 
						'</div>'
						);
						
						// 사진 처리
						for(let i = 0; i < facilities.length; i++) {
							$('.camping-item-facilities-' + c_no).append(
								'<div class="camping-item-facilities-items">' +
									'<img class="camping-item-facilities-icon" src="' + facilities[i].image + '" alt="">' + 
									'<span>' + facilities[i].desc + '</span>' +
								'</div>'
							);
						}
						
					}
					
				})
			};

		})(aus[state], state);
	}
};
