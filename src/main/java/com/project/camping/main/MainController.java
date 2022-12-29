package com.project.camping.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@Autowired
	MainDAO mDAO;
	
	@RequestMapping(value = "/do.refresh.data", method = RequestMethod.GET)
	public String refreshCampingData(HttpServletRequest request) {
		
		mDAO.refreshCampingData(request);
		request.setAttribute("contentPage", "camping-search/camping-search.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/go.camping.find", method = RequestMethod.GET)
	public String goFindCampingSite(HttpServletRequest request) {
		
		// 모든 캠핑 지역의 정보를 조회하는 일
		mDAO.getAllCampingSite(request);
				
				// 페이징처리
		mDAO.getCampingSite(1, request);
				
		request.setAttribute("loginPage", "account/login.jsp");
		request.setAttribute("contentPage", "camping-search/camping-search.jsp");

		return "index";
	}
	
	@RequestMapping(value = "/do.camping.change", method = RequestMethod.GET)
	public String changeCampingSitePage(HttpServletRequest request) {
		
		int p = Integer.parseInt(request.getParameter("p"));
		
		// 페이징처리
		mDAO.getCampingSite(p, request);
		request.setAttribute("contentPage", "camping-search/camping-search.jsp");
		return "index";
	}
}
