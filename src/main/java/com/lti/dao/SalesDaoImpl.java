package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.SalesDto;
import com.lti.entity.Document;
import com.lti.entity.Sales;
import com.lti.entity.User;
@Repository
public class SalesDaoImpl implements SalesDao {

	@PersistenceContext
	EntityManager em;

//	@Transactional
	public  List<Sales>  displaySales() {
		User user=new User();
		SalesDto salesDto=new SalesDto();
		//List<SalesDto> foundSales = new ArrayList<>();
		Document document=new Document();
		//Query q = em.createNamedQuery("applicant");
//		String jpql="select s from sales where s.isLoanApproved=:null";
//	String jpql="select s.salesId, l.loanId, l.emi, l.rateOfInterest, l.loanTenure, p.firstName,d.aadharUrl from\r\n"
//				+ "Sales s join vh_loan l on s.loanDetails.loanId=l.loanId\r\n"
//				+ "join vh_personaldetails p on s.personalDetails.applicantId=p.applicantId\r\n"
//				+ "join Document d on p.applicantId=d.personalDetails.applicantId";
		
		String jpql="select s from Sales s";
	
		TypedQuery<Sales> query =em.createQuery(jpql,Sales.class);
		
		return query.getResultList();
		
//		 salesDto =query.getSingleResult();
		
//		salesDto.setFirstName(user.getFirstName());
//		salesDto.setLastName(user.getLastName());
//		salesDto.setEmail(user.getEmail());
//		salesDto.setMobileNo(user.getMobileNo());
//		salesDto.setAadharUrl(document.getAadharUrl());
//		salesDto.setPanUrl(document.getPanUrl());
//		salesDto.setPhotoUrl(document.getPhotoUrl());
//		salesDto.setSixMonthSalaryUrl(document.getSixMonthSalaryUrl());

		//return salesDto;
	}

}
