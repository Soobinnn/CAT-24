package com.cafe24.cat24.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.cat24frontend.config.AppConfig;
import com.cafe24.cat24frontend.service.UserService;
import com.cafe24.cat24frontend.vo.UsersVo;
import com.cafe24.config.web.TestWebConfig;
import com.google.gson.Gson;

import static org.junit.Assert.assertTrue;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class UserServiceTest 
{
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before	
	public void setUp() 
	{
		mockMvc = MockMvcBuilders.
			webAppContextSetup(webApplicationContext).
			build();
	}
	
	@Autowired
	private UserService userService;
	
	@Test
	public void 회원가입서비스테스트() throws Exception 
	{
		UsersVo usersVo = new UsersVo();
		
		//1. 일반 회원가입 테스트
		usersVo.setId("bin0918");
		usersVo.setPassword("dlatnqls1!test");
		usersVo.setName("soobin");
		usersVo.setGender("M");
		usersVo.setZipcode("0000-0000");
		usersVo.setAddress("서울특별시 서초구");
		usersVo.setAddress_detail("반포동");
		usersVo.setHome_number("02-587-9082");
		usersVo.setPhone("010-3449-0918");
		usersVo.setEmail("isb9082@gmail.com");
		usersVo.setProfile("profile.jpg");
		usersVo.setBlacklist("N");
		usersVo.setLast_date("2019-07-31");
		usersVo.setUsed_YN("N");
		usersVo.setUpdate_id("isb9082");
		
		Boolean service = userService.join(usersVo);
		
		assertTrue(service == true);
		
		//1. 예외처리
		usersVo.setId("test");
		usersVo.setPassword("dt");
		usersVo.setName("soobin");
		usersVo.setGender("M");
		usersVo.setZipcode("0000-0000");
		usersVo.setAddress("서울특별시 서초구");
		usersVo.setAddress_detail("반포동");
		usersVo.setHome_number("02-587-9082");
		usersVo.setPhone("010-3449-0918");
		usersVo.setEmail("isb9082@gmail.com");
		usersVo.setProfile("profile.jpg");
		usersVo.setBlacklist("N");
		usersVo.setLast_date("2019-07-31");
		usersVo.setUsed_YN("N");
		usersVo.setUpdate_id("isb9082");
		
		service = userService.join(usersVo);
		
		assertTrue(service == true);
	}
	
}
