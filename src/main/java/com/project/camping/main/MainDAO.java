package com.project.camping.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

import com.project.camping.account.AccountDTO;

@Service
public class MainDAO {

	@Autowired
	SqlSession ss;
	
	List<MainDTO> campingSites;
	
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

				MainDTO m = new MainDTO(0, zipcode, addr1, animalCmgCl, bizrno, brazierCl, caravAcmpnyAt, caravInnerFclty,
						caravSiteCo, clturEventAt, trlerAcmpnyAt, exprnProgrmAt, clturEvent, doNm, sigunguNm,
						exprnProgrm, facltNm, firstImageUrl, glampInnerFclty, glampSiteCo, gnrlSiteCo, homepage,
						insrncAt, intro, lineIntro, mapX, mapY, operDeCl, operPdCl, posblFcltyCl, resveCl, resveUrl,
						sbrsCl, tel, themaEnvrnCl, toiletCo, wtrplCo, tooltip, null, 0, 0);
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

	public void getAllCampingSite(HttpServletRequest request) {
		
		campingSites = ss.getMapper(MainMapper.class).getAllCampingSite();
		
		HashSet<String> hs = new HashSet<String>();
		
		// 테마 확인하기
		for (MainDTO mDTO : campingSites) {
			String tag[] = mDTO.getC_sbrsCl().split(",");
			
			for (String s : tag) hs.add(s);
		}
		
		// 리스트를 돌면서 값 넣기!		
		List<String> facilities = new ArrayList<String>();
		
		for (String s : hs) if(!s.equals("미제공")) facilities.add(s);

		int count = 0;
		
		List<facilityDTO> facilityItems;
		facilityDTO fDTO;
		
		for (MainDTO mDTO : campingSites) {
			
			// 조회수 처리
			SiteViewDTO svDTO = ss.getMapper(MainMapper.class).getSiteViewCount(mDTO);
			mDTO.setSiteViewCount(svDTO == null ? 0 : svDTO.getCv_viewCount());
			// 리뷰수 처리
			mDTO.setReviewCount(ss.getMapper(MainMapper.class).getReviewCount(mDTO));
			// default 이미지 처리
			if(mDTO.getC_firstImageUrl().equals("#")) mDTO.setC_firstImageUrl("resources/facilities-icon/firstImgUrldefault.png");
			// 값 대체
			facilityItems = new ArrayList<facilityDTO>();
			
			String tag[] = mDTO.getC_sbrsCl().split(",");
			
			for (String s : tag) {
				
				fDTO = new facilityDTO();
				if(s.equals("운동장")) fDTO.setImage("resources/facilities-icon/play.png"); 
				else if(s.equals("운동시설")) 	fDTO.setImage("resources/facilities-icon/exercise.png"); 
				else if(s.equals("전기")) 	fDTO.setImage("resources/facilities-icon/electricity.png"); 
				else if(s.equals("마트.편의점")) fDTO.setImage("resources/facilities-icon/market.png");
				else if(s.equals("장작판매")) fDTO.setImage("resources/facilities-icon/firewood.png");
				else if(s.equals("온수")) 	fDTO.setImage("resources/facilities-icon/hotwater.png");
				else if(s.equals("물놀이장")) fDTO.setImage("resources/facilities-icon/waterpark.png");
				else if(s.equals("무선인터넷")) fDTO.setImage("resources/facilities-icon/wifi.png");
				else if(s.equals("산책로")) 	fDTO.setImage("resources/facilities-icon/trail.png");
				else if(s.equals("트렘폴린")) fDTO.setImage("resources/facilities-icon/trampoline.png");
				else if(s.equals("놀이터")) 	fDTO.setImage("resources/facilities-icon/playground.png");
				else {
					fDTO.setImage("resources/facilities-icon/facilitydefault.png");
					fDTO.setDesc("제공되지 않음");
				}
				
				if(!s.equals("미제공")) {
					fDTO.setDesc(s);
				}
				
				facilityItems.add(fDTO);
				
			}
			
			if(mDTO.getC_lineIntro().equals("미제공")) mDTO.setC_lineIntro("");
			
			mDTO.setFacilities(facilityItems);
			
		}
		
		request.setAttribute("searchCount", campingSites.size());
		//request.setAttribute("campingSites", campingSites);
	}

	public void getCampingSite(int pageNo, HttpServletRequest request) {
		
		int count = 10;
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);
		
		end = campingSites.size() < end ? campingSites.size() : end;
		
		List<MainDTO> PagingSites = new ArrayList<MainDTO>();
		
		for(int i = start - 1; i < end; i++) {
			PagingSites.add(campingSites.get(i));
		}
		
		int pageCount = (int) Math.ceil(campingSites.size() / (double) count);
		
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("curPage", pageNo);
		request.setAttribute("campingSites", PagingSites);
		request.setAttribute("searchCount", campingSites.size());
	}

	public void searchCampingSite(SearchDTO s, HttpServletRequest request) {
		
		// 시/도 선택 안할시??
		if(s.getSido1().equals("시/도 선택")) s.setSido1(s.getSido1().replace("시/도 선택", ""));
		
		// 검색어만 입력했을 때 -> 관련된 데이터 전부 제공
		campingSites = ss.getMapper(MainMapper.class).searchCampingSite(s);
		
		request.setAttribute("searchCount", campingSites.size());
	}

	public void getCampingDetail(MainDTO m, HttpServletRequest request) {
		
		// 조회수 1 올려주기
		SiteViewDTO svDTO = ss.getMapper(MainMapper.class).getSiteViewCount(m);
		
		// 조회수가 0인 경우
		if(svDTO == null) {
			// 레코드 생성
			if(ss.getMapper(MainMapper.class).createSiteView(m) == 1) {
				System.out.println("새로운 Row 생성");
				
				for (MainDTO mDTO : campingSites) {
					if(mDTO.getC_no() == m.getC_no()) mDTO.setSiteViewCount(1);
				}
			}
		} else {
			// 조회수만 1 올리기
			if(ss.getMapper(MainMapper.class).upSiteViewCount(m) == 1) {
				System.out.println("조회수 1증가");
				
				for (MainDTO mDTO : campingSites) {
					if(mDTO.getC_no() == m.getC_no()) mDTO.setSiteViewCount(mDTO.getSiteViewCount() + 1);
				}
			}
		}
		
		// 들고오는 일
		MainDTO targetDTO = ss.getMapper(MainMapper.class).getCampingSite(m);
		
		List<facilityDTO> facilityItems = new ArrayList<facilityDTO>();;
		facilityDTO fDTO;
		
		String tag[] = targetDTO.getC_sbrsCl().split(",");
		
		for (String s : tag) {
			fDTO = new facilityDTO();
			
			if(s.equals("운동장")) fDTO.setImage("resources/facilities-icon/play.png"); 
			else if(s.equals("운동시설")) 	fDTO.setImage("resources/facilities-icon/exercise.png"); 
			else if(s.equals("전기")) 	fDTO.setImage("resources/facilities-icon/electricity.png"); 
			else if(s.equals("마트.편의점")) fDTO.setImage("resources/facilities-icon/market.png");
			else if(s.equals("장작판매")) fDTO.setImage("resources/facilities-icon/firewood.png");
			else if(s.equals("온수")) 	fDTO.setImage("resources/facilities-icon/hotwater.png");
			else if(s.equals("물놀이장")) fDTO.setImage("resources/facilities-icon/waterpark.png");
			else if(s.equals("무선인터넷")) fDTO.setImage("resources/facilities-icon/wifi.png");
			else if(s.equals("산책로")) 	fDTO.setImage("resources/facilities-icon/trail.png");
			else if(s.equals("트렘폴린")) fDTO.setImage("resources/facilities-icon/trampoline.png");
			else if(s.equals("놀이터")) 	fDTO.setImage("resources/facilities-icon/playground.png");
			else {
				fDTO.setImage("resources/facilities-icon/facilitydefault.png");
				fDTO.setDesc("제공되지 않음");
			}
			
			if(!s.equals("미제공")) {
				fDTO.setDesc(s);
			}
			
			facilityItems.add(fDTO);
		}
		
		targetDTO.setFacilities(facilityItems);
		
		request.setAttribute("m", targetDTO);
	}

	public void getReviews(MainDTO m, HttpServletRequest request) {
		
		// 게시글 아이디!!
		request.setAttribute("reviews", ss.getMapper(MainMapper.class).getReviews(m));
	}

	public int deleteReview(ReviewDTO r) {
		return ss.getMapper(MainMapper.class).deleteReview(r);
	}

	public int updateReview(ReviewDTO r) {
		return ss.getMapper(MainMapper.class).updateReview(r);
	}

	public void createReview(ReviewDTO r, HttpServletRequest request) {
		r.setCr_star(String.format("%.1f", (double)r.getCr_no() / 2));
		System.out.println(r.toString());
		AccountDTO a = (AccountDTO) request.getSession().getAttribute("loginAccount");
		r.setCr_author(a.getAc_id());
		if(ss.getMapper(MainMapper.class).createReview(r) == 1) {
			System.out.println("리뷰 등록 성공!");
		}
		
	}	
}
