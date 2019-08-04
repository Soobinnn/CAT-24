package com.cafe24.cat24.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cafe24.cat24.vo.OrdersVo;


public interface OrdersService 
{
	/** 주문신청 **/
	public Boolean add(OrdersVo ordersVo);
	
	/** 주문내역 전체 조회 -_- **/
	public List<OrdersVo> list();
	
	/** 주문내역 갯수 -_- **/
	public Map<String, Integer> count();
	
	/** 해당 주문내역 조회 -_- **/
	public OrdersVo get(String id, String order_id);
}
