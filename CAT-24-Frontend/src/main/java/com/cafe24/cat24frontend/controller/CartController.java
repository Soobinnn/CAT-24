package com.cafe24.cat24frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController 
{
	@RequestMapping("/")
	public String list()
	{
		return "cart/list";
	}
}
