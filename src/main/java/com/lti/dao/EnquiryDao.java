package com.lti.dao;

import java.util.List;

import com.lti.entity.Enquiry;

public interface EnquiryDao {
	Enquiry addEnquiryDetails (Enquiry enquiry);
	Enquiry findEnquiryById (int enquiryId);
	List<Enquiry> viewAllEnquiry();
}
