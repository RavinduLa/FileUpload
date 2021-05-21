package com.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.dao.FileRepository2;
import com.fileupload.model.FileModel2;

@Service
public class FileService {

	@Autowired
	private FileRepository2 fileRepo;
	
	public String addFile(String title, MultipartFile file  ) throws IOException{
		
		FileModel2 fileModel2 = new FileModel2();
		fileModel2.setTitle(title);
		fileModel2.setFile(

				new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		
		FileModel2 ret = fileRepo.insert(fileModel2);
		String id = ret.getId();
		return id;
	}
	
	public String getFile(String id) {
		
		String RETRIEVE_FOLDER = "C:\\Users\\Ravindu\\Downloads\\"; 
		String RETRIEVE_FOLDER2 = "C:\\D\\SLIIT\\Y3S1\\Software-Architecture\\Asssignment2\\"; 
		
		FileModel2 fileModel2 = new FileModel2();
		fileModel2 = fileRepo.findById(id).get();
		Binary document =  	fileModel2.getFile();
		
		if(document != null) {
			FileOutputStream fileOutputStream = null;
			
			try {
				//fileOutputStream = new FileOutputStream(RETRIEVE_FOLDER + "aaa.pdf");
				fileOutputStream = new FileOutputStream(RETRIEVE_FOLDER + "aaa.pdf");
				fileOutputStream.write(document.getData());
			} catch (Exception e) {
				
				System.out.println("Error in writing output stream");
				System.out.println("Error : " +e);
				
				return "failure";
			}finally {
				if(fileOutputStream != null) {
					try {
						fileOutputStream.close();
					}catch (Exception e) {
						System.out.println(" Finally Error: "+ e);
						return "failure";
					}
				}
			}
		}
		
		return "success";
	}
	
	public HttpEntity<byte[]> getFileAsHttp(String id) {
		FileModel2 fileModel2 = new FileModel2();
		fileModel2 = fileRepo.findById(id).get();
		Binary document =  	fileModel2.getFile();
		
		String fileName = "bbb";
		
		if(document != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			
			ContentDisposition contentDisposition = ContentDisposition.builder("inline")
					.filename(fileName).build();
			
			headers.setContentDisposition(contentDisposition);
			
			return new HttpEntity<byte[]>(document.getData(),headers);
			
		}
		else
		{
			System.out.println("Document is null when retreiveing from the database");
			return null;
		}
	}
}
