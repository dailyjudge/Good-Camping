package com.project.camping.stuff;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.camping.account.AccountDAO;
import com.project.camping.account.AccountDTO;

@Controller
public class StuffController {
	
	@Autowired
	private StuffDAO sDAO;
	
	@Autowired
	private AccountDAO aDAO;
	
	@RequestMapping(value = "/do.refresh.stuffData", method = RequestMethod.GET)
	public String refreshStuffData(HttpServletRequest request) {
		
		sDAO.refreshStuffData();
		
		return "test";
	}
	
	
	
	@RequestMapping(value = "/go.camping.shop", method = RequestMethod.GET)
	public String getAllStuffData(StuffDTO s,HttpServletRequest request) {
		
		sDAO.getAllStuff(s, request);
		sDAO.StuffPaging(1, request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-stuff/camping-stuff.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/do.stuff.change", method = RequestMethod.GET)
	public String pagingStuffData(HttpServletRequest request) {
		
		int sp = Integer.parseInt(request.getParameter("sp"));
		
		sDAO.StuffPaging(sp, request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-stuff/camping-stuff.jsp");
		
		return "index";
	}
	@RequestMapping(value = "/go.stuff.detail", method = RequestMethod.GET)
	public String stuffDetail(StuffDTO s, HttpServletRequest request) {
		
		
		sDAO.StuffDetail(s,request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-stuff/camping-stuff-detail.jsp");
		
		return "index";
	}
}
