package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class LoanDetails {
	@Id
	@SequenceGenerator(name="ln_seq",initialValue = 5001,allocationSize = 1)
	@GeneratedValue(generator = "ln_seq",strategy = GenerationType.SEQUENCE)
	int loanId;
	int loanAmount;
	int loanTenure;
	double rateOfInterest;
	double emi;
	
	@ManyToOne
	@JoinColumn(name="vehicleId")
	Vehicles vehicles;
	
	@OneToOne(mappedBy = "loanDetails",cascade = CascadeType.ALL)    //sales and loandetails 1:1
	Sales sales;
	
	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public Vehicles getVehicle() {
		return vehicles;
	}

	public void setVehicle(Vehicles vehicle) {
		this.vehicles = vehicle;
	}
	
	
}
