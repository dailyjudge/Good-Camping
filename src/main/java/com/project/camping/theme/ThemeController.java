package com.project.camping.theme;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.camping.account.AccountDAO;
import com.project.camping.main.MainDAO;

@Controller
public class ThemeController {
	@Autowired
	AccountDAO aDAO;
	
	@Autowired
	MainDAO mDAO;
	
	@RequestMapping(value = "/go.theme.find", method = RequestMethod.GET)
	public String refreshCampingData(HttpServletRequest request) {
		
		aDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "camping-theme/camping-theme.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/do.theme.search", method = RequestMethod.GET)
	public String searchThemeCampingSite(ThemeDTO t, HttpServletRequest request) {
		
		aDAO.loginCheck(request);
		
		mDAO.getSearchCampingSiteByTheme(t, request);
		mDAO.getCampingSite(1, request);

		request.setAttribute("contentPage", "camping-search/camping-search.jsp");
		return "index";
	}
}
