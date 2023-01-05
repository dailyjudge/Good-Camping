package com.project.camping.main;

public class SiteViewDTO {
	private int cv_no;
	private int cv_siteNo;
	private int cv_viewCount;
	
	public SiteViewDTO() {
		// TODO Auto-generated constructor stub
	}

	public SiteViewDTO(int cv_no, int cv_siteNo, int cv_viewCount) {
		super();
		this.cv_no = cv_no;
		this.cv_siteNo = cv_siteNo;
		this.cv_viewCount = cv_viewCount;
	}

	public int getCv_no() {
		return cv_no;
	}

	public void setCv_no(int cv_no) {
		this.cv_no = cv_no;
	}

	public int getCv_siteNo() {
		return cv_siteNo;
	}

	public void setCv_siteNo(int cv_siteNo) {
		this.cv_siteNo = cv_siteNo;
	}

	public int getCv_viewCount() {
		return cv_viewCount;
	}

	public void setCv_viewCount(int cv_viewCount) {
		this.cv_viewCount = cv_viewCount;
	}

	@Override
	public String toString() {
		return "SiteViewDTO [cv_no=" + cv_no + ", cv_siteNo=" + cv_siteNo + ", cv_viewCount=" + cv_viewCount + "]";
	}
	
}
