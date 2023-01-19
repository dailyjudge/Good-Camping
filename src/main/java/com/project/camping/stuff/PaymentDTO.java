package com.project.camping.stuff;

public class PaymentDTO {
 private String cid;
 private String partner_order_id;
 private String partner_user_id;
 private String item_name;
 private String quantity;
 private String total_amount;
 private String tax_free_amount;
 private String approval_url;
 private String cancel_url;
 private String fail_url;
 
 public PaymentDTO() {
	// TODO Auto-generated constructor stub
}
 
public PaymentDTO(String cid, String partner_order_id, String partner_user_id, String item_name, String quantity,
		String total_amount, String tax_free_amount, String approval_url, String cancel_url, String fail_url) {
	super();
	this.cid = cid;
	this.partner_order_id = partner_order_id;
	this.partner_user_id = partner_user_id;
	this.item_name = item_name;
	this.quantity = quantity;
	this.total_amount = total_amount;
	this.tax_free_amount = tax_free_amount;
	this.approval_url = approval_url;
	this.cancel_url = cancel_url;
	this.fail_url = fail_url;
}

public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getPartner_order_id() {
	return partner_order_id;
}
public void setPartner_order_id(String partner_order_id) {
	this.partner_order_id = partner_order_id;
}
public String getPartner_user_id() {
	return partner_user_id;
}
public void setPartner_user_id(String partner_user_id) {
	this.partner_user_id = partner_user_id;
}
public String getItem_name() {
	return item_name;
}
public void setItem_name(String item_name) {
	this.item_name = item_name;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getTotal_amount() {
	return total_amount;
}
public void setTotal_amount(String total_amount) {
	this.total_amount = total_amount;
}
public String getTax_free_amount() {
	return tax_free_amount;
}
public void setTax_free_amount(String tax_free_amount) {
	this.tax_free_amount = tax_free_amount;
}
public String getApproval_url() {
	return approval_url;
}
public void setApproval_url(String approval_url) {
	this.approval_url = approval_url;
}
public String getCancel_url() {
	return cancel_url;
}
public void setCancel_url(String cancel_url) {
	this.cancel_url = cancel_url;
}
public String getFail_url() {
	return fail_url;
}
public void setFail_url(String fail_url) {
	this.fail_url = fail_url;
}

@Override
public String toString() {
	return "cid=" + cid + "&partner_order_id=" + partner_order_id + "&partner_user_id=" + partner_user_id
			+ "&item_name=" + item_name + "&quantity=" + quantity + "&total_amount=" + total_amount
			+ "&tax_free_amount=" + tax_free_amount + "&approval_url=" + approval_url + "&cancel_url=" + cancel_url
			+ "&fail_url=" + fail_url;
}


 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
