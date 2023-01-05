package com.project.camping.main;

public class LikeDTO {
	private int cl_no;
	private String cl_userId;
	private int cl_siteNo;
	
	public LikeDTO() {
		// TODO Auto-generated constructor stub
	}

	public LikeDTO(int cl_no, String cl_userId, int cl_siteNo) {
		super();
		this.cl_no = cl_no;
		this.cl_userId = cl_userId;
		this.cl_siteNo = cl_siteNo;
	}

	public int getCl_no() {
		return cl_no;
	}

	public void setCl_no(int cl_no) {
		this.cl_no = cl_no;
	}

	public String getCl_userId() {
		return cl_userId;
	}

	public void setCl_userId(String cl_userId) {
		this.cl_userId = cl_userId;
	}

	public int getCl_siteNo() {
		return cl_siteNo;
	}

	public void setCl_siteNo(int cl_siteNo) {
		this.cl_siteNo = cl_siteNo;
	}

	@Override
	public String toString() {
		return "LikeDTO [cl_no=" + cl_no + ", cl_userId=" + cl_userId + ", cl_siteNo=" + cl_siteNo + "]";
	}
	
	
}
