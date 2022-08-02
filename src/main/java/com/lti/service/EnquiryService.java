package com.lti.service;

import java.util.List;

import com.lti.entity.Enquiry;

public interface EnquiryService {
	Enquiry addEnquiryDetails (Enquiry enquiry);
	Enquiry findEnquiryById (int enquiryId);
	List<Enquiry> viewAllEnquiry();


}
