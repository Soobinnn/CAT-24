package com.cafe24.cat24.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.cat24.vo.CategoriesVo;

@Repository
public class CategoriesDao 
{

	@Autowired
	private SqlSession sqlSession;
	
	/** 카테고리 등록**/
	public Boolean add(CategoriesVo categoriesvo)
	{
		int count = sqlSession.insert("categories.insert",categoriesvo);
		return 1 == count;
	}
	
	/** 카테고리 전체목록 **/
	public List<CategoriesVo> list()
	{
		List<CategoriesVo> list = sqlSession.selectList("categories.list");
		return list;
	}
	/** 카테고리 전체 갯수 **/
	public int count()
	{
		return sqlSession.selectOne("categories.count");
	}
	
	/** 해당 카테고리 조회 **/
	public CategoriesVo get(long category_no)
	{
		return sqlSession.selectOne("categories.get", category_no);
	}
}
