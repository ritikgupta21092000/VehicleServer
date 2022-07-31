package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vh_vehicles")
public class Vehicles {
	@Id
	@SequenceGenerator(name="veh_seq",initialValue = 4001,allocationSize = 1)
	@GeneratedValue(generator = "veh_seq",strategy = GenerationType.SEQUENCE)
	int vehicleId;
	
	String vehicleMake;
	String vehicleModel;
	String vehicleType;
	int price;
	String fuelType;
	int seatingCapacity;
	String engineSize;
	String fuelTank;
	String carImageUrl;

	@OneToMany(mappedBy = "vehicles",cascade = CascadeType.ALL)
	List<LoanDetails> loanDetails;
	
	@OneToMany(mappedBy = "vehicles",cascade = CascadeType.ALL)
	//Sales sales;
	List<Sales> sales;

	@JsonIgnore
	public List<Sales> getSales() {
		return sales;
	}

	public void setSales(List<Sales> sales) {
		this.sales = sales;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	public String getFuelTank() {
		return fuelTank;
	}

	public void setFuelTank(String fuelTank) {
		this.fuelTank = fuelTank;
	}

	public String getCarImageUrl() {
		return carImageUrl;
	}

	public void setCarImageUrl(String carImageUrl) {
		this.carImageUrl = carImageUrl;
	}

	@JsonIgnore
	public List<LoanDetails> getLoanDetails() {
		return loanDetails;
	}

	public void setLoanDetails(List<LoanDetails> loanDetails) {
		this.loanDetails = loanDetails;
	}

	
	
	

}
