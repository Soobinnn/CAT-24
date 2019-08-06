package com.cafe24.cat24.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

import com.cafe24.cat24.config.AppConfig;
import com.cafe24.cat24.vo.OrdersVo;
import com.cafe24.config.web.TestWebConfig;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class OrdersControllerTest 
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
	
	@Test
	public void 주문등록() throws Exception
	{
		OrdersVo ordersvo = new OrdersVo();
		
		ordersvo.setOrder_no("20190804-111112");
		ordersvo.setDelivery_no(1);
		ordersvo.setTotal_sum(11000);
		ordersvo.setAccess_YN("N");
		ordersvo.setUnmember_password("1211134");
		ordersvo.setMember_no(1);
		
		
		ResultActions resultActions =
		mockMvc
		.perform(post("/api/v1/orders/")
		.contentType(MediaType.APPLICATION_JSON)
		.content(new Gson().toJson(ordersvo)));

resultActions
.andDo(print())
.andExpect(status().isOk())
.andExpect(jsonPath("$.result", is("success")));
	}
}
