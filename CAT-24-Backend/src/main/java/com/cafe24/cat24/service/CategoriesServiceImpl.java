package com.cafe24.cat24.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.cat24.repository.CategoriesDao;
import com.cafe24.cat24.vo.CategoriesVo;
import com.cafe24.cat24.vo.ProductsVo;

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
	public Map<String, Integer> count()
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int count = categoriesDao.count();
		
		map.put("count", count);
		
		return map;
	}
	
	/** 해당 카테고리 조회 **/
	public CategoriesVo get(long category_no)
	{
		return categoriesDao.get(category_no);
	}	
	
	/** 해당 카테고리 삭제 **/
	public Boolean delete(Long category_no)
	{
		return categoriesDao.delete(category_no);
	}
	
	/** 해당 카테고리 수정 **/
	public Boolean update(CategoriesVo categoriesVo, int category_no)
	{
		categoriesVo.setCategory_no(category_no);
		
		return categoriesDao.update(categoriesVo);
	}
	
	/** 해당 카테고리 상품 조회 **/
	public List<ProductsVo> product(Long category_no)
	{
		return categoriesDao.product(category_no);
	}
	
}
