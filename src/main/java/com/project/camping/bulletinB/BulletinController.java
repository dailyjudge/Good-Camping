package com.project.camping.bulletinB;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.camping.account.AccountDAO;

@Controller
public class BulletinController {
	
	@Autowired
	SqlSession ss;
	
	@Autowired
	private AccountDAO aDAO;
	@Autowired
	private BulletinDAO bDAO;
	
	@RequestMapping(value = "/go.Bulletin.Main", method = RequestMethod.GET)
	public String goToBulletinMain(HttpServletRequest request) {
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "bulletin/ex1.jsp");
		return "index";
	}
	
	
}
