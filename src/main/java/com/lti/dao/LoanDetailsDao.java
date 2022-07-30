package com.lti.dao;

import com.lti.entity.LoanDetails;

public interface LoanDetailsDao {

	LoanDetails addOrUpdateLoan(LoanDetails loanDetails);
	LoanDetails searchLoanById(int loanId);
	
}
