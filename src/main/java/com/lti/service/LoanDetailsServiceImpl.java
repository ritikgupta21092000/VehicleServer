package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.LoanDetailsDao;
import com.lti.dao.VehicleDao;
import com.lti.entity.LoanDetails;
import com.lti.entity.Vehicles;
@Component
public class LoanDetailsServiceImpl implements LoanDetailsService {

	@Autowired
	LoanDetailsDao loanDetailsDao;
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Override
	public LoanDetails addOrUpdateLoan(LoanDetails loanDetails) {
		int vehicleId = loanDetails.getVehicleId();
		Vehicles vehicles = vehicleDao.searchVehicleById(vehicleId);
		loanDetails.setVehicle(vehicles);
		LoanDetails l1=loanDetailsDao.addOrUpdateLoan(loanDetails);
		return l1;
	}

	@Override
	public LoanDetails searchLoanById(int loanId) {
		LoanDetails l1=loanDetailsDao.searchLoanById(loanId);
		return l1;
	}

}
