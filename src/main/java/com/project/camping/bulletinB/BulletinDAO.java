package com.project.camping.bulletinB;

import java.io.File;
import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.camping.account.AccountDTO;
import com.project.camping.account.AccountMapper;



@Service
public class BulletinDAO {
	
	private int allBoardCount;
	
	@Autowired
	SqlSession ss;
	
	List<ComuDTO> comus;

	public int getAllBoardCount() {
		return allBoardCount;
	}

	public void setAllBoardCount(int allBoardCount) {
		this.allBoardCount = allBoardCount;
	}
	
	//전체 숫자 조회하기 
	public void calcAllBoardCount() {
		ComuDTO cd = new ComuDTO();
		allBoardCount = ss.getMapper(BulletinMapper.class).getBoardCount(cd);
	}
	
	//페이징 조회
	public void getBoard(int pageNo, HttpServletRequest req) {
		
		int count = 3;
		int start = (pageNo -1) * count +1;
		int end = start + (count -1);
		
		int boardCount = 0;
		
//		ComuDTO cd = new ComuDTO();
		
		List<ComuDTO> comus = ss.getMapper(BulletinMapper.class).getBoards();
		
/*		for(ComuDTO comu : comus) {
			
		}*/
		
		int pageCount = (int) Math.ceil(boardCount/ (double) count);
		req.setAttribute("pageCount", pageCount);
		
		req.setAttribute("comus", comus);
		req.setAttribute("curPage", pageNo);
		
	}
	
	//신규 글 작성
	public void uploadBoard(HttpServletRequest request, ComuDTO cd ) {
		AccountDTO ac = (AccountDTO) request.getSession().getAttribute("loginAccount");
		
		String path = request.getSession().getServletContext().getRealPath("resources/comu-img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, 31457200, "utf-8", new DefaultFileRenamePolicy());
			System.out.println(ac.getAc_id());
			System.out.println(mr.getParameter("comu_title"));
			System.out.println(mr.getFilesystemName("comu_file"));
			System.out.println(mr.getParameter("comu_content"));

			cd.setComu_write_id(ac.getAc_id());
			cd.setComu_title(mr.getParameter("comu_title"));
			
			String comu_content = mr.getParameter("comu_content");
			cd.setComu_content(comu_content.replace("\r\n", "<br>"));
			
			
			String cd_file = mr.getFilesystemName("comu_file");
			cd.setComu_file(cd_file);
			System.out.println("저장되는 경로(실제 서버) : "+path);
			System.out.println("사진 이름 : "+cd_file);
			
			if(ss.getMapper(BulletinMapper.class).writeToBoard(cd) ==1) {
				request.setAttribute("result", "성공");
				allBoardCount++;
			}else {
				request.setAttribute("result", "실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("cd_file");
			new File(path + "/" + fileName).delete();
			request.setAttribute("r", "가입 실패");

		}

	}
	//글 수정
	public void upDateBoard(HttpServletRequest request, ComuDTO cd ) {
		AccountDTO ac = (AccountDTO) request.getSession().getAttribute("loginAccount");
		
		String path = request.getSession().getServletContext().getRealPath("resources/comu-img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, 31457200, "utf-8", new DefaultFileRenamePolicy());
			System.out.println(ac.getAc_id());
			System.out.println(mr.getParameter("comu_title"));
			System.out.println(mr.getFilesystemName("comu_file"));
			System.out.println(mr.getParameter("comu_content"));

			cd.setComu_write_id(ac.getAc_id());
			cd.setComu_title(mr.getParameter("comu_title"));
			cd.setComu_no(mr.getParameter("comu_no"));
			
			String comu_content = mr.getParameter("comu_content");
			cd.setComu_content(comu_content.replace("\r\n","<br>"));
			
			
			String cd_file = mr.getFilesystemName("comu_file");
			cd.setComu_file(cd_file);
			System.out.println("저장되는 경로(실제 서버) : "+path);
			System.out.println("사진 이름 : "+cd_file);
			
			if(ss.getMapper(BulletinMapper.class).UpdateThisBoard(cd) ==1) {
				request.setAttribute("result", "성공");
				allBoardCount++;
			}else {
				request.setAttribute("result", "실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("cd_file");
			new File(path + "/" + fileName).delete();
			request.setAttribute("r", "가입 실패");

		}

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

	public void getThisBoard(HttpServletRequest request) {
		String comu_no = request.getParameter("comu_no");
		System.out.println(comu_no);
		
		ComuDTO vo = ss.getMapper(BulletinMapper.class).getThisBoard(comu_no); //선택한 게시물	
		ss.getMapper(BulletinMapper.class).updateThisBoard(comu_no); // 조회수 +1
		
		String comu_content = vo.getComu_content();
		
		request.setAttribute("this_comu_vo", vo);
	}
	public void getEditBoard(HttpServletRequest request) {
		String comu_no = request.getParameter("comu_no");
		System.out.println(comu_no);
		
		ComuDTO vo = ss.getMapper(BulletinMapper.class).getThisBoard(comu_no); //선택한 게시물	
		String comu_content = vo.getComu_content();
		
		vo.setComu_content(comu_content.replace("<br>","\r\n"));
		
		request.setAttribute("this_comu_vo", vo);
	}

}
