package com.cafe24.cat24.service;

import java.util.List;

import com.cafe24.cat24.vo.ProductsVo;
import com.cafe24.cat24.vo.UsersVo;

public interface UsersService 
{
	/** 회원 전체 목록 **/
	public List<UsersVo> list();
	
	/** 회원가입 **/
	public Boolean join(UsersVo usersVo);
	
	/** 로그인 **/
	public UsersVo login(UsersVo usersVo);
	
	/** 아이디 중복 체크 **/
	public Boolean checkId(String id);
	
	/** 회원 수정-_- **/
	public Boolean update(UsersVo usersVo,String id);
	
	/** 회원 탈퇴-_- **/
	public Boolean delete(String id);
}
