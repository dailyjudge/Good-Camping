package com.project.camping.account;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.nurigo.sdk.message.model.Message;

@Service
public class AccountDAO {
	@Autowired
	SqlSession ss;
	
	public void login(HttpServletRequest req, AccountDTO ac) {
		//post input
		String id2 = req.getParameter("ac_id");
		String pw2 = req.getParameter("ac_pw");
		String loginallways = null;
		loginallways = req.getParameter("loginallways");
		
		ac.setAc_id(id2);
		ac.setAc_pw(pw2);
		
		System.out.println(id2);
		System.out.println(pw2);
		System.out.println(loginallways);
		
		AccountDTO a2 = ss.getMapper(AccountMapper.class).getAccountById(ac);
		
		if(a2 != null) {
			if(ac.getAc_pw().equals(a2.getAc_pw())) {
				req.getSession().setAttribute("loginAccount", a2);
				if(loginallways.equals(null)) {
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
		String sr_id = req.getParameter("sr_id");
		String sr_birth = req.getParameter("sr_birth");
		
		
	
	}
}
	
