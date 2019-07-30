package com.cafe24.cat24.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.cat24.vo.ProductsVo;

@Repository
public class ProductsDao 
{
	@Autowired
	private SqlSession sqlSession;
	
	/** 상품 전체목록 **/
	public List<ProductsVo> list() 
	{
		List<ProductsVo> list = sqlSession.selectList("products.list");
		return list;
	}
	
	/** 상품 등록 **/
	public Boolean add(ProductsVo productVo)
	{
		int count = sqlSession.insert("products.insert",productVo);
		return 1 == count;
	}
	
	/** 상품 전체 갯수 **/
	public int count()
	{
		return sqlSession.selectOne("products.count");
	}
	
	/** 해당 상품 조회 **/
	public ProductsVo get(Long product_no)
	{
		return sqlSession.selectOne("products.get",product_no);
	}
	
	/** 해당 상품 삭제 **/
	public Boolean delete(Long product_no)
	{
		int del = sqlSession.delete("products.delete",product_no);
		return del == 1;
	}
	
}
