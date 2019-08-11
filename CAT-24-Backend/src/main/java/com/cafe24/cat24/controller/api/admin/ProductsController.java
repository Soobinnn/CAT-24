package com.cafe24.cat24.controller.api.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.service.ProductsService;
import com.cafe24.cat24.vo.ProductsVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("productsAPIController")
@RequestMapping("api/v1/admin/products")
public class ProductsController 
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ProductsService productsService;

	
	/** 상품 전체 목록 **/
	@ApiOperation(value="상품 전체 목록")
	@GetMapping(value="/")
	public ResponseEntity<JSONResult> list() 
	{
		List<ProductsVo> list = productsService.list();
		
		// 상품이 아무것도 없을 경우
		if(list == null)
		{
			String message = messageSource.getMessage("NotEmpty.productsVo", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));

	}
	
	/** 상품 전체 갯수 **/
	@ApiOperation(value="상품 전체 갯수")
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> count()
	{
		Map<String, Integer> count = productsService.count();
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(count));
	}
	
	/** 해당 상품 조회 **/
	@ApiOperation(value="해당 상품 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="product_no", value="상품번호", required=true, dataType="long", defaultValue="")
	})
	@RequestMapping(value="/{product_no}", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> get(@PathVariable(value="product_no") Long product_no)
	{
		ProductsVo product = productsService.get(product_no);
		
		List<ProductsVo> list = new ArrayList<ProductsVo>();
		
		list.add(product);
		
		// 해당 상품이  없을 경우
		if(product == null)
		{
			String message = messageSource.getMessage("NotEmpty.productsVo.product_no", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/** 상품 등록 **/
	@ApiOperation(value="상품등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="productVo", value="상품등록", required=true, dataType="ProductsVo", defaultValue="")
	})
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<JSONResult> add(@RequestBody ProductsVo productVo) 
	{
		productsService.add(productVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productVo));
	}
	
	/** 상품 삭제 **/
	@ApiOperation(value="상품삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="product_no", value="상품번호", required=true, dataType="long", defaultValue="")
	})
	@DeleteMapping(value="/{product_no}")
	public ResponseEntity<JSONResult> delete(@PathVariable(value="product_no") Long product_no) 
	{
		Boolean del = productsService.delete(product_no);
		//해당 상품 번호가 없을 경우
		if(del == false)
		{
			String message = messageSource.getMessage("NotEmpty.productsVo.product_no", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(del));
	}
	
	/** 해당 상품 수정 **/
	@ApiOperation(value="상품수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="product_no", value="상품번호", required=true, dataType="long", defaultValue=""),
		@ApiImplicitParam(name="productsVo", value="상품수정",  required=true, dataType="ProductsVo", defaultValue="")
	})
	@PutMapping(value="/{product_no}")
	public ResponseEntity<JSONResult> update(@RequestBody ProductsVo productvo, @PathVariable(value="product_no") Long product_no)
	{
		Boolean update = productsService.update(productvo, product_no);
				
		//해당 상품 번호가 없을 경우
		if(update == false)
		{
			String message = messageSource.getMessage("NotEmpty.productsVo.product_no", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(update));
	}
}
