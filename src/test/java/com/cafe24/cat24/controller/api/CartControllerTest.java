package com.cafe24.cat24.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.cafe24.cat24.vo.CartVo;
import com.cafe24.config.web.TestWebConfig;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class CartControllerTest 
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
	public void 장바구니등록() throws Exception
	{
		CartVo cartvo = new CartVo();
		
		cartvo.setAmount(10);
		cartvo.setBuy_YN("N");
		cartvo.setMember_YN("N");
		cartvo.setMember_no(1);
		cartvo.setProduct_no(1);
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/v1/cart/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(cartvo)));
				
				resultActions
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.result", is("success")));
				
	}
	@Test
	public void 해당장바구니조회() throws Exception
	{

		ResultActions resultActions =
				mockMvc
					.perform(get("/api/v1/cart/isb908222")
						.contentType(MediaType.APPLICATION_JSON));
				
				resultActions
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.result", is("success")));
				
	}
	
}
