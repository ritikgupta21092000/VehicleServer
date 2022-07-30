package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.PersonalDetailsDao;
import com.lti.entity.PersonalDetails;

@Component
public class PersonalDetailsServiceImpl implements PersonalDetailsService {
	
	@Autowired
	PersonalDetailsDao personalDetailsDao;



	@Override
	public PersonalDetails addPersonalDetails(PersonalDetails personalDetails) {
		PersonalDetails p1= personalDetailsDao.addPersonalDetails(personalDetails);
		return p1;
	}

	@Override
	public PersonalDetails findDteailsByApplicantId(int applicantId) {
		PersonalDetails p1=personalDetailsDao.findDetailsByApplicantId(applicantId);
		return p1;
	}

}
