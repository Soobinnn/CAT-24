package com.cafe24.cat24frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class productController 
{
	/** 상품 리스트 **/
	@RequestMapping("/list")
	public String list(Model model)
	{
		return "product/list";
	}
}
