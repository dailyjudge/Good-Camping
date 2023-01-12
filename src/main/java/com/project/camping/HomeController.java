package com.project.camping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.camping.account.AccountDAO;
import com.project.camping.main.MainDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MainDAO mDAO;
	
	@Autowired
	private AccountDAO aDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		
		mDAO.checkAllCampingSiteCount();
		aDAO.loginCheck(request);
		
		request.setAttribute("contentPage", "home.jsp");

		return "index";
	}
	
	
	
	
}
