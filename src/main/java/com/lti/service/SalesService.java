package com.lti.service;

import java.util.List;

import com.lti.dto.SalesDto;
import com.lti.entity.Sales;

public interface SalesService {

	Sales addSales(Sales sales);

	List<SalesDto> displaySales();

	int updateOrReject(int salesId, String status, String message);

	List<SalesDto> rejectedApplications();
	
	List<SalesDto> userAllApplications(int userId);

	List<SalesDto> userApprovedApplications(int userId);

	List<SalesDto> userRejectedApplications(int userId);
	
	List<SalesDto> findEmi(int userId);

}
