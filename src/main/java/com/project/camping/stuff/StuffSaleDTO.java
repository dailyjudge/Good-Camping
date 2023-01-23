package com.project.camping.stuff;

public class StuffSaleDTO {
	
	private int ss_no;
	private int  ss_stuff_no;
	private String ss_category;
	private int ss_count;
	
	
	public StuffSaleDTO() {
		// TODO Auto-generated constructor stub
	}


	public StuffSaleDTO(int ss_no, int ss_stuff_no, String ss_category, int ss_count) {
		super();
		this.ss_no = ss_no;
		this.ss_stuff_no = ss_stuff_no;
		this.ss_category = ss_category;
		this.ss_count = ss_count;
	}


	public int getSs_no() {
		return ss_no;
	}


	public void setSs_no(int ss_no) {
		this.ss_no = ss_no;
	}


	public int getSs_stuff_no() {
		return ss_stuff_no;
	}


	public void setSs_stuff_no(int ss_stuff_no) {
		this.ss_stuff_no = ss_stuff_no;
	}


	public String getSs_category() {
		return ss_category;
	}


	public void setSs_category(String ss_category) {
		this.ss_category = ss_category;
	}


	public int getSs_count() {
		return ss_count;
	}


	public void setSs_count(int ss_count) {
		this.ss_count = ss_count;
	}


	@Override
	public String toString() {
		return "StuffSaleDTO [ss_no=" + ss_no + ", ss_stuff_no=" + ss_stuff_no + ", ss_category=" + ss_category
				+ ", ss_count=" + ss_count + "]";
	}
	
	

}
