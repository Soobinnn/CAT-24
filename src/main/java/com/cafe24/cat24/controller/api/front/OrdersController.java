package com.cafe24.cat24.controller.api.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.service.OrdersService;
import com.cafe24.cat24.vo.OrdersVo;

@RestController("FrontOrdersAPIController")
@RequestMapping("api/v1/orders")
public class OrdersController 
{
	/*	@Autowired
		private OrdersService orderService;
	
		*//** 주문내역 전체 조회**//*
		@GetMapping("/{id}")
		public ResponseEntity<JSONResult> list(@PathVariable long id)
		{
			List<OrdersVo> list = ordersService.list();
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
		}
		
		*//** 주문내역 갯수 **//*
		@GetMapping("/{id}/count")
		*//** 해당 주문내역 조회**//*
		@GetMapping("/{id}/{order_id}")*/
}
