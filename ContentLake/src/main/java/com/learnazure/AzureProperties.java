package com.learnazure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("azure")
public class AzureProperties {
	
	@Value("servicebus.queue-name")
	private String serviceBusQueueName;

	public String getServiceBusQueueName() {
		return serviceBusQueueName;
	}

	public void setServiceBusQueueName(String serviceBusQueueName) {
		this.serviceBusQueueName = serviceBusQueueName;
	}
	
	

	



	
}
