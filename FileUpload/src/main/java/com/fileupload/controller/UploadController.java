package com.fileupload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.dao.FileRepository;
import com.fileupload.model.FileModel;
import com.fileupload.model.FileRequest;
import com.fileupload.service.FileService;

@RestController
@CrossOrigin(origins ="*",allowedHeaders = "*",exposedHeaders = "*")
public class UploadController {
	
	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private FileService fileService;
	
	
	@PostMapping("/upload")
	public FileModel  handleFileUpload ( @RequestBody MultipartFile file){
		
		System.out.println("Running controller");
		
		FileModel fileModel = new FileModel();
		fileModel.setFile(file);
		fileModel.setUploaderName("aaa");
		fileModel.setId(1);
		
		FileModel returningFileModel =  fileRepository.save(fileModel);
		
		return returningFileModel;
		
	}
	
	@PostMapping("/upload2")
	public String uploadFile (@RequestParam("file") MultipartFile multipartFile ) {
		
		System.out.println("Running upload file 2");
		
		if(multipartFile == null) {
			System.out.println("Received file is null!");
		}
		else {
			System.out.println("Received file is not null");
		}
		
		try {
			String id = fileService.addFile("aaa", multipartFile);
			return id;
		} catch (IOException e) {
			System.out.println("Exception when adding file");
			return null;
		}
		
	}
	
	@PostMapping("/retrieve")
	public String retrieveFile( @RequestParam("id") String id) {
		String out = fileService.getFile(id);
		return out;
	}
	
	@PostMapping("/httpFileRetreive")
	public HttpEntity<byte[]> retrieveAsHttp (@RequestParam("id")  String id){
		return fileService.getFileAsHttp(id);
	}
	

}
