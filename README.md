# Good-Camping :tent:  

<table>

  <tbody>
    	<tr>
		  <td align="center">프로필</td>
		  <td align="center">담당 업무</td>
		  <td align="center" colspan="2">개발 기간</td>
	 </tr>	 
    <tr>
      <td align="center">
	      <a href="https://github.com/dailyjudge" target="_blank">
	      <img src="https://user-images.githubusercontent.com/108406531/215073930-f44fa9d6-c61a-4767-b496-cda8404320f9.PNG" width="200px;" alt=""/>
	      <br />
	      <sub><b>정민규(Team Leader)</b></sub>
	      </a>
	      <br />
       	      </td>
      <td align="left">
	    :purple_heart: 캠핑장 정보 <br />
	    :purple_heart: 로그인시 직전 페이지 유지 및 이동 <br />
	    :purple_heart: 자동 로그인 <br />
     	    </td>
      <td align="center" rowspan="5">
	    22.12.22 ~ 23.01.09
      </td>
   <tr/>
   <tr>
      <td align="center">
	      <a href="https://github.com/yeeun0526" target="_blank">
	      <img src="https://user-images.githubusercontent.com/108406531/215073930-f44fa9d6-c61a-4767-b496-cda8404320f9.PNG" width="200px;" alt=""/>
	      <br />
	      <sub><b>정민규(Team Membeer)</b></sub>
	      </a>
	      <br />
       	      </td>
      <td align="left">
	    :purple_heart: 메인 페이지 <br />
	    :purple_heart: 캠핑 스토어 <br />
     	    </td>
   <tr/>
   <tr>
      <td align="center">
	      <a href="https://github.com/HaJunyoung" target="_blank">
	      <img src="https://user-images.githubusercontent.com/108406531/215073930-f44fa9d6-c61a-4767-b496-cda8404320f9.PNG" width="200px;" alt=""/>
	      <br />
	      <sub><b>하준영(Team Member)</b></sub>
	      </a>
	      <br />
       	      </td>
      <td align="left">
	    :purple_heart: 회원 관리 <br />
	    :purple_heart: 캠핑 톡톡 <br />
     	    </td>
   <tr/>
  </tbody>
</table>
	      
## :fire: 소개
코로나 대유행 시대가 지나고 여행은 망설이지만 일상적 공간을 통해 특별한 경험을 원하는 사람들이 증가하고있다. 이러한 공간 소비형 여가생활에 대한 사람들의 선호도가 높아지고 있는 가운데 우리는 캠핑을 즐기는 캠퍼들을 대상으로 캠핑장에 대한 다양한 정보를 제공하고자 사이트를 기획하였다.  
TourAPI4.0에서 제공하는 고캠핑 API를 이용하여 응답받은 국내 캠핑장 데이터를 자체 DB화하여 운영 및 관리하였고, 
이에 더불어 캠핑 스토어를 이용한 비즈니스 가치 창출까지 목표로 한 사이트이다. 

## :fire: 기술스택  
<img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">
<img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">


<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/apache maven-C71A36?style=for-the-badge&logo=apachetomcat&logoColor=white">
<img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black"> <img src="https://img.shields.io/badge/visual studio code-007ACC?style=for-the-badge&logo=visualstudio&logoColor=white">

<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/eclipse ide-525C86?style=for-the-badge&logo=eclipse&logoColor=white">
<img src="https://img.shields.io/badge/sourcetree-blue?style=for-the-badge&logo=sourcetree&logoColor=white"> 
<img src="https://img.shields.io/badge/discord-purple?style=for-the-badge&logo=discord&logoColor=white">  

## :fire: 주요 기능
:zap: 회원 관리(회원가입, ID·PW 찾기, 로그인, 회원 정보 조회·수정·탈퇴) 
  
:zap: 캠핑장 정보(캠핑장 조회·상세 조회, 카카오 맵·카카오 모빌리티 길찾기, 리뷰·조회수·좋아요, 테마·지도·검색어 검색, 좋아요 누른 목록)   
  
:zap: 캠핑 스토어(상품 조회·상세·추천·결제, 장바구니, 주문 목록 조회)  
  
:zap: 캠핑 톡톡(게시글 조회·상세·수정·삭제)    


## :fire: 기능별 소개
### :zap: 회원 관리

### :zap: 캠핑장 정보
  #### 2.1 캠핑장 데이터 
  * 고캠핑 API를 통한 캠핑장 데이터 최신화
  ```java
  public void refreshCampingData(HttpServletRequest request) {
		HttpURLConnection huc = null;
    
		try {
			if (ss.getMapper(MainMapper.class).deleteAlldata() >= 1) {
				System.out.println("데이터 삭제 완료!");
			}

			String url = "http://apis.data.go.kr/B551011/GoCamping/basedList?MobileOS=WIN&MobileApp=Myapp&serviceKey=[개인 고유키]&_type=json&numOfRows=5000";

			URL u = new URL(url);

			huc = (HttpURLConnection) u.openConnection();
			huc.addRequestProperty("accept", "application/json");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
      
			JSONObject data = (JSONObject) jp.parse(isr);
			JSONObject res = (JSONObject) data.get("response");
			JSONObject body = (JSONObject) res.get("body");
			JSONObject items = (JSONObject) body.get("items");
			JSONArray item = (JSONArray) items.get("item");

			// 총 개수
			int count = 0;

			for (Object object : item) {
				JSONObject site = (JSONObject) object;

//			zipcode 우편번호
				int zipcode = Integer.parseInt(site.get("zipcode").toString().replace("-", ""));
        
//			addr1 주소
				String addr1 = site.get("addr1").toString();

                        ... 중략 ...
         
				MainDTO m = new MainDTO(0, zipcode, addr1, animalCmgCl, bizrno, brazierCl, caravAcmpnyAt,
						caravInnerFclty, caravSiteCo, clturEventAt, trlerAcmpnyAt, exprnProgrmAt, clturEvent, doNm,
						sigunguNm, exprnProgrm, facltNm, firstImageUrl, glampInnerFclty, glampSiteCo, gnrlSiteCo,
						homepage, insrncAt, intro, lineIntro, mapX, mapY, operDeCl, operPdCl, posblFcltyCl, resveCl,
						resveUrl, sbrsCl, tel, themaEnvrnCl, toiletCo, wtrplCo, tooltip, null, 0, 0, 0, 0, null, null);
				System.out.println(m.toString());
        
				count++;

				if (ss.getMapper(MainMapper.class).insertCampingData(m) == 1) {
					System.out.println(count + "번 째 데이터 삽입 완료");
				} else {
					System.out.println(count + "번 째 데이터 삽입 불가");
				}

			}
   }
   ```
   #### 2.2 캠핑장 조회
   * 조회수, 좋아요 수, 리뷰수 순으로 정렬되어 캠핑장 정보 제공
   * 제공되는 부대시설 내용을 이미지로 표현
   * 로그인된 유저가 좋아요를 클릭하면 좋아요 누른 목록에 저장
   * 10개 단위로 페이징 처리
   
   #### 2.3 캠핑장 상세
   * 캠핑장 홈페이지로 이동할 수 있는 링크 제공
   * 캠핑장 소개글, 캠핑장에 대한 상세 설명 제공
      - 카라반, 글램핑 장소 유무 여부
      - 캠핑장 시설 정보
      - 기타 주요시설 정보
   * 카카오 맵을 이용해 캠핑장의 실제 위치를 화면에 표시
   * 카카오 모빌리티 길찾기를 이용해 사용자의 현재 위치를 기반으로 소요되는 시간 정보 제공
   * 캠핑장에 대한 리뷰 작성 및 정보 제공
   
   #### 2.4 캠핑장 조회수
   * 캠핑장 상세 페이지 클릭시 조회수 1 증가
   * 새로고침 등 부정한 방법에 의한 조회수 예외 
   
   #### 2.5 캠핑장 좋아요
   * 캠핑장 조회 화면에서 사용자가 좋어요 누른 항목 확인 가능
   * 사용자가 좋아요 버튼을 클릭하거나 취소하면 ajax를 이용하여 실시간 데이터 반영 처리
   
   #### 2.6 캠핑장 검색
   * 검색어로 찾기
     - 원하는 키워드와 지역(선택)을 입력하여 캠핑장 검색
   * 테마로 찾기
     - 3개의 중분류, 32개의 소분류 항목 중 원하는 테마를 클릭하여 캠핑장 검색
   * 지도로 찾기
     - 지도 이미지에 해당 지역을 클릭하면 ajax를 이용하여 실시간으로 해당 지역 추천 캠핑장 정보 제공
   
   #### 2.7 좋아요 누른 목록
   * 사용자가 좋아요 누른 캠핑장 정보를 카드 형식으로 제공
   * 카드 아이템에 hover하면 캠핑장 해시태그 키워드 목록, 리뷰 별점 평균 보여주는 이벤트 사용
   * 카드 아이템 클릭시 해당 캠핑장 상세 정보 페이지로 이동
   
   
### :zap: 캠핑 스토어
 #### 3.1 캠핑용품 데이터 받기
 * 네이버 쇼핑 검색 API를 이용하여 카테고리별 실제 상품 정보 받기
 ```java
 	public void refreshStuffData() {
		// 네이버 대분류 카테고리
		String[] items = { "랜턴", "바비큐", "버너", "핫팩", "캠핑의자", "캠핑테이블", "캠핑코펠", "숯", "캠핑매트", "야전침대", "로프" };

		for (int i = 0; i < items.length; i++) {
			String str = items[i];

			String url = "https://openapi.naver.com/v1/search/shop.json?query=";

			HttpURLConnection huc = null;
			int count = 0;

			try {
				url += URLEncoder.encode(str, "utf-8");
				url += "&display=100";

				URL u = new URL(url);

				huc = (HttpURLConnection) u.openConnection();
				huc.addRequestProperty("X-Naver-Client-Id", [고유 Client-Id]);
				huc.addRequestProperty("X-Naver-Client-Secret", [고유 Client-Secret]);
				
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");

				JSONParser jp = new JSONParser();
				JSONObject stuffData = (JSONObject) jp.parse(isr);
				JSONArray products = (JSONArray) stuffData.get("items");

				for (Object p : products) {
					JSONObject stuff = (JSONObject) p;

					StuffDTO s = new StuffDTO();
					s.setS_brand(stuff.get("brand").toString());
					s.setS_category(stuff.get("category3").toString());
					s.setS_productId(stuff.get("productId").toString());
					s.setS_image(stuff.get("image").toString());
					s.setS_detail_category(stuff.get("category4").toString());
					s.setS_title(stuff.get("title").toString());
					s.setS_price(stuff.get("lprice").toString());

					System.out.println(s.toString());
					if (ss.getMapper(StuffMapper.class).insertStuff(s) == 1) {
						System.out.println(++count + "번째 데이터 삽입 성공");
					} else {
						System.out.println("실패");
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
 ```
 
  #### 3.2 상품 조회
  * 상품 정보를 12개 단위로 페이징 처리
  * 상단에 검색창을 통해 상품을 검색할 수 있음
 
  #### 3.3 상품 상세
  * 상세 페이지에서 상품을 장바구니에 담거나 바로 구매할 수 있음
  * jQuery를 이용하여 구매 수량을 변경할 때마다 총 가격 변경 이벤트 구현
  * 관련된 상품 중 판매량이 높은 4개의 아이템을 추천하는 기능 제공
    - 상품을 클릭하면 해당 상품 상세 페이지로 이동하도록 구현
  
  #### 3.4 장바구니
  * 사용자가 장바구니의 상품들을 개별/부분 삭제 가능하도록 함
  * 사용자가 개별 체크박스를 클릭할 때마다 총 가격 변경 이벤트 구현
  * 사용자가 삭제 버튼을 클릭할 시 ajax를 이용해 실시간 데이터 삭제 처리

  #### 3.5 상품 결제
  - 카카오페이 결제 이용
  
  #### 3.6 주문 상품 목록 조회
  
  
  
  
  
  
