package com.project.camping.stuff;

import java.util.Date;
import java.util.List;

public class StuffOrderDTO {
	private int so_no;
	private String so_user_id;
	private int so_user_zoncode;
	private String so_user_addr;
	private String so_user_detailAddr;
	private Date so_date;
	private String so_data;
	private int ordertotalmoney;
	private String orderImg;
	public StuffOrderDTO(int so_no, String so_user_id, int so_user_zoncode, String so_user_addr,
			String so_user_detailAddr, Date so_date, String so_data, int ordertotalmoney, String orderImg) {
		super();
		this.so_no = so_no;
		this.so_user_id = so_user_id;
		this.so_user_zoncode = so_user_zoncode;
		this.so_user_addr = so_user_addr;
		this.so_user_detailAddr = so_user_detailAddr;
		this.so_date = so_date;
		this.so_data = so_data;
		this.ordertotalmoney = ordertotalmoney;
		this.orderImg = orderImg;
	}

	public StuffOrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getSo_no() {
		return so_no;
	}

	public void setSo_no(int so_no) {
		this.so_no = so_no;
	}

	public String getSo_user_id() {
		return so_user_id;
	}

	public void setSo_user_id(String so_user_id) {
		this.so_user_id = so_user_id;
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

	public String getSo_data() {
		return so_data;
	}

	public void setSo_data(String so_data) {
		this.so_data = so_data;
	}

	public int getOrdertotalmoney() {
		return ordertotalmoney;
	}

	public void setOrdertotalmoney(int ordertotalmoney) {
		this.ordertotalmoney = ordertotalmoney;
	}

	public String getOrderImg() {
		return orderImg;
	}

	public void setOrderImg(String orderImg) {
		this.orderImg = orderImg;
	}

	@Override
	public String toString() {
		return "StuffOrderDTO [so_no=" + so_no + ", so_user_id=" + so_user_id + ", so_user_zoncode=" + so_user_zoncode
				+ ", so_user_addr=" + so_user_addr + ", so_user_detailAddr=" + so_user_detailAddr + ", so_date="
				+ so_date + ", so_data=" + so_data + ", ordertotalmoney=" + ordertotalmoney + ", orderImg=" + orderImg
				+ "]";
	}
	

}