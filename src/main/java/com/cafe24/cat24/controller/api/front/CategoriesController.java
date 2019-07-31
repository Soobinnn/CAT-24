package com.cafe24.cat24.controller.api.front;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.service.CategoriesService;
import com.cafe24.cat24.vo.CategoriesVo;

@RestController("FrontCategoriesAPIController")
@RequestMapping("/api/v1/categories")
public class CategoriesController 
{

	@Autowired
	private CategoriesService categoriesService;
	
	
	/** 카테고리 전체 조회**/
	@GetMapping(value="/")
	public ResponseEntity<JSONResult> list(@RequestBody CategoriesVo categoriesVo)
	{
		List<CategoriesVo> list = categoriesService.list(); 
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/** 카테고리 갯수 **/
	@GetMapping(value="/count")
	public ResponseEntity<JSONResult> count(@RequestBody CategoriesVo categoriesVo)
	{
		Map<String, Integer> count = categoriesService.count();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(count));
	}
	
	/** 해당 카테고리 조회**/
	@GetMapping(value="/{category_no}")
	public ResponseEntity<JSONResult> get(@PathVariable(value="category_no") Long category_no)
	{
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(category_no));
	}
	
	/** 해당 카테고리 상품 조회 **/
	@GetMapping(value="/{category_no}/products")
	public ResponseEntity<JSONResult> product(@RequestBody CategoriesVo categoriesVo, @PathVariable(value="category_no") Long category_no)
	{
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(categoriesVo));
	}
	
	/** 해당 카테고리 상품 갯수 **/
	@GetMapping(value="/{category_no}/products/count")
	public ResponseEntity<JSONResult> productcount(@RequestBody CategoriesVo categoriesVo, @PathVariable(value="category_no") Long category_no)
	{
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(categoriesVo));
	}
	
	
}
