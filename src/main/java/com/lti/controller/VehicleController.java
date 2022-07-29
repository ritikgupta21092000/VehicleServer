package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Vehicles;
import com.lti.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(value = "/addVehicle", method = RequestMethod.POST)
	@ResponseBody
	public Vehicles addVehicle(@RequestBody Vehicles vehicles) {
		return vehicleService.addVehicle(vehicles);
	}
	
	@RequestMapping(value = "/searchVehicle/{vehicleId}")
	@ResponseBody
	public Vehicles searchVehicleById(@PathVariable int vehicleId) {
		return vehicleService.searchVehicleById(vehicleId);
	}
}
