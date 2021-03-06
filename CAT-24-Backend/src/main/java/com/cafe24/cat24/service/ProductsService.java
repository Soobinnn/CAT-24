package com.cafe24.cat24.service;

import java.util.List;
import java.util.Map;

import com.cafe24.cat24.vo.ProductsVo;

public interface ProductsService 
{
	/** 상품 전체 목록 **/
	public List<ProductsVo> list();
	
	/** 상품 등록 **/
	public Boolean add(ProductsVo productVo);
	
	/** 상품 전체 갯수 **/
	public Map<String,Integer> count();
	
	/** 해당 상품 조회 **/
	public ProductsVo get(Long product_no);
	
	/** 해당 상품 삭제 **/
	public Boolean delete(Long product_no);
	
	/** 해당 상품 수정 **/
	public Boolean update(ProductsVo productvo, Long product_no);
}
