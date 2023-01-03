package com.project.camping.stuff;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuffDAO {

	@Autowired
	private SqlSession ss;

	List<StuffDTO> stuffs;

	public static StringBuilder sb;

	public void refreshStuffData() {
		// b13e5282f450344d8407d2f28c9f408e

		String[] items = { "랜턴", "바비큐", "버너", "소화기", "핫팩", "캠핑의자", "야전침대", "로프" };

		for (int i = 0; i < items.length; i++) {

//		String str = "캠핑";
			String str = items[i];

			String url = "https://openapi.naver.com/v1/search/shop.json?query=";
			int start = 1;

			HttpURLConnection huc = null;
			int count = 0;

			try {
				// Fp8eOr3uZhrFffjvlRwM
				// 01R350IQhi

				for (int j = 0; j < 10; i++) {

					url += URLEncoder.encode(str, "utf-8");
					url += "&display=100&start=" + start;

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

					start += 100;
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

		System.out.println("111");
		List<StuffDTO> stuffs2 = new ArrayList<StuffDTO>();
		System.out.println("222");

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
		req.setAttribute("stuffs", sm.getDetailStuff(s));
	}

}
