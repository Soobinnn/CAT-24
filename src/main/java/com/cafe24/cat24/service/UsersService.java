package com.cafe24.cat24.service;

import com.cafe24.cat24.vo.UsersVo;

public interface UsersService 
{
	/** 회원가입 **/
	public Boolean join(UsersVo usersVo);
	
	/** 로그인 **/
	public UsersVo login(UsersVo usersVo);
}
