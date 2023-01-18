package com.project.camping.stuff;

import java.util.Date;

public class StuffAllDTO {

	private int so_no;
	private int s_no;
	private String s_title;
	private int  s_price;
	private int soi_sc_amount;
	private Date so_date;
	private int so_user_zoncode;
	private String so_user_addr;
	private String so_user_detailaddr;
	
	
	
	public StuffAllDTO() {
		// TODO Auto-generated constructor stub
	}



	public StuffAllDTO(int so_no, int s_no, String s_title, int s_price, int soi_sc_amount, Date so_date,
			int so_user_zoncode, String so_user_addr, String so_user_detailaddr) {
		super();
		this.so_no = so_no;
		this.s_no = s_no;
		this.s_title = s_title;
		this.s_price = s_price;
		this.soi_sc_amount = soi_sc_amount;
		this.so_date = so_date;
		this.so_user_zoncode = so_user_zoncode;
		this.so_user_addr = so_user_addr;
		this.so_user_detailaddr = so_user_detailaddr;
	}



	public int getSo_no() {
		return so_no;
	}



	public void setSo_no(int so_no) {
		this.so_no = so_no;
	}



	public int getS_no() {
		return s_no;
	}



	public void setS_no(int s_no) {
		this.s_no = s_no;
	}



	public String getS_title() {
		return s_title;
	}



	public void setS_title(String s_title) {
		this.s_title = s_title;
	}



	public int getS_price() {
		return s_price;
	}



	public void setS_price(int s_price) {
		this.s_price = s_price;
	}



	public int getSoi_sc_amount() {
		return soi_sc_amount;
	}



	public void setSoi_sc_amount(int soi_sc_amount) {
		this.soi_sc_amount = soi_sc_amount;
	}



	public Date getSo_date() {
		return so_date;
	}



	public void setSo_date(Date so_date) {
		this.so_date = so_date;
	}



	public int getSo_user_zoncode() {
		return so_user_zoncode;
	}



	public void setSo_user_zoncode(int so_user_zoncode) {
		this.so_user_zoncode = so_user_zoncode;
	}



	public String getSo_user_addr() {
		return so_user_addr;
	}



	public void setSo_user_addr(String so_user_addr) {
		this.so_user_addr = so_user_addr;
	}



	public String getSo_user_detailaddr() {
		return so_user_detailaddr;
	}



	public void setSo_user_detailaddr(String so_user_detailaddr) {
		this.so_user_detailaddr = so_user_detailaddr;
	}



	@Override
	public String toString() {
		return "StuffAllDTO [so_no=" + so_no + ", s_no=" + s_no + ", s_title=" + s_title + ", s_price=" + s_price
				+ ", soi_sc_amount=" + soi_sc_amount + ", so_date=" + so_date + ", so_user_zoncode=" + so_user_zoncode
				+ ", so_user_addr=" + so_user_addr + ", so_user_detailaddr=" + so_user_detailaddr + "]";
	}
	
	
	
}
