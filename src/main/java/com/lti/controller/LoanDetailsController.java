package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.LoanDetails;
import com.lti.service.LoanDetailsService;

@RestController
@RequestMapping("/loanDetails")
@CrossOrigin(origins = "http://localhost:4200")
public class LoanDetailsController {

	@Autowired
	LoanDetailsService loanDetailsService;
	
	//http://localhost:9090/loanDetails/addLoanDetails
	@RequestMapping(value = "/addLoanDetails", method = RequestMethod.POST)
	@ResponseBody
	public LoanDetails addloanDetails(@RequestBody LoanDetails loanDetails) {
		return loanDetailsService.addOrUpdateLoan(loanDetails);
	}
	
	//http://localhost:9090/loanDetails/searchLoanDteails/3001
	@RequestMapping(value = "/searchLoanDteails/{loanId}")
	@ResponseBody
	public LoanDetails searchloanDetailsByloanId(@PathVariable int loanId) {
		return loanDetailsService.searchLoanById(loanId);
	}
}
