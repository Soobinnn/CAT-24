package com.cafe24.cat24.service;

import java.util.List;

import com.cafe24.cat24.vo.ProductsVo;

public interface ProductsService 
{
	/** 상품 전체 목록 **/
	public List<ProductsVo> list();
	
	/** 상품 등록 **/
	public Boolean add(ProductsVo productVo);
}
