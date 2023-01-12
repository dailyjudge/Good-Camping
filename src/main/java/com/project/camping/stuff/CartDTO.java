package com.project.camping.stuff;

public class CartDTO {

	private int sc_cart_id;
	private String sc_user_id;
	private int sc_stuff_no;
	private int sc_amount;
	private String s_title;
	private String s_image;
	private int s_price;
	private int money;
	private int order_no;
	
	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(int sc_cart_id, String sc_user_id, int sc_stuff_no, int sc_amount, String s_title, String s_image,
			int s_price, int money, int order_no) {
		super();
		this.sc_cart_id = sc_cart_id;
		this.sc_user_id = sc_user_id;
		this.sc_stuff_no = sc_stuff_no;
		this.sc_amount = sc_amount;
		this.s_title = s_title;
		this.s_image = s_image;
		this.s_price = s_price;
		this.money = money;
		this.order_no = order_no;
	}

	public int getSc_cart_id() {
		return sc_cart_id;
	}

	public void setSc_cart_id(int sc_cart_id) {
		this.sc_cart_id = sc_cart_id;
	}

	public String getSc_user_id() {
		return sc_user_id;
	}

	public void setSc_user_id(String sc_user_id) {
		this.sc_user_id = sc_user_id;
	}

	public int getSc_stuff_no() {
		return sc_stuff_no;
	}

	public void setSc_stuff_no(int sc_stuff_no) {
		this.sc_stuff_no = sc_stuff_no;
	}

	public int getSc_amount() {
		return sc_amount;
	}

	public void setSc_amount(int sc_amount) {
		this.sc_amount = sc_amount;
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

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	@Override
	public String toString() {
		return "CartDTO [sc_cart_id=" + sc_cart_id + ", sc_user_id=" + sc_user_id + ", sc_stuff_no=" + sc_stuff_no
				+ ", sc_amount=" + sc_amount + ", s_title=" + s_title + ", s_image=" + s_image + ", s_price=" + s_price
				+ ", money=" + money + ", order_no=" + order_no + "]";
	}

	
	
	
	
	
}
