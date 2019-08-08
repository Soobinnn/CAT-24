package com.cafe24.cat24frontend.vo;

import java.util.Date;

public class CategoriesVo 
{
	/** 카테고리 분류 **/
	private int category_no;
	/** 분류 Depth **/
	private int category_depth;
	/** 부모 카테고리 분류 **/
	private int parent_category_no;
	/** 분류명 **/
	private String category_name;
	/** 카테고리 전체이름 **/
	private String full_category_name;
	/** 카테고리 전체분류 **/
	private String full_category_no;
	/** 최상위 카테고리 분류 **/
	private int root_category_no;
	/** 진열 순서 **/
	private int display_order;
	/** 등록자 **/
	private String reg_id;
	/** 등록일 **/
	private Date reg_date;
	/** 수정자 **/
	private String update_id;
	/** 수정일 **/
	private Date update_date;
	
	
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public int getCategory_depth() {
		return category_depth;
	}
	public void setCategory_depth(int category_depth) {
		this.category_depth = category_depth;
	}
	public int getParent_category_no() {
		return parent_category_no;
	}
	public void setParent_category_no(int parent_category_no) {
		this.parent_category_no = parent_category_no;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getFull_category_name() {
		return full_category_name;
	}
	public void setFull_category_name(String full_category_name) {
		this.full_category_name = full_category_name;
	}

	public int getRoot_category_no() {
		return root_category_no;
	}
	public void setRoot_category_no(int root_category_no) {
		this.root_category_no = root_category_no;
	}
	public int getDisplay_order() {
		return display_order;
	}
	public void setDisplay_order(int display_order) {
		this.display_order = display_order;
	}
	public String getFull_category_no() {
		return full_category_no;
	}
	public void setFull_category_no(String full_category_no) {
		this.full_category_no = full_category_no;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getUpdate_id() {
		return update_id;
	}
	public void setUpdate_id(String update_id) {
		this.update_id = update_id;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	
}
