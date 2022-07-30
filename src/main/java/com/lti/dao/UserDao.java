package com.lti.dao;

import com.lti.dto.UserDto;
import com.lti.entity.User;

public interface UserDao {
	User register(User user);
	UserDto login(User user);
	User  finduserById (int userId);
}
