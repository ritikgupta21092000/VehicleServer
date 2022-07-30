package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Document;
import com.lti.service.DocumentService;

@RestController
@RequestMapping("/documents")
@CrossOrigin(origins = "http://localhost:4200")

public class DocumentController {

	@Autowired
	DocumentService documentService;
	//http://localhost:9090/documents/addDocument
	@RequestMapping(value = "/addDocument", method = RequestMethod.POST)
	@ResponseBody
	public Document addDocuments(@RequestBody Document document) {
		return documentService.addorupdateDocumenets(document);
	}
	//http://localhost:9090/documents/searchDocument/3001
	@RequestMapping(value = "/searchDocument/{documentId}")
	@ResponseBody
	public Document searchDocumnetById(@PathVariable int documentId) {
		return documentService.seacrchDocumentById(documentId);
	}
}
