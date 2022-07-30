package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Document;

@Repository
public class DocumentsDaoImpl implements DocumentsDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Document addorupdateDocumenets(Document document) {
		Document documentsPersisted=em.merge(document);
		return documentsPersisted;
	}

	public Document seacrchDocumentById(int documentId) {
		return em.find(Document.class,documentId);
	}

}
