package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.LoanDetailsDao;
import com.lti.entity.LoanDetails;
@Component
public class LoanDetailsServiceImpl implements LoanDetailsService {

	@Autowired
	LoanDetailsDao loanDetailsDao;
	@Override
	public LoanDetails addOrUpdateLoan(LoanDetails loanDetails) {
		LoanDetails l1=loanDetailsDao.addOrUpdateLoan(loanDetails);
		return l1;
	}

	@Override
	public LoanDetails searchLoanById(int loanId) {
		LoanDetails l1=loanDetailsDao.searchLoanById(loanId);
		return l1;
	}

}
