package com.cafe24.cat24frontend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.cat24frontend.dto.JSONResponse;
import com.cafe24.cat24frontend.vo.AdminVo;

@Service
public class AdminServiceImpl implements AdminService
{
	static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	/** 로그인  **/
	public Boolean login(AdminVo adminVo)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<JSONResponse> result 
			= restTemplate.postForEntity("http://localhost:8080/CAT-24-Backend/api/v1/admin/admins/login", adminVo, JSONResponse.class);
		
		System.out.println(result);

		logger.info(result.toString());
		logger.info(result.getBody().getResult());
//		logger.info(result.getBody().getMessage());
//		logger.info(result.getBody().getData().toString());
		
		
		 return true;
	}
	
}
