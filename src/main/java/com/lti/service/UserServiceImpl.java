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


	public int forgotPassword(int userId, String password) {
		return userDao.forgotPassword(userId, password);
	}
		

	@Override
	public boolean checkUserId(int userId, String email) {
		User user = userDao.findByUserIdAndEmail(userId, email);
		if (user == null) {
			return false;
		} else {
			String text = "Dear " + user.getFirstName() + " " + user.getLastName() + "\n\n Below is the Reset Password Link \n\n http://localhost:4200/forgotPassword/" + user.getUserId();
			String subject = "Reset Password!";
			emailService.sendMail(email, text, subject);
			System.out.println("Email Sent.");
			return true;
		}

	}

}
