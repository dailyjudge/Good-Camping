package com.project.camping.account;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {
	
	@Autowired
	private AccountDAO aDAO;
	
	//do.account.login
	@RequestMapping(value = "/do.account.login", method = RequestMethod.GET)
	public String refreshCampingData(HttpServletRequest request) {
		
		aDAO.login(request);
		
		aDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
}
