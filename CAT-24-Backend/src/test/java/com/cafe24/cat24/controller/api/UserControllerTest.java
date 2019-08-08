package com.cafe24.cat24.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

import com.cafe24.config.web.TestWebConfig;
import com.cafe24.cat24.vo.UsersVo;
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
	public void 회원가입테스트() throws Exception 
	{
		UsersVo usersVo = new UsersVo();
		
		//1. 일반 회원가입 테스트
		usersVo.setId("isb9081");
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
		
		ResultActions resultActions =
		mockMvc
			.perform(post("/api/v1/users/")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(usersVo)));
	
		resultActions
		.andDo(print())
		.andExpect(status().isOk());
		
		//2. 이름예외처리 테스트 : length must be between 2 and 8
		/*usersVo.setId("isb908222");
		usersVo.setPassword("dlatnqls1!test");
		
		usersVo.setName("수");

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
		
		
		
		resultActions =
		mockMvc
			.perform(post("/api/v1/users/")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(usersVo)));
	
		resultActions
			.andDo(print())
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.result", is("fail")));

		
		//2. 패스워드 예외처리 테스트 : 
		usersVo.setId("isb908222");
		
		usersVo.setPassword( "isb90822019" );
		
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
		
		
		resultActions =
		mockMvc
			.perform(post("/api/v1/users/")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(usersVo)));
	
		resultActions
		.andExpect(status().isBadRequest())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")));
*/
		//3. 성별 예외처리 테스트 : 
		/*usersVo.setId("isb9082");
		usersVo.setPassword("dlatnqls1!test");
		usersVo.setName("soobin");
		
		usersVo.setGender("s");
		
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
		
		
		resultActions =
		mockMvc
			.perform(post("/api/v1/users/")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(usersVo)));
	
		resultActions
		.andExpect(status().isBadRequest())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")));*/
	}
	
	@Test
	public void 로그인테스트() throws Exception
	{
		UsersVo usersVo = new UsersVo();
		
		//1. 일반 로그인 테스트
		usersVo.setId("isb9082");
		usersVo.setPassword("dlatnqls1!test");
		
		ResultActions resultActions =
				mockMvc
					.perform(post("/api/v1/users/login")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(usersVo)));
		
		resultActions
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.result", is("success")));
		
		//2. 아이디 예외처리 테스트
		usersVo.setId(null);
		
		resultActions =
				mockMvc
					.perform(post("/api/v1/users/login")
							.contentType(MediaType.APPLICATION_JSON)
							.content(new Gson().toJson(usersVo)));
		
		resultActions
			.andDo(print())
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.result", is("fail")));
		
		//3. 비밀번호 예외처리 테스트
		usersVo.setId("isb9082");
		usersVo.setPassword(null);
		resultActions =
				mockMvc
					.perform(post("/api/v1/users/login")
							.contentType(MediaType.APPLICATION_JSON)
							.content(new Gson().toJson(usersVo)));
		
		resultActions
			.andDo(print())
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.result", is("fail")));
		
		
		//4. 아이디또는 패스워드 비일치 테스트
		usersVo.setId("isb9082");
		usersVo.setPassword("dlatnqls1!");
		
		resultActions =
				mockMvc
					.perform(post("/api/v1/users/login")
							.contentType(MediaType.APPLICATION_JSON)
							.content(new Gson().toJson(usersVo)));
		
		resultActions
			.andDo(print())
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.result", is("fail")));
		
	}
	@Test
	public void 아이디중복테스트() throws Exception
	{
		//1. 일반 케이스 테스트
		ResultActions resultActions =
				mockMvc
					.perform(get("/api/v1/users/check/isb9082")
						.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
			.andDo(print())
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.result", is("fail")));
		
		
		//2. 아이디 최소길이
		resultActions =
				mockMvc
					.perform(get("/api/v1/users/check/y")
						.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
			.andDo(print())
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.result", is("fail")));
		
	}
	
	
}
