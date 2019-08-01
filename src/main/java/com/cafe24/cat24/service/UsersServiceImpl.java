package com.cafe24.cat24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.cat24.repository.UsersDao;
import com.cafe24.cat24.vo.UsersVo;

@Service
public class UsersServiceImpl implements UsersService
{
	@Autowired
	private UsersDao usersDao;
	
	/** 회원가입 **/
	public Boolean join(UsersVo usersVo)
	{
		return usersDao.join(usersVo);
	}
	
	/** 로그인 **/
	public UsersVo login(UsersVo usersVo)
	{
		return usersDao.login(usersVo);
	}
	
	/** 아이디 중복 체크 **/
	public Boolean checkId(String id)
	{
		return usersDao.checkId(id);
	}
}
