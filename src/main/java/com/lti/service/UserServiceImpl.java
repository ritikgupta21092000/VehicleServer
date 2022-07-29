package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dao.UserDao;
import com.lti.dto.UserDto;
import com.lti.entity.User;

@Repository
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	EmailService emailService;

	public User register(User user) {
		User user2 = userDao.register(user);
		String email = user2.getEmail();
		String text = "Registration Successfull. Your generated User Id is: " + user2.getUserId() + "\n\n Please use this User Id for login purpose.";
		String subject = "Registration Confirmation!";
		emailService.sendMail(email, text, subject);
		System.out.println("Email Sent.");
		return user2;
	}

	public UserDto login(User user) {
		UserDto userDto = userDao.login(user);
		return userDto;
	}

}
