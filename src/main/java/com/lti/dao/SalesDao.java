package com.lti.dao;

import java.util.List;

import com.lti.dto.SalesDto;
import com.lti.entity.Sales;

public interface SalesDao {
	
	List<SalesDto> displaySales();

	Sales addOrUpdateSales(Sales sales);
	
	Sales findPersonalDetailBySaleId(int saleId);
	
	int updateOrReject(int salesId, String status);
	
	List<SalesDto> rejectedApplications();
	
	List<SalesDto> userAllApplications(int personalDetailId);
	
	List<SalesDto> userApprovedApplications(int personalDetailId);
	
	List<SalesDto> userRejectedApplications(int personalDetailId);
	
	List<SalesDto> findEmi(int personalDetailId);
}
