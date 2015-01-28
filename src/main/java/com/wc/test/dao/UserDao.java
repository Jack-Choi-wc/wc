package com.wc.test.dao;

import java.util.List;
import java.util.Map;


import com.wc.test.model.User;

public interface UserDao {
	public List<User> selectUser(Map<String, Object> paramMap);
}
