package com.project.camping.main;

import java.util.List;

public class MainDTO {
// 	camping_site
//  pk
	private int c_no;
//	zipcode 우편번호
	private int c_zipcode;
//	addr1 주소
	private String c_addr1;
//	animalCmgCl 애완동물 출입 (가능, 불가능)
	private String c_animalCmgCl;
//	bizrno 사업자 번호
	private String c_bizrno;
//	brazierCl 화로대
	private String c_brazierCl;
//	caravAcmpnyAt 개인 카라반 동반 여부
	private String c_caravAcmpnyAt;
//	caravInnerFclty 카라반 - 내부시설
	private String c_caravInnerFclty;
//	caravSiteCo 주요시설 카라반
	private String c_caravSiteCo;
//	clturEventAt 자체 행사 여부 (Y:사용, N:미사용)
	private String c_clturEventAt;
//	trlerAcmpnyAt 개인 트레일러 동반 여부 (Y:사용, N:미사용)
	private String c_trlerAcmpnyAt;
//	exprnProgrmAt 체험 프로그램 여부 (Y: 사용, N: 미사용)
	private String c_exprnProgrmAt;
//	clturEvent 자체 문화 행사명
	private String c_clturEvent;
//	doNm 도
	private String c_doNm;
//	sigunguNm 시군구
	private String c_sigunguNm;
//	exprnProgrm 체험프로그램명
	private String c_exprnProgrm;
//	facltNm 야영장명
	private String c_facltNm;
//	firstImageUrl 대표 이미지
	private String c_firstImageUrl;
//	glampInnerFclty 글램핑 - 내부시설
	private String c_glampInnerFclty;
//	glampSiteCo 주요시설 글램핑
	private String c_glampSiteCo;
//	gnrlSiteCo 주요시설 일반 야영장
	private String c_gnrlSiteCo;
//	homepage 홈페이지
	private String c_homepage;
//	insrncAt 영업배상책임보험 가입여부(Y:사용, N:미사용)
	private String c_insrncAt;
//	intro 소개 
	private String c_intro;
//	lineIntro 한줄 소개
	private String c_lineIntro;
//	mapX 경도 (X)
	private String c_mapX;
//	mapY 위도 (Y)
	private String c_mapY;
//	operDeCl 운영일
	private String c_operDeCl;
//	operPdCl 운영기간
	private String c_operPdCl;
//	posblFcltyCl 주변 이용 가능 시설
	private String c_posblFcltyCl;
//	resveCl 예약 구분
	private String c_resveCl;
//	resveUrl 예약 페이지
	private String c_resveUrl;
//	sbrsCl 부대시설
	private String c_sbrsCl;
//	tel 전화
	private String c_tel;
//	themaEnvrnCl 테마환경
	private String c_themaEnvrnCl;
//	toiletCo 화장실 개수
	private String c_toiletCo;
//	wtrplCo 개수대 개수
	private String c_wtrplCo;
//	tooltip 툴팁
	private String c_tooltip;
	
//  이미지 정보를 담을 배열
	private List<facilityDTO> facilities;
	
//  리뷰 수를 담는 변수
	private int reviewCount;

//  조회 수를 담는 변수
	private int cv_viewCount;

//  사이트에 좋아요 개수
	private int siteLikeCount;
//  유저가 좋아요를 눌렀는지 확인할 수 있는 변수 (1 : 좋아요, 2: x)
	private int isLiked;
	
//	사이트 리뷰 별점 평점 - default 처리 위해 String(제공되지 않음)
	private String reviewStarAvg;

//	해시 태그를 담을 리스트
	private List<String> hashtagList;
	
	public MainDTO() {
		// TODO Auto-generated constructor stub
	}

	public MainDTO(int c_no, int c_zipcode, String c_addr1, String c_animalCmgCl, String c_bizrno, String c_brazierCl,
			String c_caravAcmpnyAt, String c_caravInnerFclty, String c_caravSiteCo, String c_clturEventAt,
			String c_trlerAcmpnyAt, String c_exprnProgrmAt, String c_clturEvent, String c_doNm, String c_sigunguNm,
			String c_exprnProgrm, String c_facltNm, String c_firstImageUrl, String c_glampInnerFclty,
			String c_glampSiteCo, String c_gnrlSiteCo, String c_homepage, String c_insrncAt, String c_intro,
			String c_lineIntro, String c_mapX, String c_mapY, String c_operDeCl, String c_operPdCl,
			String c_posblFcltyCl, String c_resveCl, String c_resveUrl, String c_sbrsCl, String c_tel,
			String c_themaEnvrnCl, String c_toiletCo, String c_wtrplCo, String c_tooltip, List<facilityDTO> facilities,
			int reviewCount, int cv_viewCount, int siteLikeCount, int isLiked, String reviewStarAvg,
			List<String> hashtagList) {
		super();
		this.c_no = c_no;
		this.c_zipcode = c_zipcode;
		this.c_addr1 = c_addr1;
		this.c_animalCmgCl = c_animalCmgCl;
		this.c_bizrno = c_bizrno;
		this.c_brazierCl = c_brazierCl;
		this.c_caravAcmpnyAt = c_caravAcmpnyAt;
		this.c_caravInnerFclty = c_caravInnerFclty;
		this.c_caravSiteCo = c_caravSiteCo;
		this.c_clturEventAt = c_clturEventAt;
		this.c_trlerAcmpnyAt = c_trlerAcmpnyAt;
		this.c_exprnProgrmAt = c_exprnProgrmAt;
		this.c_clturEvent = c_clturEvent;
		this.c_doNm = c_doNm;
		this.c_sigunguNm = c_sigunguNm;
		this.c_exprnProgrm = c_exprnProgrm;
		this.c_facltNm = c_facltNm;
		this.c_firstImageUrl = c_firstImageUrl;
		this.c_glampInnerFclty = c_glampInnerFclty;
		this.c_glampSiteCo = c_glampSiteCo;
		this.c_gnrlSiteCo = c_gnrlSiteCo;
		this.c_homepage = c_homepage;
		this.c_insrncAt = c_insrncAt;
		this.c_intro = c_intro;
		this.c_lineIntro = c_lineIntro;
		this.c_mapX = c_mapX;
		this.c_mapY = c_mapY;
		this.c_operDeCl = c_operDeCl;
		this.c_operPdCl = c_operPdCl;
		this.c_posblFcltyCl = c_posblFcltyCl;
		this.c_resveCl = c_resveCl;
		this.c_resveUrl = c_resveUrl;
		this.c_sbrsCl = c_sbrsCl;
		this.c_tel = c_tel;
		this.c_themaEnvrnCl = c_themaEnvrnCl;
		this.c_toiletCo = c_toiletCo;
		this.c_wtrplCo = c_wtrplCo;
		this.c_tooltip = c_tooltip;
		this.facilities = facilities;
		this.reviewCount = reviewCount;
		this.cv_viewCount = cv_viewCount;
		this.siteLikeCount = siteLikeCount;
		this.isLiked = isLiked;
		this.reviewStarAvg = reviewStarAvg;
		this.hashtagList = hashtagList;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getC_zipcode() {
		return c_zipcode;
	}

	public void setC_zipcode(int c_zipcode) {
		this.c_zipcode = c_zipcode;
	}

	public String getC_addr1() {
		return c_addr1;
	}

	public void setC_addr1(String c_addr1) {
		this.c_addr1 = c_addr1;
	}

	public String getC_animalCmgCl() {
		return c_animalCmgCl;
	}

	public void setC_animalCmgCl(String c_animalCmgCl) {
		this.c_animalCmgCl = c_animalCmgCl;
	}

	public String getC_bizrno() {
		return c_bizrno;
	}

	public void setC_bizrno(String c_bizrno) {
		this.c_bizrno = c_bizrno;
	}

	public String getC_brazierCl() {
		return c_brazierCl;
	}

	public void setC_brazierCl(String c_brazierCl) {
		this.c_brazierCl = c_brazierCl;
	}

	public String getC_caravAcmpnyAt() {
		return c_caravAcmpnyAt;
	}

	public void setC_caravAcmpnyAt(String c_caravAcmpnyAt) {
		this.c_caravAcmpnyAt = c_caravAcmpnyAt;
	}

	public String getC_caravInnerFclty() {
		return c_caravInnerFclty;
	}

	public void setC_caravInnerFclty(String c_caravInnerFclty) {
		this.c_caravInnerFclty = c_caravInnerFclty;
	}

	public String getC_caravSiteCo() {
		return c_caravSiteCo;
	}

	public void setC_caravSiteCo(String c_caravSiteCo) {
		this.c_caravSiteCo = c_caravSiteCo;
	}

	public String getC_clturEventAt() {
		return c_clturEventAt;
	}

	public void setC_clturEventAt(String c_clturEventAt) {
		this.c_clturEventAt = c_clturEventAt;
	}

	public String getC_trlerAcmpnyAt() {
		return c_trlerAcmpnyAt;
	}

	public void setC_trlerAcmpnyAt(String c_trlerAcmpnyAt) {
		this.c_trlerAcmpnyAt = c_trlerAcmpnyAt;
	}

	public String getC_exprnProgrmAt() {
		return c_exprnProgrmAt;
	}

	public void setC_exprnProgrmAt(String c_exprnProgrmAt) {
		this.c_exprnProgrmAt = c_exprnProgrmAt;
	}

	public String getC_clturEvent() {
		return c_clturEvent;
	}

	public void setC_clturEvent(String c_clturEvent) {
		this.c_clturEvent = c_clturEvent;
	}

	public String getC_doNm() {
		return c_doNm;
	}

	public void setC_doNm(String c_doNm) {
		this.c_doNm = c_doNm;
	}

	public String getC_sigunguNm() {
		return c_sigunguNm;
	}

	public void setC_sigunguNm(String c_sigunguNm) {
		this.c_sigunguNm = c_sigunguNm;
	}

	public String getC_exprnProgrm() {
		return c_exprnProgrm;
	}

	public void setC_exprnProgrm(String c_exprnProgrm) {
		this.c_exprnProgrm = c_exprnProgrm;
	}

	public String getC_facltNm() {
		return c_facltNm;
	}

	public void setC_facltNm(String c_facltNm) {
		this.c_facltNm = c_facltNm;
	}

	public String getC_firstImageUrl() {
		return c_firstImageUrl;
	}

	public void setC_firstImageUrl(String c_firstImageUrl) {
		this.c_firstImageUrl = c_firstImageUrl;
	}

	public String getC_glampInnerFclty() {
		return c_glampInnerFclty;
	}

	public void setC_glampInnerFclty(String c_glampInnerFclty) {
		this.c_glampInnerFclty = c_glampInnerFclty;
	}

	public String getC_glampSiteCo() {
		return c_glampSiteCo;
	}

	public void setC_glampSiteCo(String c_glampSiteCo) {
		this.c_glampSiteCo = c_glampSiteCo;
	}

	public String getC_gnrlSiteCo() {
		return c_gnrlSiteCo;
	}

	public void setC_gnrlSiteCo(String c_gnrlSiteCo) {
		this.c_gnrlSiteCo = c_gnrlSiteCo;
	}

	public String getC_homepage() {
		return c_homepage;
	}

	public void setC_homepage(String c_homepage) {
		this.c_homepage = c_homepage;
	}

	public String getC_insrncAt() {
		return c_insrncAt;
	}

	public void setC_insrncAt(String c_insrncAt) {
		this.c_insrncAt = c_insrncAt;
	}

	public String getC_intro() {
		return c_intro;
	}

	public void setC_intro(String c_intro) {
		this.c_intro = c_intro;
	}

	public String getC_lineIntro() {
		return c_lineIntro;
	}

	public void setC_lineIntro(String c_lineIntro) {
		this.c_lineIntro = c_lineIntro;
	}

	public String getC_mapX() {
		return c_mapX;
	}

	public void setC_mapX(String c_mapX) {
		this.c_mapX = c_mapX;
	}

	public String getC_mapY() {
		return c_mapY;
	}

	public void setC_mapY(String c_mapY) {
		this.c_mapY = c_mapY;
	}

	public String getC_operDeCl() {
		return c_operDeCl;
	}

	public void setC_operDeCl(String c_operDeCl) {
		this.c_operDeCl = c_operDeCl;
	}

	public String getC_operPdCl() {
		return c_operPdCl;
	}

	public void setC_operPdCl(String c_operPdCl) {
		this.c_operPdCl = c_operPdCl;
	}

	public String getC_posblFcltyCl() {
		return c_posblFcltyCl;
	}

	public void setC_posblFcltyCl(String c_posblFcltyCl) {
		this.c_posblFcltyCl = c_posblFcltyCl;
	}

	public String getC_resveCl() {
		return c_resveCl;
	}

	public void setC_resveCl(String c_resveCl) {
		this.c_resveCl = c_resveCl;
	}

	public String getC_resveUrl() {
		return c_resveUrl;
	}

	public void setC_resveUrl(String c_resveUrl) {
		this.c_resveUrl = c_resveUrl;
	}

	public String getC_sbrsCl() {
		return c_sbrsCl;
	}

	public void setC_sbrsCl(String c_sbrsCl) {
		this.c_sbrsCl = c_sbrsCl;
	}

	public String getC_tel() {
		return c_tel;
	}

	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}

	public String getC_themaEnvrnCl() {
		return c_themaEnvrnCl;
	}

	public void setC_themaEnvrnCl(String c_themaEnvrnCl) {
		this.c_themaEnvrnCl = c_themaEnvrnCl;
	}

	public String getC_toiletCo() {
		return c_toiletCo;
	}

	public void setC_toiletCo(String c_toiletCo) {
		this.c_toiletCo = c_toiletCo;
	}

	public String getC_wtrplCo() {
		return c_wtrplCo;
	}

	public void setC_wtrplCo(String c_wtrplCo) {
		this.c_wtrplCo = c_wtrplCo;
	}

	public String getC_tooltip() {
		return c_tooltip;
	}

	public void setC_tooltip(String c_tooltip) {
		this.c_tooltip = c_tooltip;
	}

	public List<facilityDTO> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<facilityDTO> facilities) {
		this.facilities = facilities;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getCv_viewCount() {
		return cv_viewCount;
	}

	public void setCv_viewCount(int cv_viewCount) {
		this.cv_viewCount = cv_viewCount;
	}

	public int getSiteLikeCount() {
		return siteLikeCount;
	}

	public void setSiteLikeCount(int siteLikeCount) {
		this.siteLikeCount = siteLikeCount;
	}

	public int getIsLiked() {
		return isLiked;
	}

	public void setIsLiked(int isLiked) {
		this.isLiked = isLiked;
	}

	public String getReviewStarAvg() {
		return reviewStarAvg;
	}

	public void setReviewStarAvg(String reviewStarAvg) {
		this.reviewStarAvg = reviewStarAvg;
	}

	public List<String> getHashtagList() {
		return hashtagList;
	}

	public void setHashtagList(List<String> hashtagList) {
		this.hashtagList = hashtagList;
	}

	@Override
	public String toString() {
		return "MainDTO [c_no=" + c_no + ", c_zipcode=" + c_zipcode + ", c_addr1=" + c_addr1 + ", c_animalCmgCl="
				+ c_animalCmgCl + ", c_bizrno=" + c_bizrno + ", c_brazierCl=" + c_brazierCl + ", c_caravAcmpnyAt="
				+ c_caravAcmpnyAt + ", c_caravInnerFclty=" + c_caravInnerFclty + ", c_caravSiteCo=" + c_caravSiteCo
				+ ", c_clturEventAt=" + c_clturEventAt + ", c_trlerAcmpnyAt=" + c_trlerAcmpnyAt + ", c_exprnProgrmAt="
				+ c_exprnProgrmAt + ", c_clturEvent=" + c_clturEvent + ", c_doNm=" + c_doNm + ", c_sigunguNm="
				+ c_sigunguNm + ", c_exprnProgrm=" + c_exprnProgrm + ", c_facltNm=" + c_facltNm + ", c_firstImageUrl="
				+ c_firstImageUrl + ", c_glampInnerFclty=" + c_glampInnerFclty + ", c_glampSiteCo=" + c_glampSiteCo
				+ ", c_gnrlSiteCo=" + c_gnrlSiteCo + ", c_homepage=" + c_homepage + ", c_insrncAt=" + c_insrncAt
				+ ", c_intro=" + c_intro + ", c_lineIntro=" + c_lineIntro + ", c_mapX=" + c_mapX + ", c_mapY=" + c_mapY
				+ ", c_operDeCl=" + c_operDeCl + ", c_operPdCl=" + c_operPdCl + ", c_posblFcltyCl=" + c_posblFcltyCl
				+ ", c_resveCl=" + c_resveCl + ", c_resveUrl=" + c_resveUrl + ", c_sbrsCl=" + c_sbrsCl + ", c_tel="
				+ c_tel + ", c_themaEnvrnCl=" + c_themaEnvrnCl + ", c_toiletCo=" + c_toiletCo + ", c_wtrplCo="
				+ c_wtrplCo + ", c_tooltip=" + c_tooltip + ", facilities=" + facilities + ", reviewCount=" + reviewCount
				+ ", cv_viewCount=" + cv_viewCount + ", siteLikeCount=" + siteLikeCount + ", isLiked=" + isLiked
				+ ", reviewStarAvg=" + reviewStarAvg + ", hashtagList=" + hashtagList + "]";
	}

	
}
