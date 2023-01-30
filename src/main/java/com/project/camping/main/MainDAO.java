package com.project.camping.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.camping.account.AccountDAO;
import com.project.camping.account.AccountDTO;
import com.project.camping.theme.ThemeDTO;
import com.project.camping.theme.ThemeMapper;

@Service
public class MainDAO {

	@Autowired
	SqlSession ss;

	List<MainDTO> campingSites;
	private int count;

	public void refreshCampingData(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// https://apis.data.go.kr/B551011/GoCamping/basedList?MobileOS=WIN&MobileApp=Myapp&serviceKey=uj0JxuMvF%2FcIGI2PtCVMExwELp3ZDUDNfAh0TJAbIfq%2BADR3x1AkzqI0zxYnr7nfSadrs6%2BkLrHSDlswUViEjg%3D%3D&_type=json

		System.out.println("---------");
		System.out.println("refresh!!");

		Scanner sc = null;
		HttpURLConnection huc = null;
		int cnt = 0;
		try {

			if (ss.getMapper(MainMapper.class).deleteAlldata() >= 1) {
				System.out.println("데이터 삭제 완료!");
			}

			String url = "http://apis.data.go.kr/B551011/GoCamping/basedList?MobileOS=WIN&MobileApp=Myapp&serviceKey=uj0JxuMvF%2FcIGI2PtCVMExwELp3ZDUDNfAh0TJAbIfq%2BADR3x1AkzqI0zxYnr7nfSadrs6%2BkLrHSDlswUViEjg%3D%3D&_type=json&numOfRows=5000";

			URL u = new URL(url);

			// numOfRows

			huc = (HttpURLConnection) u.openConnection();
			huc.addRequestProperty("accept", "application/json");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();

			JSONObject data = (JSONObject) jp.parse(isr);
			// System.out.println(data);

			JSONObject res = (JSONObject) data.get("response");
			JSONObject body = (JSONObject) res.get("body");

			JSONObject items = (JSONObject) body.get("items");

			JSONArray item = (JSONArray) items.get("item");

			// System.out.println(item);

			// 총 개수
			int count = 0;

			for (Object object : item) {
				JSONObject site = (JSONObject) object;

//				System.out.println("-> " + ++count + " " + site.get("doNm"));

//				zipcode 우편번호
				int zipcode = Integer.parseInt(site.get("zipcode").toString().replace("-", ""));
//				addr1 주소
				String addr1 = site.get("addr1").toString();
//				animalCmgCl 애완동물 출입 (가능, 불가능)
				String animalCmgCl = site.get("animalCmgCl").toString();
//				bizrno 사업자 번호
				String bizrno = site.get("bizrno").toString();
//				brazierCl 화로대
				String brazierCl = site.get("brazierCl").toString();
//				caravAcmpnyAt 개인 카라반 동반 여부
				String caravAcmpnyAt = site.get("caravAcmpnyAt").toString();
//				caravInnerFclty 카라반 - 내부시설
				String caravInnerFclty = site.get("caravInnerFclty").toString();
//				caravSiteCo 주요시설 카라반
				String caravSiteCo = site.get("caravSiteCo").toString();
//				clturEventAt 자체 행사 여부 (Y:사용, N:미사용)
				String clturEventAt = site.get("clturEventAt").toString();
//				trlerAcmpnyAt 개인 트레일러 동반 여부 (Y:사용, N:미사용)
				String trlerAcmpnyAt = site.get("trlerAcmpnyAt").toString();
//				exprnProgrmAt 체험 프로그램 여부 (Y: 사용, N: 미사용)
				String exprnProgrmAt = site.get("exprnProgrmAt").toString();
//				clturEvent 자체 문화 행사명
				String clturEvent = site.get("clturEvent").toString();
//				doNm 도
				String doNm = site.get("doNm").toString();
//				sigunguNm 시군구
				String sigunguNm = site.get("sigunguNm").toString();
//				exprnProgrm 체험프로그램명
				String exprnProgrm = site.get("exprnProgrm").toString();
//				facltNm 야영장명
				String facltNm = site.get("facltNm").toString();
//				firstImageUrl 대표 이미지
				String firstImageUrl = site.get("firstImageUrl").toString();
//				glampInnerFclty 글램핑 - 내부시설
				String glampInnerFclty = site.get("glampInnerFclty").toString();
//				glampSiteCo 주요시설 글램핑
				String glampSiteCo = site.get("glampSiteCo").toString();
//				gnrlSiteCo 주요시설 일반 야영장
				String gnrlSiteCo = site.get("gnrlSiteCo").toString();
//				homepage 홈페이지
				String homepage = site.get("homepage").toString();
//				insrncAt 영업배상책임보험 가입여부(Y:사용, N:미사용)
				String insrncAt = site.get("insrncAt").toString();
//				intro 소개
				String intro = site.get("intro").toString();

				if (intro.length() > 500)
					intro = intro.substring(0, 500);
//				lineIntro 한줄 소개
				String lineIntro = site.get("lineIntro").toString();
				if (lineIntro.length() > 500)
					lineIntro = lineIntro.substring(0, 500);
//				mapX 경도 (X)
				String mapX = site.get("mapX").toString();
//				mapY 위도 (Y)
				String mapY = site.get("mapY").toString();
//				operDeCl 운영일
				String operDeCl = site.get("operDeCl").toString();
//				operPdCl 운영기간
				String operPdCl = site.get("operPdCl").toString();
//				posblFcltyCl 주변 이용 가능 시설
				String posblFcltyCl = site.get("posblFcltyCl").toString();
//				resveCl 예약 구분
				String resveCl = site.get("resveCl").toString();
//				resveUrl 예약 페이지
				String resveUrl = site.get("resveUrl").toString();
//				sbrsCl 부대시설
				String sbrsCl = site.get("sbrsCl").toString();
//				tel 전화
				String tel = site.get("tel").toString();
//				themaEnvrnCl 테마환경
				String themaEnvrnCl = site.get("themaEnvrnCl").toString();
//				toiletCo 화장실 개수
				String toiletCo = site.get("toiletCo").toString();
//				wtrplCo 개수대 개수
				String wtrplCo = site.get("wtrplCo").toString();
//				tooltip 툴팁
				String tooltip = site.get("tooltip").toString();

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

			System.out.println("데이터 총 개수 : " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DTO에 필요한 추가 정보 처리
	public void addDetailCampingSite(HttpServletRequest request, List<MainDTO> list) {
		HashSet<String> hs = new HashSet<String>();
		
		AccountDTO a = (AccountDTO) request.getSession().getAttribute("loginAccount");
		
		LikeDTO lDTO;
		// 테마 확인하기
		for (MainDTO mDTO : list) {
			String tag[] = mDTO.getC_sbrsCl().split(",");

			for (String s : tag) hs.add(s);
			
			// 유저가 좋아요 눌렀는지? (로그인 했는지 확인)
			if (a != null) {
				lDTO = new LikeDTO(0, a.getAc_id(), mDTO.getC_no());
				mDTO.setIsLiked(ss.getMapper(MainMapper.class).checkIsLikedCampingSite(lDTO) == 1 ? 1 : 0);
			} else {
				mDTO.setIsLiked(0);
			}
			
			
		}

		// 리스트를 돌면서 값 넣기!
		List<String> facilities = new ArrayList<String>();

		for (String s : hs)
			if (!s.equals("미제공"))
				facilities.add(s);

		List<facilityDTO> facilityItems;
		facilityDTO fDTO;

		for (MainDTO mDTO : list) {

			// default 이미지 처리
			if (mDTO.getC_firstImageUrl().equals("#"))
				mDTO.setC_firstImageUrl("resources/facilities-icon/firstImgUrldefault.png");
			// 값 대체
			facilityItems = new ArrayList<facilityDTO>();

			String tag[] = mDTO.getC_sbrsCl().split(",");

			for (String s : tag) {

				fDTO = new facilityDTO();
				if (s.equals("운동장"))
					fDTO.setImage("resources/facilities-icon/play.png");
				else if (s.equals("운동시설"))
					fDTO.setImage("resources/facilities-icon/exercise.png");
				else if (s.equals("전기"))
					fDTO.setImage("resources/facilities-icon/electricity.png");
				else if (s.equals("마트.편의점"))
					fDTO.setImage("resources/facilities-icon/market.png");
				else if (s.equals("장작판매"))
					fDTO.setImage("resources/facilities-icon/firewood.png");
				else if (s.equals("온수"))
					fDTO.setImage("resources/facilities-icon/hotwater.png");
				else if (s.equals("물놀이장"))
					fDTO.setImage("resources/facilities-icon/waterpark.png");
				else if (s.equals("무선인터넷"))
					fDTO.setImage("resources/facilities-icon/wifi.png");
				else if (s.equals("산책로"))
					fDTO.setImage("resources/facilities-icon/trail.png");
				else if (s.equals("트렘폴린"))
					fDTO.setImage("resources/facilities-icon/trampoline.png");
				else if (s.equals("놀이터"))
					fDTO.setImage("resources/facilities-icon/playground.png");
				else {
					fDTO.setImage("resources/facilities-icon/facilitydefault.png");
					fDTO.setDesc("제공되지 않음");
				}

				if (!s.equals("미제공")) {
					fDTO.setDesc(s);
				}

				facilityItems.add(fDTO);

			}

			if (mDTO.getC_lineIntro().equals("미제공"))
				mDTO.setC_lineIntro("");

			mDTO.setFacilities(facilityItems);
			
		}
	}
	public void getAllCampingSite(HttpServletRequest request) {
		// 최적화 쿼리
		campingSites = ss.getMapper(MainMapper.class).getAllCampingSite2();
		
		addDetailCampingSite(request, campingSites);
		
		request.setAttribute("searchCount", campingSites.size());
	}
	

	public void getCampingSite(int pageNo, HttpServletRequest request) {

		int count = 10;
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);

		end = campingSites.size() < end ? campingSites.size() : end;

		List<MainDTO> PagingSites = new ArrayList<MainDTO>();

		for (int i = start - 1; i < end; i++) {
			PagingSites.add(campingSites.get(i));
		}

		int pageCount = (int) Math.ceil(campingSites.size() / (double) count);

		request.setAttribute("pageCount", pageCount);
		request.setAttribute("curPage", pageNo);
		request.setAttribute("campingSites", PagingSites);
		request.setAttribute("searchCount", campingSites.size());
	}

	public void searchCampingSite(SearchDTO sDTO, HttpServletRequest request) {

		// 시/도 선택 안할시??
		if (sDTO.getSido1() == null) {
			sDTO.setSido1("");
		} else if(sDTO.getSido1().equals("시/도 선택")) {
			sDTO.setSido1("");
		}
		
		if(sDTO.getGugun1() == null) sDTO.setGugun1("");
		
		// 구 선택 안할시 ??
		if (sDTO.getGugun1().equals("전체")) sDTO.setGugun1("");
		
		// 검색어만 입력했을 때 -> 관련된 데이터 전부 제공
		campingSites = ss.getMapper(MainMapper.class).searchCampingSite(sDTO);
		
		addDetailCampingSite(request, campingSites);
		
		request.setAttribute("searchCount", campingSites.size());
		request.setAttribute("searchValue", sDTO.getSearchValue());
	}

	public void getCampingDetail(MainDTO m, HttpServletRequest request) {
		// 조회수 1 올려주기
		SiteViewDTO svDTO = ss.getMapper(MainMapper.class).getSiteViewCount(m);
		
		// 조회수가 0인 경우
		if (svDTO == null) {
			// 레코드 생성
			if (ss.getMapper(MainMapper.class).createSiteView(m) == 1) {
				for (MainDTO mDTO : campingSites) {
					if (mDTO.getC_no() == m.getC_no())
						mDTO.setCv_viewCount(1);
				}
			}
		} else {
			// 조회수만 1 올리기
			if (ss.getMapper(MainMapper.class).upSiteViewCount(m) == 1) {
				for (MainDTO mDTO : campingSites) {
					if (mDTO.getC_no() == m.getC_no())
						mDTO.setCv_viewCount(mDTO.getCv_viewCount() + 1);
				}
			}
		}

		// 들고오는 일
		MainDTO targetDTO = ss.getMapper(MainMapper.class).getCampingSite(m);

		List<facilityDTO> facilityItems = new ArrayList<facilityDTO>();
		
		facilityDTO fDTO;

		String tag[] = targetDTO.getC_sbrsCl().split(",");

		for (String s : tag) {
			fDTO = new facilityDTO();

			if (s.equals("운동장"))
				fDTO.setImage("resources/facilities-icon/play.png");
			else if (s.equals("운동시설"))
				fDTO.setImage("resources/facilities-icon/exercise.png");
			else if (s.equals("전기"))
				fDTO.setImage("resources/facilities-icon/electricity.png");
			else if (s.equals("마트.편의점"))
				fDTO.setImage("resources/facilities-icon/market.png");
			else if (s.equals("장작판매"))
				fDTO.setImage("resources/facilities-icon/firewood.png");
			else if (s.equals("온수"))
				fDTO.setImage("resources/facilities-icon/hotwater.png");
			else if (s.equals("물놀이장"))
				fDTO.setImage("resources/facilities-icon/waterpark.png");
			else if (s.equals("무선인터넷"))
				fDTO.setImage("resources/facilities-icon/wifi.png");
			else if (s.equals("산책로"))
				fDTO.setImage("resources/facilities-icon/trail.png");
			else if (s.equals("트렘폴린"))
				fDTO.setImage("resources/facilities-icon/trampoline.png");
			else if (s.equals("놀이터"))
				fDTO.setImage("resources/facilities-icon/playground.png");
			else {
				fDTO.setImage("resources/facilities-icon/facilitydefault.png");
				fDTO.setDesc("제공되지 않음");
			}

			if (!s.equals("미제공")) {
				fDTO.setDesc(s);
			}

			facilityItems.add(fDTO);
		}

		targetDTO.setFacilities(facilityItems);

		request.setAttribute("m", targetDTO);
	}

	public void getReviews(MainDTO m, HttpServletRequest request) {
		request.setAttribute("reviews", ss.getMapper(MainMapper.class).getReviews(m));
	}

	public int deleteReview(ReviewDTO r) {
		return ss.getMapper(MainMapper.class).deleteReview(r);
	}

	public int updateReview(ReviewDTO r) {
		return ss.getMapper(MainMapper.class).updateReview(r);
	}

	public void createReview(ReviewDTO r, HttpServletRequest request) {
		r.setCr_star(String.format("%.1f", (double) r.getCr_no() / 2));
		AccountDTO a = (AccountDTO) request.getSession().getAttribute("loginAccount");
		r.setCr_author(a.getAc_id());
		if (ss.getMapper(MainMapper.class).createReview(r) == 1) {
			System.out.println("리뷰 등록 성공!");
		}

	}

	public int createCampingSiteLike(LikeDTO l) {
		return ss.getMapper(MainMapper.class).createCampingSiteLike(l) == 1 ? ss.getMapper(MainMapper.class).getSiteLikeCount(l): 0;
	}

	public int deleteCampingSiteLike(LikeDTO l) {
		return ss.getMapper(MainMapper.class).deleteCampingSiteLike(l) == 1 ? ss.getMapper(MainMapper.class).getSiteLikeCount(l) : 0;
	}

	public void getSearchCampingSiteByTheme(ThemeDTO t, HttpServletRequest request) {
		// 테마에 해당하는 데이터 가져오기
		campingSites = ss.getMapper(ThemeMapper.class).getSearchCampingSiteByTheme(t);

		addDetailCampingSite(request, campingSites);

		request.setAttribute("searchCount", campingSites.size());
		// request.setAttribute("campingSites", campingSites);
	}


	public void getUserLikeCampingSites(HttpServletRequest request) {
		// 유저가 좋아요 누른 데이터!!
		
		AccountDTO aDTO = (AccountDTO) request.getSession().getAttribute("loginAccount");
		
		List<MainDTO> likes = ss.getMapper(MainMapper.class).getAllUserLikes(aDTO.getAc_id());
		
		for (MainDTO m : likes) {
			// 사이트 좋아요 개수
			LikeDTO lDTO = new LikeDTO(0, "", m.getC_no());
			m.setSiteLikeCount(ss.getMapper(MainMapper.class).getSiteLikeCount(lDTO));
			// 별점 평균
			String starAvg = ss.getMapper(MainMapper.class).getSiteReviewAvg(m);
			m.setReviewStarAvg(starAvg != null ? starAvg : "리뷰 정보 없음");

			// 조회수
			SiteViewDTO svDTO = ss.getMapper(MainMapper.class).getSiteViewCount(m);
			m.setCv_viewCount(svDTO != null ? svDTO.getCv_viewCount() : 0);
			
			List<String> tags = new ArrayList<String>();
			
			// 태그 처리
			String tag = m.getC_posblFcltyCl();
			
			String items[];
			
			// 미제공일시엔 테마 정보 제공
			if(!tag.equals("미제공")) {
				String theme = m.getC_themaEnvrnCl();
				if(theme != null) {
					// , 를 기준으로 구분
					items = theme.split(",");
					
					// 태그 내용 추가
					for (String item : items) tags.add("#" + item);
				} else {
					// 테마 정보도 없다면 #힐링 추가
					tags.add("#힐링");
				}
			} else {
				// 태그 정보 추리기
				
				// 공백 없애기
				tag = tag.replace(" ", "");
				
				// ,를 기준으로 구분
				items = tag.split(",");
				
				for (String item : items) tags.add("#" + item);
			}
			
			// MainDTO에 태그 정보 세팅
			m.setHashtagList(tags);
		}
		
		// 애트리뷰트에 실어주기
		request.setAttribute("camping_like", likes);
	}

	public CampingSitesDTO getCampingSiteByArea(HttpServletRequest request, String area) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("area", area);
		
		List<MainDTO> campingSite = ss.getMapper(ThemeMapper.class).getCampingSitesByArea(map);
		
		addDetailCampingSite(request, campingSite);
		
		return new CampingSitesDTO(campingSite);
	}
}
