package com.cafe24.cat24.vo;

import java.util.Date;

public class CartVo 
{
	/** 장바구니분류 **/
	private long cart_no;
	/** 수량 **/
	private long amount;
	/** 구매여부 **/
	private String buy_YN;
	/** 회원여부 **/
	private String member_YN;
	/** 생성일 **/
	private Date reg_date;
	/** 회원번호 **/
	private long member_no;
	/**  상품분류 **/
	private long product_no;
	
	public long getCart_no() {
		return cart_no;
	}
	public void setCart_no(long cart_no) {
		this.cart_no = cart_no;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getBuy_YN() {
		return buy_YN;
	}
	public void setBuy_YN(String buy_YN) {
		this.buy_YN = buy_YN;
	}
	public String getMember_YN() {
		return member_YN;
	}
	public void setMember_YN(String member_YN) {
		this.member_YN = member_YN;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public long getMember_no() {
		return member_no;
	}
	public void setMember_no(long member_no) {
		this.member_no = member_no;
	}
	public long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}
	
	
}
