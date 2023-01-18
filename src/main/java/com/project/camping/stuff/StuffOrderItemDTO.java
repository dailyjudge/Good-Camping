package com.project.camping.stuff;

public class StuffOrderItemDTO {

	private int soi_no; //주문한상품 테이블의 pk
	private int soi_so_no; //stuff_order 의 pk
	private int soi_stuff_no; //상품 pk
	private int soi_sc_amount; //상품 개수 
	
	
	public StuffOrderItemDTO() {
		// TODO Auto-generated constructor stub
	}


	public StuffOrderItemDTO(int soi_no, int soi_so_no, int soi_stuff_no, int soi_sc_amount) {
		super();
		this.soi_no = soi_no;
		this.soi_so_no = soi_so_no;
		this.soi_stuff_no = soi_stuff_no;
		this.soi_sc_amount = soi_sc_amount;
	}


	public int getSoi_no() {
		return soi_no;
	}


	public void setSoi_no(int soi_no) {
		this.soi_no = soi_no;
	}


	public int getSoi_so_no() {
		return soi_so_no;
	}


	public void setSoi_so_no(int soi_so_no) {
		this.soi_so_no = soi_so_no;
	}


	public int getSoi_stuff_no() {
		return soi_stuff_no;
	}


	public void setSoi_stuff_no(int soi_stuff_no) {
		this.soi_stuff_no = soi_stuff_no;
	}


	public int getSoi_sc_amount() {
		return soi_sc_amount;
	}


	public void setSoi_sc_amount(int soi_sc_amount) {
		this.soi_sc_amount = soi_sc_amount;
	}


	
	
	
}
