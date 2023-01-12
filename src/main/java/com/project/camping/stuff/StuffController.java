package com.project.camping.stuff;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.camping.account.AccountDAO;
import com.project.camping.account.AccountDTO;

@Controller
public class StuffController {

	@Autowired
	private StuffDAO sDAO;

	@Autowired
	private AccountDAO aDAO;

	@RequestMapping(value = "/do.refresh.stuffData", method = RequestMethod.GET)
	public String refreshStuffData(HttpServletRequest request) {

		sDAO.refreshStuffData();

		return "test";
	}

	@RequestMapping(value = "/go.camping.shop", method = RequestMethod.GET)
	public String getAllStuffData(StuffDTO s, HttpServletRequest request) {

		sDAO.getAllStuff(s, request);
		sDAO.StuffPaging(1, request);

		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-stuff/camping-stuff.jsp");

		return "index";
	}

	@RequestMapping(value = "/do.stuff.change", method = RequestMethod.GET)
	public String pagingStuffData(HttpServletRequest request) {

		int sp = Integer.parseInt(request.getParameter("sp"));

		sDAO.StuffPaging(sp, request);

		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-stuff/camping-stuff.jsp");

		return "index";
	}

	@RequestMapping(value = "/go.stuff.detail", method = RequestMethod.GET)
	public String stuffDetail(StuffDTO s, HttpServletRequest request) {

		sDAO.StuffDetail(s, request);

		aDAO.loginCheck(request);
		request.setAttribute("contentPage", "camping-stuff/camping-stuff-detail.jsp");

		return "index";
	}

	@RequestMapping(value = "/go.stuff.search", method = RequestMethod.GET)
	public String stuffSearch(StuffSearchDTO sd, StuffDTO s, HttpServletRequest req) {

		sDAO.StuffSearch(sd, req);
		sDAO.StuffPaging(1, req);
		req.setAttribute("loginPage", "account/login.jsp");
		req.setAttribute("contentPage", "camping-stuff/camping-stuff.jsp");
		return "index";
	}

	@RequestMapping(value = "/go.stuff.cart", method = RequestMethod.GET)
	public String stuffCart(HttpServletRequest req) {

		sDAO.getAllCart(req);
		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");

		if (a == null) {
			req.setAttribute("loginPage", "account/login.jsp");
		} else {
			req.setAttribute("loginPage", "account/login_done.jsp");
		}
		req.setAttribute("contentPage", "camping-stuff/camping-stuff-cart.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/do.delete.stuff.cart", method = RequestMethod.GET)
	@ResponseBody
	public int deleteCartItem(CartDTO c, HttpServletRequest req) {
		return sDAO.deleteCartItem(c);
	}
	@RequestMapping(value = "/do.insert.cart", method = RequestMethod.GET)
	@ResponseBody
	public int insertCart(StuffDTO s, HttpServletRequest req) {
		return sDAO.insertCart(s,req);
	}
	
	@RequestMapping(value = "/go.buynow", method = RequestMethod.GET)
	public String goBuyNow(StuffDTO s, HttpServletRequest req) {
		sDAO.goBuyNow(s, req);
		aDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "camping-stuff/camping-stuff-payment.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/go.stuff.buy", method = RequestMethod.POST)
	public String goBuyNow(StuffOrderDTO soDTO, HttpServletRequest req) {
		
		sDAO.orderPage(soDTO, req);
		aDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "camping-stuff/camping-stuff-order.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "/go.stuff.payment", method = RequestMethod.GET)
	public String goStuffPayment(HttpServletRequest req) {
		
		
		sDAO.getPaymentItem(req);
//		System.out.println("들어옴!!");
//		System.out.println("a: " + aa);
		
//		String arr[] = aa.split(",");
		
//		System.out.println(arr.length);
		
//		System.out.println("내용들 뽑아보기");
//		for (String s : arr) {
//			// DB찌르기
//		}
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "camping-stuff/camping-stuff-payment.jsp");
		return "index";
	}
}
