package com.project.camping.stuff;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.camping.account.AccountDTO;

@Service
public class StuffDAO {

	@Autowired
	private SqlSession ss;

	List<StuffDTO> stuffs;

	public static StringBuilder sb;

	public void refreshStuffData() {
		// b13e5282f450344d8407d2f28c9f408e
		// 바비큐 랜턴 버너 숯 캠핑매트 캠핑테이블 캠핑의자 야전침대 캠핑코펠 핫팩 로프
		String[] items = { "랜턴", "바비큐", "버너", "핫팩", "캠핑의자", "캠핑테이블", "캠핑코펠", "숯", "캠핑매트", "야전침대", "로프" };

		// s_keyword 하나 만들기!
		// s_keyword
		for (int i = 0; i < items.length; i++) {

//		String str = "캠핑";
			String str = items[i];

			String url = "https://openapi.naver.com/v1/search/shop.json?query=";

			HttpURLConnection huc = null;
			int count = 0;

			try {
				// Fp8eOr3uZhrFffjvlRwM
				// 01R350IQhi
				url += URLEncoder.encode(str, "utf-8");
				url += "&display=100";

				System.out.println(url);

				URL u = new URL(url);

				huc = (HttpURLConnection) u.openConnection();
				huc.addRequestProperty("X-Naver-Client-Id", "Fp8eOr3uZhrFffjvlRwM");
				huc.addRequestProperty("X-Naver-Client-Secret", "01R350IQhi");
				InputStream is = huc.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				System.out.println(is);

				JSONParser jp = new JSONParser();
				JSONObject stuffData = (JSONObject) jp.parse(isr);
				// System.out.println(stuffData);

				JSONArray products = (JSONArray) stuffData.get("items");

				for (Object p : products) {
					JSONObject stuff = (JSONObject) p;

					StuffDTO s = new StuffDTO();
					s.setS_brand(stuff.get("brand").toString());
					s.setS_category(stuff.get("category3").toString());
					s.setS_productId(stuff.get("productId").toString());
					s.setS_image(stuff.get("image").toString());
					s.setS_detail_category(stuff.get("category4").toString());
					s.setS_title(stuff.get("title").toString());
					s.setS_price(stuff.get("lprice").toString());

					System.out.println(s.toString());
					if (ss.getMapper(StuffMapper.class).insertStuff(s) == 1) {
						System.out.println(++count + "번째 데이터 삽입 성공");
					} else {
						System.out.println("실패");
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void getAllStuff(StuffDTO s, HttpServletRequest req) {

		StuffMapper sm = ss.getMapper(StuffMapper.class);
		stuffs = sm.getAllStuff(s);

		for (StuffDTO stuffDTO : stuffs) {
			String title = stuffDTO.getS_title();
			title = title.replace("<b>", "");
			title = title.replace("</b>", "");

			stuffDTO.setS_title(title);
		}

		req.setAttribute("stuffs", stuffs);
	}

	public void StuffPaging(int sp, HttpServletRequest req) {

		int count = 12;
		int start = (sp - 1) * count + 1;
		int end = start + (count - 1);

		end = stuffs.size() < end ? stuffs.size() : end;

		List<StuffDTO> stuffs2 = new ArrayList<StuffDTO>();

		for (int i = start - 1; i < end; i++) {
			stuffs2.add(stuffs.get(i));

		}

		int stuffCount = (int) Math.ceil(stuffs.size() / (double) count);

		req.setAttribute("stuffCount", stuffCount);
		req.setAttribute("sp", sp);
		req.setAttribute("stuffs", stuffs2);

	}

	public void StuffDetail(StuffDTO s, HttpServletRequest req) {

		StuffMapper sm = ss.getMapper(StuffMapper.class);
		StuffDTO sDTO = sm.getDetailStuff(s);

		
		// 세분류가 있다면 . s_category에 세분류 값을 넣자!
//		if (!sDTO.getS_detail_category().equals("미제공")) {
//			sDTO.setS_category(sDTO.getS_detail_category());
//			req.setAttribute("stuffs", sDTO);
//		}else {
		
		String category = "";
		String targetCategory = sDTO.getS_category();
		String targetDetailCategory = sDTO.getS_detail_category();
		
		// 카테고리 세분류 정제
		if(targetCategory.equals("랜턴")) {
			category = "랜턴";
		} else if(targetDetailCategory.equals("미제공")) {
			category = "캠핑매트";
		} else {
			category = targetDetailCategory;
		}
		
		sDTO.setS_category(category);
		req.setAttribute("stuffs", sDTO);
		StuffSaleDTO saleDTO = new StuffSaleDTO();
		System.out.println("카테고리" + sDTO.getS_category());
		
		saleDTO.setSs_category(sDTO.getS_category());
		saleDTO.setSs_stuff_no(sDTO.getS_no());

		List<StuffSaleDTO> topItems = ss.getMapper(StuffMapper.class).getTopItems(saleDTO); // 조인해야함!!!!!!
		req.setAttribute("topItems", topItems);

//		}

	}

	public void StuffSearch(StuffSearchDTO sd, HttpServletRequest req) {

		StuffMapper sm = ss.getMapper(StuffMapper.class);
		stuffs = sm.getSearchStuff(sd);
		req.setAttribute("searchVal", sd.getStuffs());
		for (StuffDTO stuffDTO : stuffs) {
			String title = stuffDTO.getS_title();
			title = title.replace("<b>", "");
			title = title.replace("</b>", "");

			stuffDTO.setS_title(title);

//			stuffDTO.setS_title(stuffDTO.getS_title().replace("<b>", "").replace("</b>", ""));
		}

//		req.setAttribute("stuffs", stuffs);

	}

	public void getAllCart(HttpServletRequest req) {
		StuffMapper sm = ss.getMapper(StuffMapper.class);
		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");

		System.out.println(a.getAc_id());
		List<CartDTO> carts = sm.getALlCartstuff(a);
		
		int money = 0;

		for (CartDTO c : carts) {
			money += c.getSc_amount() * c.getS_price();
			
			c.setS_title(c.getS_title().replace("<b>", "").replace("</b>", ""));
		}
		
		req.setAttribute("money", money);
		req.setAttribute("carts", carts);

	}

	public int deleteCartItem(CartDTO c) {
		return ss.getMapper(StuffMapper.class).deleteCartItem(c);
	}

	public void getPaymentItem(HttpServletRequest req) {

		StuffMapper sm = ss.getMapper(StuffMapper.class);

		String items = req.getParameter("items");

		String itemNumbers[] = items.split(",");

		List<CartDTO> carts2 = new ArrayList<CartDTO>();

		for (String s : itemNumbers) {
			carts2.add(sm.getCartsPayment(s));
		}
		req.setAttribute("carts2", carts2);

	}

	public int insertCart(CartDTO c, HttpServletRequest req) {
		StuffMapper sm = ss.getMapper(StuffMapper.class);
		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
		// 첫번째. 상품이 ? 이면서 유저id가 ?인 Row가 있나요?
		c.setSc_user_id(a.getAc_id());

		// 0아니면 1
		if (ss.getMapper(StuffMapper.class).getCartCount(c) == 1) {
			// 두번째. 있다면 update (수량만 더해주기)

			return ss.getMapper(StuffMapper.class).updateCart(c);
		} else {
			// 세번째. 없다면 새로운 컬럼 추가.
			return ss.getMapper(StuffMapper.class).insertCart(c);
		}

	}

	public void goBuyNow(StuffDTO s, HttpServletRequest req) {

		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");

		CartDTO c = new CartDTO();
		// 이미지, 제목, 가격, 총량
		s.setS_no(Integer.parseInt(req.getParameter("items")));
		System.out.println(Integer.parseInt(req.getParameter("items")));
		StuffDTO sDTO = ss.getMapper(StuffMapper.class).getStuff(s);
		req.setAttribute("sDTO", sDTO);
		System.out.println("수량 값 받기 !!");
		
		
		if(req.getSession().getAttribute("amount") == null && req.getParameter("amount") != null) {
			req.getSession().setAttribute("amount", Integer.parseInt(req.getParameter("amount")));
		} 
		
		c.setSc_amount(Integer.parseInt(req.getSession().getAttribute("amount").toString()));
		c.setSc_stuff_no(sDTO.getS_no());
		c.setS_price(Integer.parseInt(sDTO.getS_price()));
		c.setS_title(sDTO.getS_title().replace("<b>", "").replace("</b>", ""));
		c.setS_image(sDTO.getS_image());

		List<CartDTO> carts = new ArrayList<CartDTO>();
		carts.add(c);

		req.setAttribute("carts2", carts);
	}

	/*
	 * public void orderPage(StuffOrderDTO soDTO, HttpServletRequest req) {
	 * 
	 * // soDTO : 주소 목록 3가지 + data(장바구니 no 리스트)
	 * 
	 * // Cart_no 리스트 String cartNumbers[] = soDTO.getSo_data().split(",");
	 * 
	 * // Cart 객체 가져오기. CartDTO cDTO; List<CartDTO> carts = new
	 * ArrayList<CartDTO>();
	 * 
	 * for (int i = 0; i < cartNumbers.length; i++) { cDTO = new CartDTO();
	 * 
	 * int cart_id = Integer.parseInt(cartNumbers[i]); cDTO.setSc_cart_id(cart_id);
	 * 
	 * // 실제 Cart 객체 CartDTO targetDTO =
	 * ss.getMapper(StuffMapper.class).getOrderItem(cDTO);
	 * targetDTO.setSc_cart_id(cart_id); carts.add(targetDTO); }
	 * 
	 * AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
	 * System.out.println("================="); System.out.println(a.getAc_id()); if
	 * (a != null) { System.out.println("로그인 확인");
	 * soDTO.setSo_user_id(a.getAc_id());
	 * 
	 * // 주문 테이블에 주문 데이터 넣기 if
	 * (ss.getMapper(StuffMapper.class).insertOrderStuff(soDTO) == 1) {
	 * System.out.println("주문 테이블에 주문 데이터 넣기 성공!");
	 * 
	 * // 주문 번호 가져오기 // userId + date desc 방식 List<StuffOrderDTO> userOrders =
	 * ss.getMapper(StuffMapper.class).getOrderNum(a); int OrderNum =
	 * userOrders.get(0).getSo_no();
	 * 
	 * // 주문 상품 테이블에 상품 정보 넣고, 장바구니에 해당 상품 지우기 // 여기에서 총 결제 금액 생각하자. int totalMoney
	 * = 0; for (int i = 0; i < carts.size(); i++) { CartDTO ctDto = carts.get(i);
	 * ctDto.setOrder_no(OrderNum);
	 * 
	 * // 총 결제 금액 처리 totalMoney += ctDto.getS_price() * ctDto.getSc_amount();
	 * 
	 * // <b>태그 정제 ctDto.setS_title(ctDto.getS_title().replace("<b>",
	 * "").replace("</b>", ""));
	 * 
	 * if (ss.getMapper(StuffMapper.class).insertOrderList(ctDto) == 1) {
	 * System.out.println(i + 1 + "번 째 주문 상품 삽입 완료"); } else { System.out.println(i
	 * + 1 + "번 째 주문 상품 삽입 실패"); break; }
	 * 
	 * if (ss.getMapper(StuffMapper.class).deleteCart(ctDto) == 1) {
	 * System.out.println(i + 1 + "번 상품 장바구니 삭제 완료"); } else { System.out.println(i
	 * + 1 + "번 상품 장바구니 삭제 실패");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * // 주문 상품 테이블 삽입 + 장바구니 내용 삭제가 완료.
	 * 
	 * // 보내줘야할 거. // 상품 no, 상품 이름, 상품 사진, 상품 가격, 상품 개수 cartDTO (리스트) // 총 결제 금액
	 * (계산해서 보내주기) // 주문 번호 // 주문 시각 // 주소 3종 // 즉 - cartDTO List + 총 결제 금액 +
	 * StuffOrderDTO 1개
	 * 
	 * // cartDTO List -> carts for (CartDTO c : carts) {
	 * System.out.println(c.toString()); } req.setAttribute("carts", carts); //
	 * StuffOrderDTO -> 주문 내역 리스트(userOrders) 중 가장 첫 번째 값 // 날짜 정제가 필요한걸 꺠달음
	 * req.setAttribute("userOrder", userOrders.get(0)); // 총 결제 금액 (for문 이용해서 각각의
	 * 값을 계산해주자) // for문에서 이미 처리 !! (totalMoney) SimpleDateFormat timeFormat = new
	 * SimpleDateFormat("yyyy.MM.dd a H:mm:ss", Locale.KOREA); String formattedDate
	 * = timeFormat.format(userOrders.get(0).getSo_date());
	 * 
	 * req.setAttribute("formattedDate", formattedDate);
	 * req.setAttribute("totalMoney", totalMoney); } else {
	 * System.out.println("주문 테이블에 주문 데이터 넣기 실패!"); }
	 * 
	 * } }
	 */
	public String kakaoPopup(StuffOrderDTO soDTO, HttpServletRequest req) {
		try {
			AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
			
			// 유저의 주소를 session으로
			System.out.println("카카오페이 팝업 이전!!");
			System.out.println(soDTO.toString());

			if (a != null) {
				req.getSession().setAttribute("addr", soDTO);
				System.out.println("세선 설정 완료 !!");
			}
			
			URL address;
			address = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection conn = (HttpURLConnection) address.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "KakaoAK 9f00a6c37ca4dae0706159881b447cec");
			conn.setDoOutput(true);
			// 보내줘야할것
			// 상품이름,사용자 아이디, 상품 갯수, 총 결제 금액, 승인 url, 취소 url, 실패 url
			
			String stuffname = ""; // 상품이름
			String itemName = ""; // 결제창에 보일 이름
			int totalprice = 0; // 총액
			
			int stuffamount = req.getSession().getAttribute("amount") == null ? 1 : Integer.parseInt(req.getSession().getAttribute("amount").toString()); // 상품개수
			String userid = ""; // 사용자 id
			
			String item = req.getParameter("items");
			System.out.println("items : " + item);
			req.getSession().setAttribute("cartNumbers", item);
			// ,
			if (item.contains(",")) {
				// 장바구니
				String cartNumbers[] = item.split(",");

				CartDTO cDTO;

				for (int i = 0; i < cartNumbers.length; i++) {
					cDTO = new CartDTO();

					int cart_id = Integer.parseInt(cartNumbers[i]);
					cDTO.setSc_cart_id(cart_id);

					// 실제 Cart 객체
					CartDTO targetDTO = ss.getMapper(StuffMapper.class).getOrderItem(cDTO);

					totalprice += targetDTO.getS_price() * targetDTO.getSc_amount();
					stuffamount += targetDTO.getSc_amount();

					if (i == 0) {
						targetDTO.setS_title(targetDTO.getS_title().replace("<b>", "").replace("</b>", ""));
						itemName = targetDTO.getS_title();
					}

				}
				
				if ((cartNumbers.length - 1) > 0) {
					itemName += " 외 " + (cartNumbers.length - 1) + "개";
				}

			} else {
				// 바로구매
				StuffDTO s = new StuffDTO();
				s.setS_no(Integer.parseInt(item));
				
				goBuyNow(s, req);
				
				StuffDTO sDTO = (StuffDTO) req.getAttribute("sDTO");
				itemName = sDTO.getS_title().replace("<b>", "").replace("</b>", "");
				totalprice = Integer.parseInt(sDTO.getS_price());
				stuffamount = 1;
			}

			itemName = URLEncoder.encode(itemName, "utf-8");

			PaymentDTO paymentDTO = new PaymentDTO("TC0ONETIME", "partner_order_id", a.getAc_id(), itemName,
					String.valueOf(stuffamount), String.valueOf(totalprice), "0",
					"http://localhost:8080/camping/go.stuff.buy.popup",
					"http://localhost:8080/camping/go.stuff.payment.popup",
					"http://localhost:8080/camping/go.stuff.payment.popup");

			OutputStream send = conn.getOutputStream();
			DataOutputStream dataSend = new DataOutputStream(send);
			dataSend.writeBytes(paymentDTO.toString());
			dataSend.close();
			int result = conn.getResponseCode();
			InputStream receive;
			if (result == 200) {
				req.getSession().setAttribute("paymentDTO", paymentDTO);
				receive = conn.getInputStream();
				// System.out.println(receive);
			} else {
				receive = conn.getErrorStream();
				// System.out.println(receive);
			}
			InputStreamReader read = new InputStreamReader(receive);
			BufferedReader change = new BufferedReader(read);
			String jsonData = change.readLine();
			// System.out.println(jsonData);
			req.getSession().setAttribute("jsonData", jsonData);
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(jsonData);
			req.getSession().setAttribute("partner_user_id", a.getAc_id());
			req.getSession().setAttribute("tid", jo.get("tid"));
//				"cid=TC0ONETIME" \
//				--data-urlencode "tid=T1234567890123456789" \
//				--data-urlencode "partner_order_id=partner_order_id" \
//				--data-urlencode "partner_user_id=partner_user_id" \
//				--data-urlencode "pg_token=xxxxxxxxxxxxxxxxxxxx"

			return jsonData;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	public String kakaoPayReady(StuffOrderDTO soDTO, HttpServletRequest req) {
		try {
			AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
			URL address;
			address = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection conn = (HttpURLConnection) address.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "KakaoAK 9f00a6c37ca4dae0706159881b447cec");
			conn.setDoOutput(true);
			// 보내줘야할것
			// 상품이름,사용자 아이디, 상품 갯수, 총 결제 금액, 승인 url, 취소 url, 실패 url

			String stuffname = ""; // 상품이름
			String itemName = ""; // 결제창에 보일 이름
			int totalprice = 0; // 총액
			int stuffamount = 1; // 상품개수
			String userid = ""; // 사용자 id

			String cartNumbers[] = req.getParameter("items").split(",");
			req.getSession().setAttribute("cartNumbers", req.getParameter("items"));
			CartDTO cDTO;

			for (int i = 0; i < cartNumbers.length; i++) {
				cDTO = new CartDTO();

				int cart_id = Integer.parseInt(cartNumbers[i]);
				cDTO.setSc_cart_id(cart_id);
				// 실제 Cart 객체
				CartDTO targetDTO = ss.getMapper(StuffMapper.class).getOrderItem(cDTO);

				totalprice += targetDTO.getS_price() * targetDTO.getSc_amount();
				stuffamount += targetDTO.getSc_amount();

				if (i == 0) {

					itemName = targetDTO.getS_title().replace("<b>", "").replace("</b>", "");

				}

			}
			if ((cartNumbers.length - 1) > 0) {
				itemName += " 외 " + (cartNumbers.length - 1) + "개";

			}

			itemName = URLEncoder.encode(itemName, "utf-8");

			PaymentDTO paymentDTO = new PaymentDTO("TC0ONETIME", "partner_order_id", a.getAc_id(), itemName,
					String.valueOf(stuffamount), String.valueOf(totalprice), "0",
					"http://localhost:8080/camping/go.stuff.buy", "http://localhost:8080/camping/go.stuff.payment",
					"http://localhost:8080/camping/go.stuff.payment");
			System.out.println(a.getAc_id());
			// System.out.println(paymentDTO.toString());

			OutputStream send = conn.getOutputStream();
			DataOutputStream dataSend = new DataOutputStream(send);
			dataSend.writeBytes(paymentDTO.toString());
			dataSend.close();
			int result = conn.getResponseCode();
			InputStream receive;
			if (result == 200) {
				receive = conn.getInputStream();
				req.getSession().setAttribute("paymentDTO", paymentDTO);
				// System.out.println(receive);
			} else {
				receive = conn.getErrorStream();
				// System.out.println(receive);
			}
			InputStreamReader read = new InputStreamReader(receive);
			BufferedReader change = new BufferedReader(read);

			String jsonData = change.readLine();
			System.out.println(jsonData);
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(jsonData);
			req.getSession().setAttribute("jsonData", jsonData);
			req.getSession().setAttribute("partner_user_id", a.getAc_id());
			req.getSession().setAttribute("tid", jo.get("tid"));
			String redirectUrl = (String) jo.get("next_redirect_pc_url");
			dataSend.writeBytes(paymentDTO.toString());
			return redirectUrl;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public void kakaoPay2(StuffDTO s2, HttpServletRequest req) {
		try {
			System.out.println("레디 지나고 접근 !!");
			// 아이템들 안받았따.
			String tid = (String) req.getSession().getAttribute("tid");
			String pg_token = req.getParameter("pg_token");
			System.out.println(tid);
			System.out.println(pg_token);
			URL address;
			address = new URL("https://kapi.kakao.com/v1/payment/approve");
			HttpURLConnection conn = (HttpURLConnection) address.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "KakaoAK 9f00a6c37ca4dae0706159881b447cec");
			conn.setDoOutput(true);

			String jsonData = (String) req.getSession().getAttribute("jsonData");
			System.out.println("넘겨받은 jsonData : " + jsonData);
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(jsonData);
			String params = "cid=TC0ONETIME&tid=" + tid + "&partner_order_id=partner_order_id" + "&partner_user_id="
					+ req.getSession().getAttribute("partner_user_id") + "&pg_token=" + pg_token;
			System.out.println("==============");
			System.out.println(params);
			OutputStream send = conn.getOutputStream();
			DataOutputStream dataSend = new DataOutputStream(send);
			dataSend.writeBytes(params);
			dataSend.flush();
			dataSend.close();

			// 결제가 승인 됐다는거
			if (conn.getResponseCode() == 200) {

				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				JSONParser jp2 = new JSONParser();
				JSONObject jo2 = (JSONObject) jp2.parse(isr);
				System.out.println(jo2);

				System.out.println("카카오페이 로직 종료");
				// 결제 승인 됐으니 넘겼었던 100,200 번 상품들 주문 완료 테이블에 인서트 하고
				// 주문 완료 페이지에서 써야되니까 바로 그거 다 꺼내서 list에 담기
				String num = (String) req.getSession().getAttribute("cartNumbers");
				System.out.println("장바구니 내역 확인!!");
				System.out.println("num : " + num);

				AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");

				if (num != null) {
					String cartNumbers[];

					CartDTO cDTO;
					List<CartDTO> carts = new ArrayList<CartDTO>();

					// Cart_no 리스트
					if (num.indexOf(",") == -1) {
						cartNumbers = new String[1];
						cartNumbers[0] = num;

						StuffDTO s = new StuffDTO();
						s.setS_no(Integer.parseInt(num));

						s = ss.getMapper(StuffMapper.class).getDetailStuff(s);
						
						cDTO = new CartDTO();
						cDTO.setSc_stuff_no(s.getS_no());
						cDTO.setSc_user_id(a.getAc_id());
						
						cDTO.setSc_amount(Integer.parseInt(req.getSession().getAttribute("amount").toString()));
						
						cDTO.setS_title(s.getS_title());
						cDTO.setS_image(s.getS_image());
						cDTO.setS_price(Integer.parseInt(s.getS_price()));

						carts.add(cDTO);
						
						System.out.println("리스트에 삽입 단계");
						System.out.println(carts.get(0).toString());
					} else {
						cartNumbers = num.split(",");

						for (int i = 0; i < cartNumbers.length; i++) {
							cDTO = new CartDTO();

							int cart_id = Integer.parseInt(cartNumbers[i]);
							cDTO.setSc_cart_id(cart_id);

							CartDTO targetDTO = ss.getMapper(StuffMapper.class).getOrderItem(cDTO);
							targetDTO.setSc_cart_id(cart_id);
							carts.add(targetDTO);
						}
					}

					StuffOrderDTO soDTO = (StuffOrderDTO) req.getSession().getAttribute("addr");

					soDTO.setSo_user_id(a.getAc_id());

					if (ss.getMapper(StuffMapper.class).insertOrderStuff(soDTO) == 1) {
						// 주문 번호 가져오기
						// userId + date desc 방식
						List<StuffOrderDTO> userOrders = ss.getMapper(StuffMapper.class).getOrderNum(a);
						int OrderNum = userOrders.get(0).getSo_no();
						System.out.println("해당 주문 테이블 주문 번호 :  " + OrderNum);

						// 주문 상품 테이블에 상품 정보 넣고, 장바구니에 해당 상품 지우기
						// 여기에서 총 결제 금액 생각하자.
						
						System.out.println("개수가 1개일 때 --> 크기 : " + carts.size());
						System.out.println(carts.get(0).toString());
						
						for (int i = 0; i < carts.size(); i++) {
							CartDTO ctDto = carts.get(i);
							ctDto.setOrder_no(OrderNum);

							// <b>태그 정제
							ctDto.setS_title(ctDto.getS_title().replace("<b>", "").replace("</b>", ""));

							if (ss.getMapper(StuffMapper.class).insertOrderList(ctDto) == 1) {
								System.out.println(i + 1 + "번  주문 상품 삽입 완료");
								// 판매량 디비 접근!!

								// pk, 상품 번호, 카테고리 이름, 판매량

								StuffSaleDTO saleDTO = new StuffSaleDTO();
								
								System.out.println("상품번호 : " + ctDto.getSc_stuff_no());
								System.out.println("개수 : " + ctDto.getSc_amount());
								
								StuffDTO s = new StuffDTO();
								s.setS_no(ctDto.getSc_stuff_no());
								
								s = ss.getMapper(StuffMapper.class).getDetailStuff(s);
								System.out.println("카테고리" + s.getS_category());
								
								
								String targetCategory = s.getS_category();
								String targetDetailCategory = s.getS_detail_category();
								
								String category = "";
								
								// 카테고리 세분류 정제
								if(targetCategory.equals("랜턴")) {
									category = "랜턴";
								} else if(targetDetailCategory.equals("미제공")) {
									category = "캠핑매트";
								} else {
									category = targetDetailCategory;
								}
								
								saleDTO.setSs_category(category);
								saleDTO.setSs_stuff_no(ctDto.getSc_stuff_no());
								saleDTO.setSs_count(ctDto.getSc_amount());

								// 0아니면 1
								if (ss.getMapper(StuffMapper.class).getSalesitem(saleDTO) == 1) {
									System.out.println("수량 올려주기!");
									// 두번째. 있다면 update (수량만 더해주기)
									if (ss.getMapper(StuffMapper.class).updateSalesitem(saleDTO) == 1) {
										System.out.println("업데이트 성공");
									} else {
										System.out.println("업데이트 실패");
									}
								} else {
									// 세번째. 없다면 새로운 컬럼 추가.
									if (ss.getMapper(StuffMapper.class).insertSales(saleDTO) == 1) {
										System.out.println("상품 판매량 입력 성공");
									} else {
										System.out.println("상품 판매량 입력 실패");

									}
								}
								
								
								if (num.indexOf(",") != -1) {
									if (ss.getMapper(StuffMapper.class).deleteCart(ctDto) == 1) {
										System.out.println(i + 1 + "번 상품 장바구니 삭제 완료");
									} else {
										System.out.println(i + 1 + "번 상품 장바구니 삭제 실패");
									}
								}
							}

							SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy.MM.dd a H:mm:ss", Locale.KOREA);
							String formattedDate = timeFormat.format(userOrders.get(0).getSo_date());

							req.setAttribute("carts", carts);
							req.getSession().setAttribute("userOrder", userOrders.get(0));

							req.getSession().setAttribute("formattedDate", formattedDate);
							
						}

						// nums = 장바구니의 pk 목록들
						// 주문 테이블에 있는 전반적인 row 하나, stuff (list)
						// 장바구니에 내용들을 지워주고, 주문 테이블에 넣어주고, 주문 상품 테이블에 넣어주고
						// 주문 상품 : pk, 주문 테이블no, 상품 id, 상품 개수
						// 장바구니 : 기본키, user id, 상품 no, 상품 수량
						// 주문 : 기본키, user id, 주소1, 주소2, 주소3, 주문 시각

					}
				}
				System.out.println("---------------------------");

				JSONObject amount = (JSONObject) jo2.get("amount");
				String total = amount.get("total").toString();

				req.getSession().setAttribute("total", total);

			} else {
				req.getSession().setAttribute("cartNumbers", null);
			}
			
			req.getSession().removeAttribute("amount");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void paymentconfirm(String kakaoPayReady) {
		System.out.println("*************");
		System.out.println(kakaoPayReady);

	}
	
	public void showAllUserOrderList(HttpServletRequest request) {
		
		AccountDTO a = (AccountDTO) request.getSession().getAttribute("loginAccount");
		
		if(a != null) {
			
			// Attribute로 실을 리스트
			List<StuffUserOrderDTO> userOrders = new ArrayList<StuffUserOrderDTO>();
			
			// 해당 유저가 주문한 내역을 먼저 가져오기. (주문 테이블에만 접근)
			List<StuffOrderDTO> orders = ss.getMapper(StuffMapper.class).getUserOrderList(a);
			
			System.out.println("주문번호 출력");
			for (StuffOrderDTO stuffOrderDTO : orders) {
				System.out.print(stuffOrderDTO.getSo_no() + " ");
			}
			System.out.println();
			
			// 주문 번호에 해당하는 품목 전부를 가져와서 리스트화.
			for(int i = 0; i < orders.size(); i++) {
				// 주문 번호 1개
				StuffOrderDTO order = orders.get(i);
				System.out.println(order.getSo_no() +"번 주문 조회 결과");
				// 주문 번호에 해당하는 상품 리스트
				List<StuffUserOrderDTO> orderItems = ss.getMapper(StuffMapper.class).getOrderItems(order);
				System.out.println(orderItems.size() + "개 조회 완료");
				// 주문 번호, 상품 번호, 상품 이미지, 상품 제목, 상품 가격, 상품 수량, 주소, 주문 시각
				
				
				// 실질적으로 실을 데이터
				StuffUserOrderDTO suo = new StuffUserOrderDTO();
				// 필요한 내용
				// 키 설정
				suo.setSo_no(orderItems.get(0).getSo_no());
				// 1. 이미지
				// 첫번째 이미지 사용
				suo.setS_image(orderItems.get(0).getS_image());
				// 2. 이름 : ~ 외 ~ 개
				// 1개일 때? 그 이상일 떄?
				String title = orderItems.get(0).getS_title().replace("<b>", "").replace("</b>", "");
				suo.setS_title(orderItems.size() == 1 ? title : title + "외 " + (orderItems.size() - 1) + "개");
				
				// 3. 가격
				int total = 0;
				
				for (StuffUserOrderDTO suoDTO : orderItems) total += suoDTO.getS_price() * suoDTO.getSoi_sc_amount();
				suo.setS_price(total);
				
				// 4. 주소
				suo.setSo_user_zoncode(orderItems.get(0).getSo_user_zoncode());
				suo.setSo_user_addr(orderItems.get(0).getSo_user_addr());
				suo.setSo_user_detailAddr(orderItems.get(0).getSo_user_detailAddr());
				// 5. 주문 시각
				suo.setSo_date(orderItems.get(0).getSo_date());
				userOrders.add(suo);
			}
			
			request.setAttribute("orders", userOrders);
		}
	}
}