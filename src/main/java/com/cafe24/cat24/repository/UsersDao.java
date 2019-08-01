package com.cafe24.cat24.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.cat24.exception.UserDaoException;
import com.cafe24.cat24.vo.UsersVo;

@Repository
public class UsersDao 
{
	@Autowired
	private SqlSession sqlSession;
	
	/** 회원가입 **/
	public Boolean join(UsersVo usersvo) 
	{
		int count = sqlSession.insert("users.insert", usersvo);
		return 1 == count;
	}
	
	/** 로그인 **/
	public UsersVo login(UsersVo usersvo)
	{
		UsersVo vo = new UsersVo();
		vo = sqlSession.selectOne("users.getByEmailAndPassword",usersvo);

		return vo;
	}
}