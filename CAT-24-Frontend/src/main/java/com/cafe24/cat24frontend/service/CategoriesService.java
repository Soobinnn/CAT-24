package com.cafe24.cat24frontend.service;

import java.util.List;

import com.cafe24.cat24frontend.vo.CategoriesVo;


public interface CategoriesService 
{
	
	/** 카테고리 목록**/
	public List<CategoriesVo> categorylist();
}
