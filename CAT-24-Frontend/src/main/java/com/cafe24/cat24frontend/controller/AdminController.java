package com.cafe24.cat24frontend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.cat24frontend.dto.JSONResult;
import com.cafe24.cat24frontend.service.AdminService;
import com.cafe24.cat24frontend.vo.AdminVo;
import com.cafe24.cat24frontend.vo.UsersVo;

@Controller
@RequestMapping("/admin")
public class AdminController 
{
	static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	/** 관리자 페이지**/
	@RequestMapping("/")
	public String list()
	{
		return "admin/admin";
	}
	
	/** 관리자 로그인 페이지**/
	@GetMapping("/login")
	public String login()
	{
		return "admin/login";
	}
	
	/** 관리자 로그인**/
	@PostMapping("/login")
	public String login(@ModelAttribute AdminVo adminVo)
	{
		logger.info(adminVo.toString());
		
		adminService.login(adminVo);

		return "admin/admin";
	}
	
	/** 관리자 회원목록**/
	@RequestMapping("/memberlist")
	public String memberList(Model model)
	{
		List<UsersVo> memberlist = adminService.memberlist();
		
		model.addAttribute("memberlist",memberlist);
		return "admin/memberList";
	}
	
	
	/** 관리자 상품목록**/
	@RequestMapping("/productlist")
	public String productList()
	{
		return "admin/productList";
	}
	
	/** 관리자 상품등록 페이지 **/
	@RequestMapping("/productregister")
	public String productRegister()
	{
		return "admin/productRegister";
	}

}
