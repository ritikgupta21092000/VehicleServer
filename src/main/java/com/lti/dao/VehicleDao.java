package com.lti.dao;

import java.util.List;

import com.lti.entity.Vehicles;

public interface VehicleDao {
	Vehicles addVehicle(Vehicles vehicles);
	List<Vehicles> viewAllVehicle();
	
	Vehicles searchVehicleById(int vehicleId);
	List<Vehicles> searchVehicleByMake(String vehicleMake);
	List<Vehicles> searchVehicleByModel(String vehicleModel);
}
