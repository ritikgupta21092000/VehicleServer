package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.PersonalDetails;
import com.lti.service.PersonalDetailsService;

@RestController
@RequestMapping("/personalDetails")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonalDetailsController {
	
	@Autowired
	//http://localhost:9090/personalDetails/addpersonalDetails
	PersonalDetailsService personalDetailsService;
	@RequestMapping(value = "/addpersonalDetails", method = RequestMethod.POST)
	@ResponseBody
	public PersonalDetails addpersonalDetails(@RequestBody PersonalDetails personalDetails) {
		return personalDetailsService.addPersonalDetails(personalDetails);
	}
	
	//http://localhost:9090/personalDetails/searchPersonalDetailsbyid/2001
	@RequestMapping(value = "/searchPersonalDetailsbyid/{applicantId}")
	@ResponseBody
	public PersonalDetails searchPersonaldetailsById(@PathVariable int applicantId) {
		return personalDetailsService.findDteailsByApplicantId(applicantId);
	}
	
	@RequestMapping(value = "/checkPersonalDetails/{userId}")
	@ResponseBody
	public PersonalDetails findPersonalDetailsByUserId(@PathVariable int userId) {
		return personalDetailsService.findPersonalDetailsByUserId(userId);
	}
}
