package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.LoanDetailsDao;
import com.lti.dao.PersonalDetailsDao;
import com.lti.dao.SalesDao;
import com.lti.dao.VehicleDao;
import com.lti.dto.SalesDto;
import com.lti.entity.LoanDetails;
import com.lti.entity.PersonalDetails;
import com.lti.entity.Sales;
import com.lti.entity.User;
import com.lti.entity.Vehicles;

@Component
public class SalesServiceImpl implements SalesService {
	
	@Autowired
	SalesDao salesDao;
	
	@Autowired
	PersonalDetailsDao personalDetailsDao;
	
	@Autowired
	LoanDetailsDao loanDetailsDao;
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	EmailService emailService;

	@Override
	public List<SalesDto> displaySales() {
		return salesDao.displaySales();
	}

	public Sales addSales(Sales sales) {
		PersonalDetails personalDetails = personalDetailsDao.findDetailsByApplicantId(sales.getApplicantId());
		LoanDetails loanDetails = loanDetailsDao.searchLoanById(sales.getLoanId());
		Vehicles vehicles = vehicleDao.searchVehicleById(sales.getVehicleId());
		sales.setPersonalDetails(personalDetails);
		sales.setLoanDetails(loanDetails);
		sales.setVehicles(vehicles);
		sales.setIsLoanApproved("pending");
		return salesDao.addOrUpdateSales(sales);
	}

	public int updateOrReject(int salesId, String status, String message) {
		PersonalDetails personalDetails = salesDao.findPersonalDetailBySaleId(salesId).getPersonalDetails();
		String emailId = personalDetails.getUser().getEmail();
		String fullName = personalDetails.getUser().getFirstName() + " " + personalDetails.getUser().getLastName();
		String subject = "Update Regarding Loan!";
		String text;
		if (status == "approved") {
			text = "Congratulations!" + fullName + "\n\n Your Loan is Approved Successfully";
		} else {
			text = "Dear " + fullName + "\n\n Your Loan Application is Rejected.\n\n Reason: " + message;
		}
		emailService.sendMail(emailId, text, subject);
		System.out.println("Email Sent");
		return salesDao.updateOrReject(salesId, status);
	}

	@Override
	public List<SalesDto> rejectedApplications() {
		return salesDao.rejectedApplications();
	}

	@Override
	public List<SalesDto> userApprovedApplications(int userId) {
		PersonalDetails personalDetails = personalDetailsDao.findDetailByUserId(userId);
		return salesDao.userApprovedApplications(personalDetails.getApplicantId());
	}

	@Override
	public List<SalesDto> userRejectedApplications(int userId) {
		PersonalDetails personalDetails = personalDetailsDao.findDetailByUserId(userId);
		return salesDao.userRejectedApplications(personalDetails.getApplicantId());
	}

	@Override
	public List<SalesDto> userAllApplications(int userId) {
		PersonalDetails personalDetails = personalDetailsDao.findDetailByUserId(userId);
		return salesDao.userAllApplications(personalDetails.getApplicantId());
	}

	@Override
	public List<SalesDto> findEmi(int userId) {
		PersonalDetails personalDetails = personalDetailsDao.findDetailByUserId(userId);
		return salesDao.findEmi(personalDetails.getApplicantId());
	}

}
