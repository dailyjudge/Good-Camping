package com.project.camping.bulletinB;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.camping.account.AccountDTO;
import com.project.camping.account.AccountMapper;


@Service
public class BulletinDAO {
	@Autowired
	SqlSession ss;
	
	List<ComuDTO> comus;
	//신규 글 작성
	public void uploadBoard(HttpServletRequest request) {
		
	}
	
	//지역 선택
	public int getSearch_where(HttpServletRequest request, ComuDTO comu) {
		String comu_groupid = (String) request.getAttribute("comu_groupid");
//		comu.setComu_groupid(comu_groupid);
		
		BulletinMapper mm = ss.getMapper(BulletinMapper.class);
		ComuDTO vo = mm.selectAllWhere(comu_groupid);
		request.setAttribute("Comu", vo);
		
		
		return 0;
	}

}
