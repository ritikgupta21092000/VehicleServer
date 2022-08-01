package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

	@Override
	public PersonalDetails findDetailByUserId(int userId) {
		String jpql = "select p from PersonalDetails p where p.user.userId=:uid";
		TypedQuery<PersonalDetails> query = em.createQuery(jpql, PersonalDetails.class);
		query.setParameter("uid", userId);
		return query.getSingleResult();
	}
	

}
