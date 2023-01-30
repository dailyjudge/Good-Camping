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
		
		bDAO.getBoard(1, request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "bulletin/board-community.jsp");
		return "index";
	}


	 @RequestMapping(value = "/go.board.comu", method = RequestMethod.GET) public
	 String goBoardComu(HttpServletRequest request) {
	 
		bDAO.getBoard(1, request);
		
		
		aDAO.loginCheck(request); 
		request.setAttribute("contentPage","bulletin/board-community.jsp"); 
		return "index"; 
	}

	@RequestMapping(value = "/board.page.change", method = RequestMethod.GET)
	public String boardpPageChange(HttpServletRequest request) {
		
		int p =Integer.parseInt(request.getParameter("p"));
		bDAO.getBoard(p, request);
		
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
	@RequestMapping(value = "/go.board.view", method = RequestMethod.GET)
	public String goBoardView(HttpServletRequest request) {
		
		bDAO.getThisBoard(request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "bulletin/board-view.jsp");
		return "index";
	}
	//게시글 수정 -> 수정 페이지로
	@RequestMapping(value = "/edit.thisBoard", method = RequestMethod.GET)
	public String editThisBoard(HttpServletRequest request) {
		
		bDAO.getEditBoard(request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "bulletin/board-edit.jsp");
		return "index";
	}
	
	//게시글 수정
	@RequestMapping(value = "/do.edit.thisBoard", method = RequestMethod.POST)
	public String doEditThisBoard(HttpServletRequest request, ComuDTO cd) {
		
		if(aDAO.loginCheck2(request)) {
			bDAO.upDateBoard(request, cd);
		}
		bDAO.getBoard(1, request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "bulletin/board-community.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.search.where", method = RequestMethod.GET)
	@ResponseBody
	public int goSearchWhere(HttpServletRequest request , ComuDTO comu) {
		
		return bDAO.getSearch_where(request, comu);
	}
	@RequestMapping(value = "/do.upload-board", method = RequestMethod.POST)
	public String doUploadBoard(HttpServletRequest request, ComuDTO cd) {
		
		if(aDAO.loginCheck2(request)) {
			bDAO.uploadBoard(request, cd);
		}
		bDAO.getBoard(1, request);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "bulletin/board-community.jsp");
		return "index";
	}
	
	
}
