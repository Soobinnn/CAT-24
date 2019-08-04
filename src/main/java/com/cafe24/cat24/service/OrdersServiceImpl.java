package com.cafe24.cat24.service;

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
}
