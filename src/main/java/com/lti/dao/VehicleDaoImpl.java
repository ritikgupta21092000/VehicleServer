package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Vehicles;

@Repository
public class VehicleDaoImpl implements VehicleDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public Vehicles addVehicle(Vehicles vehicles) {
		Vehicles vehiclePersisted = em.merge(vehicles);
		return vehiclePersisted;
	}

	@Override
	public List<Vehicles> viewAllVehicle() {
		String jpql = "select v from Vehicles v";
		TypedQuery<Vehicles> query = em.createQuery(jpql, Vehicles.class);
		return query.getResultList();
	}

	@Override
	public Vehicles searchVehicleById(int vehicleId) {
		return em.find(Vehicles.class, vehicleId);
	}

	@Override
	public List<Vehicles> searchVehicleByMake(String vehicleMake) {
		String jpql = "select v from Vehicles v where vehicleMake=:vMake";
		TypedQuery<Vehicles> query = em.createQuery(jpql, Vehicles.class);
		query.setParameter("vMake", vehicleMake);
		return query.getResultList();
	}

	@Override
	public List<Vehicles> searchVehicleByModel(String vehicleModel) {
		String jpql = "select v from Vehicles v where vehicleModel=:vModel";
		TypedQuery<Vehicles> query = em.createQuery(jpql, Vehicles.class);
		query.setParameter("vModel", vehicleModel);
		return query.getResultList();
	}

}
