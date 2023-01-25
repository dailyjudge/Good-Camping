package com.project.camping.stuff;

import java.sql.Date;

public class StuffUserOrderDTO {
	//so_user_addr, so_user_detailAddr, so_date 
	private int so_no;
	private String s_image;
	private String s_title;
	private int s_price;
	private int soi_sc_amount;
	private String so_user_zoncode;
	private String so_user_addr;
	private String so_user_detailAddr;
	private Date so_date;
	
	public StuffUserOrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public StuffUserOrderDTO(int so_no, String s_image, String s_title, int s_price, int soi_sc_amount,
			String so_user_zoncode, String so_user_addr, String so_user_detailAddr, Date so_date) {
		super();
		this.so_no = so_no;
		this.s_image = s_image;
		this.s_title = s_title;
		this.s_price = s_price;
		this.soi_sc_amount = soi_sc_amount;
		this.so_user_zoncode = so_user_zoncode;
		this.so_user_addr = so_user_addr;
		this.so_user_detailAddr = so_user_detailAddr;
		this.so_date = so_date;
	}

	public int getSo_no() {
		return so_no;
	}

	public void setSo_no(int so_no) {
		this.so_no = so_no;
	}

	public String getS_image() {
		return s_image;
	}

	public void setS_image(String s_image) {
		this.s_image = s_image;
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

	public String getSo_user_zoncode() {
		return so_user_zoncode;
	}

	public void setSo_user_zoncode(String so_user_zoncode) {
		this.so_user_zoncode = so_user_zoncode;
	}

	public String getSo_user_addr() {
		return so_user_addr;
	}

	public void setSo_user_addr(String so_user_addr) {
		this.so_user_addr = so_user_addr;
	}

	public String getSo_user_detailAddr() {
		return so_user_detailAddr;
	}

	public void setSo_user_detailAddr(String so_user_detailAddr) {
		this.so_user_detailAddr = so_user_detailAddr;
	}

	public Date getSo_date() {
		return so_date;
	}

	public void setSo_date(Date so_date) {
		this.so_date = so_date;
	}

	@Override
	public String toString() {
		return "StuffUserOrderDTO [so_no=" + so_no + ", s_image=" + s_image + ", s_title=" + s_title + ", s_price="
				+ s_price + ", soi_sc_amount=" + soi_sc_amount + ", so_user_zoncode=" + so_user_zoncode
				+ ", so_user_addr=" + so_user_addr + ", so_user_detailAddr=" + so_user_detailAddr + ", so_date="
				+ so_date + "]";
	}
	
}
