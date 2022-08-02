package com.lti.service;

import java.util.List;

import com.lti.dto.UserDto;
import com.lti.entity.User;

public interface UserService {
	User register(User user);
	UserDto login(User user);

	int forgotPassword(int userId,String email);

	
	boolean checkUserId(int userId, String email);
	
	List<User> viewAllUsers();

}
