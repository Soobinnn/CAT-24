package com.cafe24.cat24frontend.service;

import com.cafe24.cat24frontend.vo.UsersVo;

public interface UserService 
{
	/** 회원 등록 **/
	public Boolean join(UsersVo userVo);
	
	/** 로그인  **/
	public Boolean login(UsersVo userVo);
}
