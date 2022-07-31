package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.SalesDao;
import com.lti.dto.SalesDto;
import com.lti.entity.Sales;

@Component
public class SalesServiceImpl implements SalesService {
	
	@Autowired
	SalesDao salesDao;

	@Override
	public List<SalesDto> displaySales() {
		return salesDao.displaySales();
	}

}
