package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.EnquiryDao;
import com.lti.entity.Enquiry;

@Component
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryDao enquiryDao;
	@Autowired
	EmailService emailService;
	@Override
	public Enquiry addEnquiryDetails(Enquiry enquiry) {
		Enquiry enquiry2=enquiryDao.addEnquiryDetails(enquiry);
		String email=enquiry2.getEmail();
		String text="Greetings from LTI-car loan Your enquiry Id is :- "+enquiry2.getEnquiryId()+".Our next availabe Assistant will get  back to you as soon as possible";
		String subject="Car Loan Enquiry!";
		emailService.sendMail(email, text, subject);
		System.out.println("Email Sent.");
		return enquiry2;
	}

	@Override
	public Enquiry findEnquiryById(int enquiryId) {
		Enquiry enquiry2=enquiryDao.findEnquiryById(enquiryId);
		return enquiry2;
	}

	@Override
	public List<Enquiry> viewAllEnquiry() {
		List<Enquiry> e=enquiryDao.viewAllEnquiry();
		return e;
	}

}
