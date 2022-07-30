package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.PersonalDetails;
import com.lti.entity.User;
import com.lti.entity.Vehicles;

@Repository
public class PersonalDetailsDaoImpl implements PersonalDetailsDao {
	@PersistenceContext
	EntityManager em;
	@Override
	@Transactional
	public PersonalDetails addPersonalDetails(PersonalDetails personalDetails) {
		PersonalDetails personPersisted=em.merge(personalDetails);
		return personPersisted;
	}
	
	@Override
	public PersonalDetails findDetailsByApplicantId(int applicantId) {
		return em.find(PersonalDetails.class, applicantId);
	}
	

}
