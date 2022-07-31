package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.SalesDto;
import com.lti.entity.Sales;
import com.lti.service.SalesService;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "http://localhost:4200")
public class SalesController {

	@Autowired
	SalesService salesService;
	//http://localhost:9090/sales/displaySales
	@RequestMapping(value = "/displaySales", method = RequestMethod.GET)
	@ResponseBody
	 public List<SalesDto> displaySales(){
		
		return salesService.displaySales();
	}
}
