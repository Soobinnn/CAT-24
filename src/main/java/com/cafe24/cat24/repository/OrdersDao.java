package com.cafe24.cat24.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	/** 주문내역 전체 조회 -_- **/
	public List<OrdersVo> list()
	{
		List<OrdersVo> list = sqlSession.selectList("orders.list");
		return list();
	}
	
	/** 주문내역 갯수 -_- **/
	public int count()
	{
		return sqlSession.selectOne("orders.count");
		
	}
	
	/** 해당 주문내역 조회 -_- **/
	public OrdersVo get(String id, String order_id)
	{
		Map<String, String> ordersGet = new HashMap<String,String>();
		ordersGet.put("id", id);
		ordersGet.put("order_id", order_id);
		return sqlSession.selectOne("orders.get", ordersGet);
	}
}
