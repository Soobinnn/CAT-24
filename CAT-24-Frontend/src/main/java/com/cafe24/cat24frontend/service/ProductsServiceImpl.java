package com.cafe24.cat24frontend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.cat24frontend.dto.JSONResponse;
import com.cafe24.cat24frontend.vo.ProductsVo;

@Service
public class ProductsServiceImpl implements ProductsService
{
	static final Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);
	
	/** 상품 전체 목록**/
	public List<ProductsVo> productlist()
	{
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<JSONResponse> result 
			= restTemplate.getForEntity("http://localhost:8080/CAT-24-Backend/api/v1/admin/products/", JSONResponse.class);
		
		List<ProductsVo> list = (List<ProductsVo>) result.getBody().getData();
		
		System.out.println("---------------------------------");
		System.out.println(list.toString());
		logger.info(result.toString());
		logger.info(result.getBody().getResult());
		
		return list;
	}
	
	/** 해당 상품 보기 **/
	public List<ProductsVo> get(Long product_no)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8080/CAT-24-Backend/api/v1/admin/products/" +product_no;
		ResponseEntity<JSONResponse> result 
			= restTemplate.getForEntity(url, JSONResponse.class);
		
		System.out.println(result.getBody().getData());
		System.out.println(result.getBody().getResult());
		
		List<ProductsVo> gets = (List<ProductsVo>) result.getBody().getData();
		
		
				
		System.out.println("---------------------------------");
		System.out.println(gets.toString());
		logger.info(result.toString());
		logger.info(result.getBody().getResult());
		
		
		return gets;
	}
}
