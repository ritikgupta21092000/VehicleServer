package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.LoanDetails;
@Repository
public class LoanDetailsDaoImpl implements LoanDetailsDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public LoanDetails addOrUpdateLoan(LoanDetails loanDetails) {
		LoanDetails loanPersisted=em.merge(loanDetails);	
		return loanPersisted;
	}

	public LoanDetails searchLoanById(int loanId) {
		return em.find(LoanDetails.class, loanId);
	}

}
