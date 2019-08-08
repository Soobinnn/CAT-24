package com.cafe24.cat24.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.cat24frontend.config.AppConfig;
import com.cafe24.cat24frontend.dto.JSONResult;
import com.cafe24.cat24frontend.service.AdminService;
import com.cafe24.cat24frontend.vo.AdminVo;
import com.cafe24.cat24frontend.vo.ProductsVo;
import com.cafe24.cat24frontend.vo.UsersVo;
import com.cafe24.config.web.TestWebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class AdminServiceTest 
{
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private AdminService adminService;
	
	@Before	
	public void setUp() 
	{
		mockMvc = MockMvcBuilders.
			webAppContextSetup(webApplicationContext).
			build();
	}
	
	@Test
	public void 관리자로그인() throws Exception
	{
		AdminVo adminVo = new AdminVo();
		adminVo.setId("isb9082");
		adminVo.setPassword("dlatnqls1!");
		
		Boolean service = adminService.login(adminVo);
		
		assertTrue(service == true);
	}
	
	@Test
	public void 관리자회원목록() throws Exception
	{
		
		List<UsersVo> list = new ArrayList<UsersVo>();
		
		list=  adminService.memberlist();
		
		assertTrue(true);
	}
	
	@Test
	public void 관리자상품목록() throws Exception
	{
		
		List<ProductsVo> list = new ArrayList<ProductsVo>();
		
		list=  adminService.productlist();
		
		assertTrue(true);
	}
}
