package com.lti.dao;

import com.lti.entity.Document;

public interface DocumentsDao {

	Document  addorupdateDocumenets (Document document);
	Document seacrchDocumentById(int documentId);
}
