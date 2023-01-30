package com.project.camping.bulletinB;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		request.setAttribute("contentPage", "bulletin/board-start.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.board.comu", method = RequestMethod.GET)
	public String goBoardComu(HttpServletRequest request) {
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "bulletin/board-community.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.board.write", method = RequestMethod.GET)
	public String goBoardWrite(HttpServletRequest request) {
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "bulletin/board-write.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.search.where", method = RequestMethod.GET)
	@ResponseBody
	public int goSearchWhere(HttpServletRequest request , ComuDTO comu) {
		
		return bDAO.getSearch_where(request, comu);
	}
	@RequestMapping(value = "/do.upload-board", method = RequestMethod.POST)
	public String doUploadBoard(HttpServletRequest request) {
		
		/*bDAO.uploadBoard(request);*/
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "bulletin/board-community.jsp");
		return "index";
	}
	
	
}
