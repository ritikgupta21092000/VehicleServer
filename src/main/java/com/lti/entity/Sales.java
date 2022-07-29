package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Sales {
	@Id
	@SequenceGenerator(name = "sales_seq", initialValue = 9001, allocationSize = 1)
	@GeneratedValue(generator = "sales_seq", strategy = GenerationType.SEQUENCE)
	int salesId;
	
	@ManyToOne
	@JoinColumn(name="vehicleId")
	Vehicles vehicles;
	
	@OneToOne
	@JoinColumn(name="loanId")
	LoanDetails loanDetails;
	
	@ManyToOne
	@JoinColumn(name="applicantId")
	PersonalDetails personalDetails;
	
	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public Vehicles getVehicles() {
		return vehicles;
	}

	public void setVehicles(Vehicles vehicles) {
		this.vehicles = vehicles;
	}

	public LoanDetails getLoanDetails() {
		return loanDetails;
	}

	public void setLoanDetails(LoanDetails loanDetails) {
		this.loanDetails = loanDetails;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	
}
