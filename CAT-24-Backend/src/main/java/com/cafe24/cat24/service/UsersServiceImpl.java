package com.cafe24.cat24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.cat24.repository.UsersDao;
import com.cafe24.cat24.vo.UsersVo;

@Service
public class UsersServiceImpl implements UsersService
{
	@Autowired
	private UsersDao usersDao;
	
	/** 회원 전체 목록 **/
	public List<UsersVo> list()
	{
		return usersDao.list();
	}
	
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
	
	/** 회원 수정-_- **/
	public Boolean update(UsersVo usersVo,String id)
	{
		return usersDao.update(usersVo, id);
	}
	
	/** 회원 탈퇴-_- **/
	public Boolean delete(String id)
	{
		return usersDao.delete(id);
	}
	
}
