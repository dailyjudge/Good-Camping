package com.project.camping.stuff;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.camping.account.AccountDAO;

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
		
		req.setAttribute("Click", 2);
		sDAO.getAllCart(req);
		
		aDAO.loginCheck(req);
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
	
	
	@RequestMapping(value = "/go.stuff.payment", method = RequestMethod.GET)
	public String goStuffPayment(HttpServletRequest req) {
		
		
		sDAO.getPaymentItem(req);

		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "camping-stuff/camping-stuff-payment.jsp");
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/kakao.ready.popup", method = RequestMethod.POST, produces="application/json")
	public String goKakaopayBuy(StuffOrderDTO soDTO, HttpServletRequest req) {
		return sDAO.kakaoPopup(soDTO,req);
	}

	@RequestMapping(value = "/go.stuff.buy.popup", method = RequestMethod.GET)
	public String goStuffBuyPopup(StuffOrderDTO soDTO, HttpServletRequest req) {
		//sDAO.kakaoPay2(req);
		return "camping-stuff/kakaoSuccess";
	}

	@RequestMapping(value = "/do.stuff.buy.popup", method = RequestMethod.GET)
	public String doStuffBuyPopup(StuffOrderDTO soDTO, HttpServletRequest req) {
		sDAO.kakaoPay2(req);
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "camping-stuff/camping-stuff-order.jsp");
		return "index";
	}
	
	
	
	
	@RequestMapping(value = "go.kakao.ready", method = RequestMethod.POST, produces="application/json")
	public String goKakaopayReady(StuffOrderDTO soDTO, HttpServletRequest req) {
//		sDAO.paymentconfirm(sDAO.kakaoPayReady(soDTO,req));
		return "redirect:"+sDAO.kakaoPayReady(soDTO,req);
	}
	
	
	
	@RequestMapping(value = "/go.stuff.buy", method = RequestMethod.GET)
	public String goBuyNow(StuffOrderDTO soDTO, HttpServletRequest req) {
		
//		sDAO.orderPage(soDTO, req);
		aDAO.loginCheck(req);
		sDAO.kakaoPay2(req);
		req.setAttribute("contentPage", "camping-stuff/camping-stuff-order.jsp");
		
		return "index";
	}
	
	
	
	
	
}
