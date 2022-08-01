package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.lti.dto.SalesDto;
import com.lti.entity.Document;
import com.lti.entity.LoanDetails;
import com.lti.entity.PersonalDetails;
import com.lti.entity.Sales;
import com.lti.entity.User;
import com.lti.entity.Vehicles;

@Repository
public class SalesDaoImpl implements SalesDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Sales addOrUpdateSales(Sales sales) {
		Sales sales1 = em.merge(sales);
		return sales1;
	}

	public List<SalesDto> displaySales() {
		String jpql = "select s,l,p,d,v from Sales s join LoanDetails l on s.loanDetails.loanId=l.loanId join PersonalDetails p on s.personalDetails.applicantId=p.applicantId join Document d on p.applicantId=d.personalDetails.applicantId join Vehicles v on s.vehicles.vehicleId=v.vehicleId where s.isLoanApproved='pending'";
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		List<Object[]> allObjects = query.getResultList();
		List<SalesDto> foundSales = new ArrayList<>();
		SalesDto salesDto = null;
		for (Object[] obj : allObjects) {
			Sales s = (Sales) obj[0];
			LoanDetails l = (LoanDetails) obj[1];
			PersonalDetails p = (PersonalDetails) obj[2];
			Document d = (Document) obj[3];
			Vehicles v = (Vehicles) obj[4];
			salesDto = new SalesDto();
			salesDto.setSalesId(s.getSalesId());
			salesDto.setLoanId(l.getLoanId());
			salesDto.setApplicantId(p.getApplicantId());
			salesDto.setDocumentId(d.getDocumentId());
			salesDto.setVehicleId(v.getVehicleId());
			salesDto.setFirstName(p.getFirstName());
			salesDto.setAge(p.getAge());
			salesDto.setMobileNo(p.getMobileNo());
			salesDto.setEmail(p.getEmail());
			salesDto.setAadharUrl(d.getAadharUrl());
			salesDto.setPanUrl(d.getPanUrl());
			salesDto.setPhotoUrl(d.getPhotoUrl());
			salesDto.setSixMonthSalaryUrl(d.getSixMonthSalaryUrl());
			salesDto.setLoanAmount(l.getLoanAmount());
			salesDto.setLoanTenure(l.getLoanTenure());
			salesDto.setRateOfInterest(l.getRateOfInterest());
			salesDto.setEmi(l.getEmi());
			salesDto.setVehicleMake(v.getVehicleMake());
			salesDto.setVehicleModel(v.getVehicleModel());
			salesDto.setPrice(v.getPrice());
			salesDto.setIsLoanApproved("pending");
			foundSales.add(salesDto);
		}
		return foundSales;
	}

	@Transactional
	@Modifying
	public int updateOrReject(int salesId, String status) {
		String jpql = "update Sales set isLoanApproved=:st where salesId=:sid";
		Query query = em.createQuery(jpql);
		query.setParameter("st", status);
		query.setParameter("sid", salesId);
		return query.executeUpdate();
	}

	public List<SalesDto> rejectedApplications() {
		String jpql = "select s,l,p,d,v from Sales s join LoanDetails l on s.loanDetails.loanId=l.loanId join PersonalDetails p on s.personalDetails.applicantId=p.applicantId join Document d on p.applicantId=d.personalDetails.applicantId join Vehicles v on s.vehicles.vehicleId=v.vehicleId where s.isLoanApproved='rejected'";
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		List<Object[]> allObjects = query.getResultList();
		List<SalesDto> foundSales = new ArrayList<>();
		SalesDto salesDto = null;
		for (Object[] obj : allObjects) {
			Sales s = (Sales) obj[0];
			LoanDetails l = (LoanDetails) obj[1];
			PersonalDetails p = (PersonalDetails) obj[2];
			Document d = (Document) obj[3];
			Vehicles v = (Vehicles) obj[4];
			salesDto = new SalesDto();
			salesDto.setSalesId(s.getSalesId());
			salesDto.setLoanId(l.getLoanId());
			salesDto.setApplicantId(p.getApplicantId());
			salesDto.setDocumentId(d.getDocumentId());
			salesDto.setVehicleId(v.getVehicleId());
			salesDto.setFirstName(p.getFirstName());
			salesDto.setAge(p.getAge());
			salesDto.setMobileNo(p.getMobileNo());
			salesDto.setEmail(p.getEmail());
			salesDto.setAadharUrl(d.getAadharUrl());
			salesDto.setPanUrl(d.getPanUrl());
			salesDto.setPhotoUrl(d.getPhotoUrl());
			salesDto.setSixMonthSalaryUrl(d.getSixMonthSalaryUrl());
			salesDto.setLoanAmount(l.getLoanAmount());
			salesDto.setLoanTenure(l.getLoanTenure());
			salesDto.setRateOfInterest(l.getRateOfInterest());
			salesDto.setEmi(l.getEmi());
			salesDto.setVehicleMake(v.getVehicleMake());
			salesDto.setVehicleModel(v.getVehicleModel());
			salesDto.setPrice(v.getPrice());
			salesDto.setIsLoanApproved(s.getIsLoanApproved());
			foundSales.add(salesDto);
		}
		return foundSales;
	}

	public List<SalesDto> userApprovedApplications(int personalDetailId) {
		String jpql = "select s,l,p,d,v from Sales s join LoanDetails l on s.loanDetails.loanId=l.loanId join PersonalDetails p on s.personalDetails.applicantId=p.applicantId join Document d on p.applicantId=d.personalDetails.applicantId join Vehicles v on s.vehicles.vehicleId=v.vehicleId where s.isLoanApproved='approved' and s.personalDetails.applicantId=:aid";
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		query.setParameter("aid", personalDetailId);
		List<Object[]> allObjects = query.getResultList();
		List<SalesDto> foundSales = new ArrayList<>();
		SalesDto salesDto = null;
		for (Object[] obj : allObjects) {
			Sales s = (Sales) obj[0];
			LoanDetails l = (LoanDetails) obj[1];
			PersonalDetails p = (PersonalDetails) obj[2];
			Document d = (Document) obj[3];
			Vehicles v = (Vehicles) obj[4];
			salesDto = new SalesDto();
			salesDto.setSalesId(s.getSalesId());
			salesDto.setLoanId(l.getLoanId());
			salesDto.setApplicantId(p.getApplicantId());
			salesDto.setDocumentId(d.getDocumentId());
			salesDto.setVehicleId(v.getVehicleId());
			salesDto.setFirstName(p.getFirstName());
			salesDto.setAge(p.getAge());
			salesDto.setMobileNo(p.getMobileNo());
			salesDto.setEmail(p.getEmail());
			salesDto.setAadharUrl(d.getAadharUrl());
			salesDto.setPanUrl(d.getPanUrl());
			salesDto.setPhotoUrl(d.getPhotoUrl());
			salesDto.setSixMonthSalaryUrl(d.getSixMonthSalaryUrl());
			salesDto.setLoanAmount(l.getLoanAmount());
			salesDto.setLoanTenure(l.getLoanTenure());
			salesDto.setRateOfInterest(l.getRateOfInterest());
			salesDto.setEmi(l.getEmi());
			salesDto.setVehicleMake(v.getVehicleMake());
			salesDto.setVehicleModel(v.getVehicleModel());
			salesDto.setPrice(v.getPrice());
			salesDto.setIsLoanApproved(s.getIsLoanApproved());
			foundSales.add(salesDto);
		}
		return foundSales;
	}

	public List<SalesDto> userRejectedApplications(int personalDetailId) {
		String jpql = "select s,l,p,d,v from Sales s join LoanDetails l on s.loanDetails.loanId=l.loanId join PersonalDetails p on s.personalDetails.applicantId=p.applicantId join Document d on p.applicantId=d.personalDetails.applicantId join Vehicles v on s.vehicles.vehicleId=v.vehicleId where s.isLoanApproved='rejected' and s.personalDetails.applicantId=:aid";
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		query.setParameter("aid", personalDetailId);
		List<Object[]> allObjects = query.getResultList();
		List<SalesDto> foundSales = new ArrayList<>();
		SalesDto salesDto = null;
		for (Object[] obj : allObjects) {
			Sales s = (Sales) obj[0];
			LoanDetails l = (LoanDetails) obj[1];
			PersonalDetails p = (PersonalDetails) obj[2];
			Document d = (Document) obj[3];
			Vehicles v = (Vehicles) obj[4];
			salesDto = new SalesDto();
			salesDto.setSalesId(s.getSalesId());
			salesDto.setLoanId(l.getLoanId());
			salesDto.setApplicantId(p.getApplicantId());
			salesDto.setDocumentId(d.getDocumentId());
			salesDto.setVehicleId(v.getVehicleId());
			salesDto.setFirstName(p.getFirstName());
			salesDto.setAge(p.getAge());
			salesDto.setMobileNo(p.getMobileNo());
			salesDto.setEmail(p.getEmail());
			salesDto.setAadharUrl(d.getAadharUrl());
			salesDto.setPanUrl(d.getPanUrl());
			salesDto.setPhotoUrl(d.getPhotoUrl());
			salesDto.setSixMonthSalaryUrl(d.getSixMonthSalaryUrl());
			salesDto.setLoanAmount(l.getLoanAmount());
			salesDto.setLoanTenure(l.getLoanTenure());
			salesDto.setRateOfInterest(l.getRateOfInterest());
			salesDto.setEmi(l.getEmi());
			salesDto.setVehicleMake(v.getVehicleMake());
			salesDto.setVehicleModel(v.getVehicleModel());
			salesDto.setPrice(v.getPrice());
			salesDto.setIsLoanApproved(s.getIsLoanApproved());
			foundSales.add(salesDto);
		}
		return foundSales;
	}

	@Override
	public List<SalesDto> userAllApplications(int personalDetailId) {
		String jpql = "select s,l,p,d,v from Sales s join LoanDetails l on s.loanDetails.loanId=l.loanId join PersonalDetails p on s.personalDetails.applicantId=p.applicantId join Document d on p.applicantId=d.personalDetails.applicantId join Vehicles v on s.vehicles.vehicleId=v.vehicleId where s.personalDetails.applicantId=:aid";
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		query.setParameter("aid", personalDetailId);
		List<Object[]> allObjects = query.getResultList();
		List<SalesDto> foundSales = new ArrayList<>();
		SalesDto salesDto = null;
		for (Object[] obj : allObjects) {
			Sales s = (Sales) obj[0];
			LoanDetails l = (LoanDetails) obj[1];
			PersonalDetails p = (PersonalDetails) obj[2];
			Document d = (Document) obj[3];
			Vehicles v = (Vehicles) obj[4];
			salesDto = new SalesDto();
			salesDto.setSalesId(s.getSalesId());
			salesDto.setLoanId(l.getLoanId());
			salesDto.setApplicantId(p.getApplicantId());
			salesDto.setDocumentId(d.getDocumentId());
			salesDto.setVehicleId(v.getVehicleId());
			salesDto.setFirstName(p.getFirstName());
			salesDto.setAge(p.getAge());
			salesDto.setMobileNo(p.getMobileNo());
			salesDto.setEmail(p.getEmail());
			salesDto.setAadharUrl(d.getAadharUrl());
			salesDto.setPanUrl(d.getPanUrl());
			salesDto.setPhotoUrl(d.getPhotoUrl());
			salesDto.setSixMonthSalaryUrl(d.getSixMonthSalaryUrl());
			salesDto.setLoanAmount(l.getLoanAmount());
			salesDto.setLoanTenure(l.getLoanTenure());
			salesDto.setRateOfInterest(l.getRateOfInterest());
			salesDto.setEmi(l.getEmi());
			salesDto.setVehicleMake(v.getVehicleMake());
			salesDto.setVehicleModel(v.getVehicleModel());
			salesDto.setPrice(v.getPrice());
			salesDto.setIsLoanApproved(s.getIsLoanApproved());
			foundSales.add(salesDto);
		}
		return foundSales;
	}

	@Override
	public Sales findPersonalDetailBySaleId(int saleId) {
		String jpql = "select s from Sales s where s.salesId=:sid";
		TypedQuery<Sales> query = em.createQuery(jpql, Sales.class);
		query.setParameter("sid", saleId);
		return query.getSingleResult();
	}

	@Override
	public List<SalesDto> findEmi(int personalDetailId) {
		String jpql = "select s,l,p,d,v from Sales s join LoanDetails l on s.loanDetails.loanId=l.loanId join PersonalDetails p on s.personalDetails.applicantId=p.applicantId join Document d on p.applicantId=d.personalDetails.applicantId join Vehicles v on s.vehicles.vehicleId=v.vehicleId where s.isLoanApproved='approved' and s.personalDetails.applicantId=:aid";
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		query.setParameter("aid", personalDetailId);
		List<Object[]> allObjects = query.getResultList();
		List<SalesDto> foundSales = new ArrayList<>();
		SalesDto salesDto = null;
		for (Object[] obj : allObjects) {
			Sales s = (Sales) obj[0];
			LoanDetails l = (LoanDetails) obj[1];
			PersonalDetails p = (PersonalDetails) obj[2];
			Document d = (Document) obj[3];
			Vehicles v = (Vehicles) obj[4];
			salesDto = new SalesDto();
			salesDto.setSalesId(s.getSalesId());
			salesDto.setLoanId(l.getLoanId());
			salesDto.setApplicantId(p.getApplicantId());
			salesDto.setDocumentId(d.getDocumentId());
			salesDto.setVehicleId(v.getVehicleId());
			salesDto.setFirstName(p.getFirstName());
			salesDto.setAge(p.getAge());
			salesDto.setMobileNo(p.getMobileNo());
			salesDto.setEmail(p.getEmail());
			salesDto.setAadharUrl(d.getAadharUrl());
			salesDto.setPanUrl(d.getPanUrl());
			salesDto.setPhotoUrl(d.getPhotoUrl());
			salesDto.setSixMonthSalaryUrl(d.getSixMonthSalaryUrl());
			salesDto.setLoanAmount(l.getLoanAmount());
			salesDto.setLoanTenure(l.getLoanTenure());
			salesDto.setRateOfInterest(l.getRateOfInterest());
			salesDto.setEmi(l.getEmi());
			salesDto.setVehicleMake(v.getVehicleMake());
			salesDto.setVehicleModel(v.getVehicleModel());
			salesDto.setPrice(v.getPrice());
			salesDto.setIsLoanApproved(s.getIsLoanApproved());
			foundSales.add(salesDto);
		}
		return foundSales;
	}

}
