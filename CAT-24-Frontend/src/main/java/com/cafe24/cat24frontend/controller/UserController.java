package com.cafe24.cat24frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.cat24frontend.service.UserService;
import com.cafe24.cat24frontend.vo.UsersVo;

@Controller
@RequestMapping("/user")
public class UserController 
{
	static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/** 로그인 페이지 **/
	@GetMapping("/login")
	public String login()
	{
		return "user/login";
	}
	
	/** 회원가입 페이지 **/
	@GetMapping("/join")
	public String join()
	{
		return "user/join";
	}
	
	/** 회원가입 **/
	@PostMapping("/join")
	public String join(@ModelAttribute UsersVo userVo)
	{
		logger.info(userVo.toString());
		
		userService.join(userVo);
		
		return "user/login";
	}
	
	/** 로그인 **/
	@PostMapping("/login")
	public String login(@ModelAttribute UsersVo userVo)
	{
		logger.info(userVo.toString());
		
		userService.login(userVo);
		
		return "main/index";
	}
}
