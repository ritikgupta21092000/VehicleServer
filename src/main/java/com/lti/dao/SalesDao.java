package com.lti.dao;

import java.util.List;

import com.lti.dto.SalesDto;
import com.lti.entity.Sales;

public interface SalesDao {
	
	List<Sales> displaySales();
}
