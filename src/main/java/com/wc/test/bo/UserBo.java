package com.wc.test.bo;

import java.util.List;
import java.util.Map;

import com.wc.test.model.User;

public interface UserBo {
	public List<User> selectUser(Map<String, Object> paramMap);
}
