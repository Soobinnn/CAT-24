package com.cafe24.cat24.controller.api.front;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.service.CategoriesService;
import com.cafe24.cat24.vo.CategoriesVo;
import com.cafe24.cat24.vo.ProductsVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("FrontCategoriesAPIController")
@RequestMapping("/api/v1/categories")
public class CategoriesController 
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private CategoriesService categoriesService;
	
	
	/** 카테고리 전체 목록  **/
	@ApiOperation(value="카테고리 전체 목록")
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> list()
	{
		List<CategoriesVo> list = categoriesService.list(); 
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/** 카테고리 전체 갯수 **/
	@ApiOperation(value="카테고리 전체 갯수")
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> count()
	{
		Map<String, Integer> count = categoriesService.count();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(count));
	}
	
	/** 해당 카테고리 조회**/
	@ApiOperation(value="해당 카테고리 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="category_no", value="해당 카테고리 조회", required=true, dataType="Long", defaultValue="")
	})
	@RequestMapping(value="/{category_no}", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> get(@PathVariable(value="category_no") Long category_no)
	{

		CategoriesVo category = categoriesService.get(category_no);
		
		//해당 카테고리 번호가 없을 경우
		if(category == null)
		{
			String message = messageSource.getMessage("NotEmpty.categoriesVo.category_no", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(category));
	}
	
	/** 해당 카테고리 상품 조회 **/
	@ApiOperation(value="해당 카테고리 상품 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="category_no", value="해당 카테고리 조회", required=true, dataType="Long", defaultValue="")
	})
	@GetMapping(value="/{category_no}/products")
	public ResponseEntity<JSONResult> product(@PathVariable(value="category_no") Long category_no)
	{	
		List<ProductsVo> product = categoriesService.product(category_no);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(product));
	}
	
	/** 해당 카테고리 상품 갯수 **/
	@ApiOperation(value="해당 카테고리 상품 갯수")
	@ApiImplicitParams({
		@ApiImplicitParam(name="category_no", value="해당 카테고리 상품 갯수", required=true, dataType="Long", defaultValue="")
	})
	@GetMapping(value="/{category_no}/products/count")
	public ResponseEntity<JSONResult> productcount(@RequestBody CategoriesVo categoriesVo, @PathVariable(value="category_no") Long category_no)
	{
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(categoriesVo));
	}
	
	
}
