package com.cafe24.cat24frontend.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.cat24frontend.vo.UsersVo;
import com.google.gson.Gson;
@Service
public class UserServiceImpl implements UserService
{
	static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/** 회원 등록 **/
	public Boolean join(UsersVo userVo)
	{
		
		RestTemplate restTemplate = new RestTemplate();
	    
		HttpHeaders headers = new HttpHeaders();
		
			String param = new Gson().toJson(userVo);
			
		 HttpEntity<String> entity = new HttpEntity<String>(param, headers);
	    
		
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 
		 
		 logger.info(entity.toString());
		 ResponseEntity<String> result = restTemplate.exchange("http://localhost:8080/CAT-24-Backend/api/v1/users/", HttpMethod.POST, entity,  String.class);
		 
		 logger.info(result.getBody().toString());
		 
		 return true;
	}
}
