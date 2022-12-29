package com.project.camping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.camping.main.MainDAO;

@Controller
public class HomeController {
	
	@Autowired
	MainDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		
		// 모든 캠핑 지역의 정보를 조회하는 일
		//mDAO.getAllCampingSite(request);
		
		// 페이징처리
		//mDAO.getCampingSite(1, request);
		
		request.setAttribute("loginPage", "account/login.jsp");
		request.setAttribute("contentPage", "home.jsp");
		//request.setAttribute("contentPage", "camping-search/camping-search.jsp");
		return "index";
	}
	
	
	
	
}
