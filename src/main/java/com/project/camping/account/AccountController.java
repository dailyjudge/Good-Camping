package com.project.camping.account;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
public class AccountController {
	
	@Autowired
	private AccountDAO aDAO;
	private HttpServletResponse response;
	
	@RequestMapping(value = "/go.to.Main", method = RequestMethod.GET)
	public String goToMain(HttpServletRequest request) {
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	//do.account.login
	@RequestMapping(value = "/do.account.login", method = RequestMethod.POST)
	public String refreshCampingData(HttpServletRequest request, AccountDTO a) {
		
		aDAO.login(request,a);
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/go.Login.Head", method = RequestMethod.GET)
	public String goLoginHead(HttpServletRequest request) {
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "account/loginHead.jsp");
		return "index";
	}
	
	//
	// 추가로 입력한 부분
	//
	@RequestMapping(value = "/accountReg.go", method = RequestMethod.GET)
	public String accountReg(HttpServletRequest req) {
		
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/accountReg.jsp");
		return "index";
	}
	
	// 회원가입 & 로그아웃 (return 수정 필요)
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logoutDo(HttpServletRequest req) {
		aDAO.logout(req) ;
		aDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/accountReg.do", method = RequestMethod.POST)
	public String accountRegDo(HttpServletRequest req, Model m, AccountDTO a) throws IOException {

		aDAO.accoutRegDo(req, m, a);

		return "account/loginHead";
	}

//	@RequestMapping(value = "/login.go", method = RequestMethod.POST)
//	public String loginGo(HttpServletRequest req, Model m, AccountDTO a) {
//
//		aDAO.login(req, a);
//
//		return "account/loginHead";
//	}

	@RequestMapping(value = "/myPage.go", method = RequestMethod.GET)
	public String myPageGo(HttpServletRequest req, Model m, AccountDTO a) {
		AccountDTO b = (AccountDTO) req.getSession().getAttribute("loginAccount");

		return "account/myPage";
	}
	
	// 네이버 로그인 (return 수정 필요)
	 @RequestMapping("/naver.do")
	    public String naver() {
	        return "account/naver_login";
	    }
	    
	    
	    @RequestMapping(value="/callback", method=RequestMethod.GET)
	    public String callBack(){
	        return "account/callback";
	    }
	    
	    @RequestMapping(value="naverSave", method=RequestMethod.POST)
	    public @ResponseBody String naverSave(@RequestParam("ac_birth") String ac_birth, @RequestParam("ac_email") String ac_email, @RequestParam("ac_gender") String ac_gender,@RequestParam("ac_name") String ac_name) {
	    System.out.println("#############################################");
	    System.out.println(ac_birth);
	    System.out.println(ac_email);
	    System.out.println(ac_gender);
	    System.out.println(ac_name);
	    System.out.println("#############################################");
	 
	    AccountDTO naver = new AccountDTO();
	    naver.setAc_birth(ac_birth);
	    naver.setAc_id(ac_email);
	    naver.setAc_gender(ac_gender);
	    naver.setAc_name(ac_name);
	    
	    String result = "no";
	    
	    if(naver!=null) {
	        result = "ok";
	    }
	 
	    return result;
	    
	    }
	    
	    @RequestMapping(value="/check.id", method=RequestMethod.GET)
	    public String checkId(HttpServletRequest req){
	    	aDAO.idCheck(req);
	    	
	    	return "account/idCheck";
	    }
	    // 아이디 or 비번 찾기
	    @RequestMapping(value="/searchID.go", method=RequestMethod.GET)
	    public String goFindID(HttpServletRequest req){
			aDAO.loginCheck(req);
			req.setAttribute("contentPage", "account/searchId.jsp");
	    	return "index";
	    }
	    // 로그인 창에서 처음으로 id/pw 찾는 페이지로
	    @RequestMapping(value="/searchPW.go", method=RequestMethod.GET)
	    public String goFindPW(HttpServletRequest req){
	    	
	    	aDAO.loginCheck(req);
	    	req.setAttribute("contentPage", "account/find_Id_Pw.jsp");
	    	return "index";
	    }
	    // 아이디 찾기
	    @RequestMapping(value="/searchID.do", method=RequestMethod.POST)
	    public String doFindID(HttpServletRequest req){
	    	
	    	aDAO.doFindId(req);
	    	
			aDAO.loginCheck(req);
			req.setAttribute("contentPage", "account/searchIdResult.jsp");
			
	    	return "index";
	    }
	    //메일로 임시코드 보내기
	    @RequestMapping(value="/searchPW.do", method=RequestMethod.POST)
	    public String doFindPW(HttpSession session, HttpServletRequest req, HttpServletResponse response){
	    	
	    	//메일 보내기
	    	aDAO.sendPW_byMail(req,session,response);
	    	
	    	aDAO.loginCheck(req);
	    	req.setAttribute("contentPage", "account/searchPwResult.jsp");
	    	
	    	return "index";
	    }
	    // 메일 인증코드와 입력한 값 비교 -> 비밀번호 재설정(update) 부분
	    @RequestMapping(value="/changePw.after.findPw.go", method=RequestMethod.GET)
	    public String changePwGo(HttpServletRequest req,HttpSession session){
	    	aDAO.checkMailPw(req,session);
	    	
	    	aDAO.loginCheck(req);
	    	req.setAttribute("contentPage", "account/PwUpdate.jsp");
	    	
	    	return "index";
	    }
	    //비밀번호 update 후 -> 다시 로그인 화면
	    @RequestMapping(value="/changePw.after.findPw.do", method=RequestMethod.POST)
	    public String changePwDo(HttpServletRequest req){
	    	req.setAttribute("contentPage", "account/loginHead.jsp");
	    	
	    	aDAO.resetPw(req);
	    	aDAO.loginCheck(req);
	    	
	    	
	    	return "index";
	    }
	    // 처음 로그인 화면으로 돌아가기
	    @RequestMapping(value="/accountHome.go", method=RequestMethod.GET)
	    public String GoAccountHome(HttpServletRequest req){
	    	
			aDAO.loginCheck(req);
			req.setAttribute("contentPage", "account/loginHead.jsp");
			
	    	return "index";
	    }
	    
	    // 휴대폰 인증 (회원가입)
	    	@RequestMapping(value = "/sendSms.do")
	    	public String sendSms(HttpServletRequest request) throws Exception {
	    		
	    		aDAO.sendSms_Do(request);
	    		
				aDAO.loginCheck(request);
				request.setAttribute("contentPage", "account/accountReg.jsp");

	    	  return "index";
	    	}

	    }
	    
