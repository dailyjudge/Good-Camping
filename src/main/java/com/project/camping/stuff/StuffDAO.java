package com.project.camping.stuff;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.SessionScope;

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

		// <b></b> 이게 싫음 => 없애자
		// replace
		// <b>글자가 들어가있음</b>

		for (StuffDTO stuffDTO : stuffs) {
			String title = stuffDTO.getS_title();
			title = title.replace("<b>", "");
			title = title.replace("</b>", "");

			stuffDTO.setS_title(title);

//			stuffDTO.setS_title(stuffDTO.getS_title().replace("<b>", "").replace("</b>", ""));
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
		if (!sDTO.getS_detail_category().equals("미제공"))
			sDTO.setS_category(sDTO.getS_detail_category());

		req.setAttribute("stuffs", sDTO);
	}

	public void StuffSearch(StuffSearchDTO sd, HttpServletRequest req) {

		StuffMapper sm = ss.getMapper(StuffMapper.class);
		stuffs = sm.getSearchStuff(sd);

		for (StuffDTO stuffDTO : stuffs) {
			String title = stuffDTO.getS_title();
			title = title.replace("<b>", "");
			title = title.replace("</b>", "");

			stuffDTO.setS_title(title);

//			stuffDTO.setS_title(stuffDTO.getS_title().replace("<b>", "").replace("</b>", ""));
		}

		req.setAttribute("stuffs", stuffs);

	}

	public void getAllCart(HttpServletRequest req) {
		StuffMapper sm = ss.getMapper(StuffMapper.class);
		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
		System.out.println(a.getAc_id());
		List<CartDTO> carts = sm.getALlCartstuff(a);

		int money = 0;

		for (CartDTO c : carts) {
			money += c.getSc_amount() * c.getS_price();
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

	public int insertCart(StuffDTO s, HttpServletRequest req) {

		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
		// cartDTO!!
		CartDTO c = new CartDTO();
		c.setSc_amount(1);
		c.setSc_stuff_no(s.getS_no());
		c.setSc_user_id(a.getAc_id());
		return ss.getMapper(StuffMapper.class).insertCart(c);
	}

	public void goBuyNow(StuffDTO s, HttpServletRequest req) {

		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");

		CartDTO c = new CartDTO();
		// 이미지, 제목, 가격, 총량

		StuffDTO sDTO = ss.getMapper(StuffMapper.class).getStuff(s);

		c.setSc_amount(1);
		c.setSc_stuff_no(sDTO.getS_no());
		c.setS_price(Integer.parseInt(sDTO.getS_price()));
		c.setS_title(sDTO.getS_title());
		c.setS_image(sDTO.getS_image());

		List<CartDTO> carts = new ArrayList<CartDTO>();
		carts.add(c);

		req.setAttribute("carts2", carts);
	}

	public void orderPage(StuffOrderDTO soDTO, HttpServletRequest req) {

		// soDTO : 주소 목록 3가지 + data(장바구니 no 리스트)

		// Cart_no 리스트
		String cartNumbers[] = soDTO.getSo_data().split(",");
		
		// Cart 객체 가져오기.
		CartDTO cDTO;
		List<CartDTO> carts = new ArrayList<CartDTO>();
		
		for (int i = 0; i < cartNumbers.length; i++) {
			cDTO = new CartDTO();

			int cart_id = Integer.parseInt(cartNumbers[i]);
			cDTO.setSc_cart_id(cart_id);

			// 실제 Cart 객체
			CartDTO targetDTO = ss.getMapper(StuffMapper.class).getOrderItem(cDTO);
			targetDTO.setSc_cart_id(cart_id);
			carts.add(targetDTO);
		}

		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
		System.out.println("=================");
		System.out.println(a.getAc_id());
		if (a != null) {
			System.out.println("로그인 확인");
			soDTO.setSo_user_id(a.getAc_id());

			// 주문 테이블에 주문 데이터 넣기
			if (ss.getMapper(StuffMapper.class).insertOrderStuff(soDTO) == 1) {
				System.out.println("주문 테이블에 주문 데이터 넣기 성공!");

				// 주문 번호 가져오기
				// userId + date desc 방식
				List<StuffOrderDTO> userOrders = ss.getMapper(StuffMapper.class).getOrderNum(a);
				int OrderNum = userOrders.get(0).getSo_no();

				// 주문 상품 테이블에 상품 정보 넣고, 장바구니에 해당 상품 지우기
				// 여기에서 총 결제 금액 생각하자.
				int totalMoney = 0;
				for (int i = 0; i < carts.size(); i++) {
					CartDTO ctDto = carts.get(i);
					ctDto.setOrder_no(OrderNum);
					
					// 총 결제 금액 처리
					totalMoney += ctDto.getS_price() * ctDto.getSc_amount();
					
					// <b>태그 정제
					ctDto.setS_title(ctDto.getS_title().replace("<b>", "").replace("</b>", ""));
					
					if (ss.getMapper(StuffMapper.class).insertOrderList(ctDto) == 1) {
						System.out.println(i + 1 + "번 째 주문 상품 삽입 완료");
					} else {
						System.out.println(i + 1 + "번 째 주문 상품 삽입 실패");
						break;
					}

					if(ss.getMapper(StuffMapper.class).deleteCart(ctDto) == 1) {
						System.out.println(i + 1 + "번 상품 장바구니 삭제 완료");
					} else {
						System.out.println(i + 1 + "번 상품 장바구니 삭제 실패");
						
					}

				}
				
				// 주문 상품 테이블 삽입 + 장바구니 내용 삭제가 완료.
				
				// 보내줘야할 거.
				// 상품 no, 상품 이름, 상품 사진, 상품 가격, 상품 개수 cartDTO (리스트)
				// 총 결제 금액 (계산해서 보내주기)
				// 주문 번호 
				// 주문 시각
				// 주소 3종
				// 즉 - cartDTO List + 총 결제 금액 + StuffOrderDTO 1개
				
				// cartDTO List -> carts
				for (CartDTO c : carts) {
					System.out.println(c.toString());
				}
				req.setAttribute("carts", carts);
				// StuffOrderDTO -> 주문 내역 리스트(userOrders) 중 가장 첫 번째 값
				// 날짜 정제가 필요한걸 꺠달음
				req.setAttribute("userOrder", userOrders.get(0));
				// 총 결제 금액 (for문 이용해서 각각의 값을 계산해주자)
				// for문에서 이미 처리 !! (totalMoney)
				SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy.MM.dd a H:mm:ss", Locale.KOREA);
				String formattedDate = timeFormat.format(userOrders.get(0).getSo_date());
				
				req.setAttribute("formattedDate", formattedDate);
				req.setAttribute("totalMoney", totalMoney);
			} else {
				System.out.println("주문 테이블에 주문 데이터 넣기 실패!");
			}
			
			
		}
	}

}
