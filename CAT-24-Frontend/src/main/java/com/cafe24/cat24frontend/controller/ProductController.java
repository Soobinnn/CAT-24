package com.cafe24.cat24frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/** 해당 상품 보기 **/
	@RequestMapping("/list/{product_no}")
	public String get( @PathVariable( "product_no" ) Long product_no, Model model )
	{
		// 해당 상품 목록
		List<ProductsVo> get = productsService.get(product_no);
		
		// 카테고리 목록
		List<CategoriesVo> categorylist = categoriesService.categorylist();
		
		System.out.println("test");
		System.out.println(get);
		
		model.addAttribute("get",get);
		
		model.addAttribute("categorylist", categorylist);
		
		return "product/detail";
	}
	
	/** 해당 카테고리 상품 조회 **/
	@RequestMapping("/list/category/{category_no}")
	public String product(@PathVariable("category_no") Long category_no, Model model)
	{
		// 카테고리 목록
		List<CategoriesVo> categorylist = categoriesService.categorylist();
			
		// 해당 상품 목록
		List<ProductsVo> productlist =  categoriesService.product(category_no);
		
		model.addAttribute("categorylist", categorylist);
		
		model.addAttribute("productlist", productlist);
		
		return "product/list";
	}
	


}
