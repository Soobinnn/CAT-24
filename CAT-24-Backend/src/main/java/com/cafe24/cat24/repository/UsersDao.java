package com.cafe24.cat24.repository;

import java.util.HashMap;
import java.util.List;
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
	
	/** 회원 전체목록 **/
	public List<UsersVo> list() 
	{
		List<UsersVo> list = sqlSession.selectList("users.list");
		return list;
	}
	
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
	
	/** 아이디 중복 체크 **/
	public Boolean checkId(String id)
	{
		UsersVo check = sqlSession.selectOne("users.checkId",id);
		
		if(check==null)
			return true;
		
		return false;
	}
	
	/** 회원 수정-_- **/
	public Boolean update(UsersVo usersVo,String id)
	{
		int count = sqlSession.update("users.update", usersVo);
		
		return 1 == count;
	}
	
	/** 회원 탈퇴-_- **/
	public Boolean delete(String id)
	{
		int count = sqlSession.delete("users.delete", id);
		return 1 == count;
	}
}