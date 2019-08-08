package com.cafe24.cat24frontend.service;

import java.util.List;


import com.cafe24.cat24frontend.dto.JSONResult;
import com.cafe24.cat24frontend.vo.AdminVo;
import com.cafe24.cat24frontend.vo.ProductsVo;
import com.cafe24.cat24frontend.vo.UsersVo;

public interface AdminService 
{
	/** 로그인  **/
	public Boolean login(AdminVo adminVo);
	
	/** 관리자 회원목록 **/
	public List<UsersVo> memberlist();
	
	/** 관리자 상품목록**/
	public List<ProductsVo> productlist();
	
	/** 관리자 상품등록 **/
	public Boolean productRegister(ProductsVo productvo);
}
