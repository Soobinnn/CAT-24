package com.cafe24.cat24.controller.api.front;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.service.UsersService;
import com.cafe24.cat24.vo.UsersVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("userAPIController")
@RequestMapping("api/v1/users")
public class UsersController 
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UsersService usersService;
	
	/** 회원 전체 목록 **/
	@RequestMapping(value="/",method = RequestMethod.GET)
	public  ResponseEntity<JSONResult> List(@RequestBody @Valid UsersVo userVo, BindingResult result)
	{
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userVo)); 
	}
	
	/** 회원 등록 **/
	@ApiOperation(value="회원가입")
	@ApiImplicitParams({
		@ApiImplicitParam(name="join", value="회원가입", required=true, dataType="string", defaultValue="")
	})
	@PostMapping(value="/")
	public ResponseEntity<JSONResult> join(@RequestBody @Valid UsersVo usersVo, BindingResult result) 
	{
		usersService.join(usersVo);
		
		if( result.hasErrors() ) 
		{
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) 
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage())); 
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(usersVo)); 
	}
	
	/** 로그인 **/
	@PostMapping(value="/login")
	public ResponseEntity<JSONResult> login(@RequestBody UsersVo userVo) 
	{
		
		Validator validator = 
				Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<UsersVo>> validatorResults = 
				validator.validateProperty(userVo, "email");
		
		if(validatorResults.isEmpty() == false) 
		{
			for(ConstraintViolation<UsersVo> validatorResult : validatorResults) 
			{
				//String message = validatorResult.getMessage();
				String message = messageSource.getMessage("Email.userVo.email", null, LocaleContextHolder.getLocale());
				JSONResult result = JSONResult.fail(message);
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null)); 
	}
	
	/** 로그아웃 **/
	@PostMapping(value="/logout")
	public ResponseEntity<JSONResult> logout(@RequestBody UsersVo userVo) 
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null)); 
	}
}