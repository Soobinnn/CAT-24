package com.cafe24.cat24.service;

import com.cafe24.cat24.vo.CartVo;

public interface CartService 
{
	/** 장바구니 생성 **/
	public Boolean add(CartVo cartVo);
}
