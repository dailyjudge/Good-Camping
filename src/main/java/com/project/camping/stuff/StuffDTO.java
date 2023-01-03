package com.project.camping.stuff;

public class StuffDTO {

	private int s_no;
	private String s_productId;
	private String s_category;
	private String s_detail_category;
	private String s_title;
	private String s_image;
	private String s_brand;
	private String s_price;
	
	public StuffDTO() {
		// TODO Auto-generated constructor stub
	}

	public StuffDTO(int s_no, String s_productId, String s_category, String s_detail_category, String s_title,
			String s_image, String s_brand, String s_price) {
		super();
		this.s_no = s_no;
		this.s_productId = s_productId;
		this.s_category = s_category;
		this.s_detail_category = s_detail_category;
		this.s_title = s_title;
		this.s_image = s_image;
		this.s_brand = s_brand;
		this.s_price = s_price;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_productId() {
		return s_productId;
	}

	public void setS_productId(String s_productId) {
		this.s_productId = s_productId;
	}

	public String getS_category() {
		return s_category;
	}

	public void setS_category(String s_category) {
		this.s_category = s_category;
	}

	public String getS_detail_category() {
		return s_detail_category;
	}

	public void setS_detail_category(String s_detail_category) {
		this.s_detail_category = s_detail_category;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_image() {
		return s_image;
	}

	public void setS_image(String s_image) {
		this.s_image = s_image;
	}

	public String getS_brand() {
		return s_brand;
	}

	public void setS_brand(String s_brand) {
		this.s_brand = s_brand;
	}

	public String getS_price() {
		return s_price;
	}

	public void setS_price(String s_price) {
		this.s_price = s_price;
	}

	@Override
	public String toString() {
		return "StuffDTO [s_no=" + s_no + ", s_productId=" + s_productId + ", s_category=" + s_category
				+ ", s_detail_category=" + s_detail_category + ", s_title=" + s_title + ", s_image=" + s_image
				+ ", s_brand=" + s_brand + ", s_price=" + s_price + "]";
	}
	 
}
