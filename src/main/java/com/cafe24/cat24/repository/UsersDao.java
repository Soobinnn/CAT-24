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
	
	/*public UsersVo get(String email) {
		UsersVo vo = new UsersVo();
	
		vo.setName("둘리");
		vo.setEmail("dooly@gmail.com");
		vo.setPassword("1234");
		//return sqlSession.selectOne("user.getByEmail", email);
		return vo;
	}
	
	public UsersVo get(Long no){
		return sqlSession.selectOne("user.getByNo", no);
	}
	
	public UsersVo get(String email, String password) throws UserDaoException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		UsersVo userVo = sqlSession.selectOne("user.getByEmailAndPassword", map);
		
		return userVo;
	}	
	
	public int update( UsersVo userVo ) {
		return sqlSession.update( "user.update", userVo );
	}	*/
}