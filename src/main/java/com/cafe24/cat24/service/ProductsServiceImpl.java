package com.cafe24.cat24.service;

import java.util.List;

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
}
