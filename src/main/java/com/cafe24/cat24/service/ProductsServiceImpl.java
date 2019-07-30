package com.cafe24.cat24.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.cat24.repository.ProductsDao;
import com.cafe24.cat24.vo.ProductsVo;

@Service
public class ProductsServiceImpl implements ProductsService 
{
	@Autowired
	private ProductsDao productsDao;
	
	/** 상품 전체 목록 **/
	public List<ProductsVo> list() 
	{
		return productsDao.list(); 
	}
	
	/** 상품 등록 **/
	public Boolean add(ProductsVo productVo)
	{
		return productsDao.add(productVo);
	}
	
	/** 상품 전체 갯수 **/
	public Map<String,Integer> count()
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int count = productsDao.count();
		
		map.put("count", count);
		
		return map;
	}
	
	/** 해당 상품 조회 **/
	public ProductsVo get(Long product_no)
	{
		return productsDao.get(product_no);
	}
	
	/** 해당 상품 삭제 **/
	public Boolean delete(Long product_no)
	{
		return productsDao.delete(product_no);
	}
	
	/** 해당 카테고리 수정 **/
	public Boolean update(ProductsVo productvo, Long product_no)
	{
		productvo.setProduct_no(product_no);
		
		return productsDao.update(productvo);
	}
	
}
