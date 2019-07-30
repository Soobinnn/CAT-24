package com.cafe24.cat24.controller.api.admin;

import java.util.List;

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

@RestController("productsAPIController")
@RequestMapping("api/v1/admin/product")
public class ProductsController 
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ProductsService productsService;

	/** 상품 전체 목록 **/
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
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> count(@RequestBody  ProductsVo productVo)
	{
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productVo));
	}
	
	/** 해당 상품 조회 **/
	@RequestMapping(value="/{product_no}", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> get(@PathVariable(value="product_no") Long product_no)
	{
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null));
	}
	
	/** 상품 등록 **/
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<JSONResult> add(@RequestBody ProductsVo productVo) 
	{
		productsService.add(productVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productVo));
	}
	
	/** 상품 삭제 **/
	@DeleteMapping(value="/{product_no}")
	public JSONResult delete(@PathVariable(value="no") Long no, @RequestParam String password) {
		Boolean result = false;
		//boolean result = guestbookService.deleteContent();
		return JSONResult.success(result ? no : -1);
	}
	
	/** 해당 상품 수정 **/
	@PutMapping(value="/{product_no}")
	public JSONResult update(@RequestBody ProductsVo productVo) 
	{
		//guestbookService.writeContent(guestbookVo);
		return JSONResult.success(productVo);
	}
}
