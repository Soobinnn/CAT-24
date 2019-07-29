package com.cafe24.cat24.controller.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.vo.ProductVo;

@RestController("productAPIController")
@RequestMapping("api/v1/product")
public class ProductController 
{
	/** 상품 전체 목록 **/
	@RequestMapping(value="/", method=RequestMethod.GET)
	public JSONResult list(@PathVariable(value="lastNo") Long lastNo) 
	{
		//List<GuestbookVo> list = guestbookService.getContentList(lastNo);
		return JSONResult.success(null);
	}
	
	/** 상품 전체 갯수 **/
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> count(@RequestBody  ProductVo productVo)
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
	public JSONResult add(@RequestBody ProductVo productVo) 
	{
		//guestbookService.writeContent(guestbookVo);
		return JSONResult.success(productVo);
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
	public JSONResult update(@RequestBody ProductVo productVo) 
	{
		//guestbookService.writeContent(guestbookVo);
		return JSONResult.success(productVo);
	}
}
