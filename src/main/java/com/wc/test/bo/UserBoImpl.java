package com.wc.test.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wc.test.dao.UserDao;
import com.wc.test.model.User;
@Service
public class UserBoImpl implements UserBo{

    @Autowired
    private UserDao dao;
	
	public List<User> selectUser(Map<String, Object> paramMap){
		return dao.selectUser(paramMap);
	}
}
