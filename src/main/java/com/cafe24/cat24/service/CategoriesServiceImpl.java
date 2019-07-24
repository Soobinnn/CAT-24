package com.cafe24.cat24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.cat24.repository.CategoriesDao;
import com.cafe24.cat24.vo.CategoriesVo;

@Service
public class CategoriesServiceImpl implements CategoriesService
{
	@Autowired
	private CategoriesDao categoriesDao;
	
	/** 카테고리등록 **/
	public Boolean add(CategoriesVo categoriesvo)
	{
		return categoriesDao.add(categoriesvo);
	}
	
	/** 카테고리 전체목록 **/
	public List<CategoriesVo> list()
	{
		return categoriesDao.list();
	}
	
	/** 카테고리 전체 갯수 **/
	public int count()
	{
		return categoriesDao.count();
	}
}
