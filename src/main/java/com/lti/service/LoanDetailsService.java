package com.lti.service;

import com.lti.entity.LoanDetails;

public interface LoanDetailsService {

	LoanDetails addOrUpdateLoan(LoanDetails loanDetails);
	LoanDetails searchLoanById(int loanId);
}
