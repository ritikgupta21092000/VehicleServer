package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.NamedQuery;

@Entity
//@NamedQuery(name="applicant", query = "select s.salesId, l.loanId, l.emi, l.rateOfInterest, l.loanTenure, p.firstName,d.aadharUrl from Sales s join vh_loan l on s.loanDetails.loanId=l.loanId join vh_personaldetails p on s.personalDetails.applicantId=p.applicantId join Document d on p.applicantId=d.personalDetails.applicantId")
public class Sales {
	@Id
	@SequenceGenerator(name = "sales_seq", initialValue = 9001, allocationSize = 1)
	@GeneratedValue(generator = "sales_seq", strategy = GenerationType.SEQUENCE)
	int salesId;
	boolean isLoanApproved;
	

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
	public boolean isLoanApproved() {
		return isLoanApproved;
	}

	public void setLoanApproved(boolean isLoanApproved) {
		this.isLoanApproved = isLoanApproved;
	}
}
