package com.project.camping.account;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.scribejava.core.model.OAuth2AccessToken;
@Controller
public class AccountController {
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	@Autowired
	SqlSession ss;
	
	@Autowired
	private AccountDAO aDAO;
	private HttpServletResponse response;
	
	@RequestMapping(value = "/go.to.Main", method = RequestMethod.GET)
	public String goToMain(HttpServletRequest request) {
		
		aDAO.autoLogin(request);
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	//do.account.login
	@RequestMapping(value = "/do.account.login", method = RequestMethod.POST)
	public String refreshCampingData(HttpServletRequest request, HttpServletResponse response, AccountDTO a) {
		
		aDAO.login(request, response, a);
		aDAO.loginCheck(request);
		
		request.setAttribute("color", 1);
		request.setAttribute("contentPage", "home.jsp");
		
		return "index";
	}
	@RequestMapping(value = "/go.Login.Head", method = {RequestMethod.GET, RequestMethod.POST })
	public String goLoginHead(HttpServletRequest request,Model model, HttpSession session) {
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		aDAO.makeNaverUrl(request,model,session);
		
		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "account/loginHead.jsp");
		return "index";
	}
	
	//
	// 추가로 입력한 부분
	//
	@RequestMapping(value = "/accountReg.go", method = RequestMethod.GET)
	public String accountReg(HttpServletRequest req) {
		return "account/accountRegN";
	}
	@RequestMapping(value = "/go.Login.Head.callback", method = RequestMethod.GET)
	public String GoLoginCallback(HttpServletRequest req) {
		
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/callback.jsp");
		return "index";
	}
	
	// 회원가입 & 로그아웃 (return 수정 필요)
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logoutDo(HttpServletRequest req, HttpServletResponse response) {
		aDAO.logout(req, response);
		aDAO.loginCheck(req);
		
		req.setAttribute("color", 1);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/accountReg.do", method = RequestMethod.POST)
	public String accountRegDo(HttpServletRequest req, Model m, AccountDTO a) throws IOException {

		aDAO.accoutRegDo(req, m, a);
		
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/accountUpdate.do", method = RequestMethod.POST)
	public String accountUpdateDo(HttpServletRequest req, AccountDTO ac) throws IOException {
		
		aDAO.accoutUpateDo(req,ac);
		
		aDAO.loginCheck(req);
		
		req.setAttribute("Click", 3);
		req.setAttribute("contentPage", "account/ask_pw_page.jsp");
		
		return "index";
	}

	@RequestMapping(value = "/deleteUser.do", method = RequestMethod.GET)
	public String deleteUserDo(HttpServletRequest req) {
		
		aDAO.deleteUser(req);
		
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/login.go", method = RequestMethod.GET)
	public String loginGo(HttpServletRequest req) {

		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/loginHead.jsp");
		return "index";
	}

	@RequestMapping(value = "/doubleCheckPw.go", method = RequestMethod.POST)
	@ResponseBody
	public int doubleCheckPw(HttpServletRequest req, Model m, AccountDTO a) {
		
		return aDAO.doubleCheckPw(req,a);
	}
	@RequestMapping(value = "/myPage.go", method = RequestMethod.GET)
	public String myPageGo(HttpServletRequest req, Model m, AccountDTO a) {
		aDAO.loginCheck(req);
		
		req.setAttribute("Click", 3);
		req.setAttribute("contentPage", "account/ask_pw_page.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/myPage.do", method = RequestMethod.GET)
	public String myPageDo(HttpServletRequest req, AccountDTO a) {
		
		return "account/myPageN";
	}
	
	    //아이디 중복 검사
	    @RequestMapping(value="/check.id", method=RequestMethod.GET)
	    @ResponseBody
	    public int checkId(HttpServletRequest req){
	    	
	    	return aDAO.idCheck(req);
	    }
	    
	    // 아이디 or 비번 찾기
	    @RequestMapping(value="/searchID.go", method=RequestMethod.GET)
	    public String goFindID(HttpServletRequest req){
			aDAO.loginCheck(req);
			req.setAttribute("contentPage", "account/searchId.jsp");
	    	return "index";
	    }
	    
	    // 로그인 창에서 처음으로 id/pw 찾는 페이지로
	    @RequestMapping(value="/searchTheId.go", method = {RequestMethod.GET, RequestMethod.POST })
	    public String goFindId(HttpServletRequest req){
	    	
	    	aDAO.loginCheck(req);
	    	req.setAttribute("contentPage", "account/find_Id_Page.jsp");
	    	return "index";
	    }
	    // 로그인 창에서 처음으로 id/pw 찾는 페이지로
	    @RequestMapping(value="/searchThePw.go", method = {RequestMethod.GET, RequestMethod.POST })
	    public String goFindPW(HttpServletRequest req){
	    	
	    	aDAO.loginCheck(req);
	    	req.setAttribute("contentPage", "account/find_Pw_page.jsp");
	    	return "index";
	    }
	    
	    // 아이디 찾기

	    @RequestMapping(value="/searchID.do", method=RequestMethod.POST)
	    @ResponseBody
	    public String doFindID(HttpServletRequest req){
	    	return aDAO.doFindId(req);
	    }
	    
	    //메일로 임시코드 보내기
	    @RequestMapping(value="/searchPW.do", method=RequestMethod.POST)
	    @ResponseBody
	    public int doFindPW(HttpSession session, HttpServletRequest req, HttpServletResponse response){
	    	
	    	return aDAO.sendPW_byMail(req,session,response);
	    }
	    
	    // 비밀번호 재설정
	    @RequestMapping(value="/changePw.after.findPw.go", method=RequestMethod.GET)
	    public String changePwGo(AccountDTO aDTO, HttpServletRequest req,HttpSession session){
//	    	aDAO.checkMailPw(req,session);
	    	
	    	// 비밀번호 바꾸게 하고 재로그인하게 유도
	    	req.setAttribute("ac_id", aDTO.getAc_id());
	    	
	    	aDAO.loginCheck(req);
	    	req.setAttribute("contentPage", "account/PwUpdate.jsp");
	    	
	    	return "index";
	    }
	    
	    //비밀번호 update 후 -> 다시 로그인 화면
	    @RequestMapping(value="/changePw.after.findPw.do", method=RequestMethod.POST)
	    public String changePwDo(HttpServletRequest req , AccountDTO a){
	    	
	    	aDAO.resetPw(req, a);
	    	
	    	aDAO.loginCheck(req);
	    	
	    	req.setAttribute("contentPage", "home.jsp");
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
	    	@ResponseBody
	    	public String sendSms(HttpServletRequest request) throws Exception {
	    	  return aDAO.sendSms_Do(request);
	    	}
	    	
//네아로
	    	//네이버 로그인 성공시 callback호출 메소드
	    	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	    	public String callback(HttpServletRequest request,Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException {
	    		
	    		System.out.println("여기는 callback");
	    		OAuth2AccessToken oauthToken;
	            oauthToken = naverLoginBO.getAccessToken(session, code, state);
	     
	            //1. 로그인 사용자 정보를 읽어온다.
	    		apiResult = naverLoginBO.getUserProfile(oauthToken);  //String형식의 json데이터
	    		
	    		/** apiResult json 구조
	    		{"resultcode":"00",
	    		 "message":"success",
	    		 "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
	    		**/
	    		
	    		//2. String형식인 apiResult를 json형태로 바꿈
	    		JSONParser parser = new JSONParser();
	    		Object obj = parser.parse(apiResult);
	    		JSONObject jsonObj = (JSONObject) obj;
	    		
	    		//3. 데이터 파싱 
	    		//Top레벨 단계 _response 파싱
	    		JSONObject response_obj = (JSONObject)jsonObj.get("response");
	    		//response의 nickname값 파싱
	    		String id = (String)response_obj.get("id");
	    		String gender = (String)response_obj.get("gender");
	    		String email = (String)response_obj.get("email");
	    		String name = (String)response_obj.get("name");
	    		String birthyear = (String)response_obj.get("birthyear");
	    		String birthday = (String)response_obj.get("birthday");
	    		String profile = (String)response_obj.get("profile_image");
	    		String phone = (String)response_obj.get("mobile");
	    		
	    // db에 id가 있으면 -> 바로 로그인
	    //네이버로 받은 값 출력 -> db에 저장
	    //db에 id가 없으면 추가 정보 받고 로그인 -> db에 저장 
	    //필요 정보 id/pw/name/birth/phone/주소들/gender/file
	    		//if(email == 이미 존재) -> 해당account = setAttribute / content -> home.jsp
	    		//id가 이미 있는지 확인
	    		AccountDTO a2 = ss.getMapper(AccountMapper.class).getAccountByEmail(email);
	    		
	    		if(a2 != null) {
	    			request.getSession().setAttribute("loginAccount", a2);
	    			
					aDAO.loginCheck(request);
					request.setAttribute("contentPage", "home.jsp");
					
		    		return "index";
	    		}else {
		    		session.setAttribute("reg_id", id);
		    		session.setAttribute("reg_gender", gender);
		    		session.setAttribute("reg_email", email);
		    		session.setAttribute("reg_name", name);
		    		session.setAttribute("reg_birthyear", birthyear);
		    		session.setAttribute("reg_birthday", birthday);
		    		session.setAttribute("reg_profile", profile);
		    		session.setAttribute("reg_phone", phone);
		    		

		    		//request.getSession().setAttribute("loginAccount", a2);
		    		
		    		//4.파싱 닉네임 세션으로 저장
		    		//session.setAttribute("loginAccount",ac_id); //세션 생성
		    		session.setAttribute("sessionId",id);
		    		model.addAttribute("result", apiResult);
		    		
					aDAO.loginCheck(request);
					request.setAttribute("contentPage", "account/addMoreInfo.jsp");
					
		    		return "index";
	    		}

	    	}    	
	    	
	    	
	    	@RequestMapping(value="/naver.addMoreInfo.do", method=RequestMethod.POST)
		    public String naver_addmore(HttpSession session, HttpServletRequest req, AccountDTO ac){
		    	
	    		aDAO.naver_reg(req, session,ac);
	    		
				aDAO.loginCheck(req);
				req.setAttribute("contentPage", "home.jsp");
				
		    	return "index";
		    }
//	    	@RequestMapping(value="/delete_account", method=RequestMethod.GET)
//		    public String delete_account(HttpSession session, HttpServletRequest req, AccountDTO ac){
//		    	
//	    		aDAO.deleteAccount(req, session,ac);
//	    		
//				aDAO.loginCheck(req);
//				req.setAttribute("contentPage", "home.jsp");
//				
//		    	return "index";
//		    }
//	    	
	    	
	    	
}
	    
