package com.fileupload.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fileupload.model.FileModel2;

public interface FileRepository2  extends MongoRepository<FileModel2, String>{

}
