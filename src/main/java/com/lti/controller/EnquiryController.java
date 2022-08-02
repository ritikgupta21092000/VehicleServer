package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Enquiry;
import com.lti.entity.Vehicles;
import com.lti.service.EnquiryService;

@RestController
@RequestMapping("/enquiry")
@CrossOrigin(origins = "http://localhost:4200")
public class EnquiryController {
	@Autowired
	EnquiryService enquiryService;
	//http://localhost:9090/enquiry/addenquuiryDetails
	@RequestMapping(value = "/addenquuiryDetails", method = RequestMethod.POST)
	@ResponseBody
	public Enquiry addEnquiryDetails(@RequestBody Enquiry enquiry) {
		
		return enquiryService.addEnquiryDetails(enquiry);
	}
	//http://localhost:9090/enquiry/viewAllEnquiry

	@RequestMapping(value = "/viewAllEnquiry", method = RequestMethod.GET)
	@ResponseBody
	public List<Enquiry> getAllEnquiry() {
		List<Enquiry> e = new ArrayList<>();
		e = enquiryService.viewAllEnquiry();
		return e;
	}
}
