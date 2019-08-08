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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.service.AdminService;
import com.cafe24.cat24.vo.AdminVo;
import com.cafe24.cat24.vo.UsersVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("adminAPIController")
@RequestMapping("api/v1/admin/admins")
public class AdminsController 
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private AdminService adminService;
	
	/** 관리자 로그인 **/
	@ApiOperation(value=" 관리자 로그인")
	@ApiImplicitParams({
		@ApiImplicitParam(name="adminVo", value="관리자 로그인", required=true, dataType="AdminVo", defaultValue="")
	})
	@PostMapping(value="/login")
	public ResponseEntity<JSONResult> login(@RequestBody AdminVo adminVo) 
	{
		
		Validator validator = 
				Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<AdminVo>> validatorResults = 
				validator.validateProperty(adminVo, "id");

		if(validatorResults.isEmpty() == false) 
		{
			for(ConstraintViolation<AdminVo> validatorResult : validatorResults) 
			{
				//String message = validatorResult.getMessage();
				String message = messageSource.getMessage("NotEmpty.usersVo.id_password", null, LocaleContextHolder.getLocale());
				JSONResult result = JSONResult.fail(message);
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
			}
		}
		
		AdminVo vo= adminService.login(adminVo);
		
		if(vo==null)
		{
			String message = messageSource.getMessage("Fail.usersVo.id_password", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		Map<String, Object> info = new HashMap<String,Object>(); 
		
		info.put("id",adminVo.getId());
		info.put("name", vo.getName());
		info.put("used_YN",vo.getUsed_YN());
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(info)); 
	}
	
	
	/** 관리자 가입 **//*
	@ApiOperation(value="회원가입")
	@ApiImplicitParams({
		@ApiImplicitParam(name="join", value="회원가입", required=true, dataType="string", defaultValue="")
	})
	@PostMapping(value="/join")
	public ResponseEntity<JSONResult> join(@RequestBody @Valid UsersVo userVo, BindingResult result) 
	{
		if( result.hasErrors() ) 
		{
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) 
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage())); 
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userVo)); 
	}*/
}
