package com.stream.upload.repository;

import com.stream.upload.payload.FileResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileResponseRepository extends MongoRepository<FileResponse,String> {
}
