package com.cafe24.cat24frontend.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.cat24frontend.dto.JSONResponse;
import com.cafe24.cat24frontend.vo.UsersVo;


@Service
public class UserServiceImpl implements UserService
{
	static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
		
	/** 회원 등록 **/
	public Boolean join(UsersVo userVo)
	{
	
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<JSONResponse> result = restTemplate.postForEntity("http://localhost:8080/CAT-24-Backend/api/v1/users/", userVo, JSONResponse.class);
		
		System.out.println(result);
		 
		logger.info("test---------------------");
		logger.info(result.toString());
		logger.info(result.getBody().getResult());
//		logger.info(result.getBody().getMessage());
//		logger.info(result.getBody().getData().toString());
		
		
		 return true;
	}
}
