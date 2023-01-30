package com.project.camping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.camping.account.AccountDAO;
import com.project.camping.bulletinB.BulletinDAO;
import com.project.camping.main.MainDAO;

@Controller
public class HomeController {
	
	private boolean firstReq;
	
	@Autowired
	private MainDAO mDAO;
	
	@Autowired
	private AccountDAO aDAO;
	
	@Autowired
	private BulletinDAO buDAO;

	public HomeController() {
		firstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		
		if(firstReq) {
			buDAO.calcAllBoardCount();
			firstReq = false;
		}
		
		aDAO.autoLogin(request);
		aDAO.loginCheck(request);
		
		request.setAttribute("color", 1);
		request.setAttribute("contentPage", "home.jsp");

		return "index";
	}
	
	
	
	
}
