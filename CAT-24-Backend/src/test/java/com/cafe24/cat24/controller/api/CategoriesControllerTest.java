package com.cafe24.cat24.controller.api;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.cafe24.cat24.vo.CategoriesVo;
import com.cafe24.config.web.TestWebConfig;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class CategoriesControllerTest 
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
	public void 카테고리등록() throws Exception
	{
		CategoriesVo categoriesvo = new CategoriesVo();
		
		categoriesvo.setCategory_depth(0);
		categoriesvo.setParent_category_no(0);
		categoriesvo.setCategory_name("테스트43");
		categoriesvo.setFull_category_name("테스트43");
		categoriesvo.setFull_category_no("0");
		categoriesvo.setRoot_category_no(0);
		categoriesvo.setReg_id("soobin");
		categoriesvo.setUpdate_id("soobin");
		
		ResultActions resultActions =
		mockMvc
			.perform(post("/api/v1/admin/categories/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(categoriesvo)));
		
		resultActions
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result", is("success")));
	}
	
	@Test
	@Ignore
	public void 카테고리전체조회() throws Exception
	{
		ResultActions resultActions =
				mockMvc
				.perform(get("/api/v1/admin/categories/")
				.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result", is("success")));
			
	}
	
	@Test
	@Ignore
	public void 카테고리전체갯수() throws Exception
	{
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/v1/admin/categories/count")
					.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result", is("success")));
	}
	
	@Test
	@Ignore
	public void 해당카테고리조회() throws Exception
	{
		// 일반 케이스
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/v1/admin/categories/3")
					.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result", is("success")));
		
		// 없을 경우
		resultActions =
				mockMvc
					.perform(get("/api/v1/admin/categories/1")
					.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
		.andDo(print())
		.andExpect(status().isBadRequest());
	}
	
	@Test
	@Ignore
	public void 해당카테고리삭제() throws Exception
	{
		// 일반 케이스
				ResultActions resultActions =
						mockMvc
							.perform(delete("/api/v1/admin/categories/9")
							.contentType(MediaType.APPLICATION_JSON));
				
				/*resultActions
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.result", is("success")));*/
				resultActions
				.andDo(print())
				.andExpect(status().isBadRequest());
	}
	
	@Test
	@Ignore
	public void 해당카테고리수정() throws Exception
	{
		CategoriesVo categoriesvo = new CategoriesVo();
		
		categoriesvo.setCategory_depth(0);
		categoriesvo.setParent_category_no(0);
		categoriesvo.setCategory_name("테스트33");
		categoriesvo.setFull_category_name("테스트33");
		categoriesvo.setFull_category_no("0");
		categoriesvo.setRoot_category_no(0);
		categoriesvo.setReg_id("soobin");
		categoriesvo.setUpdate_id("soobin");
		
		// 일반 케이스
				ResultActions resultActions =
						mockMvc
							.perform(put("/api/v1/admin/categories/1")
							.contentType(MediaType.APPLICATION_JSON)
							.content(new Gson().toJson(categoriesvo)));
						
				resultActions
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.result", is("success")));
	}
}
