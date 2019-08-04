package com.cafe24.cat24.vo;

import java.util.Date;

public class OrdersVo 
{
	/** 주문번호 **/
	private String order_no;
	
	/** 배송번호 **/
	private long delivery_no;
	
	/** 주문일자 **/
	private Date order_date;
	
	/** 총금액 **/
	private double total_sum;
	
	/** 처리상태 **/
	private String access_YN;

	/** 주문비밀번호_비회원 **/
	private String unmember_password;
	
	/** 회원번호 **/
	private long member_no;

	/** 주문상세 **/
	/**  주문상세번호  **/
	private long orderdetail_no;
	
	/** 수량 **/
	private long amount;
	
	/** 가격 **/
	private double sum;

	
	

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public long getDelivery_no() {
		return delivery_no;
	}

	public void setDelivery_no(long delivery_no) {
		this.delivery_no = delivery_no;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public double getTotal_sum() {
		return total_sum;
	}

	public void setTotal_sum(double total_sum) {
		this.total_sum = total_sum;
	}

	public String getAccess_YN() {
		return access_YN;
	}

	public void setAccess_YN(String access_YN) {
		this.access_YN = access_YN;
	}

	public String getUnmember_password() {
		return unmember_password;
	}

	public void setUnmember_password(String unmember_password) {
		this.unmember_password = unmember_password;
	}

	public long getMember_no() {
		return member_no;
	}

	public void setMember_no(long member_no) {
		this.member_no = member_no;
	}

	public long getOrderdetail_no() {
		return orderdetail_no;
	}

	public void setOrderdetail_no(long orderdetail_no) {
		this.orderdetail_no = orderdetail_no;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "OrdersVo [order_no=" + order_no + ", delivery_no=" + delivery_no + ", order_date=" + order_date
				+ ", total_sum=" + total_sum + ", access_YN=" + access_YN + ", unmember_password=" + unmember_password
				+ ", member_no=" + member_no + ", orderdetail_no=" + orderdetail_no + ", amount=" + amount + ", sum="
				+ sum + "]";
	}

	
	
}
