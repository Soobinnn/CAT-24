package com.cafe24.cat24.controller.api.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.service.UsersService;
import com.cafe24.cat24.vo.UsersVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/*@RestController("usersAPIController")
@RequestMapping("api/v1/admin/users")
public class UsersController 
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UsersService usersService;
	
	*//** 회원 전체 목록 **//*
	@RequestMapping(value="/",method = RequestMethod.GET)
	public  ResponseEntity<JSONResult> List(@RequestBody @Valid UsersVo userVo, BindingResult result)
	{
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userVo)); 
	}
}
*/