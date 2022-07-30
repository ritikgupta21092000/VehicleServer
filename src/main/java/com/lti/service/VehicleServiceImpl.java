package com.lti.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.VehicleDao;
import com.lti.entity.Vehicles;

@Component
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleDao vehicleDao;

	@Override
	public HashMap<String, Integer> addVehicle(Vehicles vehicles) {
		HashMap<String, Integer> vehicleMap = new HashMap<>();
		try {
			Vehicles vehicles2 = vehicleDao.addVehicle(vehicles);
			vehicleMap.put("isInserted", 1);
			vehicleMap.put("vehicleId", vehicles2.getVehicleId());
		} catch (Exception e) {
			vehicleMap.put("isInserted", 0);
		}
		
		return vehicleMap;
	}

	@Override
	public List<Vehicles> viewAllVehicle() {
		List<Vehicles> vehicles = vehicleDao.viewAllVehicle();
		return vehicles;
	}

	@Override
	public Vehicles searchVehicleById(int vehicleId) {
		Vehicles vehicles = vehicleDao.searchVehicleById(vehicleId);
		return vehicles;
	}

	@Override
	public List<Vehicles> searchVehicleByMake(String vehicleMake) {
		List<Vehicles> vehicles = vehicleDao.searchVehicleByMake(vehicleMake);
		return vehicles;
	}

	@Override
	public List<Vehicles> searchVehicleByModel(String vehicleModel) {
		List<Vehicles> vehicles = vehicleDao.searchVehicleByModel(vehicleModel);
		return vehicles;
	}

}
