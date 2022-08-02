package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Enquiry;
import com.lti.entity.Vehicles;

@Repository
public class EnquiryDaoImpl implements EnquiryDao {

	@PersistenceContext
	EntityManager em;
	@Override
	@Transactional
	public Enquiry addEnquiryDetails(Enquiry enquiry) {
		Enquiry Enquirypersisted=em.merge(enquiry);
		return Enquirypersisted;
	}

	@Override
	public Enquiry findEnquiryById(int enquiryId) {
		return em.find(Enquiry.class, enquiryId);
	}

	public List<Enquiry> viewAllEnquiry() {
		String jpql = "select e from Enquiry e";
		TypedQuery<Enquiry> query = em.createQuery(jpql, Enquiry.class);
		return query.getResultList();
	}

	
	
}
