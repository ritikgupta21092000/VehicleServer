package com.lti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.UserDto;
import com.lti.entity.User;
import com.lti.service.EmailService;
import com.lti.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User signup(@RequestBody User user) {
		User user2 = userService.register(user);
		return user2;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> login(@RequestBody User user) {
		UserDto userDto = userService.login(user);
		HashMap<String, String> map = new HashMap<String, String>();
		if (userDto.isValidUser() == false) {
			map.put("ValidUser", "false");
		} else {
			map.put("userName", userDto.getUser().getEmail());
			map.put("mobileNo", userDto.getUser().getMobileNo());
			map.put("firstName", userDto.getUser().getFirstName());
			map.put("ValidUser", "true");
			map.put("userId", Integer.toString(userDto.getUser().getUserId()));
			if (userDto.isAdmin() == true) {
				map.put("isAdmin", "true");
			} else {
				map.put("isAdmin", "false");
			}
		}
		return map;
	}
  
	//http://localhost:9090/users/forgotPassword
	@RequestMapping(value = "/forgotPassword/{userId}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public int forgotPassword(@PathVariable int userId, @PathVariable String password) {
		System.out.println(userId);
		return userService.forgotPassword(userId, password);
	}

	
	@RequestMapping(value = "/checkUserId/{userId}/{email}", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkUserId(@PathVariable int userId, @PathVariable String email) {
		return userService.checkUserId(userId, email);

	}

}
