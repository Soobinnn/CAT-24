package com.cafe24.cat24.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.vo.ProductVo;

@RestController("cartAPIController")
@RequestMapping("/v1/cart")
public class CartController 
{
	@RequestMapping(value="/list/{lastNo}", method=RequestMethod.GET)
	public JSONResult list(@PathVariable(value="lastNo") Long lastNo) {
		//List<GuestbookVo> list = guestbookService.getContentList(lastNo);
		return JSONResult.success(null);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public JSONResult add(@RequestBody ProductVo productVo) {
		//guestbookService.writeContent(guestbookVo);
		return JSONResult.success(productVo);
	}
	
	//@RequestMapping(value="/{no}", method=RequestMethod.DELETE)
	@DeleteMapping(value="/{no}")
	public JSONResult delete(@PathVariable(value="no") Long no, @RequestParam String password) {
		Boolean result = false;
//		boolean result = guestbookService.deleteContent();
		return JSONResult.success(result ? no : -1);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public JSONResult update(@RequestBody ProductVo productVo) {
		//guestbookService.writeContent(guestbookVo);
		return JSONResult.success(productVo);
	}
}
