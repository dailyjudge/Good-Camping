package com.project.camping.bulletinB;

import java.sql.Date;

public class ComuDTO {
	private String comu_no;
	private String comu_groupid;
	private String comu_title;
	private String comu_write_id;
	private Date comu_w_time;
	private Date comu_d_time;
	
	private String comu_readcount;
	private String comu_content;
	private String comu_file;
	
	public ComuDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getComu_no() {
		return comu_no;
	}

	public void setComu_no(String comu_no) {
		this.comu_no = comu_no;
	}

	public String getComu_groupid() {
		return comu_groupid;
	}

	public void setComu_groupid(String comu_groupid) {
		this.comu_groupid = comu_groupid;
	}

	public String getComu_title() {
		return comu_title;
	}

	public void setComu_title(String comu_title) {
		this.comu_title = comu_title;
	}

	public String getComu_write_id() {
		return comu_write_id;
	}

	public void setComu_write_id(String comu_write_id) {
		this.comu_write_id = comu_write_id;
	}

	public Date getComu_w_time() {
		return comu_w_time;
	}

	public void setComu_w_time(Date comu_w_time) {
		this.comu_w_time = comu_w_time;
	}

	public Date getComu_d_time() {
		return comu_d_time;
	}

	public void setComu_d_time(Date comu_d_time) {
		this.comu_d_time = comu_d_time;
	}

	public String getComu_readcount() {
		return comu_readcount;
	}

	public void setComu_readcount(String comu_readcount) {
		this.comu_readcount = comu_readcount;
	}

	public String getComu_content() {
		return comu_content;
	}

	public void setComu_content(String comu_content) {
		this.comu_content = comu_content;
	}

	public String getComu_file() {
		return comu_file;
	}

	public void setComu_file(String comu_file) {
		this.comu_file = comu_file;
	}

	public ComuDTO(String comu_no, String comu_groupid, String comu_title, String comu_write_id, Date comu_w_time,
			Date comu_d_time, String comu_readcount, String comu_content, String comu_file) {
		super();
		this.comu_no = comu_no;
		this.comu_groupid = comu_groupid;
		this.comu_title = comu_title;
		this.comu_write_id = comu_write_id;
		this.comu_w_time = comu_w_time;
		this.comu_d_time = comu_d_time;
		this.comu_readcount = comu_readcount;
		this.comu_content = comu_content;
		this.comu_file = comu_file;
	}
	
}
