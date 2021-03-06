package com.cafe24.cat24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.cat24.repository.CartDao;
import com.cafe24.cat24.vo.CartVo;

@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	private CartDao cartDao;
	
	/** 장바구니 생성 **/
	public Boolean add(CartVo cartVo)
	{
		return cartDao.add(cartVo);
	}
	
	/** 해당 장바구니 조회**/
	public List<CartVo> list(String id)
	{
		return cartDao.list(id);
	}
}
