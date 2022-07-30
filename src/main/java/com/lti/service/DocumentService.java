package com.lti.service;

import com.lti.entity.Document;

public interface DocumentService {

	Document  addorupdateDocumenets (Document document);
	Document seacrchDocumentById(int documentId);
}
