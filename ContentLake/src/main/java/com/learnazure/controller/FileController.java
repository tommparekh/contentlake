package com.learnazure.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.azure.storage.blob.BlobClient;
import com.learnazure.AzureProperties;
import com.learnazure.model.TransformSource;
import com.learnazure.services.FileServices;

@RestController
@RequestMapping("/uploadFile")
public class FileController {

	@Autowired
	FileServices services;
	
	@Autowired
	AzureProperties properties;
	

	  @Autowired
	 private JmsTemplate jmsTemplate;

	@GetMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	@PostMapping("/")
	public String singleFileUpload(@RequestParam("file") MultipartFile file) {

		String uploadStatus = "Failure";
		
		BlobClient client ;
		

		

		try {

			client = services.uploadFileToBlob(file);
			
			
			TransformSource source = new TransformSource();
			
			source.setContentSource("CMS");
			
			source.setContentUrl(client.getBlobUrl());
			
			source.setContentName(client.getBlobName());
			
			jmsTemplate.convertAndSend(properties.getServiceBusQueueName(), source);
			
			System.out.println("Queue and file upload complete");
			
			uploadStatus = "Success";

		} catch (IOException e) {
			// Perform Exception Handling
		}

		return uploadStatus;
	}

}
