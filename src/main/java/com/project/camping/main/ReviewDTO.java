package com.project.camping.main;

import java.util.Date;

public class ReviewDTO {
	private int cr_no;
	private int cr_campingSiteNo;
	private String cr_author;
	private String cr_title;
	private String cr_star;
	private String cr_content;
	private String cr_date;
	
	public ReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewDTO(int cr_no, int cr_campingSiteNo, String cr_author, String cr_title, String cr_star,
			String cr_content, String cr_date) {
		super();
		this.cr_no = cr_no;
		this.cr_campingSiteNo = cr_campingSiteNo;
		this.cr_author = cr_author;
		this.cr_title = cr_title;
		this.cr_star = cr_star;
		this.cr_content = cr_content;
		this.cr_date = cr_date;
	}

	public int getCr_no() {
		return cr_no;
	}

	public void setCr_no(int cr_no) {
		this.cr_no = cr_no;
	}

	public int getCr_campingSiteNo() {
		return cr_campingSiteNo;
	}

	public void setCr_campingSiteNo(int cr_campingSiteNo) {
		this.cr_campingSiteNo = cr_campingSiteNo;
	}

	public String getCr_author() {
		return cr_author;
	}

	public void setCr_author(String cr_author) {
		this.cr_author = cr_author;
	}

	public String getCr_title() {
		return cr_title;
	}

	public void setCr_title(String cr_title) {
		this.cr_title = cr_title;
	}

	public String getCr_star() {
		return cr_star;
	}

	public void setCr_star(String cr_star) {
		this.cr_star = cr_star;
	}

	public String getCr_content() {
		return cr_content;
	}

	public void setCr_content(String cr_content) {
		this.cr_content = cr_content;
	}

	public String getCr_date() {
		return cr_date;
	}

	public void setCr_date(String cr_date) {
		this.cr_date = cr_date;
	}

	@Override
	public String toString() {
		return "ReviewDTO [cr_no=" + cr_no + ", cr_campingSiteNo=" + cr_campingSiteNo + ", cr_author=" + cr_author
				+ ", cr_title=" + cr_title + ", cr_star=" + cr_star + ", cr_content=" + cr_content + ", cr_date="
				+ cr_date + "]";
	}

	
}
