package com.cafe24.cat24.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

import com.cafe24.config.web.TestWebConfig;
import com.cafe24.cat24.vo.UserVo;
import com.google.gson.Gson;
import com.cafe24.cat24.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class UserControllerTest 
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
	public void testHomePage() throws Exception
	{
		ResultActions resultActions = mockMvc.perform(get("/api/users/list"))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void 회원가입테스트() throws Exception 
	{
		UserVo userVo = new UserVo();
		
		//1. 일반 회원가입 테스트
		userVo.setName("임수빈");
		userVo.setEmail("isb9082@gmail.com");
		userVo.setPassword( "dlatnqls1!test" );
		userVo.setGender( "NONE" );
		
		ResultActions resultActions =
		mockMvc
			.perform(post("/api/users/join")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(userVo)));
	
		resultActions
		.andDo(print())
		.andExpect(status().isOk());
		
		//2. 이름예외처리 테스트 : length must be between 2 and 8
		userVo.setName("수");
		userVo.setEmail("isb9082@gmail.com");
		userVo.setPassword( "isb90822019!" );
		userVo.setGender( "MALE" );
		
		resultActions =
		mockMvc
			.perform(post("/api/users/join")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(userVo)));
	
		resultActions
		.andDo(print())
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.result", is("fail")));

		
		//2. 패스워드 예외처리 테스트 : 
		userVo.setName("임수빈");
		userVo.setEmail("isb9082@gmail.com");
		userVo.setPassword( "isb90822019" );
		userVo.setGender( "MALE" );
		
		resultActions =
		mockMvc
			.perform(post("/api/users/join")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(userVo)));
	
		resultActions
		.andExpect(status().isBadRequest())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")));

		//3. 성별 예외처리 테스트 : 
		userVo.setName("임수빈");
		userVo.setEmail("kickscar@gmail.com");
		userVo.setPassword( "isb90822019!" );
		userVo.setGender( "s" );
		
		resultActions =
		mockMvc
			.perform(post("/api/users/join")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(userVo)));
	
		resultActions
		.andExpect(status().isBadRequest())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")));
	}
	
	@Test
	public void 로그인테스트() throws Exception
	{
		UserVo userVo = new UserVo();
		//1. 일반 로그인 테스트
		userVo.setEmail("isb9082@naver.com");
		userVo.setPassword("dlatnqls1!test");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/users/login")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(userVo)));
		
		resultActions
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result", is("success")));
		
		//2. 이메일 예외처리 테스트
		userVo.setEmail("isb9082");
		userVo.setPassword("dlatnqls1!test");
		
		resultActions =
				mockMvc
					.perform(post("/api/users/login")
							.contentType(MediaType.APPLICATION_JSON)
							.content(new Gson().toJson(userVo)));
		
		resultActions
			.andDo(print())
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.result", is("fail")));
		
	}
}
