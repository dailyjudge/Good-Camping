package com.project.camping.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.camping.account.AccountDAO;

@Controller
public class MainController {
	
	@Autowired
	private MainDAO mDAO;
	
	@Autowired
	private AccountDAO aDAO;
	
	@RequestMapping(value = "/do.refresh.data", method = RequestMethod.GET)
	public String refreshCampingData(HttpServletRequest request) {
		
		mDAO.refreshCampingData(request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-search/camping-search.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/go.camping.find", method = RequestMethod.GET)
	public String goFindCampingSite(HttpServletRequest request) {
		
		// 모든 캠핑 지역의 정보를 조회하는 일
		mDAO.getAllCampingSite(request);
				
		// 페이징처리
		mDAO.getCampingSite(1, request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-search/camping-search.jsp");

		return "index";
	}
	
	@RequestMapping(value = "/go.camping.back", method = RequestMethod.GET)
	public String backToCampingList(HttpServletRequest request) {
		
		// 페이징처리
		mDAO.getCampingSite(Integer.parseInt(request.getParameter("p")), request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-search/camping-search.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/do.camping.change", method = RequestMethod.GET)
	public String changeCampingSitePage(HttpServletRequest request) {
		
		int p = Integer.parseInt(request.getParameter("p"));
		
		// 페이징처리
		mDAO.getCampingSite(p, request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-search/camping-search.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/do.search.campingSite", method = RequestMethod.GET)
	public String searchCampingSite(SearchDTO s, HttpServletRequest request) {
		
		// 검색 하는 일
		mDAO.searchCampingSite(s, request);
		
		// 페이징처리
		mDAO.getCampingSite(1, request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-search/camping-search.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/go.camping.detail", method = RequestMethod.GET)
	public String goCampingDetail(MainDTO m, HttpServletRequest request) {
		
		mDAO.getCampingDetail(m, request);
		
		// 리뷰 정보를 들고 오는 일
		mDAO.getReviews(m, request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-search/camping-detail.jsp");

		return "index";
	}
	
	@RequestMapping(value = "/do.create.review", method = RequestMethod.GET)
	public String createReview(ReviewDTO r, HttpServletRequest request) {
		
		mDAO.createReview(r, request);
		
		
		MainDTO m = new MainDTO();
		m.setC_no(r.getCr_campingSiteNo());
		
		mDAO.getCampingDetail(m, request);
		
		mDAO.getReviews(m, request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-search/camping-detail.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/do.delete.review", method = RequestMethod.GET)
	@ResponseBody
	public int deleteReview(ReviewDTO r, HttpServletRequest request) {
		// 리뷰 정보를 삭제하는 일
		
		return mDAO.deleteReview(r);
	}
	
	@RequestMapping(value = "/do.update.review", method = RequestMethod.GET)
	@ResponseBody
	public int updateReview(ReviewDTO r, HttpServletRequest request) {
		// 리뷰 정보를 삭제하는 일
		
		return mDAO.updateReview(r);
	}
	
	@RequestMapping(value = "/do.create.campingSite.like", method = RequestMethod.GET)
	@ResponseBody
	public int createSiteLike(LikeDTO l, HttpServletRequest request) {
		// 유저의 사이트 좋아요 정보를 추가하는 일
		return mDAO.createCampingSiteLike(l);
	}
	
	@RequestMapping(value = "/do.delete.campingSite.like", method = RequestMethod.GET)
	@ResponseBody
	public int deleteSiteLike(LikeDTO l, HttpServletRequest request) {
		// 유저의 사이트 좋아요 정보를 삭제하는 일
		return mDAO.deleteCampingSiteLike(l);
	}
	
}
