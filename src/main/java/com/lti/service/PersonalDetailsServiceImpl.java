package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.PersonalDetailsDao;
import com.lti.dao.UserDao;
import com.lti.entity.PersonalDetails;
import com.lti.entity.User;

@Component
public class PersonalDetailsServiceImpl implements PersonalDetailsService {
	
	@Autowired
	PersonalDetailsDao personalDetailsDao;

	@Autowired
	UserDao userDao;

	@Override
	public PersonalDetails addPersonalDetails(PersonalDetails personalDetails) {
		User user = userDao.finduserById(personalDetails.getUserId());
		System.out.println("User: " + personalDetails.getEmploymentType());
		personalDetails.setUser(user);
		PersonalDetails p1= personalDetailsDao.addPersonalDetails(personalDetails);
		return p1;
	}

	@Override
	public PersonalDetails findDteailsByApplicantId(int applicantId) {
		PersonalDetails p1=personalDetailsDao.findDetailsByApplicantId(applicantId);
		return p1;
	}

}
