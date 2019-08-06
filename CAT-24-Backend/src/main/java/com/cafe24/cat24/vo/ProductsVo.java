package com.cafe24.cat24.vo;

import java.util.Date;

public class ProductsVo 
{
	
	/** 상품분류 **/
	private long product_no;
	/** 상품코드 **/
	private String product_code;
	/** 자체상품분류 **/
	private String custom_product_code;
	/** 상품명 **/
	private String product_name;
	/** 모델명 **/
	private String model_name;
	/** 원가 **/
	private double cost_price;
	/** 판매가 **/
	private double selling_price;
	/** 요약설명 **/
	private String summary;
	/** 설명 **/
	private String detail;
	/** 상품이미지 **/
	private String product_image;
	/** 추가이미지 **/
	private String product_subimage;
	/** 판매중여부 **/
	private String sell_yn;
	/** 할인여부 **/
	private String discount_yn;
	/** 등록자 **/
	private String reg_id;
	/** 등록일자 **/
	private Date reg_Date;
	/** 카테고리분류 **/
	private long category_no;
	
	public long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(long product_no) {
		this.product_no = product_no;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getCustom_product_code() {
		return custom_product_code;
	}
	public void setCustom_product_code(String custom_product_code) {
		this.custom_product_code = custom_product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public double getCost_price() {
		return cost_price;
	}
	public void setCost_price(double cost_price) {
		this.cost_price = cost_price;
	}
	public double getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(double selling_price) {
		this.selling_price = selling_price;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getProduct_subimage() {
		return product_subimage;
	}
	public void setProduct_subimage(String product_subimage) {
		this.product_subimage = product_subimage;
	}
	public String getSell_yn() {
		return sell_yn;
	}
	public void setSell_yn(String sell_yn) {
		this.sell_yn = sell_yn;
	}
	public String getDiscount_yn() {
		return discount_yn;
	}
	public void setDiscount_yn(String discount_yn) {
		this.discount_yn = discount_yn;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public Date getReg_Date() {
		return reg_Date;
	}
	public void setReg_Date(Date reg_Date) {
		this.reg_Date = reg_Date;
	}
	public long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(long category_no) {
		this.category_no = category_no;
	}
	
	
	
}
