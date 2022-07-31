package com.lti.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lti.entity.User;
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
	public HashMap<String, Integer> addVehicle(@RequestBody Vehicles vehicles) {
		return vehicleService.addVehicle(vehicles);
	}

	@RequestMapping(value = "/searchVehicle/{vehicleId}")
	@ResponseBody
	public Vehicles searchVehicleById(@PathVariable int vehicleId) {
		return vehicleService.searchVehicleById(vehicleId);
	}
	
	@RequestMapping(value = "/viewAllVehicles", method = RequestMethod.GET)
	@ResponseBody
	public List<Vehicles> getAllVehicles() {
		List<Vehicles> vehicles = new ArrayList<>();
		vehicles = vehicleService.viewAllVehicle();
		return vehicles;
	}
	
	@RequestMapping(value = "/getVehicleById/{vehicleId}", method = RequestMethod.GET)
	@ResponseBody
	public Vehicles getVehicleById(@PathVariable int vehicleId) {
		return vehicleService.searchVehicleById(vehicleId);
	}
	
	@RequestMapping(value = "/vehicleMake/{vehicleMake}", method = RequestMethod.GET)
	@ResponseBody
	public List<Vehicles> getVehiclesByMake(@PathVariable String vehicleMake) {
		return vehicleService.searchVehicleByMake(vehicleMake);
	}
}


