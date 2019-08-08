package com.cafe24.cat24frontend.service;

import java.util.List;

import com.cafe24.cat24frontend.vo.ProductsVo;

public interface ProductsService 
{
	/** 상품 전체 목록**/
	public List<ProductsVo> productlist();
	
	/** 해당 상품 보기 **/
	public ProductsVo get(Long product_no);
}
