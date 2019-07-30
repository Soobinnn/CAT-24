package com.cafe24.cat24.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
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
import com.cafe24.cat24.vo.ProductsVo;
import com.cafe24.config.web.TestWebConfig;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class ProductsController 
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
	@Ignore
	public void 상품등록() throws Exception
	{
		ProductsVo productsvo = new ProductsVo();
		
		productsvo.setProduct_code("code1");
		productsvo.setCustom_product_code("custom1");
		productsvo.setProduct_name("캣타워");
		productsvo.setModel_name("cattower01");
		productsvo.setCost_price(110000);
		productsvo.setSelling_price(330000);
		productsvo.setSummary("고양이들이 좋아하는 캣타워");
		productsvo.setDetail("고양이들이 좋아하는 캣타워 인기만점 1234567890");
		productsvo.setSell_yn("N");
		productsvo.setDiscount_yn("N");
		productsvo.setCategory_no(1);
		
		ResultActions resultActions =
				mockMvc
				.perform(post("/api/v1/admin/products/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(productsvo)));
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")));
	}
	
	@Test
	public void 상품전체조회() throws Exception
	{
		ResultActions resultActions =
				mockMvc
				.perform(get("/api/v1/admin/products/")
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result", is("success")));
			
	}
	
	@Test
	public void 상품전체갯수() throws Exception
	{
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/v1/admin/products/count")
					.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result", is("success")));
	}
	
	@Test
	public void 해당상품조회() throws Exception
	{
		// 일반 케이스
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/v1/admin/products/2")
					.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result", is("success")));
				
		// 없을 경우
		resultActions =
				mockMvc
					.perform(get("/api/v1/admin/products/5")
					.contentType(MediaType.APPLICATION_JSON));
				
		resultActions
		.andDo(print())
		.andExpect(status().isBadRequest());
	}
	
}
