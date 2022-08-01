package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
public class Document {
	@Id
	@SequenceGenerator(name = "document_seq", initialValue = 3001, allocationSize = 1)
	@GeneratedValue(generator = "document_seq", strategy = GenerationType.SEQUENCE)
	int documentId;
	
	String aadharUrl;
	String panUrl;
	String photoUrl;
	String sixMonthSalaryUrl;
	
	@Transient
	int personalDetailsId;
	
	@OneToOne
	@JoinColumn(name = "applicant_id")
	PersonalDetails personalDetails;
	
	

	public int getPersonalDetailsId() {
		return personalDetailsId;
	}

	public void setPersonalDetailsId(int personalDetailsId) {
		this.personalDetailsId = personalDetailsId;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getAadharUrl() {
		return aadharUrl;
	}

	public void setAadharUrl(String aadharUrl) {
		this.aadharUrl = aadharUrl;
	}

	public String getPanUrl() {
		return panUrl;
	}

	public void setPanUrl(String panUrl) {
		this.panUrl = panUrl;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getSixMonthSalaryUrl() {
		return sixMonthSalaryUrl;
	}

	public void setSixMonthSalaryUrl(String sixMonthSalaryUrl) {
		this.sixMonthSalaryUrl = sixMonthSalaryUrl;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	
	
}
