package com.fileupload.model;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fileModel")
public class FileModel2 {
	
	private String id;
	private String title;
	private Binary file;
	
	public FileModel2() {
		
	}
	public FileModel2(String id, String title, Binary file) {
		super();
		this.id = id;
		this.title = title;
		this.file = file;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Binary getFile() {
		return file;
	}
	public void setFile(Binary file) {
		this.file = file;
	} 
	
	
	
	

}
