package com.cafe24.cat24.controller.api.front;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.vo.CartVo;

@RestController("FrontCartAPIController")
@RequestMapping("/api/v1/cart")
public class CartController 
{
	/** 장바구니 생성 **/
	@PostMapping("/")
	public ResponseEntity<JSONResult> add(@RequestBody CartVo cartVo)
	{
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(cartVo));
	}
	/** 해당 장바구니 조회 **/
	
}
