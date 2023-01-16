package com.project.camping.account;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class AccountDAO {
	@Autowired
	SqlSession ss;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void login(HttpServletRequest req, AccountDTO ac) {
		//post input
		String id2 = req.getParameter("ac_id");
		String pw2 = req.getParameter("ac_pw");
		String loginallways = "";
		loginallways = req.getParameter("loginallways");
		
		ac.setAc_id(id2);
		ac.setAc_pw(pw2);
		
		AccountDTO a2 = ss.getMapper(AccountMapper.class).getAccountById(ac);
		
		if(a2 != null) {
			if(ac.getAc_pw().equals(a2.getAc_pw())) {
				req.getSession().setAttribute("loginAccount", a2);
				if(loginallways == null) {
					req.getSession().setMaxInactiveInterval(60*10);
				}else if(loginallways.equals("on")) {
					req.getSession().setMaxInactiveInterval(60*200);
				}
			}else {
				req.setAttribute("r", "로그인 실패 -> pw오류");
			}
		}else {
			req.setAttribute("r", "로그인 실패 -> 미가입 id");
		}
		
	}

	public void loginCheck(HttpServletRequest request) {
		// 이건 나중에 한번 봄
		AccountDTO a = (AccountDTO) request.getSession().getAttribute("loginAccount");
		
		if(a == null) {
			request.setAttribute("loginPage", "account/login.jsp");
		} else {
			request.setAttribute("loginPage", "account/login_done.jsp");
		}
	}
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginAccount", null);
	}
	public void idCheck(HttpServletRequest req) {
		String ac_id2 = req.getParameter("ac_id2");
		System.out.println(ac_id2);
		
		String check = ss.getMapper(AccountMapper.class).getIdCheck(ac_id2);
		
		if(check.equals(ac_id2)) {
			req.setAttribute("idCheckResult", "no");
		}else {
			req.setAttribute("idCheckResult", "ok");
		}
		req.setAttribute("ac_id2", ac_id2);
	}
	public void alertAndBack(HttpServletResponse response, String msg) {
	    try {
	        response.setContentType("text/html; charset=utf-8");
	        PrintWriter w = response.getWriter();
	        w.write("<script>alert('"+msg+"');history.go(-1);</script>");
	        w.flush();
	        w.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public void accoutRegDo(HttpServletRequest req, Model m, AccountDTO ac){
		String path = req.getSession().getServletContext().getRealPath("resources/profilePic");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 31457200, "utf-8", new DefaultFileRenamePolicy());
			
			ac.setAc_id(mr.getParameter("ac_id"));
			ac.setAc_pw(mr.getParameter("ac_pw"));
			ac.setAc_name(mr.getParameter("ac_name"));
			ac.setAc_birth(mr.getParameter("ac_birth"));
			ac.setAc_phone(mr.getParameter("ac_phone"));
			ac.setAc_postcode(mr.getParameter("ac_postcode"));
			
			ac.setAc_address(mr.getParameter("ac_address"));
			ac.setAc_detailAddress(mr.getParameter("ac_detailAddress"));
			ac.setAc_extraAddress(mr.getParameter("ac_extraAddress"));
			ac.setAc_gender(mr.getParameter("ac_gender"));
			
			String ac_file = mr.getFilesystemName("ac_file");
			ac.setAc_file(ac_file);
			req.setAttribute("accountInfo", ac);
			
			AccountMapper mm = ss.getMapper(AccountMapper.class);
			if(mm.accountRegDoIt(ac)==1) {
				req.setAttribute("r", "등록 성공");
			} else {
				req.setAttribute("r", "등록 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("ac_file");
			new File(path+"/"+fileName).delete();
			req.setAttribute("r", "가입 실패");
			
		}
		
		
	}

	public void doFindId(HttpServletRequest req) {
		String sr_name = req.getParameter("sr_name");
		String sr_phone = req.getParameter("sr_phone");
		
		//map 이용해서 
		Map<String, String> findId = new HashMap<String, String>();
		findId.put("ac_name", sr_name);
		findId.put("ac_phone", sr_phone);
		
		AccountMapper mm = ss.getMapper(AccountMapper.class);
		String userId = mm.GoFindId(findId);
		if(userId.equals(null)) {
			req.setAttribute("userId", "해당 회원은 존재하지 않습니다.");
		}else {
			req.setAttribute("userId", userId);
		}
		
	}
	public void sendPW_byMail(HttpServletRequest req, HttpSession session, HttpServletResponse response) {
			String ac_id = (String)req.getParameter("pwFind_id");
			String name = (String)req.getParameter("pwFind_name");

			AccountMapper mm = ss.getMapper(AccountMapper.class);
			AccountDTO vo = mm.selectAccount(ac_id);
				
			if(vo != null) {
			Random r = new Random();
			int num = r.nextInt(9999); // 랜덤난수설정
			session.setAttribute("num", num);
			
			if (vo.getAc_name().equals(name)) {
				session.setAttribute("email", vo.getAc_id());

				 String setfrom = "arizona19973@gmail.com"; // naver 
				 String tomail = ac_id; //받는사람
				 String title = "[삼삼하개] 비밀번호변경 인증 이메일 입니다"; 
				 String content = System.getProperty("line.separator") + "안녕하세요 회원님" + System.getProperty("line.separator")
						+ "삼삼하개 비밀번호찾기(변경) 인증번호는 " + num + " 입니다." + System.getProperty("line.separator"); // 
				try {
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");

					messageHelper.setFrom(setfrom); 
					messageHelper.setTo(tomail); 
					messageHelper.setSubject(title);
					messageHelper.setText(content); 

					mailSender.send(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
	}
}
	public void checkMailPw(HttpServletRequest req,HttpSession session) {
		String pw1 = req.getParameter("pw1");
		String pw2 = req.getParameter("pw2");
		String pw3 = req.getParameter("pw3");
		String pw4 = req.getParameter("pw4");
		String sum = pw1+pw2+pw3+pw4;
		
		String num = (String) session.getAttribute("num");
		
		//sum의 값과 인증코드가 맞으면 비밀번호 update 페이지로
		if(num.equals(sum)) {
			req.setAttribute("contentPage", "account/PwUpdate.jsp");
		}else {
			// 실패했을 때 (서로 안 맞는 경우) -> 실패 페이지 보내주기
			req.setAttribute("contentPage", "account/find_Id_pw.jsp");
		}
	}

	public void resetPw(HttpServletRequest req) {
		String ac_pw = (String)req.getParameter("re_Pw");

		AccountMapper mm = ss.getMapper(AccountMapper.class);
		//mm.
	}

	public void sendSms_Do(HttpServletRequest request) {
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
			request.setAttribute("resultNum", resultNum);
			
		  String api_key = "NCSMH2UDME7WGBSB";
		  String api_secret = "DF0VOHPG4VCEU4LI7PIQQKEDHIKKUTL8";
		  Message coolsms = new Message(api_key, api_secret);
	
		  HashMap<String, String> set = new HashMap<String, String>();
		  set.put("to", request.getParameter("phone_num")); // 수신번호
		  
	      set.put("from","01075042792"); // 발신번호, jsp에서 전송한 발신번호를 받아 map에 저장한다.
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
	}

}
	
