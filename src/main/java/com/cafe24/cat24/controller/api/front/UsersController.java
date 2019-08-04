package com.cafe24.cat24.controller.api.front;

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
import com.cafe24.cat24.vo.CategoriesVo;
import com.cafe24.cat24.vo.UsersVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("FrontusersAPIController")
@RequestMapping("api/v1/users")
public class UsersController 
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private UsersService usersService;
	
	
	/** 회원 등록 **/
	@ApiOperation(value="회원 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="usersVo", value="회원 등록", required=true, dataType="UsersVo", defaultValue="")
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
	
	/** 아이디 중복체크 **/
	@ApiOperation(value="아이디 중복체크")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="아이디", required=true, dataType="String", defaultValue="")
	})
	@GetMapping(value="/check/{id}")
	public ResponseEntity<JSONResult>checkId(@PathVariable String id)
	{
		if(id==null)
		{
			String message = messageSource.getMessage("NotEmpty.usersVo.id", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		else if(id.length()<3 || id.length()>50)
		{
			String message = messageSource.getMessage("error.usersVo.id", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		Boolean check = usersService.checkId(id);
		
		if(check==false)
		{
			String message = messageSource.getMessage("Used.usersVo.id", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}

		String message = messageSource.getMessage("Success.usersVo.id", null, LocaleContextHolder.getLocale());
		JSONResult result = JSONResult.fail(message);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	/** 로그인 **/
	@ApiOperation(value="로그인")
	@ApiImplicitParams({
		@ApiImplicitParam(name="usersVo", value="로그인", required=true, dataType="UsersVo", defaultValue="")
	})
	@PostMapping(value="/login")
	public ResponseEntity<JSONResult> login(@RequestBody UsersVo usersVo) 
	{
		
		Validator validator = 
				Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<UsersVo>> validatorResults = 
				validator.validateProperty(usersVo, "id");

		if(validatorResults.isEmpty() == false) 
		{
			for(ConstraintViolation<UsersVo> validatorResult : validatorResults) 
			{
				//String message = validatorResult.getMessage();
				String message = messageSource.getMessage("NotEmpty.usersVo.id_password", null, LocaleContextHolder.getLocale());
				JSONResult result = JSONResult.fail(message);
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
			}
		}
		
		UsersVo vo= usersService.login(usersVo);
		
		if(vo==null)
		{
			String message = messageSource.getMessage("Fail.usersVo.id_password", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		Map<String, Object> info = new HashMap<String,Object>(); 
		
		info.put("member_no",vo.getMember_no());
		info.put("id",usersVo.getId());
		info.put("name", vo.getName());
		info.put("gender",vo.getGender());
		info.put("email",vo.getEmail());
		info.put("profile",vo.getProfile());
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(info)); 
	}
	
	/** 회원 탈퇴 **/
	@ApiOperation(value="회원 탈퇴")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="회원아이디", required=true, dataType="String", defaultValue="")
	})
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<JSONResult> delete(@PathVariable(value="id") String id)
	{
		Boolean del = usersService.delete(id);
		
		//해당 카테고리 번호가 없을 경우
		if(del == false)
		{
			String message = messageSource.getMessage("NotEmpty.categoriesVo.category_no", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(del));
	}
	
	/** 회원 수정 **/
	@ApiOperation(value="회원 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id", value="아이디", required=true, dataType="String", defaultValue=""),
		@ApiImplicitParam(name="usersVo", value="회원 수정", required=true, dataType="UsersVo", defaultValue="")
	})
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<JSONResult> update(@RequestBody UsersVo usersVo, @PathVariable(value="id") String id)
	{
		Boolean update = usersService.update(usersVo, id);
				
		//해당 상품 번호가 없을 경우
		if(update == false)
		{
			String message = messageSource.getMessage("NotEmpty.categoriesVo.category_no", null, LocaleContextHolder.getLocale());
			JSONResult result = JSONResult.fail(message);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result); 
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(update));
	}
}
