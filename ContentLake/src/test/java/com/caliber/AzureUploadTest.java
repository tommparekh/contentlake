package com.caliber;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;


@SpringBootTest
public class AzureUploadTest {

	@Value("${azure.storage.connection.string}")
	public static String CONNECTION_STRING;
	

	@Value("${azure.storage.container-name}")
	public static String CONTAINER_NAME;
	
	
	
	
	@Test
	public void testStorageLib() {
		
		System.out.println("Initiating Upload" + CONNECTION_STRING + CONTAINER_NAME);
		
		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(CONNECTION_STRING).
				buildClient();
		
	
		BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(CONTAINER_NAME);
		

		// Get a reference to a blob
		BlobClient blobClient = containerClient.getBlobClient("sample.txt"+java.util.UUID.randomUUID());
		

		System.out.println("\nUploading to Blob storage as blob:\n\t" + blobClient.getBlobUrl());

		// Upload the blob
		blobClient.uploadFromFile("/tmp/sample.txt");
		
	}
	

		
	
		
	
}
