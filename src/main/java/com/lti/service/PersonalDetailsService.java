package com.lti.service;

import com.lti.entity.Document;
import com.lti.entity.PersonalDetails;

public interface PersonalDetailsService {
	
	PersonalDetails addPersonalDetails(PersonalDetails personalDetails);
	PersonalDetails findDteailsByApplicantId(int applicantId );

}
