package com.cafe24.cat24.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.cat24.vo.AdminVo;

@Repository
public class AdminDao 
{
	@Autowired
	private SqlSession sqlSession;
	
	/** 로그인 **/
	public AdminVo login(AdminVo adminvo)
	{
		AdminVo  vo = new AdminVo();
		vo = sqlSession.selectOne("admin.getByEmailAndPassword",adminvo);

		return vo;
	}
}
