package com.cafe24.cat24frontend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.cat24frontend.dto.JSONResponse;
import com.cafe24.cat24frontend.vo.CategoriesVo;
import com.cafe24.cat24frontend.vo.ProductsVo;

@Service
public class CategoriesServiceImpl implements CategoriesService
{
	static final Logger logger = LoggerFactory.getLogger(CategoriesServiceImpl.class);
	
	/** 카테고리 목록**/
	public List<CategoriesVo> categorylist()
	{
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<JSONResponse> result 
			= restTemplate.getForEntity("http://localhost:8080/CAT-24-Backend/api/v1/categories/", JSONResponse.class);
		
		List<CategoriesVo> list = (List<CategoriesVo>) result.getBody().getData();
		
		
		System.out.println("---------------------------------");
		System.out.println(list.toString());
		logger.info(result.toString());
		logger.info(result.getBody().getResult());
		
		return list;
	}
	
	/** 해당 카테고리 상품 조회 **/
	public List<ProductsVo> product(Long category_no)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8080/CAT-24-Backend/api/v1/categories/" + category_no + "/products";
		
		ResponseEntity<JSONResponse> result 
			= restTemplate.getForEntity(url, JSONResponse.class);
		
		List<ProductsVo> list = (List<ProductsVo>) result.getBody().getData();
		

		System.out.println("---------------------------------");
		System.out.println(list.toString());
		logger.info(result.toString());
		logger.info(result.getBody().getResult());
		
		return list;
	}
}
