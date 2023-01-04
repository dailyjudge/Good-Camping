package com.project.camping.account;

public class AccountDTO {
	private String ac_id;
	private String ac_pw;
	private String ac_name;
	private String ac_img;
	
	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(String ac_id, String ac_pw, String ac_name, String ac_img) {
		super();
		this.ac_id = ac_id;
		this.ac_pw = ac_pw;
		this.ac_name = ac_name;
		this.ac_img = ac_img;
	}

	public String getAc_id() {
		return ac_id;
	}

	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}

	public String getAc_pw() {
		return ac_pw;
	}

	public void setAc_pw(String ac_pw) {
		this.ac_pw = ac_pw;
	}

	public String getAc_name() {
		return ac_name;
	}

	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}

	public String getAc_img() {
		return ac_img;
	}

	public void setAc_img(String ac_img) {
		this.ac_img = ac_img;
	}

	@Override
	public String toString() {
		return "AccountDTO [ac_id=" + ac_id + ", ac_pw=" + ac_pw + ", ac_name=" + ac_name + ", ac_img=" + ac_img + "]";
	}
	
}
