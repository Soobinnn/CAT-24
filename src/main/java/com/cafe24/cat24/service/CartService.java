package com.cafe24.cat24.service;

import java.util.List;

import com.cafe24.cat24.vo.CartVo;

public interface CartService 
{
	/** 장바구니 생성 **/
	public Boolean add(CartVo cartVo);
	
	/** 해당 장바구니 조회**/
	public List<CartVo> list(String id); 
	
	
}
