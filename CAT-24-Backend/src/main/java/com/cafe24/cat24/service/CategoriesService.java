package com.cafe24.cat24.service;


import java.util.List;
import java.util.Map;

import com.cafe24.cat24.vo.CategoriesVo;
import com.cafe24.cat24.vo.ProductsVo;

public interface CategoriesService 
{
	/** 카테고리등록 **/
	public Boolean add(CategoriesVo categoriesvo);
	
	/** 카테고리 전체목록  조회**/
	public List<CategoriesVo> list();
	
	/** 카테고리 전체 갯수 **/
	public Map<String, Integer> count();
	
	/** 해당 카테고리 조회 **/
	public CategoriesVo get(long category_no);
	
	/** 해당 카테고리 삭제 **/
	public Boolean delete(Long category_no);
	
	/** 해당 카테고리 수정 **/
	public Boolean update(CategoriesVo categoriesVo, int category_no);
}
