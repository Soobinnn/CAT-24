package com.cafe24.cat24.service;

import org.springframework.stereotype.Service;

import com.cafe24.cat24.vo.OrdersVo;


public interface OrdersService 
{
	/** 주문신청 **/
	public Boolean add(OrdersVo ordersVo);
}
