package com.cafe24.cat24frontend.service;

import java.util.List;

import com.cafe24.cat24frontend.vo.CategoriesVo;
import com.cafe24.cat24frontend.vo.ProductsVo;


public interface CategoriesService 
{
	
	/** 카테고리 목록**/
	public List<CategoriesVo> categorylist();
	
	/** 해당 카테고리 상품 조회 **/
	public List<ProductsVo> product(Long category_no);
}
