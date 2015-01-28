package com.wc.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wc.test.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	private static final String NAMESPACE = "userControlMapper.";
	
    @Autowired
    private SqlSession sqlSession;

	public List<User> selectUser(Map<String, Object> paramMap){
	     return sqlSession.selectList(NAMESPACE+"selectUser", paramMap); 
	}
	
}
