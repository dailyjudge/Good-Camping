package com.project.camping.theme;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.camping.account.AccountDAO;
import com.project.camping.main.CampingSitesDTO;
import com.project.camping.main.MainDAO;
import com.project.camping.main.MainDTO;

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
	
	@ResponseBody
	@RequestMapping(value = "/do.map.search", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public CampingSitesDTO searchCampingSiteByArea(HttpServletRequest request) {
		return mDAO.getCampingSiteByArea(request, request.getParameter("area"));
	}
}
