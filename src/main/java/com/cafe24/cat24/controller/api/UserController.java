package com.cafe24.cat24.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.cat24.dto.JSONResult;
import com.cafe24.cat24.vo.UserVo;

@RestController("userAPIController")
@RequestMapping("/api/users")
public class UserController 
{
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String List(Model model)
	{
		return "user/helloworld";
	}
	
	/** 회원가입 **/
	@PostMapping(value="/join")
	public ResponseEntity<JSONResult> join(@RequestBody @Valid UserVo userVo, BindingResult result) 
	{
		if( result.hasErrors() ) 
		{
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) 
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage())); 
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(null)); 
	}
}
