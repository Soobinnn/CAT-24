package com.cafe24.cat24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.cat24.repository.AdminDao;
import com.cafe24.cat24.vo.AdminVo;
import com.cafe24.cat24.vo.UsersVo;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminDao adminDao;
	
	/** 로그인 **/
	public AdminVo login(AdminVo usersVo)
	{
		return adminDao.login(usersVo);
	}
	
}
