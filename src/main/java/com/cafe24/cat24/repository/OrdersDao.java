package com.cafe24.cat24.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.cat24.vo.OrdersVo;

@Repository
public class OrdersDao 
{
	@Autowired
	private SqlSession sqlSession;
	
	/** 주문 등록 **/
	public Boolean add(OrdersVo ordersVo)
	{
		System.out.println(ordersVo);
		int count = sqlSession.insert("orders.insert",ordersVo);
		return 1 == count;
	}
}
