package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.DocumentsDao;
import com.lti.entity.Document;

@Component
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocumentsDao documentDao;
	
	@Override
	public Document addorupdateDocumenets(Document document) {
		Document d1=documentDao.addorupdateDocumenets(document);
		return d1;
	}

	@Override
	public Document seacrchDocumentById(int documentId) {
		Document d1=documentDao.seacrchDocumentById(documentId);
		return d1;
	}

}
