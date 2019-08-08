package com.cafe24.cat24frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.cat24frontend.service.CategoriesService;
import com.cafe24.cat24frontend.service.ProductsService;
import com.cafe24.cat24frontend.vo.CategoriesVo;
import com.cafe24.cat24frontend.vo.ProductsVo;

@Controller
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	private CategoriesService categoriesService;
	
	@Autowired
	private ProductsService productsService;
	
	/** 상품 리스트 **/
	@RequestMapping("/list")
	public String list(Model model)
	{
		// 카테고리 목록
		List<CategoriesVo> categorylist = categoriesService.categorylist();
		
		// 상품 전체 목록
		List<ProductsVo> productlist =  productsService.productlist();
		
		model.addAttribute("categorylist", categorylist);
		
		model.addAttribute("productlist", productlist);
		
		return "product/list";
	}
}
