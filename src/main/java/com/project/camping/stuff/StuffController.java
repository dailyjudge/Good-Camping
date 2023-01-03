package com.project.camping.stuff;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StuffController {
	
	@Autowired
	private StuffDAO sDAO;
	
	
	
	
	@RequestMapping(value = "/do.refresh.stuffData", method = RequestMethod.GET)
	public String refreshStuffData(HttpServletRequest request) {
		
		sDAO.refreshStuffData();
		return "test";
	}
	
	
	
	@RequestMapping(value = "/go.camping.shop", method = RequestMethod.GET)
	public String getAllStuffData(StuffDTO s,HttpServletRequest req) {
		
		sDAO.getAllStuff(s,req);
		sDAO.StuffPaging(1,req);
		
		req.setAttribute("loginPage", "account/login.jsp");
		req.setAttribute("contentPage", "camping-stuff/camping-stuff.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/do.stuff.change", method = RequestMethod.GET)
	public String pagingStuffData(HttpServletRequest req) {
		
		int sp = Integer.parseInt(req.getParameter("sp"));
		
		sDAO.StuffPaging(sp,req);
		req.setAttribute("loginPage", "account/login.jsp");
		req.setAttribute("contentPage", "camping-stuff/camping-stuff.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.stuff.detail", method = RequestMethod.GET)
	public String stuffDetail(StuffDTO s, HttpServletRequest req) {
		
		
		sDAO.StuffDetail(s,req);
		req.setAttribute("loginPage", "account/login.jsp");
		req.setAttribute("contentPage", "camping-stuff/camping-stuff-detail.jsp");
		return "index";
	}
}
