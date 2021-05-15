package com.fileupload.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileRequest {
	
	private MultipartFile file;
	private String uploaderName;
	
	
	public FileRequest() {
		
	}
	
	
	public FileRequest(MultipartFile file, String uploaderName) {
		super();
		this.file = file;
		this.uploaderName = uploaderName;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getUploaderName() {
		return uploaderName;
	}
	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}
	
	

}
