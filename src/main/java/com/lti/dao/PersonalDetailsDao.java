package com.lti.dao;

import com.lti.entity.PersonalDetails;
import com.lti.entity.User;

public interface PersonalDetailsDao {
	
	PersonalDetails addPersonalDetails(PersonalDetails personalDetails);
	PersonalDetails findDetailsByApplicantId(int applicantId );
	
}
