package com.project.camping.account;

import java.sql.Date;

public class AccountDTO {
	private String ac_id;
	private String ac_pw;
	private String ac_name;
	private String ac_birth;
	private String ac_phone;
	
	private String ac_postcode;
	private String ac_address;
	private String ac_detailAddress;
	private String ac_extraAddress;
	
	private String ac_gender;
	private String ac_file;
	private String ac_sessionkey;
	private Date ac_sessionlimit;
	
	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(String ac_id, String ac_pw, String ac_name, String ac_birth, String ac_phone, String ac_postcode,
			String ac_address, String ac_detailAddress, String ac_extraAddress, String ac_gender, String ac_file,
			String ac_sessionkey, Date ac_sessionlimit) {
		super();
		this.ac_id = ac_id;
		this.ac_pw = ac_pw;
		this.ac_name = ac_name;
		this.ac_birth = ac_birth;
		this.ac_phone = ac_phone;
		this.ac_postcode = ac_postcode;
		this.ac_address = ac_address;
		this.ac_detailAddress = ac_detailAddress;
		this.ac_extraAddress = ac_extraAddress;
		this.ac_gender = ac_gender;
		this.ac_file = ac_file;
		this.ac_sessionkey = ac_sessionkey;
		this.ac_sessionlimit = ac_sessionlimit;
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

	public String getAc_birth() {
		return ac_birth;
	}

	public void setAc_birth(String ac_birth) {
		this.ac_birth = ac_birth;
	}

	public String getAc_phone() {
		return ac_phone;
	}

	public void setAc_phone(String ac_phone) {
		this.ac_phone = ac_phone;
	}

	public String getAc_postcode() {
		return ac_postcode;
	}

	public void setAc_postcode(String ac_postcode) {
		this.ac_postcode = ac_postcode;
	}

	public String getAc_address() {
		return ac_address;
	}

	public void setAc_address(String ac_address) {
		this.ac_address = ac_address;
	}

	public String getAc_detailAddress() {
		return ac_detailAddress;
	}

	public void setAc_detailAddress(String ac_detailAddress) {
		this.ac_detailAddress = ac_detailAddress;
	}

	public String getAc_extraAddress() {
		return ac_extraAddress;
	}

	public void setAc_extraAddress(String ac_extraAddress) {
		this.ac_extraAddress = ac_extraAddress;
	}

	public String getAc_gender() {
		return ac_gender;
	}

	public void setAc_gender(String ac_gender) {
		this.ac_gender = ac_gender;
	}

	public String getAc_file() {
		return ac_file;
	}

	public void setAc_file(String ac_file) {
		this.ac_file = ac_file;
	}

	public String getAc_sessionkey() {
		return ac_sessionkey;
	}

	public void setAc_sessionkey(String ac_sessionkey) {
		this.ac_sessionkey = ac_sessionkey;
	}

	public Date getAc_sessionlimit() {
		return ac_sessionlimit;
	}

	public void setAc_sessionlimit(Date ac_sessionlimit) {
		this.ac_sessionlimit = ac_sessionlimit;
	}

	@Override
	public String toString() {
		return "AccountDTO [ac_id=" + ac_id + ", ac_pw=" + ac_pw + ", ac_name=" + ac_name + ", ac_birth=" + ac_birth
				+ ", ac_phone=" + ac_phone + ", ac_postcode=" + ac_postcode + ", ac_address=" + ac_address
				+ ", ac_detailAddress=" + ac_detailAddress + ", ac_extraAddress=" + ac_extraAddress + ", ac_gender="
				+ ac_gender + ", ac_file=" + ac_file + ", ac_sessionkey=" + ac_sessionkey + ", ac_sessionlimit="
				+ ac_sessionlimit + "]";
	}
	
	
}