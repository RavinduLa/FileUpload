package com.fileupload.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@Document(collation = "fileModel")
public class FileModel {
	
	@Id
	private int id;
	private MultipartFile file;
	private String uploaderName;
	
	
	public FileModel() {
		
	}
	
	public FileModel(int id, MultipartFile file, String uploaderName) {
		super();
		this.id = id;
		this.file = file;
		this.uploaderName = uploaderName;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
