package com.cafe24.cat24.controller.api.front;

import java.util.List;

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
import com.cafe24.cat24.service.CartService;
import com.cafe24.cat24.vo.CartVo;

@RestController("FrontCartAPIController")
@RequestMapping("/api/v1/cart")
public class CartController 
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private CartService cartService;
	
	/** 장바구니 생성 **/
	@PostMapping("/")
	public ResponseEntity<JSONResult> add(@RequestBody CartVo cartVo)
	{
		Boolean add =cartService.add(cartVo);
		
		// 실패 했을 경우
		if(add == false)
		{
			String message = messageSource.getMessage("Fail.cartVo", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(add));
	}
	
	
	/** 해당 장바구니 조회 **/
	@GetMapping("/{id}")
	public ResponseEntity<JSONResult> list(@PathVariable String id)
	{
		List<CartVo> list = cartService.list(id);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(cartVo));
	}
}
