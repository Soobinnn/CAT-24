package com.cafe24.cat24.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.cat24.repository.OrdersDao;
import com.cafe24.cat24.vo.OrdersVo;

@Service
public class OrdersServiceImpl implements OrdersService
{
	@Autowired
	private OrdersDao ordersDao;
	
	/** 주문신청 **/
	public Boolean add(OrdersVo ordersVo)
	{
		return ordersDao.add(ordersVo);
	}
	
	/** 주문내역 전체 조회 -_- **/
	public List<OrdersVo> list()
	{
		return ordersDao.list();
	}
	
	/** 주문내역 갯수 -_- **/
	public Map<String, Integer> count()
	{
		Map<String, Integer> getcount = new HashMap<String,Integer>();
		int count = ordersDao.count();
		
		getcount.put("count", count);
		
		return getcount;
	}
	
	/** 해당 주문내역 조회 -_- **/
	public OrdersVo get(String id, String order_id)
	{
		return ordersDao.get(id, order_id);
	}
	
}
