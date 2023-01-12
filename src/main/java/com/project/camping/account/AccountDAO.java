package com.project.camping.account;


import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountDAO {
	@Autowired
	SqlSession ss;

	public void login(HttpServletRequest request) {
		// 추후에 변경해야 함. 자동 로그인
		String ac_id = "test";
		String ac_pw = "1111";
		String ac_name = "민규";
		String ac_img = "aa.jpg";
		
		AccountDTO a = new AccountDTO(ac_id, ac_pw, ac_name, ac_img);
		
		request.getSession().setAttribute("loginAccount", a);
		request.getSession().setMaxInactiveInterval(60 * 10);
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
	
	
}
