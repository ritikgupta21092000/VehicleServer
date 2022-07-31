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
import com.lti.entity.LoanDetails;
import com.lti.entity.PersonalDetails;
import com.lti.entity.Sales;
import com.lti.entity.User;
@Repository
public class SalesDaoImpl implements SalesDao {

	@PersistenceContext
	EntityManager em;

	public  List<SalesDto>  displaySales() {
		String jpql = "select s,l,p from Sales s join LoanDetails l on s.loanDetails.loanId=l.loanId join PersonalDetails p on s.personalDetails.applicantId=p.applicantId join Document d on p.applicantId=d.personalDetails.applicantId";
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		List<Object[]> allObjects = query.getResultList();
		List<SalesDto> foundSales = new ArrayList<>();
		SalesDto salesDto = null;
		for(Object[] obj: allObjects) {
			Sales s = (Sales)obj[0];
			LoanDetails l = (LoanDetails)obj[1];
			PersonalDetails p = (PersonalDetails)obj[2];
			Document d = (Document)obj[3];
			salesDto = new SalesDto();
			salesDto.setSalesId(s.getSalesId());
			salesDto.setLoanId(l.getLoanId());
			salesDto.setApplicantId(p.getApplicantId());
			salesDto.setDocumentId(d.getDocumentId());
			foundSales.add(salesDto);
		}
		return foundSales;
	}

}
