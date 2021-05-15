package com.fileupload.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fileupload.model.FileModel;

public interface FileRepository extends MongoRepository<FileModel, Integer> {

}
