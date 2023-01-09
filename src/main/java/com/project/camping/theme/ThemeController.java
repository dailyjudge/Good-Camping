package com.project.camping.theme;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.camping.account.AccountDAO;

@Controller
public class ThemeController {
	@Autowired
	AccountDAO aDAO;
	
	@RequestMapping(value = "/go.theme.find", method = RequestMethod.GET)
	public String refreshCampingData(HttpServletRequest request) {
		
		aDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "camping-theme/camping-theme.jsp");
		return "index";
	}
}
