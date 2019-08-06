package com.cafe24.cat24.controller.api.front;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.service.OrdersService;
import com.cafe24.cat24.vo.OrdersVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("FrontOrdersAPIController")
@RequestMapping("api/v1/orders")
public class OrdersController 
{
		@Autowired
		private MessageSource messageSource;
	
		@Autowired
		private OrdersService ordersService;
	
		/** 주문신청 **/
		@ApiOperation(value="주문신청")
		@ApiImplicitParams({
			@ApiImplicitParam(name="orderVo", value="주문", required=true, dataType="OrderVo", defaultValue="")
		})
		@PostMapping("/")
		public ResponseEntity<JSONResult> add(@RequestBody OrdersVo orderVo) 
		{
			Boolean add = ordersService.add(orderVo);
			
			// 실패 했을 경우
			if(add == false)
			{
				String message = messageSource.getMessage("Fail.ordersVo", null, LocaleContextHolder.getLocale());
				JSONResult result = JSONResult.fail(message);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
			}
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(add));
		}
		
		/** 해당 주문내역 전체 조회 -_- **/
		@ApiOperation(value="해당 주문내역 전체 조회")
		@ApiImplicitParams({
			@ApiImplicitParam(name="id", value="회원아이디", required=true, dataType="String", defaultValue="")
		})
		@GetMapping("/{id}")
		public ResponseEntity<JSONResult> list(@PathVariable String id)
		{
			List<OrdersVo> list = ordersService.list();
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
		}
		
		/** 주문내역 갯수 -_- **/
		@ApiOperation(value="주문내역 갯수")
		@GetMapping("/{id}/count")
		public ResponseEntity<JSONResult> count()
		{
			Map<String, Integer> count = ordersService.count();
			
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(count));
		}
		
		/** 해당 주문내역 조회 -_- **/
		@ApiOperation(value="해당 주문내역 조회")
		@ApiImplicitParams({
			@ApiImplicitParam(name="id", value="회원아이디", required=true, dataType="String", defaultValue=""),
			@ApiImplicitParam(name="order_id", value="주문코드", required=true, dataType="String", defaultValue="")
		})
		@GetMapping("/{id}/{order_id}")
		public ResponseEntity<JSONResult> get(@PathVariable(value="id") String id, @PathVariable(value="order_id") String order_id)
		{
			OrdersVo orders = ordersService.get(id, order_id);
			
			//해당 아이디가 없을 경우
			if(orders == null)
			{
				String message = messageSource.getMessage("NotEmpty.usersVo.id", null, LocaleContextHolder.getLocale());
				JSONResult result = JSONResult.fail(message);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(orders));
		}
		
		
}
