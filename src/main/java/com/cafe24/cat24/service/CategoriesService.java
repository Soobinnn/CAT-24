package com.cafe24.cat24.service;


import java.util.List;

import com.cafe24.cat24.vo.CategoriesVo;

public interface CategoriesService 
{
	/** 카테고리등록 **/
	public Boolean add(CategoriesVo categoriesvo);
	
	/** 카테고리 전체목록 **/
	public List<CategoriesVo> list();
	
	/** 카테고리 전체 갯수 **/
	public int count();
}
