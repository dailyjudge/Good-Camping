package com.project.camping.account;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@RequestMapping(value = "/seachpw.go", method = RequestMethod.GET)
	public String seachpwGo(HttpServletRequest req) {
		
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/searchpw.jsp");
		return "index";
	}
	
//	 @RequestMapping("/sendpw.do")
//	    public ModelAndView sendEmailAction (@RequestParam Map<String, Object> paramMap, ModelMap model) throws Exception {
//	        ModelAndView mav;
//	        String id=(String) paramMap.get("id");
//	        String e_mail=(String) paramMap.get("email");
//	        String pw= mainService.getPw(paramMap);
//	        System.out.println(pw);
//	        if(pw!=null) {
//	            email.setContent("��й�ȣ�� "+pw+" �Դϴ�.");
//	            email.setReceiver(e_mail);
//	            email.setSubject(id+"�� ��й�ȣ ã�� �����Դϴ�.");
//	            emailSender.SendEmail(email);
//	            mav= new ModelAndView("redirect:/login.do");
//	            return mav;
//	        }else {
//	            mav=new ModelAndView("redirect:/logout.do");
//	            return mav;
//	        }
//	    }
	 // ���̹� ���� �α���
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
	    @RequestMapping(value="/seachPw.go", method=RequestMethod.GET)
	    public String GoSeachPw(HttpServletRequest req){
			aDAO.loginCheck(req);
			req.setAttribute("contentPage", "account/searchpw.jsp");
	    	return "index";
	    }
	    @RequestMapping(value="/searchID.do", method=RequestMethod.GET)
	    public String doFindID(HttpServletRequest req){
	    	
	    	aDAO.doFindId(req);
			aDAO.loginCheck(req);
			req.setAttribute("contentPage", "account/searchIdResult.jsp");
			
	    	return "index";
	    }
	    @RequestMapping(value="/accountHome.go", method=RequestMethod.GET)
	    public String GoAccountHome(HttpServletRequest req){
	    	
			aDAO.loginCheck(req);
			req.setAttribute("contentPage", "account/loginHead.jsp");
			
	    	return "index";
	    }
	    
//	    @RequestMapping(value = "/phoneCheck", method = RequestMethod.GET)
//	    @ResponseBody
//	    public String sendSMS(@RequestParam("phone") String userPhoneNumber) { // �޴��� ���ں�����
//	    	int randomNumber = (int)((Math.random()* (9999 - 1000 + 1)) + 1000);//���� ����
//
//	    	testService.certifiedPhoneNumber(userPhoneNumber,randomNumber);
//	    	
//	    	return Integer.toString(randomNumber);
//	    }
	    
	    	@RequestMapping(value = "/sendSms.do")
	    	public String sendSms(HttpServletRequest request) throws Exception {
	    		
	    		Random random = new Random();		//랜덤 함수 선언
	    		int createNum = 0;  			//1자리 난수
	    		String ranNum = ""; 			//1자리 난수 형변환 변수
	            int letter    = 6;			//난수 자릿수:6
	    		String resultNum = "";  		//결과 난수
	    		
	    		for (int i=0; i<letter; i++) { 
	                		
	    			createNum = random.nextInt(9);		//0부터 9까지 올 수 있는 1자리 난수 생성
	    			ranNum =  Integer.toString(createNum);  //1자리 난수를 String으로 형변환
	    			resultNum += ranNum;			//생성된 난수(문자열)을 원하는 수(letter)만큼 더하며 나열
	    		}
	    		
	    	  String api_key = "NCSMH2UDME7WGBSB";
	    	  String api_secret = "DF0VOHPG4VCEU4LI7PIQQKEDHIKKUTL8";
	    	  Message coolsms = new Message(api_key, api_secret);

	    	  HashMap<String, String> set = new HashMap<String, String>();
	    	  set.put("to", "01075885745"); // 수신번호

	          set.put("from", request.getParameter("num") ); // 발신번호, jsp에서 전송한 발신번호를 받아 map에 저장한다.
	          set.put("text", resultNum);
	    	  set.put("type", "sms"); // 문자 타입
	    	  set.put("app_version", "test app 1.2"); 

	    	  System.out.println(set);
	    	  try {
	    	  JSONObject result = coolsms.send(set); // 보내기&전송결과받기

	    	  System.out.println(result.toString());
	        } catch (CoolsmsException e) {
	          System.out.println(e.getMessage());
	          System.out.println(e.getCode());
	        }

	    	  return "index";
	    	}

	    }
	    
