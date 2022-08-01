package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "/addSales", method = RequestMethod.POST)
	@ResponseBody
	 public Sales addSales(@RequestBody Sales sales){
		return salesService.addSales(sales);
	}
	
	@RequestMapping(value = "/update/{salesId}/{status}/{message}")
	@ResponseBody
	public int approveOrReject(@PathVariable int salesId, @PathVariable String status, @PathVariable String message) {
		System.out.println(message);
		return salesService.updateOrReject(salesId, status, message);
	}
	
	@RequestMapping(value = "/rejectedApplications", method = RequestMethod.GET)
	@ResponseBody
	 public List<SalesDto> rejectedApplications(){
		return salesService.rejectedApplications();
	}
	
	@RequestMapping(value = "/userAllApplications/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<SalesDto> getUserApplications(@PathVariable int userId){
		return salesService.userAllApplications(userId);
	}
	
	@RequestMapping(value = "/approvedApplications/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<SalesDto> getUserApprovedApplications(@PathVariable int userId){
		return salesService.userApprovedApplications(userId);
	}
	
	@RequestMapping(value = "/userRejectedApplications/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<SalesDto> getUserRejectedApplications(@PathVariable int userId){
		return salesService.userRejectedApplications(userId);
	}
	
	@RequestMapping(value = "/emiScheduler/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<SalesDto> getEmi(@PathVariable int userId){
		return salesService.findEmi(userId);
	}
}
