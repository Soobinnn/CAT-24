package com.cafe24.cat24.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.service.CategoriesService;
import com.cafe24.cat24.vo.CategoriesVo;

@RestController("categoriesAPIController")
@RequestMapping("/api/v1/admin/categories")
public class CategoriesController 
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private CategoriesService categoriesService;
	
	
	/** 카테고리 전체 목록  **/
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> list()
	{
		List<CategoriesVo> list = categoriesService.list(); 
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
	}
	
	/** 카테고리 전체 갯수 **/
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public ResponseEntity<JSONResult> count()
	{
		Map<String, Integer> count = categoriesService.count();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(count));
	}
	
	/** 해당 카테고리 조회 **/
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
	
	/** 카테고리 등록 **/
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<JSONResult> add(@RequestBody CategoriesVo categoriesVo)
	{
		categoriesService.add(categoriesVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(categoriesVo));
	}
	
	/** 해당 카테고리 수정 **/
	@RequestMapping(value="/{category_no}", method=RequestMethod.PUT)
	public ResponseEntity<JSONResult> update(@RequestBody CategoriesVo categoriesVo, @PathVariable(value="category_no") Long category_no)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(categoriesVo));
	}
	
	/** 해당 카테고리 삭제 **/
	@RequestMapping(value="/{category_no}", method=RequestMethod.DELETE)
	public ResponseEntity<JSONResult> delete(@PathVariable(value="category_no") Long category_no)
	{
		Boolean del = categoriesService.delete(category_no);
		
		//해당 카테고리 번호가 없을 경우
		if(del == false)
		{
			String message = messageSource.getMessage("NotEmpty.categoriesVo.category_no", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(del));
	}
	
}
