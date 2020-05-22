package com.learnazure.model;

import java.io.Serializable;

public class TransformSource implements Serializable{
	
	private String contentSource;
	
	private String contentUrl;
	
	private String contentName;

	public String getContentSource() {
		return contentSource;
	}

	public void setContentSource(String contentSource) {
		this.contentSource = contentSource;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	
	
	
	

}
