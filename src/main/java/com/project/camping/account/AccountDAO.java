package com.project.camping.account;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.camping.main.MainMapper;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class AccountDAO {
	@Autowired
	SqlSession ss;

	@Autowired
	private JavaMailSender mailSender;

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	public void login(HttpServletRequest req, HttpServletResponse response, AccountDTO ac) {
		// post input
		String id2 = req.getParameter("ac_id");
		String pw2 = req.getParameter("ac_pw");
		String loginallways = "";
		loginallways = req.getParameter("loginallways");

		ac.setAc_id(id2);
		ac.setAc_pw(pw2);

		AccountDTO a2 = ss.getMapper(AccountMapper.class).getAccountById(ac);

		if (a2 != null) {
			if (ac.getAc_pw().equals(a2.getAc_pw())) {
				req.getSession().setAttribute("loginAccount", a2);
				if (loginallways == null) {
					req.getSession().setMaxInactiveInterval(60 * 10);
				} else if (loginallways.equals("on")) {
					// 자동로그인을 체크한 경우

					// 세션 값
					Cookie cookie = new Cookie("loginCookie", a2.getAc_id());
					// SessionId : 6D6FDA1F96413C09419DEFA151AAB587

					cookie.setPath("/");
					int amount = 60 * 60 * 24 * 7;
					cookie.setMaxAge(amount);
					
					// 세션 유효기간
					Date ac_sessionlimit = new Date(System.currentTimeMillis() + (1000 * amount));

					System.out.println("세션 유효기간 : " + ac_sessionlimit);
					// 쿠키 적용
					response.addCookie(cookie);
					
					// 실제 디비에 내용 저장하기
					a2.setAc_sessionkey(a2.getAc_id());
					a2.setAc_sessionlimit(ac_sessionlimit);
					if (ss.getMapper(AccountMapper.class).addUserSession(a2) == 1) {
						System.out.println("사용자 자동 로그인 쿠키 등록 완료");
					} else {
						System.out.println("사용자 자동 로그인 쿠키 등록 실패");
					}
				}
			} else {
				req.setAttribute("r", "로그인 실패 -> pw오류");
			}
		} else {
			req.setAttribute("r", "로그인 실패 -> 미가입 id");
		}

	}

	public void loginCheck(HttpServletRequest request) {
		// 이건 나중에 한번 봄
		AccountDTO a = (AccountDTO) request.getSession().getAttribute("loginAccount");

		if (a == null) {

			request.setAttribute("loginPage", "account/login.jsp");

			String page = request.getRequestURL().toString();
			String params = request.getQueryString();

			if (params != null)
				page += "?" + params;
			System.out.println("page : " + page);
			// 로그인 화면 클릭한 경우가 아니라면
			if (!page.contains("go.Login.Head"))
				request.getSession().setAttribute("prevPage", page);

		} else {
			request.setAttribute("loginPage", "account/login_done.jsp");
		}
	}

	public void logout(HttpServletRequest req, HttpServletResponse response) {
		System.out.println("로그아웃 !!");
		req.getSession().setAttribute("loginAccount", null);
		
		Cookie loginCookie = new Cookie("loginCookie", null); // choiceCookieName(쿠키 이름)에 대한 값을 null로 지정
		
		loginCookie.setPath("/");
		loginCookie.setMaxAge(0); // 유효시간을 0으로 설정
		
		System.out.println("유효기간 체크 : "  + loginCookie.getMaxAge());
		System.out.println("값 체크 :  " + loginCookie.getValue());
		response.addCookie(loginCookie);
	}

	public int idCheck(HttpServletRequest req) {
		String ac_id2 = req.getParameter("ac_id2");
		System.out.println(ac_id2);

		// check : 1이면 x, 0이면 o
		return ss.getMapper(AccountMapper.class).getIdCheck(ac_id2);
//		if(check.equals(ac_id2)) {
//			req.setAttribute("idCheckResult", "no");
//		}else {
//			req.setAttribute("idCheckResult", "ok");
//		}
//		req.setAttribute("ac_id2", ac_id2);
	}

	public void alertAndBack(HttpServletResponse response, String msg) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			w.write("<script>alert('" + msg + "');history.go(-1);</script>");
			w.flush();
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void accoutRegDo(HttpServletRequest req, Model m, AccountDTO ac) {
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
			if (mm.accountRegDoIt(ac) == 1) {
				req.setAttribute("r", "등록 성공");
			} else {
				req.setAttribute("r", "등록 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("ac_file");
			new File(path + "/" + fileName).delete();
			req.setAttribute("r", "가입 실패");

		}

	}

	public String doFindId(HttpServletRequest req) {
		String sr_name = req.getParameter("sr_name");
		String sr_phone = req.getParameter("sr_phone");
		
		// map 이용해서
		Map<String, String> findId = new HashMap<String, String>();
		findId.put("ac_name", sr_name);
		findId.put("ac_phone", sr_phone);

		return ss.getMapper(AccountMapper.class).GoFindId(findId);

	}

	public int sendPW_byMail(HttpServletRequest req, HttpSession session, HttpServletResponse response) {
		String ac_id = (String) req.getParameter("ac_id");
		String name = (String) req.getParameter("ac_name");

		AccountMapper mm = ss.getMapper(AccountMapper.class);
		AccountDTO vo = mm.selectAccount(ac_id);

		// 실제로 아이디가 존재한다면.
		if (vo != null) {
			Random r = new Random();
			int num = r.nextInt(9999); // 랜덤난수설정

//				session.setAttribute("num", num);
//				session.setAttribute("the_id", ac_id);

			if (vo.getAc_name().equals(name)) {
//				 session.setAttribute("email", vo.getAc_id());

				String setfrom = "jun19975@naver.com"; // naver
				String tomail = ac_id; // 받는사람
				String title = "[삼삼하개] 비밀번호변경 인증 이메일 입니다";
				String content = System.getProperty("line.separator") + "안녕하세요 회원님"
						+ System.getProperty("line.separator") + "삼삼하개 비밀번호찾기(변경) 인증번호는 " + num + " 입니다."
						+ System.getProperty("line.separator"); //
				try {
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");

					messageHelper.setFrom(setfrom);
					messageHelper.setTo(tomail);
					messageHelper.setSubject(title);
					messageHelper.setText(content);

					mailSender.send(message);
					System.out.println("전송 완료");

					return num;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			return 0;
		}
		return 0;
	}

	public void checkMailPw(HttpServletRequest req, HttpSession session) {
		String pw1 = req.getParameter("pw1");
		String pw2 = req.getParameter("pw2");
		String pw3 = req.getParameter("pw3");
		String pw4 = req.getParameter("pw4");
		String sum = pw1 + pw2 + pw3 + pw4;

		String num = (String) session.getAttribute("num");

		// sum의 값과 인증코드가 맞으면 비밀번호 update 페이지로
		if (num.equals(sum)) {
			req.setAttribute("contentPage", "account/PwUpdate.jsp");
		} else {
			// 실패했을 때 (서로 안 맞는 경우) -> 실패 페이지 보내주기
			req.setAttribute("contentPage", "account/find_Id_pw.jsp");
		}
	}

	public void resetPw(HttpServletRequest req, AccountDTO a) {
		AccountMapper mm = ss.getMapper(AccountMapper.class);
		
		
		if (mm.updatePw(a) == 1) {
			System.out.println("성공");
			req.getSession().setAttribute("loginAccount", mm.getAccountById(a));
		} else {
			req.setAttribute("r", "비밀번호 재설정 실패");
		}
	}

	public String sendSms_Do(HttpServletRequest request) {
		System.out.println("들어옴!!");
		System.out.println(request.getAttribute("num"));

		Random random = new Random(); // 랜덤 함수 선언
		int createNum = 0; // 1자리 난수
		String ranNum = ""; // 1자리 난수 형변환 변수
		int letter = 6; // 난수 자릿수:6
		String resultNum = ""; // 결과 난수

		for (int i = 0; i < letter; i++) {
			createNum = random.nextInt(9); // 0부터 9까지 올 수 있는 1자리 난수 생성
			ranNum = Integer.toString(createNum); // 1자리 난수를 String으로 형변환
			resultNum += ranNum; // 생성된 난수(문자열)을 원하는 수(letter)만큼 더하며 나열
		}

//			request.setAttribute("resultNum", resultNum);

		String api_key = "NCSMH2UDME7WGBSB";
		String api_secret = "DF0VOHPG4VCEU4LI7PIQQKEDHIKKUTL8";
		Message coolsms = new Message(api_key, api_secret);

		HashMap<String, String> set = new HashMap<String, String>();
		set.put("to", request.getParameter("num")); // 수신번호

		set.put("from", "01075042792"); // 발신번호, jsp에서 전송한 발신번호를 받아 map에 저장한다.
		set.put("text", resultNum);
		set.put("type", "sms"); // 문자 타입
		set.put("app_version", "test app 1.2");

		System.out.println(set);
		try {
			JSONObject result = coolsms.send(set); // 보내기&전송결과받기

			return resultNum;
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		return null;
	}

	public void makeNaverUrl(HttpServletRequest request, Model model, HttpSession session) {
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		// https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		// redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);

		// 네이버
		model.addAttribute("url", naverAuthUrl);

	}

	public void naver_reg(HttpServletRequest req, HttpSession session, AccountDTO ac) {
		String ac_id = (String) session.getAttribute("reg_id");
		String ac_gender = (String) session.getAttribute("reg_gender");
		String ac_email = (String) session.getAttribute("reg_email");
		String ac_name = (String) session.getAttribute("reg_name");

		String ac_birthyear = (String) session.getAttribute("reg_birthyear");
		ac_birthyear = ac_birthyear.substring(2);
		String ac_birthday = (String) session.getAttribute("reg_birthday");
		ac_birthday = ac_birthday.replace("-", "");
		String ac_birth = ac_birthyear + ac_birthday;

		String ac_profile = (String) session.getAttribute("reg_profile");
		String ac_phone = (String) session.getAttribute("reg_phone");

		ac.setAc_id(ac_email);
		ac.setAc_gender(ac_gender);
		ac.setAc_pw(req.getParameter("ac_pw"));
		ac.setAc_name(ac_name);
		ac.setAc_birth(ac_birth);
		ac.setAc_phone(ac_phone);

		ac.setAc_postcode(req.getParameter("ac_postcode"));
		ac.setAc_address(req.getParameter("ac_address"));
		ac.setAc_detailAddress(req.getParameter("ac_detailAddress"));
		ac.setAc_extraAddress(req.getParameter("ac_extraAddress"));

		ac.setAc_gender(ac_gender);

		ac.setAc_file(ac_profile);

		req.setAttribute("accountInfo", ac);

		AccountMapper mm = ss.getMapper(AccountMapper.class);
		if (mm.accountRegDoIt(ac) == 1) {
			req.setAttribute("r", "등록 성공");
			req.getSession().setAttribute("loginAccount", ac);
		} else {
			req.setAttribute("r", "등록 실패");
		}

	}

	public void autoLogin(HttpServletRequest request) {
		// 자동 로그인 된 계정이 있을 경우 시작

		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("loginCookie")) {
					System.out.println("있음!!");
					AccountDTO aDTO = new AccountDTO();
					aDTO.setAc_sessionkey(c.getValue());
					aDTO = ss.getMapper(AccountMapper.class).getAccountByCookie(aDTO);
					request.getSession().setAttribute("loginAccount", aDTO);
					break;
				}
			}
		}

	}

//	public void deleteAccount(HttpServletRequest req, HttpSession session, AccountDTO ac) {
//		String ac_id = req.getParameter("this_id");
//		
//		AccountMapper mm = ss.getMapper(AccountMapper.class);
//		
//		if(mm.GoDeleteAccount(ac_id)==1) {
//			req.setAttribute("r", "탈퇴 성공");
//		} else {
//			req.setAttribute("r", "탈퇴 실패");
//		}
//		
//	}

}
