package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.UserDto;
import com.lti.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	EntityManager em;

	@Transactional
	public User register(User user) {
		User userPersisted = em.merge(user);
		return userPersisted;
	}

	public UserDto login(User user) {
		UserDto userDto = new UserDto();
		String jpql = "select u from User u where u.userId =: uid and u.password =: pwd";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("uid", user.getUserId());
		query.setParameter("pwd", user.getPassword());
		try {
			User foundUser = query.getSingleResult();
			if (foundUser.isAdmin() == true) {
				userDto.setAdmin(true);
			} else {
				userDto.setAdmin(false);
			}
			userDto.setUser(foundUser);
			userDto.setMessage("Valid User");
			userDto.setValidUser(true);
		} catch (Exception e) {
			userDto.setMessage("Invalid User");
			userDto.setValidUser(false);
		}
		return userDto;
	}
	
	public User finduserById(int userId) {
		User user = em.find(User.class, userId);
		System.out.println(user);
		return user;
	}

}
