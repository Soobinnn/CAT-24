package com.cafe24.cat24.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.cat24.vo.CartVo;

@Repository
public class CartDao
{
	@Autowired
	private SqlSession sqlSession;
	
	/** 장바구니 생성 **/
	public Boolean add(CartVo cartVo)
	{
		int count = sqlSession.insert("cart.insert", cartVo);
		
		return 1 == count;
	}
	
	/** 해당 장바구니 조회**/
	public List<CartVo> list(String id)
	{
		List<CartVo> list = sqlSession.selectList("cart.list",id);
		return list;
	}
}
